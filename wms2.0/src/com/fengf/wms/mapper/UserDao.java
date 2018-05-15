package com.fengf.wms.mapper;

import java.util.List;

import com.fengf.wms.pojo.Product;
import com.fengf.wms.pojo.User;
import com.fengf.wms.pojo.vo.UserQueryVo;

public interface UserDao {
	
	//总条数
	public Integer userCountByQueryVo(UserQueryVo vo);
	//结果集
	public  List<User> selectUserListByQueryVo(UserQueryVo vo);
	//通过id查询货物
	public User selectUserById(Integer id);
	//通过id修改货物
	public void updateUserById(User user);
	public void deleteUserById(Integer id);
	public void saveNewUser(User user);
	public Long checkUsername(String username);
}
