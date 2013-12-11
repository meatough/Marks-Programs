/*********************************************************** 
 * Programming Assignment 3
 * Fluid Mechanics program
 * Programmer: Mark Eatough
 * Course: CS 1600 
 * Created February 5, 2013
 
 *This program determines the Reynolds number of fluid flow 
 *through a pipe when given the velocity of teh fluid in m/s,
 *the diameter of teh pipe in meters, and the temperature of 
 *the fluid in degrees Celcius.
 ***********************************************************/
 
#include<iostream>
#include <cmath>
using namespace std;

int main()
{
	//Declare variable for Reynolds Number
	double Re;
	
	//Declare variable for velocity(will be in meters per second)
	double V;	
	
	//Declare variable for pipe diameter(will be in meters)
	double d;
	
	//Declare variable for Temperature(will be in degrees Celcius)
	double t;
	
	//declare variable for kinematic viscosity(will be in meters per second squared)
	double v;
	
	
	
	//Allow user assigned values for variables
	cout << "\n\nEnter the velocity of the liquid in m/s = ";
	cin >> V;
	
	cout << "Enter the Diameter of the pipe in meters = " ;
	cin >> d;
	
	cout << "Temperature of the liquid = ";
	cin >> t;
	
	//calculate user input data
	
	if(t == 5)
	{
		v = 1.49*pow(10, -6);
	}
	else if(t == 10)
	{
		v = 1.31*pow(10, -6);
	}
	else if(t == 15)
	{
		v = 1.15*pow(10, -6);
	}
	else
	{
		cout << "\n\nError, that is not a valid Temperature,\n" 
		"Temperature must = 5, 10, or 15, please disregard result" << endl;
	}
	
	Re = (V*d)/v;
	
	//print statements to show the user defined values of variables
	cout << "\n\n\nVelocity(m/s)\tPipe Diameter(m)"
	"\tTemperature(Celcius)\tReynolds Number" << endl;
	
	cout << V << "\t\t" << d << "\t\t\t" 
	<< t << "\t" << "\t\t" << Re << endl;	
}