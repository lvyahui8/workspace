#include<stdlib.h>
#include<stdafx.h>


int main()
{
	/*����Ϊ��������뼸��char�͵��ַ��أ����ܺܶ�����Ϊ
	��9�����Ǵ��ˣ���5������Ϊscanf��������char�͵�ʱ��
	�ѿո�Ҳ���ȥ�ˣ�����enter����ʱ�����ʾ������һ����
	��������ÿ������һ���ַ���һ����Ȼ�������һ���ַ���
	enterҲ��һ�����˴�����5��char�ַ���4��enter��*/

	char ch;
	int i=0;
	while(i<=8)
	{
		i++;
		scanf("%c",&ch);
		//getchar();
	}
	return 0;
 }