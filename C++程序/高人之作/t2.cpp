#include<iostream.h>
#include<stdlib.h>
void print(int *a)
{ 
  for(int i=0;i<9;i++)
  {
   cout<<*a;
   cout<<"  ";
   a++;
   if((i+1)%3==0)cout<<endl;
  }
}

void reserve(int *&a)
{
  int b[3][3],i,j;
  int *c;
  c=a;
  for(i=0;i<3;i++)
  {
    for(j=0;j<3;j++)
 {
  b[i][j]=*a;
  a++;
 }
  }
  a=c;
for(i=0;i<3;i++)
  {
    for(j=0;j<3;j++)
 {
  *a=b[j][i];
  a++;
 }
  }
a=c;
}

void main()
{
  int i,j;
  int *a,*b;
  a=(int *)new int[3][3];
  b=a;
  cout<<"��������������е�Ԫ��:"<<endl;
  for(i=0;i<9;i++)
  {
  cin>>*a;
  a++;
  }
  a=b;
cout<<"�˾����е�Ԫ��Ϊ:"<<endl;
print(a);
reserve(a);
cout<<"����ת�ú�˾���Ϊ:"<<endl;
print(a);
}


