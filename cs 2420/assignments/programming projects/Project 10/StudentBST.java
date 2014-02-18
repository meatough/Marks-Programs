 /*********************************************************** 
 * Programming Assignment 10
 * Binary Search Tree program
 * Programmer: Mark Eatough
 * Course: CS 2420 
 * Created April 10, 2013
 * Modified  April 17, 2013
 * Modified by Mark Eatough
 ***********************************************************/  
// studentList.inOrderTraversal( new WriteVisitor( new FileOutputStream("filename.stu")) );
//maybe use later to write file


import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.NoSuchElementException;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class StudentBST 
{
	//TreeIterator<Student> iter;

	//Scanner stringInput = new Scanner(System.in);
	LinkedBST<Student> studentList;
	Scanner input;
	Scanner menuInput;
 	
	char choice;
	ObjectOutputStream out;	//create new output stream object
	ObjectInputStream in;	//create new input stream object

			
	//constructor
	public StudentBST()
	{
		studentList = new LinkedBST<Student>();
		input = new Scanner(System.in);
		menuInput = new Scanner(System.in);
	}
	
	void studentMenu()
	{
		readFiles();
		do
     	{
      	System.out.println("\n    1 . . . Add a student ");
         System.out.println("    2 . . . Delete a student ");
         System.out.println("    3 . . . List all students ");
			System.out.println("    4 . . . List students by major ");
			System.out.println("    5 . . . List students above certian gpa ");
			System.out.println("    6 . . . List students below certian gpa ");
        	System.out.println("    Press any other key to exit ");
        	choice = menuInput.nextLine().charAt(0);
         
         
     		switch (choice)
       	{
         	case '1':  				//add a student											
           		addStudent();
          	break;
            
            case '2': 				//delete a student
            	removeStudent();
            break;
            
          	case '3':  				//List all student
					listAllStudents();
         	break;
					
				case '4':  				//Listing students of a specific major
           		searchMajor();
        		break;
					
				case '5':  				//Listing students above a gpa
           		searchAboveGPA();
        		break;
					
				case '6':  				//Listing students below a gpa
           		searchBelowGPA();
         	break;
            
          	default:
					writeFiles();
           		System.out.println("Goodbye");
       	}
 		}while("123456".indexOf(choice) != -1);
	}//end student menu
	
	void addStudent()
	{
		System.out.println();
      System.out.print("Enter student's first name: ");
      String firstName  = input.nextLine();	
			
		//input.nextLine();
      
      System.out.print("\nEnter student's last name: ");
      String lastName  = input.nextLine();
					
      System.out.print("\nEnter student's major: ");
      String major = input.nextLine();		
			   			
      System.out.print("\nEnter student's S Number: ");
      int sNumber = input.nextInt();
      					
      System.out.print("\nEnter student's GPA: ");
      double gpa  = input.nextDouble();
  		
		Student newStudent; 
		
		//newStudent = new Student(firstName, lastName, major, sNumber, gpa );
		
      studentList.add(new Student (firstName, lastName, major, sNumber, gpa));

	}
	
	void removeStudent()
	{
		System.out.printf("\nEnter the student number of the student you would like to delete: ");	
         int studentDelete = input.nextInt();
		
		for(Student s : studentList)
		{
			if(s.getStudentNumber() == studentDelete)
			{
				studentList.remove(s);
			}
		}
	}
	
	
	void listAllStudents()
	{
		System.out.println("Display of entire list of students: \n");
		System.out.println("\tLast Name\tFirst Name\tMajor\t\tStudent Number\t\tGPA");
		
		for(Student s : studentList)
		{
			System.out.println(s.toString());
		}
	}//end display list method	
	
	
	void searchMajor()
	{
		System.out.printf("\nEnter the major of the students you would like listed: ");	
         String studentMajor = input.nextLine();
		
		for(Student s : studentList)
		{
			if(s.getMajor() == studentMajor)
			{
				System.out.println(s);
			}
		}	
	}//end find by major method
	
	void searchAboveGPA()
	{
		Student aboveStudent;
		
		System.out.printf("\nEnter the GPA you would like to find students at or above: ");	
         double studentAbove = input.nextDouble();
		
		for(Student s : studentList)
		{
			if(s.getGPA() >= studentAbove)
			{
				System.out.println(s);
			}
		}
	}//end find above gpa
	
	void searchBelowGPA()
	{
		Student belowStudent;
		
		System.out.printf("\nEnter the GPA you would like to find students at or below: ");	
         double studentBelow = input.nextDouble();
		
		for(Student s : studentList)
		{
			if(s.getGPA() <= studentBelow)
			{
				System.out.println(s);
			}
		}		
	}//end find below gpa method

	
	public void readFiles()
	{
		
		try 
      {
			//open file
         in = new ObjectInputStream(
            new FileInputStream( "Students.ser" ) );
			
			while ( true )
         {
            Student myStudent = ( Student ) in.readObject();
				studentList.add(myStudent);
			}			
      } // end try
      catch ( IOException ioException )
      {
         System.err.println();
      } // end catch
		
		catch ( ClassNotFoundException classNotFoundException )
      {
         System.err.println( "Unable to create object." );
      } // end catch
	}
	
	public void writeFiles()
	{
		try
      {
   		//open file      
			out = new ObjectOutputStream(
            new FileOutputStream( "Students.ser" ) );
			
			//write file to disk
			for(Student s : studentList)
			{
				out.writeObject(s);
			}
			
			//close file
			if ( out != null )
            out.close();
				
      } // end try
      catch ( IOException ioException )
      {
         System.err.println( "Error opening, writing or closing file." );
      } // end catch
		catch ( NoSuchElementException elementException )
      {
      	System.err.println( "Invalid input. System fail" );
      } // end catch
	}
	
}//end StudentBST