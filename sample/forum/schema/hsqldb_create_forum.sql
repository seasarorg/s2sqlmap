 
CREATE TABLE category (
  
index int NOT NULL,
  
title varchar(255) DEFAULT '0' NOT NULL,
 
parent_index int DEFAULT '0' NOT NULL ,
  
PRIMARY KEY  (index)
) ;

CREATE SEQUENCE category_seq START WITH 1;
 
CREATE TABLE post (
  
index int NOT NULL,

thread_index int DEFAULT '0' NOT NULL ,
 
text varchar NOT NULL,
 
user varchar DEFAULT '' NOT NULL ,
 
timestamp datetime DEFAULT '0000-00-00 00:00:00' NOT NULL ,
 
PRIMARY KEY  (index)
);

CREATE SEQUENCE post_seq START WITH 1;

 CREATE TABLE thread (
  
index int NOT NULL,

topic_index int DEFAULT '0' NOT NULL,
 
title varchar DEFAULT '' NOT NULL,
 
starter varchar DEFAULT '' NOT NULL,
 
PRIMARY KEY  (index)
);

CREATE SEQUENCE thread_seq START WITH 1;

CREATE TABLE topic (
  
index int NOT NULL,
 
category_index int DEFAULT '0'NOT NULL,
 
title varchar DEFAULT '' NOT NULL,
 
PRIMARY KEY  (index)
);

CREATE SEQUENCE topic_seq START WITH 1;


INSERT INTO topic (topic.index,topic.title, topic.category_index) VALUES (NEXT VALUE FOR topic_seq,'test', -1);
