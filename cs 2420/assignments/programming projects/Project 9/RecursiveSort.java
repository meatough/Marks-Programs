/*********************************************************** 
 * Programming Assignment 9
 * Recursive method program
 * Programmer: Mark Eatough
 * Course: CS 2410 
 * Created:		March 25, 2013
 * Modified:	April 1, 2013	 
 * Modified by Mark Eatough
 ***********************************************************/
import java.util.ArrayList;

public class RecursiveSort extends SinglyLinkedList
{
	private static void internalMergeSort(int [] myArray, int [] tempArray, 
													int first, int last)
	{
		if((last - first + 1) <=1)
			return;
				
		int mid = ((first+last+1)/2);
		internalMergeSort(myArray, tempArray, first, mid -1);
		internalMergeSort(myArray, tempArray, mid, last);
		merge(myArray, tempArray, first, mid, last);
	}
		
	public static void mergeSort(int [] myArray)
	{
		int tempArray[] = new int[myArray.length/2];
		internalMergeSort(myArray, tempArray, 0, myArray.length-1);
	}
		
	private static void merge(int [] myArray, int [] tempArray, 
												int first, int mid, int last)
	{
		int 	tempSize = last - first + 1,
				insertIndex = first,
				firstPartitionIndex = 0,
				secondPartitionIndex = mid;
			
		//copy ower partition to temp array
		System.arraycopy(myArray, first, tempArray, 0, mid - first);
		
		//while neither parittion is empty
		while((firstPartitionIndex < (mid-first)) &&
				(secondPartitionIndex <= last))
		{
			//merge partitions into myArray from positions first to last
			if(tempArray[firstPartitionIndex] < myArray[secondPartitionIndex])
			{
				myArray[insertIndex] = tempArray[firstPartitionIndex];
				firstPartitionIndex++;
			}
			else
			{
				myArray[insertIndex] = myArray[secondPartitionIndex];
				secondPartitionIndex++;
			}
			insertIndex++;
		}//end while loop
			
		while(firstPartitionIndex < (mid - first))
		{
			myArray[insertIndex] = tempArray[firstPartitionIndex];
			firstPartitionIndex++;
			insertIndex++;
		}
	}
		
}//end recursive sort class

