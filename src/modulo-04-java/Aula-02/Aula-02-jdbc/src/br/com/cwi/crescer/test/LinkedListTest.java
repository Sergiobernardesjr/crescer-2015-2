package br.com.cwi.crescer.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.cwi.crescer.simple.LinkedList;

public class LinkedListTest {

    @Test
    public void test() {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst("primeiro");
        assertEquals(linkedList.getFirst(), "primeiro");
    }

}
