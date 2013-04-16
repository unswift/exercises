package com.gxetu.exercises.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.GenericGenerator;

/**
 * UUID主键父类
 * 
 * @author vincent
 *
 */
@MappedSuperclass
@SuppressWarnings("serial")
public class UniversallyUniqueIdentifier implements Serializable{
	
	protected String id;
	
	/**
	 * 获取主键ID
	 * 
	 * @return String
	 */
	@Id
    @GeneratedValue(generator="system-uuid")
	@Column(length = 32, nullable = false,unique=true)  
    @GenericGenerator(name="system-uuid", strategy = "uuid")
	public String getId() {
		if (StringUtils.isEmpty(id)) {
			return null;
		}
		return this.id;
	}

	/**
	 * 设置主键ID
	 * 
	 * @param id 主键id值
	 */
	public void setId(String id) {
		if (StringUtils.isEmpty(id)) {
			this.id = null;
		} else {
			this.id = id;
		}
		
	}

}
