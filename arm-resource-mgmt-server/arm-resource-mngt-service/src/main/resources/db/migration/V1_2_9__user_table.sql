CREATE TABLE users (
 user_name VARCHAR(45) NOT NULL UNIQUE,
 first_name VARCHAR(45),
 last_name VARCHAR(45),
 password VARCHAR(225),
 PRIMARY KEY(user_name)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
