/**
 * 
 */
package com.norcp.example.module.f.dao.api;

import java.io.Serializable;
import java.util.List;

import com.norcp.example.module.f.domain.Group;

/**
 * @author jxf
 *
 */
public interface IUserDao {
	/**
	 * @return
	 */
	List<Group> query();
	/**
	 * 创建用户对象
	 * @param user
	 */
	void create(Group user);
	/**
	 * 读取用户对象
	 * @param id
	 * @return
	 */
	Group read(Serializable id);
	/**
	 * 更新用户对象
	 * @param user
	 */
	void update(Group user);
	/**
	 * 删除用户对象
	 * @param user
	 */
	void delete(Group user);
}
