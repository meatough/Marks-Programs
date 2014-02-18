/*********************************************************** 
 * Programming Assignment 8
 * Recursive method program
 * Programmer: Mark Eatough
 * Course: CS 2410 
 * Created
 * Modified 
 * Modified by Mark Eatough
 ***********************************************************/
 
public class RecursiveMethod extends SinglyLinkedList
{
	public void reversePrint(SinglyLinkedList myList)
	{
		int myLength = myList.getLength();
		myList.recursiveMethod(myLength);
	}
 
}//end recursive method class