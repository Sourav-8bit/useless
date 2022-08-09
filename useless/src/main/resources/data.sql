Insert into user(username,password enabled)
values('user','pass',true);

insert into user(username,password,enabled)
values('admin','pass',true);


insert into authrities(username authority)
values('user','ROLE_USER');

insert into authrities(username authority)
values('admin','ROLE_ADMIN);