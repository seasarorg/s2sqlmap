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
import java.util.Map;
import java.util.TreeMap;

import org.seasar.s2sqlmap.support.S2SqlMapDaoSupport;

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
public class SqlMapForumDao extends S2SqlMapDaoSupport 
implements ForumDao
{
    public void addPost(ForumPost post)
    {
        getSqlMapTemplate().executeUpdate(
                "addPost",
                post);
    }

    public void addTopic(ForumTopic topic){
        getSqlMapTemplate().executeUpdate(
                "addTopic",
                topic);
    }
 
    public void updatePost(ForumPost post)
    {
        getSqlMapTemplate().executeUpdate(
                "updatePost",
                post);
    }
    
    public void updateCategoryOnTopic(
            int topic_index, 
            int catgory_index)
    {
        Map map = new TreeMap();
        
        map.put("topic_index", new Integer(topic_index));
        map.put("category_index", new Integer(catgory_index));
        
        getSqlMapTemplate().executeUpdate(
                "updateCategoryOnTopic",
                map);
    }

    public List listTopicsByCategoryId(int category_index){
        return getSqlMapTemplate().executeQueryForList(
                "listTopicsByCategoryId",
                new Integer(category_index));
    }
    
    public PostModel findPost(int post_index)
    {
        return (PostModel)getSqlMapTemplate().executeQueryForObject(
                "findPost",
                new Integer(post_index));
    }
    
    public void addThread(ForumThread thread)
    {
        getSqlMapTemplate().executeUpdate(
                "addThread",
                thread);
    }
    
    public void addCategory(ForumCategory category)
    {
        getSqlMapTemplate().executeUpdate(
                "addCategory",
                category);
    }
    
    public String getCategoryName(int category_index){
        return (String)getSqlMapTemplate().executeQueryForObject(
                "getCategoryName",
                new Integer(category_index));
    }
    
    public List listCategoriesByParentId(int parent_index)
    {
        return getSqlMapTemplate().executeQueryForList(
                "listCategoriesByParentId",
                new Integer(parent_index));
    }
    
    public List listThreads(int thread_index)
    {
        return getSqlMapTemplate().executeQueryForList(
                "listThreads",
                new Integer(thread_index));
    }
    
    public int getCategoryIdByTopicId(int topic_index)
    {
        Integer i = (Integer)getSqlMapTemplate()
        .executeQueryForObject(
                "getCategoryIdByTopicId",
                new Integer(topic_index));
 
        return i.intValue();
    }
    
    public List listCategoriesByTopicId(int topic_index){
        return getSqlMapTemplate().executeQueryForList(
                "listCategoriesByTopicId",
                new Integer(topic_index));
    }
    
    public ForumCategory getCategory(
            int category_index)
    {
        return (ForumCategory)getSqlMapTemplate()
        .executeQueryForObject(
                "getCategory",
                new Integer(category_index));
    }
    
    public int countThreadsByTopicId(
            int topic_index){
        return ((Integer)getSqlMapTemplate()
        .executeQueryForObject(
                "countThreadsByTopicId",
                new Integer(topic_index))).intValue();
    }
 
    public List listThreadsByTopicId(
            int topic_index, 
            int offset,
            int limit){
        Map map = new TreeMap();
        
        map.put("topic_index", new Integer(topic_index));
        map.put("offset", new Integer(offset));
        map.put("limit", new Integer(limit));
        
        return getSqlMapTemplate().executeQueryForList(
                "listThreadsByTopicId", 
                map);
    }
    
    public int countPostsByThreadId(int therad_index){
        return ((Integer)getSqlMapTemplate()
                .executeQueryForObject(
                        "countPostsByThreadId",
                        new Integer(therad_index))).intValue();
    }
    
    public ThreadMetadata getThreadMetadata(int therad_index){
        return (ThreadMetadata)getSqlMapTemplate()
        .executeQueryForObject(
                "getThreadMetadata",
                new Integer(therad_index));
    }

}
