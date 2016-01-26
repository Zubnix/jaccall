package com.github.zubnix.jaccall.compiletime.struct;


import com.google.testing.compile.CompileTester;
import com.google.testing.compile.JavaFileObjects;
import org.junit.Test;

import javax.tools.JavaFileObject;

import static com.google.common.truth.Truth.assert_;
import static com.google.testing.compile.JavaSourceSubjectFactory.javaSource;

public class StructWriterTest {

    @Test
    public void testCharField() {
        //given
        final JavaFileObject fileObject = JavaFileObjects.forSourceString("com.github.zubnix.libtest.struct.TestStructChar",
                                                                          "package com.github.zubnix.libtest.struct;\n" +
                                                                          "\n" +
                                                                          "import com.github.zubnix.jaccall.CType;\n" +
                                                                          "import com.github.zubnix.jaccall.Field;\n" +
                                                                          "import com.github.zubnix.jaccall.Struct;\n" +
                                                                          "\n" +
                                                                          "import static com.github.zubnix.jaccall.CType.CHAR;\n" +
                                                                          "\n" +
                                                                          "@Struct(value = {\n" +
                                                                          "             @Field(type = CHAR,\n" +
                                                                          "                    name = \"field0\")})\n" +
                                                                          "public final class TestStructChar extends TestStructChar_Jaccall_StructType{\n" +
                                                                          " \n" +
                                                                          "}");
        //when
        final CompileTester compileTester = assert_().about(javaSource())
                                                     .that(fileObject)
                                                     .processedWith(new StructGenerator());
        //then
        compileTester.compilesWithoutError()
                     .and()
                     .generatesSources(JavaFileObjects.forSourceString("com.github.zubnix.libtest.struct.TestStructChar_Jaccall_StructType",
                                                                       "package com.github.zubnix.libtest.struct;\n" +
                                                                       "\n" +
                                                                       "import com.github.zubnix.jaccall.JNI;\n" +
                                                                       "import com.github.zubnix.jaccall.StructType;\n" +
                                                                       "import javax.annotation.Generated;\n" +
                                                                       "\n" +
                                                                       "@Generated(\"com.github.zubnix.jaccall.compiletime.struct.StructGenerator\")\n" +
                                                                       "abstract class TestStructChar_Jaccall_StructType extends StructType {\n" +
                                                                       "  public static final long FFI_TYPE = JNI.ffi_type_struct(JNI.FFI_TYPE_SINT8);\n" +
                                                                       "\n" +
                                                                       "  public static final int SIZE = JNI.ffi_type_struct_size(FFI_TYPE);\n" +
                                                                       "\n" +
                                                                       "  private static final int OFFSET_0 = 0;\n" +
                                                                       "\n" +
                                                                       "  TestStruct_Jaccall_StructType() {\n" +
                                                                       "    super(SIZE);\n" +
                                                                       "  }\n" +
                                                                       "\n" +
                                                                       "  public final byte field0() {\n" +
                                                                       "    return readByte(OFFSET_0);\n" +
                                                                       "  }\n" +
                                                                       "\n" +
                                                                       "  public final void field0(final byte field0) {\n" +
                                                                       "    writeByte(OFFSET_0, field0);\n" +
                                                                       "  }\n" +
                                                                       "}"));
    }

    @Test
    public void testUnsignedCharField() {
        //given
        final JavaFileObject fileObject = JavaFileObjects.forSourceString("com.github.zubnix.libtest.struct.TestStructUnsignedChar",
                                                                          "package com.github.zubnix.libtest.struct;\n" +
                                                                          "\n" +
                                                                          "import com.github.zubnix.jaccall.CType;\n" +
                                                                          "import com.github.zubnix.jaccall.Field;\n" +
                                                                          "import com.github.zubnix.jaccall.Struct;\n" +
                                                                          "\n" +
                                                                          "import static com.github.zubnix.jaccall.CType.UNSIGNED_CHAR;\n" +
                                                                          "\n" +
                                                                          "@Struct(value = {\n" +
                                                                          "             @Field(type = UNSIGNED_CHAR,\n" +
                                                                          "                    name = \"field0\")})\n" +
                                                                          "public final class TestStructUnsignedChar extends TestStructUnsignedChar_Jaccall_StructType{\n" +
                                                                          " \n" +
                                                                          "}");
        //when
        final CompileTester compileTester = assert_().about(javaSource())
                                                     .that(fileObject)
                                                     .processedWith(new StructGenerator());
        //then
        compileTester.compilesWithoutError()
                     .and()
                     .generatesSources(JavaFileObjects.forSourceString("com.github.zubnix.libtest.struct.TestStructUnsignedChar_Jaccall_StructType",
                                                                       "package com.github.zubnix.libtest.struct;\n" +
                                                                       "\n" +
                                                                       "import com.github.zubnix.jaccall.JNI;\n" +
                                                                       "import com.github.zubnix.jaccall.StructType;\n" +
                                                                       "import javax.annotation.Generated;\n" +
                                                                       "\n" +
                                                                       "@Generated(\"com.github.zubnix.jaccall.compiletime.struct.StructGenerator\")\n" +
                                                                       "abstract class TestStructUnsignedChar_Jaccall_StructType extends StructType {\n" +
                                                                       "  public static final long FFI_TYPE = JNI.ffi_type_struct(JNI.FFI_TYPE_UINT8);\n" +
                                                                       "\n" +
                                                                       "  public static final int SIZE = JNI.ffi_type_struct_size(FFI_TYPE);\n" +
                                                                       "\n" +
                                                                       "  private static final int OFFSET_0 = 0;\n" +
                                                                       "\n" +
                                                                       "  TestStructUnsignedChar_Jaccall_StructType() {\n" +
                                                                       "    super(SIZE);\n" +
                                                                       "  }\n" +
                                                                       "\n" +
                                                                       "  public final byte field0() {\n" +
                                                                       "    return readByte(OFFSET_0);\n" +
                                                                       "  }\n" +
                                                                       "\n" +
                                                                       "  public final void field0(final byte field0) {\n" +
                                                                       "    writeByte(OFFSET_0, field0);\n" +
                                                                       "  }\n" +
                                                                       "}"));
    }

