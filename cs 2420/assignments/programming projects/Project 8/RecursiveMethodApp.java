/*********************************************************** 
 * Programming Assignment 8
 * Recursive method program
 * Programmer: Mark Eatough
 * Course: CS 2410 
 * Created:		March 13
 * Modified:	March 25, 2013 
 * Modified by Mark Eatough
 ***********************************************************/
 
public class RecursiveMethodApp
{
	public static void main(String[] args)
	{
		RecursiveMethod myRecursion = new RecursiveMethod();
		
		//Initialize variables to create person object
		Person person;
		String name;
		int age;
	
		//create a singly linked list of strings
		SinglyLinkedList<String> robins = new SinglyLinkedList<String>();
		//populate singly linked list of strings
		robins.add("Damien Wayne");
		robins.add("Stephanie Brown");
		robins.add("Tim Drake");
		robins.add("Jason Todd");
		robins.add("Dick Grayson");
		
		//create singly linked list of Integers
		SinglyLinkedList<Integer> freeThrowPercentages = new SinglyLinkedList<Integer>();
		//populate singly linked list of integers
		freeThrowPercentages.add(92);
		freeThrowPercentages.add(48);
		freeThrowPercentages.add(64);
		freeThrowPercentages.add(73);
		freeThrowPercentages.add(86);
		
		//create singly linked list of people
		SinglyLinkedList<Person> people = new SinglyLinkedList<Person>();
		
		//create first person object
		name = "Mark";
		age = 26;
		person = new Person(name, age);
		//add first person object to people list
		people.add(person);
		
		//create second person object
		name = "Chelsea";
		age = 25;
		person = new Person(name, age);
		//add second person object to people list
		people.add(person);
		
		//create third person object
		name = "Osiris";
		age = 2;
		person = new Person(name, age);
		//add third person object to people list
		people.add(person);
		
		//create fourth person object
		name = "Chris";
		age = 23;
		person = new Person(name, age);
		//add fourth person object to people list
		people.add(person);
		
		//create fifth person object
		name = "Matt";
		age = 21;
		person = new Person(name, age);
		//add fifth person object to people list
		people.add(person);
		
		
		//display lists in order
		System.out.println("Display of lists in order: \n\n");
		robins.displayList();
		freeThrowPercentages.displayList();
		people.displayList();
		
		//display lists in reverse order
		System.out.println("Display of lists in reverse: \n\n");
		myRecursion.reversePrint(robins);
		myRecursion.reversePrint(freeThrowPercentages);
		myRecursion.reversePrint(people);
		
	}//end main method 	
}//end application class