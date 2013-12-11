#include<iostream>
using namespace std;

//counter controlled loop
int main()
{
	int sum = 0;
	int number;
	int counter = 1;
	while(counter <= 5)
	{
		cout << "enter an integer to be added ";
		cin >> number;
		sum += number;
		counter ++;
	}
	cout << "\n\n\nYour sum = " << sum << endl;
}