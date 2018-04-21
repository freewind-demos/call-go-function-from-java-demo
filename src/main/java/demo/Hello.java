package demo;

import com.sun.jna.Native;

import java.io.File;

public class Hello {

    private static String LIB_PATH = new File("./go/math.so").getAbsolutePath();

    static MathLib INSTANCE = (MathLib) Native.loadLibrary(LIB_PATH, MathLib.class);

    public static void main(String[] args) {
        long result = INSTANCE.Multiply(12345, 67890);
        System.out.println(result);
    }

}
