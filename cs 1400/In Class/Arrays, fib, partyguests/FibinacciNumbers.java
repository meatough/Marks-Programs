public class FibinacciNumbers
{
	public static void main(String[] args)
	{
		int[] fib = new int[20];
		fib[0] = 0;
		fib[1] = 1;
		
		for(int i = 2 ; i < 20 ; i++)
		{
			fib[i] = fib[i -2] + fib[i - 1];
		}
		
		for(int el : fib)
		{
			System.out.printf("%d ", el);
		}
	}
}