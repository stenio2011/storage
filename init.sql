/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : storage

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-05-17 18:00:51
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
) ENGINE=InnoDB AUTO_INCREMENT=129 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of file_item
-- ----------------------------
INSERT INTO `file_item` VALUES ('1', '1', '/', '分院管理文件', null, '1', null, '2017-04-09 13:26:58', '2017-04-09 13:26:58', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('2', '1', '/', '技术公共文件', null, '1', null, '2017-04-09 13:26:58', '2017-04-09 13:26:58', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('3', '1', '/', '分院工程文件', null, '1', null, '2017-04-09 13:26:58', '2017-04-09 13:26:58', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('4', '1', '/', '其它电站工程文件', null, '1', null, '2017-04-09 13:26:58', '2017-04-09 13:26:58', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('5', '1', '/', '专业管理文件', null, '1', null, '2017-04-09 13:26:58', '2017-04-09 13:26:58', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('6', '1', '/', '科研文件', null, '1', null, '2017-04-09 13:26:58', '2017-04-09 13:26:58', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('7', '1', '/分院管理文件', '管理会议文件', null, '1', null, '2017-04-09 13:26:58', '2017-04-09 13:26:58', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('8', '1', '/分院管理文件', '制度文件', null, '1', null, '2017-04-09 13:26:58', '2017-04-09 13:26:58', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('9', '1', '/分院管理文件', '发文会议文件', null, '1', null, '2017-04-09 13:26:58', '2017-04-09 13:26:58', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('10', '1', '/技术公共文件', '工程资料', null, '1', null, '2017-04-09 13:26:58', '2017-04-09 13:26:58', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('11', '1', '/技术公共文件', '文献资料', null, '1', null, '2017-04-09 17:49:11', '2017-04-09 17:49:13', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('12', '1', '/技术公共文件', '技术文件', null, '1', null, '2017-04-09 17:49:11', '2017-04-09 17:49:13', '', '', '', '', '', '2017-04-09 22:34:04');
INSERT INTO `file_item` VALUES ('13', '1', '/技术公共文件', '会议文件', null, '1', null, '2017-04-09 18:49:23', '2017-04-09 18:49:25', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('21', '1', '/分院工程文件', '如美', null, '1', '', '2017-04-10 00:19:48', '2017-04-10 00:19:48', '', '', '', '', '', '2017-04-10 00:51:21');
INSERT INTO `file_item` VALUES ('27', '1', '/分院工程文件', '班达', null, '1', '', '2017-04-10 00:35:12', '2017-04-10 00:35:12', '', '', '', '', '', '2017-05-17 17:08:03');
INSERT INTO `file_item` VALUES ('28', '1', '/分院工程文件', '果多', null, '1', '', '2017-05-10 16:06:34', '2017-05-10 16:06:34', '', '', '', '', '', null);
INSERT INTO `file_item` VALUES ('29', '1', '/分院工程文件', '侧格', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('30', '1', '/分院工程文件', '约龙', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('31', '1', '/分院工程文件', '向达', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('32', '1', '/分院工程文件', '林场', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('33', '1', '/分院工程文件', '冬中', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('34', '1', '/分院工程文件/如美', '图纸文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('35', '1', '/分院工程文件/如美', '报告文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('36', '1', '/分院工程文件/如美', '计算文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('37', '1', '/分院工程文件/如美', '汇报文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('38', '1', '/分院工程文件/班达', '图纸文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('39', '1', '/分院工程文件/班达', '报告文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('40', '1', '/分院工程文件/班达', '计算文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('41', '1', '/分院工程文件/班达', '汇报文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('42', '1', '/分院工程文件/果多', '图纸文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('43', '1', '/分院工程文件/果多', '报告文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('44', '1', '/分院工程文件/果多', '计算文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('45', '1', '/分院工程文件/果多', '汇报文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('46', '1', '/分院工程文件/侧格', '图纸文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('47', '1', '/分院工程文件/侧格', '报告文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('48', '1', '/分院工程文件/侧格', '计算文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('49', '1', '/分院工程文件/侧格', '汇报文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('50', '1', '/分院工程文件/约龙', '图纸文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('51', '1', '/分院工程文件/约龙', '报告文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('52', '1', '/分院工程文件/约龙', '计算文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('53', '1', '/分院工程文件/约龙', '汇报文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('54', '1', '/分院工程文件/向达', '图纸文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('55', '1', '/分院工程文件/向达', '报告文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('56', '1', '/分院工程文件/向达', '计算文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('57', '1', '/分院工程文件/向达', '汇报文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('58', '1', '/分院工程文件/林场', '图纸文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('59', '1', '/分院工程文件/林场', '报告文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('60', '1', '/分院工程文件/林场', '计算文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('61', '1', '/分院工程文件/林场', '汇报文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('62', '1', '/分院工程文件/冬中', '图纸文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('63', '1', '/分院工程文件/冬中', '报告文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('64', '1', '/分院工程文件/冬中', '计算文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('65', '1', '/分院工程文件/冬中', '汇报文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('67', '1', '/其它电站工程文件', '工程1', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('68', '1', '/其它电站工程文件', '工程2', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('69', '1', '/其它电站工程文件', '工程3', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('70', '1', '/其它电站工程文件', '工程4', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('71', '1', '/其它电站工程文件', '工程5', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('72', '1', '/其它电站工程文件', '工程6', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('73', '1', '/其它电站工程文件', '工程7', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('74', '1', '/其它电站工程文件', '工程8', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('75', '1', '/其它电站工程文件/工程1', '图纸文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('76', '1', '/其它电站工程文件/工程1', '报告文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('77', '1', '/其它电站工程文件/工程1', '计算文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('78', '1', '/其它电站工程文件/工程1', '汇报文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('79', '1', '/其它电站工程文件/工程2', '图纸文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('80', '1', '/其它电站工程文件/工程2', '报告文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('81', '1', '/其它电站工程文件/工程2', '计算文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('82', '1', '/其它电站工程文件/工程2', '汇报文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('83', '1', '/其它电站工程文件/工程3', '图纸文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('84', '1', '/其它电站工程文件/工程3', '报告文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('85', '1', '/其它电站工程文件/工程3', '计算文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('86', '1', '/其它电站工程文件/工程3', '汇报文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('87', '1', '/其它电站工程文件/工程4', '图纸文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('88', '1', '/其它电站工程文件/工程4', '报告文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('89', '1', '/其它电站工程文件/工程4', '计算文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('90', '1', '/其它电站工程文件/工程4', '汇报文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('91', '1', '/其它电站工程文件/工程5', '图纸文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('92', '1', '/其它电站工程文件/工程5', '报告文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('93', '1', '/其它电站工程文件/工程5', '计算文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('94', '1', '/其它电站工程文件/工程5', '汇报文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('95', '1', '/其它电站工程文件/工程6', '图纸文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('96', '1', '/其它电站工程文件/工程6', '报告文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('97', '1', '/其它电站工程文件/工程6', '计算文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('98', '1', '/其它电站工程文件/工程6', '汇报文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('99', '1', '/其它电站工程文件/工程7', '图纸文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('100', '1', '/其它电站工程文件/工程7', '报告文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('101', '1', '/其它电站工程文件/工程7', '计算文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('102', '1', '/其它电站工程文件/工程7', '汇报文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('103', '1', '/其它电站工程文件/工程8', '图纸文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('104', '1', '/其它电站工程文件/工程8', '报告文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('105', '1', '/其它电站工程文件/工程8', '计算文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('106', '1', '/其它电站工程文件/工程8', '汇报文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('107', '1', '/专业管理文件', '坝工', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('108', '1', '/专业管理文件', '厂房', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('109', '1', '/专业管理文件', '水道', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('110', '1', '/专业管理文件/坝工', '管理文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('111', '1', '/专业管理文件/坝工', '图纸文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('112', '1', '/专业管理文件/坝工', '报告文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('113', '1', '/专业管理文件/坝工', '计算文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('114', '1', '/专业管理文件/坝工', '汇报文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('115', '1', '/专业管理文件/厂房', '管理文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('116', '1', '/专业管理文件/厂房', '图纸文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('117', '1', '/专业管理文件/厂房', '报告文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('118', '1', '/专业管理文件/厂房', '计算文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('119', '1', '/专业管理文件/厂房', '汇报文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('120', '1', '/专业管理文件/水道', '管理文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('121', '1', '/专业管理文件/水道', '图纸文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('122', '1', '/专业管理文件/水道', '报告文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('123', '1', '/专业管理文件/水道', '计算文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('124', '1', '/专业管理文件/水道', '汇报文件', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('126', '1', '/科研文件', '申请中', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('127', '1', '/科研文件', '研究中', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);
INSERT INTO `file_item` VALUES ('128', '1', '/科研文件', '已完成及发布', null, '1', null, '2017-05-10 16:06:34', '2017-05-10 16:06:34', null, null, null, null, null, null);

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
