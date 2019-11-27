package com.algs;

import java.util.Comparator;


public class ComparatorDigitSum implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) throws IllegalStateException{
		
		if(o1.equals(null) || o2.equals(null)) {
			
			throw new IllegalStateException();
		}
		
		int digitSumO1 = digitSum(o1);
		int digitSumO2 = digitSum(o2);
		
		if(digitSumO1 < digitSumO2)
			return -1;
		
		else if(digitSumO1 > digitSumO2)
			return 1;
		
		else{
			
			if(o1 < o2)
				return -1;
			
			else if (o1 > o2)
				return 1;
			
			else 
				return 0;
		}
			
	}
	
	private int digitSum(Integer o) {
		
		int digitSum = 0;
		
		while(true) {
			
			digitSum += o%10;
			o /= 10;
			
			if(o == 0)
				break;
		}
		
		return digitSum;
	}

}
