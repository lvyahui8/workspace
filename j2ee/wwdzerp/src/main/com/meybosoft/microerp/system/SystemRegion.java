package com.meybosoft.microerp.system;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.easyjf.dbo.annotation.*;
/**
 * 
 * @author 地区信息
 *
 */
@Table(tableName="SystemRegion",keyField="sn")
public class SystemRegion implements Serializable{

private Long id;

private String sn;

private String title;
@OneToOne(column="parent_sn",key="sn",type=SystemRegion.class)
private SystemRegion parent;

private Integer lev;

private Integer sequence;

private Date inputTime;

private String inputUser;
@ManyToOne(column = "parent_sn",key="sn",fieldType=java.util.HashSet.class,type =SystemRegion.class,lazy=true)
private Set<SystemRegion> children=new HashSet<SystemRegion>();
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
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
public Integer getLev() {
	return lev;
}
public void setLev(Integer lev) {
	this.lev = lev;
}
public SystemRegion getParent() {
	return parent;
}
public void setParent(SystemRegion parent) {
	this.parent = parent;
}
public Integer getSequence() {
	return sequence;
}
public void setSequence(Integer sequence) {
	this.sequence = sequence;
}
public String getSn() {
	return sn;
}
public void setSn(String sn) {
	this.sn = sn;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public Set<SystemRegion> getChildren() {
	return children;
}
public void setChildren(Set<SystemRegion> children) {
	this.children = children;
}

public int hashCode() {
	return this.id!=null?this.id.hashCode():super.hashCode();
}

public boolean equals(Object obj) {
	if((obj==null)||(! (obj instanceof SystemRegion)))return false;		
	SystemRegion o=(SystemRegion)obj;
	if(this.id!=null && (o.getId()!=null))return this.id.equals(o.getId());
	return super.equals(obj);
}

/*
public String toString()
{
	String ret=this.title+"[";
	
	if(this.children.size()>0)
	{
		java.util.Iterator it=this.children.iterator();
		while(it.hasNext())
			ret+=it.next();
	}
	ret+="]";
	return ret;
}*/
}
