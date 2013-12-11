/*********************************************************** 
 * Programming Assignment 6
 * Arrays program
 * Programmers: Mark Eatough and Stephen Williams
 * Course: CS 1600 
 * Created March 5, 2013
 
 *This program takes values from a current array and a resistance, 
 *array, and uses them to calculate a volts array.  The Program
 *then prints the three arrays with appropriate headings. 
 ***********************************************************/

#include<iostream>

using namespace std;

//create function prototype
void calc_volts(double [], double [], double [], int);

//main function
int main()
{
	const int capacity = 10;
	int k;
	
	double current[capacity] = {10.62, 14.89, 13.21, 16.55, 18.62, 
											9.47, 6.58, 18.32, 12.15, 3.98};	
																				  	
	double resistance[capacity] = {4, 8.5, 6, 7.35, 9, 15.3, 3, 5.4, 2.9, 4.8};
	
	double volts[capacity];
	
	calc_volts(current, resistance, volts, capacity);
	
	cout << "Current \tResistence \tVolts " << endl;
	
	for(k = 0; k < capacity; k++)
	{
		cout << current[k] << "\t\t" << resistance[k] 
		<< "\t\t" << volts[k] << endl;
	}
	
}	

//implementation of function to calculate volts
void calc_volts(double res [], double cur [], double vol [], int cap)
{
	int i;
	
	for(i = 0; i < cap; i++)
	{
		vol[i] = (cur[i] * res[i]);
	}
}