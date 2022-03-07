package com.lijunjie.tmall.bean;

import java.io.Serializable;

/**
 * 
 * @author 李俊杰
 *
 */
public class User implements Serializable {
	private Integer id;
	private String username;// 用户名
	private String password;// 用户密码
	private String name;// 真实姓名
	private Integer sex;//性别
	private String address;// 地址
	private Integer post;// 邮编
	private String phone;// 电话
	private String email;// 邮箱
	private String createDate; // 注册日期
	private String updateDate; // 更新日期
	private Integer flag;// 判断解除和锁定依据

	public User() {
		super();
	}

	
	public User(Integer id, String username, String password, String name, Integer sex, String address, Integer post,
			String phone, String email, String createDate, String updateDate, Integer flag) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.address = address;
		this.post = post;
		this.phone = phone;
		this.email = email;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.flag = flag;
	}


	public Integer getSex() {
		return sex;
	}


	public void setSex(Integer sex) {
		this.sex = sex;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getPost() {
		return post;
	}

	public void setPost(Integer post) {
		this.post = post;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name + ", sex="
				+ sex + ", address=" + address + ", post=" + post + ", phone=" + phone + ", email=" + email
				+ ", createDate=" + createDate + ", updateDate=" + updateDate + ", flag=" + flag + "]";
	}

	
}
