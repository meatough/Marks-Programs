public class ArrayDemo2
{
	public static void main(String[] args)
	{
		int[] intArray = {2, 4, 6, 9, 1, 5, 6 };
				
		for (int i = 0; i< 7; i++)
		{
			for (int j = 1; j <= intArray[i]; j++)
			{
				System.out.print("@");
			}
			System.out.println();
		}
	}
}