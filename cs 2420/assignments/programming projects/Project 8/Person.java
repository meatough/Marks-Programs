/*********************************************************** 
 * Programming Assignment 8
 * Recursive method program
 * Programmer: Mark Eatough
 * Course: CS 2410 
 * Created:		March 13
 * Modified:	March 25, 2013 
 * Modified by Mark Eatough
 ***********************************************************/

//Person class
//CS1410, CS2420
//@Override equals(), hashCode(), toString()
//implements Comparable


//package person;

public class Person implements Comparable<Person>
{
	//fields, variables, data members
	private String name;
	private Integer age;
	
	//constructor
	public Person()
	{	
	}

	public Person( String n, Integer a )
	{
		name = n;
		age = a;
	}//end Person()
	
	//accessor methods
	public String getName()
	{
		return name;
	}//end getName()
	
	public Integer getAge()
	{
		return age;
	}//end getAge()
	
	//mutator methods
	public void setName( String n )
	{
		name = n;
	}//end sestName()
	
	public void setAge( Integer a )
	{
		age = a;
	}//end setAge()

	@Override
	public boolean equals( Object o )
	{
		Person p = (Person)o;
		return name.equals(p.name) && age == p.age;
	}//end equals()
	
	@Override
	public int hashCode()
	{
		return name.hashCode() + age.hashCode() * 227;
	}
	
	public int compareTo( Person p )
	{
		return age.compareTo(p.age);
	}
	
	@Override	
	public String toString()
	{
		return getName() + ", " + getAge();
	}//end toString()
	
}//end class Person