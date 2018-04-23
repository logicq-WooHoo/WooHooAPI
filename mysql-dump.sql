-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: woho
-- ------------------------------------------------------
-- Server version	5.7.21-log

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
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `city` varchar(100) DEFAULT NULL,
  `county` varchar(100) DEFAULT NULL,
  `flatno` varchar(100) DEFAULT NULL,
  `landmark` varchar(100) DEFAULT NULL,
  `latitude` double NOT NULL,
  `locality` varchar(100) DEFAULT NULL,
  `longitude` double NOT NULL,
  `pincode` varchar(10) NOT NULL,
  `road` varchar(100) DEFAULT NULL,
  `societyname` varchar(100) DEFAULT NULL,
  `state` varchar(100) DEFAULT NULL,
  `street` varchar(100) DEFAULT NULL,
  `address_type` varchar(100) DEFAULT NULL,
  `distance` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'Pune','India',NULL,NULL,18.507535,'Kothrud',73.771311,'411038','Paud Road',NULL,'Maharashtra',NULL,'restaurant',NULL),(2,'Pune','India',NULL,NULL,18.507593,'Kothrud',73.806104,'411038','Paud Road',NULL,'Maharashtra',NULL,'restaurant',NULL),(3,'Pune','India',NULL,NULL,18.508539,'Kothrud',73.797661,'411038','Paud Road',NULL,'Maharashtra',NULL,'restaurant',NULL),(4,'Pune','India',NULL,NULL,18.601254,'Wakad',73.761843,'411057','Kaspate Wasti Road',NULL,'Maharashtra',NULL,'restaurant',NULL),(5,'Pune','India',NULL,NULL,18.564927,'Old Sangvi',73.739287,'411027','CQAE Road',NULL,'Maharashtra',NULL,'restaurant',NULL),(6,'Pune','India',NULL,NULL,18.5014554,'Kothrud',73.7458715,'411038','Rahul Nagar Road',NULL,'Maharashtra',NULL,'restaurant',NULL),(7,'Pune','India','B 602','',18.601254,'Wakad',73.761843,'411057',NULL,'Sentosa Elysium','Maharashtra',NULL,'user',NULL);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery_partner`
--

DROP TABLE IF EXISTS `delivery_partner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `delivery_partner` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_partner`
--

LOCK TABLES `delivery_partner` WRITE;
/*!40000 ALTER TABLE `delivery_partner` DISABLE KEYS */;
INSERT INTO `delivery_partner` VALUES (1,'FoodPanda'),(2,'Swiggy'),(3,'Zomato'),(4,'Ola Cafe');
/*!40000 ALTER TABLE `delivery_partner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `document`
--

