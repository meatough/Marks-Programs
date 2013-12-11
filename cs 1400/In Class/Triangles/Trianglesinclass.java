public class Triangles
{
	public void drawOne()
	{
		for (int i = 1; i<=7; i++)
		{
			for (int j=1; j<=i; j++)
			{
				System.out.printf("O");
			}
			System.out.print("\n");
		}
	}


	public void drawTwo()
	{
		for (int i = 7; i>=0; i--)
		{
			for (int j = 7; j>=0; j--)
			{
				System.out.printf("O");
			}
			System.out.print("\n");
		}
	}
	
	public void drawThree()
	{
		for (int i = 1; i <= 7; i++)
		{
			for (int j = 1; j<=7; j++)
			{
				System.out.print((j + 1 > 7) ?"O" : " ");
			}
			System.out.print("\n");
		}
	}
	
	public void drawFour()
	{
		for (int i = 7; i <= 1; i--)
		{
			for (int j = 7; j<=1; j--)
			{
				System.out.print((j - 1 > 1) ?"O" : " ");
			}
			System.out.print("\n");
		}
	}
}	