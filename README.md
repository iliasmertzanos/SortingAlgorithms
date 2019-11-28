# SortingAlgorithms

This java code was developed during my master degree studies within a project team. <br>
The package provides three sorting algorithms:

  - Merge sort
  - Quick sort
  - Selection sort
  
Each algorithm takes as an argument, instance of `Comparator<T>` 
in the method `public void sort(T[] data, Comparator<T> comp)` 
which is being inherrited from the class `SortAlgorithm<T>`:

  - `ComparatorDenominator implements Comparator<Double> `, compares on the lowest common denominator
  - `ComparatorDigitSum implements Comparator<Integer>`, compares the number of digits
  - `ComparatorInverse implements Comparator<T>`, takes an other comparator and inverses its comparison function
  - `ComparatorSize implements Comparator<Integer>`, compares integers
  - `CountingComparator implements Comparator<T>`, takes an other comparator, makes the same comparison but it keeps an internal counter to store the other comparator's 
	 compare method calls. 
  
  It then uses this comparator to accordingly sort the elements in the data array.  
  
  The algorithms can be tested in the `Start` class, which has only a main method that expects following arguments:
  
  - `String numbersOfrandoms = args[0];` (number of random numbers to be generated)
  - `String sortingAlgorithm = args[1];` (which algorithm to use)
  - `String sortingDirection = args[2];` (ascending ot descending)
  - `String sortingComparator = args[3];` (comparator to use during sorting)
  
  For specific information see the source code comments. For german speakers see also the task description in the src folder.
