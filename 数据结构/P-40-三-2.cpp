#include <stdio.h>

#define MAXSIZE 10

typedef struct{
	int arr[MAXSIZE];	//���Ա�
	int last;			//���Ա�ĳ���
} Node;
//ɾ����������Ҫ�β�Ϊ���Ա���׵�ַ
void Delete(Node * N_hand)
{
	int i,p;
	//�������Ա����ظ���ֵ
	for(i=0;N_hand->arr[i] != N_hand->arr[i+1];i++);

	p=i;//��p��¼�ظ�ֵ��λ��

	if(p != N_hand->last)						//���pû��ָ���β��˵�����л����ظ�ֵ����Ҫɾ��
	{
		for(i=p;i<N_hand->last;i++)
			N_hand->arr[i]=N_hand->arr[i+1];	//ɾ��p��ǵ�Ԫ��
		N_hand->last-=1;						//���Ա��ȼ���1
		Delete(N_hand);							//�����������Ա��л���û���ظ�ֵ
	}
}

void main()
{
	int i;
	Node Seq_list={{2,3,3,3,4,5,6,6,7,8},10};
	//��ӡɾ��֮ǰ��˳���
	puts("Removed before the order table:");
	for(i=0;i<Seq_list.last;i++)
		printf("%d ",Seq_list.arr[i]);

	putchar(10);
	//ɾ���ظ�ֵ
	Delete(&Seq_list);

	//��ӡɾ��֮���˳���
	puts("Delete after sequence table:");
	for(i=0;i<Seq_list.last;i++)
		printf("%d ",Seq_list.arr[i]);

	putchar(10);
}


/*
���н��
Removed before the order table:
2 3 3 3 4 5 6 6 7 8
Delete after sequence table:
2 3 4 5 6 7 8
Press any key to continue

  */
