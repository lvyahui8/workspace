package com.meybosoft.microerp.system;
//权限类别
public interface PopedomValue {
Integer NONE=new Integer(-1);//无权限
Integer READ=new Integer(0);//读
Integer ADD=new Integer(1);//添加
Integer MODIFY=new Integer(2);//修改或设置
Integer DEL=new Integer(3);//删除
Integer EXECUTE=new Integer(4);//执行
Integer ALL=new Integer(99);//全部权限
}
