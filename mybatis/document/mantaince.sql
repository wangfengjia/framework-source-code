create table `user`(
   `id` int not null auto_increment primary key,
   `name` varchar(128) not null default '',
   `password` varchar(128) not null default ''
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


create table `blog`(
   `id` int not null auto_increment primary key,
   `user_id` int not null default 0,
   `title` varchar(128) not null default ''
)ENGINE=InnoDB DEFAULT CHARSET=utf8;