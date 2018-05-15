package com.fengf.wms.pojo;

public class Product {
	private Integer pro_id;
	private String pro_name;
	private Integer pro_type;
	private String pro_inf;
	private Double pro_money;
	private Integer pro_count;
	private String pro_uptime;
	private ProductDict productDict;
	public Product(Integer pro_id, String pro_name, Integer pro_type, String pro_inf, Double pro_money,
			Integer pro_count, String pro_uptime, ProductDict productDict) {
		super();
		this.pro_id = pro_id;
		this.pro_name = pro_name;
		this.pro_type = pro_type;
		this.pro_inf = pro_inf;
		this.pro_money = pro_money;
		this.pro_count = pro_count;
		this.pro_uptime = pro_uptime;
		this.productDict = productDict;
	}
	public Product() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public Integer getPro_id() {
		return pro_id;
	}
	public void setPro_id(Integer pro_id) {
		this.pro_id = pro_id;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public Integer getPro_type() {
		return pro_type;
	}
	public void setPro_type(Integer pro_type) {
		this.pro_type = pro_type;
	}
	public String getPro_inf() {
		return pro_inf;
	}
	public void setPro_inf(String pro_inf) {
		this.pro_inf = pro_inf;
	}
	public Double getPro_money() {
		return pro_money;
	}
	public void setPro_money(Double pro_money) {
		this.pro_money = pro_money;
	}
	public Integer getPro_count() {
		return pro_count;
	}
	public void setPro_count(Integer pro_count) {
		this.pro_count = pro_count;
	}
	public String getpro_uptime() {
		return pro_uptime;
	}
	public void setpro_uptime(String pro_uptime) {
		this.pro_uptime = pro_uptime;
	}
	public ProductDict getProductDict() {
		return productDict;
	}
	public void setProductDict(ProductDict productDict) {
		this.productDict = productDict;
	}
	@Override
	public String toString() {
		return "Product [pro_id=" + pro_id + ", pro_name=" + pro_name + ", pro_type=" + pro_type + ", pro_inf="
				+ pro_inf + ", pro_money=" + pro_money + ", pro_count=" + pro_count + ", pro_uptime=" + pro_uptime
				+ ", productDict=" + productDict + "]";
	}

	
}
