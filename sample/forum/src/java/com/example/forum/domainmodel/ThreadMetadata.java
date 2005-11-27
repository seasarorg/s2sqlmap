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
public class ThreadMetadata
{
    private int    thread_count;

    private String timestamp;

    /**
     * @return Returns the count.
     */
    public int getThread_count()
    {
        return thread_count;
    }

    /**
     * @param count The count to set.
     */
    public void setThread_count(int count)
    {
        this.thread_count = count;
    }

    /**
     * @return Returns the timestamp.
     */
    public String getTimestamp()
    {
        return timestamp;
    }

    /**
     * @param timestamp The timestamp to set.
     */
    public void setTimestamp(String timestamp)
    {
        this.timestamp = timestamp;
    }
}