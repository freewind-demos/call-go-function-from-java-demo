package demo.types;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

// struct genKeys_return {
//	GoSlice r0; /* publicKey */
//	GoSlice r1; /* privateKey */
//	GoInterface r2; /* err */
// };

public class GenKeysResult extends Structure implements Structure.ByValue {
    public Pointer r0;
    public Pointer r1;
    public String r2;

    protected List<String> getFieldOrder() {
        return Arrays.asList("r0", "r1", "r2");
    }
}
