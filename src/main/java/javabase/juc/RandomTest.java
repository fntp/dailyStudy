package javabase.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.random.RandomGenerator;

/**
 * @author puye(0303)
 * @since 2023/7/14
 */
@Slf4j
public class RandomTest {

    public static void main(String[] args) {
        RandomGenerator aDefault = RandomGenerator.getDefault();
        long l = aDefault.nextLong();
        log.info("result: {}",l);
        log.info("length: {}",String.valueOf(l).length());
    }

}
