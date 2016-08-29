package cn.itcast.list.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListDemo2 {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根
        List list = new ArrayList();
//		show(list);

        list.add("abc1");
        list.add("abc2");
        list.add("abc3");
		
/*		for(Iterator it = list.iterator();it.hasNext();){
			Object obj =  it.next();// java.util.ConcurrentModificationException
			if("abc2"==obj){
				list.add("abc5");	//	并发修改异常，在迭代过程中使用集合方法操作集合，解决方法是使用 Iterator的子接口ListIterator。
			}
			else{
				System.out.println(obj);
			}
		}*/
        ListIterator it = list.listIterator();
        //	ListIterator接口方法可以满足在迭代遍历的过程中并发修改集合
        //	只有list集合具有该迭代功能
        for (/*ListIterator it = list.listIterator()*/; it.hasNext();) {
            Object obj = it.next();
            if (obj.equals("abc2")) {
                it.set("abc7");
            } else {
                System.out.println(obj);
            }
        }
        System.out.println(list);

        //	下面是逆向遍历列表
        for(/*ListIterator it = list.listIterator()*/;it.hasPrevious(); ){
            System.out.println(it.previous());
        }
    }

    private static void show(List list) {
        // TODO 自动生成的方法存根
        list.add("abc1");
        list.add("abc2");
        list.add("abc3");
        list.add("abc4");

        for(Iterator it = list .iterator();it.hasNext();){
            System.out.println(it.next());
        }

    }

}
