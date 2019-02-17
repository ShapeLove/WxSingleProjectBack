/*
 Navicat Premium Data Transfer

 Source Server         : mymysql-v
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : 192.168.56.103:3306
 Source Schema         : singledb

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : 65001

 Date: 17/02/2019 16:26:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for attention_info
-- ----------------------------
DROP TABLE IF EXISTS `attention_info`;
CREATE TABLE `attention_info`  (
  `id` bigint(50) NOT NULL AUTO_INCREMENT,
  `attention_openid` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '关注者id',
  `attention_status` tinyint(1) NOT NULL DEFAULT 0 COMMENT '关注者状态(0:关注 默认，1：不关注）',
  `to_attention_openid` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '被关注者id',
  `to_attention_status` tinyint(1) NOT NULL DEFAULT 1 COMMENT '被关注者状态(1:不关注 默认 0：关注）',
  `ext` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '冗余字段',
  `create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `IDX_AT_TO_UNIC`(`attention_openid`, `to_attention_openid`) USING BTREE COMMENT '关注者与被关注者id确定唯一一条记录'
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of attention_info
-- ----------------------------
INSERT INTO `attention_info` VALUES (2, 'ofn5o5G3Yc8EfLjXJ9HcQ37_DI6M', 0, 'ofn5o5Dpp3qA7OD18BQpyPzhGzpM', 1, NULL, '2019-02-17 06:07:32');
INSERT INTO `attention_info` VALUES (3, 'ofn5o5Dpp3qA7OD18BQpyPzhGzpM', 0, 'ofn5o5G3Yc8EfLjXJ9HcQ37_DI6M', 1, NULL, '2019-02-17 06:07:36');

-- ----------------------------
-- Table structure for except_info
-- ----------------------------
DROP TABLE IF EXISTS `except_info`;
CREATE TABLE `except_info`  (
  `id` bigint(50) NOT NULL AUTO_INCREMENT,
  `invocation_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '异常调用方法',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间',
  `last_except_message` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '异常信息',
  `except_num` int(10) NOT NULL DEFAULT 1 COMMENT '异常次数',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `IDX_INVOICE_EXCEPT`(`invocation_name`, `last_except_message`(255)) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of except_info
-- ----------------------------
INSERT INTO `except_info` VALUES (7, 'com.shape.singleproject.util.HttpUtil#uploadFile', '2018-11-06 10:11:28', '2018-11-06 18:11:19', 'Illegal character in scheme name at index 0: 192.168.56.103:4869/upload', 2);
INSERT INTO `except_info` VALUES (8, 'com.shape.singleproject.service.UserInfoService#uploadImg', '2018-11-06 10:11:28', '2018-11-06 18:11:19', 'Illegal character in scheme name at index 0: 192.168.56.103:4869/upload', 2);
INSERT INTO `except_info` VALUES (9, 'com.shape.singleproject.service.UserInfoService#getOtherUserInfo', '2019-02-16 06:05:45', '2019-02-16 14:05:44', '未知错误', 3);

-- ----------------------------
-- Table structure for login_key
-- ----------------------------
DROP TABLE IF EXISTS `login_key`;
CREATE TABLE `login_key`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `custom_key` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `open_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `session_key` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of login_key
-- ----------------------------
INSERT INTO `login_key` VALUES (5, '234586a21b375d017ee230e09d456eae', 'ofn5o5Dpp3qA7OD18BQpyPzhGzpM', 'xCTfYBrTwsIKdPqNd7SUKw==');
INSERT INTO `login_key` VALUES (6, '20bf6dc8102bc74d1e416516a5c89642', 'ofn5o5G3Yc8EfLjXJ9HcQ37_DI6M', 'm/xYxQiAq421e5t9T7KUbA==');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` bigint(50) NOT NULL AUTO_INCREMENT COMMENT '自增标识',
  `open_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '微信唯一标识',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '昵称',
  `yn` tinyint(4) NOT NULL DEFAULT 0 COMMENT '是否有效',
  `constellation` tinyint(4) DEFAULT NULL COMMENT '星座枚举',
  `birthday` date DEFAULT NULL COMMENT '出生日期',
  `education` tinyint(4) DEFAULT NULL COMMENT '学历枚举',
  `sex` tinyint(1) DEFAULT NULL COMMENT '性别枚举',
  `province` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '籍贯省地址',
  `city` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '籍贯市地址',
  `hobby` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '爱好',
  `height` int(4) DEFAULT NULL COMMENT '身高',
  `weight` int(4) DEFAULT NULL COMMENT '体重',
  `self_evaluation` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '自我评价',
  `work_area` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '工作地区',
  `want_say` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最想说的',
  `family` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '家庭情况',
  `stand_friend` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '交友标准',
  `photos` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '个人图片',
  `department` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '部门信息',
  `status` tinyint(4) NOT NULL DEFAULT 0 COMMENT '审核状态',
  `reject_reason` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '驳回原因',
  `dongdong` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '咚咚号',
  `wx_number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '微信号',
  `create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '修改时间',
  `ext` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '冗余字段',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `IDX_OPENID`(`open_id`, `name`, `city`, `status`) USING BTREE COMMENT 'openid唯一'
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (5, 'kjdigujk2341414', '灬举个果子', 0, 0, '1996-01-20', 0, 0, '山东省', '烟台市', '吹牛逼', 155, 43, '我觉得挺好的', '北京市', '才没有', '家庭和睦', '我想廖你', '[\"24055ae9d16b57584a3861718c9222fd\",\"28753a1cdfa43a7ef616b42a15aec9c6\"]', '商家研发部-商家运营部', 1, NULL, 'sunhaipeng2', 'shpcode', '2019-02-15 15:35:02', '2018-10-08 18:17:28', NULL);
INSERT INTO `user_info` VALUES (6, 'geryerywer123124', '灬举个栗子', 0, 1, '1997-01-20', 1, 1, '黑龙江省', '大庆市', NULL, 155, 43, '我觉得挺好的', '北京市', '才没有', '家庭和睦', '我想廖你', '[\"24055ae9d16b57584a3861718c9222fd\",\"28753a1cdfa43a7ef616b42a15aec9c6\"]', '商家研发部-商家运营部', 1, NULL, 'houxinchao', 'houxinchao', '2019-02-15 15:35:07', '2018-10-11 18:17:38', NULL);
INSERT INTO `user_info` VALUES (7, 'geryerywer12312346', '灬举个栗子13', 0, 2, '1997-01-20', 1, 1, '黑龙江省', '大庆市', NULL, 155, 43, '我觉得挺好的', '北京市', '才没有', '家庭和睦', '我想廖你', '[\"24055ae9d16b57584a3861718c9222fd\",\"28753a1cdfa43a7ef616b42a15aec9c6\"]', '商家研发部-商家运营部', 1, NULL, 'houxinchao', 'houxinchao', '2019-02-15 15:35:12', '2018-10-15 22:04:23', NULL);
INSERT INTO `user_info` VALUES (14, 'ofn5o5G3Yc8EfLjXJ9HcQ37_DI6M', '举个栗子', 0, 2, '1999-12-31', 1, 1, '黑龙江省', '大庆市', NULL, 165, 45, NULL, '11', NULL, NULL, NULL, '[\"082da46e062723c6576580ee0acc46f6\"]', '111-11', 1, NULL, '11', '11', '2019-02-17 06:06:07', '2019-02-17 14:05:12', NULL);
INSERT INTO `user_info` VALUES (15, 'ofn5o5Dpp3qA7OD18BQpyPzhGzpM', '小撒瓜', 0, 0, '2000-12-31', 0, 0, '北京市', '北京市', NULL, 150, 40, NULL, '北京', NULL, NULL, NULL, '[\"a912fd753f89ed55aec3749e4e827569\"]', '搜了-log', 1, NULL, 'Shjg98', 'Suf133', '2019-02-17 06:06:22', '2019-02-17 14:05:31', NULL);

SET FOREIGN_KEY_CHECKS = 1;
