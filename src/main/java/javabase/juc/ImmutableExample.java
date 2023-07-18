package javabase.juc;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 不可变(Immutable)的对象一定是线程安全的，不需要再采取任何的线程安全保障措施。
 * 只要一个不可变的对象被正确地构建出来，永远也不会看到它在多个线程之中处于不一致的状态。
 * final 关键字修饰的基本数据类型
 * String枚举类型
 * Number部分子类，如 Long 和 Double 等数值包装类型，BigInteger 和 BigDecimal 等大数据类型。但同为 Number 的原子类 AtomicInteger 和 AtomicLong 则是可变的。
 * ------
 * 著作权归@pdai所有
 * 原文链接：https://pdai.tech/md/java/thread/java-thread-x-theorty.html
 * @author puye(0303)
 * @since 2023/7/10
 */
public class ImmutableExample {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> unmodifiableMap = Collections.unmodifiableMap(map);
        // Collections.unmodifiableXXX() 先对原始的集合进行拷贝，需要对集合进行修改的方法都直接抛出异常。
        Map<String, Integer> cacheMap = Map.of("scx", 1, "gd", 2);
        cacheMap.put("scx",22);
        unmodifiableMap.put("a", 1);
    }
}
