package com.tencent.vo;


import com.tencent.impl.Downloadable;
import com.tencent.utils.StringUtils;

import java.sql.Timestamp;

/**
 * Author : samlv .
 * Date   : 2016/1/5 .
 */
public class Zz_upload extends BaseEntity implements Downloadable {
    private Integer f_id;
    private String f_url;
    private String f_qq;
    private Integer p_id;
    private Timestamp f_uploadtime;

    public Integer getF_id() {
        return f_id;
    }

    public void setF_id(Integer f_id) {
        this.f_id = f_id;
    }

    public String getF_url() {
        return f_url;
    }

    public void setF_url(String f_url) {
        this.f_url = f_url;
    }

    public String getF_qq() {
        return f_qq;
    }

    public void setF_qq(String f_qq) {
        this.f_qq = f_qq;
    }

    public Integer getP_id() {
        return p_id;
    }

    public void setP_id(Integer p_id) {
        this.p_id = p_id;
    }

    public Timestamp getF_uploadtime() {
        return f_uploadtime;
    }

    public void setF_uploadtime(Timestamp f_uploadtime) {
        this.f_uploadtime = f_uploadtime;
    }

    @Override
    public String toString() {
        return "Zz_upload{" +
                "f_id=" + f_id +
                ", f_url='" + f_url + '\'' +
                ", f_qq='" + f_qq + '\'' +
                ", p_id=" + p_id +
                ", f_uploadtime=" + f_uploadtime +
                '}';
    }

    @Override
    public String getUrl() {
        return this.f_url;
    }

    @Override
    public String getFileName() {
        return StringUtils.uuid() + ".zip";
    }
}
