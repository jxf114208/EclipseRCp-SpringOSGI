/**
 * 
 */
package com.norcp.example.module.f.service.impl;

import java.io.Serializable;
import java.util.List;

import com.norcp.example.module.f.dao.api.IUserDao;
import com.norcp.example.module.f.domain.Group;
import com.norcp.example.module.f.service.api.IUserService;

/**
 * @author jxf
 *
 */
public class UserServiceImpl implements IUserService {
	
	private IUserDao userDao;

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	/* (non-Javadoc)
	 * @see com.norcp.example.module.f.service.api.IUserService#queryUsers()
	 */
	public List<Group> queryUsers() {
		return userDao.query();
	}

	/* (non-Javadoc)
	 * @see com.norcp.example.module.f.service.api.IUserService#createUser(com.norcp.example.module.f.domain.User)
	 */
	public void createUser(Group user) {
		userDao.create(user);
	}

	/* (non-Javadoc)
	 * @see com.norcp.example.module.f.service.api.IUserService#readUser(java.io.Serializable)
	 */
	public Group readUser(Serializable id) {
		return userDao.read(id);
	}

	/* (non-Javadoc)
	 * @see com.norcp.example.module.f.service.api.IUserService#updateUser(com.norcp.example.module.f.domain.User)
	 */
	public void updateUser(Group user) {
		this.userDao.update(user);
	}

	/* (non-Javadoc)
	 * @see com.norcp.example.module.f.service.api.IUserService#deleteUser(com.norcp.example.module.f.domain.User)
	 */
	public void deleteUser(Group user) {
		this.userDao.delete(user);
	}

}
