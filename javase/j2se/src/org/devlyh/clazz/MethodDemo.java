package org.devlyh.clazz;

/**
 * Created by admin on 2015/8/16.
 */

class SuperClass{
    protected void method(){
        System.out.println("父类的方法");
    }
}

public class MethodDemo extends SuperClass {

    protected void method(){
        System.out.println("子类的方法");
    }
    public int metho2d(){
        return 0;
    }
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable 方法");
            }
        }) {
            @Override
            public void run() {
                System.out.println("Thread子类 方法");
                //super.run();
            }
        }.start();
    }
}
