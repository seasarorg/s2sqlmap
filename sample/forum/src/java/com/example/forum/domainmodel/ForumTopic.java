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
package com.example.forum.domainmodel;

/**
 * @author $Author: gwatsman $
 * @version $Revision:$
 */
public class ForumTopic
{
    private int index;

    private int category_index;

    private String title;

    /**
     * @return Returns the category_index.
     */
    public int getCategory_index()
    {
        return category_index;
    }

    /**
     * @param category_index The category_index to set.
     */
    public void setCategory_index(int category_index)
    {
        this.category_index = category_index;
    }

    /**
     * @return Returns the index.
     */
    public int getIndex()
    {
        return index;
    }

    /**
     * @param index The index to set.
     */
    public void setIndex(int index)
    {
        this.index = index;
    }
 
    /**
     * @return Returns the title.
     */
    public String getTitle()
    {
        return title;
    }
    
    /**
     * @param title The title to set.
     */
    public void setTitle(String title)
    {
        this.title = title;
    }
}