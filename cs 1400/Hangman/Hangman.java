import java.util.Random;
import java.util.ArrayList;

public class Hangman extends Words
{
	//fields
	static String display = "_";  	
	static int missedLetter = 0;
	static int turns = 0;
	ArrayList<Character> letterBox = new ArrayList<Character>();
	
	//methods
	public void makeBuffer(String w, char l)
	{
		String temp1 = "";
		String temp2 = "";
		for (int j = 0; j < w.length(); j++)
		{
			
			if(w.charAt(j) == ' ')
			{
				temp1+="   ";
			}
			
			else if(w.charAt(j) == l)
			{
				if(l == ' ')
				{
					//we do nothing here
				}
				else
				{
					temp1+= l;
					temp1+= " ";
				}
			}
			else
			{
				temp1+= "_ ";
			}
			if(display.length() == temp1.length())
			{
				for(int k = 0; k < temp1.length(); k++)
				{
					char check = display.charAt(k);
					if(check>='a' && check <='z')
					{
						temp2+=display.charAt(k);
					}
					else
					{
						temp2+=temp1.charAt(k);
					}
				}
			}
		}
		if(display.length() != temp1.length())
		{
			display = temp1;
		}
		else
		{
			display = temp2;
		}
		System.out.printf("%s", display);
	}//end displayStatus method

	public void incrementMissed(String w, char l)
	{
		boolean containsChar = false;
		for (int j = 0; j < w.length(); j++)
		{
			if(w.charAt(j) == l)
			{
				containsChar = true;
			}
		}
		
		if(containsChar == false && Character.isLetter(l) == true 
											&& letterBox.contains(l) == false)
		{
			missedLetter++;
		}
		
		
		
		if(letterBox.contains(l) == false 
			&& Character.isLetter(l) == true)
		{
			letterBox.add(l);
		}
		else
		{
			if(Character.isLetter(l) == true)
			{
				System.out.printf("%s has already been used, please enter a different letter\n\n\n", l);
			}
			else
			{
				if(turns != 0)
				{
					System.out.printf("%s is not a letter, please enter a letter\n\n\n", l);
				}
			}
		}
		turns++;
	}
	
	public void hangTheMan(String w, char l)
	{
		incrementMissed(w, l);
		if(missedLetter < 8)
		{
			System.out.print("     ____");
			System.out.println();
			System.out.print("    |    |");
			System.out.println();
			
			if (missedLetter > 0)
			{
				System.out.print("    |    O");
				System.out.println();
			}
			else
			{
				System.out.print("    |");
				System.out.println();
			}
			
			if (missedLetter > 1 && missedLetter < 3)
			{
				System.out.print("    |    |");
				System.out.println();
			}
			if (missedLetter > 2 && missedLetter < 4)
			{
				System.out.print("    |   \\|");
				System.out.println();
			}
			if (missedLetter > 3)
			{
				System.out.print("    |   \\|/");
				System.out.println();
			}
			else
			{
				System.out.print("    |");
				System.out.println();
			}
			
			if (missedLetter > 4)
			{
				System.out.print("    |    |");
				System.out.println();
			}
			else
			{
				System.out.print("    |");
				System.out.println();
			}
			
			if (missedLetter > 5 && missedLetter < 7)
			{
				System.out.print("    |   /");
				System.out.println();
			}	
			if (missedLetter > 6)
			{
				System.out.print("    |   / \\");
				System.out.println();
			}
			else
			{
				System.out.print("    |");
				System.out.println();
			}
			
			System.out.print("____|________      ");
		
			makeBuffer(w,l);
			
			System.out.println("\n\n\n");
			
			for (char s : letterBox)
         {
            System.out.printf("%s\t", s);
         }

		}//end outer for loop 
	}//end hangTheMan method
	
	public int getMissedLetter()
	{
		return missedLetter;
	}
	public boolean displayHasDashes()
	{
		boolean displayDashes = false;
		
		for (int i = 0; i < display.length(); i++)
		{
			if(display.charAt(i) == '_')
			{
				displayDashes = true;
			}
		}
		return displayDashes;
	}//end boolean method
}//end hangman class