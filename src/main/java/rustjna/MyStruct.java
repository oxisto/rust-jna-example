package rustjna;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

public class MyStruct extends Structure {

    public int field;

    public MyStruct() {}

    public MyStruct(Pointer p) {
        super(p);
        read();
    }

    @Override
    protected List<String> getFieldOrder() {
        return Arrays.asList("field");
    }

    public int getField() {
        return field;
    }

    public void setField(int field) {
        this.field = field;
        write();
    }

}
