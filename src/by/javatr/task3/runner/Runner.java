package by.javatr.task3.runner;


import java.io.File;
import java.io.FileNotFoundException;
import by.javatr.task3.service.RegexTextHandler;
import by.javatr.task3.service.StandartTextHandler;
import by.javatr.task3.service.TextHandler;
import by.javatr.task3.service.exception.TextHandlerException;
import by.javatr.task3.service.initialization.TextInitializator;


public class Runner {
	
	public static void main(String[] args) {
		
        String text = "Hello, java world and my friends!";
        
		TextHandler standartHandler = new StandartTextHandler();
		
		TextHandler regHandler = new RegexTextHandler();
		
		try {
			System.out.println(regHandler.replaceAllCharactersByIndex(text, 'g', 5));
		} catch (TextHandlerException e1) {
			e1.printStackTrace();
		}
		try {
			System.out.println(standartHandler.replaceAllCharactersByIndex(text, 'g', 5));
		} catch (TextHandlerException e1) {
			e1.printStackTrace();
		}
		
		File file = new File("java.txt");
		
		String text1 = null;
		try {
			text1 = TextInitializator.initializeByFile(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(text1);
		
		String text2 = TextInitializator.initializeByConsole();
		
		System.out.println(text2);
	}
}
