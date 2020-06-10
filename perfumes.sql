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
  PRIMARY KEY (`id`),
  UNIQUE KEY `perfume_UN` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfume`
--

LOCK TABLES `perfume` WRITE;
/*!40000 ALTER TABLE `perfume` DISABLE KEYS */;
INSERT INTO `perfume` VALUES (1,'CK one',100,'https://cdn2.dineroenimagen.com/media/dinero/styles/gallerie/public/images/2019/04/perfume-px.jpg'),(2,'Miracle Lancome',50,'https://cdn2.dineroenimagen.com/media/dinero/styles/gallerie/public/images/2019/04/perfume-px.jpg'),(3,'CH VIP',125,'https://cdn2.dineroenimagen.com/media/dinero/styles/gallerie/public/images/2019/04/perfume-px.jpg'),(4,'in2you CK',50,'https://cdn2.dineroenimagen.com/media/dinero/styles/gallerie/public/images/2019/04/perfume-px.jpg'),(5,'Halloween',30,'https://cdn2.dineroenimagen.com/media/dinero/styles/gallerie/public/images/2019/04/perfume-px.jpg'),(6,'DKNY Be Delicius',100,'https://cdn2.dineroenimagen.com/media/dinero/styles/gallerie/public/images/2019/04/perfume-px.jpg'),(7,'Hugo Man HB',125,'https://cdn2.dineroenimagen.com/media/dinero/styles/gallerie/public/images/2019/04/perfume-px.jpg'),(8,'Invictus Paco Rabanne',50,'https://cdn2.dineroenimagen.com/media/dinero/styles/gallerie/public/images/2019/04/perfume-px.jpg'),(11,'fluflu2',100,'https://cdn2.dineroenimagen.com/media/dinero/styles/gallerie/public/images/2019/04/perfume-px.jpg'),(12,'fli',125,'https://cdn2.dineroenimagen.com/media/dinero/styles/gallerie/public/images/2019/04/perfume-px.jpg'),(13,'fluflu',0,'https://cdn2.dineroenimagen.com/media/dinero/styles/gallerie/public/images/2019/04/perfume-px.jpg'),(14,'hola',100,'https://cdn2.dineroenimagen.com/media/dinero/styles/gallerie/public/images/2019/04/perfume-px.jpg'),(25,'hola1',0,'https://cdn2.dineroenimagen.com/media/dinero/styles/gallerie/public/images/2019/04/perfume-px.jpg');
/*!40000 ALTER TABLE `perfume` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-10  9:29:27
