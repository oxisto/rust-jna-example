package rustjna;

import com.sun.jna.Pointer;
import com.sun.jna.PointerType;

public class MyStruct extends PointerType {

    public int getField() {
        return field;
    }

    public void setField(int field) {
        this.field = field;
    }

    int field;

    public MyStruct(Pointer p) {
        super(p);
    }

}
