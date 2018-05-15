package com.fengf.wms.mapper;

import java.util.List;

import com.fengf.wms.pojo.UserDict;

public interface UserDictDao {

	List<UserDict> selectUserDictListByCode();

}
