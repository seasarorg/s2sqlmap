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

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import com.ibatis.db.sqlmap.SqlMap;
import com.ibatis.db.sqlmap.XmlSqlMapBuilder;
 
/**
 * S2SqlMapConfigÇÕSqlMapConfigÇÃSpring FrameworkÇÃseasarà⁄êAî≈Ç≈Ç∑ÅB
 *
 * @author $Author: gwatsman $
 * @version $Revision:$
 * @see S2SqlMapTemplate#setSqlMap
 */
public class S2SqlMapConfig implements SqlMapConfig{

	private String configLocation;

	private Properties sqlMapProperties;

	private SqlMap sqlMap;
 
	public void setConfigLocation(String configLocation) {
		this.configLocation = configLocation;
	}

	public void setSqlMapProperties(Properties sqlMapProperties) {
		this.sqlMapProperties = sqlMapProperties;
	}

	public void init() throws IOException 
    {
		if (this.configLocation == null) {
			throw new IllegalArgumentException("configLocation is required");
		}
 
		// build the SqlMap
		InputStream is = ResourceUtils.getInputStream(this.configLocation);
		this.sqlMap = (this.sqlMapProperties != null) ?
				XmlSqlMapBuilder.buildSqlMap(new InputStreamReader(is), this.sqlMapProperties) :
				XmlSqlMapBuilder.buildSqlMap(new InputStreamReader(is));
	}

    public SqlMap getSqlMap(){
        return this.sqlMap;
    }

	public Object getObject() {
		return this.sqlMap;
	}
}
