package com.fengf.wms.mapper;

import java.util.List;


import com.fengf.wms.pojo.Product;
import com.fengf.wms.pojo.vo.ProductQueryVo;


public interface ProductDao {
	
	//总条数
	public Integer productCountByQueryVo(ProductQueryVo vo);
	//结果集
	public  List<Product> selectProductListByQueryVo(ProductQueryVo vo);
	public  List<Product> selectAllProductListByQueryVo(ProductQueryVo vo);
	
	//通过id查询货物
	public Product selectProductById(Integer id);
	//通过id修改货物
	public void updateProductById(Product product);
	public void deleteProductById(Integer id);
	public void saveInputProduct(ProductQueryVo proVo);
	public void saveOutputProduct(ProductQueryVo proVo);
	public void saveNewProduct(Product product);
	public Long check(Product product);
}
