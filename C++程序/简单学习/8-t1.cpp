
#include <iostream>
#include <vector>
using std::vector;
using std::cout;
using std::endl;
template<class Type>
void Transpose(Type &array){
	int i,j,temp;
	for(i=0;i<3;i++){
		for(j=i+1;j<3;j++){
				temp=array[i][j];
				array[i][j]=array[j][i];
				array[j][i]=temp;
		}
	}
}

void main(){
//	vector<vector<int> >array(3);		//创建一个3行的二维数组
//	for(int i=0;i<array.size();i++)
//		array.resize(3);				//指定列数
	//上面三行代码可以由下面的代码替换
	vector<vector<int> >array(3,vector<int>(3));
	int r=0;	
	int i,j;
	for(i=0;i<3;i++){
		for(j=0;j<3;j++){
			array[i][j]=++r;
		}
	}
	Transpose(array);
	for(i=0;i<3;i++){
		for(j=0;j<3;j++){
			cout<<array[i][j]<<' ';
		}
		cout<<endl;	
	}
}
