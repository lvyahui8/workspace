//	HuffmanTest.cpp
#include "Huffman.h"
#include <string.h>
#include <malloc.h>
// �������ܣ��ڹ����������HT[1...range]��ѡ�� parent Ϊ0��weight��С��������㣬����ŷֱ�浽s1��s2��
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
	// w���n���ַ���Ȩֵ����>0���������������HT�������n���ַ��Ĺ���������HC
	if(n <= 1) return;
	int m = 2*n-1;
	HT = (HuffmanTree)malloc((m+1)*sizeof(HTNode));		// 0 ��Ԫ��ʹ��
	int i;
	HuffmanTree p=NULL;
	// ��ʼ�������������
	for(p=HT+1,i=1;i<=n;i++,p++,w++){
		p->weight = *w,p->parent = p->lchild = p->rchild = 0;
	}
	for( ;i<=m;i++,p++){
		p->weight = p->parent = p->lchild = p->rchild = 0;
	}
	// ������������
	int s1,s2;
	for(i=n+1;i<=m;i++){
		Select(HT,i-1,s1,s2);
		HT[s1].parent = HT[s2].parent = i;
		HT[i].lchild = s1,HT[i].rchild = s2;
		HT[i].weight = HT[s1].weight+HT[s2].weight;
	}

	// ��Ҷ�ӽڵ㵽��������ÿ���ַ��Ĺ���������
	HC = (HuffmanCode)malloc((n+1)*sizeof(char *));		// ����n���ַ������ͷָ������
	char * cd = (char*)malloc(n*sizeof(char));			// ���������Ĺ����ռ�
	int start;											// ������ʼλ��
	cd[n-1] = '\0';										// ���������
	for(i=1;i<=n;i++){									// ����ַ������������
		start = n-1;									// ��������ʼλ�ú�ĩλ�غ�
		for(int c=i,f=HT[i].parent;f != 0; c=f,f=HT[f].parent){
			if(c == HT[f].lchild)
				cd[--start] = '0';
			else
				cd[--start] = '1';
		}
		HC[i] = (char*)malloc((n-start)*sizeof(char));	// Ϊ��i���ַ��������ռ�
		strcpy(HC[i],&cd[start]);						// �� cd �����ַ����� HC
	}
	free(cd);
}