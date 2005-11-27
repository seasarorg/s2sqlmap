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

import com.ibatis.db.sqlmap.MappedStatement;
import com.ibatis.db.sqlmap.RowHandler;
import com.ibatis.db.sqlmap.SqlMap;

/**
 * Spring FrameworkÇ©ÇÁSeasarÇ÷ÇÃà⁄êAî≈Ç≈Ç∑ÅB
 *
 * @author $Author: gwatsman $
 * @version $Revision:$
 * @see #execute
 * @see #setSqlMap
 * @see #setDataSource
 * @see com.ibatis.db.sqlmap.MappedStatement
 */
public class S2SqlMapTemplate {

	private SqlMap sqlMap;
    
    private DataSource dataSource;

	public S2SqlMapTemplate() {
        
	}

	public S2SqlMapTemplate(DataSource dataSource, SqlMap sqlMap) {
		setSqlMap(sqlMap);
		init();
	}
    
    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
    }
    
    public DataSource getDataSource(){
        return this.dataSource;
    }

	public void setSqlMap(SqlMap sqlMap) {
		this.sqlMap = sqlMap;
	}

	public SqlMap getSqlMap() {
		return sqlMap;
	}

	public void init() {
		if (this.sqlMap == null) {
			throw new IllegalArgumentException("sqlMap is required");
		}
	}

	public Object execute(String statementName, SqlMapCallback action)  {
        MappedStatement stmt = this.sqlMap.getMappedStatement(statementName);
        Connection con = DataSourceUtils.getConnection(getDataSource());
        try {
            return action.doInMappedStatement(stmt, con);
        }
        catch (SQLException ex) {
            throw new SQLRuntimeException(ex);
        }
        finally {
            DataSourceUtils.closeConnectionIfNecessary(con, getDataSource());
        }
	}

	public List executeWithListResult(String statementName, SqlMapCallback action)
	     {
		return (List) execute(statementName, action);
	}

	public Map executeWithMapResult(String statementName, SqlMapCallback action)
	     {
		return (Map) execute(statementName, action);
	}

	public Object executeQueryForObject(String statementName, final Object parameterObject)
			 {
		return execute(statementName, new SqlMapCallback() {
			public Object doInMappedStatement(MappedStatement stmt, Connection con) throws SQLException {
				return stmt.executeQueryForObject(con, parameterObject);
			}
		});
	}

	public Object executeQueryForObject(
			String statementName, final Object parameterObject, final Object resultObject)
			 {
		return execute(statementName, new SqlMapCallback() {
			public Object doInMappedStatement(MappedStatement stmt, Connection con) throws SQLException {
				return stmt.executeQueryForObject(con, parameterObject, resultObject);
			}
		});
	}

	public List executeQueryForList(String statementName, final Object parameterObject)
			 {
		return executeWithListResult(statementName, new SqlMapCallback() {
			public Object doInMappedStatement(MappedStatement stmt, Connection con) throws SQLException {
				return stmt.executeQueryForList(con, parameterObject);
			}
		});
	}

	public List executeQueryForList(
			String statementName, final Object parameterObject, final int skipResults, final int maxResults)
			 {
		return executeWithListResult(statementName, new SqlMapCallback() {
			public Object doInMappedStatement(MappedStatement stmt, Connection con) throws SQLException {
				return stmt.executeQueryForList(con, parameterObject, skipResults, maxResults);
			}
		});
	}

	public Map executeQueryForMap(
			String statementName, final Object parameterObject, final String keyProperty)
			 {
		return executeWithMapResult(statementName, new SqlMapCallback() {
			public Object doInMappedStatement(MappedStatement stmt, Connection con) throws SQLException {
				return stmt.executeQueryForMap(con, parameterObject, keyProperty);
			}
		});
	}

	public Map executeQueryForMap(
			String statementName, final Object parameterObject, final String keyProperty, final String valueProperty)
			 {
		return executeWithMapResult(statementName, new SqlMapCallback() {
			public Object doInMappedStatement(MappedStatement stmt, Connection con) throws SQLException {
				return stmt.executeQueryForMap(con, parameterObject, keyProperty, valueProperty);
			}
		});
	}

	public void executeQueryWithRowHandler(
			String statementName, final Object parameterObject, final RowHandler rowHandler)
			 {
		execute(statementName, new SqlMapCallback() {
			public Object doInMappedStatement(MappedStatement stmt, Connection con) throws SQLException {
				stmt.executeQueryWithRowHandler(con, parameterObject, rowHandler);
				return null;
			}
		});
	}

	public int executeUpdate(String statementName, final Object parameterObject)
			 {
		Integer result = (Integer) execute(statementName, new SqlMapCallback() {
			public Object doInMappedStatement(MappedStatement stmt, Connection con) throws SQLException {
				return new Integer(stmt.executeUpdate(con, parameterObject));
			}
		});
		return result.intValue();
	}
}
