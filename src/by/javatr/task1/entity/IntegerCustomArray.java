package by.javatr.task1.entity;


import by.javatr.task1.entity.exception.IllegalArrayLengthException;
import by.javatr.task1.entity.exception.IndexOutOfRangeException;
import by.javatr.task1.entity.exception.NullEntryParametrException;
import by.javatr.task1.entity.validator.Validator;


public class IntegerCustomArray {
	private final static int DEFAULT_CAPACITY = 10;
	private final int[] elements;
	private final int length;

	public IntegerCustomArray() {
		length = DEFAULT_CAPACITY;
		elements = new int[DEFAULT_CAPACITY];
	}

	public IntegerCustomArray(int length) throws IllegalArrayLengthException {
		if (!Validator.isValidLength(length)) {
			throw new IllegalArrayLengthException("Array length must be > 0!");
		}

		this.length = length;
		elements = new int[length];
	}

	public IntegerCustomArray(int[] elements) throws NullEntryParametrException {
		if (elements == null) {
			throw new NullEntryParametrException("Entry parametr must be intialized!");
		}

		length = elements.length;
		this.elements = elements;
	}

	public int[] getElements() {
		return elements;
	}

	public int getLength() {
		return length;
	}

	public int get(int index) throws IndexOutOfRangeException {
		if (!Validator.isValidIndexRange(index, length)) {
			throw new IndexOutOfRangeException("Index out of arrays length!");
		}

		return elements[index];
	}

	public boolean setElement(int index, int value) throws IndexOutOfRangeException {
		if (!Validator.isValidIndexRange(index, length)) {
			throw new IndexOutOfRangeException("Index out of arrays length!");
		}

		elements[index] = value;

		return true;
	}

	public boolean isEmpty() {
		return length == 0;
	}

	public boolean addAll(int[] array) throws NullEntryParametrException, IllegalArrayLengthException {
		if (array == null) {
			throw new NullEntryParametrException("Entry parametr must be intialized!");
		}

		if (this.length != array.length) {
			throw new IllegalArrayLengthException("Entry array length must be same with our array length!");
		}

		for (int i = 0; i < elements.length; i++) {
			elements[i] = array[i];
		}

		return false;
	}

	public boolean contains(int value) {
		for (Integer val : elements) {
			if (val.equals(value)) {
				return true;
			}
		}

		return false;
	}

	public void bubbleSort() {
		boolean isSorted = false;
		int temp;

		while (!isSorted) {
			isSorted = true;

			for (int i = 0; i < elements.length - 1; i++) {

				if (elements[i] > elements[i + 1]) {
					isSorted = false;
					temp = elements[i];
					elements[i] = elements[i + 1];
					elements[i + 1] = temp;
				}
			}
		}
	}

	public void shellSort() {
		int step = elements.length / 2;

		while (step > 0) {

			for (int i = 0; i < (elements.length - step); i++) {
				int j = i;

				while ((j >= 0) && (elements[j] > elements[j + step])) {
					int temp = elements[j];
					elements[j] = elements[j + step];
					elements[j + step] = temp;
					j -= step;
				}
			}

			step = step / 2;
		}
	}

	public int binarySearch(int low, int high, int value) {
		if (low == high) {
			return low;
		}

		int mid = low + ((high - low) / 2);

		if (value > elements[mid]) {
			return binarySearch(mid + 1, high, value);
		} else if (value < elements[mid]) {
			return binarySearch(low, mid, value);
		}

		return mid;
	}

	public void binaryInsertionSort() {
		for (int i = 1; i < elements.length; i++) {
			int ins = binarySearch(0, i, elements[i]);
			int value = elements[i];
			int j = i - 1;

			while (j >= ins) {
				int temp = elements[j + 1];
				elements[j + 1] = elements[j];
				elements[j] = temp;
				j--;
			}

			elements[ins] = value;
		}
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = hash * 31 + (int) length;
		hash = hash * 31 + elementsHashCode(elements);

		return hash;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (this.getClass() != o.getClass())
			return false;
		IntegerCustomArray otherArray = (IntegerCustomArray) o;
		if (this.length != otherArray.length)
			return false;
		if (!intArraysEquals(this.elements, otherArray.elements))
			return false;
		return true;
	}

	@Override
	public String toString() {
		if (elements == null)
			return null;
		if (length == 0)
			return "[]";

		StringBuilder sb = new StringBuilder();
		int maxIndex = length - 1;
		sb.append("[");

		for (int i = 0; i < length; i++) {
			sb.append(elements[i]);

			if (i == maxIndex) {
				sb.append("]");
				continue;
			}

			sb.append(", ");
		}

		return sb.toString();
	}

	private int elementsHashCode(int[] array) {
		if (array == null)
			return 0;

		int result = 1;
		for (int element : array)
			result = 31 * result + element;

		return result;
	}

	private boolean intArraysEquals(int[] arr1, int[] arr2) {
		if (arr1 == arr2)
			return true;
		if (arr1 == null || arr2 == null)
			return false;
		if (arr1.length != arr2.length)
			return false;
		if (!isSameElements(arr1, arr2))
			return false;
		return true;
	}

	private boolean isSameElements(int[] arr1, int[] arr2) {
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}

		return true;
	}
}
