#include <stdio.h>

int main(){
	
	int n;
	while(scanf("%d",&n)==1){
		int i,k;
		for(k=1;k<=n;k++){
			putchar('a');
			for(i=n-k;i>0;i--){putchar(' ');}
			for(i=0;i<k;i++){putchar('a'+i);}
			putchar('\n');
		}
		putchar('\n');
	}

	return 0;
}