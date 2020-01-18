package by.javatr.task3.service.initialization;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class TextInitializator {
	
	public static String initializeByFile(File file) throws FileNotFoundException {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(file);
		StringBuilder text = new StringBuilder();
		
		
		while(scanner.hasNextLine()) {
			text.append(scanner.nextLine());
		}
		
		return text.toString();
	}
	
	public static String initializeByConsole() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String text = null;
		
		text = scanner.nextLine();
		
		return text;
	}

}
