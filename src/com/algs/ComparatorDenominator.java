package com.algs;

import java.util.Comparator;


public class ComparatorDenominator implements Comparator<Double> {
	
	private double epsilon;
	
	public ComparatorDenominator(double epsilon) {
		
		this.epsilon = epsilon;
	}
	
	@Override
	public int compare(Double o1, Double o2) throws IllegalStateException{
		
		if(o1.equals(null) || o2.equals(null)) {
			
			throw new IllegalStateException();
		}
		
		int denomO1 = denomCalculator(o1);
		int denomO2 = denomCalculator(o2);
		
		if(denomO1 < denomO2)
			return -1;
		
		else if(denomO1 > denomO2)
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
	
	public int denomCalculator(double o1) {
		
		int currentDenom = 0;
		int i = 1;
		
		while(true) {
			
			if((o1 * i) % 1 == 0) {
				
				currentDenom = i;
				
				double j = Math.floor(o1) * currentDenom;
				double q = 0;
				
				while(true) {
					
					q = j/currentDenom;
					
					if(q > o1 - this.epsilon && q < o1 + this.epsilon) {
						//System.out.println("q ist " + q + " j ist " + j + " currDenom ist " + currentDenom);
						return currentDenom;
					}
					
					if(q >= o1 + this.epsilon) {
						break;
					}
					
					//System.out.println(j);
					j++;
				}
			}
			
			i++;
		}
	}

}
