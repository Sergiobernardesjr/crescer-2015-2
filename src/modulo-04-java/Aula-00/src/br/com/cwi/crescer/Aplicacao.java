package br.com.cwi.crescer;

import br.com.cwi.crescer.simple.LinkedList;

public class Aplicacao {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst("primeiro");
        linkedList.addFirst("segundo");
        linkedList.addFirst("terceiro");
        linkedList.addMiddle(2, "meio");
        linkedList.addLast("quinto");
        linkedList.addLast("sexto");
        // linkedList.removeFirst();
        System.out.println(linkedList.list());

    }
}
