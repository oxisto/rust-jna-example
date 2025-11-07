#![crate_type = "cdylib"]

#[repr(C)]
pub struct MyStruct {
    pub field: i32,
}

#[no_mangle]
pub extern "C" fn treble(value: i32) -> MyStruct {
    return MyStruct { field: value * 3 }
}
