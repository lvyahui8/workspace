#include <iostream>
using namespace std;
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
	int total = 0;
	int max = myArray[0][0],rowOfMax = 0,columnOfMax = 0;
	int minorDiagonal = 0,secondaryDiagonal = 0;
	for(int row = 0;row < 4;row++)
	{
		for(int column = 0;column < 4;column++)
		{
			total += myArray[row][column];

			if(myArray[row][column] > max)
			{
				max = myArray[row][column];
				rowOfMax = row;
				columnOfMax = column;
			}

			if(row == column)
				minorDiagonal *= myArray[row][column];
			if(row + column == 3)
				secondaryDiagonal *= myArray[row][column];
		}
	}

	cout << "\nTotal of the array is " << total
	     << "\nThe largest number is " << max
	     << "\nRow of the largest number is " << rowOfMax
		 << "\nColumn of the largest number is " << columnOfMax
		 << "\nTotal of the minorDiagonal is " << minorDiagonal
		 << "\nTotal of the secondaryDiagonal is " << secondaryDiagonal;

	system("PAUSE");

	return 0;
}