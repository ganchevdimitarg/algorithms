package StacksAndQueues;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private Node<Item> first;
    private Node<Item> last;
    private int size;

    // construct an empty deque
    public Deque() {
        first = null;
        last = null;
        size = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }

        if (size == 0) {
            first = new Node<>(item);
            last = first;
            size++;
        } else {
            Node<Item> oldFirst = first;
            first = new Node<>(item);
            oldFirst.setPrev(first);
            first.setNext(oldFirst);
            size++;
        }
    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (size == 0) {
            last = new Node<>(item);
            first = last;
            size++;
        } else {
            Node<Item> oldLast = last;
            last = new Node<>(item);
            oldLast.setNext(last);
            last.setPrev(oldLast);
            size++;
        }
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        }

        if (size > 1) {
            Node<Item> oldFirst = first;
            first = first.getNext();
            first.setPrev(null);
            size--;
            return oldFirst.getValue();
        }

        size--;
        Item value = first.getValue();
        first = null;
        last = null;
        return value;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        if (size > 1) {
            Node<Item> oldLast = last;
            last = last.getPrev();
            last.setNext(null);
            size--;
            return oldLast.getValue();
        }
        size--;
        Item value = last.getValue();
        first = null;
        last = null;
        return value;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {

        private Node<Item> current;

        public DequeIterator() {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.getValue();
            current = current.getNext();
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class Node<Item> {
        private Item value;
        private Node<Item> next;
        private Node<Item> prev;

        public Node(Item value) {
            this.value = value;
        }

        public Item getValue() {
            return value;
        }

        public Node<Item> getNext() {
            return next;
        }

        public void setNext(Node<Item> next) {
            this.next = next;
        }

        public Node<Item> getPrev() {
            return prev;
        }

        public void setPrev(Node<Item> prev) {
            this.prev = prev;
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        deque.addLast(1);
        deque.removeFirst();
        Iterator<Integer> iterator = deque.iterator();
        System.out.println(iterator);
    }
}
