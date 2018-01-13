-- 创建图书表
CREATE TABLE `book` (
  `book_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '图书ID',
  `name` varchar(100) NOT NULL COMMENT '图书名称',
  `number` int(11) NOT NULL COMMENT '馆藏数量',
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='图书表'

-- 初始化图书数据
INSERT INTO `book` (`book_id`, `name`, `number`)
VALUES
	(1000, 'Java程序设计', 10),
	(1001, '数据结构', 10),
	(1002, '设计模式', 10),
	(1003, '编译原理', 10)

-- 创建预约图书表
CREATE TABLE `appointment` (
  `book_id` bigint(20) NOT NULL COMMENT '图书ID',
  `student_id` bigint(20) NOT NULL COMMENT '学号',
  `appoint_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '预约时间' ,
  PRIMARY KEY (`book_id`, `student_id`),
  INDEX `idx_appoint_time` (`appoint_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='预约图书表'


CREATE TABLE `meething`(
department VARCHAR (20),
ID int(20),
custom int(20),
name VARCHAR (20),
should int(20),
reals int(20),
late int(20),
leavs int(20),
absent int(20),
overtime int(20),
outs int(20),
businessout int(20),
time int(20),
shSign int(20),
sign int(20),
signOut int(20),
noSign int(20),
noSignout int(20),
leaves int(20),
officialOut int(20),
sickLeave int(20),
affairLeave int(20),
homeLeave int(20),
ordinary int(20),
weekend int(20),
holiday int(20),
attendTime int(20),
ordinaryOvertime int(20),
weekendOvertime int(20),
holidayOvertime int(26)
)


