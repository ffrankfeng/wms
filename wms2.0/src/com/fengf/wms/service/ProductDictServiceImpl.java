package com.fengf.wms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fengf.wms.mapper.ProductDictDao;
import com.fengf.wms.pojo.ProductDict;


@Service
public class ProductDictServiceImpl implements ProductDictService {
	@Autowired
	private ProductDictDao productDictdao;
	public List<ProductDict> selectProductDictListByCode() {
		return productDictdao.selectProductDictListByCode();
	}

}
