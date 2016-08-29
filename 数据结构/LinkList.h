#ifndef __LINKLIST_H__
#define __LINKLIST_H__

#define NODE_INPUT_FORM		"%d"	//节点信息输入格式
typedef int DATA;					//节点信息类型
typedef struct LNode {
	DATA	data;
	struct LNode * next;
}LNode;

#endif