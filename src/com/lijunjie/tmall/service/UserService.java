package com.lijunjie.tmall.service;

import java.util.List;

import com.lijunjie.tmall.bean.Admin;
import com.lijunjie.tmall.bean.User;

public interface UserService {
	public User checkUserName(String username);

	public Integer userRegister(User user);

	public User queryUserByUserNameAndPassword(User user);
	public User queryUserByUid(Integer id);
	public Admin queryAdmin(Admin admin);
	public User quertUserByEmail(String email);
	
	public Integer updateUser(User user);

	// 后台
	void add(User c);

	void delete(int id);

	void update(User u);

	User get(int id);

	List list();
}
