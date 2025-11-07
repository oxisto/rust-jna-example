package rustjna;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;


public class Treble {
    public interface CTreble extends Library {
        CTreble INSTANCE = (CTreble) Native.loadLibrary("treble",CTreble.class);

        Pointer treble(int value);

        void free_mystruct(Pointer p);

        Pointer parse_rust(String src);

        void free_cstring(Pointer p);
    }

    public static void main(String[] args) {
        // old treble example
        Pointer p = CTreble.INSTANCE.treble(10);
        try {
            MyStruct s = new MyStruct(p);
            System.out.println("trebling: 10 " + s.getField());
        } finally {
            CTreble.INSTANCE.free_mystruct(p);
        }

        // new parse example
        String src = "pub struct Foo { x: i32 }\nfn bar() {}\nmod inner { use std::fmt; }";
        Pointer jsonPtr = CTreble.INSTANCE.parse_rust(src);
        if (jsonPtr == null) {
            System.err.println("parse_rust returned null");
            return;
        }
        try {
            String json = jsonPtr.getString(0);
            System.out.println("parsed AST JSON: " + json);
        } finally {
            CTreble.INSTANCE.free_cstring(jsonPtr);
        }
    }
}
