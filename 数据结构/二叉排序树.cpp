#include <stdio.h>
#include <malloc.h>

typedef struct bsTree{
	int m_iDate;
	struct bsTree * m_lChild/*左孩子指针*/,* m_rChild/*右孩子指针*/;
} * BsTree,BsNode ;

BsTree  insert(BsTree  bs,int x){
    BsNode * p = bs;
    BsNode * note  = p;
    BsNode * ct = NULL;
    while(p){
        if(x == p->m_iDate){
            return p;
        }
        else{
            // 记录上一个节点
            note = p;
            if(x < p->m_iDate) p = p->m_lChild;
            else p = p->m_rChild;
        }
    }

    ct = (BsNode * )malloc(sizeof(BsNode));
    ct->m_iDate = x;
    ct->m_rChild = NULL;
    ct->m_lChild = NULL;
    if(!bs){
        bs = ct;
    }else if(x < note->m_iDate){
        note->m_lChild = ct;
    }else note->m_rChild = ct;
    return bs;
}

BsNode * search(BsTree bs , int x){
    if(!bs || bs->m_iDate == x){
        return bs;
    }else if(x < bs->m_iDate){
        return search(bs->m_lChild,x);
    }else{
        return search(bs->m_rChild,x);
    }
}
