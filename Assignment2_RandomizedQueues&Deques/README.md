# Specification
Here is the link of assignment specification:  
http://coursera.cs.princeton.edu/algs4/assignments/queues.html
  
# My solution
### Deque
#### API:
```java
public class Deque<Item> implements Iterable<Item> {
   public Deque()                           // construct an empty deque
   public boolean isEmpty()                 // is the deque empty?
   public int size()                        // return the number of items on the deque
   public void addFirst(Item item)          // add the item to the front
   public void addLast(Item item)           // add the item to the end
   public Item removeFirst()                // remove and return the item from the front
   public Item removeLast()                 // remove and return the item from the end
   public Iterator<Item> iterator()         // return an iterator over items in order from front to end
   public static void main(String[] args)   // unit testing
}
```
#### Performance requiments:
> Your deque implementation must support each deque operation in constant worst-case time. 
> A deque containing n items must use at most 48n + 192 bytes of memory.
> and use space proportional to the number of items currently in the deque. 
> Additionally, your iterator implementation must support each operation (including construction)
> in constant worst-case time.

#### Implementation:  
I chooseto implement deque in double linked list , see my implementation 
[here](https://github.com/CtheSky/Algorithms-Coursera/blob/master/Assignment2_RandomizedQueues%26Deques/Deque.java).

### Randomized queue
#### API:
```java
public class RandomizedQueue<Item> implements Iterable<Item> {
   public RandomizedQueue()                 // construct an empty randomized queue
   public boolean isEmpty()                 // is the queue empty?
   public int size()                        // return the number of items on the queue
   public void enqueue(Item item)           // add the item
   public Item dequeue()                    // remove and return a random item
   public Item sample()                     // return (but do not remove) a random item
   public Iterator<Item> iterator()         // return an independent iterator over items in random order
   public static void main(String[] args)   // unit testing
}
```
#### Performance requiments:
> Your randomized queue implementation must support each randomized queue operation 
> (besides creating an iterator) in constant amortized time. 
> That is, any sequence of m randomized queue operations (starting from an empty queue)
> should take at most cm steps in the worst case, for some constant c. 
> A randomized queue containing n items must use at most 48n + 192 bytes of memory.
> Additionally, your iterator implementation must support operations next() and hasNext() in constant worst-case time;
> and construction in linear time; you may (and will need to) use a linear amount of extra memory per iterator.

#### Implementation:  
Here is a special requirement that every iterator must have a mutully independent order.
To exploit the extra linear memory of iterator, I choose to implement it in resizable array. 
To give a random order, I maintain an array of indecis and shuffle this array:
```java
private class RandomizesQueueIterator implements Iterator<Item> {
        private int[] indices;
        private int m;

        public RandomizesQueueIterator() {
            indices = new int[n];
            m = 0;

            for (int i = 0; i < n; i++)
                indices[i] = i;
            for (int j = 0; j < 5; j++) {//here I choose to shuffle 5 times, 1 time won't pass test
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
```
See more details
[here](https://github.com/CtheSky/Algorithms-Coursera/blob/master/Assignment2_RandomizedQueues%26Deques/RandomizedQueue.java).
