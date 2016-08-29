#include<iostream>
using namespace std;
int main()
{
	const int a=4;
	const int b=4;
	double total=0;
	double sz[a][b];
	for(int i=0;i<a;i++)
	{
		for(int j=0;j<b;j++)
		{
			int w;
			cin>>w;
			sz[i][j]=w;
			total += sz[i][j];
		}
	}
	for(int row=0;row<a;row++)
	{
		for(int column=0;column<b;column++)
		{
			cout<<"sz[row][column]"<<sz[row][column]<<endl;
        }
	}
	cout<<"the total is"<<total<<endl;
	int ji;
	for(int c=0;i<a;i++)
	{
		for(int d=0;d<b;d++)
		{
           if(c==d)
		  {
	          ji*=sz[c][d];
		  }
		}
	}
	cout<<"the ji is"<<ji<<endl;
	int max = sz[0][0];
	int m,n;
	for(int e=0;e<a;e++)
	{
		for(int f=1;f<b;f++)
		{
			if(sz[e][f]>max)
            {
               max=sz[e][f];
			   m=e;
			   n=f;
            }
		}
	}
	cout<<"the max is"<<max<<" and the hang is "<<m<<"   "<<"the lie is "<<n<<endl;
	system("pause");
	return 0;	
}
