import java.util.Scanner;
public class MartainTest
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		//repeat 3 times
		//create Martians two by two
		//all Martians that have been created do something
		//enter to continue
		
		Martain m1 = new Martain();
		Martain m2 = new Martain();
		
		m1.act();
		m2.act();
		
		System.out.print("type enter to continue");
		String str = input.nextLine();
		
		Martain m3 = new Martain();
		Martain m4 = new Martain();
		
		System.out.print("type enter to continue");
		String str1 = input.nextLine();
		
		m1.act();
		m2.act();
		m3.act();
		m4.act();
		
		System.out.print("type enter to continue");
		String str2 = input.nextLine();

		Martain m5 = new Martain();
		Martain m6 = new Martain();
		
		m1.act();
		m2.act();
		m3.act();
		m4.act();
		m5.act();
		m6.act();
		
		System.out.print("type enter to continue");
		String str3 = input.nextLine();

	}
}