#include<stdafx.h>


void main()
{
	int c=0;
	char a;
p1:	printf("1.�����ĵȼ�ΪA,����ķ�����Ϊ_____\n int main()\nchar grade;\n");
	printf("scanf(\"%%c\",&grade);\n	printf(\"Your score:\");\nswitch(grade)\ncase'A':printf(\"85~100\\n\");break;\ncase'B':printf(\"70~84\\n\");break;\ncase'C':printf(\"60~69\\n\");break;\ncase'D':printf(\"<60\\n\");break;\ndefault:printf(\"enter data error!\\n\");\nreturn 0;\n");
	printf("��ѡ��A.85~100\nB.70~84\nC.60~69\nD.<60\n");
	getchar();
	
	a=getchar();
	if('A'==a)
	{	
		c+=10;	
	}
	else
	{
		printf("�����������\n");goto p1;
	
	}
	printf("c= %d\n",c);
}

