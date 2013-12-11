/*********************************************************** 
 * Programming Assignment 2
 * Inground Pool Dimensions program
 * Programmer: Mark Eatough
 * Course: CS 1600 
 * Created February 7, 2013
 
 *This program determines the perimeter, volume, and 
 *underground surface area of a pool from various lenghts, 
 *widths,and depths.  The program them puts all of these into
 *a table.
 ***********************************************************/
 
#include<iostream>
using namespace std;

int main()
{
	//Declare variables
	double length, width, depth, 
	volume, perimeter, undergroundSurfaceArea;
	
	//Assign first line of data in chart to variables
	length = 25;
	width = 10;
	depth = 5.0;
	
	cout << "Length\tWidth\tDepth\tPerimeter\tVolume\t\t"
	"Underground\n\t\t\t\t\t\t\tSurface Area\n" << endl;
	

	int counter = 1;
	while( counter <= 8)
	{
		perimeter = 2*(length + width);
	
		volume  = length * width * depth;
	
		undergroundSurfaceArea = perimeter*depth + length*width;
		
		cout << length << "\t" << width << "\t" << depth << "\t" 
		<< perimeter << "\t\t" << volume << "\t\t" 
		<< undergroundSurfaceArea << endl;
		
		if(counter >= 4)
		{
			length = 30;
			width  = 12;
		}
		
		if(depth < 6.5)
		{
			depth += 0.5;
		}
		else
		{
			depth = 5.0;
		}
		counter ++;
	}	
}