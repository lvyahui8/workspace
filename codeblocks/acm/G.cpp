#include <cstdio>
#include <cstring>
#include <algorithm>
#include <cstdlib>
using namespace std;

/*
E.cpp
ºÍ
G.cpp
2345678923457834567856789898923456789^2
E£º5502209611954305721294583188212718740546171310018593801000000000000000000   Process returned 0 (0x0)   execution time : 0.336 s
G£º5502209611954305721294583188212719515018394635167318026962207485150190521   Process returned 0 (0x0)   execution time : 0.269 s
*/

void  mult(char * str1,char *str2,char *str3){
    int i,j,i1,i2,tmp,carry,jj;
    int len1 = strlen(str1),len2 = strlen(str2);
    char ch;

    jj = carry = 0;

    for (i1 = len1-1;i1>=0 ;--i1 ){
        j = jj;
        for (i2=len2-1;i2>=0 ; --i2,++j){
            tmp = (str3[j]-'0')+(str1[i1]-'0')*(str2[i2]-'0')+carry;
            if(tmp>9){
                carry = tmp/10; str3[j] = tmp%10+'0';
            }
            else{
                str3[j] = tmp+'0';carry = 0;
            }
        }
        if(carry){
            str3[j] = carry+'0';carry = 0;++j;
        }
        ++jj;
    }
    --j;
    while (str3[j] == '0' && j >0) --j;
    str3[++j] = '\0';
    for (i=0,--j ;i<j;++i,--j ){
        ch = str3[i];str3[i] = str3[j];str3[j] = ch;
    }
}

int main()
{
    char * str1 = "2345678923457834567856789898923456789";
    char * str2 = "2345678923457834567856789898923456789";
    char res[512];
    memset(res,'0',sizeof(res));
    mult(str1,str2,res);
    printf("%s\n",res);
	return 0;
}
