#include <stdio.h>
#include <string.h>
char str[1000000];
int main(){
    int chars[255],k;
    char tmp[255];
    scanf("%d",&k);
    while(k--){
        char ch ;
        int i;
        memset(chars,0,sizeof(chars));
        //while((ch = getchar()) == '\n');
        //getchar();
        gets(str);
        /*
        while((ch = getchar()) != '\n'){
            chars[ch]++;
        }
        */
        int len = strlen(str);

        for(i=0;i<len;i++){
            chars[str[i]]++;
        }

        for(i=0;i<255;i++){
            if(1 == chars[i]){
                printf("%c\n",i);break;
            }
        }
    }
    return 0;
}
