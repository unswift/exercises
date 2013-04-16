package com.gxetu.exercises.utils;


/**
 * 系统变量工具类
 * 
 * @author vincent
 *
 */
public class SystemVariableUtils {
	
	//系统安全实体
	private static SystemSecurity systemSecurity;

	/**
	 * 获取系统安全实体
	 * 
	 * @return {@link SystemSecurity}
	 */
	public static SystemSecurity getSystemSecurity() {
		return systemSecurity;
	}

	/**
	 * 设置系统安全实体
	 * 
	 * @param systemSecurity 系统安全实体
	 */
	public static void setSystemSecurity(SystemSecurity systemSecurity) {
		SystemVariableUtils.systemSecurity = systemSecurity;
	}
	
	/**
	 * 判断当前用户是否已经认证
	 * 
	 * @return ture代表已认证,false代表非认证
	 */
	public static boolean currentUserIsAuthenticated() {
		return systemSecurity.getCurrendUser() != null;
	}
}
