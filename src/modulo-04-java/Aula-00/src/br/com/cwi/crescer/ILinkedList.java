package br.com.cwi.crescer;

import java.util.List;

public interface ILinkedList {

    public void addFirst(String value);

    public String getFirst();

    public String getLast();

    public List<String> list();

    public void addLast(String value);

    public void removeFirst();

    public void addMiddle(int index, String value);
}
