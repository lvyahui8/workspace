/*
          37�������������ѽ���һ������ͷ���ĵ������������еĸ���㰴����������е����ݵ����������ӡ�
		  ����fun�Ĺ����ǣ����β�x��ֵ����һ���½�㲢���뵽�����У�����������������ֵ�Ա��ֵ�������
              ���ڳ�����»��ߴ�������ȷ�����ݲ����»���ɾ����ʹ����ó���ȷ�Ľ����
              ע�⣺Դ�������ڿ����ļ����µ�BLANK1.C�С�
                    �������л�ɾ�У�Ҳ���ø��ĳ���Ľṹ��
*/
          

#include    <stdio.h>
#include    <stdlib.h>
#define    N    8
typedef  struct list
{  int  data;
   struct list  *next;
} SLIST;
void fun( SLIST  *h, int  x)
{  SLIST  *p, *q, *s;
   s=(SLIST *)malloc(sizeof(SLIST));
/**********found**********/x  02  p  03  s
   s->data=x;
   q=h;
   p=h->next;
   while(p!=NULL && x>p->data)
/**********found**********/
      q=p;
      p=p->next;
   }
   s->next=p;
/**********found**********/
   q->next=s;
}
SLIST *creatlist(int  *a)
{  SLIST  *h,*p,*q;      int  i;
   h=p=(SLIST *)malloc(sizeof(SLIST));
   for(i=0; i<N; i++)
   {  q=(SLIST *)malloc(sizeof(SLIST));
      q->data=a[i];  p->next=q;  p=q;
   }
   p->next=0;
   return  h;
}
void outlist(SLIST  *h)
{  SLIST  *p;
   p=h->next;
   if (p==NULL)  printf("\nThe list is NULL!\n");
   else
   {   printf("\nHead");
       do { printf("->%d",p->data);  p=p->next;  } while(p!=NULL);
       printf("->End\n");
   }
}
main()
{  SLIST  *head;      int  x;
   int  a[N]={11,12,15,18,19,22,25,29};
   head=creatlist(a);
   printf("\nThe list before inserting:\n");  outlist(head);
   printf("\nEnter a number :  ");  scanf("%d",&x);
   fun(head,x);
   printf("\nThe list after inserting:\n");  outlist(head);
}


/*
#include<iostream.h>
class A
{
public:
	void print()
	{ 
		
		cout<<"Hello"<<endl;
	}
};
class B
{
public:
	void print()
	{
		cout<<"Hi"<<endl;
	}
};
class C:public A,public B
{
public:
	void  disp( )
	{
		B::print();
	}
};
int main()
{
//	C c;
//	c.disp();
// 	c.B::print();
	int ** pp = new int*[3];   
	pp[0] = new int[3];  
	pp[1] = new int[2]; 
	pp[2] = new int[4];
	for(int i = 0 ;i<4;i++){
		pp[2][i] = i;
	}
	for(i = 0 ;i<4;i++){
		cout<<pp[2][i]<<endl;
	}
	
	return 0;
}*/
