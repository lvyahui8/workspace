#include<stdafx.h>
int main()
{
	char s;
	double sum;
	sum=0;
	printf("1.����if������д�ڶ����ϣ�Ҳ����д��һ���ϡ����ǣ�Ϊ�˳�����������ᳫд��___________��ʽ��\n");
	printf("  A�����                     B������\n");
	scanf("%c%*c",&s);
	if ('A'==s || 'a'==s)
	{
		sum=sum+8.3;
	}
	printf("2.��if����У�if������else�����Ƿ�Ϊһ�����?___________\n");
	printf("  A������                     B����\n");
	scanf("%c%*c",&s);
	if ('B'==s || 'b'==s)
	{
		sum=sum+8.3;
	}
	printf("3.��if����У���Ƕ���ɲ�������һ��if���?____________\n");
	printf("  A������                     B��������\n");
	scanf("%c%*c",&s);
	if ('A'==s || 'a'==s)
	{
		sum=sum+8.3;
	}
    printf("sum=%d\n",sum);
//	return 0;

//	int a,b,c=0;

   // sum=0;
    printf("4.�������б�����Ϊ���ͣ�a=2,b=5,b++����ʽa+b��ֵ��______��");
	scanf("%d",&s);
    switch(s)
	{
    case 8:sum=sum+8.3;break;
    default:sum=sum+0;
    }
    printf("5.��aΪ���ͱ���,a=12,����ʽ:a-=2��ֵ______.");
	scanf("%d",&s);
    switch(s)
	{
		case 10:sum=sum+10;break;
		default:sum=sum+0;
	}
	printf("6.��aΪ���ͱ���,a==12,���б��ʽa*=2+3,��a=");
	scanf("%d",&s);
	switch(s)
	{
		case 60:sum=sum+8.3;break;
		default:sum=sum+0;
	}
    //printf("�ܷ�=%d\n",sum);
	char f;
    printf("7.�뿴���⣬�����ĵȼ�ΪA,����ķ�����Ϊ_____\nint main()\nchar grade;\n");
	printf("scanf(\"%%c\",&grade);\printf(\"Your score:\");\nswitch(grade)\ncase'A':printf(\"85~100\\n\");break;\ncase'B':printf(\"70~84\\n\");break;\ncase'C':printf(\"60~69\\n\");break;\ncase'D':printf(\"<60\\n\");break;\ndefault:printf(\"enter data error!\\n\");\nreturn 0;\n");

	printf("��ѡ��\nA.70~84\nB.85~100\nC.60~69\nD.<60\n");
	scanf("%c%*c",&f);

    if(f=='B')
	{	
		sum+=8.3;	
	}
	printf("8.�뿴���⣬�����ĵ���ѧ�ɼ�Ϊ89�������г����������______\nint main()\nint score;\n");   
	printf("scanf(\"%%d\",&score);\nif(score>100 || score<0) printf(\"�������!\\n\")return ; \nswitch(score/10)\ncase 0:\ncase 1:\ncase 2:\ncase 3:\ncase 4:\ncase 5:printf(\"��ĳɼ����Ϊ:��\\n\"); break; \ncase 6: printf(\"��ĳɼ����Ϊ:����\\n\"); break;\ncase 7: printf(\"��ĳɼ����Ϊ:��\\n\"); break; \ncase 8: printf(\"��ĳɼ����Ϊ:��\\n\");break; \ndefault: printf(\"��ĳɼ����Ϊ:��\\n\");return 0;\n");
	printf("��ѡ��\nA.��\nB.��\nC.��\nD.��\n");	
	scanf("%c%*c",&f);

	if(f=='D')
	{
		sum+=8.3;	
	}
 
	printf("9.�뿴���⣬������Ⱥ����������9��3�������г����������_____\nint main()\ninclude<math.h>\ndouble x,s;\nint y;\n");
	printf("printf(\"input a number:\\n\");\nscanf(\"%%lf\",&x);\nwhile(1)\n");
	printf("printf(\"��ϣ�������������㣿\\n\");\nprintf(\"1.����sin(x)\\n\");\nprintf(\"2.����cos(x)\\n\");\nprintf(\"3.����tan(x)\\n\");\nscanf(\"%%d\",&y);\nswitch(y)\n");
	printf("case 1:s=sin(x);\nprintf(\"sin(%%f)=%%f\\n\",x,s);break;\ncase 2:s=cos(x);\nprintf(\"cos(%%f)=%%f\\n\",x,s);break;\ncase 3:s=tan(x);\nprintf(\"tan(%%f)=%%f\\n\",x,s);break;\ndefault:\nprintf(\"��������������1~3֮ǰ������!\\n\");\nif(y==1||y==2||y==3)break;\nreturn 0;\n");
	printf("��ѡ��\nA.sin(9)\nB.coc(9)\nC.tan(9)\n");
	scanf("%c%*c",&f);

	if(f=='C')
	{	
		sum+=8.3;	
	}

  // printf("�÷�sum= %d\n",sum);



  
	float y,z,g;
	//void daan(float d,float sum);


	printf("10.main()\n{ \n float x=2.0,y;\n if(x<0.0)\ny=0.0;\n else if (x<10.0)\ny=1.0/x;\n printf(\"%%f\",y);\n}\n,��y��ֵ��    ");
	scanf("%c%*c",&y);

	if(y==0.5)
	{	
		sum+=8.3;	
	}
   //daan(0.5);
	printf("11.main()\n{int x=2,y=-1,z=2;\n if(x<0) if(y<0)\n z=0;\n else z++;\n printf(\"%%d\",z)\n}\n����zֵΪ  ");
   //daan(2);
	scanf("%c%*c",&z);

	if(z==0.5)
	{	
		sum+=8.3;	
	}
	printf("12.main()\n{\n int x=5,y=4,z=3,g=2;\n if(a>b>c)\n printf(\"%%d\n\",g);\n else if ((z-1>=g)==1)\n printf(\"%%d\",g+1);\n else  printf(\"%%d\",g+2);\n}\n,����������   ");
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
