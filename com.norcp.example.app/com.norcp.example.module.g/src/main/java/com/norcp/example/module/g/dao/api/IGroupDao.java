/**
 * 
 */
package com.norcp.example.module.g.dao.api;

import java.io.Serializable;
import java.util.List;

import com.norcp.example.module.g.domain.Group;

/**
 * @author jxf
 *
 */
public interface IGroupDao {
	/**
	 * @return
	 */
	List<Group> query();
	/**
	 * 创建用户对象
	 * @param group
	 */
	void create(Group group);
	/**
	 * 读取用户对象
	 * @param id
	 * @return
	 */
	Group read(Serializable id);
	/**
	 * 更新用户对象
	 * @param group
	 */
	void update(Group group);
	/**
	 * 删除用户对象
	 * @param group
	 */
	void delete(Group group);
}
