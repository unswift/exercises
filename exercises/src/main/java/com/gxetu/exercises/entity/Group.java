package com.gxetu.exercises.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 组实体类
 * 
 * @author vincent
 *
 */
@Entity
@Table(name="TB_GROUP")
public class Group  extends UniversallyUniqueIdentifier{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2782822408895366101L;
	
	//组名称
	private String name;
	//成员
	private List<User> membersList = new ArrayList<User>();
	//上级组
	private Group parent;
	//下级组集合
	private List<Group> children = new ArrayList<Group>();
	//备注
	private String remark;
	//拥有资源
	private List<Resource> resourcesList = new ArrayList<Resource>();
	//shiro role 字符串
	private String role;
	//shiro role连定义的值
	private String value;
	
	public Group() {
		
	}
	
	/**
	 * 获取组名称 
	 * 
	 * @return String
	 */
	@Column(length=64,unique=true,nullable=false)
	public String getName() {
		return name;
	}

	/**
	 * 设置组名称
	 * 
	 * @param name 组名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取备注
	 * 
	 * @return String
	 */
	@Column(columnDefinition="text")
	public String getRemark() {
		return remark;
	}

	/**
	 * 设置备注
	 * 
	 * @param remark 备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 获取该组的所有用户集合
	 * 
	 * @return {@link List}
	 */
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name = "TB_GROUP_USER", joinColumns = { @JoinColumn(name = "FK_GROUP_ID") }, inverseJoinColumns = { @JoinColumn(name = "FK_USER_ID") })
	public List<User> getMembersList() {
		return membersList;
	}

	/**
	 * 设置该组的所有用户集合
	 * @param membersList
	 */
	public void setMembersList(List<User> membersList) {
		this.membersList = membersList;
	}

	/**
	 * 获取该组的父类
	 * 
	 * @return {@link Group}
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "FK_PARENT_ID")
	public Group getParent() {
		return parent;
	}

	/**
	 * 设置该组的父类
	 * 
	 * @param parent 父类
	 */
	public void setParent(Group parent) {
		this.parent = parent;
	}

	/**
	 * 获取该组下的所有子类集合
	 * 
	 * @return {@link List}
	 */
	@OneToMany(fetch=FetchType.LAZY,mappedBy="parent",cascade={CascadeType.ALL})
	public List<Group> getChildren() {
		return children;
	}

	/**
	 * 设置该组下的所有子类集合
	 * 
	 * @param children 子类集合
	 */
	public void setChildren(List<Group> children) {
		this.children = children;
	}

	/**
	 * 获取该组拥有的所有资源集合
	 * 
	 * @return List
	 */
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name = "TB_GROUP_RESOURCE", joinColumns = { @JoinColumn(name = "FK_GROUP_ID") }, inverseJoinColumns = { @JoinColumn(name = "FK_RESOURCE_ID") })
	public List<Resource> getResourcesList() {
		return resourcesList;
	}

	/**
	 * 设置该组拥有的资源集合
	 * @param resourcesList
	 */
	public void setResourcesList(List<Resource> resourcesList) {
		this.resourcesList = resourcesList;
	}

	/**
	 * 获取对应shiro的role filter名称
	 * 
	 * @return String
	 */
	@Column(length=64)
	public String getRole() {
		return role;
	}

	/**
	 * 设置对应shiro的role filter名称
	 * 
	 * @param role filter名称
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * 获取对应shiro的role值
	 * 
	 * @return String
	 */
	@Column(length=256)
	public String getValue() {
		return value;
	}

	/**
	 * 设置对应shiro的row值
	 * 
	 * @param value 值
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
}
