/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.lvyahui.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/** 
 * MyEclipse Struts
 * Creation date: 11-04-2014
 * 
 * XDoclet definition:
 * @struts.form name="helloForm"
 * 
 * ����form��Ҫ����֤�õ�
 */
public class HelloForm extends ActionForm {
	/*
	 * Generated fields
	 */

	/** info property */
	private String info;

	/*
	 * Generated Methods
	 */

	/** 
	 * Method validate
	 * @param mapping
	 * @param request
	 * @return ActionErrors
	 */
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		//��Ҫ����֤�ķ���
		ActionErrors errors = new ActionErrors();
		if(this.info == null || "".equals(this.info)){
			errors.add("info",new ActionMessage("error.info"));
		}
		return errors;
	}

	/** 
	 * Method reset
	 * @param mapping
	 * @param request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		//��Ҫ��
		// TODO Auto-generated method stub
	}

	/** 
	 * Returns the info.
	 * @return String
	 */
	public String getInfo() {
		return info;
	}

	/** 
	 * Set the info.
	 * @param info The info to set
	 */
	public void setInfo(String info) {
		this.info = info;
	}
}