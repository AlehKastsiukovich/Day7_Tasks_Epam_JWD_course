package by.javatr.task2.runner;


import java.util.Random;
import by.javatr.task2.service.RowMinElementsSorter;
import by.javatr.task2.service.Sorter;
import by.javatr.task2.service.exception.SorterException;


public class Runner {

	public static void main(String[] args) {
		int[][] array = new int[3][];
		
		array[0] = new int[3];
		array[1] = new int[5];
		array[2] = new int[10];

		Random random = new Random();

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = random.nextInt(100) - 50;
			}
		}

		Sorter sorter = new RowMinElementsSorter();
		
		try {
			sorter.sort(array);
		} catch (SorterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}