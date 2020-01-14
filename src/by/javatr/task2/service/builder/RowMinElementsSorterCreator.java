package by.javatr.task2.service.builder;


import by.javatr.task2.service.RowMinElementsSorter;
import by.javatr.task2.service.Sorter;


public class RowMinElementsSorterCreator implements SorterCreator{

	@Override
	public Sorter create() {
		return new RowMinElementsSorter();
	}

}
