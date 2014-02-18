/*********************************************************** 
 * Programming Assignment 1
 * Students program
 * Programmer: Mark Eatough
 * Course: CS1410 
 * Created January 26, 2012
 * Modified February 2, 2012
 * Modified by Mark Eatough
 ***********************************************************/

import java.util.Scanner;
import java.util.ArrayList;

public class StudentList
{
   
	//call student class
   Student myStudent = new Student();
   
	//initialize variables
   String newStudent;
   Scanner input = new Scanner(System.in);
	Scanner stringInput = new Scanner(System.in);
   char choice;
		
   ArrayList<String> students = new ArrayList<String>();	//initialize students arraylist and initialize with 5 names
   {
   	students.add("Mark \t\tEatough\t\t1 \t\tComputer Engineering\t3.0");
      students.add("Jerry \t\tMuckinfudge\t2 \t\tHumanities \t\t2.5");
      students.add("Sally \t\tBerkowitz\t3 \t\tPsychology \t\t3.3");
      students.add("Jane \t\tDoe\t\t4 \t\tCriminology \t\t2.0");
      students.add("Dougan \t\tJones\t\t5 \t\tEconomics \t\t3.5");
 	}
   
  		//public methods
  	public void studentMenu()	//working menu where methods dealing with students array list are called
	{
		do
      {
      	System.out.println("\n    1 . . . Add a student ");
         System.out.println("    2 . . . Find a student ");
         System.out.println("    3 . . . Delete a student ");
         System.out.println("    4 . . . Display all students ");
         System.out.println("    5 . . . Display the total number of students ");
         System.out.println("    Press any other key to exit ");
         choice = stringInput.nextLine().charAt(0);
         
         
     		switch (choice)
         {
         	case '1':  				//add a student											
            	addStudent();
          	break;
            
            case '2': 				//find a student
            	findStudent();
            break;
            
          	case '3':  				//delete a student
            	deleteStudent();
         	break;
            
          	case '4':  				//display list of students
            	displayList();
          	break;
            
          	case '5':				//count number of students
            	countStudents();
          	break;
            
          	default:
            	System.out.println("Goodbye");
       	}
 		}while("12345".indexOf(choice) != -1);
	}//end student menu
		
		public void displayList()  //method to display students array list
      {
         System.out.println("\tFirst Name\tLast Name\tsNumber\t\tMajor\t\t\tGPA");
      
         int index = 1;
      		
         for (String s : students)
         {
            System.out.printf("%d\t%s \n", index, s);
            index++;
         }
      }
   
      public void addStudent()	//method to add a student to students arraylist
      {	
         System.out.println();
         System.out.print("Enter student's first name: ");
         String firstName  = input.nextLine();	
			
			input.nextLine();
      
         System.out.print("\nEnter student's last name: ");
         String lastName  = input.nextLine();
					
         System.out.print("\nEnter student's major: ");
         String major = input.nextLine();		
			   			
         System.out.print("\nEnter student's S Number: ");
         int sNumber = input.nextInt();
      					
         System.out.print("\nEnter student's GPA: ");
         double gpa  = input.nextDouble();
      		
         myStudent.setFirstName (firstName);
         myStudent.setLastName (lastName);
         myStudent.setMajor (major);
         myStudent.setSNumber (sNumber);
         myStudent.setGPA (gpa);
      
	      newStudent = myStudent.toString();
         students.add(newStudent);
			
      }//end add student method
   
      public void deleteStudent()	//method to delete student from students arraylist
      {
         int removeStudent;
         int arraySize = students.size();
         displayList();
      
         System.out.printf("\nOn which line is the student you would like to delete? (line 1 - %d) ",arraySize);	
         int studentDelete = input.nextInt();
      	
         if (studentDelete < 1 || studentDelete > arraySize)
            removeStudent = 1;
         else
            removeStudent = studentDelete; 
      
         int index = removeStudent-1;
         System.out.printf("\nStudent: %s \nhas been removed.\n", students.get(index));
         String answer = input.nextLine();
         students.remove(students.get(index));
      }
   
      public void findStudent()	//mehtod to find and display student from students arraylist
      {
         int studentSearch;
         int arraySize = students.size();
         displayList();
      
         System.out.printf("\nSelect the line of the student you would like to find: (line 1 - %d) ", arraySize);
         int studentFind = input.nextInt();
      
         if (studentFind <1 || studentFind > arraySize)
            studentSearch = 1;
         else 
            studentSearch = studentFind;
      
         int index = studentSearch-1;
         System.out.printf("\n%s \n has been found\n",students.get(index));
      
      }
   
      public void countStudents()	//method to count the number of students in students arraylist
      {
         int count = students.size();
         myStudent.setCount(count);
         System.out.printf("%d", count);
      }
   
}//end student list class
	
