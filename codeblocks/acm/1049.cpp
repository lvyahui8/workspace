#include <stdio.h>
#include <stdlib.h>

int w[21];

int main(){
	int n,i,tmp,k,min;
	while(scanf("%d",&n) == 1){
		for(i=0;i<21;i++){w[i]=0;}
		for(i=0;i<n;i++){
			scanf("%d",&tmp);
			w[tmp]++;
		}
		k = 0;
		for(i=20;i>=1;i--){
			if(w[i]){
				if(k>3){
					printf("%d\n",w[i]);
					break;
				}
				k++;
			}
		}
	}
	return 0;
}