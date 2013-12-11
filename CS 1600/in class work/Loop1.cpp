#include<iostream>
using namespace std;

//counter controlled loop
int main()
{
	int count = 1;
	int sum = 0;
	while(count++ <= 20)
	{
		sum = sum + count;
		cout << count++ << endl;
		//count++;
	}
	cout << "sum = " << sum << endl;
}