    @Test
    public void testShortField() {
        //given
        final JavaFileObject fileObject = JavaFileObjects.forSourceString("com.github.zubnix.libtest.struct.TestStructShort",
                                                                          "package com.github.zubnix.libtest.struct;\n" +
                                                                          "\n" +
                                                                          "import com.github.zubnix.jaccall.CType;\n" +
                                                                          "import com.github.zubnix.jaccall.Field;\n" +
                                                                          "import com.github.zubnix.jaccall.Struct;\n" +
                                                                          "\n" +
                                                                          "import static com.github.zubnix.jaccall.CType.SHORT;\n" +
                                                                          "\n" +
                                                                          "@Struct(value = {\n" +
                                                                          "             @Field(type = SHORT,\n" +
                                                                          "                    name = \"field0\")})\n" +
                                                                          "public final class TestStructShort extends TestStructShort_Jaccall_StructType{\n" +
                                                                          " \n" +
                                                                          "}");
        //when
        final CompileTester compileTester = assert_().about(javaSource())
                                                     .that(fileObject)
                                                     .processedWith(new StructGenerator());
        //then
        compileTester.compilesWithoutError()
                     .and()
                     .generatesSources(JavaFileObjects.forSourceString("com.github.zubnix.libtest.struct.TestStructShort_Jaccall_StructType",
                                                                       "package com.github.zubnix.libtest.struct;\n" +
                                                                       "\n" +
                                                                       "import com.github.zubnix.jaccall.JNI;\n" +
                                                                       "import com.github.zubnix.jaccall.StructType;\n" +
                                                                       "import javax.annotation.Generated;\n" +
                                                                       "\n" +
                                                                       "@Generated(\"com.github.zubnix.jaccall.compiletime.struct.StructGenerator\")\n" +
                                                                       "abstract class TestStructShort_Jaccall_StructType extends StructType {\n" +
                                                                       "  public static final long FFI_TYPE = JNI.ffi_type_struct(JNI.FFI_TYPE_SINT16);\n" +
                                                                       "\n" +
                                                                       "  public static final int SIZE = JNI.ffi_type_struct_size(FFI_TYPE);\n" +
                                                                       "\n" +
                                                                       "  private static final int OFFSET_0 = 0;\n" +
                                                                       "\n" +
                                                                       "  TestStructShort_Jaccall_StructType() {\n" +
                                                                       "    super(SIZE);\n" +
                                                                       "  }\n" +
                                                                       "\n" +
                                                                       "  public final short field0() {\n" +
                                                                       "    return readShort(OFFSET_0);\n" +
                                                                       "  }\n" +
                                                                       "\n" +
                                                                       "  public final void field0(final short field0) {\n" +
                                                                       "    writeShort(OFFSET_0, field0);\n" +
                                                                       "  }\n" +
                                                                       "}"));

    }

