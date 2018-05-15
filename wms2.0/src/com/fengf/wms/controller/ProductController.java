package com.fengf.wms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fengf.common.utils.Page;
import com.fengf.wms.pojo.Product;
import com.fengf.wms.pojo.ProductDict;
import com.fengf.wms.pojo.vo.ProductQueryVo;
import com.fengf.wms.service.ProductDictService;
import com.fengf.wms.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductDictService productDictService;
	
	Page<Product> page=null;
	Page<Product> allpage=null;
	List<ProductDict> productDictList=null;
	@RequestMapping(value="/product/list")
	public String list(ProductQueryVo vo,Model model){
		productDictList = productDictService.selectProductDictListByCode();
		model.addAttribute("productDictList", productDictList);
		//通过四个条件，查询分页对象
		page = productService.selectPageByQueryVo(vo);
		System.out.println("page="+page);
		allpage = productService.selectallPageByQueryVo(vo);
		System.out.println("allpage="+allpage);
		model.addAttribute("page", page);
		return "productionAdmin";
	}
	@RequestMapping(value="/product/outputExcel")
	void outputExcel(HttpServletResponse response){
		productService.outputExcel(allpage, response);
	}
	@RequestMapping(value="/product/editProduction")
	public String edit(Integer id,Model model){
		Product u=productService.selectProductById(id);
		productDictList = productDictService.selectProductDictListByCode();
		model.addAttribute("productinf", u);
		model.addAttribute("productDictList", productDictList);
		return "editProduction";
	}
	//保存修改
	@RequestMapping(value="/product/update")
	public String update(Product product){
		productService.updateProductById(product); 
		return "redirect:list";
	}
	//删除
	@RequestMapping(value="/product/delete")
	public @ResponseBody
	void delete(Integer id ){
		productService.deleteProductById(id);
	}
	//货物入库
	@RequestMapping(value="/product/inputProduct")
	public String  inputProduct(Integer id,Model model){
		Product u=productService.selectProductById(id);	
		model.addAttribute("productinf", u);
		return "input";
	}
	//保存货物入库
	@RequestMapping(value="/product/saveInput")
	public String saveInput(ProductQueryVo proVo, Model model){
		productService.saveInputProduct(proVo);
		return "redirect:list";
		
	}
	//货物出库
	@RequestMapping(value="/product/outputProduct")
	public String  outputProduct(Integer id,Model model){
		Product u=productService.selectProductById(id);	
		model.addAttribute("productinf", u);
		return "output";
	}
	//保存货物入库
	@RequestMapping(value="/product/saveOutput")
	public String saveOutput(ProductQueryVo proVo, Model model){
		productService.saveOutputProduct(proVo);
		return "redirect:list";		
	}
	//新增货物
	@RequestMapping(value="/product/newProduction")
	public String newProduction(Model model){
		productDictList = productDictService.selectProductDictListByCode();
		model.addAttribute("productDictList", productDictList);
		return "newProduction";
	}
	//保存新增货物
	@RequestMapping(value="/product/saveNewProduct")
	public String saveNewProduct(Product product,Model model){
		productService.saveNewProduct(product);
		return "redirect:list";
	}
	@RequestMapping(value="product/checkProname")
	public void checkProname(String proname,String protype,String promoney,String proinf,HttpServletResponse response){
		boolean isExist=productService.check(proname,protype,promoney,proinf);
		try {
			response.getWriter().write("{\"isExist\":"+isExist+"}");
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
