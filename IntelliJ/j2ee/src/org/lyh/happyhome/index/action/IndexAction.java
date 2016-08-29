package org.lyh.happyhome.index.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 首页执行的Action
 * @author lvyahui
 *
 */
public class IndexAction extends ActionSupport {
    /**
     * 首页执行的method
     */
    public String execute(){

        return "index";
    }
}
