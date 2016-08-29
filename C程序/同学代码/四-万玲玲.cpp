#include<stdafx.h>
void main()
{
	int c=0;
	char a;
p1:	printf("1.请看下题，如果你的等级为A,则你的分数段为_____\nint main()\nchar grade;\n");
	printf("scanf(\"%%c\",&grade);\printf(\"Your score:\");\nswitch(grade)\ncase'A':printf(\"85~100\\n\");break;\ncase'B':printf(\"70~84\\n\");break;\ncase'C':printf(\"60~69\\n\");break;\ncase'D':printf(\"<60\\n\");break;\ndefault:printf(\"enter data error!\\n\");\nreturn 0;\n");

	printf("请选择\nA.70~84\nB.85~100\nC.60~69\nD.<60\n");
	scanf("%c%*c",&a);

	if(a=='B')
	{	
	   c+=10;	
	}
	else
	{
		printf("你的输入有误\n");goto p1;
	}

 
p2:	printf("2.请看下题，如果你的的数学成绩为89，则下列程序输出的是______\nint main()\nint score;\n");   
	printf("scanf(\"%%d\",&score);\nif(score>100 || score<0) printf(\"输入出错!\\n\")return ; \nswitch(score/10)\ncase 0:\ncase 1:\ncase 2:\ncase 3:\ncase 4:\ncase 5:printf(\"你的成绩类别为:差\\n\"); break; \ncase 6: printf(\"你的成绩类别为:及格\\n\"); break;\ncase 7: printf(\"你的成绩类别为:中\\n\"); break; \ncase 8: printf(\"你的成绩类别为:良\\n\");break; \ndefault: printf(\"你的成绩类别为:优\\n\");return 0;\n");
	printf("请选择，\nA.差\nB.良\nC.中\nD.优\n");	
	scanf("%c%*c",&a);

	if(a=='D')
	{	
		c+=10;	
	}
	else
	{
		printf("你的输入有误\n");goto p2;
	}
p3:	printf("3.请看下题，如果你先后输出的数是9和3，则下列程序运算的是_____\nint main()\ninclude<math.h>\ndouble x,s;\nint y;\n");
	printf("printf(\"input a number:\\n\");\nscanf(\"%%lf\",&x);\nwhile(1)\n");
	printf("printf(\"您希望进行那种运算？\\n\");\nprintf(\"1.计算sin(x)\\n\");\nprintf(\"2.计算cos(x)\\n\");\nprintf(\"3.计算tan(x)\\n\");\nscanf(\"%%d\",&y);\nswitch(y)\n");
	printf("case 1:s=sin(x);\nprintf(\"sin(%%f)=%%f\\n\",x,s);break;\ncase 2:s=cos(x);\nprintf(\"cos(%%f)=%%f\\n\",x,s);break;\ncase 3:s=tan(x);\nprintf(\"tan(%%f)=%%f\\n\",x,s);break;\ndefault:\nprintf(\"输入有误，请输入1~3之前的数字!\\n\");\nif(y==1||y==2||y==3)break;\nreturn 0;\n");
	printf("请选择，\nA.sin(9)\nB.coc(9)\nC.tan(9)\n");
	scanf("%c%*c",&a);

	if(a=='C')
	{	
	   c+=10;	
	}
	else
	{
		printf("你的输入有误\n");goto p3;
	}
	printf("c= %d\n",c);
	
}