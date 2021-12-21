alter table campaign add column region varchar(30);

update campaign set region='IMEA' where campaign_id=1;
update campaign set region='NAC' where campaign_id=2;