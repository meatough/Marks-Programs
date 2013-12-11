 /*********************************************************** 
 * Programming Assignment 1
 * Students program
 * Programmer: Mark Eatough
 * Course: CS 2420 
 * Created April 4, 2013
 * Modified  April 11, 2013
 * Modified by Mark Eatough
 ***********************************************************/ 
	public class Student
   {	
  		//private fields
      private String firstName;  //student first name
      {
      }
   
      private String lastName;	//student last name
      {
      }
   	
      private String major;		//student major
      {
      }
   
      private int studentNumber;			//student number
      {
      }
   
      private double gpa;			//student Grade Point Average
      {
      }
   	
		//constructors
		public Student()				//default constructor
		{
		
		}
		
		public Student(String fN, String lN, String m, int sN, double g)//parameterized constructor
		{
			firstName = fN;
			lastName = lN;
			major = m;
			studentNumber = sN;
			gpa = g;
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
				
		@Override
      public String toString()
      {
         return String.format("%s\t\t%s\t\t%d\t\t%s\t\t%.1f",
            firstName, lastName, studentNumber, major, gpa); 
      
      }

	}//end Student Class