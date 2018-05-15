package com.fengf.wms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fengf.common.utils.Page;

import com.fengf.wms.pojo.User;
import com.fengf.wms.pojo.UserDict;
import com.fengf.wms.pojo.vo.UserQueryVo;
import com.fengf.wms.service.UserDictService;
import com.fengf.wms.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private UserDictService userDictService;
	List<UserDict> fromAut=null;
	//用户
	@RequestMapping(value="/user/list")
	public String list(UserQueryVo vo,Model model){
		fromAut = userDictService.selectUserDictListByCode();
		model.addAttribute("fromAut", fromAut);
		//通过四个条件，查询分页对象
		Page<User> page = userService.selectPageByQueryVo(vo);
		model.addAttribute("page", page);
		return "workerAdmin";
	}
	@RequestMapping(value="/user/editUser")
	public String edit(Integer id,Model model){
		fromAut = userDictService.selectUserDictListByCode();
		User u=userService.selectUserById(id);
		model.addAttribute("fromAut", fromAut);
		model.addAttribute("user", u);
		return "editWorker";
	}
	//保存修改
	@RequestMapping(value="/user/update")
	public String update(User user){
		userService.updateUserById(user);
		return "redirect:list";
	}
	//删除
	@RequestMapping(value="/user/delete")
	public @ResponseBody
		void delete(Integer id ){
			userService.deleteUserById(id);
	}
	@RequestMapping(value="user/newUser")
	public String newUser(Model model){
		fromAut = userDictService.selectUserDictListByCode();
		model.addAttribute("fromAut", fromAut);
		return "newUser";
	}
	//保存新增用户信息
	@RequestMapping(value="user/saveNewUser")
	public String saveNewUser(User user,Model model){
		userService.saveNewUser(user);
		return "redirect:list";
	}
	//核查用户名
	@RequestMapping(value="user/checkUsername")
	public void checkUsername(String username,HttpServletResponse response){
		System.out.println("conusername="+username);
		boolean isExist=userService.checkUsername(username);
		try {
			response.getWriter().write("{\"isExist\":"+isExist+"}");
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
