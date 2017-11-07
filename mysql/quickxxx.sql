/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50635
Source Host           : localhost:3306
Source Database       : quickxxx

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2017-08-10 17:14:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for shop_ad
-- ----------------------------
DROP TABLE IF EXISTS `shop_ad`;
CREATE TABLE `shop_ad` (
  `id` bigint(20) NOT NULL COMMENT 'id',
  `create_date` datetime NOT NULL COMMENT '创建日期',
  `modify_date` datetime NOT NULL COMMENT '修改日期',
  `orders` int(11) DEFAULT NULL COMMENT '排序',
  `begin_date` datetime DEFAULT NULL COMMENT '起始日期',
  `content` longtext COMMENT '内容',
  `end_date` datetime DEFAULT NULL COMMENT '结束日期',
  `path` varchar(255) DEFAULT NULL COMMENT '路径',
  `title` varchar(255) NOT NULL COMMENT '标题',
  `type` int(11) NOT NULL COMMENT '类型',
  `url` varchar(255) DEFAULT NULL COMMENT '链接地址',
  `ad_position` bigint(20) NOT NULL COMMENT '广告位',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_ad
-- ----------------------------
