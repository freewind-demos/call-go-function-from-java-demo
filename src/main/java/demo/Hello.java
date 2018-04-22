package demo;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import demo.types.GenKeysResult;
import demo.types.GoSlice;
import demo.types.TwoStringsResult;
import org.apache.commons.codec.binary.Hex;

import java.io.File;

public class Hello {

    private static String LIB_PATH = new File("./go/awesome.so").getAbsolutePath();

    static MathLib INSTANCE = (MathLib) Native.loadLibrary(LIB_PATH, MathLib.class);

    public static void main(String[] args) {
        multiply();

        returnString();

        twoStrings();

        returnByteArray();

        genKeys();

        sumOf();
    }

    private static void returnByteArray() {
        System.out.println("--------------- ReturnByteArray -------------------");
        Pointer result = INSTANCE.ReturnByteArray();
        byte[] byteArray = result.getByteArray(0, 3);
        System.out.println(Hex.encodeHex(byteArray));
    }

    private static void sumOf() {
        System.out.println("--------------- SumOf -------------------");

        byte[] data = new byte[]{3, 2, 5};
        Pointer pointer = new Memory(data.length + 1);
        pointer.write(0, data, 0, data.length);
        pointer.setByte(data.length, (byte) 0);

        int sum = INSTANCE.SumOf(pointer);
        System.out.println(sum);
    }

    private static void genKeys() {
        System.out.println("--------------- GenKeys -------------------");
        GenKeysResult gResult = INSTANCE.GenKeys();
        byte[] publicKey = gResult.r0.getByteArray(0, 3);
        byte[] privateKey = gResult.r1.getByteArray(0, 3);
        String error = gResult.r2;
        System.out.println("Public Key: " + new String(Hex.encodeHex(publicKey)));
        System.out.println("Private Key: " + new String(Hex.encodeHex(privateKey)));
        System.out.println("Error: " + error);
    }

    private static void twoStrings() {
        System.out.println("--------------- TwoStrings -------------------");
        TwoStringsResult twoResult = INSTANCE.TwoStrings();
        System.out.println(twoResult.r0 + ", " + twoResult.r1);
    }

    private static void returnString() {
        System.out.println("--------------- ReturnString -------------------");
        String sResult = INSTANCE.ReturnString("Go");
        System.out.println(sResult);
    }

    private static void multiply() {
        System.out.println("--------------- Multiply -------------------");
        long result = INSTANCE.Multiply(12345, 67890);
        System.out.println(result);
    }

}
