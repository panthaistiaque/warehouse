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
-- Definition of table role
--

DROP TABLE IF EXISTS role;
CREATE TABLE role (
  role_id int(11) NOT NULL auto_increment,
  role_name varchar(20) NOT NULL,
  PRIMARY KEY  (role_id),
  UNIQUE KEY UK_iubw515ff0ugtm28p8g3myt0h (role_name)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table role
--

/*!40000 ALTER TABLE role DISABLE KEYS */;
/*!40000 ALTER TABLE role ENABLE KEYS */;


--
-- Definition of table shipment_details
--

DROP TABLE IF EXISTS shipment_details;
CREATE TABLE shipment_details (
  id int(11) NOT NULL auto_increment,
  shipment_master_id int(11) NOT NULL,
  type varchar(255) default NULL,
  name varchar(255) default NULL,
  size varchar(255) default NULL,
  qty varchar(255) default NULL,
  active tinyint(4) default '1',
  PRIMARY KEY  (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table shipment_details
--

/*!40000 ALTER TABLE shipment_details DISABLE KEYS */;
/*!40000 ALTER TABLE shipment_details ENABLE KEYS */;


--
-- Definition of table shipment_master
--

DROP TABLE IF EXISTS shipment_master;
CREATE TABLE shipment_master (
  id int(10) unsigned NOT NULL auto_increment,
  suppliers_id int(11) NOT NULL,
  remarks varchar(100) NOT NULL,
  requested_date varchar(45) NOT NULL,
  active tinyint(3) unsigned NOT NULL default '1',
  PRIMARY KEY  (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table shipment_master
--

/*!40000 ALTER TABLE shipment_master DISABLE KEYS */;
/*!40000 ALTER TABLE shipment_master ENABLE KEYS */;


--
-- Definition of table suppliers
--

DROP TABLE IF EXISTS suppliers;
CREATE TABLE suppliers (
  id int(11) NOT NULL auto_increment,
  address varchar(255) default NULL,
  contact_person_name varchar(30) NOT NULL,
  contact_person_phone varchar(11) NOT NULL,
  email varchar(30) NOT NULL,
  name varchar(50) NOT NULL,
  remarks varchar(255) default NULL,
  type varchar(20) NOT NULL,
  PRIMARY KEY  (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table suppliers
--

/*!40000 ALTER TABLE suppliers DISABLE KEYS */;
INSERT INTO suppliers (id,address,contact_person_name,contact_person_phone,email,name,remarks,type) VALUES 
 (1,'Mitford','pantha','424424','mdistiaque56@yahoo.com','IH Traders Co.','eeee','OWN'),
 (2,'HO','pantha','424424','nurse@friendship.ngo','Procurment Division','rteetyety','OWN'),
 (3,'dfds','dsfdsfsdfsd','fsfsdfdsf','fsdfsdf','ssdfs','fsfdsfds','OWN');
/*!40000 ALTER TABLE suppliers ENABLE KEYS */;


--
-- Definition of table user_role
--

DROP TABLE IF EXISTS user_role;
CREATE TABLE user_role (
  id int(11) NOT NULL,
  role_id int(11) NOT NULL,
  KEY FKa68196081fvovjhkek5m97n3y (role_id),
  KEY FKm01t79r1jd43urtdfwr98po4q (id),
  CONSTRAINT FKa68196081fvovjhkek5m97n3y FOREIGN KEY (role_id) REFERENCES role (role_id),
  CONSTRAINT FKm01t79r1jd43urtdfwr98po4q FOREIGN KEY (id) REFERENCES users (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table user_role
--

/*!40000 ALTER TABLE user_role DISABLE KEYS */;
/*!40000 ALTER TABLE user_role ENABLE KEYS */;


--
-- Definition of table users
--

DROP TABLE IF EXISTS users;
CREATE TABLE users (
  id int(11) NOT NULL auto_increment,
  email varchar(60) NOT NULL,
  first_name varchar(20) NOT NULL,
  last_name varchar(20) NOT NULL,
  password varchar(64) NOT NULL,
  phone varchar(11) default NULL,
  PRIMARY KEY  (id),
  UNIQUE KEY UK_6dotkott2kjsp8vw4d0m25fb7 (email)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table users
--

/*!40000 ALTER TABLE users DISABLE KEYS */;
/*!40000 ALTER TABLE users ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
