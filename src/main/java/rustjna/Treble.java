package rustjna;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.PointerType;


public class Treble {
    public interface CTreble extends Library {
        CTreble INSTANCE = (CTreble) Native.loadLibrary("treble",CTreble.class);

        MyStruct treble(int value);
    }

    public static void main(String[] args) {
        MyStruct s = CTreble.INSTANCE.treble(20);
        try {
            System.out.println("trebling: 20 " + s.getField());
        } finally {
            // nothing
        }
    }
}
