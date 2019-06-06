-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: parking
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cliente` (
  `ID_Cliente` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(45) NOT NULL,
  `Telefone` varchar(13) NOT NULL,
  `Endereco` varchar(100) NOT NULL,
  `FK_ID_Valor` int(11) NOT NULL,
  `Placa` varchar(10) NOT NULL,
  `Modelo` varchar(45) NOT NULL,
  PRIMARY KEY (`ID_Cliente`),
  KEY `FK_ID_Valor` (`FK_ID_Valor`),
  KEY `Placa` (`Placa`),
  CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`FK_ID_Valor`) REFERENCES `valores` (`ID_Valor`),
  CONSTRAINT `cliente_ibfk_2` FOREIGN KEY (`Placa`) REFERENCES `veiculo` (`Placa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `controledeacesso`
--

DROP TABLE IF EXISTS `controledeacesso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `controledeacesso` (
  `ID_Acesso` int(11) NOT NULL AUTO_INCREMENT,
  `HoraEntrada` datetime NOT NULL,
  `HoraSaida` datetime DEFAULT NULL,
  `Placa` varchar(8) NOT NULL,
  `Modelo` varchar(45) NOT NULL,
  `Valor` decimal(10,0) DEFAULT NULL,
  `FK_ID_Usuario` int(11) DEFAULT NULL,
  `FK_ID_Valor` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_Acesso`),
  KEY `FK_ID_Usuario` (`FK_ID_Usuario`),
  KEY `FK_ID_Valor` (`FK_ID_Valor`),
  CONSTRAINT `controledeacesso_ibfk_1` FOREIGN KEY (`FK_ID_Usuario`) REFERENCES `usuariooperacional` (`ID_usuario`),
  CONSTRAINT `controledeacesso_ibfk_2` FOREIGN KEY (`FK_ID_Valor`) REFERENCES `valores` (`ID_Valor`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `controledeacesso`
--

LOCK TABLES `controledeacesso` WRITE;
/*!40000 ALTER TABLE `controledeacesso` DISABLE KEYS */;
INSERT INTO `controledeacesso` VALUES (1,'2019-05-06 21:01:54','2019-05-06 21:02:28','cba-1234','modelo',NULL,NULL,NULL);
/*!40000 ALTER TABLE `controledeacesso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuariooperacional`
--

DROP TABLE IF EXISTS `usuariooperacional`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usuariooperacional` (
  `ID_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(45) NOT NULL,
  `Telefone` char(13) NOT NULL,
  `Endereco` varchar(250) NOT NULL,
  `NivelDeAcesso` varchar(13) NOT NULL,
  PRIMARY KEY (`ID_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuariooperacional`
--

LOCK TABLES `usuariooperacional` WRITE;
/*!40000 ALTER TABLE `usuariooperacional` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuariooperacional` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `valores`
--

DROP TABLE IF EXISTS `valores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `valores` (
  `ID_Valor` int(11) NOT NULL AUTO_INCREMENT,
  `ValorAvulso` decimal(10,0) NOT NULL,
  `ValorMensalidade_A` decimal(10,0) NOT NULL,
  `ValorMensalidade_B` decimal(10,0) NOT NULL,
  `ValorMensalidade_C` decimal(10,0) NOT NULL,
  PRIMARY KEY (`ID_Valor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `valores`
--

LOCK TABLES `valores` WRITE;
/*!40000 ALTER TABLE `valores` DISABLE KEYS */;
/*!40000 ALTER TABLE `valores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `veiculo`
--

DROP TABLE IF EXISTS `veiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `veiculo` (
  `Placa` varchar(8) NOT NULL,
  `Modelo` varchar(45) NOT NULL,
  `FK_ID_Cliente` int(11) DEFAULT NULL,
  PRIMARY KEY (`Placa`),
  KEY `FK_ID_Cliente` (`FK_ID_Cliente`),
  CONSTRAINT `veiculo_ibfk_1` FOREIGN KEY (`FK_ID_Cliente`) REFERENCES `cliente` (`ID_Cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `veiculo`
--

LOCK TABLES `veiculo` WRITE;
/*!40000 ALTER TABLE `veiculo` DISABLE KEYS */;
/*!40000 ALTER TABLE `veiculo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'parking'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-05 21:06:05
