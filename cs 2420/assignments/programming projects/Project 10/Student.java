//need to add post order traversal and pre order traversal methods to AbstractBinarySearchTree 

 /*********************************************************** 
 * Programming Assignment 10
 * Binary Search Tree program
 * Programmer: Mark Eatough
 * Course: CS 2420 
 * Created April 10, 2013
 * Modified  April 17, 2013
 * Modified by Mark Eatough
 ***********************************************************/


import java.io.Serializable; 
public class Student implements Comparable<Student>, Serializable 
{	
 	//private fields
  	private String firstName;
	private String lastName;
	private String major;
	private int studentNumber;
	private double gpa;   
	     	
	//constructors
	public Student()				//default constructor
	{
		this( "", "", "", 0, 0.0 );
	}
		
	public Student(String fN, String lN, String m, int sN, double g)//parameterized constructor
	{
		setFirstName(fN);
		setLastName(lN);
		setMajor(m);
		setStudentNumber(sN);
		setGPA(g);
	}
		
 	//public methods
   public void setFirstName(String fN)
   {
    	firstName = fN;
   }
   
   public String getFirstName()
   {
  	 	return firstName;
   }
   	
  	public void setLastName(String lN)
   {
   	lastName = lN;
   }
   
   public String getLastName()
   {
   	return lastName;
   }
   
  	public void setMajor(String m)
   {
    	major = m;
   }
   
  	public String getMajor()
   {
    	return major;
   }
   
	public void setStudentNumber(int sN)
   {
    	studentNumber = sN;
   }
   
  	public int getStudentNumber()
   {
    	return studentNumber;
   }
   
   
  	public void setGPA(double g)
   {
    	if (g < 0 || g > 4 )
      	gpa = 0;
     	else gpa = g;
 	}
   
 	public double getGPA()
 	{
    	return gpa;
 	}
	
	//override methods
	public boolean equals(Object o)
	{
		if( o instanceof Student)
		{
			return this.compareTo((Student) o) == 0;
		}
		return false;
	}
	
	public int hashCode()
	{
		return 31 * this.lastName.hashCode();
	}
	
	public int compareTo(Student other)
	{
		if(other == null)
		{
			throw new IllegalArgumentException();
		}
		
		int result =0;
		
		if(this.lastName.compareTo(other.getLastName()) < 0)
		{
			result = -1;
		}
		else if(this.lastName.compareTo(other.getLastName()) > 0)
		{
			result = 1;
		}
		else if(this.lastName.compareTo(other.getLastName()) == 0)
		{
			result = this.firstName.compareTo(other.getFirstName());
		}
		
		return result;
	}
	
	@Override
   	public String toString()
      {
         return String.format("\t%s\t\t%s\t\t%s\t%d\t\t\t%.2f\n",
         	lastName, firstName, major, studentNumber, gpa); 
      
      }

}//end Student Class