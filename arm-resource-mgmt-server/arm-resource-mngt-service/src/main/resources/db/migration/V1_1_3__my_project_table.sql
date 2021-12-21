CREATE TABLE project (
  campaign_id int(11),
  project_id int(11) NOT NULL AUTO_INCREMENT,
  project_name varchar(45) NOT NULL unique,
  project_owner varchar(45) NOT NULL,
  start_date TIMESTAMP,
  end_date TIMESTAMP,
  priority varchar(45),
  status varchar(45),
  create_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  update_date TIMESTAMP DEFAULT NULL,
  is_deleted int(10) DEFAULT 0,
  created_by varchar(45),
  updated_by varchar(45),
  PRIMARY KEY (project_id),
  FOREIGN KEY (campaign_id) REFERENCES campaign(campaign_id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;