package by.javatr.task2.service;


import by.javatr.task2.service.exception.SorterException;


public abstract class Sorter {
	
	public abstract void sort(int[][] jaggedArray) throws SorterException;
	
	public int[] bubbleSort(int[] arr) {
		boolean isSorted = false;
		int temp;

		while (!isSorted) {
			isSorted = true;

			for (int i = 0; i < arr.length - 1; i++) {

				if (arr[i] > arr[i + 1]) {
					isSorted = false;
					temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
		}

		return arr;
	}
	
	public void swap(int[] arr, int[][] jagArray, int i) {
		int[] temp;
		int numTmp;

		temp = jagArray[i];
		numTmp = arr[i];
		
		jagArray[i] = jagArray[i + 1];
		arr[i] = arr[i + 1];
		jagArray[i + 1] = temp;
		arr[i + 1] = numTmp;
	}
	
	public void decreaseSort(int[] arr, int[][] jagArray) {
		boolean isSorted = false;

		while (!isSorted) {
			isSorted = true;

			for (int i = 0; i < arr.length - 1; i++) {

				if (arr[i] < arr[i + 1]) {
					isSorted = false;
					swap(arr, jagArray, i);
				}
			}
		}
	}
	
	public void increaseSort(int[] arr, int[][] jagArray) {
		boolean isSorted = false;

		while (!isSorted) {
			isSorted = true;

			for (int i = 0; i < arr.length - 1; i++) {

				if (arr[i] > arr[i + 1]) {
					isSorted = false;
					swap(arr, jagArray, i);
				}
			}
		}
	}
	
	public int[] copyArray(int[] arr) {
		int[] tempArray = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			tempArray[i] = arr[i];
		}

		return tempArray;
	}
	
	
}
