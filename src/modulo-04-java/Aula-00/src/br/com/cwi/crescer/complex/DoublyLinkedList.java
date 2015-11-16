package br.com.cwi.crescer.complex;

import java.util.ArrayList;
import java.util.List;

import br.com.cwi.crescer.ILinkedList;

public class DoublyLinkedList implements ILinkedList {

    private Node first, last;

    @Override
    public void addFirst(String value) {
        Node node = new Node(value);
        if (isEmpty()) {
            last = node;
        }
        first.setPrevious(node);
        node.setNext(first);
        first = node;
    }

    @Override
    public String getFirst() {
        return first.getValue();
    }

    @Override
    public String getLast() {
        return last.getValue();
    }

    @Override
    public List<String> list() {
        ArrayList<String> list = new ArrayList<String>();
        Node node = first;

        while (node != null) {
            list.add(node.getValue());
            node = node.getNext();
        }

        return list;
    }

    @Override
    public void addLast(String value) {
        Node node = new Node(value);

        if (isEmpty()) {
            first = node;
        } else {
            last.setNext(node);
            node.setPrevious(last);
        }
        last = node;
    }

    @Override
    public void removeFirst() {
        Node nodePrevious = first.getPrevious();
        first = first.getNext();
        first.setPrevious(nodePrevious);
    }

    @Override
    public void addMiddle(int index, String value) {
        Node nodeMid = new Node(value);
        if (isEmpty()) {
            first = nodeMid;
        }
        Node node = first;
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

    public boolean isEmpty() {
        return first == null && last == null;
    }

    protected class Node {

        private String value;

        private Node next, previous;

        public Node(String value, Node next, Node previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        public Node(String value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(String value) {
            this.value = value;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public String getValue() {
            return this.value;
        }

        public Node getNext() {
            return this.next;
        }

        public void setNext(Node lastNode) {
            this.next = lastNode;
        }
    }
}