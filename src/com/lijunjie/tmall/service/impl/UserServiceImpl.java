package com.lijunjie.tmall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lijunjie.tmall.bean.Admin;
import com.lijunjie.tmall.bean.User;
import com.lijunjie.tmall.bean.UserExample;
import com.lijunjie.tmall.dao.UserMapper;
import com.lijunjie.tmall.service.UserService;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User checkUserName(String username) {
		// TODO Auto-generated method stub
		return userMapper.checkUserName(username);
	}
	
	public Integer userRegister(User user) {
		return userMapper.userRegister(user);
	}

	@Override
	public User queryUserByUserNameAndPassword(User user) {
		// TODO Auto-generated method stub
		return userMapper.queryUserByUserNameAndPassword(user);
	}
	
	
	
	//后台
	 @Override
	    public void add(User u) {
	        userMapper.insert(u);
	    }

	    @Override
	    public void delete(int id) {
	        userMapper.deleteByPrimaryKey(id);
	    }

	    @Override
	    public void update(User u) {
	        userMapper.updateByPrimaryKeySelective(u);
	    }

	    @Override
	    public User get(int id) {
	        return userMapper.selectByPrimaryKey(id);
	    }

	    @Override
	    public List list() {
	        UserExample example = new UserExample();
	        example.setOrderByClause("id desc");
	        return userMapper.selectByExample(example);
	    }

		@Override
		public User queryUserByUid(Integer id) {
			// TODO Auto-generated method stub
			return userMapper.queryUserByUid(id);
		}

		@Override
		public Admin queryAdmin(Admin admin) {
			// TODO Auto-generated method stub
			return userMapper.queryAdmin(admin);
		}

		@Override
		public User quertUserByEmail(String email) {
			// TODO Auto-generated method stub
			return userMapper.quertUserByEmail(email);
		}

		@Override
		public Integer updateUser(User user) {
			// TODO Auto-generated method stub
			return userMapper.updateUser(user);
		}

}
