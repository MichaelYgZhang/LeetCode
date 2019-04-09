package com.bigtalkdatastruct.linearlist;

public class ArrayList<T> implements ListADT<T> {

    private static final int DEFAULT_CAPACITY = 10;
    transient T[] elementData;
    private final T[] DEFAULT_EMPTY = (T[]) new Object[]{};
    private int count;//实际个数
    private int size;//数组大小

    public ArrayList() {
        construct();
    }

    private void construct() {
        elementData = DEFAULT_EMPTY;
        size = DEFAULT_CAPACITY;
        count = 0;
    }

    private boolean ensureCapacity() {
        if (count + 1 > DEFAULT_CAPACITY ) {
            throw new RuntimeException("容量不足");
        }
        if (DEFAULT_EMPTY == elementData) {
            elementData =  (T[]) new Object[DEFAULT_CAPACITY];
        }
        return true;
    }

    public boolean empty() {
        return count == 0;
    }

    public void clean() {
        construct();
    }

    //O(1)
    public T getElem(int index) {
        if (index >= count || index < 0) {
            throw new RuntimeException("index:" + index + ", 越界");
        }
        return elementData[index];
    }

    //O(n)
    public boolean locateElem(T e) {
        for (T t : elementData) {
            if (t == e) {
                return true;
            }
        }
        return false;
    }

    public boolean insert(T e) {
        //容量不足
        if (count + 1 > DEFAULT_CAPACITY) {
            throw new RuntimeException("容量不足,当前容量:" + count);
        }

        if (!ensureCapacity()) {
            return false;
        }
        elementData[count++] = e;
        return true;
    }

    //O(n)
    public boolean insert(int index, T e) {
        //容量不足
        if (count + 1 > size) {
            throw new RuntimeException("容量不足,当前容量:" + count);
        }
        //不在范围内
        if (index < 0 || index > size) {
            throw new RuntimeException("index:" + index + ", 越界");
        }
        if (!ensureCapacity()) {
            return false;
        }
        for (int i = count ; i > index; i--) {
            elementData[i] = elementData[i-1];
        }
        elementData[index] = e;
        count++;
        return true;
    }

    //O(n)
    public T delete(int index) {
        if (index < 1 || index > size) {
            throw new RuntimeException("index:" + index + ", 越界");
        }
        T t = elementData[index -1];
        if (index < count) {
            for (int i = index; i < count; i++) {
                elementData[i-1] = elementData[i];
            }
        }
        elementData[--count] = null;
        return t;
    }

    public int size() {
        return count;
    }

    public void print() {
        for (T e : elementData) {
            System.out.println(e);
        }
    }
}
