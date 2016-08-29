package com.meybosoft.microerp.system;

import java.io.Serializable;
import java.util.Date;
import com.easyjf.dbo.annotation.*;
@Table(tableName="SystemUser")
public class SystemUser implements Serializable{

    private Long id;
	@OneToOne(column="belongDept",type=SystemDept.class)//À˘ Ù≤ø√≈
    private SystemDept belongDept;

    private String userName;
	
    private String password;

    private String email;

    private String trueName;

    private String tel;

    private Date lastLoginTime;

    private String lastLoginIP;

	private Integer loginTimes;

	private String inputUser;

	private Date inputTime;

	private Integer status;
	public SystemDept getBelongDept() {
		return belongDept;
	}
	public void setBelongDept(SystemDept belongDept) {
		this.belongDept = belongDept;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getInputTime() {
		return inputTime;
	}
	public void setInputTime(Date inputTime) {
		this.inputTime = inputTime;
	}
	public String getInputUser() {
		return inputUser;
	}
	public void setInputUser(String inputUser) {
		this.inputUser = inputUser;
	}
	public String getLastLoginIP() {
		return lastLoginIP;
	}
	public void setLastLoginIP(String lastLoginIP) {
		this.lastLoginIP = lastLoginIP;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public Integer getLoginTimes() {
		return loginTimes;
	}
	public void setLoginTimes(Integer loginTimes) {
		this.loginTimes = loginTimes;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}	

}
