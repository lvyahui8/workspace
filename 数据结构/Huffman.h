//	Huffman.h
#ifndef __HUFFMAN_H__
#define __HUFFMAN_H__

typedef struct {
	unsigned int weight;
	unsigned int parent,lchild,rchild;
}HTNode,* HuffmanTree;			// ��̬�������鴢���������
typedef char * *HuffmanCode;	// ��̬�������鴢������������

#endif//__HUFFMAN_H__