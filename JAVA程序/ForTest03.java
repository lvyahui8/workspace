import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
public class ForTest03{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputStr ;
		while(!"quit".equals((inputStr = br.readLine()))){
			// inputStr = br.readLine();
			int  input = Integer.parseInt(inputStr);
			int  inputHalf = input >> 1;
			System.out.println();
			char c = 'A';
				
			
			for (int i = 0; i < inputHalf; i++) {
				for(int j = inputHalf - i; j > 0 ;j-- ){
					System.out.print(" ");
				}
				for (int j = 1; j<=2*i+1; j++) {
					System.out.print(c);
				}
				c++;
				System.out.println();
			}
			
			for (int i = 0; i < input; i++) {
				System.out.print(c);
			}
			System.out.println();
			c--;
			for (int i = inputHalf-1; i >=0 ; i--) {
				for(int j = 0; j <  inputHalf - i;j++ ){
					System.out.print(" ");
				}
				for (int j = 2*i+1; j>=1; j--) {
					System.out.print(c);
				}
				c--;
				System.out.println();
			}
			// System.out.println(input);
		}
	}
}

/*
E:\程序\JAVA程序>java ForTest03
7

   A
  BBB
 CCCCC
DDDDDDD
 CCCCC
  BBB
   A
9

    A
   BBB
  CCCCC
 DDDDDDD
EEEEEEEEE
 DDDDDDD
  CCCCC
   BBB
    A
5

  A
 BBB
CCCCC
 BBB
  A
*/