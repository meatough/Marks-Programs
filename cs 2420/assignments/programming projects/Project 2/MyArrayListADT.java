 /*********************************************************** 
 * Programming Assignment 2
 * Array program
 * Programmer: Mark Eatough
 * Course: CS 2420 
 * Created February 4, 2013
 * Modified February 11, 2013
 * Modified by Mark Eatough
 ***********************************************************/

import java.util.Scanner;

public class MyArrayListADT<E>
{
	//private fields
	private E[] elementArray;
	private E element;
	private int numElements;
	private int capacity;
	private int cursor;
	private int position;
	private final int Default_Capacity = 10;
	Scanner input = new Scanner(System.in);	
	//Default Constructor
	public MyArrayListADT()
	{
		this.element = null;
		this.capacity = Default_Capacity;
		this.elementArray = (E[]) new Object[capacity];
		this.numElements = 0;
	}
	
	//Parameterized Constructor
	public MyArrayListADT(int capacity)
	{
		this.element = null;
		this.capacity = capacity;
		this.elementArray = (E[]) new Object[capacity];
		this.numElements = 0;
	}
	
	//Methods
	public void traverse()
	{
		for(int i = 0; i < capacity-1; i++)
		{
			System.out.print("\n\nenter 1 to go foreward, or any other key to exit ");
			cursor = input.nextInt();

			if(cursor == 1)
			{
				System.out.println(elementArray[i]);
			}
			else
			{
				break;
			}
		}
	}
	
  	public int getNumElements()//working final
	{
		System.out.printf("%d\n\n", numElements);
		return numElements;
	}
	
	public int getCapacity()//working final
	{
		
		System.out.printf("%d\n\n", capacity);
		return capacity;		
	}
	
	public void resize(int newCap)//working final
	{
		if(newCap > capacity)
		{
			capacity = newCap;
		}
		else
		{
			if(newCap < numElements)
			{
				newCap = numElements;
				capacity = newCap;
			}
			else
			{
				capacity = newCap;
			}
		}
		
		E[]temp = (E[]) new Object [newCap];
		
		if(capacity < elementArray.length)
		{
			for(int i = 0; i < capacity; i++)
			{
				temp[i] = elementArray[i];
			}
		}
		else
		{
			for(int i = 0; i < elementArray.length; i++)
			{
				temp[i] = elementArray[i];
			}
		}
		elementArray = temp;
	}
	
	public void replacePosition(int pos, E value)//working final
	{
			if(pos < 1 || pos > numElements)
			{
				insertEnd(value);		
			}
			else
			{
				elementArray[pos-1] = value;
			}
	}
	
	public void replaceValue(E oldValue, E newValue)//working final
	{
		for(int i = 0; i<elementArray.length; i++)
		{
			if(elementArray[i] == oldValue)
			{
				elementArray[i] = newValue;
			}
		}
	}
	
	public void insertAnywhere(int pos, E value)//Test
	{
		if(numElements >= capacity)
		{
			resize(capacity++);
		}
		
		if(pos < 1 || pos > numElements)
		{
			insertEnd(value);		
		}

		
		else
		{ 
			if(numElements >=capacity)
			{
				resize(capacity++);
			}
			
			
			for (int i = numElements; i > pos-1; i--)
			{
				elementArray[i] = elementArray[i - 1];
			}
			elementArray[pos-1] = value;
		}
		
		numElements++;
	}
	
	public void insertEnd(E value)//Test
	{
		if(numElements >= capacity)
		{
			resize(capacity++);
		}

		elementArray[numElements] = value;
			
		numElements++;
	}
	
	public void deletePosition(int pos)//Test
	{
		if(pos < 1 || pos > numElements-1)
		{
			System.out.print("There is no element at this position");
		}
		else
		{
			for (int i = pos - 1; i < elementArray.length-1; i++)
			{
				elementArray[i] = elementArray[i + 1];
			}
			numElements--;
		}
	}
	
	public void deleteValue(E value)//working final
	{
		for(int i = 0; i<elementArray.length-1; i++)
		{
			if(elementArray[i] == value)
			{
				position = i;
				for (int k = position; k < elementArray.length-1; k++)
				{
					elementArray[k] = elementArray[k + 1];
				}
				numElements--;
			}
		}
	}
	
	public E getElement(int pos)//Test
	{ 	
		if(pos < 1 || pos > numElements-1)
		{
			System.out.print("There is no element at this position");
			return null;
		}
		else
		{
			System.out.print(elementArray[pos-1]);
			return element;
		}
	}
	
	public int getIndexOf(E value)//working final
	{
		for(int i = 0; i<elementArray.length; i++)
		{
			if(elementArray[i] == value)
			{
				position = i+1;
				System.out.print(position);
			}
		}
		return position;
	}
	
	public void printArray()//working final
	{
		for(int i = 0; i<elementArray.length; i++)
		{
			System.out.print(elementArray[i]);
			System.out.println();
		}
		System.out.println();
	}
}//end class