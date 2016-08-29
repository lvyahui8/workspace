package com.meybosoft.microerp.system;
//系统数据字典值
import java.io.Serializable;
import com.easyjf.dbo.annotation.*;
@Table(tableName="SystemBasicDataDetail")
public class SystemDictionaryDetail implements Serializable,Comparable {

	private Long id;	
	@OneToOne(column="parent_id",type=SystemDictionary.class)
	private SystemDictionary parent;

	private String title;

	private String tvalue;

	private Integer sequence;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public SystemDictionary getParent() {
		return parent;
	}
	public void setParent(SystemDictionary parent) {
		this.parent = parent;
	}
	public Integer getSequence() {
		return sequence;
	}
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTvalue() {
		return tvalue;
	}
	public void setTvalue(String tvalue) {
		this.tvalue = tvalue;
	}

	public boolean equals(Object obj) {
		if((obj==null)||(! (obj instanceof SystemDictionaryDetail)))return false;		
		SystemDictionaryDetail o=(SystemDictionaryDetail)obj;
		if(this.id!=null && (o.getId()!=null))return this.id.equals(o.getId());
		return super.equals(obj);
	}
	public int compareTo(Object o) {
		SystemDictionaryDetail m = (SystemDictionaryDetail) o;	
		if(this.sequence==null)return 1;
		if(m.sequence==null)return -1;
		return (this.sequence.intValue() - m.sequence.intValue());
	}
	
}
