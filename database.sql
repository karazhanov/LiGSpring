CREATE DATABASE `lig` DEFAULT CHARACTER SET utf8;

CREATE TABLE `LoginUser` (
	`id` int NOT NULL,
	`login` varchar(45) NOT NULL,
	`password` varchar(120) NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `BaseUser` (
	`id` int NOT NULL AUTO_INCREMENT,
	`name` varchar(20) NOT NULL,
	`last_name` varchar(45) NOT NULL,
	`nickname` varchar NOT NULL,
	`middle_name` varchar(45),
	`birthday` DATE NOT NULL,
	`sex_male` BINARY NOT NULL,
	`registred_on` DATETIME NOT NULL,
	`avatar_url` varchar(45) NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `UserMessages` (
	`id` int NOT NULL,
	`user_id_from` int NOT NULL,
	`user_id_to` int NOT NULL,
	`sended_on` DATETIME NOT NULL,
	`message` TEXT NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;