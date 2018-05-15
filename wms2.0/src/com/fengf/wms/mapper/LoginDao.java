package com.fengf.wms.mapper;

import com.fengf.wms.pojo.User;

public interface LoginDao {

	User login(String cur_username);
}
