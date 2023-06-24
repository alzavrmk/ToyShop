package model.toy;

import java.util.Iterator;
import java.util.List;

public class ToyIterator<E> implements Iterator<E> {
    private int index;
    private List<E> list;

    public ToyIterator(List<E> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
         return index < list.size();
    }

    @Override
    public E next() {
        return list.get(index++);
    }
}