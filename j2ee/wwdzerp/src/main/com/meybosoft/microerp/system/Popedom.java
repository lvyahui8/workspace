package com.meybosoft.microerp.system;
import com.easyjf.dbo.annotation.*;
import com.meybosoft.microerp.domain.OrderDetail;
/**
 * 权限基本信息，可以用于描述一个基本的功能的模块，也可以用于描述针对某个对象某个方法或某个属性
 * 使用编号cid来作hashCode标识
 * @author 李艳
 * 
 */
@Table(tableName="SystemPopedom")
public class Popedom implements java.io.Serializable {
	
	private Number id;// 编号
	
	private String title;// 名称
	
	private String intro;// 简介
	@OneToOne(column="parent_id",type=Popedom.class,lazy=true)
	private Popedom parent;// 父权限
	
	private Integer status;//状态
	@ManyToOne(column="parent_id",fieldType=java.util.HashSet.class,type = Popedom.class)
	private java.util.Set<Popedom> children = new java.util.HashSet<Popedom>();// 子权限
	
	public Number getId() {
		return id;
	}

	public void setId(Number id) {
		this.id = id;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof Popedom))
			return false;
		if (this.id.equals(((Popedom) obj).getId()))
			return true;
		else
			return super.equals(obj);
	}

	public int hashCode() {		
		return (this.id!=null?this.id.hashCode():super.hashCode());
	}

	public java.util.Set getChildren() {
		return children;
	}

	public void setChildren(java.util.Set children) {
		this.children = children;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public Popedom getParent() {
		return parent;
	}

	public void setParent(Popedom parent) {
		this.parent = parent;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
