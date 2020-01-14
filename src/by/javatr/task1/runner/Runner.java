package by.javatr.task1.runner;


import by.javatr.task1.entity.IntegerCustomArray;
import by.javatr.task1.entity.exception.NullEntryParametrException;
import by.javatr.task1.entity.init.ArrayInitializer;
import by.javatr.task1.service.IntegerCustomArrayService;
import by.javatr.task1.service.exception.ServiceException;


public class Runner {

	public static void main(String[] args) {
		int[] array1 = {-100, 9, 3, 200, -1, 199};
		
		IntegerCustomArray custArr = null;
		
		try {
			custArr = new IntegerCustomArray(array1);
		} catch (NullEntryParametrException e1) {
			e1.printStackTrace();
		}
		
		IntegerCustomArray custArr2 = new IntegerCustomArray();
		
		ArrayInitializer.initByConsole(custArr2.getElements());

		IntegerCustomArrayService is = IntegerCustomArrayService.getIntegerCustomArrayService();
	
		try {
			is.findFibonacciNumbers(custArr);
		} catch (ServiceException e) {
			e.printStackTrace();
		}	
	}
}
