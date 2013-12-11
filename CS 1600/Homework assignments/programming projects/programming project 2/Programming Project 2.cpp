/*********************************************************** 
 * Programming Assignment 2
 * Inground Pool Dimensions program
 * Programmer: Mark Eatough
 * Course: CS 1600 
 * Created January 28, 2013
 
 *This program determines the perimeter, volume, and 
 *underground surface area of a pool if given lenght, 
 *width,and average depth.
 ***********************************************************/
 
#include<iostream>
using namespace std;

int main()
{
	//Declare variables
	double length, width, averageDepth, 
	volume, perimeter, undergroundSurfaceArea;
	
	//Assign test data to variables
	length = 25;
	width = 15;
	averageDepth = 5.5;

	//calculate using test data
	perimeter = 2*(length + width);
	
	volume  = length * width * averageDepth;
	
	undergroundSurfaceArea = perimeter*averageDepth + length*width;
	
	//print statements to show values of test data
	cout << "Test Data:\n"  << endl;
	
	cout << "Width = " << width << endl;
	cout << "Length = " << length << endl;
	cout << "Average Depth = " << averageDepth << endl;
	
	cout << "\nPerimeter = " << perimeter << endl;
	cout << "Volume = " << volume << endl;
	cout << "Underground Surface Area = " << undergroundSurfaceArea << endl;
	
	cout << "\nTest Successful" << endl;
	
	//Allow user assigned values for variables
	cout << "\n\nEnter the length of your pool = ";
	cin >> length;
	
	cout << "Enter the width of your pool = " ;
	cin >> width;
	
	cout << "Enter the average depth of your pool = ";
	cin >> averageDepth;
	
	//calculate user input data
	perimeter = 2*(length + width);
	
	volume  = length * width * averageDepth;
	
	undergroundSurfaceArea = perimeter*averageDepth + length*width;

	//print statements to show the user defined values of variables
	cout << "\n\nPool Length = " << length << endl;
	cout << "Pool Width = " << width << endl;
	cout << "Pool Average Depth = " << averageDepth << endl;
	
	cout << "\nPool Perimeter = " << perimeter << endl;
	cout << "Pool Volume = " << volume << endl;
	cout << "Pool Underground Surface Area = " <<undergroundSurfaceArea << endl;
}