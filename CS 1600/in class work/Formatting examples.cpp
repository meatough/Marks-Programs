//formatting examples

#include<iostream>
#include<iomanip>
#include<cmath>

using namespace std;

int main()
{
	cout << "print a table of random numbers..." << endl;
	srand(time(0));
	for(int row=1; row<=5; row++)
	{
		for (int col=1; col<=6; col++)
		{
			cout 	<< setw(13)
					<<setiosflags(ios::showpoint | ios::fixed| ios::left) << setprecision(2)
					<<(1+rand()%1000)*2.27;
			
		}
		cout << endl;
	}
	printf("print individual numbers...\n%7.2f\n%d\n", 1234.567, 12345);
	
	return 0;
}