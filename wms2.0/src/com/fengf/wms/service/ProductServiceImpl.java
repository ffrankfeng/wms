package com.fengf.wms.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fengf.common.utils.Page;
import com.fengf.wms.mapper.ProductDao;
import com.fengf.wms.pojo.Product;
import com.fengf.wms.pojo.vo.ProductQueryVo;

/**
 * 货物管理
 * @author asus
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	//通过四个条件，查询分页对象
	public Page<Product> selectPageByQueryVo(ProductQueryVo vo){
		Page<Product> page=new Page<Product>();
		//每页数
		vo.setSize(5);
		page.setSize(5);


		if(vo!=null ){
			//判断当前页
			if(vo.getPage()!=null){
				page.setPage(vo.getPage());
				vo.setStartRow((vo.getPage()-1)*vo.getSize());
			}
			if(vo.getProductName()!=null && !vo.getProductName().trim().equals("")){
				vo.setProductName(vo.getProductName().trim() );
			}
			if(vo.getProductType()!=null && !vo.getProductType().trim().equals("")){
				vo.setProductType(vo.getProductType().trim() );
			}
			if(vo.getProductUptime()!=null && !vo.getProductUptime().trim().equals("")){
				vo.setProductUptime(vo.getProductUptime().trim() );
			}
			//总条数
			page.setTotal(productDao.productCountByQueryVo(vo));
			page.setRows(productDao.selectProductListByQueryVo(vo));
		}
			
		return page;
	}
	@Override
	public Page<Product> selectallPageByQueryVo(ProductQueryVo vo) {
		Page<Product> page=new Page<Product>();
		//每页数
		if(vo!=null ){
			//判断当前页
			if(vo.getPage()!=null){
				page.setPage(vo.getPage());
				vo.setStartRow((vo.getPage()-1)*vo.getSize());
			}
			if(vo.getProductName()!=null && !vo.getProductName().trim().equals("")){
				vo.setProductName(vo.getProductName().trim() );
			}
			if(vo.getProductType()!=null && !vo.getProductType().trim().equals("")){
				vo.setProductType(vo.getProductType().trim() );
			}
			if(vo.getProductUptime()!=null && !vo.getProductUptime().trim().equals("")){
				vo.setProductUptime(vo.getProductUptime().trim() );
			}
			//总条数
			page.setTotal(productDao.productCountByQueryVo(vo));
			page.setRows(productDao.selectAllProductListByQueryVo(vo));
		}
			
		return page;
	}
	public Product selectProductById(Integer id) {
		return productDao.selectProductById(id);
	}
	public void updateProductById(Product product){
		product.setpro_uptime(getupDate());
		productDao.updateProductById(product);
	}

	public void deleteProductById(Integer id) {
		productDao.deleteProductById(id);
	}

	@Override
	public void outputExcel(Page<Product> page,HttpServletResponse response) {
		//创建HSSFWorkbook对象(excel的文档对象)
	    HSSFWorkbook wb = new HSSFWorkbook();
	    //建立新的sheet对象（excel的表单）
	    HSSFSheet sheet=wb.createSheet("货物表");
	    //在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
	    HSSFRow row1=sheet.createRow(0);
	    //创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
	    HSSFCell cell=row1.createCell(0);
	    //设置单元格内容
	    cell.setCellValue("库存货物一览表");
	    //合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
	    sheet.addMergedRegion(new CellRangeAddress(0,0,0,6));
	    //在sheet里创建第二行
	    HSSFRow row0=sheet.createRow(1);    
 	    //创建单元格并设置单元格内容
 	    row0.createCell(0).setCellValue("ID");
 	    row0.createCell(1).setCellValue("name");    
 	    row0.createCell(2).setCellValue("type");
 	    row0.createCell(3).setCellValue("information");
 	    row0.createCell(4).setCellValue("money");    
 	    row0.createCell(5).setCellValue("count");    
 	    row0.createCell(6).setCellValue("update");   
 	    
 	   Iterator<Product> it=page.getRows().iterator();
 	   int i=1;
 	   while(it.hasNext()){  
 		   Product pd=it.next();
 		   HSSFRow row=sheet.createRow(++i);    
	 	   //创建单元格并设置单元格内容
	 	   row.createCell(0).setCellValue(pd.getPro_id());
	 	   row.createCell(1).setCellValue(pd.getPro_name());    
	 	   row.createCell(2).setCellValue(pd.getProductDict().getPro_dict_code());
	 	   row.createCell(3).setCellValue(pd.getPro_inf());
	 	   row.createCell(4).setCellValue(pd.getPro_money());    
	 	   row.createCell(5).setCellValue(pd.getPro_count());    
	 	   row.createCell(6).setCellValue(pd.getpro_uptime());   
 	   }
 		//输出Excel文件
 		   	OutputStream output;
			try {
				output = response.getOutputStream();
				response.reset();
	 		    response.setHeader("Content-disposition", "attachment; filename=download.xls");
	 		    response.setContentType("application/msexcel");        
	 		    wb.write(output);
	 		    output.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
	}
	public String getupDate(){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date=sdf.format(new Date());
		return date;
	}
	public void saveInputProduct(ProductQueryVo proVo) {
		proVo.setProductUptime(getupDate());
		productDao.saveInputProduct(proVo);
	}

	@Override
	public void saveOutputProduct(ProductQueryVo proVo) {
		if(proVo.getPro_count()>proVo.getPro_output()){
			proVo.setProductUptime(getupDate());
			productDao.saveOutputProduct(proVo);
		}
		else{
			productDao.deleteProductById(proVo.getPro_id());
		}
	}

	@Override
	public void saveNewProduct(Product product) {
		product.setpro_uptime(getupDate());
		productDao.saveNewProduct(product);
	}

	@Override
	public boolean check(String proname, String protype, String promoney, String proinf) {
		Product product=new Product();
		product.setPro_name(proname);
		double pro_money=Double.parseDouble(promoney);
		int pro_type=Integer.parseInt(protype);
		product.setPro_money(pro_money);
		product.setPro_inf(proinf);
		product.setPro_type(pro_type);
		Long isExist=productDao.check(product);
		System.out.println(isExist);
		return isExist>0?true:false;
	}


}
