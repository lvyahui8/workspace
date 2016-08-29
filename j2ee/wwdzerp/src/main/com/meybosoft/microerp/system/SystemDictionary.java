package com.meybosoft.microerp.system;
//系统数据字典
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.easyjf.dbo.annotation.*;
import com.meybosoft.microerp.domain.OrderDetail;
@Table(tableName="SystemBasicData")
public class SystemDictionary implements Serializable{

	private Long id;
	

	private String sn;
	

	private String title;
	

	private String intro;	
	
	@ManyToOne(column = "parent_id", fieldType=java.util.TreeSet.class,type =SystemDictionaryDetail.class)
	private java.util.Set<SystemDictionaryDetail> children = new java.util.TreeSet<SystemDictionaryDetail>();
	
	
	public java.util.Set<SystemDictionaryDetail> getChildren() {
		return children;
	}
	public void setChildren(java.util.Set<SystemDictionaryDetail> children) {
		this.children = children;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
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
	
	public boolean equals(Object obj) {
		if((obj==null)||(! (obj instanceof SystemDictionary)))return false;		
		SystemDictionary o=(SystemDictionary)obj;
		if(this.id!=null && (o.getId()!=null))return this.id.equals(o.getId());
		return super.equals(obj);
	}	
	
}
