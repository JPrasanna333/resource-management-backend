CREATE TABLE leaves (
leave_id int(11) NOT NULL AUTO_INCREMENT,
   start_date TIMESTAMP,
   end_date TIMESTAMP,
   leave_count int(11),
   create_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
   update_date TIMESTAMP DEFAULT NULL,
   is_deleted int(10) DEFAULT 0,
   PRIMARY KEY (leave_id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;