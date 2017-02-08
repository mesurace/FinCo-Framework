package framework.app.iterator;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;

import framework.lib.FincoArrayList;

/**
 *
 * @author Manish Karki
 */
@SuppressWarnings({"rawtypes","unchecked"})
public class SortedIterator <T> implements Iterator<T> {

    private ListIterator<T> it;

	public SortedIterator(FincoArrayList list, Comparator comparator) {
        Collections.sort(list, comparator);
        this.it = list.listIterator();
    }


	@Override
    public boolean hasNext() {
        return it.hasNext();
    }

    @Override
    public T next() {
        return it.next();
    }

    @Override
    public void remove() {
        it.remove();
    }

}

