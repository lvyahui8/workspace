#include <stdio.h>

#define MAXSIZE 10

typedef struct{
	int arr[MAXSIZE];	//线性表
	int last;			//线性表的长度
} Node;
//删除函数，需要形参为线性表的首地址
void Delete(Node * N_hand)
{
	int i,p;
	//查找线性表中重复的值
	for(i=0;N_hand->arr[i] != N_hand->arr[i+1];i++);

	p=i;//用p记录重复值的位置

	if(p != N_hand->last)						//如果p没有指向结尾，说明表中还有重复值，需要删除
	{
		for(i=p;i<N_hand->last;i++)
			N_hand->arr[i]=N_hand->arr[i+1];	//删除p标记的元素
		N_hand->last-=1;						//线性表长度减少1
		Delete(N_hand);							//继续查找线性表中还有没有重复值
	}
}

void main()
{
	int i;
	Node Seq_list={{2,3,3,3,4,5,6,6,7,8},10};
	//打印删除之前的顺序表
	puts("Removed before the order table:");
	for(i=0;i<Seq_list.last;i++)
		printf("%d ",Seq_list.arr[i]);

	putchar(10);
	//删除重复值
	Delete(&Seq_list);

	//打印删除之后的顺序表
	puts("Delete after sequence table:");
	for(i=0;i<Seq_list.last;i++)
		printf("%d ",Seq_list.arr[i]);

	putchar(10);
}


/*
运行结果
Removed before the order table:
2 3 3 3 4 5 6 6 7 8
Delete after sequence table:
2 3 4 5 6 7 8
Press any key to continue

  */
