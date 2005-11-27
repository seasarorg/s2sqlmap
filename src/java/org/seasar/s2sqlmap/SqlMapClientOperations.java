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

import java.util.List;
import java.util.Map;

 
import com.ibatis.common.util.PaginatedList;
import com.ibatis.sqlmap.client.event.RowHandler;

/**
 *　iBATIS SqlMapClientの標準的な操作を定義するインターフェースです。 
 * Spring FrameworkからSeasarへの移植版です。
 * @author $Author: gwatsman $
 * @version $Revision:$
 * @see S2SqlMapClientTemplate
 * @see com.ibatis.sqlmap.client.SqlMapClient
 * @see com.ibatis.sqlmap.client.SqlMapSession
 * @see com.ibatis.sqlmap.client.SqlMapExecutor
 */
public interface SqlMapClientOperations
{
    Object queryForObject(String statementName, Object parameterObject);
 
    Object queryForObject(String statementName, Object parameterObject,
            Object resultObject);
 
    List queryForList(String statementName, Object parameterObject);

 
    List queryForList(String statementName, Object parameterObject,
            int skipResults, int maxResults);
 
    void queryWithRowHandler(String statementName, Object parameterObject,
            RowHandler rowHandler);
 
    PaginatedList queryForPaginatedList(String statementName,
            Object parameterObject, int pageSize);
 
    Map queryForMap(String statementName, Object parameterObject,
            String keyProperty);
 
    Map queryForMap(String statementName, Object parameterObject,
            String keyProperty, String valueProperty);
 
    Object insert(String statementName, Object parameterObject);
 
    int update(String statementName, Object parameterObject);
 
    int delete(String statementName, Object parameterObject);
 
    void update(String statementName, Object parameterObject,
            int requiredRowsAffected);
 
    void delete(String statementName, Object parameterObject,
            int requiredRowsAffected);

}