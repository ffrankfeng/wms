package com.fengf.wms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fengf.common.utils.Page;
import com.fengf.wms.mapper.ProductDao;
import com.fengf.wms.mapper.UserDictDao;

import com.fengf.wms.pojo.Product;
import com.fengf.wms.pojo.UserDict;

@Service
public class UserDictServiceImpl implements UserDictService {

	@Autowired
	private UserDictDao userDictdao;

	public List<UserDict> selectUserDictListByCode() {
		System.out.println("UserDictServiceImpl");
		return userDictdao.selectUserDictListByCode();
	}
}
