/*********************************************************** 
 * Programming Assignment 1
 * I-Beam stress program
 * Programmer: Mark Eatough
 * Course: CS 1600 
 * Created January 24, 2013
 
 *This program determines the stress on a steel I-beam if 
 *given rectangular moment of inertia, height of the beam, 
 *weight of the load placed on the beam, and the distance in 
 *inches the load is placed from the fixed end of the beam.
 ***********************************************************/
#include<iostream>
using namespace std;	

int main()
{
	//Declaring variables
	double L;
	double I;
	double d;
	double h;
	double c; 
	double S;

	//Assigning values to variables from part a	
	L = 700;
	I = 21.4;
	d = 96;
	h = 6;
	c = 0.5 * h;
	S = (L*d*c)/I;
	
	//print statements to show the values of variables for part a
	cout << "Wieght of the load (L) = " << L << endl;
	cout << "moment of intertia (I) = " << I << endl;
	cout << "load distance from fixed end of beam (d) = " << d << endl;
	cout << "Half the hieght of the beam (c) = " << c << endl;
	
	cout << "\nStress on the beam (S) = " << S << endl;
	
	//Assigning values to variables from part b
	L = 700;
	I = 10.67;
	d = 96;
	h = 4;
	c = 0.5 * h;
	S = (L*d*c)/I;
	
	//print statements to show the values of variables for part b
	cout << "\n\nWieght of the load (L) = " << L << endl;
	cout << "moment of intertia (I) = " << I << endl;
	cout << "load distance from fixed end of beam (d) = " << d << endl;
	cout << "Half the hieght of the beam (c) = " << c << endl;
	
	cout << "\nStress on the beam (S) = " << S << endl;
		
	//Allow user assigned values for variables
	cout << "\n\n Enter the wieght of the load (L) = ";
	cin >> L;
	
	cout << "Enter the moment of intertia (I) = " ;
	cin >> I;
	
	cout << "Enter the load distance from fixed end of beam (d) = ";
	cin >> d;
	
	cout << "Height of the beam (h) = ";
	cin >> h;
	
	//calculate half the height and the stress of the beam
	c = 0.5 * h;
	S = (L*d*c)/I;
	
	//print statements to show the user defined values of variables
	cout << "\n\nWieght of the load (L) = " << L << endl;
	cout << "moment of intertia (I) = " << I << endl;
	cout << "load distance from fixed end of beam (d) = " << d << endl;
	cout << "Half the hieght of the beam (c) = " << c << endl;
	
	cout << "\nStress on the beam (S) = " << S << endl;
}