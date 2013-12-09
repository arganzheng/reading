CREATE TABLE `t_reading_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_time` datetime DEFAULT NULL,
  `modified_time` datetime DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


CREATE TABLE `t_reading_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isbn10` char(10) DEFAULT NULL,
  `isbn13` char(13) DEFAULT NULL,
  `title` varchar(128) DEFAULT NULL,
  `origin_title` varchar(128) DEFAULT NULL,
  `subtitle` varchar(256) DEFAULT NULL,
  `image` varchar(256) DEFAULT NULL,
  `author` varchar(256) DEFAULT NULL COMMENT '作者。可能有多个，以逗号分割。',
  `pubdate` date DEFAULT NULL,
  `tags` varchar(256) DEFAULT NULL,
  `pages` int(11) DEFAULT NULL,
  `summary` varchar(1000) DEFAULT NULL COMMENT '简要描述，最长是1000个字符，存入时候截断。',
  `detail_link` varchar(256) DEFAULT NULL COMMENT '详情链接（目前是调整到豆瓣去，取自alt返回字段）',
  `owner` varchar(256) DEFAULT NULL COMMENT '书的拥有者(冗余字段,逗号分割)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `t_reading_book_ownership` (
  `username` varchar(45) NOT NULL,
  `book_id` int(11) DEFAULT NULL,
  `status` varchar(32) DEFAULT NULL COMMENT '拥有关系的状态：上架(正常)、下架、借出、已归还(默认就是上架)',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='书以作者的拥有关系，书与拥有者（user）是多对多的关系，所以需要一张映射表。';


CREATE TABLE `t_reading_book_tag` (
  `book_id` int(11) NOT NULL,
  `tag_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='书籍与标签的对应关系表。';


