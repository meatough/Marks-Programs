public class Cloud
{
	//private field(s)
	
	private String cloudClassification;
	
	// constructor(s)
	
	public Cloud (String cc)
	{
		cloudClassification=cc;
	}
	
	// public method(s)
	
	public String getcloudClassification ()
	{
		return cloudClassification;
	}
	
	public void rain ()
	{
		System.out.println("It is raining");
	}
}