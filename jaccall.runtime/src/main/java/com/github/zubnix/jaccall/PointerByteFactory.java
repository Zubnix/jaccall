package com.github.zubnix.jaccall;

import java.lang.reflect.Type;
import java.nio.ByteBuffer;

final class PointerByteFactory implements PointerFactory<PointerByte> {

    @Override
    public PointerByte create(final Type type,
                              final long address) {
        return new PointerByte(address);
    }
}
