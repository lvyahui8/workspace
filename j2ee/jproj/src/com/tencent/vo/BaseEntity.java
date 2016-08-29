package com.tencent.vo;

import java.lang.reflect.Method;
import java.util.HashMap;



import java.lang.reflect.Field;

import java.sql.Timestamp;

import java.util.Map;


/**
 * Author : samlv .
 * Date   : 2016/1/6 .
 */
public class BaseEntity {


    /**
     * DB 主键
     * @return 主键ID
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTableName(){
        return null;
    }



    protected Integer id;

    protected Timestamp createdAt;
    protected Timestamp updatedAt;


    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public String getEntityName(){
        String simpleName = this.getClass().getSimpleName();
        String prefix = simpleName.substring(0,simpleName.indexOf("Entity"));
        return prefix.substring(0,1).toLowerCase()+ prefix.substring(1);
    }

    protected Map<String,Map<String,String>> errors
            = new HashMap<String,Map<String,String>>();
    protected Map<String,String> labels = new HashMap<String,String>();

    public BaseEntity() {

    }

    public void fill(Map<String, String[]> parameterMap) {
        //System.out.println(this.getClass());
        Class clazz = this.getClass();
        Field fields[] = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            String fieldName = fields[i].getName();
            //System.out.println(fieldName);
            try {
                // 查找参数集合
                String values [] = parameterMap.get(fieldName);
                if(values!=null && values.length>0){
                    String methodName = "set"+fieldName.substring(0, 1).toUpperCase()
                            + fieldName.substring(1);
                    Class fieldType = fields[i].getType();
                    Method method = clazz.getMethod(methodName,new Class[]{fieldType});
                    // 设值
                    method.invoke(this,new Object[]{fieldType.cast(values[0])});
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
