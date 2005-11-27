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

import org.seasar.s2sqlmap.support.S2SqlMapDaoSupport;

/**
 * @author $Author: gwatsman $
 * @version $Revision:$
 */
public class S2SqlMapTestDao extends S2SqlMapDaoSupport
{
    public void insert(TestModel test){
        getSqlMapTemplate().executeUpdate("insertTest",
                test);
    }
    
    public TestModel find(int key){
        return (TestModel)getSqlMapTemplate().executeQueryForObject(
                "findTest",
                new Integer( key ));
    }
    
    public void truncate(){
        getSqlMapTemplate().executeUpdate("truncate", null);
    }
}
