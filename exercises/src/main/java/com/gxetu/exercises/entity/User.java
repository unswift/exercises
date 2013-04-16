package com.gxetu.exercises.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.exitsoft.common.utils.CollectionUtils;


/**
 * 用户实体类
 * 
 * @author vincent
 *
 */
@Entity
@Table(name="TB_USER")
public class User extends UniversallyUniqueIdentifier{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3625129058551953433L;
	
	//登录名称
	private String username;
	//登录密码
	private String password;
	//真实名称
	private String realname;
	//状态 1:启用，2:禁用，3:删除
	private Integer state;
	//邮件
	private String email;
	//用户所在的组
	private List<Group> groupsList = new ArrayList<Group>();
	
	/**
	 * 用户实体类
	 */
	public User() {
		
	}

	/**
	 * 获取登录名称
	 * 
	 * @return String
	 */
	@Column(length=64,unique=true,nullable=false,updatable=false)
	public String getUsername() {
		return username;
	}

	/**
	 * 设置登录名称
	 * 
	 * @param username 登录名称
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 获取登录密码
	 * 
	 * @return String
	 */
	@Column(nullable=false,length=32,updatable=false)
	public String getPassword() {
		return password;
	}

	/**
	 * 设置登录密码
	 * 
	 * @param password 登录密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 获取真实姓名
	 * 
	 * @return String
	 */
	@Column(length=128,nullable=false)
	public String getRealname() {
		return realname;
	}

	/**
	 * 设置真实名称
	 * 
	 * @param realName 真实姓名
	 */
	public void setRealname(String realname) {
		this.realname = realname;
	}

	/**
	 * 获取用户状态
	 * 
	 * @return 1:启用，2:禁用，3:删除
	 */
	@Column(nullable=false)
	public Integer getState() {
		return state;
	}

	/**
	 * 设置用户状态
	 * 
	 * @param state 用户状态 1:启用，2:禁用，3:删除
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	
	/**
	 * 获取邮件
	 * @return String
	 */
	@Column(length=128)
	public String getEmail() {
		return email;
	}

	/**
	 * 设置邮件 
	 * @param email 邮件地址 
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * 获取该用户所在的组
	 * 
	 * @return List
	 */
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name = "TB_GROUP_USER", joinColumns = { @JoinColumn(name = "FK_USER_ID") }, inverseJoinColumns = { @JoinColumn(name = "FK_GROUP_ID") })
	public List<Group> getGroupsList() {
		return groupsList;
	}
	
	/**
	 * 设置用户所在的组
	 * 
	 * @param groupsList 组集合
	 */
	public void setGroupsList(List<Group> groupsList) {
		this.groupsList = groupsList;
	}
	
	/**
	 * 获取该用户所对应的组名称，如果多个使用逗号","分隔
	 * 
	 * @return String
	 */
	@Transient
	public String getGroupNames() {
		return this.groupsList == null && this.groupsList.size()  == 0 ? null : CollectionUtils.extractToString(this.groupsList, "name", ",");
	}
	
	
}
