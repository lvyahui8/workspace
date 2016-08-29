#include <stdio.h>
#include <math.h>

int n;
int matrix[128][128];
int s[128];
void inttoseries(int i,int *s) 
{
	int j,k;
	//函数将序号化为移动的序列
	for(k=0,j=i;k<n-1;++k)
	{
		//二维数组并未移动，s[k]记录的偏移量,第一行未移动
		s[k]=j%n;j/=n;
	}
}

int maxcolumn(int *s)
{
	int max,i,j,temp;
	// 函数返回在指定移动情况下的最大值。
	for(max=matrix[0][0],i=1;i<n;++i)
		max+=matrix[i][s[i-1]];					//计算第1列的和
	for(i=1;i<n;++i)
	{ 
		for(j=1,temp=matrix[0][i];j<n;++j)
			temp+=matrix[j][(s[j-1]+i)%n];      //计算第 i 列的和
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
		int k = (int)pow(n,n);		//所有可能的情况共有n^n种
		for(i=1;i<k;++i)			//循环将遍历所有移动情况
		{
			inttoseries(i,s);		//将i转换成移动编码s
			temp=maxcolumn(s);		//计算按照移动编码s进行移动所能取得的最大值
			if(temp<min)min=temp;	
		}
		printf("%d\n",min); 
	} 
	return 0;
}