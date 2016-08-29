#include <stdio.h>
int ids[126][1024];
int op[126];
int n,k;
int pi;

bool isTrue(int id){
	int i;
	bool found = false;
	bool isTrue = false;
	for(i=0;i < k;i++){
		int j;
		for(j = 1;j<(ids[i][0]<<1);j++){
			if(ids[i][j] == id){
				found = true;
			}
		}
		if(found && op[k] != '='){		//如果找到了，并且实验结果为不相等。则id有可能是假币
			isTrue = false;
		}
		else{
			isTrue = true;
		}
	}
	return true;
}
int main(){

	scanf("%d%d",&n,&k);		//输入金币数和测试数据组数
	if(!(2<=n && n <=1000) || !(1 <= k && k <= 100)){
		return 1;
	}
	int i,j;
	for(i = 0;i < k;i++){
		scanf("%d",&ids[i][0]);					//输出本次实验每个盘上放置的金币个数
		for(j = 1;j <= (ids[i][0]<<1);j++){
			scanf("%d",&ids[i][j]);				//依次输入金币编号
		}
		scanf("%c",&op[i]);
	}

	//从第1个金币开始，迭代校验第i个金币是否为真
	for(i = 1; i <= n ;i++){
		if(!isTrue(i)){
			break;
		}
	}
	printf("%d",i);
	return 0;
}