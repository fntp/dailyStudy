package algorithm.study;

import javabase.datastructure.deque.Deque;

import java.util.Iterator;

/**
 * @author fntp
 * @since 2023/8/21
 */
public class LinkedListDeque<E> implements Deque<E>, Iterable<E> {

    static class Node<E> {
        Node<E> prev;
        E value;
        Node<E> next;

        public Node(Node<E> prev, E value, Node<E> next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private final Node<E> sentinelNode = new Node<>(null, null, null);

    private int capacity;
    /**
     * 队列钟大哥元素个数
     */
    int size;

    public LinkedListDeque(int capacity) {
        this.capacity = capacity;
        sentinelNode.next = sentinelNode;
        sentinelNode.prev = sentinelNode;
    }

    @Override
    public boolean offerFirst(E e) {
        if (isFull()) {
            return false;
        }
        // 插入节点的上一个节点
        Node<E> a = sentinelNode;
        // 插入节点的下一个节点
        Node<E> b = sentinelNode.next;
        // 执行插入
        return extracted(e, a, b);
    }

    @Override
    public boolean offerLast(E e) {
        if (isFull()) {
            return false;
        }
        // 插入节点的上一个节点
        Node<E> a = sentinelNode.prev;
        // 插入节点的下一个节点
        Node<E> b = sentinelNode;
        return extracted(e, a, b);
    }

    private boolean extracted(E e, Node<E> a, Node<E> b) {
        // 执行插入
        Node<E> insertNode = new Node<>(a, e, b);
        a.next = insertNode;
        b.prev = insertNode;
        size++;
        return true;
    }

    @Override
    public E pollFirst() {
        if (isFull()) {
            return null;
        }
        Node<E> a = sentinelNode;
        Node<E> b = sentinelNode.next.next;
        Node<E> removed = b.prev;
        a.next = b;
        b.prev = a;
        size--;
        return removed.value;
    }

    @Override
    public E pollLast() {
        if (isFull()) {
            return null;
        }
        Node<E> a = sentinelNode.prev.prev;
        Node<E> b = sentinelNode;
        Node<E> removed = b.prev;
        a.next = b;
        b.prev = a;
        size--;
        return removed.value;
    }

    @Override
    public E peekFirst() {
        if (isFull()) {
            return null;
        }
        return sentinelNode.next.value;
    }

    @Override
    public E peekLast() {
        if (isFull()) {
            return null;
        }
        return sentinelNode.prev.value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return capacity == size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> p = sentinelNode.next;

            @Override
            public boolean hasNext() {
                return p != sentinelNode;
            }

            @Override
            public E next() {
                E value = p.value;
                p = p.next;
                return value;
            }
        };
    }
}
