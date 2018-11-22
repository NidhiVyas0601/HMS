CREATE DATABASE  IF NOT EXISTS `hms` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `hms`;
-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: hms
-- ------------------------------------------------------
-- Server version	8.0.12

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
-- Table structure for table `appointment`
--

DROP TABLE IF EXISTS `appointment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `appointment` (
  `appointment_id` int(11) NOT NULL AUTO_INCREMENT,
  `date` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `patient_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`appointment_id`),
  KEY `FK3mbue9w5cldlnxx3hm15t5sfo` (`patient_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointment`
--

LOCK TABLES `appointment` WRITE;
/*!40000 ALTER TABLE `appointment` DISABLE KEYS */;
/*!40000 ALTER TABLE `appointment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attendance`
--

DROP TABLE IF EXISTS `attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `attendance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `availabiltiy` varchar(255) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL,
  `attendance_time` time DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKb48lmkou5j4rvde9sr88bqgjw` (`employee_id`)
) ENGINE=MyISAM AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendance`
--

LOCK TABLES `attendance` WRITE;
/*!40000 ALTER TABLE `attendance` DISABLE KEYS */;
INSERT INTO `attendance` VALUES (40,'available',NULL,1,NULL,'2017-07-03 05:30:00'),(42,'available',NULL,2,NULL,'2018-11-15 23:58:56');
/*!40000 ALTER TABLE `attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `doctor` (
  `doctor_id` int(11) NOT NULL,
  `degree` varchar(255) DEFAULT NULL,
  `doc_certificate` varchar(255) DEFAULT NULL,
  `specialization` varchar(255) DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`doctor_id`),
  KEY `FKbq0hn7ebns12uwvf9mxkks8q3` (`employee_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor`
--

LOCK TABLES `doctor` WRITE;
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` VALUES (35,'MD Eye Specialist','C1238','Eye',2),(56,'MS','C373646','ophthalmologist',1),(57,'jjiji','jkkjkjk','jskk',3);
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `employees` (
  `id` int(11) NOT NULL,
  `date_of_birth` datetime DEFAULT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `email_id` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `gender` varchar(7) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `primay_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'2018-11-21 05:30:00','Doctor','RiyaR@gmail.com','Riya','Female','Rana','1234','990893456'),(2,'1990-03-09 05:30:00','Doctor','anu@gmail.com','anu','F','Singh','1234','830893456'),(3,'1975-03-09 05:30:00','Doctor','Tina@gmail.com','tina','F','Singh','1234','870893456'),(6,'1993-11-19 05:30:00','Nurse and wardboy','anitas@gmail.com','anita','Female','singh','1234','9876556756'),(52,'1995-09-18 05:30:00','Doctor','nidhi@gmail.com','nidhi','Male','vyas','1234','989786766');
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (81),(81);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient_doctor_record`
--

DROP TABLE IF EXISTS `patient_doctor_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `patient_doctor_record` (
  `id` int(11) NOT NULL,
  `admitted` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `doctor_id` int(11) DEFAULT NULL,
  `patient_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKevwe1vwcc5pujeyytok6qrwuy` (`doctor_id`),
  KEY `FKqsd1oug3jldp20onj3i02lbxr` (`patient_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient_doctor_record`
--

LOCK TABLES `patient_doctor_record` WRITE;
/*!40000 ALTER TABLE `patient_doctor_record` DISABLE KEYS */;
INSERT INTO `patient_doctor_record` VALUES (70,NULL,'2018-11-20','10:00am to 10:30am',56,69),(71,NULL,'2018-11-20','12:00pm to 12:30pm',57,69);
/*!40000 ALTER TABLE `patient_doctor_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patients`
--

DROP TABLE IF EXISTS `patients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `patients` (
  `patient_id` bigint(20) NOT NULL,
  `age` int(11) NOT NULL,
  `city` varchar(25) DEFAULT NULL,
  `contact_number` varchar(13) DEFAULT NULL,
  `email_id` varchar(30) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `guardian_name` varchar(50) DEFAULT NULL,
  `guardian_number` varchar(13) DEFAULT NULL,
  `health_issue` varchar(255) DEFAULT NULL,
  `house_number` varchar(30) DEFAULT NULL,
  `patient_name` varchar(60) DEFAULT NULL,
  `pincode` int(11) NOT NULL,
  `state` varchar(30) DEFAULT NULL,
  `street_number` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`patient_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patients`
--

LOCK TABLES `patients` WRITE;
/*!40000 ALTER TABLE `patients` DISABLE KEYS */;
INSERT INTO `patients` VALUES (69,35,'Ahmedabad','9658234521','anita@gmail.com','Female','Aman Sharma','5231456832','viral fever','c34','anita',123456,'Gujarat','street 3');
/*!40000 ALTER TABLE `patients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `report`
--

DROP TABLE IF EXISTS `report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `report` (
  `id` int(11) NOT NULL,
  `data` longblob,
  `report_name` varchar(20) DEFAULT NULL,
  `patient_record_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKiq7br6d5q0brqk4g16gngmt4e` (`patient_record_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `report`
--

LOCK TABLES `report` WRITE;
/*!40000 ALTER TABLE `report` DISABLE KEYS */;
INSERT INTO `report` VALUES (46,_binary 'I have worked on the college project called Income tax department management System. \r\nThe database was designed to access/ handle large data of an individual taxpayer/organization.\r\n I have also been a part of frontend and backend development using vue.js and express.js. \r\nI also have knowledge java and we are currently a team of 5 working on a java based project for the current semester on hospital management system.\r\nMy skills, knowledge nature of work and their level suits to the level of this post.\r\n As a fresher I don\'t have any experience level in this domain but I am very confident that if you provide me this opportunity I will \r\nsurely prove myself to be a worthy candidate for your eminent company. \r\nWith skill I possess like self motivation, leadership, and communication I\'ll prove myself not mere promising but also worthy.','wswhy.txt',1);
/*!40000 ALTER TABLE `report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room_allocation`
--

DROP TABLE IF EXISTS `room_allocation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `room_allocation` (
  `id` int(11) NOT NULL,
  `date` varchar(255) DEFAULT NULL,
  `patient_record` int(11) DEFAULT NULL,
  `room_record` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcxm4sj5x1bp22erjiedudit3v` (`patient_record`),
  KEY `FKa7pg8hxm6e2slb4uidkor2jp8` (`room_record`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room_allocation`
--

LOCK TABLES `room_allocation` WRITE;
/*!40000 ALTER TABLE `room_allocation` DISABLE KEYS */;
INSERT INTO `room_allocation` VALUES (79,'2018-11-20',70,75),(80,'2014-07-16',71,76);
/*!40000 ALTER TABLE `room_allocation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room_details`
--

DROP TABLE IF EXISTS `room_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `room_details` (
  `id` int(11) NOT NULL,
  `room_number` varchar(7) DEFAULT NULL,
  `room_type` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_hm1eww3j6kbe6593p6cg5gdmb` (`room_number`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room_details`
--

LOCK TABLES `room_details` WRITE;
/*!40000 ALTER TABLE `room_details` DISABLE KEYS */;
INSERT INTO `room_details` VALUES (75,'GW112','General Ward'),(76,'ICU131','ICU');
/*!40000 ALTER TABLE `room_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-21 16:02:21
