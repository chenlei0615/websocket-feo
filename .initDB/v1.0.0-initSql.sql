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
  `deleted` bit(1) DEFAULT b'0',
  `modify_time` datetime DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('8a77c2f764db70720164db70da9a0000', '2018-07-27 19:12:44', '\0', '2018-07-27 19:12:44', '21232f297a57a5a743894a0e4a801fc3', 'chenlei');
INSERT INTO `sys_user` VALUES ('8a77c2f764db70720164db71a75e0001', '2018-07-27 19:13:36', '\0', '2018-07-27 19:13:36', '63a9f0ea7bb98050796b649e85481845', 'zhao');
INSERT INTO `sys_user` VALUES ('8a77c2f764db70720164db71fe7b0002', '2018-07-27 19:13:58', '\0', '2018-07-27 19:13:58', 'e10adc3949ba59abbe56e057f20f883e', 'mj');

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
INSERT INTO `sys_user_role` VALUES ('8a77c2f764db70720164db70da9a0000', '1');
INSERT INTO `sys_user_role` VALUES ('8a77c2f764db70720164db71a75e0001', '2');
INSERT INTO `sys_user_role` VALUES ('8a77c2f764db70720164db71fe7b0002', '2');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` varchar(255) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `deleted` bit(1) DEFAULT b'0',
  `modify_time` datetime DEFAULT NULL,
  `creator` varchar(255) DEFAULT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '2018-07-27 14:57:24', '\0', '2018-07-27 14:57:18', null, 'ADMIN');
INSERT INTO `user_role` VALUES ('2', '2018-07-27 14:57:28', '\0', '2018-07-27 14:57:21', null, 'USER');



