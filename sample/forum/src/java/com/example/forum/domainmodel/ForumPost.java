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

import java.util.Date;

/**
 * @author $Author: gwatsman $
 * @version $Revision:$
 */
public class ForumPost
{
    private int    index;

    private int    thread_index;

    private String text;

    private String user;

    private Date   datetime = new Date();

    /**
     * @return Returns the datetime.
     */
    public Date getDatetime()
    {
        return datetime;
    }

    /**
     * @param datetime The datetime to set.
     */
    public void setDatetime(Date datetime)
    {
        this.datetime = datetime;
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
     * @return Returns the text.
     */
    public String getText()
    {
        return text;
    }

    /**
     * @param text The text to set.
     */
    public void setText(String text)
    {
        this.text = text;
    }

    /**
     * @return Returns the thread_index.
     */
    public int getThread_index()
    {
        return thread_index;
    }

    /**
     * @param thread_index The thread_index to set.
     */
    public void setThread_index(int thread_index)
    {
        this.thread_index = thread_index;
    }

    /**
     * @return Returns the user.
     */
    public String getUser()
    {
        return user;
    }

    /**
     * @param user The user to set.
     */
    public void setUser(String user)
    {
        this.user = user;
    }
}