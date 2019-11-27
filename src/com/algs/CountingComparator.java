package com.algs;

import java.util.Comparator;

/**
 * This class provides a counter for another 
 * comparator. That means for every call of 
 * the other comparator's compare method the 
 * counter will be incremented by 1.
 *
 * @param <T>
 */
public class CountingComparator<T> implements Comparator<T> {
	
	/**
	 * The reference variable which is set on the 
	 * other comparator as a result of the calling
	 * of the constructor 
	 */
	private Comparator<T> comp;
	
	/**
	 * Private attribute variable of this class 
	 * in oder to store the other comparator's 
	 * compare method calls. 
	 */
	private int counter;
	
	/**
	 * A public getter method to obtain the current 
	 * counter value.
	 */
	public int getCounter() {
		
		return counter;
	}
	
	public CountingComparator(Comparator<T> comp) {
		
		this.comp = comp;
	}
	
	@Override
	/**
	 * The compare method doesn't alter the 
	 * other comparator's compare method but 
	 * extending it with a counter. this counter
	 * is incremented at every call of the 
	 * compare method.
	 * 
	 * @param o1 the first object to be compared
	 * @param o2 the second object to be compared
	 * 
	 * @return 1 is returned if the other comparator's
	 * method output is 1; -1 is returned if the other 
	 * comparator's method output is -1; 0 is returned in 
	 * any other case.
	 * 
	 * @exception Throws an IllegalStateException if one of
	 * the two passed parameters is null.
	 */
	public int compare(T o1, T o2) throws IllegalStateException{
		
		this.counter++;
		
		if(o1.equals(null) || o2.equals(null)) {
			
			throw new IllegalStateException();
		}
		
		if(this.comp.compare(o1, o2) == -1) {
			
			return -1;
		}
		
		else if(this.comp.compare(o1, o2) == 1) {
			
			return 1;
		}
		
		else {
			
			return 0;
		}
	}

}
