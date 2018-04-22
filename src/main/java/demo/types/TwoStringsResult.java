package demo.types;

import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

public class TwoStringsResult extends Structure implements Structure.ByValue {
    public String r0;
    public String r1;

    protected List<String> getFieldOrder() {
        return Arrays.asList("r0", "r1");
    }
}
