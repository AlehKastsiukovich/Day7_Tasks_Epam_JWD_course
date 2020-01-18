package by.javatr.task1.service;


import java.util.ArrayList;
import java.util.List;
import by.javatr.task1.entity.IntegerCustomArray;
import by.javatr.task1.entity.exception.NullEntryParametrException;
import by.javatr.task1.service.exception.ServiceException;


public class IntegerCustomArrayService {
	private static IntegerCustomArrayService instance;
 	
	private IntegerCustomArrayService() {
	}
	
	public static IntegerCustomArrayService getIntegerCustomArrayService() {
		if (instance == null) {
			return new IntegerCustomArrayService();
		}
		
		return instance;
	}

	public int findMaxElement(IntegerCustomArray arr) {
		arr.bubbleSort();

		return arr.getElements()[arr.getLength() - 1];
	}

	public int findMinElement(IntegerCustomArray arr) {
		arr.bubbleSort();

		return arr.getElements()[0];
	}

	public IntegerCustomArray findSimpleNumbers(IntegerCustomArray arr) throws ServiceException {
		List<Integer> list = new ArrayList<>();
	
		for (int i = 0; i < arr.getLength(); i++) {
			if (isSimple(arr.getElements()[i])) {
				list.add(arr.getElements()[i]);
			}
		}
		
		int[] arrayOfSimpleNumbers = copyArray(list);
		
		IntegerCustomArray array;
		
		try {
			array = new IntegerCustomArray(arrayOfSimpleNumbers);
		} catch (NullEntryParametrException e) {
			throw new ServiceException();
		}
		
		return array;
	}

	public IntegerCustomArray findThreeDigitNumbers(IntegerCustomArray arr) throws ServiceException {
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < arr.getLength(); i++) {
			if (isThreeDigitNumber(arr.getElements()[i])) {
				list.add(arr.getElements()[i]);
			}
		}

		int[] arrayWithThreeDigitNumbers = copyArray(list);

		IntegerCustomArray array;

		try {
			array = new IntegerCustomArray(arrayWithThreeDigitNumbers);
		} catch (NullEntryParametrException e) {
			throw new ServiceException();
		}

		return array;
	}
	
	public IntegerCustomArray findFibonacciNumbers(IntegerCustomArray arr) throws ServiceException {
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < arr.getLength(); i++) {

			if (isFibonacci(arr.getElements()[i])) {
				list.add(arr.getElements()[i]);
			}
		}
		
		int[] arrayWithFibonacciNumbers = copyArray(list);

		IntegerCustomArray array;
		
		try {
			array = new IntegerCustomArray(arrayWithFibonacciNumbers);
		} catch (NullEntryParametrException e) {
			throw new ServiceException();
		}
		
		return array;
	}

	private boolean isThreeDigitNumber(int number) {
		String parseNumber = String.valueOf(number);

		return parseNumber.length() == 3;
	}

	private boolean isFibonacci(int number) {
		int fib;
		int n1 = 0;
		int n2 = 1;

		while (true) {
			fib = n1 + n2;
			
			if (fib > number) {
				return false;
			}
			
			if (number == fib) {
				return true;
			}
			
			n1 = n2;
			n2 = fib;
		}
	}

	private boolean isSimple(int number) {
		if (number < 8) {

			for (int i = 0; i < number; i++) {
				if (number % i == 0) {
					return false;
				}

				return true;
			}
		}

		return number % 2 != 0 && number % 3 != 0 && number % 5 != 0 && number % 7 != 0;
	}
	
	private int[] copyArray(List<Integer> list) {
		int[] tempArray = new int[list.size()];

		for (int i = 0; i < list.size(); i++) {
			tempArray[i] = list.get(i);
		}
		
		return tempArray;
	}

}
