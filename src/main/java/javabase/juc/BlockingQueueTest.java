package javabase.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author puye(0303)
 * @since 2023/7/14
 */
public class BlockingQueueTest {

    public BlockingQueueTest(){

    }

    public static void main(String[] args) {
        BlockingQueue<Node> nodeQueue = new ArrayBlockingQueue<>(10);
    }

    public ArrayBlockingQueue<Node> getNodeQueue(){
        BlockingQueue<Node> nodeQueue = new ArrayBlockingQueue<>(10);
        return (ArrayBlockingQueue<Node>) nodeQueue;
    }

}
