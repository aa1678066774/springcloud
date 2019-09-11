package com.tww.user.entity;

import java.io.Serializable;
import java.util.Date;

/**
* 
*/
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 出生年月日
	 */
	private Date birthday;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 自增主键ID
	 */
	private Long id;
	/**
	 * 手机号
	 */
	private String mobile;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 性别（0 男 1 女）
	 */
	private Integer sex;
	
	public void setBirthday(Date birthday){
		this.birthday=birthday;
	}
	public Date getBirthday(){
		return this.birthday;
	}
	
	public void setCreateTime(Date createTime){
		this.createTime=createTime;
	}
	public Date getCreateTime(){
		return this.createTime;
	}
	
	public void setId(Long id){
		this.id=id;
	}
	public Long getId(){
		return this.id;
	}
	
	public void setMobile(String mobile){
		this.mobile=mobile;
	}
	public String getMobile(){
		return this.mobile;
	}
	
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return this.name;
	}
	
	public void setSex(Integer sex){
		this.sex=sex;
	}
	public Integer getSex(){
		return this.sex;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("User[");
		sb.append("birthday=");
		sb.append(birthday);
		sb.append(",createTime=");
		sb.append(createTime);
		sb.append(",id=");
		sb.append(id);
		sb.append(",mobile=");
		sb.append(mobile);
		sb.append(",name=");
		sb.append(name);
		sb.append(",sex=");
		sb.append(sex);
		sb.append("]");
		return sb.toString();
	}
}
