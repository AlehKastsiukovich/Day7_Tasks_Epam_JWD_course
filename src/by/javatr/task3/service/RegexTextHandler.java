package by.javatr.task3.service;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
import by.javatr.task3.service.exception.TextHandlerException;
import by.javatr.task3.service.validator.TextHandlerValidator;


public class RegexTextHandler implements TextHandler {
	
	@Override
	public String replaceAllCharactersByIndex(String text, char character, int index) throws TextHandlerException {
		if (!TextHandlerValidator.isValitText(text)) {
			throw new TextHandlerException("You enter null text!");
		}
		
		if (!TextHandlerValidator.isValidNumber(index)) {
			throw new TextHandlerException("You enter wrong length! Length must be > 0");
		}
		
		Pattern pattern = Pattern.compile("\\b\\w{" + (index + 1) + ",}\\b");
		Matcher matcher = pattern.matcher(text);

		while (matcher.find()) {
			String oldWord = matcher.group();
			String newWord = oldWord.replace(oldWord.charAt(index), character);
			text = text.replaceAll(oldWord, newWord);
		}

		return text;
	}
	
	@Override
	public String correctMistake(String text) throws TextHandlerException {
		if (!TextHandlerValidator.isValitText(text)) {
			throw new TextHandlerException("You enter null text!");
		}
		
		Pattern pattern = Pattern.compile("pa");
		Matcher matcher = pattern.matcher(text);

		return matcher.replaceAll("po");
	}
	
	@Override
	public String replaceWordBySubstring(String text, String substring, int length) throws TextHandlerException {
		if (!TextHandlerValidator.isValitText(text)) {
			throw new TextHandlerException("You enter null text!");
		}
		
		if (!TextHandlerValidator.isValidNumber(length)) {
			throw new TextHandlerException("You enter wrong length! Length must be > 0");
		}
		
		Pattern pattern = Pattern.compile("\\b\\w{" + length + "}\\b");
		Matcher matcher = pattern.matcher(text);

		return matcher.replaceAll(substring);
	}
	
	@Override
	public String removeAllNonLettersAndSpaces(String text) throws TextHandlerException {
		if (!TextHandlerValidator.isValitText(text)) {
			throw new TextHandlerException("You enter null text!");
		}
		
		Pattern pattern = Pattern.compile("[^a-zA-z\\s]");
		Matcher matcher = pattern.matcher(text);

		return matcher.replaceAll("");
	}
	
	@Override
	public String removeAllWordsBeginningConsonant(String text, int length) throws TextHandlerException {
		if (!TextHandlerValidator.isValitText(text)) {
			throw new TextHandlerException("You enter null text!");
		}
		
		if (!TextHandlerValidator.isValidNumber(length)) {
			throw new TextHandlerException("You enter wrong length! Length must be > 0");
		}
		
		Pattern pattern = Pattern.compile("\\b\\w{5,5}\\b");
		Matcher matcher = pattern.matcher(text);

		return matcher.replaceAll("");
	}
}
