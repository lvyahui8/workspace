#include <iostream>
using namespace std;
int getSum(int *pointer, int n)
{
	int sum = 0;
	for (int i = 0; i < n; i++)
		sum += *(pointer + i);
    return sum;
} 
	int getProduct(int *pointer, int n)
{   
    int a,b;
	int Sum = 1;
	for (int i = 0; i < n; i++)
	{
		a = i / 4;
		b = i % 4;
		if (a == b || a + b == 3)
			Sum = Sum * (*(pointer + i));
	}
    return Sum;
}
int getMax(int *pointer, int n)
{
	int a,b;
	int max = *pointer;
	for (int i = 0; i < n; i++)
	{
	    if (max < *(pointer + i)) 
		{
			max = *(pointer + i);
			a = i / 4;
			b = i % 4;
		}
	}
    return max,a,b;
}
int main()
{   
	int a = 0;
	int *Array;
	int array[4][4];
	for (int i = 0; i < 4; i++)
	{
		for(int j = 0; j < 4; j++)
		{
			cout << "Enter a number:";
			cin >> array[i][j];
			*(Array + a) = array[i][j];
			a++;
		}
	}
	cout<<"The sum of array is "<<getSum(Array,16)<<endl;
	cout<<"The product of array is "<<getProduct(Array,16)<<endl;
	cout<<"The max and its location are "<<getMax(Array,16)<<endl;
	return 0;
}
