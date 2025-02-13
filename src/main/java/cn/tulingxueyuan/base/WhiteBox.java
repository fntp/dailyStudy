package cn.tulingxueyuan.base;

/**
 * @author fntp
 * @date 2025/2/9
 * @apiNote
 */
public class WhiteBox {
    private static native void registerNatives();
    static { registerNatives(); }
    public native int notExistedMethod();
    public native int getHeapOopSize();
    public static void main(String[] args) {
        WhiteBox wb = new WhiteBox();
        if (wb.getHeapOopSize() < 0) {
            throw new Error("wb.getHeapOopSize() < 0");
        }
        boolean catched = false;
        try {
            wb.notExistedMethod();
        } catch (UnsatisfiedLinkError e) {
            catched = true;
        }
        if (!catched) {
            throw new Error("wb.notExistedMethod() was invoked");
        }
    }
}
