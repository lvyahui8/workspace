-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: phoenixnest
-- ------------------------------------------------------
-- Server version	5.6.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `level` int(11) NOT NULL DEFAULT '1',
  `category_id` int(11) DEFAULT NULL,
  `editor` enum('yes','no') NOT NULL DEFAULT 'yes',
  `type` enum('normal','exam','article','video','audio') NOT NULL DEFAULT 'normal',
  PRIMARY KEY (`id`),
  KEY `fk_category_category1_idx` (`category_id`),
  CONSTRAINT `fk_category_category1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (4,'基础理论夯实',0,NULL,'yes','normal'),(6,'中级技能进阶',0,NULL,'yes','normal'),(7,'实操技能强化',0,NULL,'yes','normal'),(8,'分析倾听音频库',1,7,'yes','exam'),(9,'实操仿真音频库',1,7,'yes','audio'),(16,'自助练习文本库',1,7,'yes','exam'),(26,'内容反应',1,6,'yes','video'),(27,'情感反应',1,6,'yes','video'),(28,'具体化技术',1,6,'yes','audio'),(29,'重复技术',1,6,'yes','article'),(30,'房树人测验',1,6,'yes','article'),(31,'沙盘实验',1,6,'yes','audio');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `collect`
--

DROP TABLE IF EXISTS `collect`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `collect` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `project_id` int(11) NOT NULL COMMENT '项目ID',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_collect_1_idx` (`user_id`),
  KEY `fk_collect_2_idx` (`project_id`),
  CONSTRAINT `fk_collect_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_collect_2` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='手残';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `collect`
--

