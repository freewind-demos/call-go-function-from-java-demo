package demo;

import com.sun.jna.Library;

public interface MathLib extends Library {
    long Multiply(long x, long y);
}
