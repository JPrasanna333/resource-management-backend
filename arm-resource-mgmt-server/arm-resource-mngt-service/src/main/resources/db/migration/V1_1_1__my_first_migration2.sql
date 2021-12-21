-- create database test;

CREATE TABLE `expenseNew` (
  `expenseId` int(11) NOT NULL AUTO_INCREMENT,
  `expenseItem` varchar(45) NOT NULL,
  `amount` float NOT NULL,
  PRIMARY KEY (`expenseId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;