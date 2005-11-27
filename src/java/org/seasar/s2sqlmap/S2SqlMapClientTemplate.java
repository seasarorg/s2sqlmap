/*
 * Copyright 2002-2005 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.seasar.s2sqlmap;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.seasar.framework.exception.SQLRuntimeException;

import com.ibatis.common.util.PaginatedList;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapExecutor;
import com.ibatis.sqlmap.client.SqlMapSession;
import com.ibatis.sqlmap.client.event.RowHandler;
import com.ibatis.sqlmap.engine.impl.ExtendedSqlMapClient;

/**
 * Spring Frameworkの移植版です。
 * iBATIS SQL Maps APIにSqlMapClient経由でアクセスする手段を簡易化するヘルパークラスです。
 * <pre>
 * getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
 * 	 public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
 * 		 executor.startBatch();
 * 		 executor.update("insertSomething", "myParamValue");
 * 		 executor.update("insertSomethingElse", "myOtherParamValue");
 * 		 executor.executeBatch();
 * 		 return null;
 * 	 }
 * });</pre>
 *
 * @author $Author: gwatsman $
 * @version $Revision:$
 * @see #execute
 * @see #setSqlMapClient
 * @see #setDataSource
 * @see S2SqlMapClientConfig#setDataSource
 * @see com.ibatis.sqlmap.client.SqlMapClient#getDataSource
 * @see com.ibatis.sqlmap.client.SqlMapSession
 * @see com.ibatis.sqlmap.client.SqlMapExecutor
 */
public class S2SqlMapClientTemplate implements SqlMapClientOperations {

	private SqlMapClient sqlMapClient;

    private DataSource dataSource;

	public S2SqlMapClientTemplate() {
	}

	public S2SqlMapClientTemplate(SqlMapClient sqlMapClient) {
		setSqlMapClient(sqlMapClient);
		init();
	}
    
    public void setDataSource(DataSource dataSource){
        this.dataSource=dataSource;
    }

	public S2SqlMapClientTemplate(DataSource dataSource, SqlMapClient sqlMapClient) {
		setDataSource(dataSource);
		setSqlMapClient(sqlMapClient);
		init();
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public DataSource getDataSource() {
		return (dataSource != null ? dataSource : this.sqlMapClient.getDataSource());
	}

	public void init() {
		if (this.sqlMapClient == null) {
			throw new IllegalArgumentException("sqlMapClient is required");
		}
	}

	public Object execute(SqlMapClientCallback action)  {
		DataSource dataSource = getDataSource();

		if (dataSource == this.sqlMapClient.getDataSource()) {
			try {
				return action.doInSqlMapClient(this.sqlMapClient);
			}
			catch (SQLException ex) {
                throw new SQLRuntimeException(ex);
			}
		}
		else {
			SqlMapSession session = this.sqlMapClient.openSession();
			try {
				Connection con = DataSourceUtils.getConnection(getDataSource());
				try {
					session.setUserConnection(con);
					return action.doInSqlMapClient(session);
				}
				catch (SQLException ex) {
					throw new SQLRuntimeException(ex);
				}
				finally {
					DataSourceUtils.closeConnectionIfNecessary(con, getDataSource());
				}
			}
			finally {
				session.close();
			}
		}
	}

	public List executeWithListResult(SqlMapClientCallback action)  {
		return (List) execute(action);
	}

	public Map executeWithMapResult(SqlMapClientCallback action)  {
		return (Map) execute(action);
	}
	

	public Object queryForObject(final String statementName, final Object parameterObject)
			 {
		return execute(new SqlMapClientCallback() {
			public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
				return executor.queryForObject(statementName, parameterObject);
			}
		});
	}

	public Object queryForObject(
			final String statementName, final Object parameterObject, final Object resultObject)
			 {
		return execute(new SqlMapClientCallback() {
			public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
				return executor.queryForObject(statementName, parameterObject, resultObject);
			}
		});
	}

	public List queryForList(final String statementName, final Object parameterObject)
			 {
		return executeWithListResult(new SqlMapClientCallback() {
			public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
				return executor.queryForList(statementName, parameterObject);
			}
		});
	}

	public List queryForList(
			final String statementName, final Object parameterObject, final int skipResults, final int maxResults)
			 {
		return executeWithListResult(new SqlMapClientCallback() {
			public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
				return executor.queryForList(statementName, parameterObject, skipResults, maxResults);
			}
		});
	}

	public void queryWithRowHandler(
			final String statementName, final Object parameterObject, final RowHandler rowHandler)
			 {
		execute(new SqlMapClientCallback() {
			public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
				executor.queryWithRowHandler(statementName, parameterObject, rowHandler);
				return null;
			}
		});
	}

    //InvalidDataAccessApiUsageException to UnsupportedOperationException
	public PaginatedList queryForPaginatedList(
			final String statementName, final Object parameterObject, final int pageSize)
			 {

		// throw exception if lazy loading will not work
		if (this.sqlMapClient instanceof ExtendedSqlMapClient &&
				((ExtendedSqlMapClient) this.sqlMapClient).getDelegate().getTxManager() == null) {
			throw new UnsupportedOperationException(
					"SqlMapClient needs to have DataSource to allow for lazy loading" +
					" - specify SqlMapClientFactoryBean's 'dataSource' property");
		}

		return (PaginatedList) execute(
                new SqlMapClientCallback() {
			public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
				return executor.queryForPaginatedList(statementName, parameterObject, pageSize);
			}
		});
	}

	public Map queryForMap(
			final String statementName, final Object parameterObject, final String keyProperty)
			 {
		return executeWithMapResult(new SqlMapClientCallback() {
			public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
				return executor.queryForMap(statementName, parameterObject, keyProperty);
			}
		});
	}

	public Map queryForMap(
			final String statementName, final Object parameterObject, final String keyProperty, final String valueProperty)
			 {
		return executeWithMapResult(new SqlMapClientCallback() {
			public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
				return executor.queryForMap(statementName, parameterObject, keyProperty, valueProperty);
			}
		});
	}

	public Object insert(final String statementName, final Object parameterObject)
			 {
		return execute(new SqlMapClientCallback() {
			public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
				return executor.insert(statementName, parameterObject);
			}
		});
	}

	public int update(final String statementName, final Object parameterObject)
			 {
		Integer result = (Integer) execute(new SqlMapClientCallback() {
			public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
				return new Integer(executor.update(statementName, parameterObject));
			}
		});
		return result.intValue();
	}

	public int delete(final String statementName, final Object parameterObject)
	{
		Integer result = (Integer) execute(new SqlMapClientCallback() {
			public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
				return new Integer(executor.delete(statementName, parameterObject));
			}
		});
		return result.intValue();
	}

	public void update(String statementName, Object parameterObject, int requiredRowsAffected)
			 {
		int actualRowsAffected = update(statementName, parameterObject);
		if (actualRowsAffected != requiredRowsAffected) {
			throw new org.seasar.s2sqlmap.exception.port.JdbcUpdateAffectedIncorrectNumberOfRowsException(
					statementName, requiredRowsAffected, actualRowsAffected);
		}
	}

	public void delete(String statementName, Object parameterObject, int requiredRowsAffected)
			 {
		int actualRowsAffected = delete(statementName, parameterObject);
		if (actualRowsAffected != requiredRowsAffected) {
			throw new org.seasar.s2sqlmap.exception.port.JdbcUpdateAffectedIncorrectNumberOfRowsException(
					statementName, requiredRowsAffected, actualRowsAffected);
		}
	}
}
