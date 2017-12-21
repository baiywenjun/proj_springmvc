/*
Navicat MySQL Data Transfer

Source Server         : connMySql
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : iot_db

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2017-12-21 09:24:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_account
-- ----------------------------
DROP TABLE IF EXISTS `tb_account`;
CREATE TABLE `tb_account` (
  `account_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(200) NOT NULL,
  `pass_word` varchar(200) NOT NULL,
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `unlock_time` datetime DEFAULT NULL COMMENT '解锁时间',
  `phone` varchar(50) DEFAULT NULL COMMENT '联系电话默认和username一致',
  PRIMARY KEY (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_account
-- ----------------------------
INSERT INTO `tb_account` VALUES ('1', 'zhangsan', '123', '2017-12-19 15:16:12', '2017-12-18 15:16:14', '18511112222');
INSERT INTO `tb_account` VALUES ('2', 'lisi', '123', '2017-12-19 15:52:00', null, '15312331233');
INSERT INTO `tb_account` VALUES ('3', '李四234', '123', '2017-12-20 15:59:39', null, null);
INSERT INTO `tb_account` VALUES ('4', '李四456', '123', '2017-12-21 15:52:00', '2017-12-18 16:02:24', '');
INSERT INTO `tb_account` VALUES ('5', '3323', '234', null, null, null);

-- ----------------------------
-- Table structure for tb_equment
-- ----------------------------
DROP TABLE IF EXISTS `tb_equment`;
CREATE TABLE `tb_equment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `equment_name` varchar(255) DEFAULT NULL COMMENT '设备名称',
  `equment_no` varchar(100) NOT NULL COMMENT '设备编号',
  `account_name` varchar(100) DEFAULT NULL COMMENT '所属账号,accout表的username字段',
  `remark` varchar(100) DEFAULT NULL COMMENT '设备备注',
  `create_time` varchar(100) DEFAULT NULL COMMENT '创建时间',
  `equment_type` varchar(100) DEFAULT NULL COMMENT '设备类型(gps,monitoring)',
  `IP` varchar(30) DEFAULT NULL,
  `status` int(1) DEFAULT '0' COMMENT '状态(0可用1不可用)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='设备信息表';

-- ----------------------------
-- Records of tb_equment
-- ----------------------------
INSERT INTO `tb_equment` VALUES ('1', '智能手表', 'A123', 'zhangsan', null, '2017-10-01 11:11:11', '1', null, '1');
INSERT INTO `tb_equment` VALUES ('2', '智能手环', 'A456', 'zhangsan', null, '2017-10-02 11:11:11', '1', null, '1');
INSERT INTO `tb_equment` VALUES ('3', '智能水杯', 'A789', 'zhangsan', null, '2017-10-03 11:11:11', '1', null, '1');
INSERT INTO `tb_equment` VALUES ('4', '智能音箱', 'B111', 'lisi', null, '2017-10-04 11:11:11', '1', null, '1');
INSERT INTO `tb_equment` VALUES ('5', '无人机', 'C123', 'lisi', null, '2017-10-05 11:11:11', '2', null, '1');
INSERT INTO `tb_equment` VALUES ('6', '智能手表2', 'A123', 'zhangsan', '', '2017-10-06 11:11:11', '2', '', '1');
INSERT INTO `tb_equment` VALUES ('7', '智能手环2', 'A456', 'zhangsan', '', '2017-10-07 11:11:11', '2', '', '1');
INSERT INTO `tb_equment` VALUES ('8', '智能水杯2', 'A789', 'zhangsan', '', '2017-10-08 11:11:11', '3', '', '1');
INSERT INTO `tb_equment` VALUES ('9', '智能音箱2', 'B111', 'lisi', '', '2017-10-09 11:11:11', '3', '', '1');
INSERT INTO `tb_equment` VALUES ('10', '无人机2', 'C123', 'lisi', '', '2017-10-10 11:11:11', '3', '', '1');

-- ----------------------------
-- Table structure for tb_gather_log
-- ----------------------------
DROP TABLE IF EXISTS `tb_gather_log`;
CREATE TABLE `tb_gather_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `equment_no` varchar(100) DEFAULT NULL COMMENT '设备编号',
  `create_time` datetime DEFAULT NULL COMMENT '采集时间',
  `lng` varchar(100) DEFAULT NULL COMMENT '采集坐标',
  `lat` varchar(100) DEFAULT NULL COMMENT '采集坐标',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_gather_log
-- ----------------------------
INSERT INTO `tb_gather_log` VALUES ('1', 'A123', '2017-12-01 11:07:46', null, null);
INSERT INTO `tb_gather_log` VALUES ('2', 'A123', '2017-12-01 11:08:00', null, null);
INSERT INTO `tb_gather_log` VALUES ('3', 'A456', '2017-12-02 11:08:19', null, null);
INSERT INTO `tb_gather_log` VALUES ('4', 'A456', '2017-12-04 11:08:29', null, null);
INSERT INTO `tb_gather_log` VALUES ('5', 'A456', '2017-12-04 11:08:45', null, null);
INSERT INTO `tb_gather_log` VALUES ('6', 'A456', '2017-12-04 11:08:56', null, null);
INSERT INTO `tb_gather_log` VALUES ('7', 'A123', '2017-12-07 11:09:08', null, null);
INSERT INTO `tb_gather_log` VALUES ('8', 'A123', '2017-12-07 11:09:23', null, null);

-- ----------------------------
-- Table structure for tb_login_log
-- ----------------------------
DROP TABLE IF EXISTS `tb_login_log`;
CREATE TABLE `tb_login_log` (
  `login_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account_name` varchar(200) DEFAULT NULL COMMENT '登录用户',
  `login_time` datetime DEFAULT NULL COMMENT '登录时间',
  `login_ip` varchar(100) DEFAULT NULL COMMENT '登录ip',
  `lng` varchar(50) DEFAULT NULL,
  `lat` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`login_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_login_log
-- ----------------------------
