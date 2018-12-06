package com.copy.common.base;


import com.copy.common.handler.QueryHandler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @Author: zwb
 * @Date: 2018/12/6 11:28
 *
 * DAO 基类
 * Base DAO
 * @param <E>
 *
 */
public abstract class BaseDao<E> {
	protected final Log log = LogFactory.getLog(getClass());

	/**
	 * 分面名称搜索前缀
	 *
	 * Facet name suffix
	 */
	public final static String FACET_NAME_SUFFIX = "FacetRequest";
	/**
	 * 倒叙
	 *
	 * order type desc
	 */
	public final static String ORDER_TYPE_DESC = "ase";
	/**
	 * 查询处理器
	 *
	 * @param hql
	 *
	 */
	public static QueryHandler getQueryHandler(String hql) {
		return null;
	}

}
