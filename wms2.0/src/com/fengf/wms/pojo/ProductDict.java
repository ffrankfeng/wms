package com.fengf.wms.pojo;

import java.util.List;

public class ProductDict {
	private Integer pro_dict_id;
	private String pro_dict_code;
	private List<Product> pro_dict_list;
	public ProductDict(Integer pro_dict_id, String pro_dict_code, List<Product> pro_dict_list) {
		super();
		this.pro_dict_id = pro_dict_id;
		this.pro_dict_code = pro_dict_code;
		this.pro_dict_list = pro_dict_list;
	}
	public ProductDict() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public Integer getPro_dict_id() {
		return pro_dict_id;
	}
	public void setPro_dict_id(Integer pro_dict_id) {
		this.pro_dict_id = pro_dict_id;
	}
	public String getPro_dict_code() {
		return pro_dict_code;
	}
	public void setPro_dict_code(String pro_dict_code) {
		this.pro_dict_code = pro_dict_code;
	}
	public List<Product> getPro_dict_list() {
		return pro_dict_list;
	}
	public void setPro_dict_list(List<Product> pro_dict_list) {
		this.pro_dict_list = pro_dict_list;
	}
	@Override
	public String toString() {
		return "ProductDict [pro_dict_id=" + pro_dict_id + ", pro_dict_code=" + pro_dict_code + ", pro_dict_list="
				+ pro_dict_list + "]";
	}
	
}
