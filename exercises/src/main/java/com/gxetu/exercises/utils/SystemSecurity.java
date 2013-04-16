package com.gxetu.exercises.utils;

import java.io.Serializable;

import com.gxetu.exercises.entity.User;

/**
 * 系统安全实体
 * 
 * @author vincent
 *
 */
public class SystemSecurity implements Serializable{
	
	private static final long serialVersionUID = -8001588875152385490L;
	
	//当前用户
	private User currendUser;
	
	public SystemSecurity() {
		
	}

	/**
	 * 获取当前用户
	 * 
	 * @return {@link User}
	 */
	public User getCurrendUser() {
		return currendUser;
	}

	/**
	 * 设置当前用户
	 * 
	 * @param currendUser 当前用户
	 * 
	 * @see User
	 */
	public void setCurrendUser(User currendUser) {
		this.currendUser = currendUser;
	}
	
	
	
}
