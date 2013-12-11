public class GumballMachine
{
	//private fields
	private String color;
	{
	
	}
	
	private int ballcount;
	{
	
	}
	
	//constructors
	public GumballMachine (String c, int b)
	{
		color = "red";
		
		ballcount = 25;
	}
	
	//public methods
	public int getballcount()
	{
		return ballcount;
	}
	
	public String getcolor()
	{
		return color;
	}
	
	public void vend()
	{
		if (ballcount > 0)
		System.out.printf ("\nThere are %d gumballs left in the machine.", --ballcount);
		else
		System.out.print ("There machine is out of gumballs.");
	}
	
}