package demo;

import com.sun.jna.Library;
import com.sun.jna.Pointer;
import demo.types.GenKeysResult;
import demo.types.GoSlice;
import demo.types.TwoStringsResult;

public interface MathLib extends Library {

    long Multiply(long x, long y);

    String ReturnString(String s);

    TwoStringsResult TwoStrings();

    Pointer ReturnByteArray();

    GenKeysResult GenKeys();

    int SumOf(Pointer input);

}