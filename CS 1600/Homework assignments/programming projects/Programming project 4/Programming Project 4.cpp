/*********************************************************** 
 * Programming Assignment 4
 * Falling Golf Ball program
 * Programmer: Mark Eatough
 * Course: CS 1600 
 * Created February 12, 2013
 
 *This program determines distance total distance a golf
 *ball will fall, as well as how far the ball has fallen
 *over the user specified interval, and user specifed time.
 ***********************************************************/
 
 
#include<iostream>
#include<iomanip>
#include<cmath>
#include<cstdlib>

using namespace std;

int main()
{
	double d;
	double t;
	double g = 32;
	double interval;
	double currentD;
	double counter;
	
	char choice;
	
	do{
	//display the menu
	system("cls");
	cout	<<"Main Menu" << endl << endl
			<<"1. Print the default chart: (10 total seconds and 1 second interval)" << endl
			<<"2. Build a chart: (user sets the total time, and the interval)" << endl
			<<"3. Exit" << endl << endl
			<<"Your choice: ";
			
			//get a menu choice
			cin >> choice;
			
			//switch the choice
			switch(choice)
			{
				case'1':
					system("cls");
					
					cout << "\n\nTime(sec)\tDistance in the Current Time\tTotal Distance(ft)"
					"\n\t\tInterval(ft)" << endl;
					
					t = 10;
					interval = 1;
					counter = 0;
					
					while( counter <= t)
					{
						d = 0.5*(g)*pow(counter,2);
						
						currentD = 0.5*(g)*(pow(counter,2)-pow(counter - interval,2));
						
						if(currentD < 0)
						{
							currentD = 0;
						}
	
						printf("%3.2f\t\t%4.2f\t\t\t\t%5.2f\n", counter, currentD, d);
						/*cout << counter << "\t\t" << currentD  
						<< "\t\t\t\t"  << d << endl;*/
						
						counter += interval;
					}	


					system("pause");
					break;
					
				case'2':
					system("cls");
					
					cout << "\n\nEnter to total time you want to golf ball to fall: ";
					cin >> t;
	
					cout << "Enter the number of seconds on each interval you would like displayed on the Chart: " ;
					cin >> interval;
					
					counter = 0;
					
					cout << "\n\nTime(sec)\tDistance in the Current Time\tTotal Distance(ft)"
					"\n\t\tInterval(ft)" << endl;
					
					
					while( counter <= t)
					{
						d = 0.5*(g)*pow(counter,2);
						
						currentD = 0.5*(g)*(pow(counter,2)-pow(counter - interval,2));
						
						if(currentD < 0)
						{
							currentD = 0;
						}
	
						printf("%3.2f\t\t%4.2f\t\t\t\t%5.2f\n", counter, currentD, d);
						
						/*cout << counter << "\t\t" << setprecision(2) << currentD  
						<< "\t\t\t\t" << setprecision(2) << d << endl;*/
						
						counter += interval;
					}	

					system("pause");
					break;
					
				case'3': break;
					
					default:
					cout << "invalid choice!" << endl;
					system("pause");
					break;
			}//end switch
	
	}while(choice != '3');

}