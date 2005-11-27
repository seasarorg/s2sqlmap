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

import com.ibatis.db.sqlmap.RowHandler;

/**
 * iBATIS SqlMapの標準的な操作を定義するインターフェースです。S2SqlMapTemplateによって
 * 実装されます。Spring FrameworkからSeasarへの移植版です。
 * @author $Author: gwatsman $
 * @version $Revision:$
 * @see S2SqlMapTemplate
 * @see com.ibatis.db.sqlmap.MappedStatement
 */
public interface SqlMapOperations
{
    Object executeQueryForObject(String statementName, Object parameterObject);

    Object executeQueryForObject(String statementName, Object parameterObject,
            Object resultObject);

    List executeQueryForList(String statementName, Object parameterObject);

    List executeQueryForList(String statementName, Object parameterObject,
            int skipResults, int maxResults);

    Map executeQueryForMap(String statementName, Object parameterObject,
            String keyProperty);

    Map executeQueryForMap(String statementName, Object parameterObject,
            String keyProperty, String valueProperty);

    void executeQueryWithRowHandler(String statementName,
            Object parameterObject, RowHandler rowHandler);

    int executeUpdate(String statementName, Object parameterObject);
}