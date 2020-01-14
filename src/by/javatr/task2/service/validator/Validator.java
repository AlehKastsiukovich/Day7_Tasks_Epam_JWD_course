package by.javatr.task2.service.validator;


public class Validator {
	
	public static boolean isValidArray(int[][] array) {
		if (array == null) {
			return false;
		}
		
		if (array.length == 0) {
			return false;
		}
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] == null && array[i].length == 0) {
				return false;
			}
		}
		
		return true;
	}
}
