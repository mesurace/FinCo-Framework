package framework.lib;

import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

import framework.app.iterator.SortedIterator;

/**
 *
 * @author Manish Karki
 */
@SuppressWarnings({"rawtypes"})
public class FincoArrayList<T> extends CopyOnWriteArrayList {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Iterator getSortedIterator(Comparator comparator) {
        return new SortedIterator(this, comparator);
    }

}

