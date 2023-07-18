package javabase.juc;

import sun.misc.Unsafe;

/**
 * @author puye(0303)
 * @since 2023/7/18
 */
public class UnSafeTest {

    public static void main(String[] args) {
        try {
            Unsafe unsafe = Unsafe.getUnsafe();
            // 创建一个字符串对象
            String str = "dasabi";

            // 获取字符串对象的偏移量
            long offset = unsafe.objectFieldOffset(String.class.getDeclaredField("value"));

            // 获取字符串对象的内存地址
            long address = unsafe.getLong(str, offset);
            System.out.println(address);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (SecurityException e) {
            throw new RuntimeException(e);
        }
    }

}
