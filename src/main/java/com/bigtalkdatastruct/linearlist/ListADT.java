package com.bigtalkdatastruct.linearlist;

public interface ListADT<T> {

    public boolean empty();

    public void clean();

    public T getElem(int index);

    public boolean locateElem(T e);

    public boolean insert(T e);

    public boolean insert(int index, T e);

    public T delete(int index);

    public int size();

    public void print();

}
