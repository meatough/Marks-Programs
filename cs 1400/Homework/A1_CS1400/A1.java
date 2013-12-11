 /*********************************************************** 
 * Name: Mark Eatough
 * Course: CS1400 
 * Assignment: A1 
 ***********************************************************/ 

import java.util.Scanner;

public class A1
{
	public static void main(String[] args)
	{
	Scanner input = new Scanner(System.in);
	int number;
	
	//System.out.print("Please enter a positive 5 digit integer:  ");
	//number=input.nextInt();
	
	/*int firstdigit=number/10000;
	int seconddigit=number/1000 % 10;
	int thirddigit=number/100 % 10;
	int fourthdigit=number/10 % 10;
	int fifthdigit=number % 10;
*/
	//System.out.printf("%d %d %d %d %d", firstdigit, seconddigit, thirddigit, fourthdigit, fifthdigit);
   
   String property = System.getProperty("os.name");
   if(property.startsWith("Windows"))
   {
      //System.out.print(property);
   }
   else
   {
       //System.out.println("\nSystem not recognized");
   }
   System.out.println(.797-.634);
   System.out.println(1.5/5);
   System.out.println(.163*.3);
   System.out.println(.634+0.0489);
  	}//end main method
}//end class