package com.github.zubnix.libtest;


import com.github.zubnix.jaccall.JNI;

import javax.annotation.Generated;

@Generated("com.github.zubnix.jaccall.compiletime.functor.FunctionPointerGenerator")
final class ShortFunc_Jaccall_C extends PointerShortFunc {

    static {
        JNI.linkFuncPtr(ShortFunc_Jaccall_C.class,
                        "_$",
                        2,
                        "(JS)S",
                        FFI_CIF);
    }

    ShortFunc_Jaccall_C(final long address) {
        super(address);
    }

    @Override
    public short $(final short value) {
        return _$(this.address,
                  value);
    }

    private static native short _$(final long address,
                                   final short value);
}
