public class Martain
{
	//field(s)
	
	private static int number;
	private final int attackNumber = 5;
	
	//constructor(s)
	public Martain()
	{
		number++;
	}
	
	//methods
	public void act()
	{
		if (number <= attackNumber)
			System.out.println("wait... ");
		else
			System.out.println("Attack! ");
	}
}