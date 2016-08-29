#include <stdio.h>
#include <string.h>

char chs[98];

char ch;
int main(){
	freopen("a.in","r",stdin);
	memset(chs,0,sizeof(chs[0]));
	while((ch = getchar()) != EOF){
		if(ch >= 'a' && ch <= 'z'){
			chs[ch-32]++;
		}
		else{
			chs[ch]++;
		}
		
	}
	
	// find max;
	int max = -1;
	int i = 0; 
	for(i=0;i<97;i++){if(chs[i] && chs[i] > max && i >= 'A' && i <= 'Z'){
		max = chs[i];
	}}
	
	

	for(i=0;i<max;i++){
		for(int j=0;j<26;j++){
			if(i>=(max-chs['A'+j])){
				putchar('*');
			}else{
				putchar(' ');
			}
			if(j!=25)putchar(' ');//最后不能输出空格
		}
		putchar('\n');
	}

	for(i=0;i<26;i++){putchar('A'+i);putchar(' ');}
	putchar('\n');
	return 0;
}