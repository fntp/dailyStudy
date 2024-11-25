package com.xuexi.base;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author fntp
 * @since 2024/11/25
 */
class Config {
    public static String environment = "production";
}

public class UnsafeStaticFieldExample {
    private static final Unsafe UNSAFE;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            UNSAFE = (Unsafe) field.get(null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        // 获取 Config 类的环境字段
        Field environmentField = Config.class.getDeclaredField("environment");

        // 获取字段的偏移量
        long offset = UNSAFE.staticFieldOffset(environmentField);

        // 打印原始值
        System.out.println("Original environment: " + Config.environment);

        // 修改静态字段的值
        UNSAFE.putObject(Config.class, offset, "development");

        // 打印修改后的值
        System.out.println("Modified environment: " + Config.environment);
    }
}

