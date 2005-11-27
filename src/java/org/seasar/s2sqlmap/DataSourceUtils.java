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

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.seasar.framework.exception.SQLRuntimeException;
 
/**
 * DataSourceUtilsはDataSource処理のSqlMap
 * から利用される部分を抜粋したSpring Frameworkからの移植版です。 
 * @author $Author: gwatsman $
 * @version $Revision:$
 */
public abstract class DataSourceUtils
{

	private static final Log logger = LogFactory.getLog(DataSourceUtils.class);

	/**
	 * DataSourceからコネクションを取得します。
	 */
	public static Connection getConnection(DataSource dataSource){
            Connection con = null;
    		try {
                con = dataSource.getConnection();
    		}
    		catch (SQLException ex) {
    			throw new SQLRuntimeException(ex);
    		}
        return con;
	}

    /**
     * 必要な場合は与えられたConnectionを閉じます。
     * @param con 対象となるConnection。nullである場合は呼び出しは無効となります。
     * @param dataSource Connectionを生成したDataSource。
     */
    public static void closeConnectionIfNecessary(Connection con, DataSource dataSource) {
        try {
            doCloseConnectionIfNecessary(con, dataSource);
        }
        catch (SQLException ex) {
            logger.error("Could not close JDBC connection", ex);
        }
    }

    /**
     * 与えられたDataSourceを閉じます。
     * @param con 対象となるConnection。nullである場合は呼び出しは無効となります。
     * @param dataSource Connectionを生成したDataSource。
     * @throws SQLException if thrown by JDBC methods
     */
    public static void doCloseConnectionIfNecessary(Connection con, DataSource dataSource) throws SQLException {
        if (con == null) {
            return;
        }
        logger.debug("Closing JDBC connection");
        con.close();
    }
}
