CREATE DATABASE  IF NOT EXISTS `myproject`;
USE `myproject`;

--
-- Dumping data for table `card`
--
DROP TABLE IF EXISTS `card`;
CREATE TABLE `card` (
  `cardno` varchar(20) NOT NULL,
  `edate` varchar(100) NOT NULL,
  `cvv` varchar(3) NOT NULL,
  `cname` varchar(500) NOT NULL,
  `enum` varchar(100) NOT NULL,
  `ename` varchar(500) NOT NULL
);

LOCK TABLES `card` WRITE;
INSERT INTO `card` VALUES ('card 3','card 4','c5','card 6','card 2','card 1'),('eee 3','eee 4','e5','eee 6','eee 2','eee 1');
UNLOCK TABLES;

--
-- Table structure for table `event`
--
DROP TABLE IF EXISTS `event`;
CREATE TABLE `event` (
  `enum` varchar(100) NOT NULL,
  `ename` varchar(500) NOT NULL,
  `coord` varchar(500) NOT NULL,
  `coordnum` varchar(10) NOT NULL,
  `fee` varchar(100) NOT NULL,
  `venue` varchar(500) NOT NULL,
  `edate` varchar(200) NOT NULL
);

--
-- Dumping data for table `event`
--
LOCK TABLES `event` WRITE;
INSERT INTO `event` VALUES ('a','b','c','d','e','f','g'),('h','i','j','k','l','m','n'),('1','2','3','4','5','6','7'),('aa','bb','cc','dd','ee','ff','gg'),('AAA','BBB','CCC','DDD','EEE','FFF','GGG');
UNLOCK TABLES;

--
-- Table structure for table `plogindeatils`
--
DROP TABLE IF EXISTS `plogindeatils`;
CREATE TABLE `plogindeatils` (
  `User_name` varchar(100) NOT NULL,
  `pass_word` varchar(100) NOT NULL,
  `name` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`User_name`)
);

--myproject
-- Dumping data for table `plogindeatils`
--

LOCK TABLES `plogindeatils` WRITE;
INSERT INTO `plogindeatils` VALUES ('b','c','a'),('c','d','b');
UNLOCK TABLES;
