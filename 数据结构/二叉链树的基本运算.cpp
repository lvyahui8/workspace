#include <stdio.h>
#include <malloc.h>

typedef struct bitnode{
	int m_iDate;
	struct bitnode * m_lChild/*����ָ��*/,* m_rChild/*�Һ���ָ��*/;		
} CBiTNode;


//����һ����ͷ���ĿյĶ�����
CBiTNode * Initiate(){
	CBiTNode * bt;
	bt = (CBiTNode*)malloc(sizeof CBiTNode);
	bt->m_iDate = 0;
	bt->m_lChild = NULL;
	bt->m_rChild = NULL;
	return bt;
}

/*
//����һ������ͷ���ĿյĶ�����
CBiTNode * Initiate(){
	CBiTNode * bt;
	bt = NULL;
	return bt;
}
*/

//����һ����xΪ���ڵ���������Ϣ����lbt��rbtΪ���������Ķ�����
CBiTNode * Create(int x,CBiTNode * lbt,CBiTNode * rbt){
	CBiTNode * p;
	if((p=(CBiTNode*)malloc(sizeof CBiTNode)) ==NULL)
		return NULL;
	p->m_iDate = x;
	p->m_lChild = lbt;
	p->m_rChild = rbt;
	return p;
}

//�ڶ�����bt�е�parent��ָ�ڵ����������֮���������Ԫ��Ϊx�Ľڵ�
bool InsertL(int x,CBiTNode * parent){
	CBiTNode * p;

	if(NULL == parent){
		printf("L��������");
		return 0;
	}

	if((p=(CBiTNode*)malloc(sizeof CBiTNode)) ==NULL)
		return 0;

	p->m_iDate = x;
	p->m_lChild = NULL;
	p->m_rChild = NULL;

	if(NULL == parent->m_lChild)
		parent->m_lChild = p;
	else{
		p->m_lChild = parent->m_lChild;
		parent->m_lChild = p;
	}

	return 1;
}

//�ڶ�����bt�е�parent��ָ�ڵ����������֮���������Ԫ��Ϊx�Ľڵ�
bool InsertR(int x,CBiTNode * parent){
	CBiTNode * p;

	if(NULL == parent){
		printf("R��������");
		return 0;
	}

	if((p=(CBiTNode*)malloc(sizeof CBiTNode)) ==NULL)
		return 0;

	p->m_iDate = x;
	p->m_lChild = NULL;
	p->m_rChild = NULL;

	if(NULL == parent->m_rChild)
		parent->m_rChild = p;
	else{
		p->m_rChild = parent->m_rChild;
		parent->m_rChild = p;
	}

	return 1;
}

//�ڶ�����bt��ɾ��parent��������
bool DeleteL(CBiTNode *parent){
	CBiTNode * p;
	if(NULL == parent){
		printf("Lɾ������");
		return 0;
	}

	p = parent->m_lChild;
	parent->m_lChild = NULL;
	free(p);//��*pΪ��֧�ڵ�ʱ������ɾ��ֻ��ɾ���������ĸ��ڵ㡣���������ﲢû�б�ɾ��

	return 1;
}

//�ڶ�����bt��ɾ��parent��������
bool DeleteR(CBiTNode *parent){
	CBiTNode * p;
	if(NULL == parent){
		printf("Rɾ������");
		return 0;
	}

	p = parent->m_rChild;
	parent->m_rChild = NULL;
	free(p);//��*pΪ��֧�ڵ�ʱ������ɾ��ֻ��ɾ���������ĸ��ڵ㡣���������ﲢû�б�ɾ��

	return 1;
}

//�������ı���
//�������������
bool PreOrder(CBiTNode * bt){
	if(NULL == bt)
		return 0;
	else{
		printf("bt->m_iDate == %d\n",bt->m_iDate);
		PreOrder(bt->m_lChild);
		PreOrder(bt->m_rChild);
		return 1;
	}
}


void main(){
/*
�ȹ���һ�����µĶ����������������

		0
	1		2
  3	  4   5	  6

*/
	CBiTNode * bt1 = Initiate();
	InsertL(1,bt1);				//�� ֵ1���ڸ��ڵ����������
	InsertL(3,bt1->m_lChild);	//�� ֵ3���ڸ��ڵ������������������
	InsertR(4,bt1->m_lChild);	//�� ֵ4���ڸ��ڵ������������������

	InsertR(2,bt1);				//�� ֵ2���ڸ��ڵ����������
	InsertL(5,bt1->m_rChild);	//�� ֵ5���ڸ��ڵ������������������
	InsertR(6,bt1->m_rChild);	//�� ֵ6���ڸ��ڵ������������������
	PreOrder(bt1);

	putchar(10);
	
/*
�ٹ���һ�����µĶ����������������

		0
	11		12
 13    14 15   16
*/
	CBiTNode * bt2 = Initiate();
	InsertL(11,bt2);			//�� ֵ1���ڸ��ڵ����������
	InsertL(13,bt2->m_lChild);	//�� ֵ3���ڸ��ڵ������������������
	InsertR(14,bt2->m_lChild);	//�� ֵ4���ڸ��ڵ������������������

	InsertR(12,bt2);			//�� ֵ2���ڸ��ڵ����������
	InsertL(15,bt2->m_rChild);	//�� ֵ5���ڸ��ڵ������������������
	InsertR(16,bt2->m_rChild);	//�� ֵ6���ڸ��ڵ������������������
	PreOrder(bt2);
	putchar(10);
/*
��b1��Ϊ�¶�����������������b2��Ϊ����������100Ϊ���ڵ�ֵ���õ���������,���
					   100
				0				0
			1		2		11		12
		3	  4   5	  6	 13    14 15   16
*/
	CBiTNode *bt;
	bt = Create(100,bt1,bt2);
	PreOrder(bt);
	putchar(10);

/*
ɾ���¶������У���3��������һ���ڵ�õ�
					   100
				0				0
			 		2		11		12
		 	      5	  6	 13    14 15   16
*/

	DeleteL(bt->m_lChild);
	PreOrder(bt);

}
