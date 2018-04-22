package demo.types;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

// typedef struct { void *data; GoInt len; GoInt cap; } GoSlice;
public class GoSlice extends Structure implements Structure.ByValue {
    public Pointer data;
    public long len;
    public long cap;

    protected List<String> getFieldOrder() {
        return Arrays.asList("data", "len", "cap");
    }
}