    @Test
    public void testUnsignedShortField() {
        //given
        final JavaFileObject fileObject = JavaFileObjects.forSourceString("com.github.zubnix.libtest.struct.TestStructUnsignedShort",
                                                                          "package com.github.zubnix.libtest.struct;\n" +
                                                                          "\n" +
                                                                          "import com.github.zubnix.jaccall.CType;\n" +
                                                                          "import com.github.zubnix.jaccall.Field;\n" +
                                                                          "import com.github.zubnix.jaccall.Struct;\n" +
                                                                          "\n" +
                                                                          "import static com.github.zubnix.jaccall.CType.UNSIGNED_SHORT;\n" +
                                                                          "\n" +
                                                                          "@Struct(value = {\n" +
                                                                          "             @Field(type = UNSIGNED_SHORT,\n" +
                                                                          "                    name = \"field0\")})\n" +
                                                                          "public final class TestStructUnsignedShort extends TestStructUnsignedShort_Jaccall_StructType{\n" +
                                                                          " \n" +
                                                                          "}");
        //when
        final CompileTester compileTester = assert_().about(javaSource())
                                                     .that(fileObject)
                                                     .processedWith(new StructGenerator());
        //then
        compileTester.compilesWithoutError()
                     .and()
                     .generatesSources(JavaFileObjects.forSourceString("com.github.zubnix.libtest.struct.TestStructUnsignedShort_Jaccall_StructType",
                                                                       "package com.github.zubnix.libtest.struct;\n" +
                                                                       "\n" +
                                                                       "import com.github.zubnix.jaccall.JNI;\n" +
                                                                       "import com.github.zubnix.jaccall.StructType;\n" +
                                                                       "import javax.annotation.Generated;\n" +
                                                                       "\n" +
                                                                       "@Generated(\"com.github.zubnix.jaccall.compiletime.struct.StructGenerator\")\n" +
                                                                       "abstract class TestStructUnsignedShort_Jaccall_StructType extends StructType {\n" +
                                                                       "  public static final long FFI_TYPE = JNI.ffi_type_struct(JNI.FFI_TYPE_UINT16);\n" +
                                                                       "\n" +
                                                                       "  public static final int SIZE = JNI.ffi_type_struct_size(FFI_TYPE);\n" +
                                                                       "\n" +
                                                                       "  private static final int OFFSET_0 = 0;\n" +
                                                                       "\n" +
                                                                       "  TestStructUnsignedShort_Jaccall_StructType() {\n" +
                                                                       "    super(SIZE);\n" +
                                                                       "  }\n" +
                                                                       "\n" +
                                                                       "  public final short field0() {\n" +
                                                                       "    return readShort(OFFSET_0);\n" +
                                                                       "  }\n" +
                                                                       "\n" +
                                                                       "  public final void field0(final short field0) {\n" +
                                                                       "    writeShort(OFFSET_0, field0);\n" +
                                                                       "  }\n" +
                                                                       "}"));

    }

    @Test
    public void testIntegerField() {
        //given
        final JavaFileObject fileObject = JavaFileObjects.forSourceString("com.github.zubnix.libtest.struct.TestStructInteger",
                                                                          "package com.github.zubnix.libtest.struct;\n" +
                                                                          "\n" +
                                                                          "import com.github.zubnix.jaccall.CType;\n" +
                                                                          "import com.github.zubnix.jaccall.Field;\n" +
                                                                          "import com.github.zubnix.jaccall.Struct;\n" +
                                                                          "\n" +
                                                                          "import static com.github.zubnix.jaccall.CType.INT;\n" +
                                                                          "\n" +
                                                                          "@Struct(value = {\n" +
                                                                          "             @Field(type = INT,\n" +
                                                                          "                    name = \"field0\")})\n" +
                                                                          "public final class TestStructInteger extends TestStructInteger_Jaccall_StructType{\n" +
                                                                          " \n" +
                                                                          "}");
        //when
        final CompileTester compileTester = assert_().about(javaSource())
                                                     .that(fileObject)
                                                     .processedWith(new StructGenerator());
        //then
        compileTester.compilesWithoutError()
                     .and()
                     .generatesSources(JavaFileObjects.forSourceString("com.github.zubnix.libtest.struct.TestStructInteger_Jaccall_StructType",
                                                                       "package com.github.zubnix.libtest.struct;\n" +
                                                                       "\n" +
                                                                       "import com.github.zubnix.jaccall.JNI;\n" +
                                                                       "import com.github.zubnix.jaccall.StructType;\n" +
                                                                       "import javax.annotation.Generated;\n" +
                                                                       "\n" +
                                                                       "@Generated(\"com.github.zubnix.jaccall.compiletime.struct.StructGenerator\")\n" +
                                                                       "abstract class TestStructInteger_Jaccall_StructType extends StructType {\n" +
                                                                       "  public static final long FFI_TYPE = JNI.ffi_type_struct(JNI.FFI_TYPE_SINT32);\n" +
                                                                       "\n" +
                                                                       "  public static final int SIZE = JNI.ffi_type_struct_size(FFI_TYPE);\n" +
                                                                       "\n" +
                                                                       "  private static final int OFFSET_0 = 0;\n" +
                                                                       "\n" +
                                                                       "  TestStructInteger_Jaccall_StructType() {\n" +
                                                                       "    super(SIZE);\n" +
                                                                       "  }\n" +
                                                                       "\n" +
                                                                       "  public final int field0() {\n" +
                                                                       "    return readInteger(OFFSET_0);\n" +
                                                                       "  }\n" +
                                                                       "\n" +
                                                                       "  public final void field0(final int field0) {\n" +
                                                                       "    writeInteger(OFFSET_0, field0);\n" +
                                                                       "  }\n" +
                                                                       "}"));

    }

