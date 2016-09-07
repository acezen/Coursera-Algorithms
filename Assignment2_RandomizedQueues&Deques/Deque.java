import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by CtheSky on 2016/9/7.
 */
public class Deque<Item> implements Iterable<Item> {
    private class Node {
        private Item item;
        private Node prev;
        private Node next;

        Node(Item item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }
    private class DequeIterator implements Iterator<Item> {
        private Node scanner = head;

        public boolean hasNext() { return scanner != null; }
        public void remove() { throw new UnsupportedOperationException(); }
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = scanner.item;
            scanner = scanner.next;
            return item;
        }
    }

    private Node head;
    private Node tail;
    private int count;

    public Deque() {
        // construct an empty deque
        head = null;
        tail = null;
        count = 0;
    }

    public boolean isEmpty() {
        // is the deque empty?
        return count == 0;
    }

    public int size() {
        // return the number of items on the deque
        return count;
    }

    public void addFirst(Item item) {
        // add the item to the front
        if (item == null) throw new NullPointerException();
        if (count == 0) {
            head = new Node(item, null, null);
            tail = head;
        }
        else {
            head = new Node(item, null, head);
            head.next.prev = head;
        }
        count++;
    }

    public void addLast(Item item) {
        // add the item to the end
        if (item == null) throw new NullPointerException();
        if (count == 0) {
            head = new Node(item, null, null);
            tail = head;
        }
        else {
            tail = new Node(item, tail, null);
            tail.prev.next = tail;
        }
        count++;
    }

    public Item removeFirst() {
        // remove and return the item from the front
        if (count == 0) throw new NoSuchElementException();
        Item item = head.item;
        if (count == 1) {
            head = null;
            tail = null;
        }
        else {
            head = head.next;
            head.prev = null;
        }
        count--;
        return item;
    }

    public Item removeLast() {
        // remove and return the item from the end
        if (count == 0) throw new NoSuchElementException();
        Item item = tail.item;
        if (count == 1) {
            head = null;
            tail = null;
        }
        else {
            tail = tail.prev;
            tail.next = null;
        }
        count--;
        return item;
    }

    public Iterator<Item> iterator() {
        // return an iterator over items in order from front to end
        return new DequeIterator();
    }

    public static void main(String[] args) {
        // unit testing
    }
}
