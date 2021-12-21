CREATE TABLE availability (

available_id int(11) NOT NULL AUTO_INCREMENT,
available_type varchar(20),
available_hours int(10),
   start_date TIMESTAMP,
   end_date TIMESTAMP,
   available_status varchar(15),
   create_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
   update_date TIMESTAMP DEFAULT NULL,
   is_deleted int(10) DEFAULT 0,
   PRIMARY KEY (available_id)
   
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;