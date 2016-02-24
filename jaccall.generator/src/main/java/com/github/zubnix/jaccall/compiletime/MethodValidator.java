package com.github.zubnix.jaccall.compiletime;


import com.github.zubnix.jaccall.ByVal;
import com.github.zubnix.jaccall.Lng;
import com.github.zubnix.jaccall.Ptr;
import com.github.zubnix.jaccall.Unsigned;

import javax.annotation.processing.Messager;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.tools.Diagnostic;

public class MethodValidator {

    private final Messager messager;

    public MethodValidator(final Messager messager) {
        this.messager = messager;
    }

    public void validate(final ExecutableElement executableElement) {
        for (final VariableElement variableElement : executableElement.getParameters()) {
            isAllowedElement(variableElement,
                             variableElement.asType()
                                            .getKind());
            hasAllowedAnnotations(variableElement.asType(),
                                  variableElement);
        }

        isAllowedElement(executableElement,
                         executableElement.getReturnType()
                                          .getKind());
        hasAllowedAnnotations(executableElement.getReturnType(),
                              executableElement);
    }

    public void validateIfNative(final ExecutableElement executableElement) {
        if (executableElement.getModifiers()
                             .contains(Modifier.NATIVE)) {
            validate(executableElement);
        }
    }

    private void hasAllowedAnnotations(final TypeMirror type,
                                       final Element element) {
        //only type 'long' can have @Ptr annotation
        hasWellPlacedPtr(type,
                         element);
        //only type 'long' can have ByVal annotation, and can not be used in conjunction with @Ptr or @Unsigned
        hasWellPlacedByVal(type,
                           element);
        //only type 'long' can have @Lng annotation
        hasWellPlacedLng(type,
                         element);
        //float, double and 'long' annotated with @ByVal or @Ptr can not have @Unsigned annotation
        hasWellPlacedUnsigned(type,
                              element);
    }

    private void hasWellPlacedUnsigned(final TypeMirror typeMirror,
                                       final Element element) {
        if (element.getAnnotation(Unsigned.class) != null) {
            isNotTypeKind(element,
                          typeMirror,
                          TypeKind.FLOAT,
                          "@Unsigned annotation can not be placed on primitive type 'float'.");

            isNotTypeKind(element,
                          typeMirror,
                          TypeKind.DOUBLE,
                          "@Unsigned annotation can not be placed on primitive type 'double'.");

            isNotPtr(element,
                     "@Unsigned annotation can not be placed in conjunction with @Ptr annotation.");
        }
    }

    private void isNotTypeKind(final Element element,
                               final TypeMirror typeMirror,
                               final TypeKind aDouble,
                               final String charSequence) {
        if (typeMirror.getKind()
                      .equals(aDouble)) {
            this.messager.printMessage(Diagnostic.Kind.ERROR,
                                       charSequence,
                                       element);
        }
    }

    private void hasWellPlacedLng(final TypeMirror typeMirror,
                                  final Element element) {
        if (element.getAnnotation(Lng.class) != null) {
            isLong(element,
                   typeMirror,
                   "@Lng annotation can only be placed on primitive type 'long'.");
            isNotPtr(element,
                     "@Lng annotation can not be placed in conjunction with @Ptr annotation.");

            isNotByVal(element,
                       "@Lng annotation can not be placed in conjunction with @ByVal annotation.");
        }
    }

    private void isNotByVal(final Element element,
                            final String charSequence) {
        if (element.getAnnotation(ByVal.class) != null) {
            this.messager.printMessage(Diagnostic.Kind.ERROR,
                                       charSequence,
                                       element);
        }
    }

    private void hasWellPlacedByVal(final TypeMirror typeMirror,
                                    final Element element) {
        if (element.getAnnotation(ByVal.class) != null) {
            isLong(element,
                   typeMirror,
                   "@ByVal annotation can only be placed on primitive type 'long'.");
            isNotPtr(element,
                     "@ByVal annotation can not be placed in conjunction with @Ptr annotation.");
            isNotUnsigned(element);
        }
    }

    private void isNotUnsigned(final Element element) {
        if (element.getAnnotation(Unsigned.class) != null) {
            this.messager.printMessage(Diagnostic.Kind.ERROR,
                                       "@ByVal annotation can not be placed in conjunction with @Unsigned annotation.",
                                       element);
        }
    }

    private void isNotPtr(final Element element,
                          final String charSequence) {
        if (element.getAnnotation(Ptr.class) != null) {
            this.messager.printMessage(Diagnostic.Kind.ERROR,
                                       charSequence,
                                       element);
        }
    }

    private void hasWellPlacedPtr(final TypeMirror typeMirror,
                                  final Element element) {
        if (element.getAnnotation(Ptr.class) != null) {
            isLong(element,
                   typeMirror,
                   "@Ptr annotation can only be placed on primitive type 'long'.");
        }
    }

    private void isLong(final Element element,
                        final TypeMirror typeMirror,
                        final String charSequence) {
        if (!typeMirror.getKind()
                       .equals(TypeKind.LONG)) {
            this.messager.printMessage(Diagnostic.Kind.ERROR,
                                       charSequence,
                                       element);
        }
    }

    private void isAllowedElement(final Element element,
                                  final TypeKind kind) {
        //only primitive parameter and return types are allowed
        isPrimitive(element,
                    kind);
        //'boolean' and 'char' primitives are not allowed
        isAllowedPrimitive(element,
                           kind);
    }

    private void isPrimitive(final Element element,
                             final TypeKind kind) {
        if (!kind.isPrimitive() && !kind.equals(TypeKind.VOID)) {
            this.messager.printMessage(Diagnostic.Kind.ERROR,
                                       "Method should have supported primitive types only.",
                                       element);
        }
    }

    private void isAllowedPrimitive(final Element element,
                                    final TypeKind kind) {
        if (kind.equals(TypeKind.BOOLEAN)) {
            this.messager.printMessage(Diagnostic.Kind.ERROR,
                                       "Method should not have a primitive type 'boolean'.",
                                       element);
        }

        if (kind.equals(TypeKind.CHAR)) {
            this.messager.printMessage(Diagnostic.Kind.ERROR,
                                       "Method should not have a primitive type 'char'.",
                                       element);
        }
    }

    public void validateGlobalVar(final ExecutableElement executableElement) {

        if (!executableElement.getParameters()
                              .isEmpty()) {
            this.messager.printMessage(Diagnostic.Kind.ERROR,
                                       "Global variable method should not have arguments.",
                                       executableElement);
        }

        if (!executableElement.getModifiers()
                              .contains(Modifier.NATIVE)) {
            this.messager.printMessage(Diagnostic.Kind.ERROR,
                                       "Global variable method should be native.",
                                       executableElement);
        }

        isAllowedElement(executableElement,
                         executableElement.getReturnType()
                                          .getKind());
        hasAllowedAnnotations(executableElement.getReturnType(),
                              executableElement);
    }
}
