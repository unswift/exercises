package com.gxetu.exercises.service;

import java.util.List;

import com.gxetu.exercises.dao.UserDao;
import com.gxetu.exercises.entity.User;
import org.exitsoft.orm.core.Page;
import org.exitsoft.orm.core.PageRequest;
import org.exitsoft.orm.core.PropertyFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 账户管理业务逻辑
 * 
 * @author vincent
 *
 */
@Service
@Transactional
public class AccountManager {
	
	/**
	 * 用户数据访问
	 */
	@Autowired
	private UserDao userDao;
	
	//------------------------------------------------------------------用户管理 开始-------------------------------------------------------------------------------//
	
	/**
	 * 通过id获取用户实体
	 * 
	 * @param id 主键id
	 * 
	 * @return {@link User}
	 */
	public User getUser(String id) {
		return userDao.load(id);
	}
	
	/**
	 * 通过登录账号获取用户实体
	 * 
	 * @param username 用户实体
	 * 
	 * @return {@link User}
	 */
	public User getUserByUsername(String username) {
		return userDao.findUniqueByProperty("username", username);
	}
	
	/**
	 * 保存用户实体
	 * 
	 * @param entity 用户实体
	 * 
	 */
	public void saveUser(User entity) {
		userDao.save(entity);
	}
	
	/**
	 * 通过id集合删除用户
	 * 
	 * @param id id集合
	 */
	public void deleteUser(List<String> id) {
		userDao.deleteAll(id);
	}
	
	/**
	 * 通过分页请求和属性过滤器集合查询用户分页
	 * 
	 * @param request 分页请求
	 * @param filters 属性过滤器
	 * 
	 * @return {@link Page}
	 */
	public Page<User> searchUser(PageRequest request,List<PropertyFilter> filters) {
		return userDao.findPage(request, filters);
	}
	
	//------------------------------------------------------------------用户管理 结束-------------------------------------------------------------------------------//
}
