package com.algs;

import java.util.Comparator;

/**
 * This class is capable of ordering two given 
 * integer numbers.
 *
 */
public class ComparatorSize implements Comparator<Integer>{
	
	/**
	 * This method compares the two given Integer objects 
	 * and indicates their relative position to each other 
	 * on the number line by their difference. If the 
	 * difference is negative -1, if the 
	 * difference is positive 1 and if the two numbers 
	 * are equal 0 is returned.
	 * 
	 * @param o1 is a number of type Integer.
	 * @param o2 is a number of type Integer.
	 * 
	 * @return -1 is returned if o1 is smaller than o2, 
	 * 1 is returned if o1 is bigger than o2 and 0 is 
	 * returned if o1 equals o2.
	 * 
	 * @exception Throws an IllegalStateException if one of
	 * the two passed parameters is null.
	 */
	@Override
	public int compare(Integer o1, Integer o2) throws IllegalStateException{
		if(o1.equals(null) || o2.equals(null)) {
			
			throw new IllegalStateException();
		}
		
		if(o1 < o2) {
			
			return -1;
		}
		
		else if(o1 > o2) {
			
			return 1;
		}
		
		else if(o1.equals(o2)){
			
			return 0;
		}
		
		else {
			
			return 0;
		}
	}

}
