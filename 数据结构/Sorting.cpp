#include <stdio.h>
#define MAXSIZE		20

typedef int KeyType;
typedef struct {
	KeyType key;
}RedType;
typedef struct{
	RedType r[MAXSIZE+1];
	int length;
}SqList;
//---------------------÷±Ω”≤Â»Î≈≈–Ú---------------------
void InsertSort(SqList & L){
	int i,j;
	for (i=2;i<=L.length;i++)
	{
		L.r[0] = L.r[i];
		j = i -1;
		while (L.r[0].key < L.r[j].key)
		{
			L.r[j+1] = L.r[j];
			j--;
		}
		L.r[j+1] = L.r[0];
	}
}


void Show(SqList const & sqlist){
	for (int i = 1;i<=sqlist.length;i++)
	{
		printf("%d ",sqlist.r[i].key);
	}
	putchar(10);
}
void main(){
	SqList	myList ={
		{NULL,3,4,1,9,5,2,7,6,8},
		9
	};
	Show(myList);
// 	InsertSort(myList);
	Show(myList);
}