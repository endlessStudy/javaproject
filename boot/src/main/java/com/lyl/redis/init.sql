DROP DATABASE if EXISTS sboot;
CREATE database sboot;
DROP TABLE IF EXISTS  sboot.city;
CREATE TABLE sboot.city (
  id int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '城市编号',
  province_id int(10) unsigned  NOT NULL COMMENT '省份编号',
  city_name varchar(25) DEFAULT NULL COMMENT '城市名称',
  description varchar(25) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

insert into sboot.city(province_id,city_name,description) values(453200,'新乡市','liuyl的家在新乡市！')