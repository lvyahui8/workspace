#include <stdio.h>
#include <string.h>
#define Maxsize 50

void StrInsert(char *S,char *T,int i)
 { char Temp[Maxsize];  /* ����һ����ʱ��*/
   if(i<=strlen(S))
     {
      strcpy(Temp,&S[i]);/*����iλ���Ժ���ַ���������ʱ����*/
      strcpy(&S[i], T);/*����T��������S�ĵ�i��λ�ô������Ǻ�����ַ�*/
      strcat(S,Temp);/*����ʱ���е��ַ����ӵ���S���� */

      }
 }

main()
{ char s[100]="abcdefghijk",t[20]="0123456789";
  StrInsert(&s,&t,4);
  printf("%s",s);
  getch();
  }

