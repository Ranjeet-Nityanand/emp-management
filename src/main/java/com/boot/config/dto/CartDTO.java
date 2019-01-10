package com.boot.config.dto;

public class CartDTO {
	private Integer id;
	private Integer userid;
	private Integer itemid;
	private Integer selecteditem;
	private Float itemprice;
	private String itemname;
	private Float totalprice;

	public Float getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(Float totalprice) {
		this.totalprice = totalprice;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getItemid() {
		return itemid;
	}

	public void setItemid(Integer itemid) {
		this.itemid = itemid;
	}

	public Integer getSelecteditem() {
		return selecteditem;
	}

	public void setSelecteditem(Integer selecteditem) {
		this.selecteditem = selecteditem;
	}

	public Float getItemprice() {
		return itemprice;
	}

	public void setItemprice(Float itemprice) {
		this.itemprice = itemprice;
	}

	@Override
	public String toString() {
		return "[ Userid= " + userid + ", itemid= " + itemid + ", selecteditem= " + selecteditem + ", Price="
				+ itemprice + "]";
	}

}
