package by.javatr.task3.service;

import by.javatr.task3.service.exception.TextHandlerException;

public interface TextHandler {

	String replaceAllCharactersByIndex(String text, char character, int index) throws TextHandlerException;
	
	String correctMistake(String text) throws TextHandlerException;
	
	String replaceWordBySubstring(String text, String substring, int length) throws TextHandlerException;
	
	String removeAllNonLettersAndSpaces(String text) throws TextHandlerException;
	
	String removeAllWordsBeginningConsonant(String text, int length) throws TextHandlerException;
}
