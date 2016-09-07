import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by CtheSky on 2016/9/7.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
    private class RandomizesQueueIterator implements Iterator<Item> {
        private int[] indices;
        private int m;

        public RandomizesQueueIterator() {
            indices = new int[n];
            m = 0;

            for (int i = 0; i < n; i++)
                indices[i] = i;
            for (int j = 0; j < 5; j++) {
                for (int i = 0; i < n; i++) {
                    int toSwap = StdRandom.uniform(0, n);
                    int temp = indices[i];
                    indices[i] = indices[toSwap];
                    indices[toSwap] = temp;
                }
            }
        }

        public boolean hasNext() { return m < n; }
        public void remove() { throw new UnsupportedOperationException(); }
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return items[indices[m++]];
        }
    }

    private Item[] items;
    private int n;
    private int capacity;

    public RandomizedQueue() {
        // construct an empty randomized queue
        n = 0;
        capacity = 64;
        items = (Item[]) new Object[capacity];
    }
    public boolean isEmpty() {
        // is the queue empty?
        return n == 0;
    }

    public int size() {
        // return the number of items on the queue
        return n;
    }

    public void enqueue(Item item) {
        // add the item
        if (item == null) throw new NullPointerException();
        if (n == capacity) {
            capacity *= 2;
            resize(capacity);
        }
        items[n++] = item;
    }

    public Item dequeue() {
        // remove and return a random item
        if (n == 0) throw new NoSuchElementException();
        int index = StdRandom.uniform(n);
        Item item = items[index];
        items[index] = items[--n];
        items[n] = null;
        if (n < capacity / 4) {
            capacity /= 2;
            resize(capacity);
        }
        return item;
    }

    public Item sample() {
        // return (but do not remove) a random item
        if (n == 0) throw new NoSuchElementException();
        int index = StdRandom.uniform(n);
        return items[index];
    }

    public Iterator<Item> iterator() {
        // return an independent iterator over items in random order
        return new RandomizesQueueIterator();
    }

    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < n; i++)
            temp[i] = items[i];
        items = temp;
    }

    public static void main(String[] args) {
        // unit testing
    }
}
