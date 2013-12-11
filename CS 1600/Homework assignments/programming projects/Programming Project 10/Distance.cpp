/*********************************************************** 
 * Pairded Distance Project
 * Distance
 * Programmers:	Mark Eatough
 *						Derek Moulton
 *						Bryce Wengren
 * Course: 		CS 1600 
 * Created 		April 18, 2013
 * Modified:	April 23, 2013
 ***********************************************************/
#include<iostream>
using namespace std;

class Distance
{
	friend ostream& operator <<(ostream&, const Distance&);
	friend istream& operator >>(istream&, Distance&);

	private:
		int feet;
		double inches;
		
	public:
		//default constructor
		Distance();
		//parameterized constructor
		Distance( int f, double i );
		
		//function prototype set methods
		void setFeet(int f);
		void setInches(double i);
		
		//function prototype get methods
		int getFeet();
		double getInches();
		
		//show method
		void showDistance();
		
		//utility methods
		Distance operator+(Distance&);
		Distance operator-(Distance&);
		Distance operator*(Distance&);
		double convertToInches(Distance);
		
};

Distance::Distance()
{
	feet = 0;
	inches = 0;
}

Distance::Distance(int f, double i)
{
	feet = f;
	inches = i;
}

//set methods
void Distance::setFeet(int f)
{
	feet = f;
}
void Distance::setInches(double i)
{
	inches = i;
}
		
//get methods
int Distance::getFeet()
{
	return feet;
}
double Distance::getInches()
{
	return inches;
}

//show method
void Distance::showDistance()
{
	cout << "Your Distance is " << feet << " feet and " << inches << " inches." << endl;
}
//add method
Distance Distance::operator+(Distance &d)
{ 
	double in = inches+d.inches;
	int ft = feet+d.feet;
	
	bool flag = true;
	while(flag == true)
	{
		if(in >= 12)
		{
			in -=12;
			ft +=1;
		}
		else
		{
			flag = false;
		}
	}
	Distance distance(ft, in);
	return distance;
}
//subtract method
Distance Distance::operator-(Distance &d)
{ 
	double in = inches-d.inches;
	int ft = feet-d.feet;
	
	bool flag = true;
	while(flag == true)
	{
		if(in < 0 && ft >=0)
		{
			in +=12;
			ft -=1;
		}
		else if(in < 0 && ft <0)
		{
			ft = abs(ft);
			in = abs(in);
			if(in >= 12)
			{
				in -= 12;
				ft++;
			}	
		}
		else
		{
			flag = false;
		}
	}
	if(ft < 0 || in < 0)
	{
		ft = abs(ft);
		in = abs(in);
	}
	Distance distance(ft, in);
	return distance;
}
//multiply method (used to find area)
Distance Distance::operator*(Distance &d)
{ 
	//double in = inches*d.inches;
	//int ft = feet*d.feet;
	
	double in1 = d.feet*12+d.inches;
	cout << in1 << endl;
	double in2 = feet*12+inches;
	cout << in2 << endl;
	
	int ft = 0;
	double in = in1*in2;
	cout << in << endl;
	
	bool flag = true;
	while(flag == true)
	{
		if(in >= 12)
		{
			in -=12;
			ft +=1;
		}
		else
		{
			flag = false;
		}
	}
	Distance distance(ft, in);
	return distance;
}

//method to convert distance to inches
double convertToInches(Distance d)
{
	return d.getFeet()*12 + d.getInches();
}

//io stream methods
ostream& operator <<(ostream& out, const Distance& dist)
{
	out << dist.feet << " feet " << dist.inches << " inches ";
	return out;
}

istream& operator >>(istream& in, Distance& dist)
{
	int ft;
	double inch;
	cout << "\n\nenter feet ";
	in >> ft;
	cout << "\n\nenter inches "; 
	in >> inch;

	dist.setInches(inch);
	dist.setFeet(ft);		
	
	return in;
}
