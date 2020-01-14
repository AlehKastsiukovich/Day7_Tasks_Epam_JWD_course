package by.javatr.task2.service.builder;


import by.javatr.task2.service.RowMaxElementsSorter;
import by.javatr.task2.service.Sorter;


public class RowMaxElementsSorterCreator implements SorterCreator{

	@Override
	public Sorter create() {
		return new RowMaxElementsSorter();
	}
}
