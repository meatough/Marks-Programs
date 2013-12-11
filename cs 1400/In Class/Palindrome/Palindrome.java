public class Palindrome
{
	//fields
	private String word;
	
	private int index=0;
	
	
	//constructor
	public Palindrome(String anyString)
	{
		word = anyString;
	}
	
	//methods
	public boolean isPalindrome()
	{	
		boolean result = true;
		for (int i = word.length(); i/2 != 0; i-=2)
		{
			if(word.charAt(index) != word.charAt(i- 1+ index))
			{
				result = false;
				break; 
			}
			index++;
		}
		return result;
	}
}