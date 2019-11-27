package com.algs;

import java.util.Comparator;

public class MergeSort<T> implements SortAlgorithm<T> {
	
	private T[] helpArray;
	
	@Override
	public void sort(T[] data, Comparator<T> comp) {
		
		mergeSort(data, 0, data.length-1, comp);
	}
	
	public void mergeSort(T[] data, int leftBound, int rightBound, Comparator<T> comp) {
		//System.out.println("*Sort*" + leftBound + " " + rightBound);
		if(leftBound < rightBound) {
			
			int middle = (leftBound + rightBound) / 2;
			
			mergeSort(data, leftBound, middle, comp);	
			mergeSort(data, middle + 1, rightBound, comp);
			merge(data, leftBound, middle, rightBound, comp);
			
		}
		
	}
	
	public void merge(T[] data, int leftBound, int middle, int rightBound, Comparator<T> comp) {
		//System.out.println("*Merge*" + leftBound + " " + middle + " " + rightBound);
		//System.out.println("*Array*" + data[leftBound] + " " + data[middle+1]);
		int i = leftBound;
		int j = middle+1;
		int k = leftBound;
		
		helpArray = (T[])data.clone();
		
		while(i <= middle && j <= rightBound){
			
			if(comp.compare(data[i], data[j]) == -1) {

				helpArray[k] = data[i];
				i++;
			}
			
			else {
				
				helpArray[k] = data[j];
				j++;
			}
			
			k++;
		}
		
		if(i > middle) {
			
			while(j <= rightBound) {
				
				helpArray[k] = data[j];
				j++;
				k++;
			}
		}
		
		else {
			
			while(i <= middle) {
				
				helpArray[k] = data[i];
				i++;
				k++;
			}
		}
		
		String res = "";
		for(int q = leftBound; q <= rightBound; q++) {
			data[q] = helpArray[q];
			res += "\t" + data[q];
		}
		//System.out.println(res);
	}

}