LOCK TABLES `collect` WRITE;
/*!40000 ALTER TABLE `collect` DISABLE KEYS */;
/*!40000 ALTER TABLE `collect` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text NOT NULL,
  `desc` varchar(45) DEFAULT NULL,
  `pub` enum('yes','no') NOT NULL DEFAULT 'yes',
  `user_id` int(11) NOT NULL,
  `project_id` int(11) NOT NULL,
  `top` enum('yes','no') NOT NULL DEFAULT 'no',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_comment_user1_idx` (`user_id`),
  KEY `fk_comment_project1_idx` (`project_id`),
  CONSTRAINT `fk_comment_project1` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_comment_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评论';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `config`
--

DROP TABLE IF EXISTS `config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `value` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `config`
--

LOCK TABLES `config` WRITE;
/*!40000 ALTER TABLE `config` DISABLE KEYS */;
/*!40000 ALTER TABLE `config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `praise`
--

DROP TABLE IF EXISTS `praise`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `praise` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `project_id` int(11) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_sun29oa2yvxhb28e0a6b1b6e1` (`project_id`),
  KEY `FK_pm9s073ial6see3ein847evfx` (`user_id`),
  CONSTRAINT `FK_pm9s073ial6see3ein847evfx` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_sun29oa2yvxhb28e0a6b1b6e1` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='赞';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `praise`
--

LOCK TABLES `praise` WRITE;
/*!40000 ALTER TABLE `praise` DISABLE KEYS */;
/*!40000 ALTER TABLE `praise` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) NOT NULL,
  `title` text,
  `content` text,
  `type` enum('normal','exam','article','image','audio','video') NOT NULL DEFAULT 'normal',
  `resource_url` varchar(255) DEFAULT NULL,
  `praise_count` int(11) NOT NULL DEFAULT '0' COMMENT '赞同数',
  `view_count` int(11) NOT NULL DEFAULT '0' COMMENT '浏览人数',
  `collect_count` int(11) NOT NULL DEFAULT '0' COMMENT '收藏数',
  `enableTest` enum('yes','no') NOT NULL DEFAULT 'no',
  `test_type` enum('single','multiple','other') DEFAULT NULL COMMENT '测试类型',
  `answer` text COMMENT '答案，json格式,格式如下,这样设计支持多选\n[\n{"answer":true,"text":"da an nei rong"},\n{"answer":false,"text":"da an nei rong"},\n{"answer":false,"text":"da an nei rong"},\n{"answer":false,"text":"da an nei rong"},\n]\n',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `enableComment` enum('yes','no') NOT NULL DEFAULT 'yes',
  `order_by` int(11) DEFAULT '0',
  `test_count` int(11) NOT NULL DEFAULT '0' COMMENT '测试人数',
  `thumbnail` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_7t3pfhxi3tmfxbcraljg29qvi` (`category_id`),
  CONSTRAINT `FK_7t3pfhxi3tmfxbcraljg29qvi` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project`
--

LOCK TABLES `project` WRITE;
/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` VALUES (1,8,'这是题干','这是补充说明','exam',NULL,0,0,0,'no',NULL,'[{\"answer\":false,\"text\":\"的所发生的刚\"},{\"answer\":false,\"text\":\"是大法官的双方各\"},{\"answer\":true,\"text\":\"的双方各收到\"},{\"answer\":false,\"text\":\"是是广泛的发\"}]','2015-07-09 13:27:46','yes',0,0,NULL,NULL),(2,8,'第二题，轻坠','楼上的客户方会计上','exam',NULL,0,0,0,'no',NULL,'[{\"answer\":true,\"text\":\"啥地方开始的恢复会计师的咖啡\"},{\"answer\":true,\"text\":\"孙丹菲广东省高\"},{\"answer\":true,\"text\":\"了贷款卡缴费的烧烤郭德纲\"},{\"answer\":false,\"text\":\"梵蒂冈的非官方的个\"}]','2015-07-09 13:28:25','yes',0,0,NULL,NULL),(3,8,'水电费水电费','<h1>水电费水电费深刻的九分裤上对方会尽快是的粉色的</h1><br><br>孙丹菲离开深刻的放<br>孙丹菲','exam',NULL,0,0,0,'no',NULL,'[{\"answer\":true,\"text\":\"上大方的说法\"},{\"answer\":true,\"text\":\"孙丹菲地方\"},{\"answer\":false,\"text\":\"的非官方的\"},{\"answer\":false,\"text\":\"发给发\"}]','2015-07-09 14:35:47','yes',0,0,NULL,NULL),(4,8,'这个是为什么呢','<ul><li>所说的分公司的</li><li>的说法都是</li><li>的地方</li><li>地方的</li></ul>','exam',NULL,0,0,0,'no',NULL,'[{\"answer\":true,\"text\":\"的风格大方\"},{\"answer\":true,\"text\":\"的风格地方地方\"},{\"answer\":false,\"text\":\"地方地方地方\"},{\"answer\":false,\"text\":\"体育体育\"}]','2015-07-09 14:40:40','yes',0,0,NULL,NULL),(5,8,'这个是为什么呢','<ul><li>所说的分公司的</li><li>的说法都是</li><li>的地方</li><li>地方的</li></ul>','exam',NULL,0,0,0,'no',NULL,'[{\"answer\":true,\"text\":\"的风格大方\"},{\"answer\":true,\"text\":\"的风格地方地方\"},{\"answer\":false,\"text\":\"地方地方地方\"},{\"answer\":false,\"text\":\"天然556756765\"}]','2015-07-09 14:42:14','yes',0,0,NULL,NULL),(6,8,'再来一题如何','好的，没问题','exam',NULL,0,0,0,'no',NULL,'[{\"answer\":true,\"text\":\"这就是答案\"},{\"answer\":false,\"text\":\"这不是答案B\"},{\"answer\":false,\"text\":\"这不是答案C\"},{\"answer\":false,\"text\":\"这不是答案D\"}]','2015-07-10 14:14:05','yes',0,0,NULL,NULL),(7,8,'这是新的试题 是的是的是的是的','是的粉色的国际法的鬼地方是个可尽快的说法韩国','exam',NULL,0,0,0,'no',NULL,'[{\"answer\":true,\"text\":\"广泛的广泛的广泛的\"},{\"answer\":false,\"text\":\"的非官方的个的方法的个\"},{\"answer\":false,\"text\":\"的非官方的个福德宫地方\"},{\"answer\":false,\"text\":\"的法国人特意特然\"}]','2015-07-11 14:44:10','yes',0,0,NULL,NULL),(8,16,'fsdfsdsf','sdfsdfsdffffffffdfdgsdfsdfsdffffffffdfdgsdfsdfsdffffffffdfdgsdfsdfsdffffffffdfdg','exam',NULL,0,0,0,'no',NULL,'[{\"answer\":true,\"text\":\"dfgdfgdfg\"},{\"answer\":false,\"text\":\"fdgdfgerwt43534\"},{\"answer\":false,\"text\":\"45656ttrytr\"},{\"answer\":false,\"text\":\"ytrhthgfhcfdfg\"}]','2015-07-12 07:52:28','yes',0,0,NULL,NULL),(9,8,'这是题干','这是补充说明','exam',NULL,0,0,0,'no',NULL,'[{\"answer\":true,\"text\":\"我了个擦，\"},{\"answer\":true,\"text\":\"为什么会这样呢\"},{\"answer\":false,\"text\":\"水电费的\"},{\"answer\":false,\"text\":\"孙丹菲收到\"}]','2015-07-12 08:28:55','yes',0,0,NULL,NULL),(10,8,'这是题干','这是补充说明','exam',NULL,0,0,0,'no',NULL,'[{\"answer\":false,\"text\":\"的风格风格的风格大方\"},{\"answer\":false,\"text\":\"梵蒂冈梵蒂冈的风格\"},{\"answer\":true,\"text\":\"梵蒂冈梵蒂冈地方\"},{\"answer\":false,\"text\":\"的非官方的个梵蒂冈\"}]','2015-07-12 08:30:18','yes',0,0,NULL,NULL),(11,8,'这是题干','这是补充说明','exam',NULL,0,0,0,'no',NULL,'[{\"answer\":true,\"text\":\"的风格的非官方的个\"},{\"answer\":true,\"text\":\"的非官方的个的非官方的\"},{\"answer\":true,\"text\":\"的法规的法规瑞特人员用\"},{\"answer\":false,\"text\":\"挺容易热一热依然\"}]','2015-07-12 08:31:24','yes',0,0,NULL,NULL),(12,16,'孙丹菲该死的风格收到收到','孙丹菲该死的风格','exam',NULL,0,0,0,'no',NULL,'[{\"answer\":true,\"text\":\"我就不明白了你到底想要什么么\"},{\"answer\":false,\"text\":\"地方的发生个地方\"},{\"answer\":false,\"text\":\"的风格地方\"},{\"answer\":false,\"text\":\"的非官方的个\"}]','2015-07-12 08:42:10','yes',0,0,NULL,NULL),(13,27,'我就不名白','微微i外i诶为i喂喂 &nbsp;','video','/slsxpt//upload/video/d63a86c891a97cd40ce3e12424c51c49.mp4',0,0,0,'no',NULL,NULL,'2015-07-17 09:36:49','yes',0,0,'/slsxpt//upload/thumbnail/d63a86c891a97cd40ce3e12424c51c49.jpg',NULL),(14,27,'我就不名白','微微i外i诶为i喂喂 &nbsp;','video','/slsxpt//upload/video/d63a86c891a97cd40ce3e12424c51c49.mp4',0,0,0,'no',NULL,NULL,'2015-07-17 09:40:46','yes',0,0,'/slsxpt//upload/thumbnail/d63a86c891a97cd40ce3e12424c51c49.jpg',NULL),(15,26,'了加拉加斯了风景撒的发蓝精灵','聊得来会计师的疯狂了估计','video','/slsxpt//upload/video/6f05d4985598160c548e6e8f537247c8.mp4',0,0,0,'no',NULL,NULL,'2015-07-17 10:24:35','yes',0,0,'/slsxpt//upload/thumbnail/6b62ac7780be8d480c3b42fc789d4db2.jpg',NULL),(17,8,'额额个人股的法规的法规','低功耗肉汤圆他人45','exam',NULL,0,0,0,'no',NULL,'[{\"answer\":true,\"text\":\"如何规范和规范和法规和法规和\"},{\"answer\":true,\"text\":\"法规和法规发给发给\"},{\"answer\":false,\"text\":\"法国恢复好发过火发货方\"},{\"answer\":false,\"text\":\"方法好繁华发股份发给发给\"}]','2015-07-17 12:36:32','yes',0,0,NULL,NULL),(18,16,'我就不信了哈','的双方各的双方各是大法官的双方各','exam',NULL,0,0,0,'no',NULL,'[{\"answer\":true,\"text\":\"尔特我让他二\"},{\"answer\":false,\"text\":\"儿童额问题而突然\"},{\"answer\":false,\"text\":\"福德宫发的规范和\"},{\"answer\":false,\"text\":\"放到发局域\"}]','2015-07-17 12:37:52','yes',0,0,NULL,NULL),(19,31,'规范的所说的','的双方各都是发感染他人太让他人突然很发放到放到','audio','/slsxpt//upload/audio/a7054ed0515a34edeec4eb771d84649d.mp3',0,0,0,'no',NULL,NULL,'2015-07-17 12:44:55','yes',0,0,NULL,NULL),(20,29,'了吉林省大机房了跨世纪的老规矩的斯洛伐克赶紧了的哭声房价高了','<h1><a href=\"http://www.cnblogs.com/dqrcsc/p/4655772.html\" target=\"\" rel=\"\">android菜鸟学习笔记29----Android应用向用户发送提示信息的方式总结</a></h1><ul><li>常见的向用户发送提示信息的方式有3种，分别为：1)发送Toast信息2)弹出对话框3)发送通知总结如下：方式1：发送Toast信息：这种方式最简单，在之前的学习中多次使用过。Toast是在一个浮动于应用之上的View中显示信息，显示一定的时间间隔后自动消失，不可获得焦点。最简单的用法就是之前的学习中一直使用的：通过一个静态的makeText()方法返回一个Toast对象，然后调用sho</li><li>的风格w()方法。如：布局文件添加一个Button:</li></ul>','article',NULL,0,0,0,'no',NULL,NULL,'2015-07-17 13:44:39','yes',0,0,NULL,'android菜鸟学习笔记29----Android应用向用户发送提示信息的方式'),(21,29,'的双方各都是发过来快圣诞节了开发工具栏的开始放假','<ul><li>第三个的反光镜的，发神经更凉快的水井坊了酷狗了对方就够了看电视剧sd</li><li>了广东省将反光镜的洛杉矶古老的发神经公路局的路口水晶宫了圣诞节反过来看</li><li>；的发生见鬼了会计的说法了更简单了收款方</li><li>凉快的说法金刚狼的健身房了更简单了双方均高</li><li>快高考楼上的机房了高考就上当了反光镜了</li></ul>','article',NULL,0,0,0,'no',NULL,NULL,'2015-07-17 13:47:58','yes',0,0,NULL,'第三个的反光镜的，发神经更凉快的水井坊了酷狗了对方就够了看电视剧sd 了广东省将'),(22,30,'放大镜更凉快的说法了快过节了的咖啡机更凉快的水井坊了控股将发大水了科技感的风景谁离开过','的三个楼上的发过来就盯上了快过节了的发生就挂了会计师的发了髋关节的路口房价高了第三方见鬼了会计的了世界观来看<br><ol><li>快过节了的发生就挂了会计师的发了髋关节的路口房价高了第三方见鬼了会计的了世界观来看</li><li>快过节了的发生就挂了会计师的发了髋关节的路口房价高了第三方见鬼了会计的了世界观来看</li><li>快过节了的发生就挂了会计师的发了髋关节的路口房价高了第三方见鬼了会计的了世界观来看</li><li>快过节了的发生就挂了会计师的发了髋关节的路口房价高了第三方见鬼了会计的了世界观来看</li></ol>','article',NULL,0,0,0,'no',NULL,NULL,'2015-07-17 13:48:35','yes',0,0,NULL,'的三个楼上的发过来就盯上了快过节了的发生就挂了会计师的发了髋关节的路口房价高了第'),(23,30,'梵蒂冈梵蒂冈的挂号费的和规范化','快的说法国际化的开始讲风格和会计和的发生过<br>的风景上两个激烈的发神经l的浪费水晶宫了看见对方<br>的发神经更凉快的风景谁离开估计快了d<br>的哭声分公司的fgreiwtgfdsfghkdjfs','article',NULL,0,0,0,'no',NULL,NULL,'2015-07-17 13:49:05','yes',0,0,NULL,'快的说法国际化的开始讲风格和会计和的发生过 的风景上两个激烈的发神经l的浪费水晶'),(24,30,'额外热热帖呀让他和方法女不能更好的法规和','是梵蒂冈孙丹菲该死的风格都是经费的假两件的谁','article',NULL,0,0,0,'no',NULL,NULL,'2015-07-17 13:50:15','yes',0,0,NULL,'是梵蒂冈孙丹菲该死的风格都是经费的假两件的谁'),(25,30,'的双方各是的非官方的谁干的少发广告发生的个','<ol><li>的发生该发生感染他很反<b>感合肥的规划</b></li><li><b><br></b></li><li><b><br></b></li><li><b><br></b></li><li><b>的发生该发生感染他很反<span class=\"wysiwyg-color-red\">感合肥的规划法规和规范和地方&nbsp;</span></b><span><b><span class=\"wysiwyg-color-red\">的发生该发生感染他<br><br>好几个和经费和规范环境<br>很反感合肥的</span>规划法规和规范和</b>地方&nbsp;</span></li></ol><br>非官方的树干上的风格孙丹菲<br><ol><li>就了第三方见鬼了会计的发生了看过就疯狂的了睡</li><li>陆地上就发个链接的了三方工具惹你狗了的份上就赶快了</li><li>的风格地方谁跟谁的感染过</li></ol>','article',NULL,0,0,0,'no',NULL,NULL,'2015-07-17 13:51:20','yes',0,0,NULL,'的发生该发生感染他很反感合肥的规划 的发生该发生感染他很反感合肥的规划法规和规范'),(26,29,'的非官方的谁勾搭上了金刚经当上了髋关节的法律上会计','的发生过的发生过的双方均过路口发生的金刚狼的风景受够了<br>将第三方离开家更凉快打飞机更快乐简单来说开复工IE加我ijgfdlkjdfljg &nbsp;<br>两个<br>的双方各扣篮大赛风景咯咯IE网购i人的烦恼赶快的技能<br>的了罚款水晶宫快乐的健身房了客观讲<br><br>的发生了看过就凉快的深加工了发神经的<br><b>的房价高了经费的说了句</b><br><b>洛杉矶了罚款讲的是快乐方</b>','article',NULL,0,0,0,'no',NULL,NULL,'2015-07-17 13:51:52','yes',0,0,NULL,'的发生过的发生过的双方均过路口发生的金刚狼的风景受够了 将第三方离开家更凉快打飞'),(27,29,' 的双方各的发生过的非官方的的符合法规和规范V承包，出校门，吧','的双方各收到发过了开始的见鬼了肯德基发过了鬼地方个的说法<br><span>各收到发过了开始的见鬼了肯德基发过了鬼地方个的说法<br></span><span>各收到发过了开始的见鬼了肯德基发过了鬼地方个的说法<br></span><span>各收到发过了开始的见鬼了肯德基发过了鬼地方个的说法<br></span>各收到发过了开始的见鬼了肯德基发过了鬼地方个的说法<br>','article',NULL,0,0,0,'no',NULL,NULL,'2015-07-17 13:52:14','yes',0,0,NULL,'的双方各收到发过了开始的见鬼了肯德基发过了鬼地方个的说法 各收到发过了开始的见鬼'),(28,29,'的双方各收到法规发生的官方给','<h1>的分公司的广东省法规的双方各军绿色的见鬼了会计的了疯狂世界观来看的双方均高</h1><h1><u><br></u>了地方开始加干辣椒的发了水果机</h1><h1><u><br></u>流口水的反光镜的发生了赶紧了开放的</h1><h1><br></h1><h1>就凉快的说法见鬼了会计的发生了客观讲</h1><h1><u><br></u>老公的复式结构i如饿哦IE发的啥看法和高科技的说法&nbsp;</h1><br><br>','article',NULL,0,0,0,'no',NULL,NULL,'2015-07-17 13:52:58','yes',0,0,NULL,'的分公司的广东省法规的双方各军绿色的见鬼了会计的了疯狂世界观来看的双方均高 了地'),(29,29,'讽德诵功发生的广泛的三个发生的工地上干','的分公司的非官方的广泛的法规和方法的和东方红','article',NULL,0,0,0,'no',NULL,NULL,'2015-07-17 13:53:13','yes',0,0,NULL,'的分公司的非官方的广泛的法规和方法的和东方红'),(30,30,'上的风格的说法赶得上法规发生的国防生的刚','的发生过的双方各都是分公司的分公司的广泛孙丹菲该死的风格是','article',NULL,0,0,0,'no',NULL,NULL,'2015-07-17 13:53:32','yes',0,0,NULL,'的发生过的双方各都是分公司的分公司的广泛孙丹菲该死的风格是');
/*!40000 ALTER TABLE `project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tag`
--

DROP TABLE IF EXISTS `tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(11) NOT NULL COMMENT '标签名词',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag`
--

LOCK TABLES `tag` WRITE;
/*!40000 ALTER TABLE `tag` DISABLE KEYS */;
/*!40000 ALTER TABLE `tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tag_select`
--

DROP TABLE IF EXISTS `tag_select`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tag_select` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) NOT NULL,
  `tag_id` int(11) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `project_id` (`project_id`),
  KEY `tag_id` (`tag_id`),
  CONSTRAINT `tag_select_ibfk_1` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`),
  CONSTRAINT `tag_select_ibfk_2` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag_select`
--

LOCK TABLES `tag_select` WRITE;
/*!40000 ALTER TABLE `tag_select` DISABLE KEYS */;
/*!40000 ALTER TABLE `tag_select` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test`
--

DROP TABLE IF EXISTS `test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `test` (
  `id` int(11) NOT NULL,
  `answer` text NOT NULL COMMENT '用户作答，json格式',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建日期',
  `project_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_test_project1_idx` (`project_id`),
  KEY `fk_user_test_user1_idx` (`user_id`),
  CONSTRAINT `fk_user_test_project1` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_test_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='测试\n';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test`
--

LOCK TABLES `test` WRITE;
/*!40000 ALTER TABLE `test` DISABLE KEYS */;
/*!40000 ALTER TABLE `test` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) NOT NULL,
  `password` varchar(64) NOT NULL,
  `salt` varchar(64) NOT NULL,
  `name` varchar(64) DEFAULT NULL,
  `gold` int(11) DEFAULT '0',
  `progress` int(11) DEFAULT '0',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `code` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (7,'admin888','7ca9d77f852e7205d74f7e91bbc5d40d','72acf2e2e5ff4f17882b4173832fa43f',NULL,NULL,NULL,'2015-06-28 08:29:32','2015-06-28 08:29:32','lvyahui8@126.com',NULL,''),(9,'lvyahui','00b25acc721a6989148fd2491233a71a','3464b746e8c44ff9b97c20826cf05348',NULL,NULL,NULL,'2015-06-28 14:32:25','2015-06-28 14:32:25','lvyahui6@163.com',NULL,'3340b609ed484d29b3d0da38802afc7a');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `view`
--

DROP TABLE IF EXISTS `view`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `view` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `project_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_view_project1_idx` (`project_id`),
  KEY `fk_view_user1_idx` (`user_id`),
  CONSTRAINT `fk_view_project1` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_view_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='浏览';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `view`
--

LOCK TABLES `view` WRITE;
/*!40000 ALTER TABLE `view` DISABLE KEYS */;
/*!40000 ALTER TABLE `view` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-07-17 22:00:25
