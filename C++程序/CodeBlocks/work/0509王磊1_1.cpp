#include <iostream>
using namespace std;
int main()
{
	int a[4][4];
	int sum_of_array = 0;
	int product = 1;
	int max_of_array = 0;
	int c,t;       //c为元素的行号，t为元素的列号
	for (int i=0;i<4;i++)
	{
		for (int k=0;k<4;k++)
		{
			cout << "Please input the number for a[" << i << "][" << k << "]";
			cin >> a[i][k];
		}
	}

	for (int p=0;p<4;p++)
	{
		for (int k=0;k<4;k++)
		{
			sum_of_array += a[p][k];
		}
	}
	
	for (int j=0; j<4; j++)
	{
		for (int k=0; k<4; k++)
		{
			if(j==k || j+k==3)
			{
				product = product * a[j][k];
			}
		}
	}

	for (int f=0; f<4; f++)
	{
		for (int k=0; k<4; k++)
		{
			if(max_of_array <= a[f][k])
			{
				max_of_array = a[f][k];
				c = f;
				t = k;
			}
		}
	}
	cout << "The sum of array is:" << sum_of_array << '\n';
	cout << "The product is:" << product << '\n';
	cout << "The max of array is:" << max_of_array << '\n';
	cout << "最大元素在数组中的行号和列号分别为:" << c << "  " << t << '\n';

	return 0;
}
