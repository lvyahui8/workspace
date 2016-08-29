#include <stdio.h>
//TeX中的引号问题
int main(){
    int c , q = 1;
    while ((c = getchar()) != EOF){
        if('"' == c){
            printf("%s",q ? "``" : "\"");
            q = !q;
        }
        else{
            printf("%c",c);
        }
    }
    return 0;
}
