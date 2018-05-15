package com.fengf.wms.service;

import java.util.List;

import com.fengf.wms.pojo.UserDict;

public interface UserDictService {

	List<UserDict> selectUserDictListByCode();
}
