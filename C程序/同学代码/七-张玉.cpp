#include<stdafx.h>
#define R 10
#define C 5 
float score[R][C];
float s_aver[R],c_aver[C];
/*
*	������Ҫʹ��ȫ�ֱ�����������д��ȫû�����ΪʲôҪ�Զ��庯��������д��ȫ��д������������û���κ�����
*	ΪʲôҪд������ΪʲôҪģ�黯��̣��ٸ��򵥵����ӣ�printf();��Ҳ���Զ��庯����ֻ����Ϊ��д��̫���㣬΢��Ű����ŵ�c ����������
*	�������û�������������ô��ÿ��д���򣬵�����Ҫ���һЩ����ʱ������Ҫ��printf();�Ӵ������дһ�Σ����ǲ��Ǻ��鷳
*	����printf();����֮���أ����ǲ���ֻ��Ҫ����Ҫprintf("��ʽ����+�ַ���˵��",�����б�); �Ϳ��Լ򵥵��������
*	
*	��ô��ôд��һ��������һ���õĺ�����Ӧ���кܺõ���ֲ�ԣ������õ��κ�һ���������棬�Ϳ���ʹ�ã�����ʵ��ָ���Ĺ���
*	
*	#include <stdafx.h>
*
*	double power(double x,int n)
*	{
*		// {�����������Ǻ�����}
*		if(n==0) return 0;
*		double j=x;
*		for(int i=1;i<n;i++)
*		{
*			x=x*j;
*		}
*		return x;
*	}

*	������һ����������һ���ܺõĺ����������ĳ�����Ҫ��X^y���������⣬ֻҪ�򵥵ĵ��ã������ٰѸ��ӵĺ����������дһ�Σ�������
*	Ҳ���ŵ��˺�������	
*	д���������Ը��������Ҫ�趨�����ж��ٸ���������û�з���ֵ��
*	����˵�����Ŀ�У�����ȫ���Բ�����������ȫ�ֱ�����ֻҪ���������βξ��У��Ϳ������Զ��庯��ʹ�����������������
*
*	�����ҵ��ֻ����ĵ�û�д�����ô������д�����������壬���Լ�ȥд�������ȥ��һ�º�����һ�½ڵ������������ҵ���ҵ���Լ�����
*	��дһЩ�Զ��庯����������Ҫʹ��ȫ�ֱ������������������ң�
*/

int n,m;
void main()
{
	int i,j;
	float max; //���������ֵ
	//����6��ֻ�Ǻ��������������Ǻ������ã�����û���������룬�������е�������0
	float highest();
	float s_var(void);
	void s_input(void);
    void c_aver2(void);
    void s_aver2(void);
    void c_input(void);
	s_input(); // ����
	c_aver2(); //����ѧ��ƽ��ֵ
	s_aver2(); //�����Ŀƽ��ֵ
	printf("\nNO.  c1      c2      c3      c4      c5     aver\n");//���ſγ̺�ÿ��ͬѧ��ƽ����

    for(i=0;i<R;i++)
	{
		printf("\nNO.%2d\n",i+1);//ÿ��ͬѧ�ķ���
		for(j=0;j<C;j++)
			printf("%8.2f",score[i][j]);
		printf("%8.2f",s_aver[i]);
	}

	printf("\naver:\n");//ÿ�ſγ̵�ƽ����
	for(j=0;j<C;j++)
		printf("%8.2f",c_aver[j]);

	max=highest();
    printf("\nhighest:%7.2f       NO.%2d      NO.%2d\n",max,n,m);
	printf("variance:%7.2f\n",s_var());//����
}
void s_input(void)
{	
	// ��������ֵ
	int i,j;
	for(i=0;i<R;i++)
	{
		printf("input score of student%2d:\n",i+1);
		for(j=0;j<C;j++)
			scanf("%f",&score[i][j]);
	}
}

void s_aver2(void)
{
	//ÿ��ѧ����ƽ���ɼ�
	int i,j;
	float s;
	for (i=0;i<R;i++)
	{
		s=0;  // �����˸�s ��λΪ0
		for(j=0;j<C;j++)
			s+=score[i][j];
		s_aver[i]=s/5.0;
	}
}
void c_aver2(void)
{
	//ÿ�ſ�Ŀ��ƽ���ɼ�
	int i,j;
	float s;
	for(j=0;j<C;j++)
	{
		s=0;
		for(i=0;i<R;i++)
			s+=score[i][j];
		c_aver[j]=s/(float)R;
	}
}
float highest()
{
	// Ѱ�����ֵ������¼��Ӧ���к���
	float high;
	int i,j;
	high=score[0][0];
	for(i=0;i<R;i++)
	{
		for(j=0;j<C;j++)
		{
			if(score[i][j]>high)
			{
				high=score[i][j];
				n=i+1;
	            m=j+1;
			}
		}
	}
	return(high);
}
float s_var(void)
{
	int i;
	float sumx,sumy;
	sumx=0.0;
	sumy=0.0;
	for(i=0;i<R;i++)
	{
		sumx+=(s_aver[i]*s_aver[i]);
	    sumy+=s_aver[i];
	}

	return(sumx/R)-(sumy/R)*(sumy/R); //  ��ʽ����
}