 /*********************************************************** 
 * Name: Mark Eatough
 * Course: CS1400 
 * Assignment: A5
 ***********************************************************/ 
 
 public class Patterns
 {
 	public void pattern1()
	{
		for (int i = 1; i<=9; i++)
		{
			for (int k = 1; k<=(9-i); k++)
				{
				System.out.print(" ");
				}
			for (int j=1; j<=((i*2)-1); j++)
				{
				System.out.print("@");
				}
			System.out.println();
		}
	}


	public void pattern2()
	{
		for (int i = 9; i>0; i--)
		{
			for (int j = 1; j<=(i); j++)
			{
				System.out.print(" ");
			}
			for (int k = 0; k<(9-i); k++)
			{
				System.out.print("@");
			}
			System.out.print("*");
			for (int l = 0; l<(9-i); l++)
			{
				System.out.print("@");
			}

			System.out.println();
		}
	}
	
	public void pattern3()
	{
		for (int i = 9; i>=0; i--)
		{
			for (int k = 0; k<=(9-i); k++)
				{
				System.out.print(" ");
				}
			for (int j=1; j<=((i*2)-1); j++)
			{
				System.out.print("@");
			}
			System.out.println();
		}
	}
	
	public void pattern4()
	{
		for (int i = 0; i<9; i++)
		{
			for (int j = 0; j<=(i); j++)
			{
				System.out.print(" ");
			}
			for (int k = 0; k<=(7-i); k++)
			{
				System.out.print("@");
			}
			System.out.print("*");
			for (int k = 0; k<=(7-i); k++)
			{
				System.out.print("@");
			}
			System.out.println();
		}
	}
}
	

