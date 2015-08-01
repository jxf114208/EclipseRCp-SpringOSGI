/**
 * 
 */
package com.norcp.example.hibernate;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author jxf
 *
 */
public class GenericHibernateDaoSupport<E> extends HibernateDaoSupport {
	/**
	 * Class<T>
	 */
	private final Class<E> clazz;
	
	/**
	 * 构造函数
	 * @param class Domain's class
	 */
	public GenericHibernateDaoSupport(Class<E> clazz) {
		this.clazz = clazz;
	}
	
	/**
	 * 创建实例
	 * @param e
	 */
	public void create(E e) {
		getHibernateTemplate().save(e);
	}
	
	/**
	 * 读取实例
	 * @param id
	 * @return
	 */
	public E read(Serializable id) {
		@SuppressWarnings("unchecked")
		E e = (E) getHibernateTemplate().get(clazz, id);
		return e;
	}
	
	/**
	 * 更新实例
	 * @param e
	 */
	public void update(E e) {
		getHibernateTemplate().update(e);
	}
	
	/**
	 * 删除实例
	 * @param e
	 */
	public void delete(E e) {
		getHibernateTemplate().delete(e);
	}
	
	/**
	 * 查询所有对象
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<E> query() {
		return getHibernateTemplate().loadAll(clazz);
	}
}
