 /*********************************************************** 
 * Name: Mark Eatough
 * Course: CS1400 
 * Assignment: A3
 ***********************************************************/ 
 import java.util.Scanner;
 
 public class EmployeeTest
 {
 	public static void main (String[] args)
	{
		Scanner input;
		input = new Scanner(System.in);
		
		System.out.print("Employee name: ");
		String name  = input.nextLine();
		
		System.out.print("\nHours Worked: ");
		double hoursWorked = input.nextDouble();
		
		System.out.print("\nHourly Rate: $");
		double hourlyRate = input.nextDouble();
		
		
		Employee myEmployee = new Employee(name, hoursWorked, hourlyRate);
		
			myEmployee.setHoursWorked (hoursWorked);
			myEmployee.setHourlyRate (hourlyRate);
		
		System.out.printf("\nname: %s \nHours Worked: %.2f \nHourly Rate: $%.2f \nGross Pay: $%.2f", 
		myEmployee.getName(),myEmployee.getHoursWorked(), myEmployee.getHourlyRate(), myEmployee.grossPay());
		
					
		System.out.print("\n\nAdjusted Hours Worked: ");
		double hoursWorked2 = input.nextDouble();
		
		System.out.print("\nAdjusted Hourly Rate: $");
		double hourlyRate2 = input.nextDouble();
		
			myEmployee.setHoursWorked(hoursWorked2);
		
			myEmployee.setHourlyRate(hourlyRate2);

		
		System.out.printf("\n name: %s \nHours Worked: %.2f \nHourly Rate: $%.2f \nGross Pay: $%.2f", 
		myEmployee.getName(), myEmployee.getHoursWorked(), myEmployee.getHourlyRate(), myEmployee.grossPay());
		
	}
}