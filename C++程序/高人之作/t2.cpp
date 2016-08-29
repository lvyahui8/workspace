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
  cout<<"请依次输入距阵中的元素:"<<endl;
  for(i=0;i<9;i++)
  {
  cin>>*a;
  a++;
  }
  a=b;
cout<<"此距阵中的元素为:"<<endl;
print(a);
reserve(a);
cout<<"经过转置后此距阵为:"<<endl;
print(a);
}


