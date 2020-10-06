-- MySQL dump 10.13  Distrib 5.7.31, for Linux (x86_64)
--
-- Host: localhost    Database: perfumes
-- ------------------------------------------------------
-- Server version	5.7.31-0ubuntu0.18.04.1

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
-- Current Database: `perfumes`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `perfumes` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `perfumes`;

--
-- Table structure for table `marca`
--

DROP TABLE IF EXISTS `marca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `marca` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `marca_perfume_UN` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marca`
--

LOCK TABLES `marca` WRITE;
/*!40000 ALTER TABLE `marca` DISABLE KEYS */;
INSERT INTO `marca` VALUES (10,'black'),(3,'Calvin Klein'),(2,'Carolina Herrera'),(5,'Donna Karan'),(9,'fuchsia'),(14,'gray'),(13,'green'),(6,'Hugo Boss'),(4,'Jesus del Pozo'),(1,'Lancome'),(11,'maroon'),(12,'navy'),(15,'olive'),(7,'Paco Rabanne'),(8,'purple'),(17,'teal'),(16,'white');
/*!40000 ALTER TABLE `marca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perfume`
--

DROP TABLE IF EXISTS `perfume`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `perfume` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `ml` int(11) NOT NULL,
  `imagen` varchar(255) NOT NULL DEFAULT 'https://cdn2.dineroenimagen.com/media/dinero/styles/gallerie/public/images/2019/04/perfume-px.jpg',
  `id_marca` int(11) DEFAULT NULL,
  `id_usuario` int(11) NOT NULL,
  `precio` float NOT NULL,
  `fecha_creacion` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fecha_validado` datetime DEFAULT NULL COMMENT 'si tiene valor NULL este producto no esta validado',
  PRIMARY KEY (`id`),
  UNIQUE KEY `perfume_UN` (`nombre`),
  KEY `FK_marca` (`id_marca`),
  KEY `perfume_FK` (`id_usuario`),
  CONSTRAINT `FK_marca` FOREIGN KEY (`id_marca`) REFERENCES `marca` (`id`),
  CONSTRAINT `perfume_FK` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1198 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfume`
--

LOCK TABLES `perfume` WRITE;
/*!40000 ALTER TABLE `perfume` DISABLE KEYS */;
INSERT INTO `perfume` VALUES (3,'CH VIP',125,'https://www.pacoperfumerias.com/content/images/thumbs/0095999_212-vip-men.jpeg',2,4,19.9,'2020-07-13 12:31:22','2020-10-06 09:13:01'),(4,'in2you',50,'https://ima.douglas.es/_d400/0272/10829776.png',3,2,25.45,'2020-07-13 12:31:22','2020-10-06 09:13:01'),(5,'Halloween',30,'https://ima.douglas.es/_d400/2253/halloween_eau_de_toilette-10085424-0-.png',4,5,25,'2020-07-13 12:31:22','2020-10-06 10:14:50'),(6,'Be Delicius',125,'https://ima.douglas.es/_d400/0463/dkny_be_delicious_eau_de_parfum_natural_spray-10893579-0-.png',5,2,36.9,'2020-07-13 12:31:22','2020-10-04 16:34:49'),(7,'Hugo Man',125,'https://perfumerias.com/static/imagenes/productos/product_info/img414.png',6,6,45,'2020-07-13 12:31:22','2020-10-06 10:14:50'),(8,'Invictus2',50,'https://ima.douglas.es/_d400/1114/invictus_paco_rabanne_eau_de_toilette-10205136-0-.png',7,1,33,'2020-07-13 12:31:22','2020-10-04 22:18:56'),(25,'one million',50,'https://www.sephora.es/dw/image/v2/BCVW_PRD/on/demandware.static/-/Sites-masterCatalog_Sephora/default/dwcf49be11/images/hi-res/SKU/SKU_1116/173907_swatch.jpg?sw=585&sh=585&sm=fit',7,2,46,'2020-07-13 12:31:22','2020-10-06 09:13:08'),(26,'la vie ',50,'https://ima.douglas.es/_d400/0850/la_vie_est_belle_edp-0-.png',1,1,86,'2020-07-13 12:31:22','2020-10-06 09:13:01'),(27,'UltraViolet',30,'https://perfumerias.com/static/imagenes/productos/product_info/img26-1.png',7,1,45,'2020-07-13 12:31:22','2020-10-06 09:13:01'),(28,'VIP Black',100,'https://ima.douglas.es/_d400/0288/212_vip_black_eau_de_parfum-10373477-0-.png',2,7,46,'2020-07-13 12:31:22','2020-07-13 12:31:22'),(29,'oi',50,'https://ima.douglas.es/_d400/0850/_lancme_eau_de_toilette-10641804-0-.png',1,1,50,'2020-07-13 12:31:22','2020-10-06 09:13:01'),(30,'one',100,'https://ima.douglas.es/_d400/perfumes/114_ck_one.jpg',3,8,23,'2020-07-13 12:31:22','2020-07-13 13:01:52'),(34,'Miracle',50,'https://fimgs.net/mdimg/perfume/375x500.184.jpg',1,1,89,'2020-07-23 11:51:50','2020-10-06 09:13:01'),(39,'lalala',30,'https://cdn2.dineroenimagen.com/media/dinero/styles/gallerie/public/images/2019/04/perfume-px.jpg',4,1,45,'2020-07-23 13:15:23','2020-10-06 10:14:50'),(111,'dolorum',100,'http://lorempixel.com/400/400/nature/',8,16,11,'2020-10-01 11:04:54','2020-07-13 13:01:52'),(112,'sunt',30,'http://lorempixel.com/400/400/nature/',9,17,74,'2020-10-01 11:04:54',NULL),(113,'consequatur',5,'http://lorempixel.com/400/400/nature/',10,18,144,'2020-10-01 11:04:54',NULL),(114,'soluta',50,'http://lorempixel.com/400/400/nature/',11,19,87,'2020-10-01 11:04:54','2020-07-13 13:01:52'),(115,'sequi',30,'http://lorempixel.com/400/400/nature/',12,20,70,'2020-10-01 11:04:54',NULL),(116,'impedit',100,'http://lorempixel.com/400/400/nature/',13,16,36,'2020-10-01 11:04:54','2020-10-01 11:04:54'),(117,'illo',100,'http://lorempixel.com/400/400/nature/',14,17,100,'2020-10-01 11:04:54',NULL),(118,'ut',100,'http://lorempixel.com/400/400/nature/',15,18,119,'2020-10-01 11:04:54',NULL),(119,'repellendus',5,'http://lorempixel.com/400/400/nature/',16,19,136,'2020-10-01 11:04:54',NULL),(1110,'quia',30,'http://lorempixel.com/400/400/nature/',17,20,64,'2020-10-01 11:04:54',NULL),(1111,'rem',120,'http://lorempixel.com/400/400/nature/',8,16,104,'2020-10-01 11:04:54',NULL),(1112,'culpa',100,'http://lorempixel.com/400/400/nature/',9,17,128,'2020-10-01 11:04:54',NULL),(1113,'optio',120,'http://lorempixel.com/400/400/nature/',10,18,97,'2020-10-01 11:04:54',NULL),(1114,'dolor',30,'http://lorempixel.com/400/400/nature/',11,19,66,'2020-10-01 11:04:54','2020-10-01 11:04:54'),(1115,'illum',30,'http://lorempixel.com/400/400/nature/',12,20,67,'2020-10-01 11:04:54',NULL),(1116,'eligendi',50,'http://lorempixel.com/400/400/nature/',13,16,90,'2020-10-01 11:04:54',NULL),(1117,'quod',5,'http://lorempixel.com/400/400/nature/',14,17,100,'2020-10-01 11:04:54','2020-10-01 11:04:54'),(1118,'ipsum',50,'http://lorempixel.com/400/400/nature/',15,18,54,'2020-10-01 11:04:54',NULL),(1120,'aut',5,'http://lorempixel.com/400/400/nature/',17,20,98,'2020-10-01 11:04:54',NULL),(1121,'corporis',50,'http://lorempixel.com/400/400/nature/',8,16,129,'2020-10-01 11:04:54','2020-10-01 11:04:54'),(1122,'libero',50,'http://lorempixel.com/400/400/nature/',9,17,90,'2020-10-01 11:04:54',NULL),(1123,'temporibus',50,'http://lorempixel.com/400/400/nature/',10,18,60,'2020-10-01 11:04:54',NULL),(1124,'qui',50,'http://lorempixel.com/400/400/nature/',11,19,12,'2020-10-01 11:04:54',NULL),(1125,'minus',50,'http://lorempixel.com/400/400/nature/',12,20,146,'2020-10-01 11:04:54',NULL),(1126,'consectetur',5,'http://lorempixel.com/400/400/nature/',13,16,127,'2020-10-01 11:04:54',NULL),(1127,'voluptas',50,'http://lorempixel.com/400/400/nature/',14,17,127,'2020-10-01 11:04:54',NULL),(1128,'asperiores',5,'http://lorempixel.com/400/400/nature/',15,18,71,'2020-10-01 11:04:54','2020-10-01 11:04:54'),(1129,'odio',30,'http://lorempixel.com/400/400/nature/',16,19,144,'2020-10-01 11:04:54',NULL),(1130,'at',30,'http://lorempixel.com/400/400/nature/',17,20,84,'2020-10-01 11:04:54',NULL),(1131,'quas',100,'http://lorempixel.com/400/400/nature/',8,16,91,'2020-10-01 11:04:54',NULL),(1132,'occaecati',5,'http://lorempixel.com/400/400/nature/',9,17,76,'2020-10-01 11:04:54',NULL),(1133,'atque',100,'http://lorempixel.com/400/400/nature/',10,18,145,'2020-10-01 11:04:54',NULL),(1134,'reiciendis',50,'http://lorempixel.com/400/400/nature/',11,19,66,'2020-10-01 11:04:54',NULL),(1135,'fuga',100,'http://lorempixel.com/400/400/nature/',12,20,113,'2020-10-01 11:04:54',NULL),(1137,'iusto',120,'http://lorempixel.com/400/400/nature/',14,17,57,'2020-10-01 11:04:54','2020-10-01 11:04:54'),(1138,'et',5,'http://lorempixel.com/400/400/nature/',15,18,72,'2020-10-01 11:04:54','2020-10-01 11:04:54'),(1139,'cumque',50,'http://lorempixel.com/400/400/nature/',16,19,68,'2020-10-01 11:04:54',NULL),(1140,'fugiat',120,'http://lorempixel.com/400/400/nature/',17,20,96,'2020-10-01 11:04:54','2020-10-01 11:04:54'),(1141,'facilis',5,'http://lorempixel.com/400/400/nature/',8,16,76,'2020-10-01 11:04:54',NULL),(1142,'quaerat',50,'http://lorempixel.com/400/400/nature/',9,17,126,'2020-10-01 11:04:54',NULL),(1143,'error',50,'http://lorempixel.com/400/400/nature/',10,18,79,'2020-10-01 11:04:54',NULL),(1144,'molestiae',120,'http://lorempixel.com/400/400/nature/',11,19,142,'2020-10-01 11:04:54',NULL),(1145,'non',30,'http://lorempixel.com/400/400/nature/',12,20,68,'2020-10-01 11:04:54',NULL),(1146,'velit',30,'http://lorempixel.com/400/400/nature/',13,16,120,'2020-10-01 11:04:54','2020-10-01 11:04:54'),(1147,'aliquid',50,'http://lorempixel.com/400/400/nature/',14,17,28,'2020-10-01 11:04:54',NULL),(1148,'nihil',120,'http://lorempixel.com/400/400/nature/',15,18,132,'2020-10-01 11:04:54',NULL),(1149,'vel',120,'http://lorempixel.com/400/400/nature/',16,19,21,'2020-10-01 11:04:54',NULL),(1150,'amet',120,'http://lorempixel.com/400/400/nature/',17,20,111,'2020-10-01 11:04:54',NULL),(1151,'praesentium',120,'http://lorempixel.com/400/400/nature/',8,16,86,'2020-10-01 11:04:54',NULL),(1152,'veritatis',120,'http://lorempixel.com/400/400/nature/',9,17,26,'2020-10-01 11:04:54',NULL),(1153,'officia',120,'http://lorempixel.com/400/400/nature/',10,18,44,'2020-10-01 11:04:54',NULL),(1154,'a',100,'http://lorempixel.com/400/400/nature/',11,19,125,'2020-10-01 11:04:54',NULL),(1155,'rerum',100,'http://lorempixel.com/400/400/nature/',12,20,61,'2020-10-01 11:04:54',NULL),(1156,'provident',5,'http://lorempixel.com/400/400/nature/',13,16,74,'2020-10-01 11:04:54',NULL),(1157,'eos',5,'http://lorempixel.com/400/400/nature/',14,17,55,'2020-10-01 11:04:54','2020-10-01 11:04:54'),(1158,'mollitia',120,'http://lorempixel.com/400/400/nature/',15,18,23,'2020-10-01 11:04:54','2020-10-01 11:04:54'),(1159,'ea',120,'http://lorempixel.com/400/400/nature/',16,19,107,'2020-10-01 11:04:54',NULL),(1160,'sed',5,'http://lorempixel.com/400/400/nature/',17,20,58,'2020-10-01 11:04:54','2020-10-01 11:04:54'),(1161,'exercitationem',100,'http://lorempixel.com/400/400/nature/',8,16,147,'2020-10-01 11:04:54',NULL),(1162,'iure',100,'http://lorempixel.com/400/400/nature/',9,17,109,'2020-10-01 11:04:54',NULL),(1163,'possimus',100,'http://lorempixel.com/400/400/nature/',10,18,48,'2020-10-01 11:04:54',NULL),(1164,'aspernatur',120,'http://lorempixel.com/400/400/nature/',11,19,80,'2020-10-01 11:04:54',NULL),(1165,'expedita',30,'http://lorempixel.com/400/400/nature/',12,20,33,'2020-10-01 11:04:54',NULL),(1166,'in',30,'http://lorempixel.com/400/400/nature/',13,16,47,'2020-10-01 11:04:54',NULL),(1167,'recusandae',100,'http://lorempixel.com/400/400/nature/',14,17,115,'2020-10-01 11:04:54',NULL),(1168,'ad',120,'http://lorempixel.com/400/400/nature/',15,18,73,'2020-10-01 11:04:54',NULL),(1169,'commodi',50,'http://lorempixel.com/400/400/nature/',16,19,100,'2020-10-01 11:04:54',NULL),(1170,'quos',50,'http://lorempixel.com/400/400/nature/',17,20,56,'2020-10-01 11:04:54',NULL),(1171,'placeat',50,'http://lorempixel.com/400/400/nature/',8,16,148,'2020-10-01 11:04:54','2020-10-01 11:04:54'),(1172,'repudiandae',5,'http://lorempixel.com/400/400/nature/',9,17,41,'2020-10-01 11:04:54',NULL),(1173,'id',5,'http://lorempixel.com/400/400/nature/',10,18,14,'2020-10-01 11:04:54',NULL),(1174,'voluptatem',5,'http://lorempixel.com/400/400/nature/',11,19,96,'2020-10-01 11:04:54',NULL),(1175,'numquam',30,'http://lorempixel.com/400/400/nature/',12,20,102,'2020-10-01 11:04:54',NULL),(1176,'explicabo',30,'http://lorempixel.com/400/400/nature/',13,16,144,'2020-10-01 11:04:54',NULL),(1177,'est',100,'http://lorempixel.com/400/400/nature/',14,17,14,'2020-10-01 11:04:54',NULL),(1178,'eum',120,'http://lorempixel.com/400/400/nature/',15,18,104,'2020-10-01 11:04:54',NULL),(1179,'dolore',5,'http://lorempixel.com/400/400/nature/',16,19,73,'2020-10-01 11:04:54',NULL),(1180,'nemo',100,'http://lorempixel.com/400/400/nature/',17,20,78,'2020-10-01 11:04:54',NULL),(1181,'natus',30,'http://lorempixel.com/400/400/nature/',8,16,75,'2020-10-01 11:04:54',NULL),(1182,'nesciunt',30,'http://lorempixel.com/400/400/nature/',9,17,72,'2020-10-01 11:04:54',NULL),(1183,'inventore',120,'http://lorempixel.com/400/400/nature/',10,18,99,'2020-10-01 11:04:54',NULL),(1184,'ex',50,'http://lorempixel.com/400/400/nature/',11,19,47,'2020-10-01 11:04:54',NULL),(1185,'maxime',120,'http://lorempixel.com/400/400/nature/',12,20,80,'2020-10-01 11:04:54',NULL),(1186,'ratione',100,'http://lorempixel.com/400/400/nature/',13,16,120,'2020-10-01 11:04:54',NULL),(1187,'pariatur',30,'http://lorempixel.com/400/400/nature/',14,17,38,'2020-10-01 11:04:54',NULL),(1188,'quisquam',100,'http://lorempixel.com/400/400/nature/',15,18,87,'2020-10-01 11:04:54','2020-10-01 11:04:54'),(1189,'laboriosam',30,'http://lorempixel.com/400/400/nature/',16,19,25,'2020-10-01 11:04:54','2020-10-01 11:04:54'),(1191,'saepe',100,'http://lorempixel.com/400/400/nature/',8,16,125,'2020-10-01 11:04:54',NULL),(1192,'ullam',100,'http://lorempixel.com/400/400/nature/',9,17,64,'2020-10-01 11:04:54',NULL),(1193,'odit',5,'http://lorempixel.com/400/400/nature/',10,18,97,'2020-10-01 11:04:54',NULL),(1194,'voluptatum',50,'http://lorempixel.com/400/400/nature/',11,19,49,'2020-10-01 11:04:54',NULL),(1195,'deserunt',30,'http://lorempixel.com/400/400/nature/',12,20,135,'2020-10-01 11:04:54',NULL),(1196,'debitis',30,'http://lorempixel.com/400/400/nature/',13,16,97,'2020-10-01 11:04:54','2020-10-04 16:04:17'),(1197,'nostrum',50,'http://lorempixel.com/400/400/nature/',14,17,115,'2020-10-01 11:04:54','2020-10-04 16:02:40');
/*!40000 ALTER TABLE `perfume` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rol` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `rol_UN` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (2,'Administrador'),(1,'Usuario');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `imagen` varchar(255) NOT NULL DEFAULT 'https://p1.pxfuel.com/preview/790/280/868/596ed5870f859.jpg',
  `id_rol` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `usuario_UN` (`nombre`),
  KEY `usuario_FK` (`id_rol`),
  CONSTRAINT `usuario_FK` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Benjamin','81dc9bdb52d04dc20036dbd8313ed055','https://p1.pxfuel.com/preview/790/280/868/596ed5870f859.jpg',1),(2,'Paz','81dc9bdb52d04dc20036dbd8313ed055','https://p1.pxfuel.com/preview/790/280/868/596ed5870f859.jpg',1),(3,'Admin','81dc9bdb52d04dc20036dbd8313ed055','https://p1.pxfuel.com/preview/790/280/868/596ed5870f859.jpg',2),(4,'Gaizka','81dc9bdb52d04dc20036dbd8313ed055','https://p1.pxfuel.com/preview/790/280/868/596ed5870f859.jpg',1),(5,'Manel','81dc9bdb52d04dc20036dbd8313ed055','https://p1.pxfuel.com/preview/790/280/868/596ed5870f859.jpg',1),(6,'Andres','81dc9bdb52d04dc20036dbd8313ed055','https://p1.pxfuel.com/preview/790/280/868/596ed5870f859.jpg',1),(7,'pazita','81dc9bdb52d04dc20036dbd8313ed055','https://p1.pxfuel.com/preview/790/280/868/596ed5870f859.jpg',1),(8,'pazita1','81dc9bdb52d04dc20036dbd8313ed055','https://p1.pxfuel.com/preview/790/280/868/596ed5870f859.jpg',1),(14,'pazita2','81dc9bdb52d04dc20036dbd8313ed055','https://p1.pxfuel.com/preview/790/280/868/596ed5870f859.jpg',1),(15,'Barbara','81dc9bdb52d04dc20036dbd8313ed055','https://p1.pxfuel.com/preview/790/280/868/596ed5870f859.jpg',1),(16,'Mossie','81dc9bdb52d04dc20036dbd8313ed055','http://lorempixel.com/400/400/people/',1),(17,'Cali','81dc9bdb52d04dc20036dbd8313ed055','http://lorempixel.com/400/400/people/',1),(18,'Winifred','81dc9bdb52d04dc20036dbd8313ed055','http://lorempixel.com/400/400/people/',1),(19,'Emma','81dc9bdb52d04dc20036dbd8313ed055','http://lorempixel.com/400/400/people/',1),(20,'Della','81dc9bdb52d04dc20036dbd8313ed055','http://lorempixel.com/400/400/people/',1),(21,'pepito','81dc9bdb52d04dc20036dbd8313ed055','https://p1.pxfuel.com/preview/790/280/868/596ed5870f859.jpg',1),(22,'pepita','81dc9bdb52d04dc20036dbd8313ed055','https://p1.pxfuel.com/preview/790/280/868/596ed5870f859.jpg',1),(23,'pepitaa','81dc9bdb52d04dc20036dbd8313ed055','https://p1.pxfuel.com/preview/790/280/868/596ed5870f859.jpg',1),(24,'pepita3','81dc9bdb52d04dc20036dbd8313ed055','https://p1.pxfuel.com/preview/790/280/868/596ed5870f859.jpg',1),(27,'pepita5','81dc9bdb52d04dc20036dbd8313ed055','https://p1.pxfuel.com/preview/790/280/868/596ed5870f859.jpg',1),(30,'pepita6','81dc9bdb52d04dc20036dbd8313ed055','https://p1.pxfuel.com/preview/790/280/868/596ed5870f859.jpg',1),(32,'pepita56','81dc9bdb52d04dc20036dbd8313ed055','https://p1.pxfuel.com/preview/790/280/868/596ed5870f859.jpg',1),(33,'Ander','81dc9bdb52d04dc20036dbd8313ed055','https://p1.pxfuel.com/preview/790/280/868/596ed5870f859.jpg',1),(34,'pepita28','81dc9bdb52d04dc20036dbd8313ed055','https://p1.pxfuel.com/preview/790/280/868/596ed5870f859.jpg',1),(35,'Benjamin3','e10adc3949ba59abbe56e057f20f883e','https://p1.pxfuel.com/preview/790/280/868/596ed5870f859.jpg',1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `v.perfumes_resumen`
--

DROP TABLE IF EXISTS `v.perfumes_resumen`;
/*!50001 DROP VIEW IF EXISTS `v.perfumes_resumen`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `v.perfumes_resumen` AS SELECT 
 1 AS `id_usuario`,
 1 AS `total`,
 1 AS `aprobado`,
 1 AS `pendiente`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `v.perfumes_resumen_total`
--

DROP TABLE IF EXISTS `v.perfumes_resumen_total`;
/*!50001 DROP VIEW IF EXISTS `v.perfumes_resumen_total`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `v.perfumes_resumen_total` AS SELECT 
 1 AS `total`,
 1 AS `aprobados`,
 1 AS `pendientes`,
 1 AS `marcas`,
 1 AS `usuarios`*/;
SET character_set_client = @saved_cs_client;

--
-- Current Database: `perfumes`
--

USE `perfumes`;

--
-- Final view structure for view `v.perfumes_resumen`
--

/*!50001 DROP VIEW IF EXISTS `v.perfumes_resumen`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`debian-sys-maint`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v.perfumes_resumen` AS select `perfume`.`id_usuario` AS `id_usuario`,count(`perfume`.`id_usuario`) AS `total`,count(`perfume`.`fecha_validado`) AS `aprobado`,sum(isnull(`perfume`.`fecha_validado`)) AS `pendiente` from `perfume` group by `perfume`.`id_usuario` order by `perfume`.`id_usuario` limit 500 */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v.perfumes_resumen_total`
--

/*!50001 DROP VIEW IF EXISTS `v.perfumes_resumen_total`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`debian-sys-maint`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v.perfumes_resumen_total` AS select count(`perfume`.`id`) AS `total`,count(`perfume`.`fecha_validado`) AS `aprobados`,sum(isnull(`perfume`.`fecha_validado`)) AS `pendientes`,(select count(`marca`.`id`) from `marca`) AS `marcas`,(select count(`usuario`.`id`) from `usuario`) AS `usuarios` from `perfume` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-10-06 10:46:32
