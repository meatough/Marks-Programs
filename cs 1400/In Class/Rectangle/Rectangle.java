public class Rectangle
{
	// private fields
	private int length;
	private int width;
	
	// public method(s)

	
	public int setLength ()
	{
		return length;
	}
	
	public void setLength( int myLength)
	{
		length = myLength;
	}
	
	public int setWidth()
	{
		return width;
	}
	
	public void setWidth(int myWidth)
	{
		width = myWidth;
	}
	 
	public void displayArea()
	{
		System.out.printf("Area is %d", length*width);
	}
	
}