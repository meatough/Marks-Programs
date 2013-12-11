/*********************************************************** 
 * Programming Assignment 6											*
 * Pig Latin program														*	
 * Programmer: Mark Eatough											*	
 * Course: CS1410 														*
 * Created March 1, 2012												*
 * Modified March 6, 2012												*
 * Modified by Mark Eatough											*
 ***********************************************************/ 
 
 class PigLatin
 {
 	//fields
	public String sentance;
	public String[] temporary;
	public String word;
	public int i;
	
	public String deliminator = " ";
	
	private int index=0;
	
	
	//constructor
	public PigLatin(String anyString)
	{
		sentance = anyString;
	}
	
	//methods
	public void separateSentance()//method to separate each word in sentance
	{
		temporary = sentance.split(deliminator);	
	}
		
	public void convertToPigLatin()//method to convert to pig latin
 	{
		for(int i = 0; i < temporary.length ; i++)
		{
			word = temporary[i];
			
			if(word.length() == 1)
			{
				if(i == temporary.length-1)
				{
					System.out.printf("%s.", word.toLowerCase());
				}
				else if(i == 0)
				{
					System.out.printf("%s ", word.toUpperCase());
				}
				else
				{
					System.out.printf("%s ", word.toLowerCase());
				}
			}//end of if statement that leaves words with one letter as is.
			
			else
			{
				for(int j = 1; j < word.length() ; j++)
				{
	
					if(i==0 && j==1)
					{
						System.out.printf("%s", Character.toUpperCase(word.charAt(j)));
					}
					else
					{
							System.out.printf("%s", Character.toLowerCase(word.charAt(j)));
					}
				}	
					
				if(i < temporary.length-1)
				{
					System.out.printf("%say ", Character.toLowerCase(word.charAt(0)));
				}
				
				if(i == temporary.length-1)
				{
					System.out.printf("%say.", Character.toLowerCase(word.charAt(0)));
				}
			}//end of else statement that translates all multi letter words into pig latin
		}//end of for loop which iterates through words from sentance
	}//end of convert to pig latin method
 }//end of PigLatin class