    @Test
    public void testUnsignedIntegerField() {
        //given
        final JavaFileObject fileObject = JavaFileObjects.forSourceString("com.github.zubnix.libtest.struct.TestStructUnsignedInteger",
                                                                          "package com.github.zubnix.libtest.struct;\n" +
                                                                          "\n" +
                                                                          "import com.github.zubnix.jaccall.CType;\n" +
                                                                          "import com.github.zubnix.jaccall.Field;\n" +
                                                                          "import com.github.zubnix.jaccall.Struct;\n" +
                                                                          "\n" +
                                                                          "import static com.github.zubnix.jaccall.CType.UNSIGNED_INT;\n" +
                                                                          "\n" +
                                                                          "@Struct(value = {\n" +
                                                                          "             @Field(type = UNSIGNED_INT,\n" +
                                                                          "                    name = \"field0\")})\n" +
                                                                          "public final class TestStructUnsignedInteger extends TestStructUnsignedInteger_Jaccall_StructType{\n" +
                                                                          " \n" +
                                                                          "}");
        //when
        final CompileTester compileTester = assert_().about(javaSource())
                                                     .that(fileObject)
                                                     .processedWith(new StructGenerator());
        //then
        compileTester.compilesWithoutError()
                     .and()
                     .generatesSources(JavaFileObjects.forSourceString("com.github.zubnix.libtest.struct.TestStructUnsignedInteger_Jaccall_StructType",
                                                                       "package com.github.zubnix.libtest.struct;\n" +
                                                                       "\n" +
                                                                       "import com.github.zubnix.jaccall.JNI;\n" +
                                                                       "import com.github.zubnix.jaccall.StructType;\n" +
                                                                       "import javax.annotation.Generated;\n" +
                                                                       "\n" +
                                                                       "@Generated(\"com.github.zubnix.jaccall.compiletime.struct.StructGenerator\")\n" +
                                                                       "abstract class TestStructUnsignedInteger_Jaccall_StructType extends StructType {\n" +
                                                                       "  public static final long FFI_TYPE = JNI.ffi_type_struct(JNI.FFI_TYPE_UINT32);\n" +
                                                                       "\n" +
                                                                       "  public static final int SIZE = JNI.ffi_type_struct_size(FFI_TYPE);\n" +
                                                                       "\n" +
                                                                       "  private static final int OFFSET_0 = 0;\n" +
                                                                       "\n" +
                                                                       "  TestStructUnsignedInteger_Jaccall_StructType() {\n" +
                                                                       "    super(SIZE);\n" +
                                                                       "  }\n" +
                                                                       "\n" +
                                                                       "  public final int field0() {\n" +
                                                                       "    return readInteger(OFFSET_0);\n" +
                                                                       "  }\n" +
                                                                       "\n" +
                                                                       "  public final void field0(final int field0) {\n" +
                                                                       "    writeInteger(OFFSET_0, field0);\n" +
                                                                       "  }\n" +
                                                                       "}"));
    }

    @Test
    public void testLongField() {
        //given
        final JavaFileObject fileObject = JavaFileObjects.forSourceString("com.github.zubnix.libtest.struct.TestStructLong",
                                                                          "package com.github.zubnix.libtest.struct;\n" +
                                                                          "\n" +
                                                                          "import com.github.zubnix.jaccall.CType;\n" +
                                                                          "import com.github.zubnix.jaccall.Field;\n" +
                                                                          "import com.github.zubnix.jaccall.Struct;\n" +
                                                                          "\n" +
                                                                          "import static com.github.zubnix.jaccall.CType.LONG;\n" +
                                                                          "\n" +
                                                                          "@Struct(value = {\n" +
                                                                          "             @Field(type = LONG,\n" +
                                                                          "                    name = \"field0\")})\n" +
                                                                          "public final class TestStructLong extends TestStructLong_Jaccall_StructType{\n" +
                                                                          " \n" +
                                                                          "}");
        //when
        final CompileTester compileTester = assert_().about(javaSource())
                                                     .that(fileObject)
                                                     .processedWith(new StructGenerator());
        //then
        compileTester.compilesWithoutError()
                     .and()
                     .generatesSources(JavaFileObjects.forSourceString("com.github.zubnix.libtest.struct.TestStructLong_Jaccall_StructType",
                                                                       "package com.github.zubnix.libtest.struct;\n" +
                                                                       "\n" +
                                                                       "import com.github.zubnix.jaccall.CLong;\n" +
                                                                       "import com.github.zubnix.jaccall.JNI;\n" +
                                                                       "import com.github.zubnix.jaccall.StructType;\n" +
                                                                       "import javax.annotation.Generated;\n" +
                                                                       "\n" +
                                                                       "@Generated(\"com.github.zubnix.jaccall.compiletime.struct.StructGenerator\")\n" +
                                                                       "abstract class TestStructLong_Jaccall_StructType extends StructType {\n" +
                                                                       "  public static final long FFI_TYPE = JNI.ffi_type_struct(JNI.FFI_TYPE_SLONG);\n" +
                                                                       "\n" +
                                                                       "  public static final int SIZE = JNI.ffi_type_struct_size(FFI_TYPE);\n" +
                                                                       "\n" +
                                                                       "  private static final int OFFSET_0 = 0;\n" +
                                                                       "\n" +
                                                                       "  TestStructLong_Jaccall_StructType() {\n" +
                                                                       "    super(SIZE);\n" +
                                                                       "  }\n" +
                                                                       "\n" +
                                                                       "  public final CLong field0() {\n" +
                                                                       "    return readCLong(OFFSET_0);\n" +
                                                                       "  }\n" +
                                                                       "\n" +
                                                                       "  public final void field0(final CLong field0) {\n" +
                                                                       "    writeCLong(OFFSET_0, field0);\n" +
                                                                       "  }\n" +
                                                                       "}"));
    }

