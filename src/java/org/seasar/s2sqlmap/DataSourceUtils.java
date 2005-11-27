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
 * DataSourceUtils��DataSource������SqlMap
 * ���痘�p����镔���𔲐�����Spring Framework����̈ڐA�łł��B 
 * @author $Author: gwatsman $
 * @version $Revision:$
 */
public abstract class DataSourceUtils
{

	private static final Log logger = LogFactory.getLog(DataSourceUtils.class);

	/**
	 * DataSource����R�l�N�V�������擾���܂��B
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
     * �K�v�ȏꍇ�͗^����ꂽConnection����܂��B
     * @param con �ΏۂƂȂ�Connection�Bnull�ł���ꍇ�͌Ăяo���͖����ƂȂ�܂��B
     * @param dataSource Connection�𐶐�����DataSource�B
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
     * �^����ꂽDataSource����܂��B
     * @param con �ΏۂƂȂ�Connection�Bnull�ł���ꍇ�͌Ăяo���͖����ƂȂ�܂��B
     * @param dataSource Connection�𐶐�����DataSource�B
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
