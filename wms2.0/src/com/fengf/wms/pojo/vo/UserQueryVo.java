package com.fengf.wms.pojo.vo;
import java.io.Serializable;

public class UserQueryVo implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -3249625489171483273L;
	//客户名称
	private String userName;
	private String userPhone;
	private String userAut;
		
	//当前页
	private Integer page;
		
	//每页数
	private Integer size=10;
		
	//开始行
	private Integer startRow=0;

	public UserQueryVo() {
		super();
		// TODO 自动生成的构造函数存根
	}

	public UserQueryVo(String userName, String userPhone, String userAut, Integer page, Integer size,
			Integer startRow) {
		super();
		this.userName = userName;
		this.userPhone = userPhone;
		this.userAut = userAut;
		this.page = page;
		this.size = size;
		this.startRow = startRow;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserAut() {
		return userAut;
	}

	public void setUserAut(String userAut) {
		this.userAut = userAut;
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

	@Override
	public String toString() {
		return "UserQueryVo [userName=" + userName + ", userPhone=" + userPhone + ", userAut=" + userAut + ", page="
				+ page + ", size=" + size + ", startRow=" + startRow + "]";
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
		
}
