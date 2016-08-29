#include<stdafx.h>
#include<math.h>

int i=1,n;

int main()
{
	int S(int x,int y);
	int a,sum=0,s=0;
	printf("依次输入a,n的值......\n");
    scanf("%d %d",&a,&n);

    while(i<=n)
	{
		sum=S(a,sum);
		s+=sum;
	}
	printf("s=%d\n",s);
	return 0;

}
int S(int x,int y)
{

	y=x*(pow(10,i)-1)/9;

	i++;
   
	//printf("s=%d\n",s);
    return y;
}
