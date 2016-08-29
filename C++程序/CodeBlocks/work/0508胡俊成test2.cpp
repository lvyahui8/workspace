#include <iostream>
#include <cmath>
using namespace std;
int getSum(int *pointer ,int n);
int getProduct(int *pointer , int n);
int getMax(int *pointer , int n);
int rowOfMax = 0;
int secondaryDiagonal = 0;
int main()
{
	int myArray[4][4];
	cout << "Input the array: " <<endl;
	for(int row = 0;row < 4;row++)
	{
		for(int column = 0;column < 4;column++)
		{
			cin >> myArray[row][column];
		}
	}

	cout << "\nTotal of the array is " << getSum(myArray[0],16)
		<< "\nThe largest number is " << myArray[rowOfMax][getMax(myArray[0],16)]
		<< "\nRow of the largest number is " << rowOfMax
		<< "\nColumn of the largest number is " << getMax(myArray[0],16)
		<< "\nTotal of the minorDiagonal is " << getProduct(myArray[0],16)
		<< "\nTotal of the secondaryDiagonal is " << secondaryDiagonal;

	system("PAUSE");

	return 0;
}

int getSum(int *pointer ,int n)
{
	int total = 0;
	for(int i = 0;i < n;i++)
	total += *(pointer++);

	return total;
}

int getProduct(int *pointer , int n)
{
	int minorDiagonal = 0;
	for(int i = 1;i <= n;i++)
	{
		if(i / 4 == i % 4)
			minorDiagonal *= *(pointer++);
		if(i / 4 + i % 4 == 3)
			secondaryDiagonal *= *(pointer++);
	}
	return minorDiagonal;
}
int getMax(int *pointer , int n)
{
	int max = *pointer;
	int columnOfMax = 0;
	for(int i = 0;i < n;i++)
	{
		if(*(pointer++) > max)
		{
			max = *(pointer++);
			rowOfMax = i / 4;
			columnOfMax = i % 4;
		}
	}

	return columnOfMax;

}
