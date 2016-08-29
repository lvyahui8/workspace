#ifndef __GLISTS_H__
#define __GLISTS_H__

//	=====================广义表的定义==============================

//	--------------头尾链表存储-----------------------------
typedef enum {ATOM,LIST} ElemTag;
typedef int AtomType;		//	原子类型
typedef struct GLNode{
	ElemTag	tag;
	union{
		AtomType	atom;	//	原子值域
		struct{
			struct GLNode * hp, * tp
		}ptr;		//	ptr是表节点的指针域，hp指向表头，tp指向表尾
	}
}GLNode,*GLists;

//	-------------扩展线性链表存储------------------------
typedef struct GLNode{
	ElemTag	tag;
	union{
		AtomType	atom;	//	原子值域
		struct GLNode * hp; //	ptr是表节点的指针域，hp指向表头，tp指向表尾
	}
	struct GLNode	* tp;
}GLNode,*GLists;

#endif//__GLISTS_H__