package by.javatr.task1.entity;

import by.javatr.task1.entity.exception.IllegalArrayLengthException;
import by.javatr.task1.entity.exception.IndexOutOfRangeException;
import by.javatr.task1.entity.exception.NullEntryParametrException;

public interface AbstractArray<E> {

	E get(int index) throws IndexOutOfRangeException;

	boolean isEmpty();

	boolean setElement(int index, E e) throws IndexOutOfRangeException, NullEntryParametrException;

	boolean addAll(E[] e) throws NullEntryParametrException, IllegalArrayLengthException;
	
	boolean contains(E e) throws NullEntryParametrException;

}
