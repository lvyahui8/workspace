#include "stdafx.h"
int main()
{	
	int a=2,n=3,Sn=0,k,sum=1,S=0,ch,ch1;
	//printf("������������a,n \n ������Sn=a+aa+aaa+a...a  �������a...a����n��a����������ֱ�����a��n��ֵ");
	//scanf("%d,%d",&a,&n);// 2 3 
	for(k=1;k<=n;k++)
	{	
		ch=k;
		//����a..a0
		while((ch-1)!=0)
		{
			ch1=ch;
			//����10��k-1�η�
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
}//printf("��ֱƵ�");