package datastructure;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class List<T> implements Iterable<T>{

    private Node<T> head;

    public List() {
        this.head = null;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public boolean contains(T x) {
        return search(x) != null;
    }

    public void print() {
        print(this.head);
    }

    private void print(Node<T> l) {
        while (l != null) {
            System.out.printf("%s ", l.item);
            l = l.next;
        }
        System.out.println();
    }


    public void insert(T x) {
        this.head = insert(this.head, x);
    }

    private Node<T> insert(Node<T> l, T x) {
        return new Node<>(x, l);
    }

    public Node<T> search(T x) {
        Node<T> p = this.head;

        while (p != null && !Objects.equals(p.item, x)) {
            p = p.next;
        }

        return p;
    }

    public void delete(T x) {
        Node<T> pred = null;
        Node<T> p = this.head;

        while (p != null && !Objects.equals(p.item, x)) {
            pred = p;
            p = p.next;
        }

        if (p != null) {
            if (pred == null) {
                this.head = p.next;
            } else {
                pred.next = p.next;
            }
            p.next = null;
        }
    }

    private static class Node<T> {
        private final T item;
        private Node<T> next;

        private Node(T item, Node<T> next){
            this.item = item;
            this.next = next;
        }

    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        private Node<T> pred = null, predOfPred = null;
        private Node<T> current = List.this.head;

        @Override
        public void remove() {
            if (this.pred != null) {
                Node<T> n = this.pred;
                if (this.predOfPred == null) {
                    head = this.current;
                } else {
                    this.predOfPred.next = this.current;
                }
                n.next = null;
            }
        }

        @Override
        public boolean hasNext() {
            return this.current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            final T x = this.current.item;
            this.predOfPred  = this.pred;
            this.pred = this.current;
            this.current = this.current.next;
            return x;
        }
    }
}
