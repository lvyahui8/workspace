/*
��״������
����Ϊn
����Ϊw
�� ȱ�ٵĸ���Ϊ   2 * (1+2+3+......+(w-(w+1)/2))����(w^2-1)/4
������Ԫ�صĸ���Ϊ   n*w-(w^2-1)/4
*/
#include <stdio.h>
#define STAGE 5							//����Ľ���
#define BANDWIDTH 3						//����,ֻ�п�������������СֵΪ3.
#define SIZE ((BANDWIDTH*STAGE)-((BANDWIDTH*BANDWIDTH)-1)/4)	//ѹ�������ʣ���Ԫ�ظ���

void Compress(int (*sym_matrix)[STAGE],int w,int * vector){
	int i,j;
	int n=(w+1)/2;
	for(i=0;i<STAGE;i++){				
		for(j=i-1;j<i-1+w;j++){			//ֻɨ����ֵ��Ԫ��
			if(-1 == j) continue;
			if(STAGE == j) break;
			vector[((w-1)*i+j+n-1)-1]=sym_matrix[i][j];	//  ��A[i][j]��Ԫ�ظպ������Ա��е� (w*i-1)+(j-i+n)==(w-1)*i+j+n-1 ��Ԫ��;
		}
	}
}

void Decompress(int * vector,int w,int (*sym_matrix)[STAGE]){
	int i,j;
	int n=(w+1)/2;
	for(i=0;i<STAGE;i++){
		for(j=0;j<=STAGE;j++){
			if(i-j<n && i-j>-n)			//�� |i-j|<nʱ�з���Ԫ��
				sym_matrix[i][j]=vector[((w-1)*i+j+n-1)-1];	
			else
				sym_matrix[i][j]=0;
		}
	}
}

void main(){
	int sym_mat[STAGE][STAGE]={			//�����Ҫѹ���ľ���
		{3,5,0,0,0},
		{6,2,6,0,0},
		{0,8,1,8,0},
		{0,0,6,3,4},
		{0,0,0,5,7}
	};
	int ver[SIZE];						//ѹ������ռ�
	int de_sym_mat[STAGE][STAGE];		//���������ѹ��ľ���
	//ѹ������
	Compress(sym_mat,BANDWIDTH,ver);
	puts("ѹ����");
	for(int i=0;i<SIZE;i++)
		printf("%d ",ver[i]);
	putchar(10);
	//��ѹ
	Decompress(ver,BANDWIDTH,de_sym_mat);
	puts("��ѹ��");
	for(i=0;i<STAGE*STAGE;i++){
		if(i%STAGE==0)
			putchar(10);
		printf("%d ",*(*de_sym_mat+i));
	}
	putchar(10);
}