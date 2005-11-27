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

import java.util.List;

import com.example.forum.domainmodel.ForumCategory;
import com.example.forum.domainmodel.ForumPost;
import com.example.forum.domainmodel.ForumThread;
import com.example.forum.domainmodel.ForumTopic;
import com.example.forum.domainmodel.PostModel;
import com.example.forum.domainmodel.ThreadMetadata;

/**
 * @author $Author: gwatsman $
 * @version $Revision:$
 */
public class ForumServiceImpl implements ForumService
{
    private ForumDao forumDao;

    /**
     * @return Returns the forumDao.
     */
    public ForumDao getForumDao()
    {
        return forumDao;
    }

    /**
     * @param forumDao The forumDao to set.
     */
    public void setForumDao(ForumDao forumDao)
    {
        this.forumDao = forumDao;
    }

    /**
     * @param category
     */
    public void addCategory(ForumCategory category)
    {
        forumDao.addCategory(category);
    }
    /**
     * @param post
     */
    public void addPost(ForumPost post)
    {
        forumDao.addPost(post);
    }
    /**
     * @param thread
     */
    public void addThread(ForumThread thread)
    {
        forumDao.addThread(thread);
    }
    /**
     * @param topic
     */
    public void addTopic(ForumTopic topic)
    {
        forumDao.addTopic(topic);
    }
    /**
     * @param therad_index
     * @return
     */
    public int countPostsByThreadId(int therad_index)
    {
        return forumDao.countPostsByThreadId(therad_index);
    }
    /**
     * @param topic_index
     * @return
     */
    public int countThreadsByTopicId(int topic_index)
    {
        return forumDao.countThreadsByTopicId(topic_index);
    }
    /**
     * @param post_index
     * @return
     */
    public PostModel findPost(int post_index)
    {
        return forumDao.findPost(post_index);
    }
    /**
     * @param category_index
     * @return
     */
    public ForumCategory getCategory(int category_index)
    {
        return forumDao.getCategory(category_index);
    }
    /**
     * @param topic_index
     * @return
     */
    public int getCategoryIdByTopicId(int topic_index)
    {
        return forumDao.getCategoryIdByTopicId(topic_index);
    }
    /**
     * @param category_index
     * @return
     */
    public String getCategoryName(int category_index)
    {
        return forumDao.getCategoryName(category_index);
    }
    /**
     * @param thread_index
     * @return
     */
    public ThreadMetadata getThreadMetadata(int thread_index)
    {
        return forumDao.getThreadMetadata(thread_index);
    }
    /**
     * @param parent_index
     * @return
     */
    public List listCategoriesByParentId(int parent_index)
    {
        return forumDao.listCategoriesByParentId(parent_index);
    }
    /**
     * @param thread_index
     * @return
     */
    public List listThreads(int thread_index)
    {
        return forumDao.listThreads(thread_index);
    }
    /**
     * @param topic_index
     * @param offset
     * @param limit
     * @return
     */
    public List listThreadsByTopicId(int topic_index, int offset, int limit)
    {
        return forumDao.listThreadsByTopicId(topic_index, offset, limit);
    }
    /**
     * @param category_index
     * @return
     */
    public List listTopicsByCategoryId(int category_index)
    {
        return forumDao.listTopicsByCategoryId(category_index);
    }
    /**
     * @param topic_index
     * @param catgory_index
     */
    public void updateCategoryOnTopic(int topic_index, int catgory_index)
    {
        forumDao.updateCategoryOnTopic(topic_index, catgory_index);
    }
    /**
     * @param post
     */
    public void updatePost(ForumPost post)
    {
        forumDao.updatePost(post);
    }
}