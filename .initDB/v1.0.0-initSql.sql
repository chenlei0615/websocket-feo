/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : powerfulldb

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-07-27 12:12:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(255) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_id` varchar(255) NOT NULL,
  `role_id` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKle1fb8o3fcqxqukslp1egkudk` (`role_id`),
  CONSTRAINT `FKb40xxfch70f5qnyfw8yme1n1s` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`),
  CONSTRAINT `FKle1fb8o3fcqxqukslp1egkudk` FOREIGN KEY (`role_id`) REFERENCES `user_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` varchar(255) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `deleted` bit(1) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `creator` varchar(255) DEFAULT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------


-- 初始化测试脚本
insert  into `user_role`(`id`,`role_name`) values (1,'ADMIN'),(2,'USER');

insert  into `sys_user`(`id`,`password`,`user_name`) values (1,'root','root'),(2,'admin','admin');

insert  into `sys_user_role`(`user_id`,`role_id`) values (1,1),(2,2);