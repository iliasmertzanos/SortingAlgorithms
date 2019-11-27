package com.algs;

import java.util.Comparator;

/**
 * This generic class inverts the return of 
 * another comparator. For that to happen, the 
 * compare method of this class manipulates the 
 * output of the other comparator's compare 
 * method. 
 *
 * @param <T>
 */
public class ComparatorInverse<T> implements Comparator<T> {
	
	/**
	 * The reference variable which is set on the 
	 * other comparator as a result of the calling
	 * of the constructor 
	 */
	private Comparator<T> comp;
	
	public ComparatorInverse(Comparator<T> comp) {
		
		this.comp = comp;
	}
	
	@Override
	/**
	 * This compare methods inverts the outputs of the 
	 * passed comparator's compare method. As a 
	 * consequence the order of the two objects is 
	 * turned around.
	 * 
	 * @param o1 the first object to be compared
	 * @param o2 the second object to be compared
	 * 
	 * @return 1 is returned if the other comparator's
	 * method output is -1; -1 is returned if the other 
	 * comparator's method output is 1; 0 is returned in 
	 * any other case.
	 * 
	 * @exception Throws an IllegalStateException if one of
	 * the two passed parameters is null.
	 */
	public int compare(T o1, T o2) throws IllegalStateException {
		
		if(o1.equals(null) || o2.equals(null)) {
			
			throw new IllegalStateException();
		}
		
		if(this.comp.compare(o1, o2) == -1) {
			
			return 1;
		}
		
		else if(this.comp.compare(o1, o2) == 1) {
			
			return -1;
		}
		
		else {
			
			return 0;
		}
	}

}
