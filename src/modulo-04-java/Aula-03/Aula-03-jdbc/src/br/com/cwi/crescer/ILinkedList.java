package br.com.cwi.crescer;

import java.util.List;

public interface ILinkedList<T> {

    public void addFirst(T value);

    public T getFirst();

    public T getLast();

    public List<T> list();

    public void addLast(T value);

    public void removeFirst();

    public void addMiddle(int index, T value);
}
