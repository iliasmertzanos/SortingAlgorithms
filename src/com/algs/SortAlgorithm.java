package com.algs;

import java.util.Comparator;

/**
 * This interface stipulates that all 
 * implementing classes provide a method
 * that is called sort.
 *
 * @param <T>
 */
public interface SortAlgorithm<T> {
	
	/**
	 * The method head signifies that two parameters 
	 * are required.
	 * 
	 * @param data
	 * @param comp
	 */
	public void sort(T[] data, Comparator<T> comp);
}
