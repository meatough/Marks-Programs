public class hoppetyhop
{
	public void hoppety(int k)
	{
	
		for (int i=1; i<=k; i++)
		{
			if (i % 15 ==0) 
			
				System.out.print("hoppety hop\n");
			
			else if (i % 3==0)
			
				System.out.print("hoppety\n");
				
			else if ( i % 5==0)
			
				System.out.print("hop\n");
				
			else
			
				System.out.printf("%d\n",i);
			
		}
	}
}