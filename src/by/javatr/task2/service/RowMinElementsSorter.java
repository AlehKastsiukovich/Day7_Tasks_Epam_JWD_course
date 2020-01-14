package by.javatr.task2.service;


import by.javatr.task2.service.exception.SorterException;
import by.javatr.task2.service.validator.Validator;


public class RowMinElementsSorter extends Sorter {

	@Override
	public void sort(int[][] jaggedArray) throws SorterException {
		if(!Validator.isValidArray(jaggedArray)) {
			throw new SorterException("Array initialized wrong!");
		}
	
		int[] arr = findRowMinimum(jaggedArray);
		
		decreaseSort(arr, jaggedArray);
		
	}
	
	private int[] findRowMinimum(int[][] jagArray) {
		int[] rowMinElements = new int[jagArray.length];
		int[] tmp;

		for (int i = 0; i < jagArray.length; i++) {
			tmp = copyArray(jagArray[i]);
			bubbleSort(tmp);
			rowMinElements[i] = jagArray[i][0];
		}

		return rowMinElements;
	}
}
