insert into campaign(campaign_name,campaign_owner,start_date,end_date,priority,status,created_by) 
values('Hewlett-Packard','Enrique Lores','2021-11-15 08:00:00','2021-12-12 17:03:01','LOW','IN_PROGRESS','Admin');
insert into campaign(campaign_name,campaign_owner,start_date,end_date,priority,status,created_by) 
values('Dell','Alok Ohrie','2021-11-20 10:00:00','2022-01-23 17:30:01','MEDIUM','ON_HOLD','Admin');

insert into project(campaign_id,project_name, project_owner,start_date,end_date,priority,status,created_by) 
values(3,'Portfolio','Kabilash','2021-11-15 09:00:00','2021-12-12 09:03:01','LOW','IN_PROGRESS','Admin');
insert into project(campaign_id,project_name, project_owner,start_date,end_date,priority,status,created_by) 
values(4,'APEX','Hema','2021-11-20 09:00:00','2022-01-23 17:03:01','MEDIUM','ON_HOLD','Admin');

insert into task(project_id,task_name,task_owner,start_date,end_date,duration,priority,status,created_by,resource_id)
values(5,'Eta','Kowshik','2021-11-15 09:00:00','2021-12-12 09:03:01',26,'LOW','IN_PROGRESS','Admin',15);

insert into task(project_id,task_name,task_owner,start_date,end_date,duration,priority,status,created_by,resource_id)
values(6,'Omicron','Krishna','2021-11-20 09:00:00','2022-01-23 17:03:01',19,'MEDIUM','ON_HOLD','Admin',21);