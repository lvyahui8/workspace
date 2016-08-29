#include <iostream>
using namespace std;
void getSum(int A[4][4])
{
	int i,j;
	int sum = 0;
	for (i = 0;i < 4; i++)
	{
		for (j = 0; j < 4; j++)
	    sum += A[i][j];
	}
	cout<<"The sum of array is "<<sum<<endl;
}
void getProduct(int A[4][4])
{
	int i,j;
    int Sum = 1;
	for (i = 0; i < 4; i++)
	{
		for (j = 0; j < 4; j++)
		{
			if (i == j || i + j == 3)
			Sum =Sum * A[i][j];	
		}
	}
	cout<<"The product of array is "<<Sum<<endl;
}
void getMax(int A[4][4])
{
	int k,p,i,j;
	int max = A[0][0];
	for (i = 0; i < 4; i++)
	{
		for (j = 0; j < 4; j++)
			if (max < A[i][j])
			{
				max = A[i][j];
				k = i;
				p = j;
			}
	}
	cout<<"The max of Array is "<<max<<", and its location is "<<k<<" "<<p<<endl;
}
int main()
{
	int i,j;
	int array[4][4];
	for (i = 0; i < 4; i++)
	{
		for (j = 0; j < 4; j++)
		{
			cout<<"Enter a number:";
			cin>>array[i][j];
		}
	}
	getSum(array);
	getProduct(array);
	getMax(array);
	return 0;
}
