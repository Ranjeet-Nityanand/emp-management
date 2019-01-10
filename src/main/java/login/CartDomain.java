package login;

public class CartDomain {
	private Integer id;
	private Integer userid;
	private Integer itemid;
	private Integer itemquantity;
	private Float itemprice;
	private Float totalprice;
	private String itemname;

	@Override
	public String toString() {
		return "[ id=" + id + ", userid=" + userid + ", itemid=" + itemid + ", itemPrice=" + itemprice + "]";
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

	public Integer getItemquantity() {
		return itemquantity;
	}

	public void setItemquantity(Integer itemquantity) {
		this.itemquantity = itemquantity;
	}

	public Float getItemprice() {
		return itemprice;
	}

	public void setItemprice(Float itemprice) {
		this.itemprice = itemprice;
	}

	public Float getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(Float totalprice) {
		this.totalprice = totalprice;
	}

}
