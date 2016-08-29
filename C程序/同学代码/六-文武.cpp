#include "stdafx.h"
int main()
{	
	int a=2,n=3,Sn=0,k,sum=1,S=0,ch,ch1;
	//printf("接下来请输入a,n \n 并且有Sn=a+aa+aaa+a...a  其中最后a...a里有n个a，请在下面分别输入a和n的值");
	//scanf("%d,%d",&a,&n);// 2 3 
	for(k=1;k<=n;k++)
	{	
		ch=k;
		//做出a..a0
		while((ch-1)!=0)
		{
			ch1=ch;
			//做出10的k-1次方
			while((ch1-1)!=0)
			{
				sum=sum*10;
				ch1--;
			}
			S=S+a*sum;  //     S1=0   S2=S1+2*10=20  S3=S2+2*100=220    S4=S3+2*1000=2220 2*10^0  +  2*10^1  +  
			ch--;
		}
		sum=1;
		//  S==
		
		Sn=Sn+S; //   SN == he-2*n
	}
		//S==
	Sn=Sn+n*a;
	printf("%d",Sn);
	return 0;
}//printf("你爸逼的");