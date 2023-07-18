package javabase.juc;

/**
 * @author puye(0303)
 * @since 2023/7/17
 */
public class Node {

    int value;

    Node next;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
