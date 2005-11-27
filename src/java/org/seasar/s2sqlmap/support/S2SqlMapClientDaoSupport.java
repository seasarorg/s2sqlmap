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
package org.seasar.s2sqlmap.support;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.seasar.s2sqlmap.S2SqlMapClientTemplate;
import org.seasar.s2sqlmap.SqlMapClientConfig;

import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * iBATIS SqlMapClientのデータアクセスオブジェクト(DAO)の便利なスーパークラスです。
 * Spring FrameworkからSeasarへの移植版です。
 * @author $Author: gwatsman $
 * @version $Revision:$
 * @see #setSqlMapClient
 * @see #setSqlMapClientTemplate
 */
public abstract class S2SqlMapClientDaoSupport{
    
	protected final Log logger = LogFactory.getLog(getClass());

	private S2SqlMapClientTemplate 
    sqlMapClientTemplate = new S2SqlMapClientTemplate();

	private boolean externalTemplate = false;

	public final void setDataSource(DataSource dataSource) {
	  this.sqlMapClientTemplate.setDataSource(dataSource);
	}

	public final DataSource getDataSource() {
		return (this.sqlMapClientTemplate != null ? this.sqlMapClientTemplate.getDataSource() : null);
	}

	public final void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClientTemplate.setSqlMapClient(sqlMapClient);
	}

    public final void setSqlMapClientConfig(SqlMapClientConfig sqlMapClientConfig) {
        this.sqlMapClientTemplate.setSqlMapClient(sqlMapClientConfig.getSqlMapClient());
    }

	public final SqlMapClient getSqlMapClient() {
		return this.sqlMapClientTemplate.getSqlMapClient();
	}

	public final void setSqlMapClientTemplate(S2SqlMapClientTemplate sqlMapClientTemplate) {
		if (sqlMapClientTemplate == null) {
			throw new IllegalArgumentException("Cannot set sqlMapClientTemplate to null");
		}
		this.sqlMapClientTemplate = sqlMapClientTemplate;
		this.externalTemplate = true;
	}

	public final S2SqlMapClientTemplate getSqlMapClientTemplate() {
	  return sqlMapClientTemplate;
	}

	public final void init() throws Exception {
		if (!this.externalTemplate) {
			this.sqlMapClientTemplate.init();
		}
		initDao();
	}

	protected void initDao() throws Exception {
	}

}