    @Test
    public void testUnsignedLongField() {
        //TODO

    }

    @Test
    public void testLongLongField() {
        //TODO

    }

    @Test
    public void testUnsignedLongLongField() {
        //TODO

    }

    @Test
    public void testFloatField() {
        //TODO

    }

    @Test
    public void testDoubleField() {
        //TODO

    }

    @Test
    public void testPointerField() {
        //given
        final JavaFileObject fileObject = JavaFileObjects.forSourceString("com.github.zubnix.libtest.struct.TestStructPointer",
                                                                          "package com.github.zubnix.libtest.struct;\n" +
                                                                          "\n" +
                                                                          "import com.github.zubnix.jaccall.CType;\n" +
                                                                          "import com.github.zubnix.jaccall.Field;\n" +
                                                                          "import com.github.zubnix.jaccall.Struct;\n" +
                                                                          "\n" +
                                                                          "import static com.github.zubnix.jaccall.CType.POINTER;\n" +
                                                                          "\n" +
                                                                          "@Struct(value = {\n" +
                                                                          "             @Field(type = POINTER,\n" +
                                                                          "                    name = \"field0\")})\n" +
                                                                          "public final class TestStructPointer extends TestStructPointer_Jaccall_StructType{\n" +
                                                                          " \n" +
                                                                          "}");
        //when
        final CompileTester compileTester = assert_().about(javaSource())
                                                     .that(fileObject)
                                                     .processedWith(new StructGenerator());
        //then
        compileTester.compilesWithoutError()
                     .and()
                     .generatesSources(JavaFileObjects.forSourceString("com.github.zubnix.libtest.struct.TestStructPointer_Jaccall_StructType",
                                                                       "package com.github.zubnix.libtest.struct;\n" +
                                                                       "\n" +
                                                                       "import com.github.zubnix.jaccall.JNI;\n" +
                                                                       "import com.github.zubnix.jaccall.Pointer;\n" +
                                                                       "import com.github.zubnix.jaccall.StructType;\n" +
                                                                       "import java.lang.Void;\n" +
                                                                       "import javax.annotation.Generated;\n" +
                                                                       "\n" +
                                                                       "@Generated(\"com.github.zubnix.jaccall.compiletime.struct.StructGenerator\")\n" +
                                                                       "abstract class TestStructPointer_Jaccall_StructType extends StructType {\n" +
                                                                       "  public static final long FFI_TYPE = JNI.ffi_type_struct(JNI.FFI_TYPE_POINTER);\n" +
                                                                       "\n" +
                                                                       "  public static final int SIZE = JNI.ffi_type_struct_size(FFI_TYPE);\n" +
                                                                       "\n" +
                                                                       "  private static final int OFFSET_0 = 0;\n" +
                                                                       "\n" +
                                                                       "  TestStructPointer_Jaccall_StructType() {\n" +
                                                                       "    super(SIZE);\n" +
                                                                       "  }\n" +
                                                                       "\n" +
                                                                       "  public final Pointer<Void> field0() {\n" +
                                                                       "    return readPointer(OFFSET_0, Void.class);\n" +
                                                                       "  }\n" +
                                                                       "\n" +
                                                                       "  public final void field0(final Pointer<Void> field0) {\n" +
                                                                       "    writePointer(OFFSET_0, field0);\n" +
                                                                       "  }\n" +
                                                                       "}"));

    }

