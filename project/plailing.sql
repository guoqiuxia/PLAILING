/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50506
Source Host           : localhost:3306
Source Database       : plailing

Target Server Type    : MYSQL
Target Server Version : 50506
File Encoding         : 65001

Date: 2019-01-01 21:19:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tbl_administrator`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_administrator`;
CREATE TABLE `tbl_administrator` (
  `adminId` int(11) NOT NULL AUTO_INCREMENT,
  `adminName` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`adminId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tbl_administrator
-- ----------------------------
INSERT INTO `tbl_administrator` VALUES ('1', 'liangyaru', '123');
INSERT INTO `tbl_administrator` VALUES ('2', 'liushanshan', '123');
INSERT INTO `tbl_administrator` VALUES ('3', 'guoqiuxia', '123');

-- ----------------------------
-- Table structure for `tbl_applicationsite`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_applicationsite`;
CREATE TABLE `tbl_applicationsite` (
  `siteId` int(11) NOT NULL AUTO_INCREMENT,
  `siteType` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `useTime` datetime DEFAULT NULL,
  `useLang` int(11) DEFAULT NULL,
  `applicationTime` datetime DEFAULT NULL,
  `courseId` int(11) DEFAULT NULL,
  PRIMARY KEY (`siteId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tbl_applicationsite
-- ----------------------------
INSERT INTO `tbl_applicationsite` VALUES ('1', '公教楼', '2019-01-02 10:10:21', '2', '2018-12-29 21:30:21', '22');
INSERT INTO `tbl_applicationsite` VALUES ('2', '公教楼', '2019-01-05 10:10:46', '3', '2018-12-29 21:30:46', '23');

-- ----------------------------
-- Table structure for `tbl_auditing`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_auditing`;
CREATE TABLE `tbl_auditing` (
  `auditingId` int(11) NOT NULL AUTO_INCREMENT,
  `personalInfo` varchar(2048) CHARACTER SET utf8 DEFAULT NULL,
  `identityPic` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `teachVideo` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `certificate` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `checkState` int(11) DEFAULT NULL,
  `adminId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`auditingId`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tbl_auditing
-- ----------------------------
INSERT INTO `tbl_auditing` VALUES ('1', '我是大佬', 'img/0824ab18972bd407910.jpg', null, 'img/0373f8d56fa1e0032f1.jpg', '0', null, '1');
INSERT INTO `tbl_auditing` VALUES ('2', '我是大佬', 'img/4040.png', null, 'img/4041.png', '0', null, '1');
INSERT INTO `tbl_auditing` VALUES ('3', '我是大佬', 'img/4040.png', null, 'img/4041.png', '0', null, '2');
INSERT INTO `tbl_auditing` VALUES ('4', '我是大佬', 'img/4040.png', null, 'img/4041.png', '0', null, '2');
INSERT INTO `tbl_auditing` VALUES ('5', '我是大佬', 'img/4040.png', null, 'img/4041.png', '0', null, '2');
INSERT INTO `tbl_auditing` VALUES ('6', '我是大佬', 'img/4040.png', null, 'img/4041.png', '0', null, '3');
INSERT INTO `tbl_auditing` VALUES ('7', '我是大佬', 'img/4040.png', null, 'img/4041.png', '0', null, '3');
INSERT INTO `tbl_auditing` VALUES ('8', '我是大佬', 'img/4040.png', null, 'img/4041.png', '0', null, '3');
INSERT INTO `tbl_auditing` VALUES ('9', '我是大佬', 'img/4040.png', null, 'img/4041.png', '0', null, '4');
INSERT INTO `tbl_auditing` VALUES ('10', '我是大佬', 'img/4040.png', null, 'img/4041.png', '0', null, '4');
INSERT INTO `tbl_auditing` VALUES ('11', '我是大佬', 'img/4040.png', null, 'img/4041.png', '0', null, '3');
INSERT INTO `tbl_auditing` VALUES ('12', '我是大佬', 'img/4040.png', null, 'img/4041.png', '0', null, '3');
INSERT INTO `tbl_auditing` VALUES ('13', '我是大佬', 'img/check/course10.jpg', null, 'img/check/course11.jpg', '0', null, '1');
INSERT INTO `tbl_auditing` VALUES ('14', '我是大佬', 'img/check/course60.jpg', null, 'img/check/course61.jpg', '0', null, '1');
INSERT INTO `tbl_auditing` VALUES ('15', '我是大佬', 'img/check/course70.jpg', null, 'img/check/course71.jpg', '0', null, '1');
INSERT INTO `tbl_auditing` VALUES ('16', '我是大佬', 'img/check/course270.jpg', null, 'img/check/course271.jpg', '0', null, '5');
INSERT INTO `tbl_auditing` VALUES ('17', '我是大佬', 'img/check/course280.jpg', null, 'img/check/course281.jpg', '0', null, '5');
INSERT INTO `tbl_auditing` VALUES ('18', '我是大佬', 'img/check/course290.jpg', null, 'img/check/course291.jpg', '0', null, '5');
INSERT INTO `tbl_auditing` VALUES ('19', '我是大佬', 'img/check/course300.jpg', null, 'img/check/course301.jpg', '0', null, '5');
INSERT INTO `tbl_auditing` VALUES ('20', '我是大佬', 'img/check/course310.png', null, 'img/check/course311.png', '0', null, '5');
INSERT INTO `tbl_auditing` VALUES ('21', '我是大佬', 'img/check/course310.jpg', null, 'img/check/course311.jpg', '0', null, '5');
INSERT INTO `tbl_auditing` VALUES ('22', '我是大佬', 'img/check/course330.jpg', null, 'img/check/course331.jpg', '0', null, '6');
INSERT INTO `tbl_auditing` VALUES ('23', '我是大佬', 'img/check/course340.jpg', null, 'img/check/course341.jpg', '0', null, '6');
INSERT INTO `tbl_auditing` VALUES ('24', '我是大佬', 'img/check/course360.png', null, 'img/check/course361.png', '0', null, '6');
INSERT INTO `tbl_auditing` VALUES ('25', '我是大佬', 'img/check/course350.jpg', null, 'img/check/course351.jpg', '0', null, '6');
INSERT INTO `tbl_auditing` VALUES ('26', '我是大佬', 'img/check/course370.jpg', null, 'img/check/course371.jpg', '0', null, '7');
INSERT INTO `tbl_auditing` VALUES ('27', '我是大佬', 'img/check/course380.jpg', null, 'img/check/course381.jpg', '0', null, '7');
INSERT INTO `tbl_auditing` VALUES ('28', '我是大佬', 'img/check/course390.jpg', null, 'img/check/course391.jpg', '0', null, '7');
INSERT INTO `tbl_auditing` VALUES ('29', '我是大佬', 'img/check/course400.jpg', null, 'img/check/course401.jpg', '0', null, '7');

-- ----------------------------
-- Table structure for `tbl_comment`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_comment`;
CREATE TABLE `tbl_comment` (
  `commentId` int(11) NOT NULL AUTO_INCREMENT,
  `text` varchar(1024) CHARACTER SET utf8 DEFAULT NULL,
  `commentTime` datetime DEFAULT NULL,
  `pId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `catalogId` int(11) DEFAULT NULL,
  `top` int(11) DEFAULT NULL,
  PRIMARY KEY (`commentId`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tbl_comment
-- ----------------------------
INSERT INTO `tbl_comment` VALUES ('1', '这个章节处于哪个阶段，初级、中级或高级', '2018-12-29 22:39:43', null, '2', '2', '0');
INSERT INTO `tbl_comment` VALUES ('2', '这个课程将的知识点的用处不是特别大', '2018-12-29 22:40:34', null, '4', '2', '0');
INSERT INTO `tbl_comment` VALUES ('3', '也不能说用处不大就是不会用，但是你要懂这些知识才可以进行下面的操作', '2018-12-29 22:46:18', null, '2', '2', '0');
INSERT INTO `tbl_comment` VALUES ('4', '我觉得这个课程挺有趣的', '2018-12-29 22:49:01', null, '1', '2', '0');
INSERT INTO `tbl_comment` VALUES ('5', '我挺喜欢这个课程', '2018-12-29 22:49:16', null, '8', '2', '0');
INSERT INTO `tbl_comment` VALUES ('6', '我觉得用处挺大的', '2018-12-29 22:50:47', '3', '4', '2', '3');
INSERT INTO `tbl_comment` VALUES ('7', '你们都觉得这个课程怎么样', '2018-12-29 22:51:16', null, '8', '2', '0');
INSERT INTO `tbl_comment` VALUES ('8', '初级吧', '2018-12-29 22:51:30', '1', '6', '2', '1');
INSERT INTO `tbl_comment` VALUES ('9', '我觉得挺有用的', '2018-12-29 22:51:46', '2', '8', '2', '2');
INSERT INTO `tbl_comment` VALUES ('10', '这个折纸第一节很好玩', '2018-12-29 22:53:08', null, '7', '2', '0');
INSERT INTO `tbl_comment` VALUES ('11', '我觉得这个折纸能够让我定下心来', '2018-12-29 22:54:12', null, '3', '2', '0');
INSERT INTO `tbl_comment` VALUES ('12', '我觉得这个老师十分的有趣', '2018-12-29 22:55:44', null, '3', '2', '0');
INSERT INTO `tbl_comment` VALUES ('13', '我好喜欢这个老师啊', '2018-12-29 22:55:47', null, '5', '2', '0');
INSERT INTO `tbl_comment` VALUES ('14', '我觉得这个章节很好学', '2018-12-29 22:57:38', null, '9', '2', '0');

-- ----------------------------
-- Table structure for `tbl_course`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_course`;
CREATE TABLE `tbl_course` (
  `courseId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `photo` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  `price` double(30,0) DEFAULT NULL,
  `courseInfo` varchar(1024) CHARACTER SET utf8 DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `grade` double(11,2) DEFAULT NULL,
  `typeId` int(11) DEFAULT NULL,
  `joinCount` int(10) unsigned zerofill DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `demandId` int(11) DEFAULT NULL,
  PRIMARY KEY (`courseId`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tbl_course
-- ----------------------------
INSERT INTO `tbl_course` VALUES ('1', 'javaEE实战入门', 'img/check/course82.jpg', '199', '本课程基于任务驱动的场景教学⽅法,传授主流的互联⽹开发技术及Spring Boot、Hibernate等框架技术,分阶段循序渐进的逐步引导学员了解和掌握企业级的JavaEE项目开发知识。', '1', '0.00', '30', '0000000000', '1', '1');
INSERT INTO `tbl_course` VALUES ('2', 'C/C++入门到精通', 'img/check/course172.jpg', '0', '本课程需要有基本的c语言基础，目标是希望通过学习，让我们对c++语言有一个比较全面的掌握。', '1', '0.00', '30', '0000000000', '1', '2');
INSERT INTO `tbl_course` VALUES ('3', 'H5基础课程', 'img/check/course152.jpg', '30', '从零基础起步开始HTML的学习，本套课程全部用最为通俗的语言对所有的专业术语进行讲解分析。', '2', '0.00', '30', '0000000003', '1', '3');
INSERT INTO `tbl_course` VALUES ('4', 'jQuery视频教程', 'img/check/course142.jpg', '99', 'jQuery是一个快速、简洁的JavaScript框架。它封装JavaScript常用的功能代码，提供一种简便的JavaScript设计模式，优化HTML文档操作、事件处理、动画设计和Ajax交互。 ', '2', '0.00', '30', '0000000000', '1', '4');
INSERT INTO `tbl_course` VALUES ('5', 'PS简易教程', 'img/check/8d0bafa6b29aa4a0cd2.jpg', '35', '本课程主讲产品精修、海报设计、主图/详情页设计、店铺装修，为美工新手、美工就业/从业人员首选，适合PS基础薄弱、缺乏设计思路、色彩搭配的学员。', '2', '0.00', '13', '0000000000', '1', '5');
INSERT INTO `tbl_course` VALUES ('6', '折纸手工教学', 'img/check/折纸2.jpg', '10', '即使是折纸的新手也可以轻松的跟随折纸视频的讲解完成相关手工折纸的创作，可以让我们轻松完成多种样式的有趣折纸制作。', '3', '3.50', '60', '0000000006', '1', '7');
INSERT INTO `tbl_course` VALUES ('7', '毛笔字教学', 'img/check/d59212776f5c0a58772.jpg', '60', '书法是中国传统文化艺术发展五千年来最具有经典标志的民族符号。它是用毛笔书写汉字并具有审美惯性的艺术形式。此课程主要包括偏旁部首的基本要领、基本字的写法等的学习。', '4', '0.00', '63', '0000000000', '1', '6');
INSERT INTO `tbl_course` VALUES ('8', '古筝考级教学', 'img/check/slider42.jpg', '20', '本套教材虽然不是音乐艺术院校的教学大纲，但结合古筝这件乐器自身的特点，本着传统民间乐曲与现代创编作品并重的理念，每一级里都较为充分地体现了对这两方面的考量，亦使考级方式更为灵活、更易操作。', '4', '0.00', '24', '0000000000', '1', '8');
INSERT INTO `tbl_course` VALUES ('9', '计算机组成原理', 'img/check/356 (1)2.jpg', '10', '结合老师上课讲的内容加上自己自己的理解，对本课程做了通俗易懂的讲解，适合基础薄弱的同学进行学习。', '3', '0.00', '29', '0000000000', '1', '9');
INSERT INTO `tbl_course` VALUES ('10', '数据结构', 'img/check/3562.jpg', '10', '结合老师上课讲的内容加上自己自己的理解，对本课程做了通俗易懂的讲解，适合基础薄弱的同学进行学习。', '3', '0.00', '29', '0000000000', '1', '10');
INSERT INTO `tbl_course` VALUES ('11', '果酒制作', 'img/check/course12.jpg', '30', '果酒使用水果的糖分发酵成酒精的酒，含有水果的风味与酒精。如青梅酒，葡萄酒等等。果酒酒香浓郁，回味无穷。', '1', '0.00', '61', '0000000000', '1', '11');
INSERT INTO `tbl_course` VALUES ('12', '形象设计', 'img/check/course62.jpg', '20', '零基础学习穿衣打扮，做自己的形象管理专家！', '1', '0.00', '65', '0000000000', '1', '1');
INSERT INTO `tbl_course` VALUES ('13', '时间管理术', 'img/check/course72.jpg', '60', '	掌控碎片时间-时间管理术', '1', '0.00', '65', '0000000000', '1', null);
INSERT INTO `tbl_course` VALUES ('14', '人像摄影高手训练营', 'img/check/course272.jpg', '99', '分享自己的摄像机摄影经验，让更多人能发现生活的美，完成心灵的改变。', '5', '0.00', '10', '0000000001', '1', null);
INSERT INTO `tbl_course` VALUES ('15', '手机摄影', 'img/check/course282.jpg', '99', '分享自己的手机摄影经验，让更多人能发现生活的美，完成心灵的改变。', '5', '0.00', '13', '0000000000', '1', '3');
INSERT INTO `tbl_course` VALUES ('16', 'logo设计', 'img/check/course292.jpg', '100', 'LOGO设计是一门综合基础知识的高级课程，希望大家在学习的过程中，必须掌握基本知识，发挥自己的创意和遵守规则的前提下去设计出符合实际以及企业需求的', '5', '0.00', '15', '0000000000', '1', '4');
INSERT INTO `tbl_course` VALUES ('17', '数字图形创意设计', 'img/check/course302.jpg', '100', '本课程结合AI软件的实际用途，按照系统、实用、易学、易用的要求，详细介绍了软件回执图形的方法，涉及AI的基本操纵，基本图形的回执、编辑与组织，图形高级回执效果，图层与蒙版的介绍等。', '5', '0.00', '15', '0000000000', '1', '6');
INSERT INTO `tbl_course` VALUES ('18', '和声魔改', 'img/check/course312.png', '100', '通过季风流行钢琴魔改手法，改变一首歌的和声。', '5', '0.00', '24', '0000000000', '1', '7');
INSERT INTO `tbl_course` VALUES ('19', '吉他教学', 'img/check/course312.jpg', '100', '非洲鼓（Djembe） 流行歌曲伴奏系列教程，零基础教学，快速上手。难度星级分类，每首歌曲提供不同难度的学习内容，轻松学会。更多课程，请关注鼎声打击乐节奏教室。', '5', '0.00', '24', '0000000000', '1', '8');
INSERT INTO `tbl_course` VALUES ('20', '28天健康减肥法', 'img/check/course332.jpg', '100', '28天健康减肥法，以运动与饮食指导来影响身体体重变化的系统性方法，坚持28天，就会见到好的结果！对于某些减肥指导性内容，可进行增补。用健康且正确适合的方法，帮助减肥！', '6', '0.00', '37', '0000000000', '1', '3');
INSERT INTO `tbl_course` VALUES ('21', '办公室瑜伽', 'img/check/course342.jpg', '100', '长期坐办公室腰椎，肩颈不舒服的人，特别适合练习这几个动作。', '6', '0.00', '38', '0000000000', '1', '10');
INSERT INTO `tbl_course` VALUES ('22', '法语入门', 'img/check/course362.png', '100', '针对法语零基础，4节课学会法语字母和音素发音，还有法语简单日常对话学习及法语歌曲电影推荐赏析。学会法语字母及音素发音，掌握法语发音规则和技巧，从而拥有见到法语可以自然拼读的能力。', '6', '0.00', '43', '0000000000', '1', '5');
INSERT INTO `tbl_course` VALUES ('23', '学习韩语', 'img/check/course352.jpg', '100', '语言通常来源于生活之中，口语是学习任何一门语言的最高境界，所以学习韩语也是同样的。学习日常生活中的常用语，希望对大家口语提升有所帮助。', '6', '0.00', '48', '0000000000', '1', '6');
INSERT INTO `tbl_course` VALUES ('24', 'office', 'img/check/course372.jpg', '20', '从零基础学习PPT2016幻灯片的使用方法', '7', '0.00', '51', '0000000000', '1', '4');
INSERT INTO `tbl_course` VALUES ('25', 'word', 'img/check/course382.jpg', '20', '对Word功能进行系统、专业的讲解。内容：公文段落编辑规范、图文混排规范、精美表格/图片设计、流程/结构图设计、长文档排版技巧、页眉/页脚设计、邮件合并、文档自动化技术等，并放送大量独家操作经验和技巧', '7', '0.00', '51', '0000000000', '1', null);
INSERT INTO `tbl_course` VALUES ('26', 'Web安全微专业公开课', 'img/check/course392.jpg', '100', 'Web安全微专业导读篇。课程以配备了实战靶场环境、社区资源配套及课程咨询和技术解答，帮助大家了解并学习网络安全，传授黑白帽实战技能，带领零基础小白正式踏入入门阶段。\r\n', '7', '0.00', '67', '0000000000', '1', null);
INSERT INTO `tbl_course` VALUES ('27', '面试公开课', 'img/check/course402.jpg', '100', '教师资格证面试完整流程+结构化面试训练+面试技巧指导+面试礼仪讲解+面试评分标准等系列课程，让你全面了解教师资格证面试考试。\r\n', '7', '0.00', '72', '0000000000', '1', null);

-- ----------------------------
-- Table structure for `tbl_coursecatalog`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_coursecatalog`;
CREATE TABLE `tbl_coursecatalog` (
  `catalogId` int(11) NOT NULL AUTO_INCREMENT,
  `catalogName` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `pId` int(30) DEFAULT NULL,
  `courseId` int(11) DEFAULT NULL,
  `courseFile` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`catalogId`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tbl_coursecatalog
-- ----------------------------
INSERT INTO `tbl_coursecatalog` VALUES ('1', '第一章  基础课程', null, '6', null);
INSERT INTO `tbl_coursecatalog` VALUES ('2', '中国结的简易折法', '1', '6', 'videoes\\weixinjsqz11.mp4');
INSERT INTO `tbl_coursecatalog` VALUES ('3', 'H5基础第一节', null, '3', null);
INSERT INTO `tbl_coursecatalog` VALUES ('4', 'H5基础视频', '3', '3', 'videoes\\H5基础视频.mp4');
INSERT INTO `tbl_coursecatalog` VALUES ('5', '人像摄影基础', null, '14', null);
INSERT INTO `tbl_coursecatalog` VALUES ('6', '人像摄影', '5', '14', 'videoes\\人像摄影.mp4');
INSERT INTO `tbl_coursecatalog` VALUES ('7', 'logo设计基础', null, '16', null);
INSERT INTO `tbl_coursecatalog` VALUES ('8', 'logo设计', '7', '16', 'videoes\\logo设计.mp4');
INSERT INTO `tbl_coursecatalog` VALUES ('9', '和声魔改基础', null, '18', null);
INSERT INTO `tbl_coursecatalog` VALUES ('10', '和声魔改', '9', '18', 'videoes\\和声魔改.mp4');
INSERT INTO `tbl_coursecatalog` VALUES ('11', '减肥瘦身基础', null, '20', null);
INSERT INTO `tbl_coursecatalog` VALUES ('12', '减肥瘦身', '11', '20', 'videoes\\减肥瘦身1.mp4');
INSERT INTO `tbl_coursecatalog` VALUES ('13', '法语基础', null, '22', null);
INSERT INTO `tbl_coursecatalog` VALUES ('14', '法语', '13', '22', 'videoes\\法语1.mp4');
INSERT INTO `tbl_coursecatalog` VALUES ('15', 'office基础', null, '24', null);
INSERT INTO `tbl_coursecatalog` VALUES ('16', 'office', '15', '24', 'videoes\\office1.mp4');
INSERT INTO `tbl_coursecatalog` VALUES ('17', '面试基础', null, '27', null);
INSERT INTO `tbl_coursecatalog` VALUES ('18', '面试', '17', '27', 'videoes\\面试1.mp4');
INSERT INTO `tbl_coursecatalog` VALUES ('19', '毛笔字的初级教学', null, '7', null);
INSERT INTO `tbl_coursecatalog` VALUES ('20', ' 毛笔字的初级教学', '19', '7', 'videoes\\weixinjsqz11.mp4');
INSERT INTO `tbl_coursecatalog` VALUES ('21', 'javaEE实战入门', null, '1', null);
INSERT INTO `tbl_coursecatalog` VALUES ('22', 'javaEE实战入门', '21', '1', 'videoes\\weixinjsqz11.mp4');

-- ----------------------------
-- Table structure for `tbl_coursecomment`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_coursecomment`;
CREATE TABLE `tbl_coursecomment` (
  `courseCommentId` int(11) NOT NULL AUTO_INCREMENT,
  `text` varchar(200) DEFAULT NULL,
  `commentTime` datetime DEFAULT NULL,
  `courseCommentPid` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `courseId` int(11) DEFAULT NULL,
  `top` int(11) DEFAULT NULL,
  PRIMARY KEY (`courseCommentId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_coursecomment
-- ----------------------------
INSERT INTO `tbl_coursecomment` VALUES ('1', '这个折纸非常的有趣', '2018-12-29 21:32:05', null, '6', '6', '0');
INSERT INTO `tbl_coursecomment` VALUES ('2', '这个课程十分的好学', '2018-12-29 21:33:02', null, '6', '6', '0');
INSERT INTO `tbl_coursecomment` VALUES ('3', '这个课程的教学课程比较缓慢，容易跟上操作', '2018-12-29 21:56:05', null, '7', '6', '0');
INSERT INTO `tbl_coursecomment` VALUES ('4', '我也是十分喜欢这个课程', '2018-12-29 22:04:18', null, '1', '6', '0');
INSERT INTO `tbl_coursecomment` VALUES ('5', '我也觉得可以跟上操作', '2018-12-29 22:05:04', '3', '1', '6', '3');
INSERT INTO `tbl_coursecomment` VALUES ('6', '嗯嗯，我也这么觉得', '2018-12-29 22:05:38', '2', '1', '6', '2');
INSERT INTO `tbl_coursecomment` VALUES ('7', '是的，十分有趣', '2018-12-29 22:05:52', '1', '1', '6', '1');
INSERT INTO `tbl_coursecomment` VALUES ('8', '我觉得这个课程非常好', '2018-12-29 22:08:31', null, '2', '6', '0');
INSERT INTO `tbl_coursecomment` VALUES ('9', '这个课程真的非常的好，重要的事情说两遍', '2018-12-29 22:08:55', null, '2', '6', '0');
INSERT INTO `tbl_coursecomment` VALUES ('10', '这个课程有什么特色我没有看出来吗，为什么你这么的喜欢', '2018-12-29 22:10:33', '4', '2', '6', '4');

-- ----------------------------
-- Table structure for `tbl_coursetype`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_coursetype`;
CREATE TABLE `tbl_coursetype` (
  `typeId` int(11) NOT NULL AUTO_INCREMENT,
  `typeName` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `pTypeId` int(11) DEFAULT NULL,
  PRIMARY KEY (`typeId`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tbl_coursetype
-- ----------------------------
INSERT INTO `tbl_coursetype` VALUES ('1', '摄影技术', null);
INSERT INTO `tbl_coursetype` VALUES ('2', '创意设计', null);
INSERT INTO `tbl_coursetype` VALUES ('3', '声乐器乐', null);
INSERT INTO `tbl_coursetype` VALUES ('4', 'IT互联网', null);
INSERT INTO `tbl_coursetype` VALUES ('5', '运动健身', null);
INSERT INTO `tbl_coursetype` VALUES ('6', '语言学习', null);
INSERT INTO `tbl_coursetype` VALUES ('7', '职场技能', null);
INSERT INTO `tbl_coursetype` VALUES ('8', '生活意趣', null);
INSERT INTO `tbl_coursetype` VALUES ('9', '公开课', null);
INSERT INTO `tbl_coursetype` VALUES ('10', '人像', '1');
INSERT INTO `tbl_coursetype` VALUES ('11', '风光', '1');
INSERT INTO `tbl_coursetype` VALUES ('12', '产品', '1');
INSERT INTO `tbl_coursetype` VALUES ('13', '后期处理', '1');
INSERT INTO `tbl_coursetype` VALUES ('14', '摄影基础', '1');
INSERT INTO `tbl_coursetype` VALUES ('15', '平面设计', '2');
INSERT INTO `tbl_coursetype` VALUES ('16', 'UI设计', '2');
INSERT INTO `tbl_coursetype` VALUES ('17', '影视设计', '2');
INSERT INTO `tbl_coursetype` VALUES ('18', '动漫插画', '2');
INSERT INTO `tbl_coursetype` VALUES ('19', '分支主题', '2');
INSERT INTO `tbl_coursetype` VALUES ('20', '网页设计', '2');
INSERT INTO `tbl_coursetype` VALUES ('21', '室内设计', '2');
INSERT INTO `tbl_coursetype` VALUES ('22', '服装设计', '2');
INSERT INTO `tbl_coursetype` VALUES ('23', '乐理知识', '3');
INSERT INTO `tbl_coursetype` VALUES ('24', '声乐教程', '3');
INSERT INTO `tbl_coursetype` VALUES ('25', '创作软件', '3');
INSERT INTO `tbl_coursetype` VALUES ('26', '传统民族乐器', '3');
INSERT INTO `tbl_coursetype` VALUES ('27', '西洋管弦乐', '3');
INSERT INTO `tbl_coursetype` VALUES ('28', '打击乐器', '3');
INSERT INTO `tbl_coursetype` VALUES ('29', '计算机基础', '4');
INSERT INTO `tbl_coursetype` VALUES ('30', '编程语言', '4');
INSERT INTO `tbl_coursetype` VALUES ('31', '系统运维', '4');
INSERT INTO `tbl_coursetype` VALUES ('32', '移动开发', '4');
INSERT INTO `tbl_coursetype` VALUES ('33', '互联网产品', '4');
INSERT INTO `tbl_coursetype` VALUES ('34', '其他技术', '4');
INSERT INTO `tbl_coursetype` VALUES ('35', '球类运动', '5');
INSERT INTO `tbl_coursetype` VALUES ('36', '搏击运动', '5');
INSERT INTO `tbl_coursetype` VALUES ('37', '减肥瘦身', '5');
INSERT INTO `tbl_coursetype` VALUES ('38', '增肌塑形', '5');
INSERT INTO `tbl_coursetype` VALUES ('39', '养生保健', '5');
INSERT INTO `tbl_coursetype` VALUES ('40', '户外运动', '5');
INSERT INTO `tbl_coursetype` VALUES ('41', '棋类运动', '5');
INSERT INTO `tbl_coursetype` VALUES ('42', '英语', '6');
INSERT INTO `tbl_coursetype` VALUES ('43', '法语', '6');
INSERT INTO `tbl_coursetype` VALUES ('44', '西班牙语', '6');
INSERT INTO `tbl_coursetype` VALUES ('45', '葡萄牙语', '6');
INSERT INTO `tbl_coursetype` VALUES ('46', '俄语', '6');
INSERT INTO `tbl_coursetype` VALUES ('47', '日语', '6');
INSERT INTO `tbl_coursetype` VALUES ('48', '韩语', '6');
INSERT INTO `tbl_coursetype` VALUES ('49', '汉语方言', '6');
INSERT INTO `tbl_coursetype` VALUES ('50', '其他语种', '6');
INSERT INTO `tbl_coursetype` VALUES ('51', '办公软件', '7');
INSERT INTO `tbl_coursetype` VALUES ('52', '求职', '7');
INSERT INTO `tbl_coursetype` VALUES ('53', '营销', '7');
INSERT INTO `tbl_coursetype` VALUES ('54', '人际', '7');
INSERT INTO `tbl_coursetype` VALUES ('55', '财务', '7');
INSERT INTO `tbl_coursetype` VALUES ('56', '管理', '7');
INSERT INTO `tbl_coursetype` VALUES ('57', '其他', '7');
INSERT INTO `tbl_coursetype` VALUES ('58', '烹饪', '8');
INSERT INTO `tbl_coursetype` VALUES ('59', '插画', '8');
INSERT INTO `tbl_coursetype` VALUES ('60', '折纸', '8');
INSERT INTO `tbl_coursetype` VALUES ('61', '调酒', '8');
INSERT INTO `tbl_coursetype` VALUES ('62', '品茶', '8');
INSERT INTO `tbl_coursetype` VALUES ('63', '书法', '8');
INSERT INTO `tbl_coursetype` VALUES ('64', '舞蹈', '8');
INSERT INTO `tbl_coursetype` VALUES ('65', '其他', '8');
INSERT INTO `tbl_coursetype` VALUES ('66', '文学', '9');
INSERT INTO `tbl_coursetype` VALUES ('67', '理学', '9');
INSERT INTO `tbl_coursetype` VALUES ('68', '工学', '9');
INSERT INTO `tbl_coursetype` VALUES ('69', '哲学', '9');
INSERT INTO `tbl_coursetype` VALUES ('70', '历史', '9');
INSERT INTO `tbl_coursetype` VALUES ('71', '经济', '9');
INSERT INTO `tbl_coursetype` VALUES ('72', '社会', '9');
INSERT INTO `tbl_coursetype` VALUES ('73', '心理学', '9');
INSERT INTO `tbl_coursetype` VALUES ('74', '医疗健康', '9');
INSERT INTO `tbl_coursetype` VALUES ('75', '宗教', '9');
INSERT INTO `tbl_coursetype` VALUES ('76', '法律政治', '9');
INSERT INTO `tbl_coursetype` VALUES ('77', '美术建筑', '9');

-- ----------------------------
-- Table structure for `tbl_demand`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_demand`;
CREATE TABLE `tbl_demand` (
  `demandId` int(11) NOT NULL AUTO_INCREMENT,
  `text` varchar(1024) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `proportion` double DEFAULT NULL,
  PRIMARY KEY (`demandId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_demand
-- ----------------------------
INSERT INTO `tbl_demand` VALUES ('1', 'java', '2', '0.5');
INSERT INTO `tbl_demand` VALUES ('2', '大数据', '1', '1');
INSERT INTO `tbl_demand` VALUES ('3', 'ps', '1', '1');
INSERT INTO `tbl_demand` VALUES ('4', 'c', '1', '1');
INSERT INTO `tbl_demand` VALUES ('5', 'c++', '1', '1');
INSERT INTO `tbl_demand` VALUES ('6', '做咖啡', '1', '1');
INSERT INTO `tbl_demand` VALUES ('7', '如何品酒', '1', '1');
INSERT INTO `tbl_demand` VALUES ('8', '瑜伽', '1', '1');
INSERT INTO `tbl_demand` VALUES ('9', '计算机', '1', '1');
INSERT INTO `tbl_demand` VALUES ('10', '钢琴', '1', '1');
INSERT INTO `tbl_demand` VALUES ('11', '小提琴', '1', '1');

-- ----------------------------
-- Table structure for `tbl_follow`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_follow`;
CREATE TABLE `tbl_follow` (
  `followId` int(11) NOT NULL AUTO_INCREMENT,
  `studentId` int(11) DEFAULT NULL,
  `teacherId` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `followDate` date DEFAULT NULL,
  PRIMARY KEY (`followId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tbl_follow
-- ----------------------------
INSERT INTO `tbl_follow` VALUES ('1', '3', '2', '1', '2018-12-29');
INSERT INTO `tbl_follow` VALUES ('2', '3', '4', '1', '2018-12-29');
INSERT INTO `tbl_follow` VALUES ('3', '3', '5', '1', '2018-12-29');
INSERT INTO `tbl_follow` VALUES ('4', '1', '4', '1', '2018-12-29');
INSERT INTO `tbl_follow` VALUES ('5', '2', '4', '1', '2018-12-29');
INSERT INTO `tbl_follow` VALUES ('6', '4', '5', '1', '2018-12-29');
INSERT INTO `tbl_follow` VALUES ('7', '5', '7', '1', '2018-12-29');
INSERT INTO `tbl_follow` VALUES ('8', '6', '2', '1', '2018-12-29');
INSERT INTO `tbl_follow` VALUES ('9', '7', '1', '1', '2018-12-29');
INSERT INTO `tbl_follow` VALUES ('10', '8', '2', '1', '2018-12-29');
INSERT INTO `tbl_follow` VALUES ('11', '9', '1', '1', '2018-12-29');

-- ----------------------------
-- Table structure for `tbl_grade`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_grade`;
CREATE TABLE `tbl_grade` (
  `gradeId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `courseId` int(11) DEFAULT NULL,
  `grade` double DEFAULT NULL,
  PRIMARY KEY (`gradeId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tbl_grade
-- ----------------------------
INSERT INTO `tbl_grade` VALUES ('1', '1', '6', '3');
INSERT INTO `tbl_grade` VALUES ('2', '2', '6', '4');
INSERT INTO `tbl_grade` VALUES ('3', '4', '6', '5');
INSERT INTO `tbl_grade` VALUES ('4', '5', '6', '5');
INSERT INTO `tbl_grade` VALUES ('5', '6', '6', '4');

-- ----------------------------
-- Table structure for `tbl_inform`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_inform`;
CREATE TABLE `tbl_inform` (
  `informId` int(11) NOT NULL AUTO_INCREMENT,
  `informText` varchar(1024) DEFAULT NULL,
  `informTime` date DEFAULT NULL,
  `courseId` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`informId`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_inform
-- ----------------------------
INSERT INTO `tbl_inform` VALUES ('1', '【课程更新】《javaEE实战入门》有新内容更新，点击进入学习', '2018-12-01', '1', '1');
INSERT INTO `tbl_inform` VALUES ('2', '【课程更新】《C/C++入门到精通》有新内容更新，点击进入学习', '2018-05-02', '2', '1');
INSERT INTO `tbl_inform` VALUES ('3', '【课程更新】《H5基础课程》有新内容更新，点击进入学习', '2018-09-09', '3', '1');
INSERT INTO `tbl_inform` VALUES ('4', '【课程更新】《jQuery视频教程》有新内容更新，点击进入学习', '2018-07-07', '4', '1');
INSERT INTO `tbl_inform` VALUES ('5', '【课程更新】《PS简易教程》有新内容更新，点击进入学习', '2018-01-02', '5', '1');
INSERT INTO `tbl_inform` VALUES ('6', '【课程更新】《折纸手工教学》有新内容更新，点击进入学习', '2018-02-03', '6', '1');
INSERT INTO `tbl_inform` VALUES ('7', '【课程更新】《毛笔字教学》有新内容更新，点击进入学习', '2018-02-04', '7', '1');
INSERT INTO `tbl_inform` VALUES ('8', '【课程更新】《古筝考级教学》有新内容更新，点击进入学习', '2018-12-13', '8', '1');
INSERT INTO `tbl_inform` VALUES ('9', '【课程更新】《计算机组成原理》有新内容更新，点击进入学习', '2018-12-03', '9', '1');
INSERT INTO `tbl_inform` VALUES ('10', '【课程更新】《数据结构》有新内容更新，点击进入学习', '2018-11-14', '10', '1');
INSERT INTO `tbl_inform` VALUES ('11', '【课程更新】《果酒制作》有新内容更新，点击进入学习', '2018-12-04', '11', '1');
INSERT INTO `tbl_inform` VALUES ('12', '【课程更新】《形象设计》有新内容更新，点击进入学习', '2018-11-07', '12', '1');
INSERT INTO `tbl_inform` VALUES ('13', '【课程更新】《时间管理术》有新内容更新，点击进入学习', '2018-10-25', '13', '1');
INSERT INTO `tbl_inform` VALUES ('14', '【课程更新】《人像摄影高手训练营》有新内容更新，点击进入学习', '2018-09-20', '14', '1');
INSERT INTO `tbl_inform` VALUES ('15', '【审核发布】《手机摄影》课程已通过', '2018-12-17', '15', '0');
INSERT INTO `tbl_inform` VALUES ('16', '【审核发布】《logo设计》课程已通过', '2018-12-12', '16', '0');
INSERT INTO `tbl_inform` VALUES ('17', '【审核发布】《数字图形创意设计》课程已通过', '2018-12-05', '17', '0');
INSERT INTO `tbl_inform` VALUES ('18', '【审核发布】《和声魔改》课程已通过', '2018-10-08', '18', '0');
INSERT INTO `tbl_inform` VALUES ('19', '【审核发布】《吉他教学》课程已通过', '2018-10-10', '19', '0');
INSERT INTO `tbl_inform` VALUES ('20', '【审核发布】《28天健康减肥法》课程已通过', '2018-12-03', '20', '0');
INSERT INTO `tbl_inform` VALUES ('21', '【审核发布】《办公室瑜伽》课程已通过', '2018-11-13', '21', '0');
INSERT INTO `tbl_inform` VALUES ('22', '【审核发布】《28天健康减肥法》课程的场地申请已通过', '2018-12-04', '20', '0');
INSERT INTO `tbl_inform` VALUES ('23', '【审核发布】《办公室瑜伽》课程的场地申请已通过', '2018-11-07', '21', '0');
INSERT INTO `tbl_inform` VALUES ('24', '【审核发布】《人像摄影高手训练营》课程的场地申请已通过', '2018-12-13', '14', '0');
INSERT INTO `tbl_inform` VALUES ('25', '【审核发布】《时间管理术》课程的场地申请已通过', '2018-12-20', '13', '0');
INSERT INTO `tbl_inform` VALUES ('26', '【审核发布】《logo设计》课程的场地申请已通过', '2018-12-25', '16', '0');
INSERT INTO `tbl_inform` VALUES ('27', '【审核发布】《毛笔字教学》课程的场地申请已通过', '2018-12-26', '7', '0');
INSERT INTO `tbl_inform` VALUES ('28', '【审核发布】《折纸手工教学》课程的场地申请已通过', '2018-12-27', '6', '0');

-- ----------------------------
-- Table structure for `tbl_money`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_money`;
CREATE TABLE `tbl_money` (
  `moneyId` int(11) NOT NULL AUTO_INCREMENT,
  `money` double(11,0) DEFAULT NULL,
  `moneyTime` datetime DEFAULT NULL,
  `courseId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`moneyId`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_money
-- ----------------------------
INSERT INTO `tbl_money` VALUES ('1', '10', '2018-12-29 21:52:29', '6', '3');
INSERT INTO `tbl_money` VALUES ('2', '10', '2018-12-29 21:56:00', '6', '3');
INSERT INTO `tbl_money` VALUES ('3', '10', '2018-12-29 22:04:10', '6', '3');
INSERT INTO `tbl_money` VALUES ('4', '10', '2018-12-29 22:08:16', '6', '3');
INSERT INTO `tbl_money` VALUES ('5', '30', '2018-12-29 22:33:39', '3', '2');
INSERT INTO `tbl_money` VALUES ('6', '10', '2018-12-29 22:48:42', '6', '3');
INSERT INTO `tbl_money` VALUES ('7', '10', '2018-12-29 22:52:29', '6', '3');
INSERT INTO `tbl_money` VALUES ('8', '99', '2018-12-30 17:28:26', '14', '5');
INSERT INTO `tbl_money` VALUES ('9', '30', '2018-12-30 17:29:02', '3', '2');
INSERT INTO `tbl_money` VALUES ('10', '30', '2018-12-30 20:34:20', '3', '2');
INSERT INTO `tbl_money` VALUES ('11', '30', '2018-12-30 20:38:31', '3', '2');

-- ----------------------------
-- Table structure for `tbl_user`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_user`;
CREATE TABLE `tbl_user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(30) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `nativeProvince` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `nativeCity` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `phoneNumber` char(11) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `photo` varchar(50) DEFAULT NULL,
  `nickName` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `birthday` char(10) DEFAULT NULL,
  `identityNumber` char(18) DEFAULT NULL,
  `balance` double DEFAULT NULL,
  `tag` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `school` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `major` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `introduction` varchar(1024) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tbl_user
-- ----------------------------
INSERT INTO `tbl_user` VALUES ('1', '1209980074@qq.com', '0', '江苏', '南京市', '15222228888', '1234qwerasdf', 'img/Linux&c.png', '小e1', '1996-12-04', '130283199612042255', '990', null, '河北师范大学', '数信专业', '我是一名大学生');
INSERT INTO `tbl_user` VALUES ('2', '3449165425@qq.com', '1', '广东', '江门市', '15227119999', '123456asd', 'img/Linux&c.png', '小e2', '1995-11-02', '450101199511028866', '360', null, '河北师范大学', '美术与设计专业', '我是一名大学生');
INSERT INTO `tbl_user` VALUES ('3', '1186373310@qq.com', '1', '河北', '石家庄', '15577449999', '123456', 'img/Linux&c.png', '小e3', '1996-02-02', '450103199602025533', '190', null, '河北师范大学', '材料与工程学专业', '我是一名大学生');
INSERT INTO `tbl_user` VALUES ('4', 'm13932208353@163.com', '0', '吉林', '长春市', '13932208353', '123456', 'img/Linux&c.png', '小e4', '1996-01-01', '102030199601014455', '9970', null, '河北师范大学', '外国语专业', '我是一名大学生');
INSERT INTO `tbl_user` VALUES ('5', 'm15227119655@163.com', '1', '广西', '贵港市', '15227119655', 'lffang1125', 'img/Linux&c.png', '小e5', '1996-04-05', '450803199611255646', '171', null, '河北师范大学', '软件工程', '我是一名大学生');
INSERT INTO `tbl_user` VALUES ('6', '15225426358@163.com', '1', '河北', '沧州', '15225426358', '124578963', 'img/Linux&c.png', '小e6', '1998-11-01', '130282199811017878', '990', null, '河北师范大学', '生命科学专业', '我是一名大学生');
INSERT INTO `tbl_user` VALUES ('7', '15236451235@163.com', '1', '河北', '石家庄', '15236451235', '123456987', 'img/Linux&c.png', '小e7', '1999-12-20', '130282199912201242', '490', null, '河北师范大学', '职技专业', '我是一名大学生');
INSERT INTO `tbl_user` VALUES ('8', '15236455245@163.com', '0', '河北', '石家庄', '15236455245', '1234256', 'img/Linux&c.png', '小e8', '1997-12-04', '130283199712042255', '490', null, '河北师范大学', '数信专业', '我是一名大学生');
INSERT INTO `tbl_user` VALUES ('9', '15236455426@163.com', '0', '河北', '石家庄', '15236455426', '12452356', 'img/Linux&c.png', '小e9', '1998-11-04', '130283199811042255', '500', null, '河北师范大学', '美术与设计专业', '我是一名大学生');

-- ----------------------------
-- Table structure for `tbl_userbalance`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_userbalance`;
CREATE TABLE `tbl_userbalance` (
  `userBalanceId` int(11) NOT NULL AUTO_INCREMENT,
  `balanceTime` datetime DEFAULT NULL,
  `money` double DEFAULT NULL,
  `totleMoney` double DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `balanceState` int(11) DEFAULT NULL,
  `courseId` int(11) DEFAULT NULL,
  PRIMARY KEY (`userBalanceId`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tbl_userbalance
-- ----------------------------
INSERT INTO `tbl_userbalance` VALUES ('1', '2018-12-29 21:52:28', '10', '990', '6', '1', '6');
INSERT INTO `tbl_userbalance` VALUES ('2', '2018-12-29 21:56:00', '10', '490', '7', '1', '6');
INSERT INTO `tbl_userbalance` VALUES ('3', '2018-12-29 22:04:10', '10', '990', '1', '1', '6');
INSERT INTO `tbl_userbalance` VALUES ('4', '2018-12-29 22:08:15', '10', '390', '2', '1', '6');
INSERT INTO `tbl_userbalance` VALUES ('5', '2018-12-29 22:33:39', '30', '360', '2', '1', '3');
INSERT INTO `tbl_userbalance` VALUES ('6', '2018-12-29 22:48:42', '10', '490', '8', '1', '6');
INSERT INTO `tbl_userbalance` VALUES ('7', '2018-12-29 22:52:29', '10', '190', '3', '1', '6');
INSERT INTO `tbl_userbalance` VALUES ('8', '2018-12-30 17:28:26', '99', '201', '5', '1', '14');
INSERT INTO `tbl_userbalance` VALUES ('9', '2018-12-30 17:29:02', '30', '171', '5', '1', '3');
INSERT INTO `tbl_userbalance` VALUES ('10', '2018-12-30 20:34:20', '10000', '10000', '4', '0', null);
INSERT INTO `tbl_userbalance` VALUES ('11', '2018-12-30 20:38:31', '30', '9970', '4', '1', '3');
INSERT INTO `tbl_userbalance` VALUES ('12', '2018-12-28 21:37:30', '1000', '1000', '6', '0', null);

-- ----------------------------
-- Table structure for `tbl_usercollectioncourse`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_usercollectioncourse`;
CREATE TABLE `tbl_usercollectioncourse` (
  `collectionId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `courseId` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`collectionId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tbl_usercollectioncourse
-- ----------------------------
INSERT INTO `tbl_usercollectioncourse` VALUES ('1', '2', '6', '1', '2018-12-29 22:13:12');
INSERT INTO `tbl_usercollectioncourse` VALUES ('2', '2', '3', '1', '2018-12-29 22:33:49');
INSERT INTO `tbl_usercollectioncourse` VALUES ('3', '4', '3', '1', '2018-12-30 20:37:40');

-- ----------------------------
-- Table structure for `tbl_userdemand`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_userdemand`;
CREATE TABLE `tbl_userdemand` (
  `userDemandId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `demandId` int(11) DEFAULT NULL,
  `demandTime` date DEFAULT NULL,
  PRIMARY KEY (`userDemandId`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tbl_userdemand
-- ----------------------------
INSERT INTO `tbl_userdemand` VALUES ('1', '3', '1', '2018-12-29');
INSERT INTO `tbl_userdemand` VALUES ('2', '2', '2', '2018-12-29');
INSERT INTO `tbl_userdemand` VALUES ('3', '1', '1', '2018-12-29');
INSERT INTO `tbl_userdemand` VALUES ('4', '5', '3', '2018-12-29');
INSERT INTO `tbl_userdemand` VALUES ('5', '4', '4', '2018-12-29');
INSERT INTO `tbl_userdemand` VALUES ('6', '6', '5', '2018-12-29');
INSERT INTO `tbl_userdemand` VALUES ('7', '7', '6', '2018-12-29');
INSERT INTO `tbl_userdemand` VALUES ('8', '8', '7', '2018-12-29');
INSERT INTO `tbl_userdemand` VALUES ('9', '9', '8', '2018-12-29');
INSERT INTO `tbl_userdemand` VALUES ('10', '5', '9', '2018-12-29');
INSERT INTO `tbl_userdemand` VALUES ('11', '4', '10', '2018-12-29');
INSERT INTO `tbl_userdemand` VALUES ('12', '5', '11', '2018-12-29');

-- ----------------------------
-- Table structure for `tbl_userjoincourse`
-- ----------------------------
DROP TABLE IF EXISTS `tbl_userjoincourse`;
CREATE TABLE `tbl_userjoincourse` (
  `joincourseId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `courseId` int(11) DEFAULT NULL,
  `joinTime` date DEFAULT NULL,
  PRIMARY KEY (`joincourseId`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tbl_userjoincourse
-- ----------------------------
INSERT INTO `tbl_userjoincourse` VALUES ('1', '6', '6', '2018-12-29');
INSERT INTO `tbl_userjoincourse` VALUES ('2', '7', '6', '2018-12-29');
INSERT INTO `tbl_userjoincourse` VALUES ('3', '1', '6', '2018-12-29');
INSERT INTO `tbl_userjoincourse` VALUES ('4', '2', '6', '2018-12-29');
INSERT INTO `tbl_userjoincourse` VALUES ('5', '2', '3', '2018-12-29');
INSERT INTO `tbl_userjoincourse` VALUES ('6', '8', '6', '2018-12-29');
INSERT INTO `tbl_userjoincourse` VALUES ('7', '3', '6', '2018-12-29');
INSERT INTO `tbl_userjoincourse` VALUES ('8', '2', '6', '2018-12-29');
INSERT INTO `tbl_userjoincourse` VALUES ('10', '5', '6', '2018-12-29');
INSERT INTO `tbl_userjoincourse` VALUES ('11', '5', '14', '2018-12-30');
INSERT INTO `tbl_userjoincourse` VALUES ('12', '5', '3', '2018-12-30');
INSERT INTO `tbl_userjoincourse` VALUES ('14', '4', '3', '2018-12-30');
