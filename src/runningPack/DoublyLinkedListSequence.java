package runningPack;

import java.util.Iterator;
import java.util.NoSuchElementException;

// Position ADT
interface Position<E> {
    E getElement();
}

// Doubly Linked List Node
class Node<E> implements Position<E> {
    private E element;
    private Node<E> prev;
    private Node<E> next;

    Node(E element, Node<E> prev, Node<E> next) {
        this.element = element;
        this.prev = prev;
        this.next = next;
    }

    @Override
    public E getElement() {
        return element;
    }

    public Node<E> getPrev() {
        return prev;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}

// Sequence ADT
interface Sequence<E> extends Iterable<E> {
    int size();
    boolean isEmpty();
    Position<E> first();
    Position<E> last();
    Position<E> before(Position<E> p) throws IllegalArgumentException;
    Position<E> after(Position<E> p) throws IllegalArgumentException;
    Position<E> addFirst(E e);
    Position<E> addLast(E e);
    Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException;
    Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException;
    E remove(Position<E> p) throws IllegalArgumentException;
}

// Doubly Linked List Sequence Implementation
public class DoublyLinkedListSequence<E> implements Sequence<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public DoublyLinkedListSequence() {
        head = null;
        tail = null;
        size = 0;
    }

    // Helper method to validate position
    private Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node)) {
            throw new IllegalArgumentException("Invalid position");
        }
        Node<E> node = (Node<E>) p;
        if (node.getNext() == null) {
            throw new IllegalArgumentException("Position is no longer in the list");
        }
        return node;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Position<E> first() {
        return head;
    }

    @Override
    public Position<E> last() {
        return tail;
    }

    @Override
    public Position<E> before(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getPrev();
    }

    @Override
    public Position<E> after(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getNext();
    }

    @Override
    public Position<E> addFirst(E e) {
        Node<E> newNode = new Node<>(e, null, head);
        if (isEmpty()) {
            tail = newNode; // New node is also the tail
        } else {
            head.setPrev(newNode);
        }
        head = newNode; // New node becomes the head
        size++;
        return newNode;
    }

    @Override
    public Position<E> addLast(E e) {
        Node<E> newNode = new Node<>(e, tail, null);
        if (isEmpty()) {
            head = newNode; // New node is also the head
        } else {
            tail.setNext(newNode);
        }
        tail = newNode; // New node becomes the tail
        size++;
        return newNode;
    }

    @Override
    public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        Node<E> newNode = new Node<>(e, node.getPrev(), node);
        node.getPrev().setNext(newNode);
        node.setPrev(newNode);
        size++;
        return newNode;
    }

    @Override
    public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        Node<E> newNode = new Node<>(e, node, node.getNext());
        node.getNext().setPrev(newNode);
        node.setNext(newNode);
        size++;
        return newNode;
    }

    @Override
    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        Node<E> prevNode = node.getPrev();
        Node<E> nextNode = node.getNext();
        if (prevNode == null) {
            head = nextNode; // Removing head node
        } else {
            prevNode.setNext(nextNode);
        }
        if (nextNode == null) {
            tail = prevNode; // Removing tail node
        } else {
            nextNode.setPrev(prevNode);
        }
        E removedElement = node.getElement();
        node.setNext(null); // Help garbage collection
        node.setPrev(null); // Help garbage collection
        size--;
        return removedElement;
    }

    @Override
    public Iterator<E> iterator() {
        return new DoublyLinkedListIterator();
    }

    private class DoublyLinkedListIterator implements Iterator<E> {
        private Position<E> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements");
            }
            E element = current.getElement();
            current = after(current);
            return element;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedListSequence<Integer> sequence = new DoublyLinkedListSequence<>();
        Position<Integer> p1 = sequence.addFirst(10);
        Position<Integer> p2 = sequence.addLast(20);
        Position<Integer> p3 = sequence.addAfter(p1, 15);

        // Example of addition operation (O(1))
        Position<Integer> p4 = sequence.addBefore(p2, 25);

        // Example of removal operation (O(1))
        sequence.remove(p3);

        // Iterating over elements
        for (int num : sequence) {
            System.out.println(num);
        }
    }
}
