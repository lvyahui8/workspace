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
		if(found && op[k] != '='){		//����ҵ��ˣ�����ʵ����Ϊ����ȡ���id�п����Ǽٱ�
			isTrue = false;
		}
		else{
			isTrue = true;
		}
	}
	return true;
}
int main(){

	scanf("%d%d",&n,&k);		//���������Ͳ�����������
	if(!(2<=n && n <=1000) || !(1 <= k && k <= 100)){
		return 1;
	}
	int i,j;
	for(i = 0;i < k;i++){
		scanf("%d",&ids[i][0]);					//�������ʵ��ÿ�����Ϸ��õĽ�Ҹ���
		for(j = 1;j <= (ids[i][0]<<1);j++){
			scanf("%d",&ids[i][j]);				//���������ұ��
		}
		scanf("%c",&op[i]);
	}

	//�ӵ�1����ҿ�ʼ������У���i������Ƿ�Ϊ��
	for(i = 1; i <= n ;i++){
		if(!isTrue(i)){
			break;
		}
	}
	printf("%d",i);
	return 0;
}