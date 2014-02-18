 /*********************************************************** 
 * Programming Assignment 1
 * Distance program
 * Programmer: Mark Eatough
 * Course: CS 2420 
 * Created January 28, 2013
 * Modified January 31, 2013
 * Modified by Mark Eatough
 ***********************************************************/

//Distance class with feet and inches

public class Distance
{
	private int feet;
	private int inches;
	private final int DEFAULT_FT = 1;
	private final int DEFAULT_IN = 1;

	//constructors	
	public Distance()
	{
		feet = DEFAULT_FT;
		inches = DEFAULT_IN;
	}

	public Distance( int ft, int in )
	{
		feet = ft;
		inches = in;
	}
	
	//get methods
	public int getFeet() throws IllegalArgumentException
	{
		if (this.feet < 0)
		{
			System.out.printf("Invalid feet, %d must be > 0 ", this.feet);
			throw new IllegalArgumentException();
		}
		else
		{
			return this.feet;
		}
	}
		
	public int getInches() throws IllegalArgumentException
	{
		if (this.inches < 0)
		{
			System.out.printf("Invalid feet, %d must be > 0 ", this.inches);
			throw new IllegalArgumentException();
		}
		else
		{
			return this.inches;
		}
	}
	
	public int getDistance()
	{
		return this.feet*12 + this.inches;
	}

	
	//set methods - validate + whole integers only
	public void setFeet(int myFeet) throws IllegalArgumentException
	{
		if (myFeet < 0)
		{
			System.out.printf("Invalid feet input, %d must be > 0 ", myFeet );
			throw new IllegalArgumentException( );
		}
			this.feet = myFeet;
	}
	
	public void setInches(int myInches)throws IllegalArgumentException
	{
		if (myInches < 0)
		{
			System.out.printf("Invalid inches input, %d must be > 0 ", myInches);
			throw new IllegalArgumentException();
		}
			this.inches = myInches;
	}
	
	//method to add two distance objects
	public Distance addDistance(Distance d) throws IllegalArgumentException		
	{
       int f = d.feet;	
       int i = d.inches;
		 			
		if (d.feet < 0)
		{
			System.out.printf("Invalid feet input, %d must be > 0 ", f );
			throw new IllegalArgumentException( );
		}
		else
		{
			this.feet = this.feet + f;
		}
		
		if (d.inches < 0)
		{
			System.out.printf("Invalid feet input, %d must be > 0 ", i);
			throw new IllegalArgumentException();
		}
		else
		{
			this.inches = this.inches + i;
		}

		if(inches >= 12)
		{
			this.feet++; 
			this.inches = inches-12;
		}
		return new Distance(feet, inches);
	}
	
	//method to subtract two distance objects
	public Distance subDistance(Distance d) throws IllegalArgumentException	
	{
      int f = d.feet;	
      int   i = d.inches;	
			
		if (d.feet < 0)
		{
			System.out.printf("Invalid feet input, %d must be > 0 ", f );
			throw new IllegalArgumentException( );
		}
		else
		{
			this.feet = this.feet-f;
		}
		
		if (d.inches < 0)
		{
			System.out.printf("Invalid feet input, %d must be > 0 ", i);
			throw new IllegalArgumentException();
		}
		else
		{
			this.inches = this.inches-i;
		}

		if(inches <= -1)
		{
			this.feet--; 
			this.inches = inches+12;
		}
		return new Distance(feet, inches);
	}
	
	//equals() - compares two distance objects for equality  	
	@Override
	public boolean equals(Object obj)	//equals method to create distance object
	{
		boolean flag = false;
		Distance d = ( Distance )obj;
		if( d.feet == feet && d.inches == inches )
		flag = true;
		return flag;
		}
	
	//hashCode() - same hash code for equal objects					
	public int hashcode(Distance d)
	{
		return d.feet*12 + d.inches;
	}
	
	//compareTo() - compares two distance objects ( <, >, == )	
	public int compareTo(Distance d)
	{
		int result = d.compareTo(d);
		System.out.println(result);
		return result;
	}	
	
	@Override
	public String toString()
	{
		return String.format("%d' %d\"", feet, inches );
	}	
}