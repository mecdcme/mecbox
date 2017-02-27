--
-- Table structure for table `mb_users`
--

DROP TABLE IF EXISTS `mb_users`;
CREATE TABLE `mb_users` (
  `userid` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `surname` varchar(100) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `EMAIL_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


--
-- Dumping data for table `mb_users`
--
-- user admin@mecbox.it password  mecbox
-- user guest@mecbox.it password  mec
LOCK TABLES `mb_users` WRITE;
INSERT INTO `mb_users` VALUES (1,'admin@mecbox.it','Admin','Mecbox','$2a$10$9rKQEP7mbFoCN82iNx16wuoVQ56WqQBGxbwU2HmDWI0G1BSucJqGW'),(2,'guest@mecbox.it','Guest','Mecbox','$2a$10$QZWKAPfnG2F0MIpANjKVvOzfu8VTvEgoPKEoASh93nO/ysRmnJaVC');
UNLOCK TABLES;

--
-- Table structure for table `mb_user_roles`
--

DROP TABLE IF EXISTS `mb_user_roles`;

CREATE TABLE `mb_user_roles` (
  `user_role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) DEFAULT NULL,
  `userid` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`user_role_id`),
  CONSTRAINT `FK_USER_ROLES` FOREIGN KEY (`userid`) REFERENCES `mb_users` (`userid`)
  ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `mb_user_roles`
--

LOCK TABLES `mb_user_roles` WRITE;
INSERT INTO `mb_user_roles` VALUES (1,'ADMIN',1),(2,'USER',2);
UNLOCK TABLES;


--
-- Table structure for table `mb_household`
--

DROP TABLE IF EXISTS `mb_household`;

