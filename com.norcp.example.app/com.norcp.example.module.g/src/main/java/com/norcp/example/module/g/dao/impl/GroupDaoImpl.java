/**
 * 
 */
package com.norcp.example.module.g.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.norcp.example.module.g.dao.api.IGroupDao;
import com.norcp.example.module.g.domain.Group;

/**
 * @author jxf
 *
 */
public class GroupDaoImpl implements IGroupDao {

	/* (non-Javadoc)
	 * @see com.norcp.example.module.f.dao.api.IGroupDao#query()
	 */
	public List<Group> query() {
		List<Group> groups = new ArrayList<Group>();
		Group group1 = new Group();
		group1.setName("Eclipse RCP group");
		Group group2 = new Group();
		group2.setName("Eclipse OSGI group");
		groups.add(group1);
		groups.add(group2);
		return groups;
	}

	/* (non-Javadoc)
	 * @see com.norcp.example.module.f.dao.api.IGroupDao#create(com.norcp.example.module.f.domain.Group)
	 */
	public void create(Group group) {
		group.setName("spring");
		System.out.println("create group");
	}

	/* (non-Javadoc)
	 * @see com.norcp.example.module.f.dao.api.IGroupDao#read(java.io.Serializable)
	 */
	public Group read(Serializable id) {
		Group group = new Group();
		group.setName("spring");
		System.out.println("read group");
		return group;
	}

	/* (non-Javadoc)
	 * @see com.norcp.example.module.f.dao.api.IGroupDao#update(com.norcp.example.module.f.domain.Group)
	 */
	public void update(Group group) {
		group.setName("new spring");
		System.out.println("update group");
	}

	/* (non-Javadoc)
	 * @see com.norcp.example.module.f.dao.api.IGroupDao#delete(com.norcp.example.module.f.domain.Group)
	 */
	public void delete(Group group) {
		System.out.println("delete group");
	}

}
