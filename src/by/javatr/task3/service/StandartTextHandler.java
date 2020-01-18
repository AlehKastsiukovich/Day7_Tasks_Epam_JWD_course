package by.javatr.task3.service;


import by.javatr.task3.service.exception.TextHandlerException;
import by.javatr.task3.service.validator.TextHandlerValidator;


public class StandartTextHandler implements TextHandler{
	public static final String SPLITTER = "[\\s\\.\\!\\,\\-]";
	
	@Override
	public String replaceAllCharactersByIndex(String text, char character, int index) throws TextHandlerException {
		if (!TextHandlerValidator.isValitText(text)) {
			throw new TextHandlerException("You enter null text!");
		}
		
		if (!TextHandlerValidator.isValidNumber(index)) {
			throw new TextHandlerException("You enter wrong index! Index must be >= 0");
		}
		
		String[] textArray = text.split(SPLITTER);

		for (String str : textArray) {

			if (index < str.length()) {
				char[] charArray = str.toCharArray();
				charArray[index] = character;
				text = text.replace(str, new String(charArray));
			}
		}

		return text;
	}
	
	@Override
	public String correctMistake(String text) throws TextHandlerException {
		if (!TextHandlerValidator.isValitText(text)) {
			throw new TextHandlerException("You enter null text!");
		}
		
		char[] array = text.toCharArray();

		for (int i = 0; i < array.length - 1; i++) {

			if (array[i] == 'p' & array[i + 1] == 'a') {
				array[i + 1] = 'o';
			}
		}

		return new String(array);
	}
	
	@Override
	public String replaceWordBySubstring(String text, String substring, int length) throws TextHandlerException {
		if (!TextHandlerValidator.isValitText(text)) {
			throw new TextHandlerException("You enter null text!");
		}
		
		if (!TextHandlerValidator.isValidNumber(length)) {
			throw new TextHandlerException("You enter wrong length! Length must be > 0");
		}
		
		String[] textArray = text.split(SPLITTER);

		for (String str : textArray) {

			if (str.length() == length) {
				text = text.replaceFirst(str, substring);
			}
		}

		return text;

	}
	
	@Override
	public String removeAllNonLettersAndSpaces(String text) throws TextHandlerException {
		if (!TextHandlerValidator.isValitText(text)) {
			throw new TextHandlerException("You enter null text!");
		}
		
		StringBuilder sBuilder = new StringBuilder();

		char[] ch = text.toCharArray();

		for (Character character : ch) {

			if (Character.isLetter(character) | character == ' ') {
				sBuilder.append(character);
			}
		}

		return sBuilder.toString();
	}
	
	@Override
	public String removeAllWordsBeginningConsonant(String text, int length) throws TextHandlerException {
		if (!TextHandlerValidator.isValitText(text)) {
			throw new TextHandlerException("You enter null text!");
		}
		
		if (!TextHandlerValidator.isValidNumber(length)) {
			throw new TextHandlerException("You enter wrong length! Length must be > 0");
		}
		
		String[] textArray = text.split(SPLITTER);

		for (String str : textArray) {

			if (str.length() == length & isConsonant(str.charAt(0))) {
				text = text.replaceFirst(str, "");
			}
		}

		return text;
	}

	private boolean isConsonant(char character) {
		switch (Character.toLowerCase(character)) {
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u':
		case 'y':
			return false;
		default:
			return true;
		}
	}
}
