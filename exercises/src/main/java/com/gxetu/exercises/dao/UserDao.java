package com.gxetu.exercises.dao;

import com.gxetu.exercises.entity.User;
import org.exitsoft.orm.core.hibernate.support.HibernateSupportDao;
import org.springframework.stereotype.Repository;

/**
 * 用户数据访问
 * 
 * @author vincent
 *
 */
@Repository
public class UserDao extends HibernateSupportDao<User, String>{
	
}
