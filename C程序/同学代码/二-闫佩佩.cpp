#include<stdafx.h>
#include<math.h>
int main()
{
	double a,b,c,s,area;
	scanf("%lf%lf%lf",&a,&b,&c);
	if (a+b<=c || a+c<=b || b+c<=a)
	printf("�������ͼ�β���������\n");
	else
	if (a<0 || b<0 || c<0 )
	printf("����������");
	else
	if(a+b>c && a+c>b && b+c>a)
	{
    s=(a+b+c)/2;
	area=sqrt(s*(s-a)*(s-b)*(s-c));
	printf("area=%f\n",area);
	}
	else
        
	return 0;	
}
    