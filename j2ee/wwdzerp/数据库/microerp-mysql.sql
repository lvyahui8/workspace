-- MySQL dump 10.10
--
-- Host: localhost    Database: microerp
-- ------------------------------------------------------
-- Server version	5.0.15-nt

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
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` bigint(20) NOT NULL,
  `sn` varchar(16) default NULL,
  `title` varchar(100) default NULL,
  `types` varchar(16) default NULL,
  `leader` varchar(50) default NULL,
  `linkMan` varchar(50) default NULL,
  `tel` varchar(50) default NULL,
  `address` varchar(50) default NULL,
  `zip` varchar(20) default NULL,
  `fax` varchar(50) default NULL,
  `email` varchar(50) default NULL,
  `homePage` varchar(50) default NULL,
  `source` varchar(50) default NULL,
  `rank` varchar(50) default NULL,
  `intro` text,
  `remark` text,
  `inputUser` varchar(16) default NULL,
  `inputTime` datetime default NULL,
  `status` int(11) default NULL,
  `province` varchar(50) default NULL,
  `city` varchar(50) default NULL,
  `town` varchar(50) default NULL,
  `parent_id` varchar(16) default NULL,
  `balance` decimal(19,4) default NULL,
  `ticketNum` int(11) default NULL,
  `debt` decimal(19,4) default NULL,
  `balanceBarrel` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `customer`
--


/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
LOCK TABLES `customer` WRITE;
INSERT INTO `customer` VALUES (1,'014605','孟保良','0','fgfdg','','65432115,13618205778','南桥路阳光家园A5  5-1',NULL,NULL,NULL,NULL,'朋友介绍','VIP客户','','dfsdf',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0.0000',11,'267.4000',59),(2,'01DP0001  ','遵义钛厂工贸公司    ','0','','','68817023   ','大坪电视塔村5号楼2-9       ',NULL,NULL,NULL,NULL,'','','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0.0000',0,'0.0000',NULL),(3,'01DP0005  ','黄强                ','2','','','681203839  ','珠江花园13栋12-6            ',NULL,NULL,NULL,NULL,'','','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0.0000',0,'0.0000',0),(4,'01DP0012  ','蔡峰    荷兰        ','2','','','68713617','电视塔村13号2单元7-9     ',NULL,NULL,NULL,NULL,'','','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0.0000',NULL,'0.0000',NULL),(5,'01DP0022  ','夏琴                ','0','','','68701099','电视塔村13号2单元9-2   ',NULL,NULL,NULL,NULL,'','','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0.0000',NULL,'0.0000',NULL),(337,'01JL0303  ','唐桂平              ','0','','','68728398   ','歇台子金银湾200号3单元10-111',NULL,NULL,NULL,NULL,'','','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0.0000',NULL,'0.0000',NULL),(338,'01JL0304  ','胡太平              ','0','','','13708386713','大渡口园丁小区2号楼3单元111号',NULL,NULL,NULL,NULL,'','','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0.0000',NULL,'0.0000',NULL),(339,'01JL0305  ','九龙装饰公司        ','0','','','68656399   ','石坪桥怡然酒店21-188      ',NULL,NULL,NULL,NULL,'','','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0.0000',NULL,'0.0000',NULL),(340,'01JL0306  ','古建华              ','0','','','68914716','大渡口马王三村4栋2单元4-9',NULL,NULL,NULL,NULL,'','','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0.0000',NULL,'0.0000',NULL);
UNLOCK TABLES;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;

--
-- Table structure for table `customerprice`
--

DROP TABLE IF EXISTS `customerprice`;
CREATE TABLE `customerprice` (
  `id` bigint(20) NOT NULL,
  `customer_id` bigint(20) default NULL,
  `product_id` bigint(20) default NULL,
  `price` decimal(19,4) default NULL,
  `unit` varchar(16) default NULL,
  `vdate` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `customerprice`
--


/*!40000 ALTER TABLE `customerprice` DISABLE KEYS */;
LOCK TABLES `customerprice` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `customerprice` ENABLE KEYS */;

--
-- Table structure for table `dealinfo`
--

DROP TABLE IF EXISTS `dealinfo`;
CREATE TABLE `dealinfo` (
  `id` bigint(20) NOT NULL,
  `customer_id` bigint(20) default NULL,
  `systemuser_id` bigint(20) default NULL,
  `order_id` bigint(20) default NULL,
  `sum` decimal(19,4) default NULL,
  `vdate` datetime default NULL,
  `dealType` int(11) default NULL,
  `payType` int(11) default NULL,
  `payment` varchar(16) default NULL,
  `inputTime` datetime default NULL,
  `inputUser` varchar(8) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `dealinfo`
--


/*!40000 ALTER TABLE `dealinfo` DISABLE KEYS */;
LOCK TABLES `dealinfo` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `dealinfo` ENABLE KEYS */;

--
-- Table structure for table `delivery`
--

DROP TABLE IF EXISTS `delivery`;
CREATE TABLE `delivery` (
  `id` bigint(20) NOT NULL,
  `sn` varchar(16) default NULL,
  `carno` varchar(20) default NULL,
  `deliver` varchar(20) default NULL,
  `appointer` varchar(20) default NULL,
  `sender` varchar(20) default NULL,
  `auditing` varchar(20) default NULL,
  `intro` varchar(200) default NULL,
  `vdate` datetime default NULL,
  `status` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `delivery`
--


/*!40000 ALTER TABLE `delivery` DISABLE KEYS */;
LOCK TABLES `delivery` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `delivery` ENABLE KEYS */;

--
-- Table structure for table `deliverydetail`
--

DROP TABLE IF EXISTS `deliverydetail`;
CREATE TABLE `deliverydetail` (
  `id` bigint(20) NOT NULL,
  `order_id` bigint(20) default NULL,
  `parent_id` bigint(20) default NULL,
  `backBottle` int(11) default NULL,
  `backWater` int(11) default NULL,
  `backAmount` decimal(19,4) default NULL,
  `intro` varchar(200) default NULL,
  `status` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `deliverydetail`
--


/*!40000 ALTER TABLE `deliverydetail` DISABLE KEYS */;
LOCK TABLES `deliverydetail` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `deliverydetail` ENABLE KEYS */;

--
-- Table structure for table `orderdetail`
--

DROP TABLE IF EXISTS `orderdetail`;
CREATE TABLE `orderdetail` (
  `id` bigint(20) NOT NULL,
  `order_id` bigint(20) default NULL,
  `product_id` bigint(20) default NULL,
  `types` varchar(16) default NULL,
  `num` double default NULL,
  `price` decimal(19,4) default NULL,
  `amount` decimal(19,4) default NULL,
  `unit` varchar(16) default NULL,
  `status` int(11) default NULL,
  `sequence` int(11) default NULL,
  `width` double default NULL,
  `height` double default NULL,
  `unitType` int(11) default NULL,
  `cou` int(11) default NULL,
  `vdate` datetime default NULL,
  `intro` varchar(100) default NULL,
  `beginSn` int(11) default NULL,
  `endSn` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `orderdetail`
--


/*!40000 ALTER TABLE `orderdetail` DISABLE KEYS */;
LOCK TABLES `orderdetail` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `orderdetail` ENABLE KEYS */;

--
-- Table structure for table `orderinfo`
--

DROP TABLE IF EXISTS `orderinfo`;
CREATE TABLE `orderinfo` (
  `id` bigint(20) NOT NULL,
  `sn` varchar(16) NOT NULL,
  `customer_id` bigint(20) default NULL,
  `vdate` datetime default NULL,
  `requireDate` datetime default NULL,
  `payType` varchar(16) default NULL,
  `linkMan` varchar(50) default NULL,
  `tel` varchar(50) default NULL,
  `address` varchar(50) default NULL,
  `requirement` text,
  `remark` text,
  `amount` decimal(19,4) default NULL,
  `handPerson` varchar(16) default NULL,
  `inputUser` varchar(16) default NULL,
  `inputTime` datetime default NULL,
  `opUser` varchar(16) default NULL,
  `opIntro` text,
  `opTime` datetime default NULL,
  `status` int(11) default NULL,
  `paymentStatus` int(11) default NULL,
  `invoiceSum` decimal(19,4) default NULL,
  `realSum` decimal(19,4) default NULL,
  `managerFee` decimal(19,4) default NULL,
  `workTip` decimal(19,4) default NULL,
  `donateTickt` int(11) default NULL,
  `donateMachine` int(11) default NULL,
  `types` int(11) default NULL,
  `payment_id` bigint(20) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `orderinfo`
--


/*!40000 ALTER TABLE `orderinfo` DISABLE KEYS */;
LOCK TABLES `orderinfo` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `orderinfo` ENABLE KEYS */;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment` (
  `id` bigint(20) NOT NULL,
  `vdate` datetime default NULL,
  `sum` decimal(19,4) default NULL,
  `customer_id` varchar(16) default NULL,
  `payUser` varchar(16) default NULL,
  `opUser` varchar(16) default NULL,
  `waterTicket_id` bigint(20) default NULL,
  `price` decimal(19,4) default NULL,
  `num` int(11) default NULL,
  `diffSum` decimal(19,4) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `payment`
--


/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
LOCK TABLES `payment` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` bigint(20) NOT NULL,
  `sn` varchar(16) NOT NULL,
  `title` varchar(50) NOT NULL,
  `types` varchar(16) default NULL,
  `dir` varchar(16) default NULL,
  `unit` varchar(16) default NULL,
  `buyPrice` decimal(19,4) default NULL,
  `salePrice` decimal(19,4) default NULL,
  `pic` varchar(50) default NULL,
  `intro` text,
  `remark` text,
  `systemUser_id` varchar(16) default NULL,
  `inputTime` datetime default NULL,
  `status` int(11) default NULL,
  `customer_id` varchar(16) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product`
--


/*!40000 ALTER TABLE `product` DISABLE KEYS */;
LOCK TABLES `product` WRITE;
INSERT INTO `product` VALUES (1,'02','1 1回归水3加仑','water','','ge','5.0000','5.6000','','',NULL,NULL,NULL,NULL,'6533'),(2,'03','1 1回归水1.3加仑','water','','zhang','4.0000','4.0000','','',NULL,NULL,NULL,NULL,NULL),(3,'04','1 1纯净水5加仑','water','','','2.0000','3.0000','','',NULL,NULL,NULL,NULL,NULL),(4,'05','1 1矿质水5加仑','water','','','2.0000','2.0000','','',NULL,NULL,NULL,NULL,NULL),(5,'06','樵坪纯净水5加仑','water','','','2.0000','5.2000','','',NULL,NULL,NULL,NULL,NULL),(6,'07','樵坪矿泉水5加仑','water','','','5.0000','10.2000','','',NULL,NULL,NULL,NULL,NULL),(7,'08','樵坪矿泉水3加仑','water','','','2.0000','8.2000','','',NULL,NULL,NULL,NULL,NULL),(8,'09','职工用水','water','','','4.0000','5.6000','','',NULL,NULL,NULL,NULL,'4'),(9,'10','押金1','other','','','1.0000','1.0000','','',NULL,NULL,NULL,NULL,'9'),(10,'11','1 1回归水3加仑水票','ticket','','','10.0000','10.0000','','',NULL,NULL,NULL,NULL,NULL),(11,'12','1 1回归水1.3加仑水票','ticket','','','0.0000','0.0000','','',NULL,NULL,NULL,NULL,'5'),(12,'13','1 1纯净水5加仑水票','ticket','','','0.0000','0.0000','','',NULL,NULL,NULL,NULL,NULL),(13,'14','1 1矿质水5加仑水票','ticket','','','0.0000','0.0000','','',NULL,NULL,NULL,NULL,NULL),(14,'15','樵坪纯净水5加仑水票','ticket','','','0.0000','0.0000','','',NULL,NULL,NULL,NULL,NULL),(15,'16','樵坪矿泉水5加仑水票','ticket','','','0.0000','0.0000','','',NULL,NULL,NULL,NULL,NULL),(16,'17','樵坪矿泉水3加仑水票','ticket','','','0.0000','0.0000','','',NULL,NULL,NULL,NULL,NULL),(18,'19','职工用水水票','ticket','','','0.0000','0.0000','','',NULL,NULL,NULL,NULL,NULL);
UNLOCK TABLES;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;

--
-- Table structure for table `systembasicdata`
--

DROP TABLE IF EXISTS `systembasicdata`;
CREATE TABLE `systembasicdata` (
  `id` bigint(20) NOT NULL,
  `sn` varchar(16) NOT NULL,
  `title` varchar(100) default NULL,
  `intro` text,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `systembasicdata`
--


/*!40000 ALTER TABLE `systembasicdata` DISABLE KEYS */;
LOCK TABLES `systembasicdata` WRITE;
INSERT INTO `systembasicdata` VALUES (1167665815531,'sex','性别','标识性别特性'),(1167665919546,'payType','付款方式','可选的付款方式!'),(1167665938953,'customerType','客户类型','客户的类型！'),(1167720790953,'productType','产品类别','产品类别'),(1167720934328,'measureUnit','计量单位','计量单位'),(1167876801514,'carNo','车号','车号'),(1167877627655,'workers','员工','员工'),(1167885322358,'payment','付款情况','付款情况'),(1167977610015,'orderStatus','订单状态','订单状态'),(1168115087171,'customerSource','客户渠道','客户渠道'),(1168115253546,'ranks','信用等级','信用等级');
UNLOCK TABLES;
/*!40000 ALTER TABLE `systembasicdata` ENABLE KEYS */;

--
-- Table structure for table `systembasicdatadetail`
--

DROP TABLE IF EXISTS `systembasicdatadetail`;
CREATE TABLE `systembasicdatadetail` (
  `id` bigint(20) NOT NULL,
  `parent_id` varchar(16) default NULL,
  `title` varchar(50) default NULL,
  `tvalue` varchar(50) default NULL,
  `sequence` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `systembasicdatadetail`
--


/*!40000 ALTER TABLE `systembasicdatadetail` DISABLE KEYS */;
LOCK TABLES `systembasicdatadetail` WRITE;
INSERT INTO `systembasicdatadetail` VALUES (1167665454203,'1166275623625','5','5',1),(1167665826453,'1167665815531','男','man',1),(1167665837921,'1167665815531','女','women',2),(1167665986812,'1167665938953','集团客户','1',1),(1167665999140,'1167665938953','普通客户','0',0),(1167666009062,'1167665938953','水站','2',2),(1167720808437,'1167720790953','水','water',1),(1167720840781,'1167720790953','水票','ticket',2),(1167720862593,'1167720790953','水桶','barrel',3),(1167720869421,'1167720790953','其它','other',4),(1167720951859,'1167720934328','个','ge',0),(1167720973000,'1167720934328','张','zhang',2),(1167720983171,'1167720934328','桶','tong',3),(1167877703530,'1167877627655','蔡亚萍','caiyaping',0),(1167877719873,'1167877627655','伍小波','wuxiaobo',2),(1167878101920,'1167876801514','ca-001','ca-001',0),(1167885342811,'1167885322358','已付','2',2),(1167885356952,'1167885322358','未付','-1',0),(1167885374420,'1167885322358','赠送','3',3),(1167885386764,'1167885322358','坏帐','4',4),(1167885546702,'1167665919546','现金支付','1',1),(1167885559561,'1167665919546','水票支付','3',2),(1167885572123,'1167665919546','转帐','2',3),(1167977639765,'1167977610015','录入中','-1',1),(1167977648359,'1167977610015','已确认','0',2),(1167977705265,'1167977610015','已发货','2',3),(1168107029718,'1167876801514','car002','car002',2),(1168107242031,'1167720790953','饮水机','machine',5),(1168115119265,'1168115087171','朋友介绍','朋友介绍',0),(1168115286968,'1168115253546','一般客户','一般客户',0),(1168115299234,'1168115253546','VIP客户','VIP客户',2);
UNLOCK TABLES;
/*!40000 ALTER TABLE `systembasicdatadetail` ENABLE KEYS */;

--
-- Table structure for table `systemdept`
--

DROP TABLE IF EXISTS `systemdept`;
CREATE TABLE `systemdept` (
  `id` bigint(20) NOT NULL,
  `sn` varchar(16) NOT NULL,
  `title` varchar(100) default NULL,
  `address` varchar(100) default NULL,
  `tel` varchar(50) default NULL,
  `email` varchar(50) default NULL,
  `linkMan` varchar(16) default NULL,
  `manager` varchar(16) default NULL,
  `types` varchar(16) default NULL,
  `intro` text,
  `remark` text,
  `inputUser` varchar(16) default NULL,
  `inputTime` datetime default NULL,
  `lastLoginTime` datetime default NULL,
  `loginTimes` int(11) default NULL,
  `status` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `systemdept`
--


/*!40000 ALTER TABLE `systemdept` DISABLE KEYS */;
LOCK TABLES `systemdept` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `systemdept` ENABLE KEYS */;

--
-- Table structure for table `systemgroup`
--

DROP TABLE IF EXISTS `systemgroup`;
CREATE TABLE `systemgroup` (
  `id` bigint(20) NOT NULL,
  `title` varchar(50) default NULL,
  `intro` varchar(200) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `systemgroup`
--


/*!40000 ALTER TABLE `systemgroup` DISABLE KEYS */;
LOCK TABLES `systemgroup` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `systemgroup` ENABLE KEYS */;

--
-- Table structure for table `systemgroup_systemrole`
--

DROP TABLE IF EXISTS `systemgroup_systemrole`;
CREATE TABLE `systemgroup_systemrole` (
  `systemgroup_id` bigint(20) default NULL,
  `systemrole_id` bigint(20) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `systemgroup_systemrole`
--


/*!40000 ALTER TABLE `systemgroup_systemrole` DISABLE KEYS */;
LOCK TABLES `systemgroup_systemrole` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `systemgroup_systemrole` ENABLE KEYS */;

--
-- Table structure for table `systemgroup_systemuser`
--

DROP TABLE IF EXISTS `systemgroup_systemuser`;
CREATE TABLE `systemgroup_systemuser` (
  `systemrole_id` bigint(20) default NULL,
  `systemgroup_id` bigint(20) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `systemgroup_systemuser`
--


/*!40000 ALTER TABLE `systemgroup_systemuser` DISABLE KEYS */;
LOCK TABLES `systemgroup_systemuser` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `systemgroup_systemuser` ENABLE KEYS */;

--
-- Table structure for table `systemloginfo`
--

DROP TABLE IF EXISTS `systemloginfo`;
CREATE TABLE `systemloginfo` (
  `id` bigint(20) NOT NULL,
  `opType` varchar(16) default NULL,
  `intro` text,
  `vdate` datetime default NULL,
  `userName` varchar(16) default NULL,
  `ip` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `systemloginfo`
--


/*!40000 ALTER TABLE `systemloginfo` DISABLE KEYS */;
LOCK TABLES `systemloginfo` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `systemloginfo` ENABLE KEYS */;

--
-- Table structure for table `systempopedom`
--

DROP TABLE IF EXISTS `systempopedom`;
CREATE TABLE `systempopedom` (
  `id` bigint(20) NOT NULL,
  `title` varchar(50) default NULL,
  `intro` varchar(200) default NULL,
  `parent_id` bigint(20) default NULL,
  `status` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `systempopedom`
--


/*!40000 ALTER TABLE `systempopedom` DISABLE KEYS */;
LOCK TABLES `systempopedom` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `systempopedom` ENABLE KEYS */;

--
-- Table structure for table `systemregion`
--

DROP TABLE IF EXISTS `systemregion`;
CREATE TABLE `systemregion` (
  `id` bigint(20) NOT NULL,
  `title` varchar(64) default NULL,
  `sequence` int(11) default NULL,
  `parent_sn` varchar(64) default NULL,
  `lev` int(11) default NULL,
  `inputTime` datetime default NULL,
  `inputUser` varchar(16) default NULL,
  `sn` varchar(64) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `systemregion`
--


/*!40000 ALTER TABLE `systemregion` DISABLE KEYS */;
LOCK TABLES `systemregion` WRITE;
INSERT INTO `systemregion` VALUES (1,'中华人民共和国',0,'67',0,'2001-08-06 00:00:00','lj','0000000'),(2,'北京',0,'0000000',1,NULL,NULL,'0000001'),(3,'北京市',0,'0000001',2,'2001-08-06 00:00:00','lj','00000010000001'),(4,'东城区',0,'0000001',NULL,NULL,'admin','00000010000002'),(5,'西城区',0,'0000001',NULL,NULL,'admin','00000010000003'),(6,'宣武区',0,'0000001',NULL,NULL,'admin','00000010000004'),(7,'崇文区',0,'0000001',NULL,NULL,'admin','00000010000005'),(8,'朝阳区',0,'0000001',NULL,NULL,'admin','00000010000006'),(9,'海淀区',0,'0000001',NULL,NULL,'admin','00000010000007'),(10,'丰台区',0,'0000001',NULL,NULL,'admin','00000010000008'),(11,'门头沟区',0,'0000001',NULL,NULL,'admin','00000010000009'),(12,'石景山区',0,'0000001',NULL,NULL,'admin','00000010000010'),(13,'福建',2,'0000000',1,NULL,NULL,'0000002'),(14,'福州市',0,'0000002',2,'2001-08-22 16:16:50','Lj','00000020000000'),(15,'南平市',1,'0000002',2,'2001-08-22 16:17:23','Lj','00000020000001'),(16,'宁德市',2,'0000002',2,'2001-08-22 16:17:55','Lj','00000020000002'),(17,'三明市',3,'0000002',2,'2001-08-22 16:18:13','Lj','00000020000003'),(18,'漳州市',4,'0000002',2,'2001-08-22 16:18:36','Lj','00000020000004'),(19,'莆田市',5,'0000002',2,'2001-08-22 16:19:00','Lj','00000020000005'),(20,'龙岩市',6,'0000002',2,'2001-08-22 16:19:17','Lj','00000020000006'),(21,'泉州市',7,'0000002',2,'2001-08-22 16:19:30','Lj','00000020000007'),(22,'厦门市',9,'0000002',2,'2001-08-22 16:19:49','Lj','00000020000008'),(23,'甘肃',0,'0000000',1,'2001-08-06 00:00:00','lj','0000003'),(24,'白银市',0,'0000003',2,'2001-08-22 16:24:17','Lj','00000030000000'),(25,'甘南藏族自治州',1,'0000003',2,'2001-08-22 16:24:36','Lj','00000030000001'),(26,'金昌市',2,'0000003',2,'2001-08-22 16:25:05','Lj','00000030000002'),(27,'陇南地区',3,'0000003',2,'2001-08-22 16:25:17','Lj','00000030000003'),(28,'平凉市',4,'0000003',2,'2001-08-22 16:25:33','Lj','00000030000004'),(29,'庆阳地区',5,'0000003',2,'2001-08-22 16:25:45','Lj','00000030000005'),(30,'天水市',6,'0000003',2,'2001-08-22 16:25:59','Lj','00000030000006'),(31,'定西地区/县',7,'0000003',2,'2001-08-22 16:26:17','Lj','00000030000007'),(32,'嘉峪关市',8,'0000003',2,'2001-08-22 16:26:30','Lj','00000030000008'),(33,'酒泉市',9,'0000003',2,'2001-08-22 16:27:05','Lj','00000030000009'),(34,'兰州市',10,'0000003',2,'2001-08-22 16:27:19','Lj','00000030000010'),(35,'宁夏回族自治州/宁夏市',11,'0000003',2,'2001-08-22 16:27:42','Lj','00000030000011'),(36,'武威市',12,'0000003',2,'2001-08-22 16:28:47','Lj','00000030000012'),(37,'张掖市',13,'0000003',2,'2001-08-22 16:29:03','Lj','00000030000013'),(38,'临夏市',14,'0000003',2,'2001-08-22 16:29:31','Lj','00000030000014'),(39,'广东',0,'0000000',1,'2001-08-06 00:00:00','lj','0000004'),(40,'潮州市',0,'0000004',2,'2001-08-22 16:30:53','Lj','00000040000000'),(41,'佛山市',1,'0000004',2,'2001-08-22 16:31:05','Lj','00000040000001'),(42,'河源市',2,'0000004',2,'2001-08-22 16:31:17','Lj','00000040000002'),(43,'江门市',3,'0000004',2,'2001-08-22 16:31:33','Lj','00000040000003'),(44,'茂名市',4,'0000004',2,'2001-08-22 16:31:46','Lj','00000040000004'),(45,'清远市',5,'0000004',2,'2001-08-22 16:31:59','Lj','00000040000005'),(46,'汕头市',6,'0000004',2,'2001-08-22 16:32:19','Lj','00000040000006'),(47,'韶关市',7,'0000004',2,'2001-08-22 16:32:32','Lj','00000040000007'),(48,'湛江市',8,'0000004',2,'2001-08-22 16:32:49','Lj','00000040000008'),(49,'珠海市',9,'0000004',2,'2001-08-22 16:33:00','Lj','00000040000009'),(50,'中山市',10,'0000004',2,'2001-08-22 16:33:11','Lj','00000040000010'),(51,'广州市',11,'0000004',2,'2001-08-22 16:33:45','Lj','00000040000011'),(52,'惠州市',12,'0000004',2,'2001-08-22 16:33:59','Lj','00000040000012'),(53,'揭阳市',13,'0000004',2,'2001-08-22 16:34:14','Lj','00000040000013'),(54,'梅州市',14,'0000004',2,'2001-08-22 16:34:27','Lj','00000040000014'),(55,'汕尾市',15,'0000004',2,'2001-08-22 16:34:38','Lj','00000040000015'),(56,'深圳市',16,'0000004',2,'2001-08-22 16:34:50','Lj','00000040000016'),(57,'阳江市',17,'0000004',2,'2001-08-22 16:35:03','Lj','00000040000017'),(58,'云浮市',18,'0000004',2,'2001-08-22 16:35:15','Lj','00000040000018'),(59,'肇庆市',19,'0000004',2,'2001-08-22 16:35:26','Lj','00000040000019'),(60,'顺德市',20,'0000004',2,NULL,NULL,'00000040000020'),(61,'东莞市',21,'0000004',2,NULL,NULL,'00000040000021'),(62,'普宁市',22,'0000004',2,NULL,NULL,'00000040000022'),(63,'澄海市',23,'0000004',2,NULL,NULL,'00000040000023'),(64,'鹤山市',24,'0000004',NULL,NULL,'admin','00000040000024'),(65,'新会市',25,'0000004',NULL,NULL,'admin','00000040000025'),(66,'广西',0,'0000000',1,'2001-08-06 00:00:00','lj','0000005'),(67,'百色地区',0,'0000005',2,'2001-08-22 16:36:37','Lj','00000050000000'),(68,'防城港市',1,'0000005',2,'2001-08-22 16:36:51','Lj','00000050000001'),(69,'桂林市',2,'0000005',2,'2001-08-22 16:37:03','Lj','00000050000002'),(70,'贺州地区',3,'0000005',2,'2001-08-22 16:37:15','Lj','00000050000003'),(71,'柳州市',4,'0000005',2,'2001-08-22 16:37:27','Lj','00000050000004'),(72,'梧州市',5,'0000005',2,'2001-08-22 16:37:38','Lj','00000050000005'),(73,'北海市',6,'0000005',2,'2001-08-22 16:37:53','Lj','00000050000006'),(74,'贵港市',7,'0000005',2,'2001-08-22 16:38:04','Lj','00000050000007'),(75,'河池地区',8,'0000005',2,'2001-08-22 16:38:16','Lj','00000050000008'),(76,'南宁市',9,'0000005',2,'2001-08-22 16:38:31','Lj','00000050000009'),(77,'钦州市',10,'0000005',2,'2001-08-22 16:38:44','Lj','00000050000010'),(78,'玉林市',11,'0000005',2,'2001-08-22 16:38:55','Lj','00000050000011'),(79,'贵州',0,'0000000',1,'2001-08-06 00:00:00','lj','0000006'),(80,'安顺市',0,'0000006',2,'2001-08-22 16:39:49','Lj','00000060000000'),(81,'贵阳市',1,'0000006',2,'2001-08-22 16:40:01','Lj','00000060000001'),(82,'六盘水市',2,'0000006',2,'2001-08-22 16:40:14','Lj','00000060000002'),(83,'都匀市',3,'0000006',2,'2001-08-22 16:40:37','Lj','00000060000003'),(84,'铜仁市',4,'0000006',2,'2001-08-22 16:40:53','Lj','00000060000004'),(85,'毕节市',5,'0000006',2,'2001-08-22 16:41:15','Lj','00000060000005'),(86,'遵义市',6,'0000006',2,'2001-08-22 16:41:30','Lj','00000060000006'),(87,'凯里市',7,'0000006',2,'2001-08-22 16:41:45','Lj','00000060000007'),(88,'兴义市',8,'0000006',2,'2001-08-22 16:42:02','Lj','00000060000008'),(89,'海南',0,'0000000',1,NULL,NULL,'0000007'),(90,'海口市',0,'0000007',2,'2001-08-22 16:43:14','Lj','00000070000000'),(91,'三亚市',1,'0000007',2,'2001-08-22 16:43:32','Lj','00000070000001'),(92,'东方市',2,'0000007',2,'2001-08-23 15:07:21','Lj','00000070000002'),(93,'琼海市',3,'0000007',2,'2001-08-23 15:07:37','Lj','00000070000003'),(94,'琼山市',4,'0000007',2,'2001-08-23 15:07:48','Lj','00000070000004'),(95,'通什市',5,'0000007',2,'2001-08-23 15:08:00','Lj','00000070000005'),(96,'文昌市',6,'0000007',2,'2001-08-23 15:08:11','Lj','00000070000006'),(97,'万宁市',7,'0000007',2,'2001-08-23 15:08:21','Lj','00000070000007'),(98,'儋州市',8,'0000007',2,'2001-08-23 15:08:54','Lj','00000070000008'),(99,'河南',0,'0000000',1,'2001-08-06 00:00:00','lj','0000008'),(100,'安阳市',0,'0000008',2,'2001-08-22 16:44:47','Lj','00000080000000'),(101,'焦作市',1,'0000008',2,'2001-08-22 16:45:02','Lj','00000080000001'),(102,'驻马店市',2,'0000008',2,'2001-08-22 16:45:20','Lj','00000080000002'),(103,'洛阳市',3,'0000008',2,'2001-08-22 16:45:47','Lj','00000080000003'),(104,'南阳市',4,'0000008',2,'2001-08-22 16:46:11','Lj','00000080000004'),(105,'商丘市',5,'0000008',2,'2001-08-22 16:46:25','Lj','00000080000005'),(106,'郑州市',6,'0000008',2,'2001-08-22 16:46:37','Lj','00000080000006'),(107,'新乡市',7,'0000008',2,'2001-08-22 16:46:52','Lj','00000080000007'),(108,'许昌市',8,'0000008',2,'2001-08-22 16:47:04','Lj','00000080000008'),(109,'鹤壁市',9,'0000008',2,'2001-08-22 16:47:16','Lj','00000080000009'),(110,'开封市',10,'0000008',2,'2001-08-22 16:47:30','Lj','00000080000010'),(111,'濮阳市',11,'0000008',2,'2001-08-22 16:47:42','Lj','00000080000011'),(112,'平顶山市',12,'0000008',2,'2001-08-22 16:47:56','Lj','00000080000012'),(113,'漯河市',13,'0000008',2,'2001-08-22 16:48:08','Lj','00000080000013'),(114,'三门峡市',14,'0000008',2,'2001-08-22 16:48:20','Lj','00000080000014'),(115,'周口市',15,'0000008',2,'2001-08-22 16:48:49','Lj','00000080000015'),(116,'信阳市',16,'0000008',2,'2001-08-22 16:49:02','Lj','00000080000016'),(117,'巩义市',17,'0000008',NULL,NULL,'admin','00000080000017'),(118,'黑龙江',0,'0000000',1,'2001-08-06 00:00:00','lj','0000009'),(119,'大庆市',0,'0000009',2,'2001-08-22 16:49:53','Lj','00000090000000'),(120,'哈尔滨市',1,'0000009',2,'2001-08-22 16:50:06','Lj','00000090000001'),(121,'黑河市',2,'0000009',2,'2001-08-22 16:50:21','Lj','00000090000002'),(122,'佳木斯市',3,'0000009',2,'2001-08-22 16:50:34','Lj','00000090000003'),(123,'齐齐哈尔市',4,'0000009',2,'2001-08-22 16:50:45','Lj','00000090000004'),(124,'双鸭山市',5,'0000009',2,'2001-08-22 16:50:58','Lj','00000090000005'),(125,'伊春市',6,'0000009',2,'2001-08-22 16:51:12','Lj','00000090000006'),(126,'大兴安岭（加格达奇）',7,'0000009',2,'2001-08-22 16:51:29','Lj','00000090000007'),(127,'鹤岗市',8,'0000009',2,'2001-08-22 16:51:44','Lj','00000090000008'),(128,'鸡西市',9,'0000009',2,'2001-08-22 16:51:59','Lj','00000090000009'),(129,'牡丹江市',10,'0000009',2,'2001-08-22 16:52:13','Lj','00000090000010'),(130,'七台河市',11,'0000009',2,'2001-08-22 16:52:26','Lj','00000090000011'),(131,'绥化市',12,'0000009',2,'2001-08-22 16:52:39','Lj','00000090000012'),(132,'吉林',0,'0000000',1,'2001-08-06 00:00:00','lj','0000010'),(133,'白城市',0,'0000010',2,'2001-08-22 16:53:49','Lj','00000100000000'),(134,'长春市',1,'0000010',2,'2001-08-22 16:54:04','Lj','00000100000001'),(135,'四平市',2,'0000010',2,'2001-08-22 16:54:15','Lj','00000100000002'),(136,'通化市',3,'0000010',2,'2001-08-22 16:54:34','Lj','00000100000003'),(137,'白山市',4,'0000010',2,'2001-08-22 16:54:46','Lj','00000100000004'),(138,'辽源市',5,'0000010',2,'2001-08-22 16:54:58','Lj','00000100000005'),(139,'松原市',6,'0000010',2,'2001-08-22 16:55:11','Lj','00000100000006'),(140,'延边朝鲜族自治州',7,'0000010',2,'2001-08-22 16:55:23','Lj','00000100000007'),(141,'吉林市',8,'0000010',NULL,NULL,'admin','00000100000008'),(142,'磐石市',9,'0000010',NULL,NULL,'admin','00000100000009'),(143,'江苏',0,'0000000',1,'2001-08-06 00:00:00','lj','0000011'),(144,'常州市',0,'0000011',2,'2001-08-22 16:56:28','Lj','00000110000000'),(145,'连云港市',1,'0000011',2,'2001-08-22 16:56:38','Lj','00000110000001'),(146,'南通市',2,'0000011',2,'2001-08-22 16:56:50','Lj','00000110000002'),(147,'宿迁市',3,'0000011',2,'2001-08-22 16:57:02','Lj','00000110000003'),(148,'无锡市',4,'0000011',2,'2001-08-22 16:57:14','Lj','00000110000004'),(149,'扬州市',5,'0000011',2,'2001-08-22 16:57:29','Lj','00000110000005'),(150,'徐州市',6,'0000011',2,'2001-08-22 16:57:41','Lj','00000110000006'),(151,'淮阴市',7,'0000011',2,'2001-08-22 16:57:56','Lj','00000110000007'),(152,'南京市',8,'0000011',2,'2001-08-22 16:58:09','Lj','00000110000008'),(153,'苏州市',9,'0000011',2,'2001-08-22 16:58:21','Lj','00000110000009'),(154,'泰州市',10,'0000011',2,'2001-08-22 16:58:32','Lj','00000110000010'),(155,'盐城市',11,'0000011',2,'2001-08-22 16:58:42','Lj','00000110000011'),(156,'镇江市',12,'0000011',2,'2001-08-22 16:58:54','Lj','00000110000012'),(157,'吴江市',13,'0000011',NULL,NULL,'admin','00000110000013'),(158,'丹阳市',14,'0000011',NULL,NULL,'admin','00000110000014'),(159,'江阴市',15,'0000011',NULL,NULL,'admin','00000110000015'),(160,'辽宁',0,'0000000',1,'2001-08-06 00:00:00','lj','0000012'),(161,'鞍山市',0,'0000012',2,'2001-08-22 17:00:32','Lj','00000120000000'),(162,'朝阳市',1,'0000012',2,'2001-08-22 17:00:45','Lj','00000120000001'),(163,'丹东市',2,'0000012',2,'2001-08-22 17:00:59','Lj','00000120000002'),(164,'阜新市',3,'0000012',2,'2001-08-22 17:01:13','Lj','00000120000003'),(165,'锦州市',4,'0000012',2,'2001-08-22 17:01:26','Lj','00000120000004'),(166,'盘锦市',5,'0000012',2,'2001-08-22 17:01:39','Lj','00000120000005'),(167,'铁岭市',6,'0000012',2,'2001-08-22 17:01:51','Lj','00000120000006'),(168,'本溪市',7,'0000012',2,'2001-08-22 17:02:02','Lj','00000120000007'),(169,'大连市',8,'0000012',2,'2001-08-22 17:02:23','Lj','00000120000008'),(170,'抚顺市',9,'0000012',2,'2001-08-22 17:02:39','Lj','00000120000009'),(171,'葫芦岛市',10,'0000012',2,'2001-08-22 17:02:52','Lj','00000120000010'),(172,'辽阳市',11,'0000012',2,'2001-08-22 17:03:05','Lj','00000120000011'),(173,'沈阳市',12,'0000012',2,'2001-08-22 17:03:16','Lj','00000120000012'),(174,'营口市',13,'0000012',2,'2001-08-22 17:03:28','Lj','00000120000013'),(175,'宁夏',0,'0000000',1,'2001-08-06 00:00:00','lj','0000013'),(176,'固原地区',0,'0000013',2,'2001-08-22 17:04:19','Lj','00000130000000'),(177,'吴忠市',1,'0000013',2,'2001-08-22 17:04:30','Lj','00000130000001'),(178,'石嘴山市',2,'0000013',2,'2001-08-22 17:04:46','Lj','00000130000002'),(179,'银川市',3,'0000013',2,'2001-08-22 17:04:57','Lj','00000130000003'),(180,'浙江',0,'0000000',1,'2001-08-06 00:00:00','lj','0000014'),(181,'青海',0,'0000000',1,'2001-08-06 00:00:00','lj','0000015'),(182,'果洛藏族自治州',0,'0000015',2,'2001-08-22 17:07:32','Lj','00000150000000'),(183,'海东地区',1,'0000015',2,'2001-08-22 17:07:44','Lj','00000150000001'),(184,'海西蒙古族藏族自治州',2,'0000015',2,'2001-08-22 17:07:57','Lj','00000150000002'),(185,'西宁市',3,'0000015',2,'2001-08-22 17:08:11','Lj','00000150000003'),(186,'海北藏族自治州',4,'0000015',2,'2001-08-22 17:08:31','Lj','00000150000004'),(187,'海南藏族自治州',5,'0000015',2,'2001-08-22 17:08:47','Lj','00000150000005'),(188,'黄南藏族自治州',6,'0000015',2,'2001-08-22 17:08:59','Lj','00000150000006'),(189,'玉树藏族自治州',7,'0000015',2,'2001-08-22 17:09:13','Lj','00000150000007'),(190,'山东',0,'0000000',1,'2001-08-06 00:00:00','lj','0000016'),(191,'滨州市',0,'0000016',2,'2001-08-22 17:10:09','Lj','00000160000000'),(192,'东营市',1,'0000016',2,'2001-08-22 17:10:23','Lj','00000160000001'),(193,'济南市',2,'0000016',2,'2001-08-22 17:10:35','Lj','00000160000002'),(194,'淄博市',3,'0000016',2,'2001-08-22 17:10:47','Lj','00000160000003'),(195,'聊城市',4,'0000016',2,'2001-08-22 17:11:01','Lj','00000160000004'),(196,'青岛市',5,'0000016',2,'2001-08-22 17:11:13','Lj','00000160000005'),(197,'泰安市',6,'0000016',2,'2001-08-22 17:11:39','Lj','00000160000006'),(198,'威海市',7,'0000016',2,'2001-08-22 17:12:12','Lj','00000160000007'),(199,'枣庄市',8,'0000016',2,'2001-08-22 17:12:23','Lj','00000160000008'),(200,'德州市',9,'0000016',2,'2001-08-22 17:12:35','Lj','00000160000009'),(201,'菏泽市',10,'0000016',2,'2001-08-22 17:12:50','Lj','00000160000010'),(202,'济宁市',11,'0000016',2,'2001-08-22 17:13:15','Lj','00000160000011'),(203,'莱芜市',12,'0000016',2,'2001-08-22 17:13:47','Lj','00000160000012'),(204,'临沂市',13,'0000016',2,'2001-08-22 17:14:01','Lj','00000160000013'),(205,'日照市',14,'0000016',2,'2001-08-22 17:14:16','Lj','00000160000014'),(206,'潍坊市',15,'0000016',2,'2001-08-22 17:14:27','Lj','00000160000015'),(207,'烟台市',16,'0000016',2,'2001-08-22 17:14:40','Lj','00000160000016'),(208,'龙口市',17,'0000016',2,NULL,NULL,'00000160000017'),(209,'寿光市',18,'0000016',NULL,NULL,'xiaotao','00000160000018'),(210,'山西',0,'0000000',1,'2001-08-06 00:00:00','lj','0000017'),(211,'长治市',0,'0000017',2,'2001-08-22 17:15:48','Lj','00000170000000'),(212,'晋城市',1,'0000017',2,'2001-08-22 17:16:01','Lj','00000170000001'),(213,'吕梁地区',2,'0000017',2,'2001-08-22 17:16:14','Lj','00000170000002'),(214,'朔州市',3,'0000017',2,'2001-08-22 17:16:26','Lj','00000170000003'),(215,'阳泉市',4,'0000017',2,'2001-08-22 17:16:37','Lj','00000170000004'),(216,'忻州地区',5,'0000017',2,'2001-08-22 17:16:50','Lj','00000170000005'),(217,'大同市',6,'0000017',2,'2001-08-22 17:17:03','Lj','00000170000006'),(218,'晋中市',7,'0000017',2,'2001-08-22 17:17:16','Lj','00000170000007'),(219,'临汾地区',8,'0000017',2,'2001-08-22 17:17:28','Lj','00000170000008'),(220,'太原市',9,'0000017',2,'2001-08-22 17:17:39','Lj','00000170000009'),(221,'运城地区',10,'0000017',2,'2001-08-22 17:17:52','Lj','00000170000010'),(222,'汾阳市',11,'0000017',NULL,NULL,'admin','00000170000011'),(223,'陕西',0,'0000000',1,'2001-08-06 00:00:00','lj','0000018'),(224,'安康市',0,'0000018',2,'2001-08-22 17:21:26','Lj','00000180000000'),(225,'汉中市',1,'0000018',2,'2001-08-22 17:21:39','Lj','00000180000001'),(226,'铜川市',2,'0000018',2,'2001-08-22 17:21:53','Lj','00000180000002'),(227,'西安市',3,'0000018',2,'2001-08-22 17:22:07','Lj','00000180000003'),(228,'延安市',4,'0000018',2,'2001-08-22 17:22:21','Lj','00000180000004'),(229,'宝鸡市',5,'0000018',2,'2001-08-22 17:23:01','Lj','00000180000005'),(230,'商洛/商州',6,'0000018',2,'2001-08-22 17:23:16','Lj','00000180000006'),(231,'渭南市',7,'0000018',2,'2001-08-22 17:23:29','Lj','00000180000007'),(232,'咸阳市',8,'0000018',2,'2001-08-22 17:23:41','Lj','00000180000008'),(233,'榆林市',9,'0000018',2,'2001-08-22 17:24:05','Lj','00000180000009'),(234,'上海',0,'0000000',1,'2001-08-06 00:00:00','lj','0000019'),(235,'上海',0,'0000019',NULL,NULL,'admin','00000190000000'),(236,'四川',0,'0000000',1,'2001-08-06 00:00:00','lj','0000020'),(237,'阿坝藏族羌族自治州',0,'0000020',2,'2001-08-22 17:25:35','Lj','00000200000000'),(238,'成都市',1,'0000020',2,'2001-08-22 17:25:47','Lj','00000200000001'),(239,'德阳市',2,'0000020',2,'2001-08-22 17:26:00','Lj','00000200000002'),(240,'广安市',3,'0000020',2,'2001-08-22 17:26:12','Lj','00000200000003'),(241,'资阳市',4,'0000020',2,'2001-08-22 17:26:29','Lj','00000200000004'),(242,'凉山彝族自治州',5,'0000020',2,'2001-08-22 17:26:41','Lj','00000200000005'),(243,'绵阳市',6,'0000020',2,'2001-08-22 17:27:11','Lj','00000200000006'),(244,'南充市',7,'0000020',2,'2001-08-22 17:27:23','Lj','00000200000007'),(245,'泸州市',8,'0000020',2,'2001-08-22 17:27:35','Lj','00000200000008'),(246,'遂宁市',9,'0000020',2,'2001-08-22 17:27:44','Lj','00000200000009'),(247,'宜宾市',10,'0000020',2,'2001-08-22 17:27:56','Lj','00000200000010'),(248,'巴中地区/市',11,'0000020',2,'2001-08-22 17:28:07','Lj','00000200000011'),(249,'达州市',12,'0000020',2,'2001-08-22 17:28:19','Lj','00000200000012'),(250,'甘孜藏族自治州',13,'0000020',2,'2001-08-22 17:28:32','Lj','00000200000013'),(251,'广元市',14,'0000020',2,'2001-08-22 17:28:43','Lj','00000200000014'),(252,'自贡市',15,'0000020',2,'2001-08-22 17:28:53','Lj','00000200000015'),(253,'眉山地区',16,'0000020',2,'2001-08-22 17:29:06','Lj','00000200000016'),(254,'攀枝花市',17,'0000020',2,'2001-08-22 17:29:17','Lj','00000200000017'),(255,'乐山市',18,'0000020',2,'2001-08-22 17:29:44','Lj','00000200000018'),(256,'雅安市',19,'0000020',2,'2001-08-22 17:30:19','Lj','00000200000019'),(257,'台湾',0,'0000000',1,'2001-08-06 00:00:00','lj','0000021'),(258,'天津',0,'0000000',1,'2001-08-06 00:00:00','lj','0000022'),(259,'天津市',0,'0000022',2,'2001-08-06 00:00:00','lj','00000220000001'),(260,'西藏',0,'0000000',1,'2001-08-06 00:00:00','lj','0000023'),(261,'阿里',0,'0000023',2,'2001-08-23 14:19:50','Lj','00000230000000'),(262,'拉萨市',1,'0000023',2,'2001-08-23 14:20:01','Lj','00000230000001'),(263,'林芝（八一镇）',2,'0000023',2,'2001-08-23 14:20:15','Lj','00000230000002'),(264,'日喀则',3,'0000023',2,'2001-08-23 14:20:28','Lj','00000230000003'),(265,'昌都',4,'0000023',2,'2001-08-23 14:20:41','Lj','00000230000004'),(266,'那曲',5,'0000023',2,'2001-08-23 14:20:51','Lj','00000230000005'),(267,'山南（泽当镇）',6,'0000023',2,'2001-08-23 14:21:02','Lj','00000230000006'),(268,'香港',0,'0000000',1,'2001-08-06 00:00:00','lj','0000024'),(269,'香港',0,'0000024',NULL,NULL,'admin','00000240000000'),(270,'新疆',0,'0000000',1,'2001-08-06 00:00:00','lj','0000025'),(271,'阿克苏地区/市',0,'0000025',2,'2001-08-23 14:21:44','Lj','00000250000000'),(272,'博尔塔拉蒙古自治州',1,'0000025',2,'2001-08-23 14:21:54','Lj','00000250000001'),(273,'哈密市',2,'0000025',2,'2001-08-23 14:22:08','Lj','00000250000002'),(274,'喀什市',3,'0000025',2,'2001-08-23 14:22:23','Lj','00000250000003'),(275,'石河子',4,'0000025',2,'2001-08-23 14:22:34','Lj','00000250000004'),(276,'乌鲁木齐市',5,'0000025',2,'2001-08-23 14:22:46','Lj','00000250000005'),(277,'巴音郭楞蒙古自治州',6,'0000025',2,'2001-08-23 14:22:57','Lj','00000250000006'),(278,'昌吉',7,'0000025',2,'2001-08-23 14:23:10','Lj','00000250000007'),(279,'和田市',8,'0000025',2,'2001-08-23 14:23:31','Lj','00000250000008'),(280,'克拉玛依市',9,'0000025',2,'2001-08-23 14:23:40','Lj','00000250000009'),(281,'吐鲁番',10,'0000025',2,'2001-08-23 14:23:51','Lj','00000250000010'),(282,'伊犁哈萨克自治州',11,'0000025',2,'2001-08-23 14:24:02','Lj','00000250000011'),(283,'库尔勒市',12,'0000025',2,NULL,NULL,'00000250000012'),(284,'云南',0,'0000000',1,'2001-08-06 00:00:00','lj','0000026'),(285,'保山地区',0,'0000026',2,'2001-08-22 17:35:49','Lj','00000260000000'),(286,'大理市',1,'0000026',2,'2001-08-22 17:36:15','Lj','00000260000001'),(287,'迪庆藏族自治州',2,'0000026',2,'2001-08-22 17:36:32','Lj','00000260000002'),(288,'昆明市',3,'0000026',2,'2001-08-22 17:36:45','Lj','00000260000003'),(289,'丽江地区',4,'0000026',2,'2001-08-22 17:36:56','Lj','00000260000004'),(290,'曲靖市',5,'0000026',2,'2001-08-22 17:37:06','Lj','00000260000005'),(291,'文山壮族苗族自治州',6,'0000026',2,'2001-08-22 17:37:18','Lj','00000260000006'),(292,'玉溪市',7,'0000026',2,'2001-08-22 17:37:32','Lj','00000260000007'),(293,'楚雄彝族自治州',8,'0000026',2,'2001-08-22 17:37:44','Lj','00000260000008'),(294,'德宏傣族景颇族自治州',9,'0000026',2,'2001-08-22 17:37:56','Lj','00000260000009'),(295,'红河哈尼族彝族自治州',10,'0000026',2,'2001-08-22 17:38:10','Lj','00000260000010'),(296,'怒江傈僳组自治州',11,'0000026',2,'2001-08-22 17:38:23','Lj','00000260000011'),(297,'临沧地区',12,'0000026',2,'2001-08-22 17:38:35','Lj','00000260000012'),(298,'西双版纳傣族自治州',13,'0000026',2,'2001-08-22 17:38:46','Lj','00000260000013'),(299,'昭通地区',14,'0000026',2,'2001-08-22 17:38:56','Lj','00000260000014'),(300,'思茅市',15,'0000026',2,'2001-08-22 17:39:14','Lj','00000260000015'),(301,'重庆',0,'0000000',1,'2001-08-06 00:00:00','lj','0000027'),(302,'重庆市',0,'0000027',2,'2001-08-06 00:00:00','lj','00000270000001'),(303,'内蒙古',0,'0000000',1,'2001-08-06 00:00:00','lj','0000028'),(304,'呼和浩特',0,'0000028',NULL,NULL,'admin','00000280000001'),(305,'包头',0,'0000028',NULL,NULL,'admin','00000280000002'),(306,'乌兰浩特',0,'0000028',NULL,NULL,'admin','00000280000003'),(307,'通辽',0,'0000028',NULL,NULL,'admin','00000280000004'),(308,'锡林浩特',0,'0000028',NULL,NULL,'admin','00000280000005'),(309,'集宁',0,'0000028',NULL,NULL,'admin','00000280000006'),(310,'临河',0,'0000028',NULL,NULL,'admin','00000280000007'),(311,'乌海',0,'0000028',NULL,NULL,'admin','00000280000008'),(312,'海拉尔呼盟',0,'0000028',NULL,NULL,'admin','00000280000009'),(313,'东胜鄂尔多斯',0,'0000028',NULL,NULL,'admin','00000280000010'),(314,'湖南',0,'0000000',1,'2001-08-06 00:00:00','lj','0000029'),(315,'湖北',0,'0000000',1,'2001-08-06 00:00:00','lj','0000030'),(316,'安徽',0,'0000000',NULL,NULL,'admin','0000031'),(317,'江西',0,'0000000',NULL,NULL,'admin','0000032'),(318,'河北',0,'0000000',1,'2004-10-11 00:00:00','csy','0000033'),(319,'澳门',0,'0000000',NULL,NULL,'admin','0000034'),(320,'长沙市',0,'0000029',NULL,NULL,'admin','00002900000000'),(321,'株州市',0,'0000029',NULL,NULL,'admin','00002900000001'),(322,'湘潭市',0,'0000029',NULL,NULL,'admin','00002900000002'),(323,'湘乡市',0,'0000029',NULL,NULL,'admin','00002900000003'),(324,'沅江市',0,'0000029',NULL,NULL,'admin','00002900000004'),(325,'吉首市',0,'0000029',NULL,NULL,'admin','00002900000005'),(326,'大庸市',0,'0000029',NULL,NULL,'admin','00002900000006'),(327,'常德市',0,'0000029',NULL,NULL,'admin','00002900000007'),(328,'津市市',0,'0000029',NULL,NULL,'admin','00002900000008'),(329,'益阳市',0,'0000029',NULL,NULL,'admin','00002900000009'),(330,'涟源市',0,'0000029',NULL,NULL,'admin','00002900000010'),(331,'新化市',0,'0000029',NULL,NULL,'admin','00002900000011'),(332,'怀化市',0,'0000029',NULL,NULL,'admin','00002900000012'),(333,'冷水滩市',0,'0000029',NULL,NULL,'admin','00002900000013'),(334,'娄底市',0,'0000029',NULL,NULL,'admin','00002900000014'),(335,'冷水江市',0,'0000029',NULL,NULL,'admin','00002900000015'),(336,'郴州市',0,'0000029',NULL,NULL,'admin','00002900000016'),(337,'资兴市',0,'0000029',NULL,NULL,'admin','00002900000017'),(338,'武汉市',0,'0000030',NULL,NULL,'admin','00003000000001'),(339,'孝感市',0,'0000030',NULL,NULL,'admin','00003000000002'),(340,'襄樊市',0,'0000030',NULL,NULL,'admin','00003000000003'),(341,'咸宁市',0,'0000030',NULL,NULL,'admin','00003000000004'),(342,'荆州市',0,'0000030',NULL,NULL,'admin','00003000000005'),(343,'襄阳市',0,'0000030',NULL,NULL,'admin','00003000000006'),(344,'宜昌市',0,'0000030',NULL,NULL,'admin','00003000000007'),(345,'黄石市',0,'0000030',NULL,NULL,'admin','00003000000008'),(346,'仙桃市',0,'0000030',NULL,NULL,'admin','00003000000009'),(347,'安庆',0,'0000031',NULL,NULL,'admin','00003100000001'),(348,'蚌埠',0,'0000031',NULL,NULL,'admin','00003100000002'),(349,'合肥',0,'0000031',NULL,NULL,'admin','00003100000003'),(350,'淮北',0,'0000031',NULL,NULL,'admin','00003100000004'),(351,'阜阳',0,'0000031',NULL,NULL,'admin','00003100000005'),(352,'黄山',0,'0000031',NULL,NULL,'admin','00003100000006'),(353,'马鞍山',0,'0000031',NULL,NULL,'admin','00003100000007'),(354,'太原',0,'0000032',NULL,NULL,'admin','00003200000001'),(355,'长治',0,'0000032',NULL,NULL,'admin','00003200000002'),(356,'大同',0,'0000032',NULL,NULL,'admin','00003200000003'),(357,'晋城',0,'0000032',NULL,NULL,'admin','00003200000004'),(358,'晋中',0,'0000032',NULL,NULL,'admin','00003200000005'),(359,'临汾',0,'0000032',NULL,NULL,'admin','00003200000006'),(360,'吕梁',0,'0000032',NULL,NULL,'admin','00003200000007'),(361,'朔州',0,'0000032',NULL,NULL,'admin','00003200000008'),(362,'忻州',0,'0000032',NULL,NULL,'admin','00003200000009'),(363,'阳泉',0,'0000032',NULL,NULL,'admin','00003200000010'),(364,'运城',0,'0000032',NULL,NULL,'admin','00003200000011'),(365,'石家庄',0,'0000033',NULL,NULL,'admin','00003300000001'),(366,'秦皇岛',0,'0000033',NULL,NULL,'admin','00003300000002'),(367,'唐山',0,'0000033',NULL,NULL,'admin','00003300000003'),(368,'廊坊',0,'0000033',NULL,NULL,'admin','00003300000004'),(369,'邯郸',0,'0000033',NULL,NULL,'admin','00003300000005'),(370,'缸窑',0,'0000033',NULL,NULL,'admin','00003300000006'),(371,'张家口',0,'0000033',NULL,NULL,'admin','00003300000007'),(372,'承德',0,'0000033',NULL,NULL,'admin','00003300000008'),(373,'保定',0,'0000033',NULL,NULL,'admin','00003300000009'),(374,'衡水',0,'0000033',NULL,NULL,'admin','00003300000010'),(375,'沧州',0,'0000033',NULL,NULL,'admin','00003300000012'),(376,'邢台',0,'0000033',NULL,NULL,'admin','00003300000013'),(377,'澳门',0,'0000034',NULL,NULL,'admin','00003400000001'),(378,'国外',0,'0000000',1,'2005-03-05 00:00:00','admin','1111111'),(379,'美国',NULL,'0000000',1,'2007-01-23 13:48:23','毛伟','0000035'),(380,'纽约',NULL,'0000035',1,'2007-01-23 13:48:23','毛伟','0000035000001');
UNLOCK TABLES;
/*!40000 ALTER TABLE `systemregion` ENABLE KEYS */;

--
-- Table structure for table `systemrole`
--

DROP TABLE IF EXISTS `systemrole`;
CREATE TABLE `systemrole` (
  `id` bigint(20) NOT NULL,
  `sn` varchar(16) NOT NULL,
  `title` varchar(50) default NULL,
  `intro` text,
  `roleValue` varchar(50) default NULL,
  `status` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `systemrole`
--


/*!40000 ALTER TABLE `systemrole` DISABLE KEYS */;
LOCK TABLES `systemrole` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `systemrole` ENABLE KEYS */;

--
-- Table structure for table `systemuser`
--

DROP TABLE IF EXISTS `systemuser`;
CREATE TABLE `systemuser` (
  `id` bigint(20) NOT NULL,
  `belongDept` varchar(16) default NULL,
  `userName` varchar(16) default NULL,
  `password` varchar(32) default NULL,
  `email` varchar(50) default NULL,
  `trueName` varchar(50) default NULL,
  `tel` varchar(50) default NULL,
  `role` varchar(16) default NULL,
  `lastLoginTime` datetime default NULL,
  `lastLoginIP` varchar(50) default NULL,
  `loginTimes` int(11) default NULL,
  `inputUser` varchar(16) default NULL,
  `inputTime` datetime default NULL,
  `status` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `systemuser`
--


/*!40000 ALTER TABLE `systemuser` DISABLE KEYS */;
LOCK TABLES `systemuser` WRITE;
INSERT INTO `systemuser` VALUES (8,NULL,'test','098F6BCD4621D373CADE4E832627B4F6','microerp@easyjf.com','测试帐号','13251114955',NULL,'2007-02-04 13:29:41','127.0.0.1',992,NULL,NULL,0),(1168111285656,NULL,'t1','83F1535F99AB0BF4E9D02DFD85D3E3F7','t1','t1','t2',NULL,'2007-01-07 03:44:04','127.0.0.1',3,NULL,NULL,0);
UNLOCK TABLES;
/*!40000 ALTER TABLE `systemuser` ENABLE KEYS */;

--
-- Table structure for table `waterticket`
--

DROP TABLE IF EXISTS `waterticket`;
CREATE TABLE `waterticket` (
  `id` bigint(20) NOT NULL,
  `sn` bigint(20) default NULL,
  `product_id` bigint(20) default NULL,
  `customer_id` bigint(20) default NULL,
  `status` int(11) default NULL,
  `vdate` datetime default NULL,
  `backDate` datetime default NULL,
  `consumer_id` bigint(20) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `waterticket`
--


/*!40000 ALTER TABLE `waterticket` DISABLE KEYS */;
LOCK TABLES `waterticket` WRITE;
UNLOCK TABLES;
/*!40000 ALTER TABLE `waterticket` ENABLE KEYS */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