CREATE TABLE `mb_household` (
  `region` char(17) DEFAULT NULL,
  `zone` int(2) DEFAULT NULL,
  `woreda` int(2) DEFAULT NULL,
  `city` int(1) DEFAULT NULL,
  `subcity` int(2) DEFAULT NULL,
  `psa` int(2) DEFAULT NULL,
  `sa` int(2) DEFAULT NULL,
  `kebele` int(3) DEFAULT NULL,
  `ea` int(2) DEFAULT NULL,
  `household` bigint(21) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 

--
-- Dumping data for table `mb_household`
--
LOCK TABLES `mb_household` WRITE;
INSERT INTO `mb_household` VALUES ('Addis Ababa',1,1,1,10,1,1,5,4,130),('Addis Ababa',1,1,1,4,1,2,6,4,145),('Addis Ababa',1,1,1,10,1,1,5,3,119),('Addis Ababa',1,1,1,4,1,1,6,3,130),('Addis Ababa',1,1,1,7,1,1,6,1,122),('Addis Ababa',1,1,1,7,1,1,6,5,97),('Addis Ababa',1,1,1,2,1,1,1,2,69),('Addis Ababa',1,1,1,4,1,1,6,2,120),('Addis Ababa',1,1,1,2,1,1,1,3,158),('Addis Ababa',1,1,1,2,1,1,1,1,59),('Addis Ababa',1,1,1,7,1,1,6,2,147),('Addis Ababa',1,1,1,4,1,2,6,6,141),('Addis Ababa',1,1,1,10,1,1,5,1,112),('Addis Ababa',1,1,1,10,1,1,5,2,129),('Addis Ababa',1,1,1,2,1,1,1,4,99),('Addis Ababa',1,1,1,7,1,1,6,3,151),('Addis Ababa',1,1,1,7,1,1,6,4,131),('Addis Ababa',1,1,1,4,1,1,6,1,190),('Addis Ababa',1,1,1,7,1,1,6,6,113),('Addis Ababa',1,1,1,4,1,2,6,5,130),('Afar',4,1,8,88,1,3,1,1,122),('Afar',2,4,8,88,1,1,1,3,222),('Afar',2,4,8,88,1,1,1,1,158),('Afar',4,1,8,88,1,1,2,3,12),('Afar',4,1,8,88,1,2,2,5,73),('Afar',4,1,8,88,1,2,2,6,53),('Afar',4,1,8,88,1,2,2,4,85),('Afar',2,4,8,88,1,1,1,5,135),('Afar',4,1,8,88,1,3,1,3,144),('Afar',2,4,8,88,1,1,1,4,141),('Afar',4,1,8,88,1,1,2,1,9),('Afar',2,4,8,88,1,1,1,2,130),('Afar',4,1,8,88,1,3,1,2,158),('Afar',4,1,8,88,1,1,2,2,70),('Amhara',4,5,4,1,1,1,1,2,180),('Amhara',5,10,8,88,1,1,18,2,156),('Amhara',5,10,8,88,1,2,18,5,146),('Amhara',5,10,8,88,1,1,18,1,129),('Amhara',9,1,1,1,1,2,8,6,117),('Amhara',4,5,8,88,1,1,5,5,109),('Amhara',5,11,8,88,1,1,13,4,114),('Amhara',4,5,8,88,1,1,5,2,158),('Amhara',5,10,8,88,1,2,18,4,160),('Amhara',9,1,1,1,1,2,8,7,181),('Amhara',5,11,8,88,1,1,13,3,117),('Amhara',4,5,4,1,1,1,1,1,149),('Amhara',5,11,8,88,1,3,13,5,120),('Amhara',4,5,4,1,1,1,1,4,213),('Amhara',9,1,1,1,1,1,8,1,33),('Amhara',5,11,8,88,1,1,13,1,104),('Amhara',4,5,4,1,1,1,1,5,152),('Amhara',5,10,8,88,1,1,18,3,143),('Amhara',4,5,4,1,1,1,1,3,160),('Amhara',5,11,8,88,1,1,13,2,153),('Amhara',9,1,1,1,1,1,8,4,39),('Amhara',4,5,8,88,1,1,5,3,114),('Amhara',9,1,1,1,1,1,8,3,36),('Amhara',9,1,1,1,1,2,8,5,181),('Amhara',4,5,8,88,1,1,5,1,135),('Amhara',4,5,8,88,1,1,5,4,118),('Amhara',5,10,8,88,1,2,18,7,4),('Amhara',5,10,8,88,1,2,18,6,5),('Diredawa',1,1,1,1,1,1,10,5,180),('Diredawa',1,1,8,88,1,1,1,3,75),('Diredawa',1,1,8,88,1,3,2,4,153),('Diredawa',1,1,8,88,1,1,1,2,119),('Diredawa',1,1,1,1,1,1,10,2,150),('Diredawa',1,1,8,88,1,1,1,1,143),('Diredawa',1,1,1,1,1,1,10,3,190),('Diredawa',1,1,8,88,1,2,2,2,119),('Diredawa',1,1,8,88,1,2,2,3,140),('Diredawa',1,1,1,1,1,1,10,4,110),('Diredawa',1,1,1,1,1,1,10,1,150),('Diredawa',1,1,8,88,1,3,2,5,119),('Diredawa',1,1,8,88,1,2,2,1,167),('Gambella',1,2,8,88,1,1,2,3,234),('Gambella',1,2,8,88,1,1,1,2,257),('Gambella',1,2,8,88,1,1,2,2,168),('Gambella',1,2,8,88,1,1,2,1,264),('Gambella',1,2,8,88,1,1,1,1,278),('Harari',1,1,1,1,1,1,2,2,91),('Harari',1,1,1,1,1,2,2,5,56),('Harari',1,1,8,88,1,1,1,4,100),('Harari',1,1,8,88,1,1,1,3,133),('Harari',1,1,1,1,1,1,2,3,109),('Harari',1,1,8,88,1,1,1,1,131),('Harari',1,1,1,1,1,1,2,4,103),('Harari',1,1,1,1,1,2,2,7,14),('Harari',1,1,1,1,1,1,2,1,107),('Harari',1,1,8,88,1,1,1,2,70),('Harari',1,1,8,88,1,1,1,5,34),('Oromia',5,4,8,88,1,1,1,4,161),('Oromia',2,2,8,88,1,1,3,4,96),('Oromia',5,4,8,88,1,1,1,1,172),('Oromia',5,4,8,88,1,1,1,2,126),('Oromia',2,2,8,88,1,1,3,3,108),('Oromia',5,7,2,1,1,1,1,2,192),('Oromia',5,4,8,88,1,1,1,5,116),('Oromia',5,7,2,1,1,1,1,1,247),('Oromia',5,4,8,88,1,1,1,3,162),('Oromia',2,2,8,88,1,1,3,1,132),('SNNP',11,10,8,88,1,2,12,2,165),('SNNP',1,2,8,88,1,1,1,3,176),('SNNP',11,10,8,88,1,2,12,1,175),('SNNP',11,10,8,88,1,1,2,5,121),('SNNP',11,10,8,88,1,1,2,4,143),('SNNP',11,10,2,1,1,1,11,4,189),('SNNP',4,4,1,1,1,1,1,5,185),('SNNP',10,9,8,88,1,1,1,1,232),('SNNP',11,10,2,1,1,1,11,5,177),('SNNP',11,10,8,88,1,1,2,1,167),('SNNP',4,4,1,1,1,1,1,3,135),('SNNP',4,4,1,1,1,1,1,4,152),('SNNP',11,10,8,88,1,2,12,4,166),('SNNP',1,2,8,88,1,1,1,2,189),('SNNP',11,10,2,1,1,1,11,3,224),('SNNP',11,10,8,88,1,1,2,3,168),('SNNP',1,2,8,88,1,1,1,5,141),('SNNP',10,9,8,88,1,1,1,4,134),('SNNP',1,2,8,88,1,1,1,4,163),('SNNP',1,2,8,88,1,1,1,1,267),('SNNP',11,10,2,1,1,1,11,1,249),('SNNP',11,10,8,88,1,1,2,2,144),('SNNP',10,9,8,88,1,1,1,3,182),('SNNP',4,4,1,1,1,1,1,2,190),('SNNP',11,10,2,1,1,1,11,2,158),('SNNP',4,4,1,1,1,1,1,1,130),('SNNP',11,10,8,88,1,2,12,3,103),('SNNP',10,9,8,88,1,1,1,2,126),('Somalie',1,2,1,1,1,6,1,2,64),('Somalie',2,7,8,88,1,1,1,1,61),('Somalie',2,7,8,88,1,2,1,4,36),('Somalie',1,1,8,88,1,5,9,1,184),('Somalie',2,7,8,88,1,1,1,2,60),('Somalie',1,1,8,88,1,1,1,1,81),('Somalie',1,2,8,88,1,2,2,1,82),('Somalie',1,2,8,88,1,6,19,1,58),('Somalie',1,1,8,88,1,1,1,5,1),('Somalie',1,1,8,88,1,1,1,2,103),('Somalie',1,1,8,88,1,1,1,3,45),('Somalie',1,1,8,88,1,5,9,2,161),('Somalie',2,7,8,88,1,2,1,5,55),('Somalie',1,2,1,1,1,6,1,1,8),('Somalie',2,7,8,88,1,2,1,3,32),('Tigray',4,6,8,88,1,1,5,2,102),('Tigray',4,6,8,88,1,1,5,1,119),('Tigray',4,4,1,1,1,1,5,3,142),('Tigray',4,6,8,88,1,1,5,3,122),('Tigray',4,5,8,88,1,1,2,4,142),('Tigray',4,5,8,88,1,1,2,5,37),('Tigray',4,4,1,1,1,1,5,2,116),('Tigray',4,6,8,88,1,1,5,4,109),('Tigray',4,6,8,88,1,1,5,5,165),('Tigray',4,4,1,1,1,1,5,5,92),('Tigray',4,4,1,1,1,1,5,6,111),('Tigray',4,5,8,88,1,1,2,1,91),('Tigray',4,4,1,1,1,1,5,1,158);
UNLOCK TABLES;

--
-- Table structure for table `mb_religion`
--

DROP TABLE IF EXISTS `mb_religion`;

CREATE TABLE `mb_religion` (
  `ID` bigint(21) NOT NULL,
  `RELIGION` char(14) DEFAULT NULL,
  `INDIVIDUALS` bigint(21) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Dumping data for table `mb_religion`
--

LOCK TABLES `mb_religion` WRITE;
INSERT INTO `mb_religion` VALUES (1,'Bahai',1),(2,'Catholic',1048),(3,'Jew',1),(4,'Jova',16),(5,'Muslim',25971),(6,'No religion',43),(7,'Orthodox',26155),(8,'Others',35),(9,'Protestant',23971),(10,'Traditionalist',441),(11,'Wakefena',162);
UNLOCK TABLES;


--
-- Table structure for table `mb_sex_distribution`
--

DROP TABLE IF EXISTS `mb_sex_distribution`;

CREATE TABLE `mb_sex_distribution` (
  `ID` bigint(21) NOT NULL,
  `range` varchar(8) NOT NULL DEFAULT '',
  `male` bigint(21) NOT NULL DEFAULT '0',
  `female` bigint(21) NOT NULL DEFAULT '0',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Dumping data for table `mb_sex_distribution`
--

LOCK TABLES `mb_sex_distribution` WRITE;
INSERT INTO `mb_sex_distribution` VALUES (1,'0 to 4',4699,4541),(2,'5 to 10',7143,6879),(3,'11 to 16',5858,5679),(4,'17 to 25',6688,7810),(5,'26 to 34',4879,5218),(6,'35 to 45',5213,4700),(7,'46 to 55',1803,1964),(8,'56 to 65',1400,1296),(9,'66 to 78',879,732),(10,'79 to 99',361,337);
UNLOCK TABLES;


-- Dump completed on 2017-02-16 14:24:08
