/*
带状方阵中
阶数为n
带宽为w
则 缺少的个数为   2 * (1+2+3+......+(w-(w+1)/2))。即(w^2-1)/4
有意义元素的个数为   n*w-(w^2-1)/4
*/
#include <stdio.h>
#define STAGE 5							//方阵的阶数
#define BANDWIDTH 3						//带宽,只有可能是奇数，最小值为3.
#define SIZE ((BANDWIDTH*STAGE)-((BANDWIDTH*BANDWIDTH)-1)/4)	//压缩储存后剩余的元素个数

void Compress(int (*sym_matrix)[STAGE],int w,int * vector){
	int i,j;
	int n=(w+1)/2;
	for(i=0;i<STAGE;i++){				
		for(j=i-1;j<i-1+w;j++){			//只扫描有值的元素
			if(-1 == j) continue;
			if(STAGE == j) break;
			vector[((w-1)*i+j+n-1)-1]=sym_matrix[i][j];	//  第A[i][j]个元素刚好是线性表中第 (w*i-1)+(j-i+n)==(w-1)*i+j+n-1 个元素;
		}
	}
}

void Decompress(int * vector,int w,int (*sym_matrix)[STAGE]){
	int i,j;
	int n=(w+1)/2;
	for(i=0;i<STAGE;i++){
		for(j=0;j<=STAGE;j++){
			if(i-j<n && i-j>-n)			//当 |i-j|<n时有非零元素
				sym_matrix[i][j]=vector[((w-1)*i+j+n-1)-1];	
			else
				sym_matrix[i][j]=0;
		}
	}
}

void main(){
	int sym_mat[STAGE][STAGE]={			//存放需要压缩的矩阵
		{3,5,0,0,0},
		{6,2,6,0,0},
		{0,8,1,8,0},
		{0,0,6,3,4},
		{0,0,0,5,7}
	};
	int ver[SIZE];						//压缩储存空间
	int de_sym_mat[STAGE][STAGE];		//用来储存解压后的矩阵
	//压缩储存
	Compress(sym_mat,BANDWIDTH,ver);
	puts("压缩后");
	for(int i=0;i<SIZE;i++)
		printf("%d ",ver[i]);
	putchar(10);
	//解压
	Decompress(ver,BANDWIDTH,de_sym_mat);
	puts("解压后");
	for(i=0;i<STAGE*STAGE;i++){
		if(i%STAGE==0)
			putchar(10);
		printf("%d ",*(*de_sym_mat+i));
	}
	putchar(10);
}