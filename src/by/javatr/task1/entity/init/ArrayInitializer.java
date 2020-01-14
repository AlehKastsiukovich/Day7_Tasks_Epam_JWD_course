package by.javatr.task1.entity.init;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;


public class ArrayInitializer {

	public static boolean initByRandomNumbers(int[] arr) {
		if (!checkArray(arr)) {
			return false;
		}

		Random random = new Random();

		for (int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt();
		}

		return true;
	}

	public static boolean initByConsole(int[] arr) {
		if (!checkArray(arr)) {
			return false;
		}

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		fillArray(arr, scanner);

		return true;
	}

	public static boolean initByFile(int[] arr, File file) throws FileNotFoundException {
		if (!checkArray(arr)) {
			return false;
		}

		if (file == null) {
			throw new FileNotFoundException();
		}

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(file);

		fillArray(arr, scanner);

		return true;

	}

	private static void fillArray(int[] arr, Scanner scanner) {
		for (int i = 0; i < arr.length; i++) {

			while (!scanner.hasNextInt()) {
				scanner.next();
			}

			arr[i] = scanner.nextInt();
		}
	}

	private static boolean checkArray(int[] arr) {
		if (arr == null) {
			throw new NullPointerException();
		}

		if (arr.length == 0) {
			return false;
		}

		return true;
	}
}
