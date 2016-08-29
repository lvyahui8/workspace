//	Huffman.h
#ifndef __HUFFMAN_H__
#define __HUFFMAN_H__

typedef struct {
	unsigned int weight;
	unsigned int parent,lchild,rchild;
}HTNode,* HuffmanTree;			// 动态分配数组储存哈夫曼树
typedef char * *HuffmanCode;	// 动态分配数组储存哈夫曼编码表

#endif//__HUFFMAN_H__