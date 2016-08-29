
//����ֻд�����Ǿ���
#include <stdio.h>
#define STAGE 5						//����Ľ���
#define SIZE ((STAGE*(STAGE+1)/2)+1)	//ѹ�������ʣ���Ԫ�ظ���

void Compress(int (*sym_matrix)[STAGE],int * vector){
	int i,j;
	for(i=0;i<STAGE;i++){			//������ѹ��
		for(j=0;j<=i;j++){
			vector[i*(i+1)/2+j]=sym_matrix[i][j];
			//���� *vector++ = *(*(sym_matrix+i)+j);
		}
	}
	vector[SIZE-1] = sym_matrix[0][1];
}

void Decompress(int * vector,int (*sym_matrix)[STAGE]){
	int i,j;
	for(i=0;i<STAGE;i++){
		for(j=0;j<=STAGE;j++){
			if(i>=j)
				sym_matrix[i][j]=vector[i*(i+1)/2+j];	//������
			else
				sym_matrix[i][j]=vector[SIZE-1];		//������
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
	int de_sym_mat[STAGE][STAGE];		//���������ѹ��ľ���
	//ѹ������
	Compress(sym_mat,ver);
	for(int i=0;i<SIZE;i++)
		printf("%d ",ver[i]);
	putchar(10);
	//��ѹ
	Decompress(ver,de_sym_mat);
	for(i=0;i<STAGE*STAGE;i++)
	{
		if(i%STAGE==0)
			putchar(10);
		printf("%d ",*(*de_sym_mat+i));
		
	}
}