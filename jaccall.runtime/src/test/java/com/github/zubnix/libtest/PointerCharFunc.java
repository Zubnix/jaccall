package com.github.zubnix.libtest;


import com.github.zubnix.jaccall.JNI;
import com.github.zubnix.jaccall.Pointer;
import com.github.zubnix.jaccall.PointerFunc;

import javax.annotation.Generated;
import javax.annotation.Nonnull;

@Generated("com.github.zubnix.jaccall.compiletime.functor.FunctionPointerGenerator")
public abstract class PointerCharFunc extends PointerFunc<CharFunc> implements CharFunc {

    static final long FFI_CIF = JNI.ffi_callInterface(JNI.FFI_TYPE_SINT8,
                                                      JNI.FFI_TYPE_SINT8);


    PointerCharFunc(final long address) {
        super(CharFunc.class,
              address);
    }

    @Nonnull
    public static Pointer<CharFunc> nref(@Nonnull final CharFunc function) {
        if (function instanceof PointerCharFunc) {
            return (PointerCharFunc) function;
        }
        return new CharFunc_Jaccall_J(function);
    }


}
