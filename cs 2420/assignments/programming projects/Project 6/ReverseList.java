/*********************************************************** 
 * Programming Assignment 6
 * Stack Operations program
 * Programmer: Mark Eatough
 * Course: CS 2410 
 * Created March 4, 2013
 * Modified March 6, 2013
 * Modified by Mark Eatough
 ***********************************************************/

import java.util.LinkedList;
import java.util.List;
import java.util.EmptyStackException;
import java.util.ArrayList;

/**
 * An implementation of the Stack interface using a List as the
 *  underlying data structure.
 */
public class ReverseList 
{		
	public <E> void reverseList(ArrayList<E> aList)
	{
		Stack <E> stack = new ListStack <E>();
		
		for(E e: aList)
		{
			stack.push(e);
		}
		aList.clear();
		
		while(stack.isEmpty() != true)
		{
			aList.add(stack.pop());
		}
	}//end reverseList method
}//end ReverseList class