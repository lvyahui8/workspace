#include <iostream>
using namespace std;

int main(){
	int p,e,i,d;
	
	int ans ;
	while(scanf("%d%d%d%d",&p,&e,&i,&d) == 4 && p !=0){
		int i;
		for ( i = d + 1; i < 21252; ++i)
		{
			if((i - p)%23==0) break;
		}
		for ( ; i < 21252; i+=23)
		{
			if ((i - e)%28==0)
			{
				break;
			}
		}
		for (; i < 21252; i += 23*28)
		{
			if ((i % 33) == 0)
			{
				break;
			}
		}
		if(i<21252){
			printf("%d\n",i - d);
		}
		else{
			printf("No Ans\n");
		}
	}
}