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

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import javax.sql.DataSource;

import org.seasar.s2sqlmap.spring.lob.port.LobHandler;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.ibatis.sqlmap.engine.impl.ExtendedSqlMapClient;
import com.ibatis.sqlmap.engine.transaction.TransactionConfig;
import com.ibatis.sqlmap.engine.transaction.TransactionManager;
import com.ibatis.sqlmap.engine.transaction.external.ExternalTransactionConfig;

/**
 * S2SqlMapClientConfigÇÕëŒâûÇ∑ÇÈProxyBeanÇÃSpring FrameworkÇ©ÇÁÇÃà⁄êAî≈Ç≈Ç∑ÅB
 * @author $Author: gwatsman $
 * @version $Revision:$
 * @see #setConfigLocation
 * @see #setDataSource
 * @see S2SqlMapClientTemplate#setSqlMapClient
 * @see S2SqlMapClientTemplate#setDataSource
 */
public class S2SqlMapClientConfig implements SqlMapClientConfig  
{
	private static ThreadLocal configTimeLobHandlerHolder = new ThreadLocal();
 
	public static LobHandler getConfigTimeLobHandler() {
		return (LobHandler) configTimeLobHandlerHolder.get();
	}
 
	private String configLocation;

	private Properties sqlMapClientProperties;

	private DataSource dataSource;

	//private boolean useTransactionAwareDataSource = false;

	private Class transactionConfigClass = ExternalTransactionConfig.class;

	private Properties transactionConfigProperties;

	private LobHandler lobHandler;

	private SqlMapClient sqlMapClient;

	public S2SqlMapClientConfig() {
		this.transactionConfigProperties = new Properties();
		this.transactionConfigProperties.setProperty("SetAutoCommitAllowed", "false");
	}
 
	public void setConfigLocation(String configLocation) {
		this.configLocation = configLocation;
	}
 
	public void setSqlMapClientProperties(Properties sqlMapClientProperties) {
		this.sqlMapClientProperties = sqlMapClientProperties;
	}
 
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
 
	public void setUseTransactionAwareDataSource(boolean useTransactionAwareDataSource) {
		throw new UnsupportedOperationException();
        //this.useTransactionAwareDataSource = useTransactionAwareDataSource;
	}

	public void setTransactionConfigClass(Class transactionConfigClass) {
		if (transactionConfigClass == null || !TransactionConfig.class.isAssignableFrom(transactionConfigClass)) {
			throw new IllegalArgumentException("Invalid transactionConfigClass: does not implement " +
					"com.ibatis.sqlmap.engine.transaction.TransactionConfig");
		}
		this.transactionConfigClass = transactionConfigClass;
	}
 
	public void setTransactionConfigProperties(Properties transactionConfigProperties) {
		this.transactionConfigProperties = transactionConfigProperties;
	}
 
	public void setLobHandler(LobHandler lobHandler) {
		this.lobHandler = lobHandler;
	}

	public void init() throws Exception {
		if (this.configLocation == null) {
			throw new IllegalArgumentException("configLocation is required");
		}

		if (this.lobHandler != null) {
			configTimeLobHandlerHolder.set(this.lobHandler);
		}

		try {
			// Build the SqlMapClient.
			InputStream is = ResourceUtils.getInputStream(configLocation);
			this.sqlMapClient = (this.sqlMapClientProperties != null) ?
					SqlMapClientBuilder.buildSqlMapClient(
                            new InputStreamReader(is), this.sqlMapClientProperties) :
					SqlMapClientBuilder.buildSqlMapClient(
                            new InputStreamReader(is));
                            
			// Tell the SqlMapClient to use the given DataSource, if any.
			if (this.dataSource != null) {
				TransactionConfig transactionConfig = (TransactionConfig) this.transactionConfigClass.newInstance();
				DataSource dataSourceToUse = this.dataSource;
				transactionConfig.setDataSource(dataSourceToUse);
				transactionConfig.initialize(this.transactionConfigProperties);
				applyTransactionConfig(this.sqlMapClient, transactionConfig);
			}
		}

		finally {
			if (this.lobHandler != null) {
				// Reset LobHandler holder.
				configTimeLobHandlerHolder.set(null);
			}
		}
	}

	protected void applyTransactionConfig(SqlMapClient sqlMapClient, TransactionConfig transactionConfig) {
		if (!(this.sqlMapClient instanceof ExtendedSqlMapClient)) {
			throw new IllegalArgumentException(
					"Cannot set TransactionConfig with DataSource for SqlMapClient if not of type " +
					"ExtendedSqlMapClient: " + this.sqlMapClient);
		}
		ExtendedSqlMapClient extendedClient = (ExtendedSqlMapClient) this.sqlMapClient;
		transactionConfig.setMaximumConcurrentTransactions(extendedClient.getDelegate().getMaxTransactions());
		extendedClient.getDelegate().setTxManager(new TransactionManager(transactionConfig));
	}
    
    public SqlMapClient getSqlMapClient() {
        return this.sqlMapClient;
    }

	public Object getObject() {
		return this.sqlMapClient;
	}
}
