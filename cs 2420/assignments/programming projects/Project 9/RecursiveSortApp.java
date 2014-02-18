/*********************************************************** 
 * Programming Assignment 9
 * Recursive method program
 * Programmer: Mark Eatough
 * Course: CS 2410 
 * Created:		March 25, 2013
 * Modified:	April 1, 2013	 
 * Modified by Mark Eatough
 ***********************************************************/
import java.util.Random;
import java.util.ArrayList;

public class RecursiveSortApp
{
 	public static void main(String[] args)
	{
		Random generator = new Random();
		SinglyLinkedList<Integer> random = new SinglyLinkedList<Integer>();
		//ArrayList<Integer> temp = new ArrayList<Integer>();
		//ArrayList<Integer> temp = new ArrayList<Integer>();
		RecursiveSort recursion = new RecursiveSort();
		
		//populate linked list with 100 random integers between 1 and 1000
		for(int i = 0; i < 100; i++)
		{
			int rand = generator.nextInt(1000) + 1;
			random.add(rand);
		}
		
		//create array object
		int [] sortArray = new int [random.getLength()];
		
		//display unsorted list
		System.out.println("Unsorted list of random numbers: \n\n");
		random.displayList();
			
		//convert linked list into an array
		int listEl = random.getLength();
		for(int j = 0; j < listEl; j++)
		{
			sortArray[j] = random.remove(0);
		}
		
		//sort the array
		//int first = 0;
		//int last = sortArray.length--;
		RecursiveSort.mergeSort(sortArray);
		
		
		//convert array back into linked list
		int arrayEl = sortArray.length;
		for(int k = arrayEl-1; k >= 0; k--)
		{
			random.add(sortArray[k]);
		}
		
		//print sorted linked list
		System.out.println("\n\n\nSorted list of random numbers: \n\n");
		random.displayList();
	}//end main method
}//end RecursiveSortApp