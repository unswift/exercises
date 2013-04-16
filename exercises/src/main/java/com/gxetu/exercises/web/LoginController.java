package com.gxetu.exercises.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gxetu.exercises.entity.User;
import com.gxetu.exercises.service.AccountManager;
/**
 * 	登录 Spring MVC 实现类
 * 	@author 李云龙
 *			<br/>联系电话：15978101829
 *			<br/>E-mail: hot-java@163.com
 *			<br/>QQ	   : 348184835
 *			<br/>开发日期：2013-4-16
 * 	@since 	V1.0
 */
@Controller
public class LoginController {

	@Autowired
	private AccountManager accountManager;
	
	/**
	 * 	跳转到登录页面
	 * 	@author 李云龙
	 */
	@RequestMapping("login")
	public void login(){
		
	}
	
	/**
	 * 	登录，传递用户名和密码
	 * 	@author 李云龙
	 *	@param username
	 *	@param password
	 *	@param modelAndView
	 *	@return
	 */
	@RequestMapping("dologin")
	public ModelAndView dologin(@RequestParam("username")String username, @RequestParam("password")String password, ModelAndView model){
		User user=accountManager.getUserByUsername(username);
		if(user!=null && user.getPassword().equals(password)){
			model.setViewName("index");
		}else{
			model.setViewName("redirect:login?msg=用户名或密码错");
		}
		model.addObject("username", username);
		return model;
	}
	
}
