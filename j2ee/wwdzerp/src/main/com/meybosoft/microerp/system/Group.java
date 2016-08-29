package com.meybosoft.microerp.system;

import com.easyjf.dbo.annotation.*;

@Table(tableName="SystemGroup")
public class Group implements java.io.Serializable{	
	
    private Number id;
	
    private String title;
	
    private Integer intro;
	//@ManyToOne(name="users")
    private java.util.List<SystemUser> users;
	//@ManyToOne
    private java.util.List<Role> roles;	
	
	public Number getId() {
		return id;
	}
	public void setId(Number id) {
		this.id = id;
	}
	public Integer getIntro() {
		return intro;
	}
	public void setIntro(Integer intro) {
		this.intro = intro;
	}
	public java.util.List<Role> getRoles() {
		return roles;
	}
	public void setRoles(java.util.List<Role> roles) {
		this.roles = roles;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public java.util.List<SystemUser> getUsers() {
		return users;
	}
	public void setUsers(java.util.List<SystemUser> users) {
		this.users = users;
	}    
    
}
