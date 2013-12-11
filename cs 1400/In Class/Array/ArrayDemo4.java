public class ArrayDemo4
{
	public static void main(String[] args)
	{
		final int ARRAY_LENGTH = 6;
		
		double[] intArray = new double[ARRAY_LENGTH];
		
								
		for (int i = 0; i< ARRAY_LENGTH; i++)
		{
			intArray[i] = Math.sin((i+1) * Math.PI/6);
			System.out.printf("sin(%d) = %.2f\n", i, intArray[i]);
		}
		
	}
}