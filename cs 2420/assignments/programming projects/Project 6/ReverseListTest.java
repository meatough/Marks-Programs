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
public class ReverseListTest
{
	public static void main(String[] args)
  	{
		ReverseList myLists = new ReverseList();
		
		//create an arraylist of strings
		ArrayList <String> movies = new ArrayList<String>();
		{
			movies.add("Looper");
			movies.add("Insomnia");
			movies.add("Inception");
			movies.add("Mind Hunters");
			movies.add("Memento");
		}
		
		//create an arraylist of intergers
		ArrayList <Integer> years = new ArrayList<Integer>();
		{
			years.add(1492);
			years.add(1776);
			years.add(1860);
			years.add(1940);
			years.add(1986);
		}
		
		//print out array list of strings
		System.out.println("List of movies: \n");
		for (String m : movies)
      {
      	System.out.printf("%s \n", m);
     	}
		
		//reverse order of array list using a stack
		myLists.reverseList(movies);
		
		//print out array of strings in reversed order
		System.out.println("\nReversed list of movies: \n");
		for (String m : movies)
      {
      	System.out.printf("%s \n", m);
     	}
		
		//print out array list of integers
		System.out.println("\n\nList of years: \n");
		for (int y : years)
      {
      	System.out.printf("%d \n", y);
     	}
		
		//reverse order of array list using a stack
		myLists.reverseList(years);
		
		//print out array of integers in reversed order
		System.out.println("\nReversed list of years: \n");
		for (int y : years)
      {
      	System.out.printf("%d \n", y);
     	}
	}//end main method
}//end ReverseListTest class