package by.javatr.task2.service.builder;


import by.javatr.task2.service.RowMaxSumSorter;
import by.javatr.task2.service.Sorter;


public class RowMaxSumSorterCreator implements SorterCreator {

	@Override
	public Sorter create() {
		return new RowMaxSumSorter();
	}

	
	
	
}
