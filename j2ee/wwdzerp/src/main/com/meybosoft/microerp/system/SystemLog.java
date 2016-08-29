package com.meybosoft.microerp.system;

import java.io.Serializable;
import java.util.Date;
import com.easyjf.dbo.annotation.*;
@Table(tableName="SystemLogInfo")
public class SystemLog implements Serializable{

	private Number id;

	private String opType;

	private String intro;

	private Date vdate;

	private String userName;
	
	private String ip;

	public Number getId() {
		return id;
	}

	public void setId(Number id) {
		this.id = id;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getOpType() {
		return opType;
	}

	public void setOpType(String opType) {
		this.opType = opType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getVdate() {
		return vdate;
	}

	public void setVdate(Date vdate) {
		this.vdate = vdate;
	}

}
