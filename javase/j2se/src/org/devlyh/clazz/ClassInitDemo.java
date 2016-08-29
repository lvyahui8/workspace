package org.devlyh.clazz;

class PClass extends Object{
    int anInt = 10;
    static int sVal = 20;

    static int initVal = init();
    static {
        System.out.println("父类静态代码块执行:"+sVal);
        sVal = 100;
    }

    {
        System.out.println("父类构造代码块执行");
        anInt = 30;
    }

    public PClass(){
        System.out.println("父类构造函数执行 :"+anInt);
    }

    public static int init(){
        System.out.println(PClass.class.getName()+"静态成员初始化");
        return 1000;
    }
}

public class ClassInitDemo extends PClass{
    private int anInt = 4;

    static private int sVal = 3;

    static int initVal = init();

    static {
        System.out.println("子类静态代码执行 sval:"+sVal);
        sVal = 10;
    }

    {
        System.out.println("子类构造代码块执行");
        anInt = 10;
    }

    public static int init(){
        System.out.println(ClassInitDemo.class.getName()+"静态成员初始化");
        return 1000;
    }

    public ClassInitDemo(){
        System.out.println("子类构造函数执行:"+anInt);
        System.out.println(this.anInt);
        System.out.println(super.anInt);
        System.out.println(sVal);
    }

    public static void main(String[] args) {
        new ClassInitDemo();
    }

}