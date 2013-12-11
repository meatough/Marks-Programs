public class GbMachinetest
{
	public static void main(String[] args)
	{	

		GumballMachine myGumballMachine = new GumballMachine ("red" , 25);
		
		System.out.printf("Here is your %s gumball", myGumballMachine.getcolor());
		
		myGumballMachine.vend();
		
		System.out.printf("Here is your %s gumball", myGumballMachine.getcolor());
		
		myGumballMachine.vend();
	}		
}