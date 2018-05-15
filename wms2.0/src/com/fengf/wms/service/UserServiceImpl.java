package com.fengf.wms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fengf.common.utils.MD5Utils;
import com.fengf.common.utils.Page;
import com.fengf.wms.mapper.UserDao;
import com.fengf.wms.pojo.Product;
import com.fengf.wms.pojo.User;
import com.fengf.wms.pojo.vo.UserQueryVo;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	//通过四个条件，查询分页对象
		public Page<User> selectPageByQueryVo(UserQueryVo vo){
			Page<User> page=new Page<User>();
			//每页数
			vo.setSize(5);
			page.setSize(5);
			if(vo!=null ){
				//判断当前页
				if(vo.getPage()!=null){
					page.setPage(vo.getPage());
					vo.setStartRow((vo.getPage()-1)*vo.getSize());
				}
				if(vo.getUserName()!=null && !vo.getUserName().trim().equals("")){
					vo.setUserName(vo.getUserName().trim() );
				}
				if(vo.getUserPhone()!=null && !vo.getUserPhone().trim().equals("")){
					vo.setUserPhone(vo.getUserPhone().trim() );
				}
				if(vo.getUserAut()!=null && !vo.getUserAut().trim().equals("")){
					vo.setUserAut(vo.getUserAut().trim() );
				}
				//总条数
				page.setTotal(userDao.userCountByQueryVo(vo));
				page.setRows(userDao.selectUserListByQueryVo(vo));
			}
			return page;
		}
	
		public User selectUserById(Integer id) {
			return userDao.selectUserById(id);
		}
		public void deleteUserById(Integer id) {
			userDao.deleteUserById(id);
		}

		@Override
		public void updateUserById(User user) {
			if(!user.getUser_password().equals("")){
				System.out.println("uouou="+user);
				user.setUser_password(MD5Utils.MD5(user.getUser_password()));
			}
			userDao.updateUserById(user);
		}

		@Override
		public void saveNewUser(User user) {
			user.setUser_password(MD5Utils.MD5(user.getUser_password()));
			userDao.saveNewUser(user);
		}

		@Override
		public boolean checkUsername(String username) {
			Long isExist=userDao.checkUsername(username);
			System.out.println("username="+username);
			System.out.println("isExist="+isExist);
			return isExist>0?true:false;
		}

}
