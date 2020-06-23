-- MySQL dump 10.13  Distrib 5.7.30, for Linux (x86_64)
--
-- Host: localhost    Database: perfumes
-- ------------------------------------------------------
-- Server version	5.7.30-0ubuntu0.18.04.1

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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marca`
--

LOCK TABLES `marca` WRITE;
/*!40000 ALTER TABLE `marca` DISABLE KEYS */;
INSERT INTO `marca` VALUES (3,'Calvin Klein'),(2,'Carolina Herrera'),(5,'Donna Karan'),(6,'Hugo Boss'),(4,'Jesus del Pozo'),(1,'Lancome'),(7,'Paco Rabanne');
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
  PRIMARY KEY (`id`),
  UNIQUE KEY `perfume_UN` (`nombre`),
  KEY `FK_marca` (`id_marca`),
  CONSTRAINT `FK_marca` FOREIGN KEY (`id_marca`) REFERENCES `marca` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfume`
--

LOCK TABLES `perfume` WRITE;
/*!40000 ALTER TABLE `perfume` DISABLE KEYS */;
INSERT INTO `perfume` VALUES (2,'Miracle ',50,'https://fimgs.net/mdimg/perfume/375x500.184.jpg',1),(3,'CH VIP',125,'https://www.pacoperfumerias.com/content/images/thumbs/0095999_212-vip-men.jpeg',2),(4,'in2you',50,'https://ima.douglas.es/_d400/0272/10829776.png',3),(5,'Halloween',30,'https://ima.douglas.es/_d400/2253/halloween_eau_de_toilette-10085424-0-.png',4),(6,'Be Delicius',100,'https://ima.douglas.es/_d400/0463/dkny_be_delicious_eau_de_parfum_natural_spray-10893579-0-.png',5),(7,'Hugo Man',125,'https://perfumerias.com/static/imagenes/productos/product_info/img414.png',6),(8,'Invictus',50,'https://ima.douglas.es/_d400/1114/invictus_paco_rabanne_eau_de_toilette-10205136-0-.png',7),(25,'one million',50,'https://www.sephora.es/dw/image/v2/BCVW_PRD/on/demandware.static/-/Sites-masterCatalog_Sephora/default/dwcf49be11/images/hi-res/SKU/SKU_1116/173907_swatch.jpg?sw=585&sh=585&sm=fit',7),(26,'la vie ',50,'https://ima.douglas.es/_d400/0850/la_vie_est_belle_edp-0-.png',1),(27,'UltraViolet',30,'https://perfumerias.com/static/imagenes/productos/product_info/img26-1.png',7),(28,'VIP Black',100,'https://ima.douglas.es/_d400/0288/212_vip_black_eau_de_parfum-10373477-0-.png',2),(29,'oi',50,'https://ima.douglas.es/_d400/0850/_lancme_eau_de_toilette-10641804-0-.png',1);
/*!40000 ALTER TABLE `perfume` ENABLE KEYS */;
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
  PRIMARY KEY (`id`),
  UNIQUE KEY `usuario_UN` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Benjamin','1234','https://p1.pxfuel.com/preview/790/280/868/596ed5870f859.jpg'),(2,'Paz','1234','https://p1.pxfuel.com/preview/790/280/868/596ed5870f859.jpg'),(3,'Carlos','1234','https://p1.pxfuel.com/preview/790/280/868/596ed5870f859.jpg'),(4,'Gaizka','1234','https://p1.pxfuel.com/preview/790/280/868/596ed5870f859.jpg'),(5,'Manel','1234','https://p1.pxfuel.com/preview/790/280/868/596ed5870f859.jpg'),(6,'Admin','1234','https://p1.pxfuel.com/preview/790/280/868/596ed5870f859.jpg'),(7,'pazita','1234','https://p1.pxfuel.com/preview/790/280/868/596ed5870f859.jpg'),(8,'pazita1','1234','https://p1.pxfuel.com/preview/790/280/868/596ed5870f859.jpg'),(14,'pazita2','1234','https://p1.pxfuel.com/preview/790/280/868/596ed5870f859.jpg');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-23 13:17:53
