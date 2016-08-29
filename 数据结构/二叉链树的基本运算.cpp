#include <stdio.h>
#include <malloc.h>

typedef struct bitnode{
	int m_iDate;
	struct bitnode * m_lChild/*左孩子指针*/,* m_rChild/*右孩子指针*/;		
} CBiTNode;


//建立一个带头结点的空的二叉树
CBiTNode * Initiate(){
	CBiTNode * bt;
	bt = (CBiTNode*)malloc(sizeof CBiTNode);
	bt->m_iDate = 0;
	bt->m_lChild = NULL;
	bt->m_rChild = NULL;
	return bt;
}

/*
//建立一个不带头结点的空的二叉树
CBiTNode * Initiate(){
	CBiTNode * bt;
	bt = NULL;
	return bt;
}
*/

//生成一棵以x为根节点数据域信息，以lbt和rbt为左右子树的二叉树
CBiTNode * Create(int x,CBiTNode * lbt,CBiTNode * rbt){
	CBiTNode * p;
	if((p=(CBiTNode*)malloc(sizeof CBiTNode)) ==NULL)
		return NULL;
	p->m_iDate = x;
	p->m_lChild = lbt;
	p->m_rChild = rbt;
	return p;
}

//在二叉树bt中的parent所指节点和其左子树之间插入数据元素为x的节点
bool InsertL(int x,CBiTNode * parent){
	CBiTNode * p;

	if(NULL == parent){
		printf("L插入有误");
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

//在二叉树bt中的parent所指节点和其右子树之间插入数据元素为x的节点
bool InsertR(int x,CBiTNode * parent){
	CBiTNode * p;

	if(NULL == parent){
		printf("R插入有误");
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

//在二叉树bt中删除parent的左子树
bool DeleteL(CBiTNode *parent){
	CBiTNode * p;
	if(NULL == parent){
		printf("L删除出错");
		return 0;
	}

	p = parent->m_lChild;
	parent->m_lChild = NULL;
	free(p);//当*p为分支节点时，这样删除只是删除了子树的根节点。子树的子孙并没有被删除

	return 1;
}

//在二叉树bt中删除parent的右子树
bool DeleteR(CBiTNode *parent){
	CBiTNode * p;
	if(NULL == parent){
		printf("R删除出错");
		return 0;
	}

	p = parent->m_rChild;
	parent->m_rChild = NULL;
	free(p);//当*p为分支节点时，这样删除只是删除了子树的根节点。子树的子孙并没有被删除

	return 1;
}

//二叉树的遍历
//先序遍历二叉树
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
先构造一个如下的二叉树，并先序输出

		0
	1		2
  3	  4   5	  6

*/
	CBiTNode * bt1 = Initiate();
	InsertL(1,bt1);				//将 值1插在根节点的左子树上
	InsertL(3,bt1->m_lChild);	//将 值3插在根节点的左子树的左子树上
	InsertR(4,bt1->m_lChild);	//将 值4插在根节点的左子树的右子树上

	InsertR(2,bt1);				//将 值2插在根节点的右子树上
	InsertL(5,bt1->m_rChild);	//将 值5插在根节点的右子树的左子树上
	InsertR(6,bt1->m_rChild);	//将 值6插在根节点的右子树的右子树上
	PreOrder(bt1);

	putchar(10);
	
/*
再构造一个如下的二叉树，并先序输出

		0
	11		12
 13    14 15   16
*/
	CBiTNode * bt2 = Initiate();
	InsertL(11,bt2);			//将 值1插在根节点的左子树上
	InsertL(13,bt2->m_lChild);	//将 值3插在根节点的左子树的左子树上
	InsertR(14,bt2->m_lChild);	//将 值4插在根节点的左子树的右子树上

	InsertR(12,bt2);			//将 值2插在根节点的右子树上
	InsertL(15,bt2->m_rChild);	//将 值5插在根节点的右子树的左子树上
	InsertR(16,bt2->m_rChild);	//将 值6插在根节点的右子树的右子树上
	PreOrder(bt2);
	putchar(10);
/*
将b1作为新二叉树的左子树，将b2作为右子树，以100为根节点值。得到如下子树,输出
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
删除新二叉树中，第3层第左起第一个节点得到
					   100
				0				0
			 		2		11		12
		 	      5	  6	 13    14 15   16
*/

	DeleteL(bt->m_lChild);
	PreOrder(bt);

}