DROP TABLE IF EXISTS `document`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `document` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `file_path` varchar(100) DEFAULT NULL,
  `file_size` bigint(20) DEFAULT NULL,
  `file_type` varchar(100) DEFAULT NULL,
  `file_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `document`
--

LOCK TABLES `document` WRITE;
/*!40000 ALTER TABLE `document` DISABLE KEYS */;
/*!40000 ALTER TABLE `document` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `food_category`
--

DROP TABLE IF EXISTS `food_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `food_category` (
  `categoryid` bigint(20) NOT NULL AUTO_INCREMENT,
  `category` varchar(100) NOT NULL,
  `subcategory` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`categoryid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `food_category`
--

LOCK TABLES `food_category` WRITE;
/*!40000 ALTER TABLE `food_category` DISABLE KEYS */;
INSERT INTO `food_category` VALUES (1,'Tandoor',''),(2,'Chinees',''),(3,'Continental',''),(4,'Biryani',''),(5,'Thali',NULL),(6,'Vegetarian',NULL);
/*!40000 ALTER TABLE `food_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `food_service_type`
--

DROP TABLE IF EXISTS `food_service_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `food_service_type` (
  `food_servcicetype_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `comment` varchar(100) DEFAULT NULL,
  `servcicetype` varchar(100) NOT NULL,
  PRIMARY KEY (`food_servcicetype_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `food_service_type`
--

LOCK TABLES `food_service_type` WRITE;
/*!40000 ALTER TABLE `food_service_type` DISABLE KEYS */;
INSERT INTO `food_service_type` VALUES (1,'','Breakfast'),(2,'','Lunch'),(3,'','Snacks'),(4,'','Dinner');
/*!40000 ALTER TABLE `food_service_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu_item`
--

DROP TABLE IF EXISTS `menu_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu_item` (
  `menu_item_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `food_category_categoryid` bigint(20) DEFAULT NULL,
  `food_service_type_food_servcicetype_id` bigint(20) DEFAULT NULL,
  `is_veg` bit(1) DEFAULT NULL,
  PRIMARY KEY (`menu_item_id`),
  KEY `FK85i18h83s5wk1gsty2pkmik0x` (`food_category_categoryid`),
  KEY `FKjniedvdsjxlva5tajvogugbgy` (`food_service_type_food_servcicetype_id`),
  CONSTRAINT `FK85i18h83s5wk1gsty2pkmik0x` FOREIGN KEY (`food_category_categoryid`) REFERENCES `food_category` (`categoryid`),
  CONSTRAINT `FKjniedvdsjxlva5tajvogugbgy` FOREIGN KEY (`food_service_type_food_servcicetype_id`) REFERENCES `food_service_type` (`food_servcicetype_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu_item`
--

LOCK TABLES `menu_item` WRITE;
/*!40000 ALTER TABLE `menu_item` DISABLE KEYS */;
INSERT INTO `menu_item` VALUES (1,'Aloo methi',150,6,2,''),(2,'Kaju Masala',200,6,2,'');
/*!40000 ALTER TABLE `menu_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_tracking`
--

DROP TABLE IF EXISTS `order_tracking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_tracking` (
  `id` varchar(255) NOT NULL,
  `order_json` longblob NOT NULL,
  `timestamp` datetime NOT NULL,
  `user_information_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKp5w0ej13m1l8xg6lii5yavibu` (`user_information_id`),
  CONSTRAINT `FKp5w0ej13m1l8xg6lii5yavibu` FOREIGN KEY (`user_information_id`) REFERENCES `userinformation` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_tracking`
--

LOCK TABLES `order_tracking` WRITE;
/*!40000 ALTER TABLE `order_tracking` DISABLE KEYS */;
INSERT INTO `order_tracking` VALUES ('67Uhsc','{\"orderDetails\":[{\"restaurantId\":2,\"restaurantName\":\"Samartha Veg\",\"deliveryPartner\":\"Swiggy\",\"menuItems\":[{\"id\":2,\"foodServiceTypeId\":null,\"foodCategoryId\":null,\"itemName\":\"Kaju Masala\",\"price\":200.0,\"quantity\":\"1\",\"totalPrice\":200.0}]},{\"restaurantId\":1,\"restaurantName\":\"Hotel Kinara\",\"deliveryPartner\":\"Swiggy\",\"menuItems\":[{\"id\":1,\"foodServiceTypeId\":null,\"foodCategoryId\":null,\"itemName\":\"Aloo methi\",\"price\":150.0,\"quantity\":\"2\",\"totalPrice\":300.0}]}],\"deliveryAddress\":\"B 602, Sentosa Elysium, Shankar Kalat Nagar, Wakad, Pimpri-Chinchwad, Pune, 411057, Maharashtra, India\",\"paymentDetails\":{\"subTotal\":500.0,\"grandTotal\":590.0,\"deliveryCharges\":0.0,\"tax\":90.0,\"discount\":0.0},\"userId\":2}','2018-04-24 01:19:55',2);
/*!40000 ALTER TABLE `order_tracking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paymentcard`
--

DROP TABLE IF EXISTS `paymentcard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paymentcard` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `card_number` bigint(20) NOT NULL,
  `card_type` varchar(255) NOT NULL,
  `cvv` int(11) NOT NULL,
  `expire_on` varchar(255) NOT NULL,
  `user_information_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ibbe36o7y69ory4n68i0cc0y9` (`card_number`),
  UNIQUE KEY `UKak362x65optqe9ek0jlwjdyes` (`card_number`),
  KEY `FKagt99kwjkpspij95box5rpx3y` (`user_information_id`),
  CONSTRAINT `FKagt99kwjkpspij95box5rpx3y` FOREIGN KEY (`user_information_id`) REFERENCES `userinformation` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paymentcard`
--

LOCK TABLES `paymentcard` WRITE;
/*!40000 ALTER TABLE `paymentcard` DISABLE KEYS */;
INSERT INTO `paymentcard` VALUES (1,2345123456789023,'debit',123,'07/19',2);
/*!40000 ALTER TABLE `paymentcard` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurant_details`
--

DROP TABLE IF EXISTS `restaurant_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `restaurant_details` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `registration_number` varchar(100) NOT NULL,
  `restaurant_name` varchar(100) NOT NULL,
  `address_id` bigint(20) DEFAULT NULL,
  `document_id` bigint(20) DEFAULT NULL,
  `user_information_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKp1yg7j7qnxt4yshqwgbxvqrrh` (`address_id`),
  KEY `FKfg5ptvp2j47e2vcsckl4lnqo6` (`document_id`),
  KEY `FKnduux7tmkdfrkc9lg99fjat1w` (`user_information_id`),
  CONSTRAINT `FKfg5ptvp2j47e2vcsckl4lnqo6` FOREIGN KEY (`document_id`) REFERENCES `document` (`id`),
  CONSTRAINT `FKnduux7tmkdfrkc9lg99fjat1w` FOREIGN KEY (`user_information_id`) REFERENCES `userinformation` (`id`),
  CONSTRAINT `FKp1yg7j7qnxt4yshqwgbxvqrrh` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurant_details`
--

LOCK TABLES `restaurant_details` WRITE;
/*!40000 ALTER TABLE `restaurant_details` DISABLE KEYS */;
INSERT INTO `restaurant_details` VALUES (1,'101','Hotel Kinara',1,NULL,1),(2,'102','Samartha Veg',2,NULL,1),(3,'103','Parth Veg',3,NULL,1),(4,'104','Tatva Veg',4,NULL,1),(5,'105','CQAE Are',5,NULL,1),(6,'106','Maratha Samrat Restaurant',6,NULL,1);
/*!40000 ALTER TABLE `restaurant_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurant_details_food_category`
--

DROP TABLE IF EXISTS `restaurant_details_food_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `restaurant_details_food_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_id` bigint(20) DEFAULT NULL,
  `rest_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurant_details_food_category`
--

LOCK TABLES `restaurant_details_food_category` WRITE;
/*!40000 ALTER TABLE `restaurant_details_food_category` DISABLE KEYS */;
INSERT INTO `restaurant_details_food_category` VALUES (1,6,1),(2,6,2),(3,6,3),(4,6,4);
/*!40000 ALTER TABLE `restaurant_details_food_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurant_menu`
--

DROP TABLE IF EXISTS `restaurant_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `restaurant_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `restaurant_details_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3cdl1jv1h4kq5bjyh5l1ldatl` (`restaurant_details_id`),
  CONSTRAINT `FK3cdl1jv1h4kq5bjyh5l1ldatl` FOREIGN KEY (`restaurant_details_id`) REFERENCES `restaurant_details` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurant_menu`
--

LOCK TABLES `restaurant_menu` WRITE;
/*!40000 ALTER TABLE `restaurant_menu` DISABLE KEYS */;
INSERT INTO `restaurant_menu` VALUES (1,1),(2,2),(3,3),(4,4),(5,5);
/*!40000 ALTER TABLE `restaurant_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurant_menu_menu_items`
--

DROP TABLE IF EXISTS `restaurant_menu_menu_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `restaurant_menu_menu_items` (
  `restaurant_menu_id` bigint(20) NOT NULL,
  `menu_items_menu_item_id` bigint(20) NOT NULL,
  PRIMARY KEY (`restaurant_menu_id`,`menu_items_menu_item_id`),
  UNIQUE KEY `UK_92txq1121nhjynd4e8yj6vcjc` (`menu_items_menu_item_id`),
  CONSTRAINT `FKcq7xl1cuy9ns2a6k954npuvee` FOREIGN KEY (`menu_items_menu_item_id`) REFERENCES `menu_item` (`menu_item_id`),
  CONSTRAINT `FKra2hyhy3rvba0npy2b2fq0jsk` FOREIGN KEY (`restaurant_menu_id`) REFERENCES `restaurant_menu` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurant_menu_menu_items`
--

LOCK TABLES `restaurant_menu_menu_items` WRITE;
/*!40000 ALTER TABLE `restaurant_menu_menu_items` DISABLE KEYS */;
INSERT INTO `restaurant_menu_menu_items` VALUES (1,1),(2,2);
/*!40000 ALTER TABLE `restaurant_menu_menu_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurant_review`
--

DROP TABLE IF EXISTS `restaurant_review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `restaurant_review` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `comment` varchar(255) DEFAULT NULL,
  `rating` double DEFAULT NULL,
  `recommendation_count` int(11) DEFAULT NULL,
  `restaurant_details_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsnr9ly3r7vujjc7ip2oxva1ft` (`restaurant_details_id`),
  CONSTRAINT `FKsnr9ly3r7vujjc7ip2oxva1ft` FOREIGN KEY (`restaurant_details_id`) REFERENCES `restaurant_details` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurant_review`
--

LOCK TABLES `restaurant_review` WRITE;
/*!40000 ALTER TABLE `restaurant_review` DISABLE KEYS */;
INSERT INTO `restaurant_review` VALUES (1,NULL,4.2,230,1),(2,NULL,4.1,210,2),(3,NULL,4,200,3),(4,NULL,3.9,190,4);
/*!40000 ALTER TABLE `restaurant_review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurant_setup`
--

DROP TABLE IF EXISTS `restaurant_setup`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `restaurant_setup` (
  `setup_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `delivery_services` longblob NOT NULL,
  `operation_time` longblob NOT NULL,
  `restaurant_details_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`setup_id`),
  KEY `FK715wydd7xge7ukb8tmfvhn9tv` (`restaurant_details_id`),
  CONSTRAINT `FK715wydd7xge7ukb8tmfvhn9tv` FOREIGN KEY (`restaurant_details_id`) REFERENCES `restaurant_details` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurant_setup`
--

LOCK TABLES `restaurant_setup` WRITE;
/*!40000 ALTER TABLE `restaurant_setup` DISABLE KEYS */;
INSERT INTO `restaurant_setup` VALUES (1,'?','?',1),(2,'?','?',2),(3,'?','?',3),(4,'?','?',4),(5,'null','null',5),(6,'null','null',6);
/*!40000 ALTER TABLE `restaurant_setup` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurant_type`
--

DROP TABLE IF EXISTS `restaurant_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `restaurant_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurant_type`
--

LOCK TABLES `restaurant_type` WRITE;
/*!40000 ALTER TABLE `restaurant_type` DISABLE KEYS */;
INSERT INTO `restaurant_type` VALUES (1,'Indian'),(2,'American'),(3,'Italian'),(4,'Chinese'),(5,'Europian'),(6,'Korean'),(7,'Austerlian'),(8,'Japanese');
/*!40000 ALTER TABLE `restaurant_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurantsetup_deliverypartner`
--

DROP TABLE IF EXISTS `restaurantsetup_deliverypartner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `restaurantsetup_deliverypartner` (
  `setup_id` bigint(20) NOT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`setup_id`,`id`),
  KEY `FKrmq5xv3mj4dhfex2cfuimbixr` (`id`),
  CONSTRAINT `FK6tlvjx28twnnjgbyaah712ioh` FOREIGN KEY (`setup_id`) REFERENCES `restaurant_setup` (`setup_id`),
  CONSTRAINT `FKrmq5xv3mj4dhfex2cfuimbixr` FOREIGN KEY (`id`) REFERENCES `delivery_partner` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurantsetup_deliverypartner`
--

LOCK TABLES `restaurantsetup_deliverypartner` WRITE;
/*!40000 ALTER TABLE `restaurantsetup_deliverypartner` DISABLE KEYS */;
INSERT INTO `restaurantsetup_deliverypartner` VALUES (1,1),(2,1),(3,1),(5,1),(1,2),(2,2),(3,2),(5,2),(1,3),(2,3),(3,3),(5,3);
/*!40000 ALTER TABLE `restaurantsetup_deliverypartner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurantsetup_restauranttype`
--

DROP TABLE IF EXISTS `restaurantsetup_restauranttype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `restaurantsetup_restauranttype` (
  `setup_id` bigint(20) NOT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`setup_id`,`id`),
  KEY `FKjfp6rgaru3qyhhh3is03b78ox` (`id`),
  CONSTRAINT `FKj6927yixytk83a60yvhhcd5rf` FOREIGN KEY (`setup_id`) REFERENCES `restaurant_setup` (`setup_id`),
  CONSTRAINT `FKjfp6rgaru3qyhhh3is03b78ox` FOREIGN KEY (`id`) REFERENCES `restaurant_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurantsetup_restauranttype`
--

LOCK TABLES `restaurantsetup_restauranttype` WRITE;
/*!40000 ALTER TABLE `restaurantsetup_restauranttype` DISABLE KEYS */;
INSERT INTO `restaurantsetup_restauranttype` VALUES (1,1),(2,1),(3,1),(4,1),(5,1),(6,1),(1,2),(2,2),(3,2),(4,2),(5,2),(6,2),(1,3),(2,3),(3,3),(4,3),(5,3),(6,3),(5,4),(6,4),(5,5),(6,5),(5,6),(6,6),(5,7),(6,7),(5,8),(6,8);
/*!40000 ALTER TABLE `restaurantsetup_restauranttype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userinformation`
--

DROP TABLE IF EXISTS `userinformation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userinformation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(100) DEFAULT NULL,
  `firstname` varchar(100) DEFAULT NULL,
  `lastname` varchar(100) DEFAULT NULL,
  `mobileno` varchar(10) NOT NULL,
  `usertype` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userinformation`
--

LOCK TABLES `userinformation` WRITE;
/*!40000 ALTER TABLE `userinformation` DISABLE KEYS */;
INSERT INTO `userinformation` VALUES (1,'','Sunil','Shetty','7568941238','owner'),(2,NULL,'Rakesh','Sharma','8623564512','customer');
/*!40000 ALTER TABLE `userinformation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userinformation_addresses`
--

DROP TABLE IF EXISTS `userinformation_addresses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userinformation_addresses` (
  `user_information_id` bigint(20) NOT NULL,
  `addresses_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_information_id`,`addresses_id`),
  UNIQUE KEY `UK_etj5ul3tm405pwj047vv7www9` (`addresses_id`),
  CONSTRAINT `FKihh82qawc91v412mritvqit1i` FOREIGN KEY (`addresses_id`) REFERENCES `address` (`id`),
  CONSTRAINT `FKmyxei0g22m0813j4s03ji3xa3` FOREIGN KEY (`user_information_id`) REFERENCES `userinformation` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userinformation_addresses`
--

LOCK TABLES `userinformation_addresses` WRITE;
/*!40000 ALTER TABLE `userinformation_addresses` DISABLE KEYS */;
INSERT INTO `userinformation_addresses` VALUES (2,7);
/*!40000 ALTER TABLE `userinformation_addresses` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-24  2:05:30
