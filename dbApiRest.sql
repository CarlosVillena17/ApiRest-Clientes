CREATE DATABASE  IF NOT EXISTS `db_apirest` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `db_apirest`;
-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: db_apirest
-- ------------------------------------------------------
-- Server version	8.0.25

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `apellido` varchar(255) DEFAULT NULL,
  `create_at` date DEFAULT NULL,
  `nombre` varchar(200) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=MyISAM AUTO_INCREMENT=77 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (73,'Carlitos Bommy','2022-03-08','carrrr','cvillxxenacabreaajos@gmail.com'),(7,'Johnson','2018-02-18','Ralphaaa','ralph.johnson@gmail.com'),(9,'Gosling','2018-03-03','Dr. James','james.gosling@gmail.com'),(10,'Lee','2018-03-04','Magma','magma.lee@gmail.com'),(11,'Roe','2018-03-05','Tornado','tornado.roe@gmail.com'),(34,'bear','2022-02-18','boomy','ssddsddl@gmail.com'),(35,'Lerdorf','2022-02-18','Richarsssd','rassssmu¿k.lerdorf@gml.com'),(37,'Villena','2022-02-18','Carlos','linus.torvalds@gmail.com'),(39,'bear','2022-02-18','boomyaa','loaaaasaasasasasal@gmail.com'),(41,'Cabrejos','2022-02-18','Carlos Ricardo','carlos.villena2@unmsm.edu.pe'),(71,'Villena','2022-03-08','Carlos Ricardo','asaaadadad@gmaoil.com'),(52,'ccolcca','2022-02-20','chancho','mibebaaita@gmail.com'),(54,'Villena','2022-02-20','Carlos','cviaaallenacabrejaaaos@gmail.com'),(68,'ccolcca|','2022-03-08','chanchito mariluz','avalos@gmail.com'),(72,'Carlitos Bommy','2022-03-08','carrrr','cvillxxenacabrejos@gmail.com'),(74,'sdadd','2022-03-08','sadds','sdadad'),(75,'ssasasas','2022-03-08','aasasas','sasas'),(76,'','2022-03-09','aassass','');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-15 17:43:12
