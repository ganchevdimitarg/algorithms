package StacksAndQueues;

import java.util.Iterator;
import java.util.NoSuchElementException;
//import edu.princeton.cs.algs4.StdIn;
//import edu.princeton.cs.algs4.StdOut;
//import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] queue;
    private int size;

    // construct an empty randomized queue
    public RandomizedQueue() {
        size = 0;
        queue = (Item[]) new Object[2];
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (queue.length == size) {
            expand(queue);
        }
        if (size == 0) {
            queue[size] = item;
            size++;
            return;
        }
        int randomIndex = getIndex();
        Item temp = queue[randomIndex];
        queue[randomIndex] = item;
        queue[size] = temp;
        size++;
    }

    private void expand(Item[] q) {
        Item[] newQueue = (Item[]) new Object[q.length * 2];
        System.arraycopy(q, 0, newQueue, 0, q.length);
        queue = newQueue;
    }

    private void shrink(Item[] q) {
        Item[] newQueue = (Item[]) new Object[q.length / 2];

        for (int i = 0; i < q.length; i++) {
            if (q[i] != null) {
                newQueue[i] = q[i];
            }
        }
        queue = newQueue;
    }

    // remove and return a random item
    public Item dequeue() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        if (size == queue.length / 4){
            shrink(queue);
        }
        int index = getIndex();
        Item element = queue[index];
        queue[index] = queue[size - 1];
        queue[index] = null;
        size--;
        return element;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        int index = getIndex();
        return queue[index];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new QueueIterator(this.size);
    }

    private class QueueIterator implements Iterator<Item> {

        private int counter;
        private int[] indices;

        public QueueIterator(int size) {
            counter = 0;
            indices = new int[size];
            for (int j = 0; j < size; j++) {
                indices[j] = j;
            }
            StdRandom.shuffle(indices);
        }

        public boolean hasNext() {
            return counter < size;
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            return queue[indices[counter++]];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private int getIndex() {
        return StdRandom.uniform(size);
    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<String> test = new RandomizedQueue<>();
        test.enqueue("a");
        test.enqueue("b");
        test.enqueue("c");
        test.enqueue("d");
        test.enqueue("e");
        test.enqueue("f");
        System.out.println(test.dequeue());
        System.out.println(test.sample());
        System.out.println(test.iterator().next());
    }


}