#include <stdio.h>
#include <math.h>

int n;
int matrix[128][128];
int s[128];
void inttoseries(int i,int *s) 
{
	int j,k;
	//��������Ż�Ϊ�ƶ�������
	for(k=0,j=i;k<n-1;++k)
	{
		//��ά���鲢δ�ƶ���s[k]��¼��ƫ����,��һ��δ�ƶ�
		s[k]=j%n;j/=n;
	}
}

int maxcolumn(int *s)
{
	int max,i,j,temp;
	// ����������ָ���ƶ�����µ����ֵ��
	for(max=matrix[0][0],i=1;i<n;++i)
		max+=matrix[i][s[i-1]];					//�����1�еĺ�
	for(i=1;i<n;++i)
	{ 
		for(j=1,temp=matrix[0][i];j<n;++j)
			temp+=matrix[j][(s[j-1]+i)%n];      //����� i �еĺ�
		if(temp>max)max=temp;
	} return max;
}

int main(){
	int min,i,j,temp;
	while(scanf("%d",&n),n+1) 
	{   
		for(i = 0;i<n;i++){
			for(j = 0;j<n;j++){
				scanf("%d",&matrix[i][j]);
			}
		}
		inttoseries(0,s);
		min=maxcolumn(s);
		int k = (int)pow(n,n);		//���п��ܵ��������n^n��
		for(i=1;i<k;++i)			//ѭ�������������ƶ����
		{
			inttoseries(i,s);		//��iת�����ƶ�����s
			temp=maxcolumn(s);		//���㰴���ƶ�����s�����ƶ�����ȡ�õ����ֵ
			if(temp<min)min=temp;	
		}
		printf("%d\n",min); 
	} 
	return 0;
}