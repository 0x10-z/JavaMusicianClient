-- MySQL dump 10.13  Distrib 5.5.31, for debian-linux-gnu (i686)
--
-- Host: localhost    Database: javamusica
-- ------------------------------------------------------
-- Server version	5.5.31-0ubuntu0.12.04.1

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
-- Table structure for table `artista`
--

DROP TABLE IF EXISTS `artista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `artista` (
  `nombre` varchar(30) DEFAULT NULL,
  `alias` varchar(30) NOT NULL,
  `edad` int(11) NOT NULL,
  `instrumento` varchar(30) NOT NULL,
  `disponibilidad` char(2) NOT NULL,
  PRIMARY KEY (`alias`),
  KEY `instrumento` (`instrumento`),
  CONSTRAINT `artista_ibfk_1` FOREIGN KEY (`instrumento`) REFERENCES `instrumento` (`nombre`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `artista`
--

LOCK TABLES `artista` WRITE;
/*!40000 ALTER TABLE `artista` DISABLE KEYS */;
INSERT INTO `artista` VALUES ('ander','cover',25,'teclado','si'),('borja','coyi',25,'triangulo','no'),('diego','ddepablo',20,'bateria','si'),('iker','ocio',20,'guitarra','no');
/*!40000 ALTER TABLE `artista` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `biografia`
--

DROP TABLE IF EXISTS `biografia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `biografia` (
  `nombre` varchar(30) NOT NULL,
  `id` int(11) NOT NULL,
  `hitos` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`nombre`,`id`),
  CONSTRAINT `fkbio` FOREIGN KEY (`nombre`) REFERENCES `artista` (`alias`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `biografia`
--

LOCK TABLES `biografia` WRITE;
/*!40000 ALTER TABLE `biografia` DISABLE KEYS */;
INSERT INTO `biografia` VALUES ('cover',1,'2001-->tema jarto'),('cover',2,'2002-->tema muuy jarto');
/*!40000 ALTER TABLE `biografia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grupo`
--

DROP TABLE IF EXISTS `grupo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grupo` (
  `nombre` varchar(30) NOT NULL,
  `nom_artista` varchar(200) NOT NULL DEFAULT '',
  PRIMARY KEY (`nombre`,`nom_artista`),
  KEY `nom_artista` (`nom_artista`),
  CONSTRAINT `grupo_ibfk_1` FOREIGN KEY (`nom_artista`) REFERENCES `artista` (`alias`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupo`
--

LOCK TABLES `grupo` WRITE;
/*!40000 ALTER TABLE `grupo` DISABLE KEYS */;
INSERT INTO `grupo` VALUES ('equipo_B','cover'),('equipo_B','coyi'),('equipo_B','ddepablo'),('equipo_B','ocio');
/*!40000 ALTER TABLE `grupo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instrumento`
--

DROP TABLE IF EXISTS `instrumento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `instrumento` (
  `nombre` varchar(30) NOT NULL DEFAULT '',
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instrumento`
--

LOCK TABLES `instrumento` WRITE;
/*!40000 ALTER TABLE `instrumento` DISABLE KEYS */;
INSERT INTO `instrumento` VALUES ('acordeon'),('bajo'),('bateria'),('flauta'),('guitarra'),('guitarra_electrica'),('piano'),('saxofon'),('tambor'),('teclado'),('triangulo'),('trompeta'),('viola'),('violin');
/*!40000 ALTER TABLE `instrumento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solista`
--

DROP TABLE IF EXISTS `solista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `solista` (
  `nombre` varchar(30) NOT NULL,
  PRIMARY KEY (`nombre`),
  CONSTRAINT `fknom` FOREIGN KEY (`nombre`) REFERENCES `artista` (`alias`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solista`
--

LOCK TABLES `solista` WRITE;
/*!40000 ALTER TABLE `solista` DISABLE KEYS */;
INSERT INTO `solista` VALUES ('cover');
/*!40000 ALTER TABLE `solista` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-05-19 13:04:01
