CREATE TABLE resource (
leave_id int(11),
resource_id int(11) NOT NULL AUTO_INCREMENT,
  available_id int(11),
  resource_name varchar(45) NOT NULL unique,
  resource_type varchar(45) NOT NULL,
   create_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
   update_date TIMESTAMP DEFAULT NULL,
   is_deleted int(10) DEFAULT 0,
   PRIMARY KEY (resource_id),
   FOREIGN KEY (available_id) REFERENCES availability(available_id),
FOREIGN KEY (leave_id) REFERENCES leaves(leave_id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
