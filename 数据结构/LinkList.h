#ifndef __LINKLIST_H__
#define __LINKLIST_H__

#define NODE_INPUT_FORM		"%d"	//�ڵ���Ϣ�����ʽ
typedef int DATA;					//�ڵ���Ϣ����
typedef struct LNode {
	DATA	data;
	struct LNode * next;
}LNode;

#endif