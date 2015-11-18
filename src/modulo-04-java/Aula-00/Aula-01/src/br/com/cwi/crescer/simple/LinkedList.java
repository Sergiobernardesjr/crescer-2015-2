package br.com.cwi.crescer.simple;

import java.util.ArrayList;
import java.util.List;

import br.com.cwi.crescer.ILinkedList;

public class LinkedList<T> implements ILinkedList<T> {

    private Node<T> last, first;

    @Override
    public void addFirst(T value) {
        Node<T> node = new Node<T>(value, first);
        if (first == null) {
            last = node;
        }
        first = node;
    }

    @Override
    public T getFirst() {
        return first.getValue();
    }

    @Override
    public T getLast() {
        return last.getValue();
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
        if (first == null) {
            first = node;
        } else {
            last.setNext(node);
        }
        last = node;
    }

    @Override
    public void removeFirst() {
        first = first.getNext();
    }

    @Override
    public void addMiddle(int index, T value) {
        Node<T> nodeMid = new Node<T>(value);
        if (first == null) {
            first = nodeMid;
        }
        Node<T> node = first;
        int cont = 0;
        while (node != null) {
            node = node.getNext();
            cont++;
            if (index - 1 == cont) {
                nodeMid.setNext(node.getNext());
                node.setNext(nodeMid);
            }
        }
    }

    public void remove(int index) {

    }

    private Node<T> getNode(int index) {
        Node<T> node = first;
        for (int i = 0; i < index; i++) {
            if (i == (index - 1)) {
                break;
            }
            node = node.next;
        }
        return node;
    }

    protected class Node<T> {

        private T value;

        private Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

        public Node(T value) {
            this.value = value;
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
}
