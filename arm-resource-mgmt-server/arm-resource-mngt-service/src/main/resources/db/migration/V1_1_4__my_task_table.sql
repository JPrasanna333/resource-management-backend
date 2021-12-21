CREATE TABLE task (
  project_id int(11),
  task_id int(11) NOT NULL AUTO_INCREMENT,
  task_name varchar(45) NOT NULL unique,
  task_owner varchar(45) NOT NULL,
  start_date TIMESTAMP,
  end_date TIMESTAMP,
  duration float,
  priority varchar(45),
  status varchar(45),
  create_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  update_date TIMESTAMP DEFAULT NULL,
  created_by varchar(45),
  updated_by varchar(45),
  is_deleted int(10) DEFAULT 0,
  resource_id int(10) DEFAULT null,
  PRIMARY KEY (task_id),
  FOREIGN KEY (project_id) REFERENCES project(project_id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;