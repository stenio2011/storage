/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50623
Source Host           : localhost:3306
Source Database       : storage

Target Server Type    : MYSQL
Target Server Version : 50623
File Encoding         : 65001

Date: 2017-04-23 12:11:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for file_item
-- ----------------------------
DROP TABLE IF EXISTS `file_item`;
CREATE TABLE `file_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `uid` bigint(20) DEFAULT NULL,
  `dir` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `size` bigint(20) DEFAULT NULL,
  `is_dir` tinyint(4) DEFAULT NULL,
  `md5` varchar(32) DEFAULT NULL,
  `c_time` datetime DEFAULT NULL,
  `m_time` datetime DEFAULT NULL,
  `file_code` varchar(255) DEFAULT NULL,
  `project_code` varchar(255) DEFAULT NULL,
  `item_code` varchar(255) DEFAULT NULL,
  `project_name` varchar(255) DEFAULT NULL,
  `research_stage` varchar(255) DEFAULT NULL,
  `build_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of file_item
-- ----------------------------
INSERT INTO `file_item` VALUES ('1', '1', '/', 'a', null, '1', null, '2017-04-09 13:26:58', '2017-04-09 13:26:58', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('2', '1', '/', 'b', null, '1', null, '2017-04-09 13:26:58', '2017-04-09 13:26:58', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('3', '1', '/', 'c', null, '1', null, '2017-04-09 13:26:58', '2017-04-09 13:26:58', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('4', '1', '/a', 'aa', null, '1', null, '2017-04-09 13:26:58', '2017-04-09 13:26:58', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('5', '1', '/a', 'ab', null, '1', null, '2017-04-09 13:26:58', '2017-04-09 13:26:58', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('6', '1', '/a', 'ac', null, '1', null, '2017-04-09 13:26:58', '2017-04-09 13:26:58', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('7', '1', '/b', 'ba', null, '1', null, '2017-04-09 13:26:58', '2017-04-09 13:26:58', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('8', '1', '/b', 'bb', null, '1', null, '2017-04-09 13:26:58', '2017-04-09 13:26:58', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('9', '1', '/c', 'ca', null, '1', null, '2017-04-09 13:26:58', '2017-04-09 13:26:58', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('10', '1', '/c', 'cc', null, '1', null, '2017-04-09 13:26:58', '2017-04-09 13:26:58', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('11', '1', '/a/aa', 'abc', null, '1', null, '2017-04-09 17:49:11', '2017-04-09 17:49:13', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('12', '1', '/a/aa/abc', 'file1.txt', '1024', '0', null, '2017-04-09 17:49:11', '2017-04-09 17:49:13', '123456', '654321', '0011', '工程名称1', '立项', '2017-04-09 22:34:04');
INSERT INTO `file_item` VALUES ('13', '1', '/a/aa', 'abcd', null, '1', null, '2017-04-09 18:49:23', '2017-04-09 18:49:25', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('21', '1', '/a/aa/abc', '1.png', '19486', '0', '', '2017-04-10 00:19:48', '2017-04-10 00:19:48', '456', '12222', '0022', '工程名称2', '立项', '2017-04-10 00:51:21');
INSERT INTO `file_item` VALUES ('27', '1', '/a/aa/abc', '未休年假费用支付申请表.docx', '40702', '0', '', '2017-04-10 00:35:12', '2017-04-10 00:35:12', '1223', '1452', '0033', '工程名称3', '立项', '2017-04-10 00:51:24');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `real_name` varchar(255) DEFAULT NULL,
  `is_manager` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'stenio', 'stenio', '贺新', '1');
