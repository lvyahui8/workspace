package cn.hnctcm.tescocampus.domain;

import java.util.Date;

public class Shop {	
	private String name;
	private String induc;
	private int sendUpPrices;
	private int imgSrcId;
	private Date openDate;
	
	public Shop() {
		super();
	}
	public Shop(String shopName, String shopInduc, int sendUpPrices,
			int imgSrcId,Date openDate) {
		super();
		this.name = shopName;
		this.induc = shopInduc;
		this.sendUpPrices = sendUpPrices;
		this.imgSrcId = imgSrcId;
		this.openDate = openDate;
	}

	public int getSendUpPrices() {
		return sendUpPrices;
	}
	public void setSendUpPrices(int sendUpPrices) {
		this.sendUpPrices = sendUpPrices;
	}

	public Date getOpenDate() {
		return openDate;
	}
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInduc() {
		return induc;
	}
	public void setInduc(String induc) {
		this.induc = induc;
	}
	
	
	public int getImgSrcId() {
		return imgSrcId;
	}
	public void setImgSrcId(int imgSrcId) {
		this.imgSrcId = imgSrcId;
	}
	@Override
	public String toString() {
		return "Shop [name=" + name + ", induc=" + induc + ", sendUpPrices="
				+ sendUpPrices + ", imgSrcId=" + imgSrcId + ", openDate="
				+ openDate + "]";
	}
	
}
