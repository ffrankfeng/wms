package com.fengf.wms.mapper;

import java.util.List;

import com.fengf.wms.pojo.ProductDict;


public interface ProductDictDao {

	List<ProductDict> selectProductDictListByCode();

}
