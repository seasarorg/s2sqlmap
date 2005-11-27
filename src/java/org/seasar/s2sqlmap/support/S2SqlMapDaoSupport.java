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
import org.seasar.s2sqlmap.S2SqlMapTemplate;
import org.seasar.s2sqlmap.SqlMapConfig;

import com.ibatis.db.sqlmap.SqlMap;

/**
 * iBATIS SqlMapのデータアクセスオブジェクト(DAO)の便利なスーパークラスです。
 * Spring FrameworkからSeasarへの移植版です。
 * @author $Author: gwatsman $
 * @version $Revision:$
 * @see #setSqlMap
 * @see #setSqlMapTemplate
 */
public abstract class S2SqlMapDaoSupport{

	protected final Log logger = LogFactory.getLog(getClass());

	private S2SqlMapTemplate sqlMapTemplate = new S2SqlMapTemplate();

	private boolean externalTemplate;

	public final void setDataSource(DataSource dataSource) {
	  this.sqlMapTemplate.setDataSource(dataSource);
	}

	public final DataSource getDataSource() {
		return (this.sqlMapTemplate != null ? this.sqlMapTemplate.getDataSource() : null);
	}

	public final void setSqlMap(SqlMap sqlMap) {
		this.sqlMapTemplate.setSqlMap(sqlMap);
	}

    public final void setSqlMapConfig(SqlMapConfig sqlMap){
        this.sqlMapTemplate.setSqlMap(sqlMap.getSqlMap());
    }

	public final SqlMap getSqlMap() {
		return this.sqlMapTemplate.getSqlMap();
	}

	public final void setSqlMapTemplate(S2SqlMapTemplate sqlMapTemplate) {
		if (sqlMapTemplate == null) {
			throw new IllegalArgumentException("Cannot set sqlMapTemplate to null");
		}
		this.sqlMapTemplate = sqlMapTemplate;
		this.externalTemplate = true;
	}

	public final S2SqlMapTemplate getSqlMapTemplate() {
	  return sqlMapTemplate;
	}
}
