package com.fengf.wms.service;

import com.fengf.common.utils.Page;
import com.fengf.wms.pojo.Product;
import com.fengf.wms.pojo.User;
import com.fengf.wms.pojo.vo.UserQueryVo;

public interface UserService {
	public Page<User> selectPageByQueryVo(UserQueryVo vo);
	public User selectUserById(Integer id);
	public void updateUserById(User user);
	public void deleteUserById(Integer id);
	public void saveNewUser(User user);
	public boolean checkUsername(String username);
}
