package javabase.juc;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author puye(0303)
 * @since 2023/7/10
 */
public class AwaitSignalTest {

    public static void main(String[] args) {
        //ExecutorService executorService = Executors.newCachedThreadPool();
        //AwaitSignalExample example = new AwaitSignalExample();
        //executorService.execute(() -> example.after());
        //executorService.execute(() -> example.before());
        Decoder decoder = Base64.getDecoder();
        byte[] result = decoder.decode("aHR0cHM6Ly90Lm1lL3ZhcmlhYmxldW5kZWZpbmVkZA==".getBytes(StandardCharsets.UTF_8));
        System.out.println(new String(result, StandardCharsets.UTF_8));
    }

}
