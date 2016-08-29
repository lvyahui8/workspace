/*
          37、给定程序中已建立一个带有头结点的单向链表，链表中的各结点按结点数据域中的数据递增有序链接。
		  函数fun的功能是：把形参x的值放入一个新结点并插入到链表中，插入后各结点数据域的值仍保持递增有序。
              请在程序的下划线处填入正确的内容并把下划线删除，使程序得出正确的结果。
              注意：源程序存放在考生文件夹下的BLANK1.C中。
                    不得增行或删行，也不得更改程序的结构！
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
