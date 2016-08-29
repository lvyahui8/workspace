#include <cstdio>
#include <cstring>
#include <algorithm>
#include <cstdlib>
using namespace std;
const int maxn = 80;


void  mult(char a[],char b[],char s[]){
    int i,j,k=0,alen,blen,sum=0,res[maxn][maxn]={0},flag =0;

    char result[maxn];
    alen = strlen(a);blen = strlen(b);
    for(i=0;i<alen;i++){
        for (j=0;j<blen ; j++){
            res[i][j] = (a[i]-'0')*(b[j]-'0');
        }
    }
    for (i=alen-1;i>=0 ;i-- ){
        for (j=blen-1;j>=0 ;j-- ){
            sum = sum + res[i+blen-k-1][j];

        }
        result[k] = sum%10;
        k+=1;
        sum/=10;
    }
    for (i=blen-2;i>=0 ;i-- ){
        for (j=0;j<=i ;j++ ){
            sum += res[i-j][j];
        }
        result[k] = sum%10;
        k+=1;
        sum/=10;
    }
    if (sum!=0){
        result[k] = sum;k=k+1;
    }
    for (i=0;i<k ; i++){
        result[i]+='0';
    }
    for (i=k-1;i>=0; i--){
        s[i] = result[k-1-i];
    }
    s[k] = '\0';
    while (1){
        if (strlen(s)!=strlen(a)&&s[0] =='0'){
            strcpy(s,s+1);
        }
        else{
            break;
        }
    }
}

int main()
{
    char * str1 = "2345678923457834567856789898923456789";
    char * str2 = "2345678923457834567856789898923456789";
    char * res ;
    mult(str1,str2,res);
    printf("%s\n",res);
	return 0;
}
