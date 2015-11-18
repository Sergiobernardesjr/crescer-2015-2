package br.com.cwi.crescer.complex;

import java.util.ArrayList;
import java.util.List;

import br.com.cwi.crescer.ILinkedList;

public class DoublyLinkedList<T> implements ILinkedList<T> {

    private Node<T> first, last;

    @Override
    public void addFirst(T value) {
        Node<T> node = new Node<T>(value);
        if (isEmpty()) {
            last = node;
        }
        first.setPrevious(node);
        node.setNext(first);
        first = node;
    }

    @Override
    public T getFirst() {
        return this.first.getValue();
    }

    @Override
    public T getLast() {
        return this.last.getValue();
    }

    @Override
    public List<T> list() {
        ArrayList<T> list = new ArrayList<T>();
        Node<T> node = first;

        while (node != null) {
            list.add(node.getValue());
            node = node.getNext();
        }

        return list;
    }

    @Override
    public void addLast(T value) {
        Node<T> node = new Node<T>(value);

        if (isEmpty()) {
            first = node;
        } else {
            last.setNext(node);
            node.setPrevious(last);
        }
        last = node;
    }

    @Override
    public void remove(int index) {
        Node<T> removido = getNode(index);
        Node<T> anterior = removido.getPrevious();
        anterior.setNext(removido.getNext());
    }

    @Override
    public void addMiddle(int index, T value) {
        Node<T> nodeMid = new Node<T>(value);
        if (isEmpty()) {
            first = nodeMid;
        }
        Node<T> node = first;
        int cont = 0;
        while (node != null) {
            node = node.getNext();
            cont++;
            if (index - 1 == cont) {
                nodeMid.setNext(node.getNext());
                nodeMid.setPrevious(node.previous);
                node.setNext(nodeMid);
            }
        }
    }

    private Node<T> getNode(int index) {
        int i = 0;
        Node<T> node = first;
        while (i < index) {
            node = node.getNext();
            i++;
        }
        return node;
    }

    public boolean isEmpty() {
        return first == null && last == null;
    }

    protected class Node<T> {

        private T value;

        private Node<T> next, previous;

        public Node(T value, Node<T> next, Node<T> previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

        public Node(T value) {
            this.value = value;
        }

        public Node<T> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<T> previous) {
            this.previous = previous;
        }

        public T getValue() {
            return this.value;
        }

        public Node<T> getNext() {
            return this.next;
        }

        public void setNext(Node<T> lastNode) {
            this.next = lastNode;
        }
    }

    @Override
    public void removeFirst() {
        if (!isEmpty()) {
            first = first.getNext();
        }
    }
}