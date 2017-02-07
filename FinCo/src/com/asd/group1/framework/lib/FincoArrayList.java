package com.asd.group1.framework.lib;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import com.asd.group1.framework.app.iterator.SortedIterator;

/**
 *
 * @author Manish Karki
 */
@SuppressWarnings({"rawtypes"})
public class FincoArrayList<T> extends ArrayList {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Iterator getSortedIterator(Comparator comparator) {
        return new SortedIterator(this, comparator);
    }

}

