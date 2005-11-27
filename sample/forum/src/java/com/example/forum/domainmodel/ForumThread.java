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
public class ForumThread
{
    private int    index;

    private int    topic_index;

    private String title;

    private String starter;

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
     * @return Returns the starter.
     */
    public String getStarter()
    {
        return starter;
    }

    /**
     * @param starter The starter to set.
     */
    public void setStarter(String starter)
    {
        this.starter = starter;
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

    /**
     * @return Returns the topic_index.
     */
    public int getTopic_index()
    {
        return topic_index;
    }

    /**
     * @param topic_index The topic_index to set.
     */
    public void setTopic_index(int topic_index)
    {
        this.topic_index = topic_index;
    }
}