#include<iostream>
using namespace std;
void main()
{
	int sum = 0;
	int cSum = 1;
	int BNum,x[16][2];
	int Array[4][4];
	int i=0,j=0,k=0;	
	cout<<"input the array\n";
	for(;i<=3;i++)
		for(j=0;j<=3;j++)
		{
			cin>>Array[i][j];
			if(i==0&&j==0)
			{
				BNum = Array[i][j];
				x[0][0] = i;
				x[0][1] =j;
			}
			sum += Array[i][j];
			if(i==j||i+j==3)
				cSum *= Array[i][j];
			if(Array[i][j]==BNum)
			{
				BNum = Array[i][j];
				x[++k][0]=i;
				x[k][1]=j;
			}
			else if(Array[i][j]>BNum)
			{
				BNum=Array[i][j];
				x[0][0]=i;
				x[0][1]=j;
				k=0;
			}
		}
		cout << "the sum is:" <<sum;
		cout << "\nthe csum is:" << cSum;
		cout << "\nthe Bnum location is:\n";
		for(int n=0;n<=k;n++)
			cout << "(" << x[n][0]+1 << "," << x[n][1]+1 << ")\n";
}