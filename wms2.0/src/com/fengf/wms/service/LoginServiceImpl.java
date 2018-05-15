package com.fengf.wms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fengf.common.utils.MD5Utils;
import com.fengf.wms.mapper.LoginDao;
import com.fengf.wms.pojo.User;


@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao loginDao;
	public User login(String cur_username, String cur_password) {
		cur_password=MD5Utils.MD5(cur_password);
		User user=loginDao.login(cur_username);
		if(user!=null){
			if(user.getUser_name().equals(cur_username)&&user.getUser_password().equals(cur_password)){
				return user;
			}
		}
		return null;
	}

}
