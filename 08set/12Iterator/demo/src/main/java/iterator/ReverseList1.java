package iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ReverseList1<T> implements Iterable<T> {
    private List<T> list = new ArrayList<T>();

    public void add(T item) {
        list.add(item);
    }

    @Override
    public Iterator<T> iterator() {
        return new ReverseIterator(list.size());
    }

    class ReverseIterator implements Iterator<T> {
        int index;

        public ReverseIterator(int index) {
            this.index = index;
        }

        @Override
        public boolean hasNext() {
            return index > 0;
        }

        @Override
        public T next() {
            index--;
            return list.get(index);
        }

    }

}
