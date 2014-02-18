 /*********************************************************** 
 * Programming Assignment 3
 * Singly linked list program
 * Programmer: Mark Eatough
 * Course: CS 2410 
 * Created February 6, 2013
 * Modified February 13, 2013
 * Modified by Mark Eatough
 ***********************************************************/
 
 package gray.adts.ch3;
 import java.util.Scanner;
 
 public class SinglyLinkedTest
 {
 	public static void main(String[] args)
	{
		SinglyLinkedList<String> comics = new SinglyLinkedList<String>(); 
		comics.addFront("Batman");
		comics.addFront("X-Men");
		comics.addFront("Spiderman");
		comics.addFront("Captain America");
		comics.addFront("Wonder Woman");
	
		Scanner input = new Scanner(System.in);
		Scanner intInput = new Scanner(System.in);
		String com;
		int location;
		char choice;
		char sel;
		
		do
      {
			System.out.println("\n        Main Menu");
      	System.out.println("\n    1 . . . Add an item ");
         System.out.println("    2 . . . Delete an item ");
         System.out.println("    3 . . . Find an item ");
         System.out.println("    4 . . . Display the list ");
         System.out.println("    Press any other key to exit ");
         choice = input.nextLine().charAt(0);
         
     		switch (choice)
         {
         	case '1':  				//add an item		
									
					System.out.println("\n         Add Menu");			
     				System.out.println("\n    a . . . Add item to beginning of list");
         		System.out.println("    b . . . Add item at location");
         		System.out.println("    Press any other key to exit back to main menu ");
					sel = input.nextLine().charAt(0);
	
					if(sel == 'a')
					{
						System.out.println("Enter the comic to add to beginning of list");
						com = input.nextLine();
						comics.addFront(com);//working
					}
					else if(sel == 'b')
					{
						System.out.println("Enter the comic to add");
						com = input.nextLine();
						System.out.println("Enter location you would like comic to go");
						location = intInput.nextInt();
						comics.addAnywhere(com, location);//working
					}
					break;
            
            case '2': 				//delete an item
            	System.out.println("\n         Delete Menu");			
     				System.out.println("\n    a . . . Delete item by location");
         		System.out.println("    b . . . Delete item by name");
         		System.out.println("    Press any other key to exit back to main menu ");
					sel = input.nextLine().charAt(0);
					
					if(sel == 'a')
					{
						System.out.println("Enter location of comic you would like to delete");
						location = intInput.nextInt();
						comics.removeIndex(location);//working
					}
					else if(sel == 'b')
					{
						System.out.println("Enter the comic you would like to delete");
						com = input.nextLine();
						comics.removeElement(com);//close!!! but no frickin cigar
					}
				break;
            
          	case '3':  				//find an item
            	System.out.println("\n         Find Menu");			
     				System.out.println("\n    a . . . Find item by location");
         		System.out.println("    b . . . Find item by name");
         		System.out.println("    Press any other key to exit back to main menu ");
					sel = input.nextLine().charAt(0);
					
					if(sel == 'a')
					{
						System.out.println("Enter location of comic you would like to find");
						location = intInput.nextInt();
						comics.getElementAt(location);//working
					}
					else if(sel == 'b')
					{
						System.out.println("Enter the comic you would like to find");
						com = input.nextLine();
						comics.findElement(com);//working
					}
				break;
 
          	case '4':  				 
            	comics.displayList();//working
          	break;
                      
          	default:
            	System.out.println("Goodbye");
       	}
 		}while("1234".indexOf(choice) != -1);
	}//end main method
 }//end class