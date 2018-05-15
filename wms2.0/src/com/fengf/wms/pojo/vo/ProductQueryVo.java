package com.fengf.wms.pojo.vo;

import java.io.Serializable;

public class ProductQueryVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7094093339511682702L;
	private String productName;
	private String productType;
	private String productUptime;
	private Integer pro_id;
	private Integer pro_input;
	private Integer pro_output;
	private Integer pro_count;	
	
	//当前页
	private Integer page;
		
	//每页数
	private Integer size=10;
		
	//开始行
	private Integer startRow=0;



	public ProductQueryVo(String productName, String productType, String productUptime, Integer pro_id,
			Integer pro_input, Integer pro_output, Integer pro_count, Integer page, Integer size, Integer startRow) {
		super();
		this.productName = productName;
		this.productType = productType;
		this.productUptime = productUptime;
		this.pro_id = pro_id;
		this.pro_input = pro_input;
		this.pro_output = pro_output;
		this.pro_count = pro_count;
		this.page = page;
		this.size = size;
		this.startRow = startRow;
	}

	public ProductQueryVo() {
		super();
		// TODO 自动生成的构造函数存根
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getProductUptime() {
		return productUptime;
	}

	public void setProductUptime(String productUptime) {
		this.productUptime = productUptime;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getStartRow() {
		return startRow;
	}

	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getPro_id() {
		return pro_id;
	}

	public void setPro_id(Integer pro_id) {
		this.pro_id = pro_id;
	}

	public Integer getPro_input() {
		return pro_input;
	}

	public void setPro_input(Integer pro_input) {
		this.pro_input = pro_input;
	}

	public Integer getPro_output() {
		return pro_output;
	}

	public void setPro_output(Integer pro_output) {
		this.pro_output = pro_output;
	}

	public Integer getPro_count() {
		return pro_count;
	}

	public void setPro_count(Integer pro_count) {
		this.pro_count = pro_count;
	}

	@Override
	public String toString() {
		return "ProductQueryVo [productName=" + productName + ", productType=" + productType + ", productUptime="
				+ productUptime + ", pro_id=" + pro_id + ", pro_input=" + pro_input + ", pro_output=" + pro_output
				+ ", pro_count=" + pro_count + ", page=" + page + ", size=" + size + ", startRow=" + startRow + "]";
	}




	
}
