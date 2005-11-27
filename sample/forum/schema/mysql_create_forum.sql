# Host: localhost

# Database: forum

# Table: 'category'




CREATE TABLE `category` (
  
`index` int(11) NOT NULL auto_increment,
  
`title` varchar(255) NOT NULL default '0',
 
`parent_index` int(11) NOT NULL default '0',
  
PRIMARY KEY  (`index`)
) 
ENGINE=MyISAM;

# Host: localhost

# Database: forum

# Table: 'post'


CREATE TABLE `post` (
  
`index` int(11) NOT NULL auto_increment,

`thread_index` int(11) NOT NULL default '0',
 
`text` text NOT NULL,
 
`user` varchar(100) NOT NULL default '',
 
`timestamp` datetime NOT NULL default '0000-00-00 00:00:00',
 
PRIMARY KEY  (`index`),
 
FULLTEXT KEY `text` (`text`)
) ENGINE=MyISAM;




# Host: localhost

# Database: forum

# Table: 'thread'
#


CREATE TABLE `thread` (
  
`index` int(11) NOT NULL auto_increment,

`topic_index` int(11) NOT NULL default '0',
 
`title` varchar(255) NOT NULL default '',
 
`starter` varchar(255) NOT NULL default '',
 
PRIMARY KEY  (`index`)
) ENGINE=MyISAM;

# Host: localhost

# Database: forum

# Table: 'topic'
# 


CREATE TABLE `topic` (
  
`index` int(11) NOT NULL auto_increment,
 
`category_index` int(11) NOT NULL default '0',
 
`title` varchar(255) NOT NULL default '',
 
PRIMARY KEY  (`index`)
) ENGINE=MyISAM;


INSERT INTO topic (topic.title, topic.category_index) VALUES ('test', -1);
