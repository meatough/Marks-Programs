//getting better, need to make sure game does not occur if word cannot be found on first try

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
	
public class HangmanApp extends Hangman
{
	//values to keep track of wins and losses      
	int wins = 0;
	int losses = 0;
	
	String myWord;
	char menuChoice;
	char arrayChoice;
   char letter;
   Scanner inputChar = new Scanner(System.in);
	Scanner menuInput = new Scanner(System.in);
	Scanner arrayInput = new Scanner(System.in);
	//methods
	public void hangmanMenu()
	{
		//populate all arrays
		populateAnimalsArray();
		populateSchoolArray();
		populateCapitalsArray();
		populateStatesArray();
		populateNationsArray();
		populateAllArray();
	
		do
		{
			System.out.println("    1 . . . Play hangman ");
			System.out.println("    2 . . . Wins and Losses ");
  	    	System.out.println("    Press any other key to exit ");
			menuChoice = menuInput.nextLine().charAt(0);
			
			switch(menuChoice)
			{
				case '1':
					letter = ' ';
					missedLetter = 0;
					display = "_ ";
					letterBox.clear();
										
					selectArray();											
      			playHangman(myWord);
      		break;
				
				case '2':
					System.out.printf("Wins: %d\t\tLosses: %d\n\n", wins, losses);
					for(int i = 0; i < animalsPlayed.length; i++)
					{
						System.out.println(animalsPlayed[i]);
					}
				break;
				
				default:
      			System.out.println("Goodbye");
			}
 		}while("12".indexOf(menuChoice) != -1);
	}//end student menu
	
	public String selectWord(String [] words, String [] wordsPlayed)
	{
		String word = "";
		
		if(contains(wordsPlayed, null) == true)
		{
			Random generate = new Random();
		
			int rand = generate.nextInt(words.length);
		
			String tempWord = words[rand];
		
			if(contains(wordsPlayed, tempWord) == true)
			{
				selectWord(words, wordsPlayed);
			}
			else
			{
				word = tempWord;
				for(int i = 0; i < words.length; i++)
				{
					if(word == words[i])
					{
						wordsPlayed[i] = words[i];
						return word;
					}
				}
			}
		}//end if statement
		else
		{
			System.out.println("You have played all of the words from this list");
			selectArray();
		}
		return word;
	}
	
	public void selectArray()
	{
		System.out.println("    Which word list would you like to play from?");
		System.out.println("    a . . . animals ");
		System.out.println("    b . . . school subjects ");
		System.out.println("    c . . . U.S. state capitals ");
		System.out.println("    d . . . U.S. states ");
		System.out.println("    e . . . Nations ");
		System.out.println("    f . . . All Words ");
		arrayChoice = menuInput.nextLine().charAt(0);
		
		switch(arrayChoice)
		{
			case 'a':
				myWord = selectWord(animals, animalsPlayed);
			break; 
			
			case 'b':
				//myWord = selectWord(schoolSubjects);
			break; 
			
			case 'c':
				//myWord = selectWord(stateCapitals);
			break; 
			
			case 'd':
				//myWord = selectWord(usStates);
			break; 
			
			case 'e':
				//myWord = selectWord(nations);
			break; 
			case 'f':
				//myWord = selectWord(all);
		}
	}
	
	public void playHangman(String word)
	{
   	while(getMissedLetter() < 7 && displayHasDashes() == true)
   	{	
    		hangTheMan(word, letter);
			
			if(Character.isLetter(letter) == false)
			{
				System.out.println("Please enter a letter");
			}
				
      	if(displayHasDashes() == false)
      	{
       		System.out.println("Congratulations\nYou win!!!");
				wins++;            
      	}
         
      	if(getMissedLetter() < 7 &&displayHasDashes() == true)
      	{
       		System.out.print("\n\n\nEnter your Letter ");
         	letter = inputChar.nextLine().charAt(0);
         	letter = Character.toLowerCase(letter);
      	}
				
      	if(getMissedLetter() >= 7)
      	{
       		System.out.printf("\n\nSorry, you loose, the correct word was %s\n", word);
				System.out.println("Better luck next time");
				losses++;
      	}
		}//end while loop
	}//end play hangman method 
}//end app class