    @Test
    public void testPointerToPointerToPointerField() {
        //given
        final JavaFileObject fileObject = JavaFileObjects.forSourceString("com.github.zubnix.libtest.struct.TestStructPointer",
                                                                          "package com.github.zubnix.libtest.struct;\n" +
                                                                          "\n" +
                                                                          "import com.github.zubnix.jaccall.CType;\n" +
                                                                          "import com.github.zubnix.jaccall.Field;\n" +
                                                                          "import com.github.zubnix.jaccall.Struct;\n" +
                                                                          "\n" +
                                                                          "import static com.github.zubnix.jaccall.CType.POINTER;\n" +
                                                                          "\n" +
                                                                          "@Struct(value = {\n" +
                                                                          "             @Field(type = POINTER,\n" +
                                                                          "                    pointerDepth = 2,\n" +
                                                                          "                    name = \"field0\")})\n" +
                                                                          "public final class TestStructPointer extends TestStructPointer_Jaccall_StructType{\n" +
                                                                          " \n" +
                                                                          "}");
        //when
        final CompileTester compileTester = assert_().about(javaSource())
                                                     .that(fileObject)
                                                     .processedWith(new StructGenerator());
        //then
        compileTester.compilesWithoutError()
                     .and()
                     .generatesSources(JavaFileObjects.forSourceString("com.github.zubnix.libtest.struct.TestStructPointer_Jaccall_StructType",
                                                                       "package com.github.zubnix.libtest.struct;\n" +
                                                                       "\n" +
                                                                       "import com.github.zubnix.jaccall.JNI;\n" +
                                                                       "import com.github.zubnix.jaccall.Pointer;\n" +
                                                                       "import com.github.zubnix.jaccall.StructType;\n" +
                                                                       "import java.lang.Void;\n" +
                                                                       "import javax.annotation.Generated;\n" +
                                                                       "\n" +
                                                                       "@Generated(\"com.github.zubnix.jaccall.compiletime.struct.StructGenerator\")\n" +
                                                                       "abstract class TestStructPointer_Jaccall_StructType extends StructType {\n" +
                                                                       "  public static final long FFI_TYPE = JNI.ffi_type_struct(JNI.FFI_TYPE_POINTER);\n" +
                                                                       "\n" +
                                                                       "  public static final int SIZE = JNI.ffi_type_struct_size(FFI_TYPE);\n" +
                                                                       "\n" +
                                                                       "  private static final int OFFSET_0 = 0;\n" +
                                                                       "\n" +
                                                                       "  TestStructPointer_Jaccall_StructType() {\n" +
                                                                       "    super(SIZE);\n" +
                                                                       "  }\n" +
                                                                       "\n" +
                                                                       "  public final Pointer<Pointer<Pointer<Void>>> field0() {\n" +
                                                                       "    return readPointer(OFFSET_0, Void.class).castpp().castpp();\n" +
                                                                       "  }\n" +
                                                                       "\n" +
                                                                       "  public final void field0(final Pointer<Pointer<Pointer<Void>>> field0) {\n" +
                                                                       "    writePointer(OFFSET_0, field0);\n" +
                                                                       "  }\n" +
                                                                       "}"));

    }

    @Test
    public void testStructField() {
        //TODO

    }

