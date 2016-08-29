#include <iostream>
#include <vector>
using std::vector;
using std::cout;
using std::endl;

int * Transpose(int iL_len){
	int (*array)[3] =new int[iL_len][3];
	int i,j,temp,r=0;
	/*
	array[3][3]={
		{1,2,3},
		{4,5,6},
		{7,8,9}
	};*/
	for(i=0;i<iL_len;i++){
		for(j=0;j<3;j++){
			array[i][j]=++r;
		}
	}
	for(i=0;i<iL_len;i++){
		for(j=i;j<3;j++){
			if(i!=j){
				temp=array[i][j];
				array[i][j]=array[j][i];
				array[j][i]=temp;
			}
		}
	}
	return (int*)array;
}

void main(){
	int iL_len=3;
	int * (*fun)(int);
	fun=Transpose;
	int *array = fun(iL_len);
	int i;
	for(i=0;i<3*iL_len;i++){
		if(i%3==0) cout<<endl;
		cout<<*(array+i)<<' ';
	}
}