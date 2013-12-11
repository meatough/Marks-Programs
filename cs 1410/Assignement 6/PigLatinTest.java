/*********************************************************** 
 * Programming Assignment 6											*
 * Pig Latin program														*	
 * Programmer: Mark Eatough											*	
 * Course: CS1410 														*
 * Created March 1, 2012												*
 * Modified March 6, 2012												*
 * Modified by Mark Eatough											*
 ***********************************************************/ 
 import java.util.Scanner; 

 class PigLatinTest
 {
 	public static void main (String[] args)
	{
		Scanner input;
		input = new Scanner(System.in);
		
		System.out.println("enter your sentance to be translated into pig latin \n");
		String sentance = input.nextLine();
		
		PigLatin myPigLatin = new PigLatin(sentance);
		
		myPigLatin.separateSentance();
		
		System.out.println();
		
		myPigLatin.convertToPigLatin();
	}//end main method
 }//end PigLatinTest class