    @Test
    public void testMixed() {
        //given
        final JavaFileObject fileObject = JavaFileObjects.forSourceString("com.github.zubnix.libtest.struct.FieldsTestStruct",
                                                                          "package com.github.zubnix.libtest.struct;\n" +
                                                                          "import com.github.zubnix.jaccall.CType;\n" +
                                                                          "import com.github.zubnix.jaccall.Field;\n" +
                                                                          "import com.github.zubnix.jaccall.Struct;\n" +
                                                                          "import com.github.zubnix.jaccall.compiletime.linker.TestStructEmbedded;\n" +
                                                                          "        @Struct({\n" +
                                                                          "                        @Field(name = \"charField\",\n" +
                                                                          "                               type = CType.CHAR),\n" +
                                                                          "                        @Field(name = \"shortField\",\n" +
                                                                          "                               type = CType.SHORT),\n" +
                                                                          "                        @Field(name = \"intField\",\n" +
                                                                          "                               type = CType.INT),\n" +
                                                                          "                        @Field(name = \"longField\",\n" +
                                                                          "                               type = CType.LONG),\n" +
                                                                          "                        @Field(name = \"longLongField\",\n" +
                                                                          "                               type = CType.LONG_LONG),\n" +
                                                                          "                        @Field(name = \"floatField\",\n" +
                                                                          "                               type = CType.FLOAT),\n" +
                                                                          "                        @Field(name = \"doubleField\",\n" +
                                                                          "                               type = CType.DOUBLE),\n" +
                                                                          "                        @Field(name = \"pointerField\",\n" +
                                                                          "                               type = CType.POINTER,\n" +
                                                                          "                               dataType = Void.class),\n" +
                                                                          "                        @Field(name = \"pointerArrayField\",\n" +
                                                                          "                               type = CType.POINTER,\n" +
                                                                          "                               dataType = Void.class,\n" +
                                                                          "                               cardinality = 3),\n" +
                                                                          "                        @Field(name = \"structField\",\n" +
                                                                          "                               type = CType.STRUCT,\n" +
                                                                          "                               dataType = TestStructEmbedded.class),\n" +
                                                                          "                        @Field(name = \"structArrayField\",\n" +
                                                                          "                               type = CType.STRUCT,\n" +
                                                                          "                               dataType = TestStructEmbedded.class,\n" +
                                                                          "                               cardinality = 3),\n" +
                                                                          "                })\n" +
                                                                          "        public final class FieldsTestStruct extends FieldsTestStruct_Jaccall_StructType {\n" +
                                                                          "        }");
        //when
        final CompileTester compileTester = assert_().about(javaSource())
                                                     .that(fileObject)
                                                     .processedWith(new StructGenerator());
        //then
        //then
        compileTester.compilesWithoutError()
                     .and()
                     .generatesSources(JavaFileObjects.forSourceString("com.github.zubnix.libtest.struct.FieldsTestStruct_Jaccall_StructType",
                                                                       "package com.github.zubnix.libtest.struct;\n" +
                                                                       "\n" +
                                                                       "import com.github.zubnix.jaccall.CLong;\n" +
                                                                       "import com.github.zubnix.jaccall.JNI;\n" +
                                                                       "import com.github.zubnix.jaccall.Pointer;\n" +
                                                                       "import com.github.zubnix.jaccall.Size;\n" +
                                                                       "import com.github.zubnix.jaccall.StructType;\n" +
                                                                       "import com.github.zubnix.jaccall.compiletime.linker.TestStructEmbedded;\n" +
                                                                       "import java.lang.Byte;\n" +
                                                                       "import java.lang.Double;\n" +
                                                                       "import java.lang.Float;\n" +
                                                                       "import java.lang.Integer;\n" +
                                                                       "import java.lang.Long;\n" +
                                                                       "import java.lang.Short;\n" +
                                                                       "import java.lang.Void;\n" +
                                                                       "import javax.annotation.Generated;\n" +
                                                                       "\n" +
                                                                       "@Generated(\"com.github.zubnix.jaccall.compiletime.struct.StructGenerator\")\n" +
                                                                       "abstract class FieldsTestStruct_Jaccall_StructType extends StructType {\n" +
                                                                       "  public static final long FFI_TYPE = JNI.ffi_type_struct(JNI.FFI_TYPE_SINT8, JNI.FFI_TYPE_SINT16, JNI.FFI_TYPE_SINT32, JNI.FFI_TYPE_SLONG, JNI.FFI_TYPE_SINT64, JNI.FFI_TYPE_FLOAT, JNI.FFI_TYPE_DOUBLE, JNI.FFI_TYPE_POINTER, JNI.FFI_TYPE_POINTER, TestStructEmbedded.FFI_TYPE, TestStructEmbedded.FFI_TYPE);\n" +
                                                                       "\n" +
                                                                       "  public static final int SIZE = JNI.ffi_type_struct_size(FFI_TYPE);\n" +
                                                                       "\n" +
                                                                       "  private static final int OFFSET_0 = 0;\n" +
                                                                       "\n" +
                                                                       "  private static final int OFFSET_1 = newOffset(Size.sizeof((Short) null), OFFSET_0 + (Size.sizeof((Byte) null) * 1));\n" +
                                                                       "\n" +
                                                                       "  private static final int OFFSET_2 = newOffset(Size.sizeof((Integer) null), OFFSET_1 + (Size.sizeof((Short) null) * 1));\n" +
                                                                       "\n" +
                                                                       "  private static final int OFFSET_3 = newOffset(Size.sizeof((CLong) null), OFFSET_2 + (Size.sizeof((Integer) null) * 1));\n" +
                                                                       "\n" +
                                                                       "  private static final int OFFSET_4 = newOffset(Size.sizeof((Long) null), OFFSET_3 + (Size.sizeof((CLong) null) * 1));\n" +
                                                                       "\n" +
                                                                       "  private static final int OFFSET_5 = newOffset(Size.sizeof((Float) null), OFFSET_4 + (Size.sizeof((Long) null) * 1));\n" +
                                                                       "\n" +
                                                                       "  private static final int OFFSET_6 = newOffset(Size.sizeof((Double) null), OFFSET_5 + (Size.sizeof((Float) null) * 1));\n" +
                                                                       "\n" +
                                                                       "  private static final int OFFSET_7 = newOffset(Size.sizeof((Pointer) null), OFFSET_6 + (Size.sizeof((Double) null) * 1));\n" +
                                                                       "\n" +
                                                                       "  private static final int OFFSET_8 = newOffset(Size.sizeof((Pointer) null), OFFSET_7 + (Size.sizeof((Pointer) null) * 1));\n" +
                                                                       "\n" +
                                                                       "  private static final int OFFSET_9 = newOffset((Size.sizeof((Long) null)), OFFSET_8 + (Size.sizeof((Pointer) null) * 3));\n" +
                                                                       "\n" +
                                                                       "  private static final int OFFSET_10 = newOffset((Size.sizeof((Long) null)), OFFSET_9 + (TestStructEmbedded.SIZE * 1));\n" +
                                                                       "\n" +
                                                                       "  FieldsTestStruct_Jaccall_StructType() {\n" +
                                                                       "    super(SIZE);\n" +
                                                                       "  }\n" +
                                                                       "\n" +
                                                                       "  public final byte charField() {\n" +
                                                                       "    return readByte(OFFSET_0);\n" +
                                                                       "  }\n" +
                                                                       "\n" +
                                                                       "  public final void charField(final byte charField) {\n" +
                                                                       "    writeByte(OFFSET_0, charField);\n" +
                                                                       "  }\n" +
                                                                       "\n" +
                                                                       "  public final short shortField() {\n" +
                                                                       "    return readShort(OFFSET_1);\n" +
                                                                       "  }\n" +
                                                                       "\n" +
                                                                       "  public final void shortField(final short shortField) {\n" +
                                                                       "    writeShort(OFFSET_1, shortField);\n" +
                                                                       "  }\n" +
                                                                       "\n" +
                                                                       "  public final int intField() {\n" +
                                                                       "    return readInteger(OFFSET_2);\n" +
                                                                       "  }\n" +
                                                                       "\n" +
                                                                       "  public final void intField(final int intField) {\n" +
                                                                       "    writeInteger(OFFSET_2, intField);\n" +
                                                                       "  }\n" +
                                                                       "\n" +
                                                                       "  public final CLong longField() {\n" +
                                                                       "    return readCLong(OFFSET_3);\n" +
                                                                       "  }\n" +
                                                                       "\n" +
                                                                       "  public final void longField(final CLong longField) {\n" +
                                                                       "    writeCLong(OFFSET_3, longField);\n" +
                                                                       "  }\n" +
                                                                       "\n" +
                                                                       "  public final long longLongField() {\n" +
                                                                       "    return readLong(OFFSET_4);\n" +
                                                                       "  }\n" +
                                                                       "\n" +
                                                                       "  public final void longLongField(final long longLongField) {\n" +
                                                                       "    writeLong(OFFSET_4, longLongField);\n" +
                                                                       "  }\n" +
                                                                       "\n" +
                                                                       "  public final float floatField() {\n" +
                                                                       "    return readFloat(OFFSET_5);\n" +
                                                                       "  }\n" +
                                                                       "\n" +
                                                                       "  public final void floatField(final float floatField) {\n" +
                                                                       "    writeFloat(OFFSET_5, floatField);\n" +
                                                                       "  }\n" +
                                                                       "\n" +
                                                                       "  public final double doubleField() {\n" +
                                                                       "    return readDouble(OFFSET_6);\n" +
                                                                       "  }\n" +
                                                                       "\n" +
                                                                       "  public final void doubleField(final double doubleField) {\n" +
                                                                       "    writeDouble(OFFSET_6, doubleField);\n" +
                                                                       "  }\n" +
                                                                       "\n" +
                                                                       "  public final Pointer<Void> pointerField() {\n" +
                                                                       "    return readPointer(OFFSET_7, Void.class);\n" +
                                                                       "  }\n" +
                                                                       "\n" +
                                                                       "  public final void pointerField(final Pointer<Void> pointerField) {\n" +
                                                                       "    writePointer(OFFSET_7, pointerField);\n" +
                                                                       "  }\n" +
                                                                       "\n" +
                                                                       "  public final Pointer<Pointer<Void>> pointerArrayField() {\n" +
                                                                       "    return readArray(OFFSET_8, Void.class).castpp();\n" +
                                                                       "  }\n" +
                                                                       "\n" +
                                                                       "  public final TestStructEmbedded structField() {\n" +
                                                                       "    return readStructType(OFFSET_9, TestStructEmbedded.class);\n" +
                                                                       "  }\n" +
                                                                       "\n" +
                                                                       "  public final void structField(final TestStructEmbedded structField) {\n" +
                                                                       "    writeStructType(OFFSET_9, structField);\n" +
                                                                       "  }\n" +
                                                                       "\n" +
                                                                       "  public final Pointer<TestStructEmbedded> structArrayField() {\n" +
                                                                       "    return readArray(OFFSET_10, TestStructEmbedded.class);\n" +
                                                                       "  }\n" +
                                                                       "}"));
    }
}