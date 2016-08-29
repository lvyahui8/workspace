package org.devlyh.exception;


public class Main{
    public  static  int i = 9;
    public static void main(String[] args) throws Exception{
        exceptionDemo();
    }

    public static int exceptionDemo() throws Exception{
        // 如果程序没有执行到try代码块，finally也不会执行
        //  exit();

        try {
            if(i>10){
                throw  new Exception("抛出异常");
            }
            // System.exit(0); // 可以是finally块不执行
            return returnVal();// 先执行return 表达式的计算，再执行finally，再然后返回运算结果，然后弹栈
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("finally执行");
        }
        return returnVal() ;// 先执行finally在执行这里
     }


    public static int returnVal(){
        System.out.println("return");
        return 0;
    }

    public static void exit(){
        System.exit(0);
    }
}