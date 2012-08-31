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
package com.example.forum;

import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.seasar.framework.container.S2Container;
import org.seasar.framework.container.factory.S2ContainerFactory;

/**
 * @author $Author: gwatsman $
 * @version $Revision:$
 */
public class ComponentConfigurer
{
    public static final Log log = LogFactory.getLog(ComponentConfigurer.class);

    private static S2Container container;

    private static String PATH = "s2sqlmap.dicon";
    
    public static synchronized Object
    getComponent(ServletContext application,
            String componentName)
    {
        if (null == container){
            container = S2ContainerFactory.create(PATH);
        }
        
        return container.getComponent(componentName);
    }
}