package org.freedesktop.libtest;

import org.freedesktop.jaccall.Functor;

/**
 * Created by zubzub on 2/19/16.
 */
@Functor
public interface CharFunc {
    byte invoke(byte value);
}
