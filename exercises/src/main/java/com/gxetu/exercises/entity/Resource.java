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
import javax.persistence.OrderBy;
import javax.persistence.Table;

/**
 * 资源实体类
 * 
 * @author vincent
 *
 */
@Entity
@Table(name="TB_RESOURCE")
public class Resource  extends UniversallyUniqueIdentifier{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6212202811480704968L;
	
	//资源名称
	private String name;
	//controller路径
	private String controllerPath;
	//shiro permission 字符串
	private String permission;
	//资源类型 
	private String type;
	//父类
	private Resource parent;
	//顺序值
	private Integer sort;
	//子类
	private List<Resource> children = new ArrayList<Resource>();
	//资源所对应的组集合
	private List<Group> groupsList = new ArrayList<Group>();
	//备注
	private String remark;
	
	public Resource() {
		
	}
	
	/**
	 * 获取资源名称
	 * 
	 * @return String
	 */
	@Column(length=64,unique=true,nullable=false)
	public String getName() {
		return name;
	}

	/**
	 * 设置资源名称
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取controller路径 
	 * 
	 * @return String
	 */
	@Column(length=512)
	public String getControllerPath() {
		return controllerPath;
	}

	/**
	 * 设置controller路径
	 * 
	 * @param controllerPath controller路径
	 */
	public void setControllerPath(String controllerPath) {
		this.controllerPath = controllerPath;
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
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * 获取shiro 的 permission
	 * 
	 * @return String
	 */
	@Column(unique=true,length=128)
	public String getPermission() {
		return permission;
	}

	/**
	 * 设置shiro 的 permission
	 * @param permission
	 */
	public void setPermission(String permission) {
		this.permission = permission;
	}

	/**
	 * 获取资源类型
	 * 
	 * @return 01代表菜单类型，02代表资源类型 
	 */
	@Column(nullable=false,length=2)
	public String getType() {
		return type;
	}

	/**
	 * 设置资源类型
	 * 
	 * @param type 01代表菜单类型，02代表资源类型
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 获取资源的父类
	 * 
	 * @return {@link Resource}
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_PARENT_ID")
	public Resource getParent() {
		return parent;
	}

	/**
	 * 设置资源的父类
	 * 
	 * @param parent 父类资源
	 */
	public void setParent(Resource parent) {
		this.parent = parent;
	}

	/**
	 * 获取资源顺序值
	 * 
	 * @return Integer
	 */
	public Integer getSort() {
		return sort;
	}

	/**
	 * 设置顺序值
	 * 
	 * @param sort 顺序值
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}

	/**
	 * 获取该资源下的子类资源集合
	 * 
	 * @return {@link List}
	 */
	@OrderBy("sort ASC")
	@OneToMany(mappedBy = "parent",fetch = FetchType.LAZY,cascade={CascadeType.ALL})
	public List<Resource> getChildren() {
		return children;
	}

	/**
	 * 设置该资源下的子类资源集合
	 * 
	 * @param children 子类资源集合
	 */
	public void setChildren(List<Resource> children) {
		this.children = children;
	}

	/**
	 * 获取该资源对应的组集合
	 * 
	 * @return {@link List}
	 */
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name = "TB_GROUP_RESOURCE", joinColumns = { @JoinColumn(name = "FK_RESOURCE_ID") }, inverseJoinColumns = { @JoinColumn(name = "FK_GROUP_ID") })
	public List<Group> getGroupsList() {
		return groupsList;
	}

	/**
	 * 设置该资源下的组集合
	 * 
	 * @param groupsList 组集合
	 */
	public void setGroupsList(List<Group> groupsList) {
		this.groupsList = groupsList;
	}
	
	
	
}
