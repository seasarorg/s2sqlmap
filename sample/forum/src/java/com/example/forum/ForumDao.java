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
public interface ForumDao
{
    //Category 
    
    String getCategoryName(int category_index);
    
    void updateCategoryOnTopic(int topic_index, int catgory_index);

    void addCategory(ForumCategory category);
       
    int getCategoryIdByTopicId(int topic_index);
    
    ForumCategory getCategory(int category_index);
    
    List listCategoriesByParentId(int parent_index);

    // Thread
    
    List listThreads(
            int thread_index);
  
    List listTopicsByCategoryId(int category_index);

    void addThread(ForumThread thread);

    ThreadMetadata getThreadMetadata(int thread_index);
    
    List listThreadsByTopicId(
            int topic_index, 
            int offset,
            int limit);
    
    int countThreadsByTopicId(int topic_index);
    
    // Post

    void addPost(ForumPost post);
    
    void updatePost(ForumPost post);
    
    int countPostsByThreadId(int therad_index);
    
    PostModel findPost(int post_index);
 
    // Topic

    void addTopic(ForumTopic topic);

}
