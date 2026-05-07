/*
 Navicat Premium Data Transfer

 Source Server         : azhou
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : 20250227jiajiao

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 02/03/2025 20:15:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '评论编号',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论内容',
  `order_id` bigint(20) NULL DEFAULT NULL COMMENT '订单编号',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户编号',
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父评论编号',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `teacher_id` bigint(20) NULL DEFAULT NULL COMMENT '教师编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '评论' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (16, '哈哈哈 这老师有点逗', 1, 1, 0, '2025-02-28 11:49:55', NULL);
INSERT INTO `comment` VALUES (18, '123', 1, 1, 0, '2025-03-02 14:17:59', NULL);
INSERT INTO `comment` VALUES (19, '你个老六', 1, 1, 0, '2025-03-02 14:18:06', NULL);
INSERT INTO `comment` VALUES (31, '家长非常给力 ', 1, NULL, 0, '2025-03-02 17:13:25', 1);
INSERT INTO `comment` VALUES (32, '你好', 4, NULL, 0, '2025-03-02 17:23:49', 1);
INSERT INTO `comment` VALUES (33, '老师您好', 4, 1, 0, '2025-03-02 17:24:10', NULL);
INSERT INTO `comment` VALUES (34, '老师您好', 5, 2, 0, '2025-03-02 18:40:13', NULL);

-- ----------------------------
-- Table structure for manage
-- ----------------------------
DROP TABLE IF EXISTS `manage`;
CREATE TABLE `manage`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '管理员编号',
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `pass_word` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `photo_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '管理员表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of manage
-- ----------------------------
INSERT INTO `manage` VALUES (1, 'admin', 'admin', 'http://localhost:8092/jiajiao/8e232234-6b67-49e1-b144-f112dd6fdbaa.jpg', 'admin');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '消息ID',
  `send_user_id` bigint(20) NULL DEFAULT NULL COMMENT '发送用户ID',
  `accept_user_id` bigint(20) NULL DEFAULT NULL COMMENT '发送用户ID',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 40 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (37, 1, 1, '2025-03-02 17:34:32');
INSERT INTO `message` VALUES (39, 2, 1, '2025-03-02 17:42:16');

-- ----------------------------
-- Table structure for message_info
-- ----------------------------
DROP TABLE IF EXISTS `message_info`;
CREATE TABLE `message_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '消息详情ID',
  `info` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '内容',
  `message_id` bigint(20) NULL DEFAULT NULL COMMENT '聊天ID',
  `position` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '左边右边',
  `send_user_id` bigint(20) NULL DEFAULT NULL COMMENT '发送用户ID',
  `accept_user_id` bigint(20) NULL DEFAULT NULL COMMENT '发送用户ID',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 93 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message_info
-- ----------------------------
INSERT INTO `message_info` VALUES (83, '你好', 37, 'right', 1, 1, '2025-03-02 17:34:36');
INSERT INTO `message_info` VALUES (84, '你好呀', 37, 'right', 1, 1, '2025-03-02 17:41:03');
INSERT INTO `message_info` VALUES (85, '哈哈哈', 37, 'left', 1, 1, '2025-03-02 17:41:13');
INSERT INTO `message_info` VALUES (86, '666', 37, 'left', 1, 1, '2025-03-02 17:41:19');
INSERT INTO `message_info` VALUES (87, '家长 您好', 37, 'left', 1, 1, '2025-03-02 17:41:37');
INSERT INTO `message_info` VALUES (88, '在的老师', 37, 'right', 1, 1, '2025-03-02 17:41:42');
INSERT INTO `message_info` VALUES (89, '李老师 您好', 39, 'right', 2, 1, '2025-03-02 17:42:23');
INSERT INTO `message_info` VALUES (90, '在的', 39, 'left', 2, 1, '2025-03-02 17:42:29');
INSERT INTO `message_info` VALUES (91, '家长您好', 39, 'left', 2, 1, '2025-03-02 17:49:33');
INSERT INTO `message_info` VALUES (92, '哈哈', 39, 'right', 2, 1, '2025-03-02 17:49:37');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单编号',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户编号',
  `teacher_id` bigint(20) NULL DEFAULT NULL COMMENT '老师编号',
  `student_time` datetime(0) NULL DEFAULT NULL COMMENT '上课时间',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上课地点',
  `subject_id` bigint(20) NULL DEFAULT NULL COMMENT '学科',
  `status` int(11) NULL DEFAULT NULL COMMENT '状态[0:待支付,1:已支付,2:老师审核,3:老师同意,4:老师拒绝,5:已完成,6:已取消]',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `type_id` bigint(20) NULL DEFAULT NULL COMMENT '授课方式',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '预约订单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (1, 1, 1, '2025-03-01 13:00:00', '湖南省长沙市欧园小区1栋103', 3, 1, '暂无', '2025-02-28 10:57:46', 2);
INSERT INTO `orders` VALUES (2, 1, 2, '2025-03-02 13:00:00', '暂无', 3, 1, '暂无', '2025-02-28 11:01:55', 1);
INSERT INTO `orders` VALUES (3, 1, 2, '2025-03-05 10:00:00', '湖南省长沙市欧园小区1栋103', 5, 2, '666', '2025-03-01 19:52:58', 2);
INSERT INTO `orders` VALUES (4, 1, 1, '2025-03-04 13:00:00', '湖南长沙', 1, 3, '123', '2025-03-02 17:17:21', 1);
INSERT INTO `orders` VALUES (5, 2, 1, '2025-01-01 00:00:00', '湖南宁乡', 2, 2, '暂无', '2025-03-02 18:37:56', 2);

-- ----------------------------
-- Table structure for subject
-- ----------------------------
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '学科编号',
  `subject_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学科名称',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '学科管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of subject
-- ----------------------------
INSERT INTO `subject` VALUES (1, '小学数学', '2025-02-28 10:35:06');
INSERT INTO `subject` VALUES (2, '小学语文', '2025-02-28 10:35:15');
INSERT INTO `subject` VALUES (3, '小学英语', '2025-02-28 10:35:26');
INSERT INTO `subject` VALUES (4, '初中语文', '2025-02-28 10:35:44');
INSERT INTO `subject` VALUES (5, '初中数学', '2025-02-28 10:35:50');
INSERT INTO `subject` VALUES (6, '初中英语', '2025-02-28 10:36:00');
INSERT INTO `subject` VALUES (7, '初中理科', '2025-02-28 10:36:09');
INSERT INTO `subject` VALUES (8, '初中文科', '2025-02-28 10:36:15');
INSERT INTO `subject` VALUES (9, '高中语文', '2025-02-28 10:36:22');
INSERT INTO `subject` VALUES (10, '高中数学', '2025-02-28 10:36:30');
INSERT INTO `subject` VALUES (11, '高中英语', '2025-02-28 10:36:38');
INSERT INTO `subject` VALUES (12, '高中理科', '2025-02-28 10:36:43');
INSERT INTO `subject` VALUES (13, '高中文科', '2025-02-28 10:36:55');
INSERT INTO `subject` VALUES (14, '线性代数', '2025-02-28 10:37:03');
INSERT INTO `subject` VALUES (15, '统计学', '2025-02-28 10:37:10');
INSERT INTO `subject` VALUES (16, '马克思主义', '2025-02-28 10:37:17');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '老师编号',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '老师姓名',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `sex` int(11) NULL DEFAULT NULL COMMENT '性别',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `head_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `collegiate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '毕业院校',
  `educational` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学历',
  `educational_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '毕业证书',
  `info` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '个人简介',
  `status` int(11) NULL DEFAULT NULL COMMENT '状态[0:待审核,1:审核通过,2:审核不通过]',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `type_id` bigint(20) NULL DEFAULT NULL COMMENT '服务方式',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '教师管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1, '李逸飞', 28, 1, 'tea1', 'tea1', 'http://localhost:8092/jiajiao/aed0681c-1967-4214-a82d-04b508933ded.jpeg', '中南大学', '研究生', 'http://localhost:8092/jiajiao/92b5487d-af56-4f1a-97a1-cde469844b8c.png', '# 个人简介\n\n大家好，我叫[您的姓名]，是一名专注于数学教育领域的专业家教老师。我拥有扎实的数学专业知识和丰富的教学经验，致力于帮助每一位学生在数学学习的道路上取得进步，点亮他们的智慧之光。\n\n我对数学有着深厚的热爱与执着，这份热情始于年少时对数学奥秘的探索，并在多年的学习与钻研中不断深化。在大学期间，我主修数学相关专业，以优异的成绩完成了学业，系统地掌握了从基础数学到高等数学的各类知识体系，这为我日后的教学工作奠定了坚实的理论基础。\n\n毕业后，我投身于教育事业，积累了丰富的一线教学经验。我曾在[学校名称或教育机构名称]担任数学教师，教授过不同年龄段、不同学习层次的学生，涵盖小学、初中和高中各个阶段。无论是基础薄弱需要查漏补缺的学生，还是渴望在数学竞赛中拔得头筹的尖子生，我都能根据他们的实际情况制定个性化的教学方案。通过深入分析学生的学习特点和问题所在，运用生动有趣、深入浅出的教学方法，激发他们对数学的兴趣，培养他们的逻辑思维能力和自主学习能力。\n\n在教学过程中，我注重理论与实践相结合。不仅会详细讲解数学概念、定理和公式，还会通过大量的实例和练习让学生加深理解，并引导他们学会将所学知识应用到实际生活中，体会数学的实用性和趣味性。我鼓励学生积极提问，培养他们独立思考和解决问题的能力，让他们在探索数学的过程中逐渐建立起自信。\n\n作为一名家教老师，我深知一对一教学的优势和责任。我会为每一位学生提供专属的学习空间，耐心倾听他们在学习中的困惑和烦恼，及时给予针对性的指导和反馈。我会根据学生的作业完成情况、考试成绩以及课堂表现，动态调整教学内容和方法，确保教学效果的最大化。同时，我也注重与家长的沟通与合作，定期向家长反馈学生的学习进展，共同促进学生的成长与进步。\n\n除了传统的课堂教学，我还积极探索创新教学模式，利用现代教育技术和网络资源丰富教学内容和形式。例如，制作精美的教学课件、使用在线教学平台进行互动教学等，让学习不再局限于时间和空间，为学生提供更加便捷、高效的学习体验。\n\n我始终坚信，每个学生都有无限的潜力，只要给予正确的引导和足够的努力，他们都能在数学领域绽放光彩。我将以饱满的热情、专业的素养和高度的责任感，继续在数学教育的道路上砥砺前行，为学生们的数学梦想助力，成为他们成长路上的良师益友。', 1, '2025-02-28 10:45:15', '1192704429@qq.com', 3);
INSERT INTO `teacher` VALUES (2, '林晓萱', 26, 0, 'tea2', 'tea2', 'http://localhost:8092/jiajiao/e83cac04-51f8-4670-97c2-4f89d9407ffb.jpeg', '湖南大学', '大学本科', 'http://localhost:8092/jiajiao/fce6c0ca-719d-428c-8924-a3078892d253.png', '在硕士阶段，专注于专业领域的深入研究，取得了一定的研究成果。教学中，严谨认真，注重细节，对学生的要求严格，致力于培养学生的专业素养和严谨治学的态度。同时，积极关注学科前沿动态，将最新的研究成果融入教学内容中，拓宽学生的视野，激发学生的创新意识。', 1, '2025-02-28 10:50:26', '120202020@qq.com', 1);
INSERT INTO `teacher` VALUES (3, '苏若瑶', 32, 0, 'tea3', 'tea3', 'http://localhost:8092/jiajiao/80a3a26e-0789-4a92-9d41-0c29cc05f1ea.jpg', '广东大学', '硕士研究生', 'http://localhost:8092/jiajiao/6ba58c46-c169-4ccc-ae30-7c1d67d51c2b.png', '具备扎实的专业知识基础，对学术研究充满热情，善于将理论知识与实际应用相结合。在教学过程中，注重培养学生的创新思维和实践能力，引导学生积极参与科研项目和实践活动，助力学生在专业领域取得更好的发展。', 1, '2025-02-28 10:51:26', '10010@qq.com', 1);
INSERT INTO `teacher` VALUES (4, '张宇轩', 29, 1, 'tea4', 'tea4', 'http://localhost:8092/jiajiao/a264e71c-4245-426b-88b8-70a1e8abc7be.jpeg', '北京大学', '本科', 'http://localhost:8092/jiajiao/11c6b2b0-245f-4bda-850c-3409c6a16db6.png', '在本科学习期间打下了坚实的专业基础。拥有丰富的教学经验，擅长运用生动形象的案例和通俗易懂的语言进行教学，使复杂的知识点变得易于理解和掌握。注重与学生的互动交流，鼓励学生积极参与课堂讨论，培养学生的自主学习能力和团队协作精神，深受学生的喜爱和好评。', 1, '2025-02-28 10:52:14', '10086@qq.com', 1);
INSERT INTO `teacher` VALUES (5, '陈雅昕', 22, 0, 'tea5', 'tea5', 'http://localhost:8092/jiajiao/74116c4d-d40a-4cc0-985b-bcfdf6076a44.jpg', '清华大学', '本科', 'http://localhost:8092/jiajiao/843f8c30-b1d1-4b43-a358-f03bd01b80b7.png', '教学过程中，强调理论与实践的结合，注重培养学生的动手能力和解决实际问题的能力。积极参与教学改革和课程建设，不断探索创新教学模式，以提高教学质量。对待学生耐心细致，关心学生的学习和生活，是学生成长道路上的良师益友。', 1, '2025-02-28 10:53:08', '119@qq.com', 3);
INSERT INTO `teacher` VALUES (6, '李俊凯', 26, 1, 'tea12', 'tea1', 'http://localhost:8092/jiajiao/c0f4d25c-856e-498c-9e7d-7a2ff8e31dbd.jpeg', '长沙大学', '本科', 'http://localhost:8092/jiajiao/7eb3c17b-e21b-4924-8ea1-3d1a7b777553.png', '123', 0, '2025-03-02 16:26:08', '18585635263@qq.com', 3);

-- ----------------------------
-- Table structure for teacher_subject
-- ----------------------------
DROP TABLE IF EXISTS `teacher_subject`;
CREATE TABLE `teacher_subject`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `teacher_id` bigint(20) NULL DEFAULT NULL COMMENT '老师编号',
  `subject_id` bigint(20) NULL DEFAULT NULL COMMENT '学科编号',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '老师绑定学科' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher_subject
-- ----------------------------
INSERT INTO `teacher_subject` VALUES (1, 1, 1, '2025-02-28 22:31:36');
INSERT INTO `teacher_subject` VALUES (2, 1, 2, '2025-02-28 22:31:36');
INSERT INTO `teacher_subject` VALUES (3, 1, 3, '2025-02-28 22:31:36');
INSERT INTO `teacher_subject` VALUES (4, 2, 1, '2025-02-28 22:31:36');
INSERT INTO `teacher_subject` VALUES (5, 2, 4, '2025-02-28 22:31:36');
INSERT INTO `teacher_subject` VALUES (6, 2, 5, '2025-02-28 22:31:36');
INSERT INTO `teacher_subject` VALUES (7, 3, 6, '2025-02-28 22:31:36');
INSERT INTO `teacher_subject` VALUES (8, 3, 5, '2025-02-28 22:31:36');
INSERT INTO `teacher_subject` VALUES (9, 2, 2, '2025-02-28 22:31:36');
INSERT INTO `teacher_subject` VALUES (10, 4, 7, '2025-02-28 22:31:36');
INSERT INTO `teacher_subject` VALUES (11, 4, 2, '2025-02-28 22:31:36');
INSERT INTO `teacher_subject` VALUES (12, 4, 10, '2025-02-28 22:31:36');
INSERT INTO `teacher_subject` VALUES (13, 5, 9, '2025-02-28 22:31:36');
INSERT INTO `teacher_subject` VALUES (14, 5, 8, '2025-02-28 22:31:36');

-- ----------------------------
-- Table structure for types
-- ----------------------------
DROP TABLE IF EXISTS `types`;
CREATE TABLE `types`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '方式编号',
  `type_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '方式名称',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '服务方式管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of types
-- ----------------------------
INSERT INTO `types` VALUES (1, '线上教学', '2025-02-28 10:37:54');
INSERT INTO `types` VALUES (2, '线下教学', '2025-02-28 10:37:49');
INSERT INTO `types` VALUES (3, '不限', '2025-02-28 10:37:42');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `sex` int(11) NULL DEFAULT NULL COMMENT '性别[0:女,1:男]',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'azhou', 'http://localhost:8092/jiajiao/18e784fd-72ec-4499-bdfe-6b7aa1404ff8.jpg', 'azhou', 'azhou', 0, '2025-02-28 10:54:03');
INSERT INTO `users` VALUES (2, '用户-azhou1', 'https://code-grade-server-prd.oss-cn-shenzhen.aliyuncs.com/2024-03-21/ea57760f-b358-4482-85d9-d4a131b28108_type_bg.png', 'azhou1', '123', 1, '2025-02-28 18:01:45');
alter table users add column school varchar(200) default null  comment '学小姓名';
alter table users add column address varchar(200) default null  comment '住址';
alter table users add column info varchar(200) default null  comment '简介';


alter table users add column classes varchar(200) default null  comment '年级';
alter table orders add column money varchar(200) default null  comment '价格';

SET FOREIGN_KEY_CHECKS = 1;
