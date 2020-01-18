package by.javatr.task3.service.validator;


public class TextHandlerValidator {
	
	public static boolean isValitText(String text) {
		return text != null;
	}
	
	public static boolean isValidNumber(int value) {
		return value >= 0;
	}
}
