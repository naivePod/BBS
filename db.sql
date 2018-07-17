/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50523
Source Host           : localhost:3306
Source Database       : db

Target Server Type    : MYSQL
Target Server Version : 50523
File Encoding         : 65001

Date: 2018-07-17 16:28:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `Article_id` int(11) NOT NULL AUTO_INCREMENT,
  `User_id` int(11) NOT NULL,
  `Title_Content` varchar(15) NOT NULL,
  `Article_Content` text NOT NULL,
  `Title_Time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`Article_id`),
  KEY `Article_userid_User_idx` (`User_id`),
  CONSTRAINT `Article_userid_User` FOREIGN KEY (`User_id`) REFERENCES `user` (`User_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('16', '1', 'dsf', 'asdaasd', '2018-01-12 17:39:31');
INSERT INTO `article` VALUES ('17', '1', 'sad', 'asdasd', '2018-01-13 16:36:31');
INSERT INTO `article` VALUES ('19', '3', 'test', 'test', '2018-01-13 19:53:01');
INSERT INTO `article` VALUES ('20', '3', 'test111', 'sdfsd', '2018-01-14 20:44:19');
INSERT INTO `article` VALUES ('21', '3', 'hello world', 'hi', '2018-01-14 20:45:21');
INSERT INTO `article` VALUES ('22', '3', '明天回家', '不过还有需求分析课设', '2018-01-14 20:46:00');
INSERT INTO `article` VALUES ('23', '1', 'hello', 'hello', '2018-01-14 22:06:13');
INSERT INTO `article` VALUES ('24', '1', 'qw', 'asdasdasd', '2018-01-15 09:16:21');
INSERT INTO `article` VALUES ('25', '1', '好慌', '怎么办', '2018-01-15 09:28:56');

-- ----------------------------
-- Table structure for reply
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply` (
  `Reply_id` int(11) NOT NULL AUTO_INCREMENT,
  `User_id` int(11) NOT NULL,
  `Article_id` int(11) NOT NULL,
  `Floor` int(11) NOT NULL,
  `ReplyContent` text NOT NULL,
  `ReplyTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`Reply_id`),
  KEY `Reply_userid_User_idx` (`User_id`),
  KEY `Reply_article_Article_idx` (`Article_id`),
  CONSTRAINT `Reply_article_Article` FOREIGN KEY (`Article_id`) REFERENCES `article` (`Article_id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `Reply_userid_User` FOREIGN KEY (`User_id`) REFERENCES `user` (`User_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reply
-- ----------------------------
INSERT INTO `reply` VALUES ('10', '1', '16', '1', 'asdaasd', '2018-01-12 17:39:31');
INSERT INTO `reply` VALUES ('11', '1', '16', '1', 't123', '2018-01-12 20:31:45');
INSERT INTO `reply` VALUES ('16', '1', '17', '1', 'asdasd', '2018-01-13 16:36:31');
INSERT INTO `reply` VALUES ('18', '1', '16', '3', 'qweqwe', '2018-01-13 16:37:14');
INSERT INTO `reply` VALUES ('20', '3', '19', '1', 'test', '2018-01-13 19:53:01');
INSERT INTO `reply` VALUES ('21', '1', '19', '2', 'asdsa', '2018-01-13 21:34:40');
INSERT INTO `reply` VALUES ('22', '1', '17', '2', '= .=', '2018-01-14 19:18:31');
INSERT INTO `reply` VALUES ('23', '3', '20', '1', 'sdfsd', '2018-01-14 20:44:19');
INSERT INTO `reply` VALUES ('24', '3', '19', '3', 'sdfdsfsag', '2018-01-14 20:44:38');
INSERT INTO `reply` VALUES ('25', '3', '21', '1', 'hi', '2018-01-14 20:45:21');
INSERT INTO `reply` VALUES ('26', '3', '22', '1', '不过还有需求分析课设', '2018-01-14 20:46:00');
INSERT INTO `reply` VALUES ('27', '1', '23', '1', 'hello', '2018-01-14 22:06:13');
INSERT INTO `reply` VALUES ('28', '1', '24', '1', 'asdasdasd', '2018-01-15 09:16:21');
INSERT INTO `reply` VALUES ('29', '1', '23', '2', 'asddsa', '2018-01-15 09:16:51');
INSERT INTO `reply` VALUES ('30', '1', '25', '1', '怎么办', '2018-01-15 09:28:56');
INSERT INTO `reply` VALUES ('31', '1', '19', '4', 'test', '2018-01-15 09:29:08');

-- ----------------------------
-- Table structure for top
-- ----------------------------
DROP TABLE IF EXISTS `top`;
CREATE TABLE `top` (
  `Article_id` int(11) NOT NULL,
  `Aid` int(11) NOT NULL,
  `Ttime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`Article_id`),
  KEY `top_Aid_admin_idx` (`Aid`),
  CONSTRAINT `top_Aid_admin` FOREIGN KEY (`Aid`) REFERENCES `user` (`User_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `top_Article_id_article` FOREIGN KEY (`Article_id`) REFERENCES `article` (`Article_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of top
-- ----------------------------
INSERT INTO `top` VALUES ('23', '3', '2018-01-15 09:17:25');
INSERT INTO `top` VALUES ('24', '3', '2018-01-15 09:17:25');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `User_id` int(11) NOT NULL AUTO_INCREMENT,
  `UserName` varchar(12) NOT NULL,
  `Psw` varchar(12) NOT NULL,
  `Email` varchar(20) DEFAULT NULL,
  `Birth` varchar(10) DEFAULT NULL,
  `role` int(1) DEFAULT NULL,
  `create_time` date DEFAULT NULL,
  `last_update_time` date DEFAULT NULL,
  PRIMARY KEY (`User_id`),
  UNIQUE KEY `UserName_UNIQUE` (`UserName`),
  KEY `username_index` (`UserName`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'Tom', 'qw123456', null, null, null, null, null);
INSERT INTO `user` VALUES ('2', 'Mark', 'www123456', null, null, null, null, null);
INSERT INTO `user` VALUES ('3', 'admin', 'admin', null, null, null, null, null);
INSERT INTO `user` VALUES ('5', 'test', '123456', null, null, null, null, null);
INSERT INTO `user` VALUES ('6', 'test1', '123456', null, null, null, null, null);
INSERT INTO `user` VALUES ('7', 'test2', '123456', null, null, null, null, null);
INSERT INTO `user` VALUES ('8', 'test3', '123456', null, null, null, null, null);

-- ----------------------------
-- View structure for user_view
-- ----------------------------
DROP VIEW IF EXISTS `user_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `user_view` AS (select `user`.`User_id` AS `User_id`,`user`.`UserName` AS `UserName`,`user`.`Email` AS `Email`,`user`.`Birth` AS `Birth`,count(`a`.`User_id`) AS `num` from (`user` left join `article` `a` on((`user`.`User_id` = `a`.`User_id`))) group by `user`.`User_id`) ; ;
DROP TRIGGER IF EXISTS `insert_reply`;
DELIMITER ;;
CREATE TRIGGER `insert_reply` AFTER INSERT ON `article` FOR EACH ROW begin

	insert into reply(User_id,Article_id,Floor,ReplyContent) values(new.User_id, new.Article_id, 1, new.Article_Content);
end
;;
DELIMITER ;
