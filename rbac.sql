/*
Navicat MySQL Data Transfer

Source Server         : Mysql
Source Server Version : 80016
Source Host           : localhost:3306
Source Database       : rbac

Target Server Type    : MYSQL
Target Server Version : 80016
File Encoding         : 65001

Date: 2019-11-02 12:48:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_permission
-- ----------------------------
INSERT INTO `t_permission` VALUES ('1', '系统菜单', '0', null, 'glyphicon glyphicon-th-list');
INSERT INTO `t_permission` VALUES ('2', '控制面板', '1', null, 'glyphicon glyphicon-dashboard');
INSERT INTO `t_permission` VALUES ('3', '权限管理', '1', null, 'glyphicon glyphicon glyphicon-tasks');
INSERT INTO `t_permission` VALUES ('4', '用户维护', '3', '/user/index', 'glyphicon glyphicon-user');
INSERT INTO `t_permission` VALUES ('5', '角色维护', '3', '/role/index', 'glyphicon glyphicon-king');
INSERT INTO `t_permission` VALUES ('6', '许可维护', '3', '/permission/index', 'glyphicon glyphicon-lock');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', 'PM-项目经理');
INSERT INTO `t_role` VALUES ('2', 'SE软件工程师');
INSERT INTO `t_role` VALUES ('3', 'PG-程序员');
INSERT INTO `t_role` VALUES ('4', 'TL-组长');
INSERT INTO `t_role` VALUES ('5', 'GL-组长');
INSERT INTO `t_role` VALUES ('6', 'QC-品质控制');
INSERT INTO `t_role` VALUES ('7', 'SA-软件架构师');
INSERT INTO `t_role` VALUES ('8', 'CMO/CMS-配置管理员');
INSERT INTO `t_role` VALUES ('9', 'SYSTEM-系统管理员');

-- ----------------------------
-- Table structure for t_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleid` int(11) DEFAULT NULL,
  `permissionid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_permission
-- ----------------------------
INSERT INTO `t_role_permission` VALUES ('34', '9', '1');
INSERT INTO `t_role_permission` VALUES ('35', '9', '2');
INSERT INTO `t_role_permission` VALUES ('36', '9', '3');
INSERT INTO `t_role_permission` VALUES ('37', '9', '4');
INSERT INTO `t_role_permission` VALUES ('38', '9', '5');
INSERT INTO `t_role_permission` VALUES ('39', '9', '6');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `loginacct` varchar(255) DEFAULT NULL,
  `userpswd` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `createtime` char(19) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('5', 'zhangsan', 'zhangsan', 'zhangsan', 'zhangsan@qq.com', '2019-10-31 15:18:56');
INSERT INTO `t_user` VALUES ('6', '黎滕', '令狐冲', '123456', '1377981923@qq.com', '2019-11-01 21:19:12');
INSERT INTO `t_user` VALUES ('7', 'lisi', 'lisi', '123456', '1377981923@qq.com', '2019-11-01 21:37:07');

-- ----------------------------
-- Table structure for t_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `roleid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('1', '5', '9');
INSERT INTO `t_user_role` VALUES ('53', '5', '1');
INSERT INTO `t_user_role` VALUES ('54', '5', '2');
INSERT INTO `t_user_role` VALUES ('55', '5', '3');
INSERT INTO `t_user_role` VALUES ('56', '5', '4');
INSERT INTO `t_user_role` VALUES ('57', '5', '5');
INSERT INTO `t_user_role` VALUES ('58', '5', '6');
INSERT INTO `t_user_role` VALUES ('59', '5', '7');
INSERT INTO `t_user_role` VALUES ('60', '5', '8');
INSERT INTO `t_user_role` VALUES ('61', '6', '9');
