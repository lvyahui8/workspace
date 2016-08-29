package org.devlyh.datatype;

/**
 * Created by admin on 2015/8/16.
 */
public class Main {
    private char aChar;

    public static void main(String[] args) {
//        float f = 1.20f,
//                f2 = -1.20f;
//        System.out.println(Integer.toBinaryString(Float.floatToIntBits(f)));
//        System.out.println(Integer.toBinaryString(Float.floatToIntBits(f2)));

//        System.out.println((int)(new Main().aChar));
//        System.out.println();
        Integer i1 = 127;
        Integer i2 = 127;
        Integer i3 = 128;
        Integer i4 = 128;
        System.out.println(i1 == i2); // true
        System.out.println(i3 == i4); // false

        int arr [] = new int[12];
        System.out.println(arr.getClass().getSuperclass());//clazz java.lang.Object
    }
}

