//	HuffmanTest.cpp
#include "Huffman.h"
#include <string.h>
#include <malloc.h>
// 函数功能：在哈夫曼编码表HT[1...range]中选择 parent 为0且weight最小的两个结点，将序号分别存到s1和s2里
void Select(const HuffmanTree &HT,int range,int &s1,int &s2){
	int i;
	int * pFlags;
	pFlags = (int *)malloc((range+1)*sizeof(int));
	int iFlags=0;
	for(i=1;i<=range;i++){
		if(0 == HT[i].parent){
			pFlags[++iFlags] = i;
		}
	}
	int Min=1000;
	int pMin=pFlags[1];
	for(i=1;i<=iFlags;i++){
		if(HT[pFlags[i]].weight < Min){
			pMin = i;
			Min=HT[pFlags[i]].weight;
		}
	}
	s1=pFlags[pMin];
	Min=1000;
	for(i=1;i<=iFlags;i++){
		if(pFlags[i]!=s1)
			if(HT[pFlags[i]].weight < Min){
				pMin = i;
				Min=HT[pFlags[i]].weight;
			}
	}
	s2=pFlags[pMin];
}
void HuffmanCoding(HuffmanTree &HT,HuffmanCode &HC,int * w, int n){
	// w存放n个字符的权值（均>0），构造哈夫曼树HT，并求出n个字符的哈夫曼编码HC
	if(n <= 1) return;
	int m = 2*n-1;
	HT = (HuffmanTree)malloc((m+1)*sizeof(HTNode));		// 0 单元不使用
	int i;
	HuffmanTree p=NULL;
	// 初始化哈夫曼编码表
	for(p=HT+1,i=1;i<=n;i++,p++,w++){
		p->weight = *w,p->parent = p->lchild = p->rchild = 0;
	}
	for( ;i<=m;i++,p++){
		p->weight = p->parent = p->lchild = p->rchild = 0;
	}
	// 建立哈夫曼树
	int s1,s2;
	for(i=n+1;i<=m;i++){
		Select(HT,i-1,s1,s2);
		HT[s1].parent = HT[s2].parent = i;
		HT[i].lchild = s1,HT[i].rchild = s2;
		HT[i].weight = HT[s1].weight+HT[s2].weight;
	}

	// 从叶子节点到根逆向求每个字符的哈夫曼编码
	HC = (HuffmanCode)malloc((n+1)*sizeof(char *));		// 分配n个字符编码的头指针向量
	char * cd = (char*)malloc(n*sizeof(char));			// 分配求编码的工作空间
	int start;											// 编码起始位置
	cd[n-1] = '\0';										// 编码结束符
	for(i=1;i<=n;i++){									// 逐个字符求哈夫曼编码
		start = n-1;									// 将编码起始位置和末位重合
		for(int c=i,f=HT[i].parent;f != 0; c=f,f=HT[f].parent){
			if(c == HT[f].lchild)
				cd[--start] = '0';
			else
				cd[--start] = '1';
		}
		HC[i] = (char*)malloc((n-start)*sizeof(char));	// 为第i个字符编码分配空间
		strcpy(HC[i],&cd[start]);						// 从 cd 复制字符串到 HC
	}
	free(cd);
}