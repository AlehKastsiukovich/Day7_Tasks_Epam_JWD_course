package by.javatr.task2.service;


import by.javatr.task2.service.exception.SorterException;
import by.javatr.task2.service.validator.Validator;


public class RowMaxSumSorter extends Sorter {

	@Override
	public void sort(int[][] jaggedArray) throws SorterException {
		if(!Validator.isValidArray(jaggedArray)) {
			throw new SorterException("Array initialized wrong!");
		}
		
		int[] arr = findAllRowsSum(jaggedArray);

		increaseSort(arr, jaggedArray);

	}

	private int[] findAllRowsSum(int[][] jagArray) {
		int[] sumsArray = new int[jagArray.length];

		for (int i = 0; i < jagArray.length; i++) {

			sumsArray[i] = findRowElementsSum(jagArray[i]);
		}

		return sumsArray;
	}

	private int findRowElementsSum(int[] arr) {
		int sum = 0;

		for (int elem : arr) {
			sum += elem;
		}

		return sum;
	}
}
