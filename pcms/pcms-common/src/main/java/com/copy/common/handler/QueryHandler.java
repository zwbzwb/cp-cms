package com.copy.common.handler;

import com.copy.common.constants.Constants;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Map;

/**
 * @Author: zwb
 * @Date: 2018/12/6 15:48
 * QueryHandler
 */
public class QueryHandler {
	/**
	 * count
	 */
	public static final String COUNT_SQL = "select count(*) ";
	/**
	 * from
	 */
	public static final String KEYWORD_FROM = " from ";
	/**
	 * 排序
	 * order by
	 */
	public static final String KEYWORD_ORDER = " order by ";
	/**
	 *分组
	 * group by
	 */
	public static final String KEYWORD_GROUP = " group by ";

	boolean whereFlag = true;
	boolean orderFlag = true;
	boolean groupFlag = true;
	private StringBuilder sqlBuilder;
	private Map<String,Object> map;
	private Map<String,Object[]> arrayMap;
	private Integer firstResult;
	private Integer maxResults;
	private Boolean cacheable;

	/**
	 * @param sql
	 */
	public QueryHandler(String sql){
		this.sqlBuilder = new StringBuilder(Constants.BLANK_SPACE);
		sqlBuilder.append(sql);
	}
	public QueryHandler(){
		this.sqlBuilder = new StringBuilder();
	}

	/**
	 * @param session
	 * @return query
	 */
	public Query<?> getQuery (Session session){
		return getQuery(session,getSql());
	}
	/**
	 * @param condition
	 * @return query handler
	 *
	 */
	public QueryHandler condition(String condition){
		if(whereFlag){
			whereFlag = false;
			sqlBuilder.append(" where ");
		}else{
			sqlBuilder.append(" and ");
		}
		sqlBuilder.append(condition);
		return this;
	}

	/**
	 *
	 * @param sqlString
	 * @return query handler
	 */
	public QueryHandler order (String sqlString){
		if(orderFlag){
			orderFlag = false;
			append(KEYWORD_ORDER);
		}else{
			sqlBuilder.append(Constants.COMMA_DELINITED);
		}
		sqlBuilder.append(sqlBuilder);
		return this;
	}
	/**
	 * @param sqlString
	 * @return query handler
	 */
	public QueryHandler append(String sqlString){
		sqlBuilder.append(Constants.BLANK_SPACE);
		sqlBuilder.append(sqlString);
		return  this;
	}

	/**
	 *
	 * @param sqlString
	 * @return QueryHandler
	 */
	public QueryHandler group (String sqlString){
		if(groupFlag ){
			groupFlag = false;
			sqlBuilder.append( KEYWORD_GROUP);
		}else{
			sqlBuilder.append(Constants.COMMA_DELINITED);
		}
		sqlBuilder.append(sqlString);
		return this;
	}
	//public
	/**
	 * @param session
	 * @param sql
	 * @return query
	 *
	 */
	public Query<?> getQuery (Session session,String sql){
		Query<?> query = session.createQuery(sql);
		if(null != map){
			for(String key:map.keySet()){
				query.setParameter(key,map.get(key));
			}
		}
		if(null != arrayMap){
			for(String key : arrayMap.keySet()){
				query.setParameter(key,arrayMap.get(key));
			}
		}
		if(null != firstResult){
			query.setFirstResult(firstResult);
		}
		if(null != maxResults){
			query.setMaxResults(maxResults);
		}
		if(null != cacheable){
			query.setCacheable(cacheable);
		}else {
			query.setCacheable(true);
		}
		return query;
	}
	public String getSql(){
		return sqlBuilder.toString();
	}
	public String getCountSql(){
		String sql = getSql();
		sql = sql.substring(sql.toLowerCase().indexOf(KEYWORD_FROM));
		int orderIndex = sql.toLowerCase().indexOf(KEYWORD_ORDER);
		if(-1 != orderIndex){
			sql = sql.substring(0,orderIndex);
		}
		return COUNT_SQL + sql ;
	}
}
