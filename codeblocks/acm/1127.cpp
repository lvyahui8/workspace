#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char num[20];

bool div0 = false;

double qz(double v1,const char c,double v2){
	switch(c){
		case '-':
			v1 = v1 - v2;
			break;
		case '+':
			v1 = v1 + v2;
			break;
		case '*':
			v1 = v1 * v2;
			break;
		case '/':
		    if(0 == v2){
                div0 = true;
                return v1;
		    }
			v1 = v1 / v2;
			break;
		default:
		    break;
	}
	return v1;
}

bool isC(char ch){
    return '-' == ch || '+' == ch || '*' == ch || '/' == ch;
}
int main(){
	char ch;
	int p=0;
	while(true){
        div0 = false;
		double res = 0;
		p = 0;
		char oldc = '+';
		char oldmc = '*';
		double oldv = 0;
		double mmv = 1;
		bool isMM = false;
		while(true){
            ch = getchar();
			if(ch==EOF){return 0;}

            if(isC(ch) || '\n'==ch){
                oldv = atof(num);
                p=0;strcpy(num,"");
            }
			switch(ch){
			case '-':
			case '+':
			    if(isMM){
                    mmv = qz(mmv,oldmc,oldv);
                    res = qz(res ,oldc,mmv);
			    }
			    else{
                    res = qz(res ,oldc,oldv);
			    }
                isMM = false;
                oldc = ch;oldmc = '*';mmv=1;
				break;
			case '*':
			case '/':
                isMM = true;
                mmv = qz(mmv,oldmc,oldv);
                oldmc = ch;
				break;
            case '\n':
                if(isMM){
                    mmv = qz(mmv,oldmc,oldv);
                    res = qz(res,oldc,mmv);
                }
                else{
                    res = qz(res,oldc,oldv);
                }
                break;
			default:
				num[p++]=ch;
			}
            if(div0){break;}
            if('\n' == ch) break;
		}
		if(div0){
            printf("DivByZero\n");
		}
		else printf("%e\n",res);
	}

	return 0;
}
