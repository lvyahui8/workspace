#include<stdafx.h>
void main()
{
	int c=0;
	char a;
p1:	printf("1.�뿴���⣬�����ĵȼ�ΪA,����ķ�����Ϊ_____\nint main()\nchar grade;\n");
	printf("scanf(\"%%c\",&grade);\printf(\"Your score:\");\nswitch(grade)\ncase'A':printf(\"85~100\\n\");break;\ncase'B':printf(\"70~84\\n\");break;\ncase'C':printf(\"60~69\\n\");break;\ncase'D':printf(\"<60\\n\");break;\ndefault:printf(\"enter data error!\\n\");\nreturn 0;\n");

	printf("��ѡ��\nA.70~84\nB.85~100\nC.60~69\nD.<60\n");
	scanf("%c%*c",&a);

	if(a=='B')
	{	
	   c+=10;	
	}
	else
	{
		printf("�����������\n");goto p1;
	}

 
p2:	printf("2.�뿴���⣬�����ĵ���ѧ�ɼ�Ϊ89�������г����������______\nint main()\nint score;\n");   
	printf("scanf(\"%%d\",&score);\nif(score>100 || score<0) printf(\"�������!\\n\")return ; \nswitch(score/10)\ncase 0:\ncase 1:\ncase 2:\ncase 3:\ncase 4:\ncase 5:printf(\"��ĳɼ����Ϊ:��\\n\"); break; \ncase 6: printf(\"��ĳɼ����Ϊ:����\\n\"); break;\ncase 7: printf(\"��ĳɼ����Ϊ:��\\n\"); break; \ncase 8: printf(\"��ĳɼ����Ϊ:��\\n\");break; \ndefault: printf(\"��ĳɼ����Ϊ:��\\n\");return 0;\n");
	printf("��ѡ��\nA.��\nB.��\nC.��\nD.��\n");	
	scanf("%c%*c",&a);

	if(a=='D')
	{	
		c+=10;	
	}
	else
	{
		printf("�����������\n");goto p2;
	}
p3:	printf("3.�뿴���⣬������Ⱥ����������9��3�������г����������_____\nint main()\ninclude<math.h>\ndouble x,s;\nint y;\n");
	printf("printf(\"input a number:\\n\");\nscanf(\"%%lf\",&x);\nwhile(1)\n");
	printf("printf(\"��ϣ�������������㣿\\n\");\nprintf(\"1.����sin(x)\\n\");\nprintf(\"2.����cos(x)\\n\");\nprintf(\"3.����tan(x)\\n\");\nscanf(\"%%d\",&y);\nswitch(y)\n");
	printf("case 1:s=sin(x);\nprintf(\"sin(%%f)=%%f\\n\",x,s);break;\ncase 2:s=cos(x);\nprintf(\"cos(%%f)=%%f\\n\",x,s);break;\ncase 3:s=tan(x);\nprintf(\"tan(%%f)=%%f\\n\",x,s);break;\ndefault:\nprintf(\"��������������1~3֮ǰ������!\\n\");\nif(y==1||y==2||y==3)break;\nreturn 0;\n");
	printf("��ѡ��\nA.sin(9)\nB.coc(9)\nC.tan(9)\n");
	scanf("%c%*c",&a);

	if(a=='C')
	{	
	   c+=10;	
	}
	else
	{
		printf("�����������\n");goto p3;
	}
	printf("c= %d\n",c);
	
}