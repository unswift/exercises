/*
MySQL Data Transfer
Source Host: localhost
Source Database: exercises
Target Host: localhost
Target Database: exercises
Date: 2013/4/16 12:57:28
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for tb_group
-- ----------------------------
DROP TABLE IF EXISTS `tb_group`;
CREATE TABLE `tb_group` (
  `id` varchar(32) COLLATE utf8_bin NOT NULL,
  `name` varchar(64) COLLATE utf8_bin NOT NULL,
  `remark` text COLLATE utf8_bin,
  `role` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `value` varchar(256) COLLATE utf8_bin DEFAULT NULL,
  `fk_parent_id` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `name` (`name`),
  KEY `FKFA285D6E5393CC38` (`fk_parent_id`),
  CONSTRAINT `FKFA285D6E5393CC38` FOREIGN KEY (`fk_parent_id`) REFERENCES `tb_group` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for tb_group_resource
-- ----------------------------
DROP TABLE IF EXISTS `tb_group_resource`;
CREATE TABLE `tb_group_resource` (
  `fk_resource_id` varchar(32) COLLATE utf8_bin NOT NULL,
  `fk_group_id` varchar(32) COLLATE utf8_bin NOT NULL,
  KEY `FK898FD3BF75F2AF77` (`fk_group_id`),
  KEY `FK898FD3BF928BFBBD` (`fk_resource_id`),
  CONSTRAINT `FK898FD3BF928BFBBD` FOREIGN KEY (`fk_resource_id`) REFERENCES `tb_resource` (`id`),
  CONSTRAINT `FK898FD3BF75F2AF77` FOREIGN KEY (`fk_group_id`) REFERENCES `tb_group` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for tb_group_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_group_user`;
CREATE TABLE `tb_group_user` (
  `fk_group_id` varchar(32) COLLATE utf8_bin NOT NULL,
  `fk_user_id` varchar(32) COLLATE utf8_bin NOT NULL,
  KEY `FK92B07BFC9F3F601D` (`fk_user_id`),
  KEY `FK92B07BFC75F2AF77` (`fk_group_id`),
  CONSTRAINT `FK92B07BFC75F2AF77` FOREIGN KEY (`fk_group_id`) REFERENCES `tb_group` (`id`),
  CONSTRAINT `FK92B07BFC9F3F601D` FOREIGN KEY (`fk_user_id`) REFERENCES `tb_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for tb_resource
-- ----------------------------
DROP TABLE IF EXISTS `tb_resource`;
CREATE TABLE `tb_resource` (
  `id` varchar(32) COLLATE utf8_bin NOT NULL,
  `controller_path` varchar(512) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(64) COLLATE utf8_bin NOT NULL,
  `permission` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  `remark` text COLLATE utf8_bin,
  `sort` int(11) DEFAULT NULL,
  `type` varchar(2) COLLATE utf8_bin NOT NULL,
  `fk_parent_id` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `name` (`name`),
  UNIQUE KEY `permission` (`permission`),
  KEY `FKECCF42BF2DEE4B21` (`fk_parent_id`),
  CONSTRAINT `FKECCF42BF2DEE4B21` FOREIGN KEY (`fk_parent_id`) REFERENCES `tb_resource` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` varchar(32) COLLATE utf8_bin NOT NULL,
  `email` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(32) COLLATE utf8_bin NOT NULL,
  `realname` varchar(128) COLLATE utf8_bin NOT NULL,
  `state` int(11) NOT NULL,
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `tb_user` VALUES ('SJDK3849CKMS3849DJCK2039ZMSK0001', 'admin@exercises.com', 'admin', '系统管理员', '2', 'admin');
