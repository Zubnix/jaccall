package com.github.zubnix.libtest;


import com.github.zubnix.jaccall.JNI;
import com.github.zubnix.jaccall.PointerFunc;

import javax.annotation.Generated;
import javax.annotation.Nonnull;

@Generated("com.github.zubnix.jaccall.compiletime.functor.FunctionPointerGenerator")
public abstract class PointerShortFunc extends PointerFunc<PointerShortFunc> implements ShortFunc {

    static final long FFI_CIF = JNI.ffi_callInterface(JNI.FFI_TYPE_SINT16,
                                                      JNI.FFI_TYPE_SINT16);

    PointerShortFunc(final long address) {
        super(PointerShortFunc.class,
              address);
    }

    @Nonnull
    public static PointerShortFunc nref(@Nonnull final ShortFunc function) {
        if (function instanceof PointerShortFunc) {
            return (PointerShortFunc) function;
        }
        return new ShortFunc_Jaccall_J(function);
    }
}
