#include<stdafx.h>
int main()
{
	char s;
	double sum;
	sum=0;
	printf("1.整个if语句可以写在多行上，也可以写在一行上。但是，为了程序的清晰，提倡写成___________形式。\n");
	printf("  A、锯齿                     B、单行\n");
	scanf("%c%*c",&s);
	if ('A'==s || 'a'==s)
	{
		sum=sum+8.3;
	}
	printf("2.在if语句中，if部分与else部分是否为一个语句?___________\n");
	printf("  A、不是                     B、是\n");
	scanf("%c%*c",&s);
	if ('B'==s || 'b'==s)
	{
		sum=sum+8.3;
	}
	printf("3.在if语句中，内嵌语句可不可以是一个if语句?____________\n");
	printf("  A、可以                     B、不可以\n");
	scanf("%c%*c",&s);
	if ('A'==s || 'a'==s)
	{
		sum=sum+8.3;
	}
    printf("sum=%d\n",sum);
//	return 0;

//	int a,b,c=0;

   // sum=0;
    printf("4.假设所有变量均为整型，a=2,b=5,b++则表达式a+b的值是______。");
	scanf("%d",&s);
    switch(s)
	{
    case 8:sum=sum+8.3;break;
    default:sum=sum+0;
    }
    printf("5.若a为整型变量,a=12,则表达式:a-=2的值______.");
	scanf("%d",&s);
    switch(s)
	{
		case 10:sum=sum+10;break;
		default:sum=sum+0;
	}
	printf("6.若a为整型变量,a==12,则有表达式a*=2+3,则a=");
	scanf("%d",&s);
	switch(s)
	{
		case 60:sum=sum+8.3;break;
		default:sum=sum+0;
	}
    //printf("总分=%d\n",sum);
	char f;
    printf("7.请看下题，如果你的等级为A,则你的分数段为_____\nint main()\nchar grade;\n");
	printf("scanf(\"%%c\",&grade);\printf(\"Your score:\");\nswitch(grade)\ncase'A':printf(\"85~100\\n\");break;\ncase'B':printf(\"70~84\\n\");break;\ncase'C':printf(\"60~69\\n\");break;\ncase'D':printf(\"<60\\n\");break;\ndefault:printf(\"enter data error!\\n\");\nreturn 0;\n");

	printf("请选择\nA.70~84\nB.85~100\nC.60~69\nD.<60\n");
	scanf("%c%*c",&f);

    if(f=='B')
	{	
		sum+=8.3;	
	}
	printf("8.请看下题，如果你的的数学成绩为89，则下列程序输出的是______\nint main()\nint score;\n");   
	printf("scanf(\"%%d\",&score);\nif(score>100 || score<0) printf(\"输入出错!\\n\")return ; \nswitch(score/10)\ncase 0:\ncase 1:\ncase 2:\ncase 3:\ncase 4:\ncase 5:printf(\"你的成绩类别为:差\\n\"); break; \ncase 6: printf(\"你的成绩类别为:及格\\n\"); break;\ncase 7: printf(\"你的成绩类别为:中\\n\"); break; \ncase 8: printf(\"你的成绩类别为:良\\n\");break; \ndefault: printf(\"你的成绩类别为:优\\n\");return 0;\n");
	printf("请选择，\nA.差\nB.良\nC.中\nD.优\n");	
	scanf("%c%*c",&f);

	if(f=='D')
	{
		sum+=8.3;	
	}
 
	printf("9.请看下题，如果你先后输出的数是9和3，则下列程序运算的是_____\nint main()\ninclude<math.h>\ndouble x,s;\nint y;\n");
	printf("printf(\"input a number:\\n\");\nscanf(\"%%lf\",&x);\nwhile(1)\n");
	printf("printf(\"您希望进行那种运算？\\n\");\nprintf(\"1.计算sin(x)\\n\");\nprintf(\"2.计算cos(x)\\n\");\nprintf(\"3.计算tan(x)\\n\");\nscanf(\"%%d\",&y);\nswitch(y)\n");
	printf("case 1:s=sin(x);\nprintf(\"sin(%%f)=%%f\\n\",x,s);break;\ncase 2:s=cos(x);\nprintf(\"cos(%%f)=%%f\\n\",x,s);break;\ncase 3:s=tan(x);\nprintf(\"tan(%%f)=%%f\\n\",x,s);break;\ndefault:\nprintf(\"输入有误，请输入1~3之前的数字!\\n\");\nif(y==1||y==2||y==3)break;\nreturn 0;\n");
	printf("请选择，\nA.sin(9)\nB.coc(9)\nC.tan(9)\n");
	scanf("%c%*c",&f);

	if(f=='C')
	{	
		sum+=8.3;	
	}

  // printf("得分sum= %d\n",sum);



  
	float y,z,g;
	//void daan(float d,float sum);


	printf("10.main()\n{ \n float x=2.0,y;\n if(x<0.0)\ny=0.0;\n else if (x<10.0)\ny=1.0/x;\n printf(\"%%f\",y);\n}\n,则y的值是    ");
	scanf("%c%*c",&y);

	if(y==0.5)
	{	
		sum+=8.3;	
	}
   //daan(0.5);
	printf("11.main()\n{int x=2,y=-1,z=2;\n if(x<0) if(y<0)\n z=0;\n else z++;\n printf(\"%%d\",z)\n}\n，则z值为  ");
   //daan(2);
	scanf("%c%*c",&z);

	if(z==0.5)
	{	
		sum+=8.3;	
	}
	printf("12.main()\n{\n int x=5,y=4,z=3,g=2;\n if(a>b>c)\n printf(\"%%d\n\",g);\n else if ((z-1>=g)==1)\n printf(\"%%d\",g+1);\n else  printf(\"%%d\",g+2);\n}\n,则输出结果是   ");
   //daan(3);
	scanf("%c%*c",&g);

	if(g==2)
	{	
		sum+=8.3;	
	}

  
}
 /*void daan(float d,float sum)
  {
      	float e;
        scanf("%d%*c",&e);
       	if(e==d)
{
sum+=8.3;
}
 }*/
