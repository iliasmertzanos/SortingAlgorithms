package com.algs;

import java.util.Comparator;


public class QuickSort<T> implements SortAlgorithm<T> {

	@Override
	public void sort(T[] data, Comparator<T> comp) {
		
		quickSort(data, 0, data.length-1, comp);

	}
	
	private void quickSort(T[] data, int low, int high, Comparator<T> comp) {
		
		if(low < high) {
			int positionPivo  = quickSortPositioner(data, low, high, comp);
			quickSort(data, low, positionPivo-1,comp); //hier laufen ich bis echt kleiner
			quickSort(data, positionPivo+1, high, comp); //hier laufe ich bis echt größer
		}
	}
	
	private int quickSortPositioner(T[] data, int low, int high, Comparator<T> comp) {
		
		/**
		 * The pivot element is chosen as the element 
		 * in the middle of the part under consideration.
		 * 
		 */
		int pivotPosition = (high+low)/2;
		
		T swapper = data[pivotPosition];
		data[pivotPosition] = data[low];
		data[low] = swapper;
		
		int l = low + 1; // lower scrolling variable
		int h = high; // upper scrolling varible
	
		while(l <= h) {
		
			if((comp.compare(data[l], data[low]) == 1)) {
				
				swapper = data[l];
				data[l] = data[h];
				data[h] = swapper;
				
				h--;
			}
			
			else {
				
				l++;
			}		
		}
		swapper = data[h];
		data[h] = data[low];
		data[low] = swapper;
		return h;
	}

}
