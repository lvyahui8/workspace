#include<stdio.h>
#include<math.h>
void main()
{
float a,b,c,s,area;
printf("请在以下输入三边的长度:\n");
scanf("%f%f%f",&a,&b,&c);
s=(a+b+c)/2;
if(a+b>c&&a+c>b&&b+c>a)
{
    area=sqrt(s*(s-a)*(s-b)*(s-c));
    printf("area=%f",area);
}
else
printf("不能构成三角形");
}