-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.41-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema warehouse
--

CREATE DATABASE IF NOT EXISTS warehouse;
USE warehouse;

--
-- Definition of table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL auto_increment,
  `role_name` varchar(20) NOT NULL,
  PRIMARY KEY  (`role_id`),
  UNIQUE KEY `UK_iubw515ff0ugtm28p8g3myt0h` (`role_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role`
--

/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`role_id`,`role_name`) VALUES 
 (4,'ROLE_MTM'),
 (5,'ROLE_S'),
 (1,'ROLE_SM'),
 (2,'ROLE_WM'),
 (3,'ROLE_WS');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;


--
-- Definition of table `shipment_details`
--

DROP TABLE IF EXISTS `shipment_details`;
CREATE TABLE `shipment_details` (
  `id` int(11) NOT NULL auto_increment,
  `shipment_master_id` int(11) NOT NULL,
  `type` varchar(255) default NULL,
  `name` varchar(255) default NULL,
  `size` varchar(255) default NULL,
  `qty` varchar(255) default NULL,
  `active` tinyint(4) default '1',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `shipment_details`
--

/*!40000 ALTER TABLE `shipment_details` DISABLE KEYS */;
INSERT INTO `shipment_details` (`id`,`shipment_master_id`,`type`,`name`,`size`,`qty`,`active`) VALUES 
 (1,14,'435','wedwqe','wqewqe','wqewqe',1),
 (2,14,'5',NULL,'wqewq','ewqewqsa',1),
 (3,14,'453','wqewqe','wqewq','dfdsg',1),
 (4,14,'34534',NULL,'wqeewqewe','rtyerr',1);
/*!40000 ALTER TABLE `shipment_details` ENABLE KEYS */;


--
-- Definition of table `shipment_master`
--

DROP TABLE IF EXISTS `shipment_master`;
CREATE TABLE `shipment_master` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `suppliers_id` int(11) NOT NULL,
  `remarks` varchar(100) NOT NULL,
  `requested_date` varchar(45) NOT NULL,
  `active` tinyint(3) unsigned NOT NULL default '1',
  `status` varchar(45) NOT NULL default 'Initiated',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `shipment_master`
--

/*!40000 ALTER TABLE `shipment_master` DISABLE KEYS */;
INSERT INTO `shipment_master` (`id`,`suppliers_id`,`remarks`,`requested_date`,`active`,`status`) VALUES 
 (1,1,'qwewq','istiaque',1,'Initiated'),
 (2,1,'qwewq','2021-03-07',1,'Froward'),
 (3,1,'qwewq','2021-03-07',1,'Froward'),
 (4,1,'rewrew','2021-03-07',1,'Initiated'),
 (5,1,'rewrew','2021-03-07',1,'Froward'),
 (6,1,'rewrew','2021-03-07',1,'Initiated'),
 (7,1,'rewrew','2021-03-07',1,'Froward'),
 (8,1,'rewrew','2021-03-07',1,'Froward'),
 (12,1,'rewrew','2021-03-07',1,'Froward'),
 (13,1,'rewrew','2021-03-07',1,'Froward'),
 (14,1,'rewrew','2021-03-07',1,'Initiated');
/*!40000 ALTER TABLE `shipment_master` ENABLE KEYS */;


--
-- Definition of table `suppliers`
--

DROP TABLE IF EXISTS `suppliers`;
CREATE TABLE `suppliers` (
  `id` int(11) NOT NULL auto_increment,
  `address` varchar(255) default NULL,
  `contact_person_name` varchar(30) NOT NULL,
  `contact_person_phone` varchar(11) NOT NULL,
  `email` varchar(30) NOT NULL,
  `name` varchar(50) NOT NULL,
  `remarks` varchar(255) default NULL,
  `token` binary(255) default NULL,
  `type` varchar(20) NOT NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `UK_nwdngx5sgx1es5qgd9oq05vm9` (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `suppliers`
--

/*!40000 ALTER TABLE `suppliers` DISABLE KEYS */;
INSERT INTO `suppliers` (`id`,`address`,`contact_person_name`,`contact_person_phone`,`email`,`name`,`remarks`,`token`,`type`) VALUES 
 (1,'16 Akmol khan road, Mitford','Panta','01685331016','panthaistiaque@gmail.com','IH Traders',NULL,0x61386664646366622D613932332D346465322D393331392D623631363632323735656631000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000,'Vendor'),
 (2,'39 New market, Dhaka','Istiaque','01721672283','mdistiaque56@yahoo.com','Thai Brothers and Co.',NULL,0x31303335616631372D353635312D346434642D383661642D346266653466363430363436000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000,'Vendor');
/*!40000 ALTER TABLE `suppliers` ENABLE KEYS */;


--
-- Definition of table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  KEY `FKm01t79r1jd43urtdfwr98po4q` (`id`),
  CONSTRAINT `FKm01t79r1jd43urtdfwr98po4q` FOREIGN KEY (`id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_role`
--

/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` (`id`,`role_id`) VALUES 
 (1,1);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;


--
-- Definition of table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL auto_increment,
  `email` varchar(60) NOT NULL,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `password` varchar(64) NOT NULL,
  `phone` varchar(11) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`,`email`,`first_name`,`last_name`,`password`,`phone`) VALUES 
 (1,'pantha@gmail.com','Pantha','Istiaqe','123','01685331016');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
