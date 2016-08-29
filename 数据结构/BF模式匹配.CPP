/*

#include <stdio.h>
#include <string.h>


int Index_BF(const char * str,const char * mode,int pos){
	int	i = pos;
	int	j = 1;
	while (i<=str[0] && j<=mode[0])
	{
		if (str[i] == mode[j])
		{
			i++,j++;
		}
		else{
			i = i - j + 2;
			j = 1;
		}
	}
	if (j>mode[0])
	{
		return i - mode[0];
	}
	else{
		return 0;
	}
}

void main(){
	char string[16] = "\016abcabcabaabcac";
	char mode[10] = "\010abaabcac";
	printf("模式串在主串中的位置:%d\n",Index_BF(string,mode,1));
}
*/


#include <stdio.h>
#include <string.h>

typedef struct{
	char * str;
	int length;
}String;

int Index_BF(String mainStr,String modeStr,int pos){
	int	i = pos-1;
	int	j = 0;
	while (i<mainStr.length && j<modeStr.length)
	{
		if (mainStr.str[i] == modeStr.str[j])
		{
			i++,j++;
		}
		else{
            // 出现不同的，回退到模式第一个字符的状态，将模式右移进行匹配
			i = i - j + 2;
			j = 0;
		}
	}
	if (j==modeStr.length)
	{
		return i - modeStr.length;
	}
	else{
		return 0;
	}
}

void main(){
	String mainStr = {"abcabcabaabcac",14};
	String modeStr = {"abaabcac",8};
	printf("模式串在主串中的位置:%d\n",Index_BF(mainStr,modeStr,1));	
}