public class Cat
{
	// private field(s)
	private String name;
	{
	
	}
	private int miceCount;
	{
	
	}
	//constructor(s)
	public Cat (String n)
	{
		name=n;
	}
	
	//public methods
	public String getName()
	{
		return name;
	}
	
	public int getMiceCount()
	{
		return miceCount;
	}
	
	public void catchMice (int miceCaught)
	{
		miceCount +=miceCaught;
	}
}