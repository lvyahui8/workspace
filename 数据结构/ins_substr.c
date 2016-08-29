#include <stdio.h>
#include <string.h>
#define Maxsize 50

void StrInsert(char *S,char *T,int i)
 { char Temp[Maxsize];  /* 设置一个临时串*/
   if(i<=strlen(S))
     {
      strcpy(Temp,&S[i]);/*将第i位起以后的字符拷贝到临时串中*/
      strcpy(&S[i], T);/*将串T拷贝到串S的第i个位置处，覆盖后面的字符*/
      strcat(S,Temp);/*把临时串中的字符联接到串S后面 */

      }
 }

main()
{ char s[100]="abcdefghijk",t[20]="0123456789";
  StrInsert(&s,&t,4);
  printf("%s",s);
  getch();
  }

