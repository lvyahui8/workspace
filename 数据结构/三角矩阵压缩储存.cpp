
//这里只写下三角矩阵
#include <stdio.h>
#define STAGE 5						//方阵的阶数
#define SIZE ((STAGE*(STAGE+1)/2)+1)	//压缩储存后剩余的元素个数

void Compress(int (*sym_matrix)[STAGE],int * vector){
	int i,j;
	for(i=0;i<STAGE;i++){			//下三角压缩
		for(j=0;j<=i;j++){
			vector[i*(i+1)/2+j]=sym_matrix[i][j];
			//或者 *vector++ = *(*(sym_matrix+i)+j);
		}
	}
	vector[SIZE-1] = sym_matrix[0][1];
}

void Decompress(int * vector,int (*sym_matrix)[STAGE]){
	int i,j;
	for(i=0;i<STAGE;i++){
		for(j=0;j<=STAGE;j++){
			if(i>=j)
				sym_matrix[i][j]=vector[i*(i+1)/2+j];	//下三角
			else
				sym_matrix[i][j]=vector[SIZE-1];		//上三角
		}
	}
}
	
void main(){
	int sym_mat[STAGE][STAGE]={
		{3,0,0,0,0},
		{6,2,0,0,0},
		{4,8,1,0,0},
		{7,4,6,3,0},
		{8,2,9,5,7}
	};
	int ver[SIZE];
	int de_sym_mat[STAGE][STAGE];		//用来储存解压后的矩阵
	//压缩储存
	Compress(sym_mat,ver);
	for(int i=0;i<SIZE;i++)
		printf("%d ",ver[i]);
	putchar(10);
	//解压
	Decompress(ver,de_sym_mat);
	for(i=0;i<STAGE*STAGE;i++)
	{
		if(i%STAGE==0)
			putchar(10);
		printf("%d ",*(*de_sym_mat+i));
		
	}
}