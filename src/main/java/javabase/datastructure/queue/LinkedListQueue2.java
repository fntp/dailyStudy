package javabase.datastructure.queue;

import java.util.Iterator;
import java.util.StringJoiner;

/**
 * 基于单向环形链表实现
 * @param <E> 队列中元素类型
 */
public class LinkedListQueue2<E>
        implements Queue<E>, Iterable<E> {

    private static class Node<E> {
        E value;
        Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    private final Node<E> head = new Node<>(null, null);
    private Node<E> tail = head;
    int size = 0;
    private int capacity = Integer.MAX_VALUE;

    {
        tail.next = head;
    }

    public LinkedListQueue2() {
    }

    public LinkedListQueue2(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean offer(E value) {
        Node<E> newNode = new Node<>(value, head);
        tail.next = newNode;
        tail = newNode;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        Node<E> first = head.next;
        head.next = first.next;
        if (first == tail) {
            tail = head;
        }
        size--;
        return first.value;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return head.next.value;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> p = head.next;

            @Override
            public boolean hasNext() {
                return p != head;
            }

            @Override
            public E next() {
                E value = p.value;
                p = p.next;
                return value;
            }
        };
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(",");
        for (E e : this) {
            sj.add(e.toString());
        }
        return sj.toString();
    }
}
