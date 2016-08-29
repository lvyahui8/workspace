#include <iostream>
using namespace std;
int main()
{
	int matrix[4][4];
	int sum;
	int row,column;
	for(row=0;row<4;row++)//1.1
	{
		for(column=0;column<4;column++)
		{
			cout<<"input the matrix"<<row<<column<<endl;
			cin>>matrix[row][column];
		}
	}
	for(row=0;row<4;row++)
	{
		for(column=0;column<4;column++)
		{
			sum=sum+matrix[row][column];
		}
	}
	cout<<"the sum of this matrix is"<<sum<<endl;
	int sum2;//1.2
	for(row=0;row<4;row++)
	{
		for(column=0;column<4;column++)
		{
				if(row==column||row+column==3)
				{
					sum2=sum2+matrix[row][column];
				}
		}
	}
	cout<<"对角线之和 is"<<sum2<<endl;
	int max=matrix[1][1];//1.3
	int rmax,cmax;
	for(row=0;row<4;row++)
	{
		for(column=0;column<4;column++)
		{
			if(matrix[row][column]>max)
			{
				max=matrix[row][column];
				rmax=row;cmax=column;
			}
		}
	}
	cout<<"the max element is"<<max<<"  place in["<<rmax<<"]["<<cmax<<"]"<<endl;
	return 0;
}
