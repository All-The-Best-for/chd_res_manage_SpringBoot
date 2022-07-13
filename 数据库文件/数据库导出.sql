/*
SQLyog Ultimate v13.1.1 (64 bit)
MySQL - 5.7.37 : Database - college_restaurant_management_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`college_restaurant_management_db` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `college_restaurant_management_db`;

/*Table structure for table `dish_appraisal` */

DROP TABLE IF EXISTS `dish_appraisal`;

CREATE TABLE `dish_appraisal` (
  `dish_id` int(10) unsigned NOT NULL COMMENT '订单id',
  `user_id` int(10) unsigned NOT NULL COMMENT '评价者id',
  `appraisal_text` varchar(255) DEFAULT NULL COMMENT '评价内容',
  `agree` float DEFAULT NULL COMMENT '用户对商家的评分',
  `negative` int(11) DEFAULT NULL COMMENT '点踩数',
  `appraisal_time` datetime DEFAULT NULL COMMENT '评论时间',
  PRIMARY KEY (`dish_id`,`user_id`),
  KEY `user_id_bind` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `dish_appraisal` */

insert  into `dish_appraisal`(`dish_id`,`user_id`,`appraisal_text`,`agree`,`negative`,`appraisal_time`) values 
(1653741961,1,'一般',3,0,'2022-06-07 15:35:32'),
(1653894142,1,'okokok',4,0,'2022-06-05 16:34:52'),
(1654401001,1,'好好好',4,0,'2022-06-05 15:54:29'),
(1654415725,1,'nice',5,0,'2022-06-05 15:55:59'),
(1654513533,1,'很好',5,0,'2022-06-06 19:08:34'),
(1654515079,1,'qqq',4,0,'2022-06-06 19:31:56'),
(1654515786,1,'ddd',5,0,'2022-06-06 19:44:47'),
(1654518888,1,'ggg',4,0,'2022-06-06 20:36:11'),
(1654520242,1,'hhh',4,0,'2022-06-06 20:58:28'),
(1654520854,1,'jjj',4,0,'2022-06-06 21:08:44'),
(1654587350,1,'不太行',2,0,'2022-06-07 15:37:22'),
(1654606128,1,'还不错',5,0,'2022-06-07 20:49:46'),
(1654663670,1,'rrr',4,0,'2022-06-08 12:49:32');

/*Table structure for table `dish_info` */

DROP TABLE IF EXISTS `dish_info`;

CREATE TABLE `dish_info` (
  `dish_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '菜品id',
  `dish_name` varchar(255) DEFAULT NULL COMMENT '菜品名称',
  `dish_price` float DEFAULT NULL COMMENT '菜品单价',
  `dish_sort` varchar(15) DEFAULT NULL COMMENT '菜品种类',
  `dish_sales` int(11) DEFAULT NULL COMMENT '菜品销售量',
  `dish_icon` varchar(255) DEFAULT NULL COMMENT '菜品图标路径',
  `dish_picture1` varchar(255) DEFAULT NULL COMMENT '菜品大图1路径',
  `dish_star` float DEFAULT NULL COMMENT '菜品星级',
  `old_price` float DEFAULT NULL COMMENT '旧价',
  `dish_text` varchar(255) DEFAULT NULL COMMENT '商品描述',
  PRIMARY KEY (`dish_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

/*Data for the table `dish_info` */

insert  into `dish_info`(`dish_id`,`dish_name`,`dish_price`,`dish_sort`,`dish_sales`,`dish_icon`,`dish_picture1`,`dish_star`,`old_price`,`dish_text`) values 
(1,'黄焖鸡f',15,'经典好菜',12,'images\\dishIcon\\dishId1.jpg','images\\dishPic\\dishId1.jpg',3.9735,15,'滑滑嫩嫩，超好吃'),
(2,'大盘鸡',39,'人气爆品',2,'images\\dishIcon\\dishId1.jpg','images\\dishPic\\dishId1.jpg',4.05,NULL,'量大，管饱'),
(3,'猪肉大虾锅贴',12,'精选套餐',8,'images\\dishIcon\\dishId3.jpg','images\\dishPic\\dishId3.jpg',4.05,12,'实惠，好吃'),
(4,'照烧鸡排饭',9,'小吃主食',3,'images\\dishIcon\\dishId4.jpg','images\\dishPic\\dishId4.jpg',4,9,'调换口味的不二之选'),
(5,'油泼面',8,'面食',3,'images\\dishIcon\\dishId5.jpg','images\\dishPic\\dishId5.jpg',3,8,'陕西人都爱吃'),
(6,'桂圆红豆红枣粥',5,'营养甜粥',1,'images\\dishIcon\\dishId6.jpg','images\\dishPic\\dishId6.jpg',3,5,'早上来一份？'),
(7,'四喜丸子',13,'经典好菜',8,'images\\dishIcon\\dishId7.jpg','images\\dishPic\\dishId7.jpg',4.05,13,'四喜丸子（Braised pork balls in gravy），是经典的中国传统名菜之一，属于鲁菜菜系。由四个色、香、味俱佳的肉丸组成，寓人生福、禄、寿、喜四大喜事。常用于喜宴、寿宴等宴席中的压轴菜，以取其吉祥之意。 四喜丸子从外观上来说，由四个较大的肉丸以及其他辅料组成。四喜丸子做法与狮子头基本一致，只是四喜丸子限用四个肉丸。主要用料为猪肉馅、鸡蛋、葱花等。'),
(8,'黑椒鸡腿堡',18,'秘制汉堡',1,'images\\dishIcon\\dishId8.jpg','images\\dishPic\\dishId8.jpg',4,0,'我家有个爱吃汉堡的小朋友，所以隔三差五就要做汉堡吃。\n以前熬酱汁都很麻烦，这次用了美食杰霸王超市的李锦记黑椒汁，超方便，味道也很好。'),
(9,'啤酒鸡块',25,'正餐',0,'images\\dishIcon\\dishId9.jpg','images\\dishPic\\dishId9.jpg',4,25,'啤酒不仅是饮品，也是上好的调味料，将啤酒放入菜肴中，让饭菜呈现别样的风味'),
(10,'水煮肉片',15,'正餐',0,'images\\dishIcon\\dishId10.jpg','images\\dishPic\\dishId10.jpg',4,15,'土豆一定要先煮。\n油爆香的时候一定要烧热。\n下肉片的时候要一片片，而且先不要搅动，等定型再搅动。\n配菜可以随意添加自己喜欢的食材。'),
(18,'芹菜叶蛋饼',4,'我的正餐',1,'images\\dishIcon\\dishId18.jpg','images\\dishPic\\dishId18.jpg',4,4,'好吃的很'),
(19,'海苔肉松火腿肠小面包',3,'早餐',0,'images\\dishIcon\\dishId19.jpg','images\\dishPic\\dishId19.jpg',4,3,'火腿肠面包绝对是孩子们最爱的一款面包，加了番茄酱和沙拉酱的酸甜口感搭配，加入适量低粉的这个方子做出来的面包很松软，想要给孩子吃上健康美味的面包就不能错过哟'),
(22,'鸡蛋香煎馒头片',2,'早点',0,'images\\dishIcon\\dishId22.jpg','images\\dishPic\\dishId22.jpg',4,2,'脆');

/*Table structure for table `order_info` */

DROP TABLE IF EXISTS `order_info`;

CREATE TABLE `order_info` (
  `order_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '流水号',
  `order_dish` int(10) NOT NULL COMMENT '菜品号',
  `count` int(11) DEFAULT NULL COMMENT '此菜品数量',
  PRIMARY KEY (`order_id`,`order_dish`)
) ENGINE=InnoDB AUTO_INCREMENT=1654663671 DEFAULT CHARSET=utf8;

/*Data for the table `order_info` */

insert  into `order_info`(`order_id`,`order_dish`,`count`) values 
(1653728409,1,1),
(1653728409,7,1),
(1653731286,4,1),
(1653738936,1,1),
(1653738936,7,1),
(1653738941,3,1),
(1653738947,5,1),
(1653741961,1,1),
(1653741961,3,1),
(1653741961,6,1),
(1653742192,2,1),
(1653744442,1,1),
(1653744442,7,1),
(1653744545,3,1),
(1653748108,1,1),
(1653748120,1,1),
(1653748169,1,1),
(1653748392,3,1),
(1653748522,1,1),
(1653748567,1,1),
(1653748669,5,1),
(1653748814,6,1),
(1653749233,1,1),
(1653749717,1,1),
(1653749841,1,1),
(1653749954,1,1),
(1653749972,7,1),
(1653749987,1,1),
(1653890987,1,1),
(1653893270,7,1),
(1653894142,3,1),
(1653894142,4,1),
(1653967928,1,1),
(1653967928,7,1),
(1653967935,3,1),
(1654074958,1,1),
(1654074958,7,1),
(1654136821,1,1),
(1654136821,5,1),
(1654136821,7,1),
(1654137128,1,1),
(1654137128,7,1),
(1654137210,1,1),
(1654137561,1,1),
(1654137673,1,1),
(1654138778,3,1),
(1654306563,4,1),
(1654306563,5,1),
(1654306661,2,1),
(1654396738,1,1),
(1654396738,3,1),
(1654401001,2,1),
(1654419107,7,1),
(1654484373,8,1),
(1654513533,3,1),
(1654513533,4,1),
(1654513559,3,1),
(1654513559,7,1),
(1654515079,1,1),
(1654515786,3,2),
(1654515786,5,1),
(1654515826,7,1),
(1654518888,1,1),
(1654518888,7,1),
(1654518988,1,1),
(1654520227,1,1),
(1654520227,7,1),
(1654520242,3,1),
(1654520242,7,1),
(1654520854,3,1),
(1654520854,7,1),
(1654565940,1,1),
(1654565940,4,1),
(1654565940,5,1),
(1654565940,7,1),
(1654587350,5,1),
(1654606111,1,1),
(1654606111,7,1),
(1654606128,4,1),
(1654606128,5,1),
(1654660205,1,1),
(1654663670,1,1),
(1654663670,7,1);

/*Table structure for table `order_user` */

DROP TABLE IF EXISTS `order_user`;

CREATE TABLE `order_user` (
  `user_id` int(10) DEFAULT NULL COMMENT '用户id',
  `order_id` int(10) unsigned NOT NULL COMMENT '流水号',
  `order_amount` float unsigned NOT NULL COMMENT '金额',
  `stall_id` int(10) unsigned NOT NULL COMMENT '档口id',
  `is_pay` int(11) DEFAULT NULL COMMENT '订单状态，1已完成、2未支付、3待取餐、4待评价、5已取消',
  `is_accept` int(11) DEFAULT NULL COMMENT '商家是否接单',
  `order_time` datetime DEFAULT NULL COMMENT '订单时间',
  PRIMARY KEY (`order_id`),
  KEY `stall_id_bind9` (`stall_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `order_user` */

insert  into `order_user`(`user_id`,`order_id`,`order_amount`,`stall_id`,`is_pay`,`is_accept`,`order_time`) values 
(1,1653728409,28,1,5,0,'2022-05-28 17:00:08'),
(1,1653731286,9,2,1,0,'2022-05-28 17:48:05'),
(1,1653738936,28,1,1,0,'2022-05-28 19:55:35'),
(1,1653738941,12,1,1,0,'2022-05-28 19:55:40'),
(1,1653738947,8,1,1,0,'2022-05-28 19:55:46'),
(1,1653741961,32,1,1,0,'2022-05-28 20:46:00'),
(1,1653744442,28,1,3,0,'2022-05-28 21:27:21'),
(1,1653744545,12,1,4,0,'2022-05-28 21:29:04'),
(1,1653748108,15,1,5,0,'2022-05-28 22:28:27'),
(1,1653748120,15,1,5,0,'2022-05-28 22:28:39'),
(1,1653748169,15,1,3,0,'2022-05-28 22:29:28'),
(1,1653748392,12,1,3,0,'2022-05-28 22:33:11'),
(1,1653748522,15,1,3,0,'2022-05-28 22:35:21'),
(1,1653748567,15,1,3,0,'2022-05-28 22:36:06'),
(1,1653748669,8,1,3,0,'2022-05-28 22:37:48'),
(1,1653748814,5,1,3,0,'2022-05-28 22:40:13'),
(1,1653749233,15,1,3,0,'2022-05-28 22:47:12'),
(1,1653749717,15,1,3,0,'2022-05-28 22:55:16'),
(1,1653749841,15,1,3,0,'2022-05-28 22:57:20'),
(1,1653749954,15,1,3,0,'2022-05-28 22:59:13'),
(1,1653749972,13,1,3,0,'2022-05-28 22:59:31'),
(1,1653749987,15,1,3,0,'2022-05-28 22:59:46'),
(1,1653890987,15,1,3,0,'2022-05-30 14:09:46'),
(1,1653893270,13,1,3,0,'2022-05-30 14:47:49'),
(1,1653894142,21,1,1,0,'2022-05-30 15:02:21'),
(1,1653967928,28,1,3,0,'2022-05-31 11:32:07'),
(1,1653967935,12,1,5,0,'2022-05-31 11:32:14'),
(1,1654074958,28,1,5,0,'2022-06-01 17:15:57'),
(2,1654136821,36,1,2,0,'2022-06-02 10:26:59'),
(2,1654137128,28,1,2,0,'2022-06-02 10:32:06'),
(2,1654137210,15,1,5,0,'2022-06-02 10:33:28'),
(2,1654137561,15,1,5,0,'2022-06-02 10:39:19'),
(2,1654137673,15,1,5,0,'2022-06-02 10:41:11'),
(2,1654138778,12,1,3,0,'2022-06-02 10:59:36'),
(1,1654306563,17,1,5,0,'2022-06-04 09:36:02'),
(1,1654396738,27,1,3,0,'2022-06-05 10:38:57'),
(1,1654419107,13,1,3,0,'2022-06-05 16:51:46'),
(1,1654484373,18,2,3,0,'2022-06-06 10:59:32'),
(1,1654513533,21,1,1,0,'2022-06-06 19:05:32'),
(1,1654513559,25,1,2,0,'2022-06-06 19:05:58'),
(1,1654515079,15,1,1,0,'2022-06-06 19:31:18'),
(1,1654515786,32,1,1,0,'2022-06-06 19:43:05'),
(1,1654515826,13,1,2,0,'2022-06-06 19:43:45'),
(1,1654518888,28,1,1,0,'2022-06-06 20:34:47'),
(1,1654518988,15,1,5,0,'2022-06-06 20:36:27'),
(1,1654520227,28,1,2,0,'2022-06-06 20:57:06'),
(1,1654520242,25,1,1,0,'2022-06-06 20:57:21'),
(1,1654520854,25,1,1,0,'2022-06-06 21:07:33'),
(1,1654565940,45,1,5,0,'2022-06-07 09:38:59'),
(1,1654587350,8,1,1,0,'2022-06-07 15:35:49'),
(1,1654606111,28,1,5,0,'2022-06-07 20:48:30'),
(1,1654606128,17,1,1,0,'2022-06-07 20:48:47'),
(1,1654660205,15,1,3,0,'2022-06-08 11:50:04'),
(1,1654663670,28,1,1,0,'2022-06-08 12:47:49');

/*Table structure for table `recharge_info` */

DROP TABLE IF EXISTS `recharge_info`;

CREATE TABLE `recharge_info` (
  `recharge_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '充值流水号',
  `recharge_amount` float unsigned NOT NULL COMMENT '充值金额',
  `recharge_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '充值时间',
  PRIMARY KEY (`recharge_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `recharge_info` */

/*Table structure for table `recharge_user` */

DROP TABLE IF EXISTS `recharge_user`;

CREATE TABLE `recharge_user` (
  `user_id` int(10) unsigned NOT NULL COMMENT '充值用户id',
  `recharge_id` int(10) unsigned NOT NULL COMMENT '充值流水id',
  PRIMARY KEY (`user_id`,`recharge_id`),
  KEY `recharge_id_res` (`recharge_id`),
  CONSTRAINT `recharge_id_res` FOREIGN KEY (`recharge_id`) REFERENCES `recharge_info` (`recharge_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_recharge_id_res` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `recharge_user` */

/*Table structure for table `recommendation_stall` */

DROP TABLE IF EXISTS `recommendation_stall`;

CREATE TABLE `recommendation_stall` (
  `stall_id` int(10) NOT NULL COMMENT '热门推荐的店铺id',
  `is_admin` int(10) DEFAULT NULL COMMENT '是否为管理员设置',
  PRIMARY KEY (`stall_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `recommendation_stall` */

insert  into `recommendation_stall`(`stall_id`,`is_admin`) values 
(1,1),
(2,0),
(3,0),
(4,0);

/*Table structure for table `res_appraisal` */

DROP TABLE IF EXISTS `res_appraisal`;

CREATE TABLE `res_appraisal` (
  `res_id` int(10) unsigned NOT NULL COMMENT '评论餐厅id',
  `user_id` int(10) unsigned NOT NULL COMMENT '评论用户id',
  `appraisal_text` varchar(255) DEFAULT NULL COMMENT '评论内容',
  `agree` int(11) DEFAULT NULL COMMENT '点赞数',
  `negative` int(11) DEFAULT NULL COMMENT '点踩数',
  `appraisal_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '评论时间',
  PRIMARY KEY (`res_id`,`user_id`),
  KEY `user_id_bind3` (`user_id`),
  CONSTRAINT `res_id_bind2` FOREIGN KEY (`res_id`) REFERENCES `restaurant_info` (`res_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_id_bind3` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `res_appraisal` */

/*Table structure for table `res_profit_info` */

DROP TABLE IF EXISTS `res_profit_info`;

CREATE TABLE `res_profit_info` (
  `res_id` int(10) unsigned NOT NULL COMMENT '盈利餐厅id',
  `profit_time` int(11) DEFAULT NULL COMMENT '盈利记录时间戳——记录年月',
  `profit_amount` float DEFAULT NULL COMMENT '盈利金额',
  PRIMARY KEY (`res_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `res_profit_info` */

/*Table structure for table `restaurant_admin` */

DROP TABLE IF EXISTS `restaurant_admin`;

CREATE TABLE `restaurant_admin` (
  `restaurant_id` int(11) unsigned NOT NULL COMMENT '餐厅id',
  `top_admin_id` int(11) unsigned NOT NULL COMMENT '餐厅对应的顶级管理员id',
  PRIMARY KEY (`restaurant_id`,`top_admin_id`),
  KEY `top_admin_bind` (`top_admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `restaurant_admin` */

insert  into `restaurant_admin`(`restaurant_id`,`top_admin_id`) values 
(1,1),
(2,2),
(3,3),
(4,4),
(5,5);

/*Table structure for table `restaurant_info` */

DROP TABLE IF EXISTS `restaurant_info`;

CREATE TABLE `restaurant_info` (
  `res_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '餐厅id',
  `res_name` varchar(15) DEFAULT NULL COMMENT '餐厅名称',
  `res_account` double DEFAULT NULL COMMENT '餐厅盈利',
  `res_star` float DEFAULT NULL COMMENT '餐厅星级',
  `res_amount` int(11) DEFAULT NULL COMMENT '销量',
  PRIMARY KEY (`res_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `restaurant_info` */

insert  into `restaurant_info`(`res_id`,`res_name`,`res_account`,`res_star`,`res_amount`) values 
(1,'天行健',971,4.12291,36),
(2,'小时空',0,4,0),
(3,'树慧园',0,4,0),
(4,'滋兰苑',0,4,0),
(5,'撒地方',0,0,0);

/*Table structure for table `secondary_admin_info` */

DROP TABLE IF EXISTS `secondary_admin_info`;

CREATE TABLE `secondary_admin_info` (
  `secondary_admin_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '档口管理员id',
  `secondary_admin_number` varchar(17) DEFAULT NULL COMMENT '档口管理员工号',
  `secondary_admin_name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `secondary_admin_sex` varchar(1) DEFAULT NULL COMMENT '性别',
  `secondary_admin_phone` varchar(15) DEFAULT NULL COMMENT '手机号',
  `secondary_admin_password` varchar(255) DEFAULT NULL COMMENT '密码',
  `secondary_admin_icon` varchar(255) DEFAULT NULL COMMENT '图标',
  `secondary_admin_picture` varchar(50) DEFAULT NULL COMMENT '照片',
  PRIMARY KEY (`secondary_admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `secondary_admin_info` */

insert  into `secondary_admin_info`(`secondary_admin_id`,`secondary_admin_number`,`secondary_admin_name`,`secondary_admin_sex`,`secondary_admin_phone`,`secondary_admin_password`,`secondary_admin_icon`,`secondary_admin_picture`) values 
(1,'1','admin','男','19829263439','123','https://tva2.sinaimg.cn/large/0072Vf1pgy1foxkg1c0bbj31kw0w04oe.jpg',NULL),
(2,'2','test','男','19829263439','123','https://tva2.sinaimg.cn/large/0072Vf1pgy1foxkg1c0bbj31kw0w04oe.jpg',NULL),
(3,'3','qianAdmin','男','19829254229','123','https://tva2.sinaimg.cn/large/0072Vf1pgy1foxkg1c0bbj31kw0w04oe.jpg',NULL),
(4,'4','aAdmin','男','19829263429','123','https://tva2.sinaimg.cn/large/0072Vf1pgy1foxkg1c0bbj31kw0w04oe.jpg',NULL),
(14,'jjj','jjj','男','19829265429','123','https://tva2.sinaimg.cn/large/0072Vf1pgy1foxkg1c0bbj31kw0w04oe.jpg',''),
(15,'bbb','bbb','男','19829263459','123','https://tva2.sinaimg.cn/large/0072Vf1pgy1foxkg1c0bbj31kw0w04oe.jpg','');

/*Table structure for table `stall_admin` */

DROP TABLE IF EXISTS `stall_admin`;

CREATE TABLE `stall_admin` (
  `stall_id` int(11) unsigned NOT NULL COMMENT '档口id',
  `secondary_admin_id` int(11) unsigned NOT NULL COMMENT '档口对应的二级管理员id',
  PRIMARY KEY (`stall_id`,`secondary_admin_id`),
  KEY `sec_admin_bind` (`secondary_admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `stall_admin` */

insert  into `stall_admin`(`stall_id`,`secondary_admin_id`) values 
(1,1),
(2,2),
(3,3),
(4,4),
(14,14),
(15,15);

/*Table structure for table `stall_appraisal` */

DROP TABLE IF EXISTS `stall_appraisal`;

CREATE TABLE `stall_appraisal` (
  `stall_id` int(10) unsigned NOT NULL COMMENT '档口id',
  `user_id` int(10) unsigned NOT NULL COMMENT '用户id',
  `appraisal_text` varchar(255) DEFAULT NULL COMMENT '评论内容',
  `agree` int(11) DEFAULT NULL COMMENT '点赞数',
  `negative` int(11) DEFAULT NULL COMMENT '点踩数',
  `appraisal_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '评论时间',
  PRIMARY KEY (`stall_id`,`user_id`),
  KEY `user_bind2` (`user_id`),
  CONSTRAINT `stall_bind2` FOREIGN KEY (`stall_id`) REFERENCES `stall_info` (`stall_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_bind2` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `stall_appraisal` */

/*Table structure for table `stall_dish` */

DROP TABLE IF EXISTS `stall_dish`;

CREATE TABLE `stall_dish` (
  `stall_id` int(10) NOT NULL COMMENT '档口id',
  `dish_id` int(10) NOT NULL COMMENT '档口对应餐品id',
  `period` int(11) NOT NULL COMMENT '上架时段：1早2中3晚',
  `if_stock` int(1) DEFAULT NULL COMMENT '是否上架',
  `amount` int(10) DEFAULT NULL COMMENT '本档口本餐品剩余数量',
  PRIMARY KEY (`stall_id`,`dish_id`,`period`),
  KEY `dish_id_bind` (`dish_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `stall_dish` */

insert  into `stall_dish`(`stall_id`,`dish_id`,`period`,`if_stock`,`amount`) values 
(1,1,2,1,1444),
(1,3,2,1,233),
(1,4,2,1,222),
(1,5,3,1,333),
(1,6,2,1,444),
(1,7,2,1,555),
(2,2,2,1,556),
(2,8,1,1,1000),
(2,9,1,1,1000),
(2,10,1,1,1000),
(3,18,1,1,1000),
(3,19,1,1,1000),
(4,22,1,1,1000);

/*Table structure for table `stall_info` */

DROP TABLE IF EXISTS `stall_info`;

CREATE TABLE `stall_info` (
  `stall_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '档口id',
  `stall_name` varchar(15) DEFAULT NULL COMMENT '档口名称',
  `stall_account` double DEFAULT NULL COMMENT '档口盈利',
  `stall_restaurant` int(11) DEFAULT NULL COMMENT '档口所属餐厅id',
  `stall_text` varchar(255) DEFAULT NULL COMMENT '档口简介',
  `stall_icon` varchar(255) DEFAULT NULL COMMENT '档口图标',
  `stall_picture1` varchar(255) DEFAULT NULL COMMENT '档口照片1',
  `stall_picture2` varchar(255) DEFAULT NULL COMMENT '档口照片2',
  `stall_picture3` varchar(255) DEFAULT NULL COMMENT '档口照片3',
  `stall_star` float DEFAULT NULL COMMENT '档口星级',
  `amount` int(11) DEFAULT NULL COMMENT '销售量',
  `box_fee` float DEFAULT NULL COMMENT '餐盒费',
  `res_address` varchar(20) DEFAULT NULL COMMENT '档口所在餐厅名称',
  `day_amount` int(11) DEFAULT '0' COMMENT '日销量',
  `is_work` int(11) DEFAULT NULL COMMENT '是否营业',
  PRIMARY KEY (`stall_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `stall_info` */

insert  into `stall_info`(`stall_id`,`stall_name`,`stall_account`,`stall_restaurant`,`stall_text`,`stall_icon`,`stall_picture1`,`stall_picture2`,`stall_picture3`,`stall_star`,`amount`,`box_fee`,`res_address`,`day_amount`,`is_work`) values 
(1,'川渝川菜馆',436,1,'这是一个川菜店','images\\stallIcon\\stallId1.jpg','images\\stallPic\\stallId1.jpg','http://fuss10.elemecdn.com/6/72/cb844f0bb60c502c6d5c05e0bddf5jpeg.jpeg?imageView2/1/w/750/h/750','http://fuss10.elemecdn.com/9/b5/469d8854f9a3a03797933fd01398bjpeg.jpeg?imageView2/1/w/750/h/750',4.11357,35,1,'天行健',0,0),
(2,'千家粗粮王',96,1,'这是一个自助餐','images\\stallIcon\\stallId2.jpg','images\\stallPic\\stallId2.jpg','http://fuss10.elemecdn.com/6/72/cb844f0bb60c502c6d5c05e0bddf5jpeg.jpeg?imageView2/1/w/750/h/750',NULL,3.5,3,2,'天行健',0,1),
(3,'阿婆米线',4,1,'这是一个米线店','images\\stallIcon\\stallId3.jpg','images\\stallPic\\stallId3.jpg',NULL,NULL,4.1,1,1,'天行健',0,1),
(4,'东北饺子王',0,1,'这是一个饺子店','images\\stallIcon\\stallId4.jpg','images\\stallPic\\stallId4.jpg',NULL,NULL,4.1,0,1,'天行健',0,1),
(14,'hhhhh',0,1,'hhhh','images\\stallIcon\\stallId14.jpg','images\\stallPic\\stallId14.jpg','','',4,0,1,'天行健',0,0),
(15,'bbbbb',0,1,'bbbb','images\\stallIcon\\stallId15.jpg','images\\stallPic\\stallId15.jpg','','',4,0,1,'天行健',0,1);

/*Table structure for table `stall_profit_info` */

DROP TABLE IF EXISTS `stall_profit_info`;

CREATE TABLE `stall_profit_info` (
  `stall_id` int(11) NOT NULL COMMENT '档口id',
  `profit_time` int(11) DEFAULT NULL COMMENT '盈利时间戳',
  `profit_amount` float DEFAULT NULL COMMENT '档口盈利金额',
  PRIMARY KEY (`stall_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `stall_profit_info` */

/*Table structure for table `super_admin_info` */

DROP TABLE IF EXISTS `super_admin_info`;

CREATE TABLE `super_admin_info` (
  `super_id` int(10) unsigned NOT NULL COMMENT '学院管理人员id',
  `super_number` varchar(15) DEFAULT NULL COMMENT '工号',
  `super_name` varchar(7) DEFAULT NULL COMMENT '姓名',
  `super_sex` varchar(1) DEFAULT NULL COMMENT '性别',
  `super_phone` varchar(15) DEFAULT NULL COMMENT '手机号',
  `super_password` varchar(255) DEFAULT NULL COMMENT '密码',
  `super_icon` varchar(255) DEFAULT NULL COMMENT '图标',
  `super_picture` varchar(255) DEFAULT NULL COMMENT '照片',
  PRIMARY KEY (`super_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `super_admin_info` */

insert  into `super_admin_info`(`super_id`,`super_number`,`super_name`,`super_sex`,`super_phone`,`super_password`,`super_icon`,`super_picture`) values 
(1,'1','admin','男','19829263254','123','https://tva2.sinaimg.cn/large/0072Vf1pgy1foxkg1c0bbj31kw0w04oe.jpg',NULL);

/*Table structure for table `top_admin_info` */

DROP TABLE IF EXISTS `top_admin_info`;

CREATE TABLE `top_admin_info` (
  `top_admin_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '餐厅管理员id',
  `top_admin_number` varchar(15) NOT NULL COMMENT '餐厅管理员工号',
  `top_admin_name` varchar(7) DEFAULT NULL COMMENT '姓名',
  `top_admin_sex` varchar(1) DEFAULT NULL COMMENT '性别',
  `top_admin_phone` varchar(15) DEFAULT NULL COMMENT '手机号',
  `top_admin_password` varchar(255) DEFAULT NULL COMMENT '密码',
  `top_admin_icon` varchar(255) DEFAULT NULL COMMENT '用户图标',
  `top_admin_picture` varchar(255) DEFAULT NULL COMMENT '用户照片',
  PRIMARY KEY (`top_admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `top_admin_info` */

insert  into `top_admin_info`(`top_admin_id`,`top_admin_number`,`top_admin_name`,`top_admin_sex`,`top_admin_phone`,`top_admin_password`,`top_admin_icon`,`top_admin_picture`) values 
(1,'1','admin','男','19829263245','123','https://tva2.sinaimg.cn/large/0072Vf1pgy1foxkg1c0bbj31kw0w04oe.jpg',NULL),
(2,'2','test','男','19829263234','123','https://tva2.sinaimg.cn/large/0072Vf1pgy1foxkg1c0bbj31kw0w04oe.jpg',NULL),
(3,'3','3admin','男','12345678908','123','https://tva2.sinaimg.cn/large/0072Vf1pgy1foxkg1c0bbj31kw0w04oe.jpg',NULL),
(4,'4','4admin','男','19829263254','123','https://tva2.sinaimg.cn/large/0072Vf1pgy1foxkg1c0bbj31kw0w04oe.jpg',NULL),
(5,'asd','asd','男','19829263267','123','','');

/*Table structure for table `user_info` */

DROP TABLE IF EXISTS `user_info`;

CREATE TABLE `user_info` (
  `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户uid',
  `user_number` varchar(255) NOT NULL COMMENT '用户学号/工号',
  `user_name` varchar(255) NOT NULL COMMENT '用户真实姓名',
  `user_sex` varchar(1) NOT NULL COMMENT '用户性别',
  `user_phone` varchar(15) NOT NULL COMMENT '用户手机号',
  `user_account` float unsigned NOT NULL COMMENT '用户账号余额',
  `user_password` varchar(255) NOT NULL COMMENT '用户密码，md5加密',
  `user_icon` varchar(255) DEFAULT NULL COMMENT '用户图标',
  `user_picture` varchar(255) DEFAULT NULL COMMENT '用户照片',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

/*Data for the table `user_info` */

insert  into `user_info`(`user_id`,`user_number`,`user_name`,`user_sex`,`user_phone`,`user_account`,`user_password`,`user_icon`,`user_picture`) values 
(1,'2018903754','王大爷','男','19829263265',707,'123','https://tva2.sinaimg.cn/large/0072Vf1pgy1foxkg1c0bbj31kw0w04oe.jpg','1'),
(2,'2018903793','刘老五','男','19829263228',88,'123','https://tva2.sinaimg.cn/large/0072Vf1pgy1foxkg1c0bbj31kw0w04oe.jpg',NULL),
(3,'2018903794','李大四','男','19829263227',500,'123','https://tva2.sinaimg.cn/large/0072Vf1pgy1foxkg1c0bbj31kw0w04oe.jpg',NULL),
(4,'2018903795','田小七','女','11111111111',600,'123','https://tva2.sinaimg.cn/large/0072Vf1pgy1foxkg1c0bbj31kw0w04oe.jpg',NULL),
(7,'2018903796','阿道夫','男','19829263256',100,'123','https://tva2.sinaimg.cn/large/0072Vf1pgy1foxkg1c0bbj31kw0w04oe.jpg','1'),
(8,'2018903797','马武媚','女','19829263265',100,'123','https://tva2.sinaimg.cn/large/0072Vf1pgy1foxkg1c0bbj31kw0w04oe.jpg','1');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
