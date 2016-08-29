package org.lyh.app;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner  = new Scanner(new File("data.in"));

        int n;
        while(scanner.hasNext()){
            n = Integer.valueOf(scanner.nextLine());
            String string = scanner.nextLine();
            while (n >= 0){
                string = string.replaceFirst("" + n,""+(char)n);
                n --;
            }
            System.out.println(string);
            char arr[] = string.toCharArray();

            for (char ch : arr){
                System.out.print(((int)(ch)) + " ");
            }
            System.out.println();
        }
    }
}
