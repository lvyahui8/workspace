// ��������Ϸ
import javax.swing.*;

class Game02 
{
	public static void main(String[] args) 
	{
		//	����������������Ա��������
		//	Math.round()�ǽ�һ������������
		//	Math.random()�ǲ���һ������[0,1]�������
		int	num1 = (int)(Math.round(Math.random()*10));
		int num2 = (int)(Math.round(Math.random()*10));
		//	����һ�����������ʶ��ͬ�������
		System.out.println("Hello World!");
		int sign = (int)(Math.round(Math.random()*3));
		//	����һ�������������������
		int answer;
		System.out.println("\n\n******");
		if (0 == sign) {
		    System.out.println(num1+"+"+num2);
			answer = num1 + num2;
		}
		else if (1 == sign) {
			System.out.println(num1+"-"+num2);
			answer = num1 - num2;
		}
		else if (2 == sign) {
		    System.out.println(num1+"*"+num2);
			answer = num1 * num2;
		}
		else if(3 == sign){
		    System.out.println(num1+"/"+num2);
			answer = num1 / num2;
		}
		else {
		    System.out.println(num1 +"%"+num2);
			answer = num1 % num2;
		}
		/*
		switch () {
		    case :
		        
		        break;
		    default:
		        
		        break;
		}
		*/
		System.out.println("********\n");
		//����ʱ3��
		for(int i=3;i>0;i--){
			System.out.println(i+"......");
			try{
				Thread.sleep(1000);   //��������쳣������������޷�ͨ��
			}catch (Exception e){
				 e.printStackTrace();   //print exception info
			}
		}
		
		System.out.println("Answer:"+answer);
	}
}
