CREATE DATABASE  IF NOT EXISTS `EmployeeProDirectory`;
USE `EmployeeProDirectory`;
--
-- Table structure for table `employee`
--
DROP TABLE IF EXISTS `EmployeePro`;

CREATE TABLE `EmployeePro` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `employee`
--
INSERT INTO `EmployeePro` VALUES
	(1,'Harry','Styles','Harry@gmail.com'),
	(2,'Emma','Watson','Emma@gmail.com'),
	(3,'Sansa','Stark','Sansa@gmail.com'),
	(4,'Frodo','Baggins','Frodo@gmail.com'),
	(5,'Emilia','Clarke','Emilia@gmail.com');