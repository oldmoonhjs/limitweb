/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50154
Source Host           : localhost:3306
Source Database       : limitpro

Target Server Type    : MYSQL
Target Server Version : 50154
File Encoding         : 65001

Date: 2016-05-22 00:37:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `loginname` varchar(20) NOT NULL,
  `loginpassword` varchar(20) NOT NULL,
  `nickname` varchar(25) DEFAULT 'sam',
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'admin', 'admin', 'super');
INSERT INTO `users` VALUES ('2', 'Test', 'test', 'sam');
