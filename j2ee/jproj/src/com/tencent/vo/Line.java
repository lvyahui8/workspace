package com.tencent.vo;

/**
 * Author : samlv .
 * Date   : 2016/1/6 .
 */
public class Line extends BaseEntity{
    private String lineKey;
    private String lineContent;
    private String uin;
    private String model;
    private String qua;

    /**
     *
     * @return lineKey,格式 类似于：84529/84516/85114/
     */
    public String getLineKey() {
        return lineKey;
    }

    public void setLineKey(String lineKey) {
        this.lineKey = lineKey;
    }

    /**
     * 调用链条的方法名称描述
     * @return lineContent,格式methodA(l_num)/methodB(l_num)/methodC/[delay]
     */
    public String getLineContent() {
        return lineContent;
    }

    public void setLineContent(String lineContent) {
        this.lineContent = lineContent;
    }

    /**
     * 上报这条调用链条的用户QQ号
     * @return uin QQ号
     */
    public String getUin() {
        return uin;
    }

    public void setUin(String uin) {
        this.uin = uin;
    }

    /**
     * 上报用户手机机型
     * @return 机型
     */
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    /**
     * 手空的代码版本
     * @return
     */
    public String getQua() {
        return qua;
    }

    public void setQua(String qua) {
        this.qua = qua;
    }


    @Override
    public String toString() {
        return "Line{" +
                "lineKey='" + lineKey + '\'' +
                ", lineContent='" + lineContent + '\'' +
                ", uin='" + uin + '\'' +
                ", model='" + model + '\'' +
                ", qua='" + qua + '\'' +
                '}';
    }
}
