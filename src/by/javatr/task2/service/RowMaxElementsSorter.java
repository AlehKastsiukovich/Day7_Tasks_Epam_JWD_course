package by.javatr.task2.service;


import by.javatr.task2.service.exception.SorterException;
import by.javatr.task2.service.validator.Validator;


public class RowMaxElementsSorter extends Sorter {

	@Override
	public void sort(int[][] jaggedArray) throws SorterException {
		if(!Validator.isValidArray(jaggedArray)) {
			throw new SorterException("Array initialized wrong!");
		}
		
		int[] arr = findRowMaximum(jaggedArray);

		increaseSort(arr, jaggedArray);

	}

	private int[] findRowMaximum(int[][] jagArray) {
		int[] rowMaxElements = new int[jagArray.length];
		int[] tmp;

		for (int i = 0; i < jagArray.length; i++) {
			tmp = copyArray(jagArray[i]);
			bubbleSort(tmp);

			rowMaxElements[i] = tmp[jagArray[i].length - 1];
		}

		return rowMaxElements;
	}
}
