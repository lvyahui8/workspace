#ifndef __GLISTS_H__
#define __GLISTS_H__

//	=====================�����Ķ���==============================

//	--------------ͷβ����洢-----------------------------
typedef enum {ATOM,LIST} ElemTag;
typedef int AtomType;		//	ԭ������
typedef struct GLNode{
	ElemTag	tag;
	union{
		AtomType	atom;	//	ԭ��ֵ��
		struct{
			struct GLNode * hp, * tp
		}ptr;		//	ptr�Ǳ�ڵ��ָ����hpָ���ͷ��tpָ���β
	}
}GLNode,*GLists;

//	-------------��չ��������洢------------------------
typedef struct GLNode{
	ElemTag	tag;
	union{
		AtomType	atom;	//	ԭ��ֵ��
		struct GLNode * hp; //	ptr�Ǳ�ڵ��ָ����hpָ���ͷ��tpָ���β
	}
	struct GLNode	* tp;
}GLNode,*GLists;

#endif//__GLISTS_H__