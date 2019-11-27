package com.algs;

import java.util.Comparator;

/**
 * This generic class handles unsorted arrays and
 * provides a sorted representation employing
 * the selection sort algorithm.
 * 
 * @param <T>
 */
public class SelectionSort<T> implements SortAlgorithm<T>{
	
	@Override
	public void sort(T[] data, Comparator<T> comp) throws IllegalArgumentException{
		
		if(data == null) {
			
			throw new IllegalArgumentException();
		}
		
		if(data.length > 1) {
			
			int phase = 0;
			int currPos = 0;

			T minObj = null;
			
			for(int i = phase; i < data.length; i++) {
				
				/**
				 * In every phase of the selection sort 
				 * algorithm the current minObj is set 
				 * on the phase starting position. 
				 * Likewise the index of the minObj 
				 * is overwritten with the phase 
				 * starting position index.
				 */
				if(i == phase) {

					minObj = data[phase];
					currPos = phase;
				}
				
				/**
				 * By use of the passed comparator 
				 * the current  is compared 
				 * with the minObj. If the result of 
				 * compare is smaller zero, the current 
				 * loop index element becomes the new
				 * minObj. At once the position of 
				 * the new minObj is stored in currPos.
				 */
				if(comp.compare(data[i],minObj) < 0) {
					
					minObj = data[i];
					currPos = i;
				
				}
				
				/**
				 * If the loop is in its last scroll 
				 * the current minObj is effectively 
				 * the smallest Object. Therefore the 
				 * element at the start position of 
				 * this loop in the actual phase 
				 * is pushed on the position of the 
				 * found minObj and the minObj 
				 * takes its place vice versa.
				 */
				if(i == data.length-1) {
					
					data[currPos] = data[phase];
					data[phase]= minObj;
					
					i = phase;
					phase++;
				}
			}
		}	
		
	}
	
	
}
