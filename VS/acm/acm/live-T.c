#include <stdio.h>

int main(){
	int p,e,i,d,kase=0;
	int step = 23 * 28;
	scanf("%d%d%d%d",&p,&e,&i,&d);
	while (p!=-1 && e!=-1 && i!=-1 && d!=-1 )
	{
		int j ;
		for(j=d+1;j<21252;j++){
			if((j-p)%23 == 0){
				break;
			}
		}
		for(;j<21252;j+=23){
			if((j-e)%28==0){
				break;
			}
		}
		
		for(;j<21252;j+=(step)){
			if ((j-i)%33==0)
			{
				break;
			}
		}
		printf("Case %2d:",++kase);
		printf("the next triple peak occurs in %d days.\n",j-d);
		scanf("%d%d%d%d",&p,&e,&i,&d);
	}
	return 0;
}
