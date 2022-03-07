package com.lijunjie.tmall.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lijunjie.tmall.bean.Admin;
import com.lijunjie.tmall.bean.User;
import com.lijunjie.tmall.bean.UserExample;

@Repository
public interface UserMapper {

	public User checkUserName(String username);

	public Integer userRegister(User user);

	public User queryUserByUserNameAndPassword(User user);
	
	public Admin queryAdmin(Admin admin);
	public Integer updateUser(User user);
	/**
	 * 验证修改密码的邮箱，查询出用户
	 * @param email
	 * @return
	 */
	public User quertUserByEmail(String email);

	// 后台
	public User queryUserByUid(Integer id);

	int deleteByPrimaryKey(Integer id);

	int insert(User record);

	int insertSelective(User record);

	List<User> selectByExample(UserExample example);

	User selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);
}
