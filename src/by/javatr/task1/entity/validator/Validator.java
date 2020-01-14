package by.javatr.task1.entity.validator;


public class Validator {
	
	public static boolean isValidLength(int length) {
		return length > 0;
	}
	
	public static boolean isValidIndexRange(int index, int length) {
		return  (index >= 0 & index <= length - 1); 
	}
	
}
