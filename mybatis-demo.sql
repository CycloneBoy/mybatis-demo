/*
Navicat MySQL Data Transfer

Source Server         : CycloneBoy
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : mybatis-demo

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-07-21 21:56:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_article
-- ----------------------------
DROP TABLE IF EXISTS `t_article`;
CREATE TABLE `t_article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_article
-- ----------------------------
INSERT INTO `t_article` VALUES ('1', '疯狂Java讲义', '108.9', '李刚老师的经典著作');
INSERT INTO `t_article` VALUES ('2', '疯狂Android讲义', '99.9', '李刚老师的经典著作');
INSERT INTO `t_article` VALUES ('3', '疯狂ios讲义', '89.9', '李刚老师的经典著作');
INSERT INTO `t_article` VALUES ('4', 'SpringMVC+Mybatis企业开发', '69.9', '肖文吉老师的经典著作');

-- ----------------------------
-- Table structure for t_card
-- ----------------------------
DROP TABLE IF EXISTS `t_card`;
CREATE TABLE `t_card` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_card
-- ----------------------------
INSERT INTO `t_card` VALUES ('1', '432801199808081038');
INSERT INTO `t_card` VALUES ('2', '420082199919991999');

-- ----------------------------
-- Table structure for t_clazz
-- ----------------------------
DROP TABLE IF EXISTS `t_clazz`;
CREATE TABLE `t_clazz` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_clazz
-- ----------------------------
INSERT INTO `t_clazz` VALUES ('1', 'j1601');
INSERT INTO `t_clazz` VALUES ('2', 'j1602');

-- ----------------------------
-- Table structure for t_employee
-- ----------------------------
DROP TABLE IF EXISTS `t_employee`;
CREATE TABLE `t_employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loginname` varchar(32) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL,
  `sex` char(2) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `phone` varchar(21) DEFAULT NULL,
  `sal` double DEFAULT NULL,
  `state` varchar(18) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_employee
-- ----------------------------
INSERT INTO `t_employee` VALUES ('1', 'jack', '123456', '杰克', '男', '22', '13011112222', '9800', 'ACTIVE');
INSERT INTO `t_employee` VALUES ('2', 'rose', '111111', '露丝', '女', '18', '13011113333', '6800', 'ACTIVE');
INSERT INTO `t_employee` VALUES ('3', 'tom', '123456', '汤姆', '男', '23', '13044442222', '8800', 'ACTIVE');
INSERT INTO `t_employee` VALUES ('4', 'mary', '123', '玛丽', '女', '20', '13511119999', '7800', 'ACTIVE');

-- ----------------------------
-- Table structure for t_item
-- ----------------------------
DROP TABLE IF EXISTS `t_item`;
CREATE TABLE `t_item` (
  `order_id` int(11) NOT NULL,
  `article_id` int(11) NOT NULL,
  `amount` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`,`article_id`),
  KEY `article_id` (`article_id`),
  CONSTRAINT `t_item_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `t_order` (`id`),
  CONSTRAINT `t_item_ibfk_2` FOREIGN KEY (`article_id`) REFERENCES `t_article` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_item
-- ----------------------------
INSERT INTO `t_item` VALUES ('1', '1', '1');
INSERT INTO `t_item` VALUES ('1', '2', '1');
INSERT INTO `t_item` VALUES ('1', '3', '2');
INSERT INTO `t_item` VALUES ('2', '1', '1');
INSERT INTO `t_item` VALUES ('2', '4', '2');

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(64) DEFAULT NULL,
  `total` double DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `t_order_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('1', '6aa3fa359ff14619b77fabbbfff2d', '388.6', '1');
INSERT INTO `t_order` VALUES ('2', '6aa3fa359ff14619b77fabbbfff3c', '217.8', '1');

-- ----------------------------
-- Table structure for t_person
-- ----------------------------
DROP TABLE IF EXISTS `t_person`;
CREATE TABLE `t_person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `sex` varchar(32) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `card_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `card_id` (`card_id`),
  CONSTRAINT `t_person_ibfk_1` FOREIGN KEY (`card_id`) REFERENCES `t_card` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_person
-- ----------------------------
INSERT INTO `t_person` VALUES ('1', 'jack', '男', '23', '1');
INSERT INTO `t_person` VALUES ('2', 'rose', '女', '20', '2');

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `sex` varchar(3) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `clazz_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `clazz_id` (`clazz_id`),
  CONSTRAINT `t_student_ibfk_1` FOREIGN KEY (`clazz_id`) REFERENCES `t_clazz` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES ('1', 'jack', '男', '22', '1');
INSERT INTO `t_student` VALUES ('2', 'rose', '女', '18', '1');
INSERT INTO `t_student` VALUES ('3', 'tom', '男', '25', '2');
INSERT INTO `t_student` VALUES ('4', 'mary', '女', '20', '2');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) DEFAULT NULL,
  `loginname` varchar(32) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `phone` varchar(32) DEFAULT NULL,
  `address` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '杰克', 'jack', '123456', '13910012002', '广州');
INSERT INTO `t_user` VALUES ('2', '柔丝', 'rose', '111111', '13010023001', '深圳');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `address` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '张三', '111', '西安');
INSERT INTO `user` VALUES ('2', '李四', '222', '长沙');
INSERT INTO `user` VALUES ('3', '王五', '333', '武汉');
INSERT INTO `user` VALUES ('6', 'update', '11111', '厦门');
INSERT INTO `user` VALUES ('8', 'test', '123456', '北京');

-- ----------------------------
-- Table structure for user2
-- ----------------------------
DROP TABLE IF EXISTS `user2`;
CREATE TABLE `user2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(32) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `address` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user2
-- ----------------------------
INSERT INTO `user2` VALUES ('1', '张三', '111', '西安');
INSERT INTO `user2` VALUES ('2', '李四', '222', '长沙');
INSERT INTO `user2` VALUES ('3', '王五', '333', '武汉');
INSERT INTO `user2` VALUES ('5', '大黄蜂', '11111', '地球');
