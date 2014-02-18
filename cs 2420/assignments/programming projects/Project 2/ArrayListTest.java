 /*********************************************************** 
 * Programming Assignment 2
 * Array program
 * Programmer: Mark Eatough
 * Course: CS 2410 
 * Created February 4, 2013
 * Modified February 11, 2013
 * Modified by Mark Eatough
 ***********************************************************/

public class ArrayListTest extends MyArrayListADT
{
	public static void main(String[] args)
   {
		//create an integer array list of grades
		MyArrayListADT<Integer> grades = new MyArrayListADT<Integer>();
		//create a string array list of dystopian novels
		MyArrayListADT<String> dystopian = new MyArrayListADT<String>();
		
		//populate grades with scores
		grades.insertEnd(100);
		grades.insertEnd(89);
		grades.insertEnd(73);
		grades.insertEnd(68);
		grades.insertEnd(93);
		grades.insertEnd(78);
		grades.insertEnd(86);
		
		//populate dystopian novels with books
		dystopian.insertEnd("The Hunger Games");
		dystopian.insertEnd("1984");
		dystopian.insertEnd("A Brave New World");
		dystopian.insertEnd("The Giver");
		dystopian.insertEnd("Divergent");
		
		//traverse the arrays
		System.out.println("traverse grades array");
		grades.traverse();
		System.out.println("traverse dystopian array");
		dystopian.traverse();
		
		
		//print the grades array
		System.out.println("Printing out the Arrays: \n");
		System.out.println("Grades: \n");
		grades.printArray();
		//print the novels array
		System.out.println("My Favorite Dystopian Novels: \n");
		dystopian.printArray();
		
		//display the capacity and number of elements of the arrays
		System.out.print("Grades Capacity: ");
		grades.getCapacity();
		System.out.print("Grades Number of Elements: ");
		grades.getNumElements();
		System.out.print("Dystopian Capacity: ");
		dystopian.getCapacity();
		System.out.print("Dystopian number of elements: ");
		dystopian.getNumElements();
		
		//resize the arrays too small
		System.out.print("Resizing the array too small\n\n");
		grades.resize(5);
		System.out.println("Grades: \n");
		grades.printArray();
		System.out.print("Grades Capacity: ");
		grades.getCapacity();
		System.out.print("Grades Number of Elements: ");
		grades.getNumElements();
		
		dystopian.resize(4);
		System.out.println("Dystopian Novels: \n");
		dystopian.printArray();
		System.out.print("Dystopian Capacity: ");
		dystopian.getCapacity();
		System.out.print("Dystopian number of elements: ");
		dystopian.getNumElements();
		
		//resize the arrays larger
		System.out.print("Resizing the array larger\n\n");
		grades.resize(15);
		System.out.println("Grades: \n");
		grades.printArray();
		System.out.print("Grades Capacity: ");
		grades.getCapacity();
		System.out.print("Grades Number of Elements: ");
		grades.getNumElements();
		
		dystopian.resize(13);
		System.out.println("Dystopian Novels: \n");
		dystopian.printArray();
		System.out.print("Dystopian Capacity: ");
		dystopian.getCapacity();
		System.out.print("Dystopian number of elements: ");
		dystopian.getNumElements();
		
		//get the element of an array when giving position
		System.out.print("Grades at position 5: ");
		grades.getElement(5);
		System.out.println("\n");
		System.out.print("Dystopian novel at position 4: ");
		dystopian.getElement(4);
		
		//get the index of an element of array
		System.out.print("\n\nindex of 78: ");
		grades.getIndexOf(78);
		System.out.println("\n");
		System.out.print("index of 1984: ");
		dystopian.getIndexOf("1984");
		
		//insert an element somewhere in middle of array
		System.out.println("\n\nPrinting out the Arrays after inserting element anywhere: \n");
		grades.insertAnywhere(5,37);
		dystopian.insertAnywhere(4, "Catching Fire");
		System.out.println("Grades: \n");
		grades.printArray();
		System.out.println("My Favorite Dystopian Novels: \n");
		dystopian.printArray();
		System.out.print("Grades Capacity: ");
		grades.getCapacity();
		System.out.print("Grades Number of Elements: ");
		grades.getNumElements();
		System.out.print("Dystopian Capacity: ");
		dystopian.getCapacity();
		System.out.print("Dystopian number of elements: ");
		dystopian.getNumElements();

		
		//replace an element in the Array giving valid position and new value
		System.out.println("Printing out the Arrays after replacing an element using position: \n");
		grades.replacePosition(4,59);
		dystopian.replacePosition(3, "Anthem");
		System.out.println("Grades: \n");
		grades.printArray();
		System.out.println("My Favorite Dystopian Novels: \n");
		dystopian.printArray();
		System.out.print("Grades Capacity: ");
		grades.getCapacity();
		System.out.print("Grades Number of Elements: ");
		grades.getNumElements();
		System.out.print("Dystopian Capacity: ");
		dystopian.getCapacity();
		System.out.print("Dystopian number of elements: ");
		dystopian.getNumElements();
		
		//replace an element in the Array giving invalid position
		System.out.println("Printing out the Arrays after replacing an element using position: \n");
		grades.replacePosition(0,63);
		dystopian.replacePosition(13, "insurgent");
		System.out.println("Grades: \n");
		grades.printArray();
		System.out.println("My Favorite Dystopian Novels: \n");
		dystopian.printArray();
		System.out.print("Grades Capacity: ");
		grades.getCapacity();
		System.out.print("Grades Number of Elements: ");
		grades.getNumElements();
		System.out.print("Dystopian Capacity: ");
		dystopian.getCapacity();
		System.out.print("Dystopian number of elements: ");
		dystopian.getNumElements();

		
		//replace an element in the array giving old value and new value
		System.out.println("Printing out the Arrays after replacing an element using values: \n");
		grades.replaceValue(59, 79);
		dystopian.replaceValue("The Giver", "A Wrinkle in Time");
		System.out.println("Grades: \n");
		grades.printArray();
		System.out.println("My Favorite Dystopian Novels: \n");
		dystopian.printArray();
		System.out.print("Grades Capacity: ");
		grades.getCapacity();
		System.out.print("Grades Number of Elements: ");
		grades.getNumElements();
		System.out.print("Dystopian Capacity: ");
		dystopian.getCapacity();
		System.out.print("Dystopian number of elements: ");
		dystopian.getNumElements();
		
		//Demonstrate deleting a position in the array, then repring everything
		System.out.println("Printing out the Arrays after deleting an element using position: \n");
		grades.deletePosition(1);
		grades.printArray();	
		dystopian.deletePosition(3);
		System.out.println("Dystopian Novels: \n");
		dystopian.printArray();
		System.out.print("Grades Capacity: ");
		grades.getCapacity();
		System.out.print("Grades Number of Elements: ");
		grades.getNumElements();
		System.out.print("Dystopian Capacity: ");
		dystopian.getCapacity();
		System.out.print("Dystopian number of elements: ");
		dystopian.getNumElements();
		
		//Demonstrate deleting a value in the array, then repring everything
		System.out.println("Printing out the Arrays after deleting an element using value: \n");
		grades.deleteValue(37);
		grades.printArray();	
		dystopian.deleteValue("Catching Fire");
		System.out.println("Dystopian Novels: \n");
		dystopian.printArray();
		System.out.print("Grades Capacity: ");
		grades.getCapacity();
		System.out.print("Grades Number of Elements: ");
		grades.getNumElements();
		System.out.print("Dystopian Capacity: ");
		dystopian.getCapacity();
		System.out.print("Dystopian number of elements: ");
		dystopian.getNumElements();
	}
}