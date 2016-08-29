#include <stdio.h>
#define MAXN 512

typedef struct Matrix {
	long int mat[MAXN][MAXN];
	int row,col;
	Matrix operator * (const Matrix & m){
		if (this->col != m.row) {
			return *this;
		}
		Matrix tmp;
		tmp.row = this->row;
		tmp.col = m.col;
		for (int i = 0;i < tmp.row ; i++) {
			for (int j = 0;j < tmp.col;j++) {
				tmp.mat[i][j] = 0;
				for(int k = 0;k < this->col;k ++){
					tmp.mat[i][j] += this->mat[i][k]*m.mat[k][j];
				}
			}
		}
		return tmp;
	}
}Matrix;

void print_mat(Matrix mat){
	for (int i = 0 ;i < mat.row; i++) {
		for (int j = 0; j < mat.col; j++) {
			printf("%d ",mat.mat[i][j]);
		}
		printf("\n");
	}
}
int main(){
	//int a[MAXN],f[MAXN];
	//int d,n,m;
	/*
	while((scanf("%d%d%d",&d,&n,&m) == 3) && d!=0){
		for (int i = 0;i < d;i++) {
			scanf("%d",&a[i]);		
		}
		
		for (i = d-1; i >= 0;i--) {
			scanf("%d",&f[i]);
		}
		int ans = 0;
		for (i = 0; i < d; i ++) {
			ans += a[i]*f[i];
		}
		printf("%d\n",ans);
	}

	*/
	int row , col;
	scanf("%d%d",&row,&col);
	Matrix mat1;
	mat1.row = row;
	mat1.col = col;
	for (int i = 0 ;i < mat1.row; i++) {
		for (int j = 0; j < mat1.col; j++) {
			scanf("%d",&mat1.mat[i][j]);
		}
	}
	scanf("%d%d",&row,&col);
	Matrix mat2;
	mat2.row = row;
	mat2.col = col;
	for (i = 0 ;i < mat2.row; i++) {
		for (int j = 0; j < mat2.col; j++) {
			scanf("%d",&mat2.mat[i][j]);
		}
	}


	print_mat(mat1*mat2);
	return 0;
}
