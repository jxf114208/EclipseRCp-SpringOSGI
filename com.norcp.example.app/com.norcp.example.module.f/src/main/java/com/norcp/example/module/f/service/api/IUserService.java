package com.norcp.example.module.f.service.api;

import java.io.Serializable;
import java.util.List;

import com.norcp.example.module.f.domain.Group;

/**
 * @author jxf
 *
 */
public interface IUserService {
	/**
	 * @return
	 */
	List<Group> queryUsers();
	/**
	 * 创建用户对象
	 * @param user
	 */
	void createUser(Group user);
	/**
	 * 读取用户对象
	 * @param id
	 * @return
	 */
	Group readUser(Serializable id);
	/**
	 * 更新用户对象
	 * @param user
	 */
	void updateUser(Group user);
	/**
	 * 删除用户对象
	 * @param user
	 */
	void deleteUser(Group user);
}
