package demo.types;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

// typedef struct { void *t; void *v; } GoInterface;
public class GoInterface extends Structure implements Structure.ByValue {
    public Pointer t;
    public Pointer v;

    protected List<String> getFieldOrder() {
        return Arrays.asList("t", "v");
    }
}
