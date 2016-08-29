#include "Huffman.h"
#include <stdio.h>
#include <stdlib.h>

void HuffmanCoding(HuffmanTree &HT,HuffmanCode &HC,int * w, int n);
void main(){
	system("color F0");
	HuffmanTree HT = NULL;
	HuffmanCode HC = NULL;
	char chArr[8]={'A','B','C','D','E','F','G','H'};
	int w[8]={7,19,2,6,32,3,21,10};
	HuffmanCoding(HT,HC,w,8);
	int i,j;
	printf(    "HT    weight   parent  lchild  rchild\n");
	for(i=1;i<=15;i++){
		printf("%02d\t%2u\t%2u\t%2u\t%2u\n",i,HT[i].weight,HT[i].parent,HT[i].lchild,HT[i].rchild);
	}
	printf("\n\n×Ö·û    È¨Öµ    ±àÂë\n");
	for(i=0;i<8;i++){
		printf("%c\t%2d\t%-8s\n",chArr[i],w[i],HC[i+1]);
	}
}