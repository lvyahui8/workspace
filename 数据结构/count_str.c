#include <stdio.h>
#include <string.h>
#define Maxsize 50
typedef struct { char ch[Maxsize]; int length;}SeqString;

int SubStrCount(SeqString *S,SeqString *T)
  {                                       /*统计子串T在主串S中出现的次数*/
    int i,j,k,count=0;
    int m=S->length;
    int n=T->length; printf("%4d 4d",m,n);
    for(i=0;i<=m-n;i++)                      /*0≤i≤m-n*/
      {  j=0;k=i;
         while(j<n && S->ch[k]==T->ch[j])
            {
               k++;j++;
             }
         if(j==n)
            count++;
        }
        return count;
    }

main()
{ SeqString *s,*t; int num;
  strcpy(s->ch,"abcdefgcdehijk"),strcpy(t->ch,"cde");
  s->length=strlen(s->ch);t->length=strlen(t->ch);
  num=SubStrCount(s,t);
  printf("num=%d",num);
  getch();
  }

