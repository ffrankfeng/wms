package com.fengf.wms.service;

import javax.servlet.http.HttpServletResponse;

import com.fengf.common.utils.Page;
import com.fengf.wms.pojo.Product;
import com.fengf.wms.pojo.vo.ProductQueryVo;

public interface ProductService {
	public Page<Product> selectPageByQueryVo(ProductQueryVo vo);
	public Product selectProductById(Integer id);
	public void updateProductById(Product product);
	public void deleteProductById(Integer id);
	public void outputExcel(Page<Product> page, HttpServletResponse response);
	public void saveInputProduct(ProductQueryVo proVo);
	public void saveOutputProduct(ProductQueryVo proVo);
	public void saveNewProduct(Product product);
	public boolean check(String proname, String protype, String promoney, String proinf);
	public Page<Product> selectallPageByQueryVo(ProductQueryVo vo);
}
