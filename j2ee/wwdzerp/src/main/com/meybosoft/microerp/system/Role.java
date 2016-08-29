package com.meybosoft.microerp.system;
import com.easyjf.dbo.annotation.*;
/**
 * 用户角色，用来记录一组权限
 * @author 李艳
 *
 */
@Table(tableName="SystemRole")
public class Role implements java.io.Serializable{
	@TableField(name="id")
	private Long id;	
	
	@TableField(name="sn")
	private String sn;	
	
	@TableField(name="title")
	private String title;
	
	@TableField(name="intro")
	private String intro;	
	
	@TableField(name="status")
	private Integer status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
