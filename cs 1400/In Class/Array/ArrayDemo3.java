public class ArrayDemo3
{
	public static void main(String[] args)
	{
		int[] intArray = {2, 4, 6, 9, 1, 5, 6 };
		int sum = 0;
						
		for (int i = 0; i< 7; i++)
		{
			sum += intArray[i];
		}
		
		System.out.printf("\nSum = %d", sum);
	}
}