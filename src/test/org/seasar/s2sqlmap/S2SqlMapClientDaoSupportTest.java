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

import java.util.Date;

import junit.framework.TestCase;

import org.seasar.framework.container.S2Container;
import org.seasar.framework.container.factory.S2ContainerFactory;

/**
 * @author $Author: gwatsman $
 * @version $Revision:$
 */
public class S2SqlMapClientDaoSupportTest extends TestCase
{
    private static String PATH = "s2sqlmap2.dicon";
    
    public static final String DAO = "dao";

    public void testSqlMapClientDaoSupport()
    throws Exception{
        S2Container container = S2ContainerFactory.create(PATH);
        S2SqlMapClientTestDao dao = 
            (S2SqlMapClientTestDao) container.getComponent(DAO);
        TestModel test = new TestModel();
        TestModel ret;
        
        test.setHoge(1);
        test.setFoo("foo");
        test.setBar(new Date());
        
        dao.tuncate();
        dao.insert(test);
        
        ret = dao.find(1);
        
        assertEquals(ret.getHoge(),test.getHoge());
        assertEquals(ret.getFoo(),ret.getFoo());
        assertEquals(ret.getBar(),ret.getBar());
    }
}
