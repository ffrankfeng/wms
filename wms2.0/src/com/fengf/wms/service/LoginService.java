package com.fengf.wms.service;

import com.fengf.wms.pojo.User;

public interface LoginService {

	User login(String cur_username, String cur_password);

}
