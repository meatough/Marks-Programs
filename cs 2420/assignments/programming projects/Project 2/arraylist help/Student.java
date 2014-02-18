 /*********************************************************** 
 * Programming Assignment 1
 * Students program
 * Programmer: Mark Eatough
 * Course: CS1410 
 * Created January 26, 2012
 * Modified February 2, 2012
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
   
      private int sNumber;			//student number
      {
      }
   
      private double gpa;			//student Grade Point Average
      {
      }
   
      private int count;			//count of students
      {
      }
   	
		//constructors
		public Student()				//default constructor
		{
		
		}
		
		public Student(String fN, String lN, String m, int sN, double g, int c)//parameterized constructor
		{
			firstName = fN;
			lastName = lN;
			major = m;
			sNumber = sN;
			gpa = g;
			c = count;
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
   
      public void setSNumber(int sN)
      {
         sNumber = sN;
      }
   
      public int getSNumber()
      {
         return sNumber;
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
   
      public void setCount(int c)
      {
         count = c;
      }
   
      public int getCount()
      {
         return count;
      }
				
		@Override
      public String toString()
      {
         return String.format("%s\t\t%s\t\t%d\t\t%s\t\t%.1f",
            firstName, lastName, sNumber, major, gpa); 
      
      }

	}//end Student Class