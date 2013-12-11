/*********************************************************** 
 * Programming Assignment 5
 * Functions Program program
 * Programmer: Mark Eatough
 * Course: CS 1600 
 * Created February 25, 2013
 
 *This program determines the absolute value when given a double, 
 *the annulus moment when the inner and outer diameter of a pipe,
 *the buoyant force when given volume and fluid denstiy, 
 *the maximum of three numeric values, and the square of
 *a given numeric value.
 ***********************************************************/
 
 #include<iostream>
 #include<cmath>

 using namespace std;
  
//create function prototypes
double findAbs(double);
double annulusMoment(double, double);
double buoyantForce(double, double);
template<class T> T  maximum(T, T, T);
template<class T> T  square(T);

//create get function prototypes
void getAbsoluteValue();
void getAnnulusMoment();
void getBuoyantForce();
void getMaximum();
void getSquare();
 
int main()
{
	char choice;
	
	do{
	//display the menu
	system("cls");
	cout	<<"Main Menu" << endl << endl
			<<"1. Absolute Value" << endl
			<<"2. Annulus Moment" << endl
			<<"3. Buoyant Force" << endl
			<<"4. Maximum" << endl
			<<"5. Square" << endl
			<<"6. Exit" << endl << endl
			<<"Your choice: ";
			
			//get a menu choice
			cin >> choice;
			
			//switch the choice
			switch(choice)
			{
				case'1':
					system("cls");
					
					getAbsoluteValue();

					system("pause");
					break;
					
				case'2':
					system("cls");
					
					getAnnulusMoment();

					system("pause");
					break;
					
				case'3':
					system("cls");
					
					getBuoyantForce();

					system("pause");
					break;
					
				case'4':
					system("cls");
					
					getMaximum();

					system("pause");
					break;
					
				case'5':
					system("cls");
					
					getSquare();

					system("pause");
					break;
					
				case'6': break;
					
					default:
					cout << "invalid choice!" << endl;
					system("pause");
					break;
			}//end switch
	
	}while(choice != '6');
}//end main
	
	//Implementation of the functions
	double findAbs(  double x )
	{
		return x < 0 ? -x : x; 
	}
	
	void getAbsoluteValue()
	{
		double x;
		
		cout << "\n\nEnter the number you would like to find the absolute value of: ";
		cin >> x; 
		
		double abs = findAbs(x);
		
		printf("\nThe absolute value of %.2f is %.2f\n\n", x, abs);
		
	}
	
	double annulusMoment(double inner, double outer)
	{
		double i;
		
		i = (M_PI/4)*(pow(outer, 4) - pow(inner, 4));

		return i; 
	}
	
	void getAnnulusMoment()
	{
		double inner;
		double outer;
		
		cout << "\n\nEnter the inner radius of the rod: ";
		cin >> inner;
		cout << "Enter the outer radius of the rod: ";
		cin >> outer;
		
		double aM = annulusMoment(inner, outer);
		
		cout << "\n\nThe second moment of inertia of the rod with an inner radius" << endl;
		printf("of %.2f and an outer radius of %.2f is %.2f\n\n", inner, outer, aM);
	}
	
	double buoyantForce(double fd, double v)
	{
		int pickUnit;
		double g;
		double b;

		cout << "select your units\n\n1 - US Customary Units\n2 - metric units\n" << endl;
		cin >>   pickUnit;

		if(pickUnit == 1)
		{
			g = 32.2;
		}

		else if(pickUnit == 2)
		{
			g = 9.8;
		}

		b = fd*g*v;

		return b;
	}
	
	void getBuoyantForce()
	{
		double fd;
		double v;
		
		cout << "\n\nEnter the fluid density: ";
		cin >> fd;
		cout << "Enter the volume: ";
		cin >> v;
		
		double buoy = buoyantForce(fd, v);
		
		cout << "\n\nThe buoyant force caused by a liquid with a fluid density" << endl;
		printf("of %.3f on an abject with a volume of %.3f is %.3f\n\n", fd, v, buoy);
		
	}
	
	template<class T> T maximum(T a, T b, T c)
	{
		T max = a;
		if( b >  max)
		{
			max = b;
		}

		if (c > max)
		{
			max = c; 
		}

		return max;
	}
	
	void getMaximum()
	{
		int type;
		
		cout << "select your data type\n\n1 - Integers\n2 - Doubles\n3 - long" << endl;
		cin >>   type;

		if(type == 1)
		{
			int a;
			int b;
			int c;
			
			cout << "Enter first number: " << endl;
			cin  >> a;
			cout << "Enter second number: " << endl;
			cin  >> b;
			cout << "Enter third number: " << endl;
			cin  >> c;
		
			int m = maximum(a,b,c);
		
			cout << "\n\nThe maximum of " << a << ", " << b << ", and " << c
			<< " is " << m << "\n\n";
		}

		else if(type == 2)
		{
			double a;
			double b;
			double c;
			
			cout << "Enter first number: " << endl;
			cin  >> a;
			cout << "Enter second number: " << endl;
			cin  >> b;
			cout << "Enter third number: " << endl;
			cin  >> c;
		
			double m = maximum(a,b,c);
		
			cout << "\n\nThe maximum of " << a << ", " << b << ", and " << c
			<< "is " << m << "\n\n";

		}
		
		else if(type == 3)
		{
			long a;
			long b;
			long c;
			
			cout << "Enter first number: " << endl;
			cin  >> a;
			cout << "Enter second number: " << endl;
			cin  >> b;
			cout << "Enter third number: " << endl;
			cin  >> c;
		
			long m = maximum(a,b,c);
		
			cout << "\n\nThe maximum of " << a << ", " << b << ", and " << c
			<< "is " << m << "\n\n";

		}
	}

	template<class T> T square(T a)
	{
		T square;
		square = a*a;

		return square; 
	}
	
	void getSquare()
	{
		int type;
		
		cout << "select your data type\n\n1 - Integers\n2 - Doubles\n3 - long" << endl;
		cin >>   type;

		if(type == 1)
		{
			int a;
			
			cout << "Enter number to be squared: " << endl;
			cin  >> a;
					
			int s = square(a);
		
			cout << "\n\n" << a << " squared is " << s << "\n\n";
		}

		else if(type == 2)
		{
			double a;
			
			cout << "Enter number to be squared: " << endl;
			cin  >> a;
					
			double s = square(a);
		
			cout << "\n\n" << a << " squared is " << s << "\n\n";

		}
		
		else if(type == 3)
		{
			long a;
			
			cout << "Enter number to be squared: " << endl;
			cin  >> a;
					
			long s = square(a);
		
			cout << "\n\n" << a << " squared is " << s << "\n\n";

		}
	}