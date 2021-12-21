CREATE TABLE users_role (
  user_name VARCHAR(45) NOT NULL,
  role_name VARCHAR(45) NOT NULL,
  PRIMARY KEY (user_name,role_name),
  KEY username (user_name),
  CONSTRAINT users_role_ibfk_1 
   FOREIGN KEY (user_name) REFERENCES users (user_name),
  CONSTRAINT users_role_ibfk_2 
   FOREIGN KEY (role_name) REFERENCES role (role_name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;