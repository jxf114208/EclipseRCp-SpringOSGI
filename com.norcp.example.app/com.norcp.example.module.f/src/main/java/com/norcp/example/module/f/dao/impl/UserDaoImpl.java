/**
 * 
 */
package com.norcp.example.module.f.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.norcp.example.module.f.dao.api.IUserDao;
import com.norcp.example.module.f.domain.Group;

/**
 * @author jxf
 *
 */
public class UserDaoImpl implements IUserDao {

	/* (non-Javadoc)
	 * @see com.norcp.example.module.f.dao.api.IUserDao#query()
	 */
	public List<Group> query() {
		List<Group> users = new ArrayList<Group>();
		Group user1 = new Group();
		user1.setName("Eclipse RCP user");
		Group user2 = new Group();
		user2.setName("Eclipse OSGI user");
		users.add(user1);
		users.add(user2);
		return users;
	}

	/* (non-Javadoc)
	 * @see com.norcp.example.module.f.dao.api.IUserDao#create(com.norcp.example.module.f.domain.User)
	 */
	public void create(Group user) {
		user.setName("spring");
		System.out.println("create user");
	}

	/* (non-Javadoc)
	 * @see com.norcp.example.module.f.dao.api.IUserDao#read(java.io.Serializable)
	 */
	public Group read(Serializable id) {
		Group user = new Group();
		user.setName("spring");
		System.out.println("read user");
		return user;
	}

	/* (non-Javadoc)
	 * @see com.norcp.example.module.f.dao.api.IUserDao#update(com.norcp.example.module.f.domain.User)
	 */
	public void update(Group user) {
		user.setName("new spring");
		System.out.println("update user");
	}

	/* (non-Javadoc)
	 * @see com.norcp.example.module.f.dao.api.IUserDao#delete(com.norcp.example.module.f.domain.User)
	 */
	public void delete(Group user) {
		System.out.println("delete user");
	}

}
