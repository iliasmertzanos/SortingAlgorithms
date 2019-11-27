package com.algs;

import java.util.Random;


public class Start {

	public static void main(String[] args) {
		
		if(args == null || args.length != 4) {			
			System.out.println("Please insert 4 parameters.");
			return;
		}
		
		/**
		 * Inputs of user.
		 */
		String numbersOfrandoms = args[0];
		String sortingAlgorithm = args[1];
		String sortingDirection = args[2];
		String sortingComparator = args[3];
		
		/**
		 * Error message and return if passed arguments 
		 * are not admissible.
		 */		
		if(!(numbersOfrandoms.matches("[0-9]+"))) {
			
			System.out.println("Please insert an integer number.");
			return;
		}	
		
		if(!(sortingAlgorithm.equals("select") || sortingAlgorithm.equals("merge") || sortingAlgorithm.equals("quick"))) {
			
			System.out.println("Inapt sorting algorithm.");
			return;
		}
		
		if(!(sortingDirection.equals("up") || sortingDirection.equals("down"))) {
			
			System.out.println("Ineligible sort direction.");
			return;
		}
		
		if(!(sortingComparator.equals("size") || sortingComparator.equals("digitsum") || sortingComparator.equals("denominator"))) {
			
			System.out.println("Unavailable comparator.");
			return;
		}
		
		
		/**
		 * Creates the random generator and the counter.
		 */
		Random generator = new Random();

		int amountOfRandomNumbers = Integer.parseInt(numbersOfrandoms);
		
		int counter = 0;
		
		double epsilon = 0.01;
		
		/**
		 * Selects the sorting algorithm.
		 */
		if(!(sortingComparator.equals("denominator"))) {
			
			Integer[] randomNumberArray = new Integer[amountOfRandomNumbers];
			for(int i = 0; i < amountOfRandomNumbers; i++) {
				//if denominator
				
				randomNumberArray[i] = generator.nextInt(2001) - 1000;		
			}
			
			String res2 = "";
			for(int i = 0; i < randomNumberArray.length; i++) {
			
				res2 += "\t" + randomNumberArray[i];
			}
			System.out.println(res2);
			
			
			switch (sortingAlgorithm) {
			
			case "merge":	
				
				MergeSort<Integer> merger = new MergeSort<Integer>();
				if(sortingDirection.equals("up")) {
					
					if(sortingComparator.equals("size")) {
						
						CountingComparator<Integer> comp = new CountingComparator(new ComparatorSize());
						merger.sort(randomNumberArray, comp);
						counter = comp.getCounter();
					}
					
					else {
						
						CountingComparator<Integer> comp = new CountingComparator(new ComparatorDigitSum());
						merger.sort(randomNumberArray, comp);
						counter = comp.getCounter();
					}
					
				}
				
				else {
					
					if(sortingComparator.equals("size")) {
						
						CountingComparator<Integer> comp = new CountingComparator(new ComparatorInverse(new ComparatorSize()));
						merger.sort(randomNumberArray, comp);
						counter = comp.getCounter();
					}
					
					else {
						
						CountingComparator<Integer> comp = new CountingComparator(new ComparatorInverse(new ComparatorDigitSum()));
						merger.sort(randomNumberArray, comp);
						counter = comp.getCounter();
					}
				}
				
				break;
				
			case "select":	
				
				SelectionSort<Integer> selecter = new SelectionSort<Integer>();
				if(sortingDirection.equals("up")) {
					
					if(sortingComparator.equals("size")) {
						
						CountingComparator<Integer> comp = new CountingComparator(new ComparatorSize());
						selecter.sort(randomNumberArray, comp);
						counter = comp.getCounter();
					}
					
					else {
						
						CountingComparator<Integer> comp = new CountingComparator(new ComparatorDigitSum());
						selecter.sort(randomNumberArray, comp);
						counter = comp.getCounter();
					}
					
				}
				
				else {
					
					if(sortingComparator.equals("size")) {
						
						CountingComparator<Integer> comp = new CountingComparator(new ComparatorInverse(new ComparatorSize()));
						selecter.sort(randomNumberArray, comp);
						counter = comp.getCounter();
					}
					
					else {
						
						CountingComparator<Integer> comp = new CountingComparator(new ComparatorInverse(new ComparatorDigitSum()));
						selecter.sort(randomNumberArray, comp);
						counter = comp.getCounter();
					}
					
					
				}
				
				break;
				
			case "quick":	
				
				QuickSort<Integer> quicker = new QuickSort<Integer>();
				if(sortingDirection.equals("up")) {
					
					if(sortingComparator.equals("size")) {
						
						CountingComparator<Integer> comp = new CountingComparator(new ComparatorSize());
						quicker.sort(randomNumberArray, comp);
						counter = comp.getCounter();
					}
					
					else {
						
						CountingComparator<Integer> comp = new CountingComparator(new ComparatorDigitSum());
						quicker.sort(randomNumberArray, comp);
						counter = comp.getCounter();
					}
					
				}
				
				else {
					
					if(sortingComparator.equals("size")) {
						
						CountingComparator<Integer> comp = new CountingComparator(new ComparatorInverse(new ComparatorSize()));
						quicker.sort(randomNumberArray, comp);
						counter = comp.getCounter();
					}
					
					else {
						
						CountingComparator<Integer> comp = new CountingComparator(new ComparatorInverse(new ComparatorDigitSum()));
						quicker.sort(randomNumberArray, comp);
						counter = comp.getCounter();
					}
					
					
				}
				
				break;

			default: System.out.println("This doesn't work!");
					 
				break;
			}
			
			res2 = "";
			for(int i = 0; i < randomNumberArray.length; i++) {
			
				res2 += "\t" + randomNumberArray[i];
			}
			System.out.println(res2 + "\n \n" + "Vergleichsschritte: " + counter);
		}
		
		if(sortingComparator.equals("denominator")) {
			
			Double[] randomNumberArray = new Double[amountOfRandomNumbers];
			for(int i = 0; i < amountOfRandomNumbers; i++) {
				
				randomNumberArray[i] = Math.floor((generator.nextDouble() * 20 - 10) * 10) / 10;	
			}
			
			/**
			 * Display 
			 */
			String res2 = "";
			for(int i = 0; i < randomNumberArray.length; i++) {
			
				res2 += "\t" + randomNumberArray[i];
			}
			System.out.println(res2);
			
			switch (sortingAlgorithm) {
			
			case "merge":	
				
				MergeSort<Double> merger = new MergeSort<Double>();
				if(sortingDirection.equals("up")) {
						
					CountingComparator<Double> comp = new CountingComparator(new ComparatorDenominator(epsilon));
					merger.sort(randomNumberArray, comp);
					counter = comp.getCounter();
				}
				
				else {
						
					CountingComparator<Double> comp = new CountingComparator(new ComparatorInverse(new ComparatorDenominator(epsilon)));
					merger.sort(randomNumberArray, comp);
					counter = comp.getCounter();
				}
				
				break;
				
			case "select":	
				
				SelectionSort<Double> selecter = new SelectionSort<Double>();
				if(sortingDirection.equals("up")) {
					
					CountingComparator<Double> comp = new CountingComparator(new ComparatorDenominator(epsilon));
					selecter.sort(randomNumberArray, comp);
					counter = comp.getCounter();					
				}
				
				else {
					
					CountingComparator<Double> comp = new CountingComparator(new ComparatorInverse(new ComparatorDenominator(epsilon)));
					selecter.sort(randomNumberArray, comp);
					counter = comp.getCounter();
				}
				
				break;
				
			case "quick":	
				
				QuickSort<Double> quicker = new QuickSort<Double>();
				if(sortingDirection.equals("up")) {
					
					CountingComparator<Double> comp = new CountingComparator(new ComparatorDenominator(epsilon));
					quicker.sort(randomNumberArray, comp);
					counter = comp.getCounter();	
				}
				
				else {
					
					CountingComparator<Double> comp = new CountingComparator(new ComparatorInverse(new ComparatorDenominator(epsilon)));
					quicker.sort(randomNumberArray, comp);
					counter = comp.getCounter();
				}
				
				break;

			default: System.out.println("This doesn't work!");
					 
				break;
			}
			
			/**
			 * Array for Denominators.
			 */
			ComparatorDenominator denomComp = new ComparatorDenominator(epsilon);
			int[] denominatorArray = new int[amountOfRandomNumbers];
			for(int i = 0; i < amountOfRandomNumbers; i++) {
				
				denominatorArray[i] = denomComp.denomCalculator(randomNumberArray[i]);
			}
			
			/**
			 * For display output.
			 */
			res2 = "";
			for(int i = 0; i < randomNumberArray.length; i++) {
			
				res2 += "\t" + randomNumberArray[i] + "[" + denominatorArray[i] + "]";
			}
			System.out.println(res2 + "\n \n" + "Vergleichsschritte: " + counter);
		}
		
	}

}
