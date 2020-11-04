drop table if exists device_info;
drop table if exists device_user_param_info;
drop table if exists object_sequence_info;
drop table if exists parameter_info;
drop table if exists product_info;
drop table if exists role_info;
drop table if exists user_info;
drop table if exists user_role_info;
create table device_info (object_id bigint not null, created_date datetime(6), description varchar(1000), device_name varchar(255), device_remark varchar(1000), sold_date datetime(6), updated_date datetime(6), assigned_to bigint, product_id bigint, primary key (object_id)) engine=InnoDB;
create table device_user_param_info (object_id bigint not null, assessment_date datetime(6), device_id bigint, parameter_id bigint, parameter_value varchar(255), risk_factor varchar(255), user_id bigint, primary key (object_id)) engine=InnoDB;
create table object_sequence_info (object_name varchar(255) not null, sequence_increment bigint, max_used_sequence bigint, primary key (object_name)) engine=InnoDB;
create table parameter_info (object_id bigint not null, created_date datetime(6), parameter_name varchar(255), parameter_type varchar(255), updated_date datetime(6), product_id bigint, primary key (object_id)) engine=InnoDB;
create table product_info (object_id bigint not null, created_date datetime(6), product_category varchar(255), product_name varchar(255), product_status varchar(255), updated_date datetime(6), product_vendor varchar(255), primary key (object_id)) engine=InnoDB;
create table role_info (object_id bigint not null, created_date datetime(6), name varchar(40), updated_date datetime(6), primary key (object_id)) engine=InnoDB;
create table user_info (object_id bigint not null, user_age integer, user_contact_number varchar(255), created_date datetime(6), date_of_birth datetime(6), email varchar(255), first_name varchar(255), last_name varchar(255), password varchar(255), updated_date datetime(6), user_gender varchar(255), user_imei varchar(255), user_status bit, created_by bigint, primary key (object_id)) engine=InnoDB;
create table user_role_info (login_id bigint not null, role_id bigint not null, primary key (login_id, role_id)) engine=InnoDB;
alter table device_info add constraint UKfg9xgaiibp18gtjt8l7un3k8y unique (device_name);
alter table parameter_info add constraint UKlmiqk7woioh8l1phlyogknvyl unique (parameter_name, parameter_type, product_id);
alter table user_info add constraint UKgnu0k8vv6ptioedbxbfsnan9g unique (email);
alter table device_info add constraint FKg44vbid0ys6q0ncy30df7a50b foreign key (assigned_to) references user_info (object_id);
alter table device_info add constraint FKx0dd4t8j8pktmfvloodeyws4 foreign key (product_id) references product_info (object_id);
alter table parameter_info add constraint FK7wlf0f9sffg36gfnh17mjlxq8 foreign key (product_id) references product_info (object_id);
alter table user_info add constraint FKi4jcp54w6035tta98sxexwdxr foreign key (created_by) references user_info (object_id);
alter table user_role_info add constraint FK6roe2639sbv0me3wl2e701dqh foreign key (role_id) references role_info (object_id);
alter table user_role_info add constraint FK31i6tromuksc02i12oju74l7b foreign key (login_id) references user_info (object_id);

insert  into `object_sequence_info`(`object_name`,`sequence_increment`,`max_used_sequence`) values 
('com.kiwisense.dal.model.Device',13510798882121489,13510798882122488),
('com.kiwisense.dal.model.Product',18014398509491985,18014398509492984),
('com.kiwisense.dal.model.ProductParameter',22517998136862486,22517998136863480),
('com.kiwisense.dal.model.Role',9007199254750993,9007199254751992),
('com.kiwisense.dal.model.User',4503599627380497,4503599627381496);


insert  into `role_info`(`object_id`,`created_date`,`name`,`updated_date`) values (9007199254750992,'2020-11-01 13:47:53.815000','ROLE_ADMIN','2020-11-01 13:47:53.815000'), (9007199254750993,'2020-11-01 13:47:53.828000','ROLE_DOCTOR','2020-11-01 13:47:53.828000'),(9007199254750994,'2020-11-01 13:47:53.836000','ROLE_PATIENT','2020-11-01 13:47:53.836000');


insert  into `user_info`(`object_id`,`user_age`,`user_contact_number`,`created_date`,`date_of_birth`,`email`,`first_name`,`last_name`,`password`,`updated_date`,`user_gender`,`user_imei`,`user_status`,`created_by`) values 
(4503599627380496,0,NULL,'2020-11-01 13:47:54.030000',NULL,'admin@kiwisense.com',NULL,NULL,'$2a$10$q9WDjYtWglvEPUbglsRg1eRykPdEOO6gn7IFm9zLS06DBT2SuE2Ka','2020-11-01 13:47:54.030000',NULL,NULL,NULL,NULL),
(4503599627380497,0,NULL,'2020-11-01 13:47:54.140000',NULL,'testreg@gmail.com',NULL,NULL,'$2a$10$x7NpZgK2oXBYjks0Z5Mj..zXsYfOjB3EgKMFj3x54SfzkNM6pd13O','2020-11-01 13:47:54.140000',NULL,NULL,NULL,NULL);


insert  into `user_role_info`(`login_id`,`role_id`) values (4503599627380496,9007199254750992),(4503599627380497,9007199254750994);




insert  into `product_info`(`object_id`,`created_date`,`product_category`,`product_name`,`product_status`,`updated_date`,`product_vendor`) values 
(18014398509491984,'2020-11-01 17:14:59.239000','Watch','Kiwi Watch','Good','2020-11-01 17:14:59.239000','KIWI');


insert  into `parameter_info`(`object_id`,`created_date`,`parameter_name`,`parameter_type`,`updated_date`,`product_id`) values 
(22517998136862480,'2020-11-01 17:14:59.248000','DISTANCE','string','2020-11-01 17:14:59.248000',18014398509491984),
(22517998136862481,'2020-11-01 17:14:59.249000','TEMPERATURE','string','2020-11-01 17:14:59.249000',18014398509491984),
(22517998136862482,'2020-11-01 17:14:59.250000','BURNT_CALORIES','string','2020-11-01 17:14:59.250000',18014398509491984),
(22517998136862483,'2020-11-01 17:14:59.251000','HEART_RATE','string','2020-11-01 17:14:59.252000',18014398509491984),
(22517998136862484,'2020-11-01 17:14:59.252000','STEPS','string','2020-11-01 17:14:59.252000',18014398509491984),
(22517998136862485,'2020-11-01 17:14:59.254000','SPO2','string','2020-11-01 17:14:59.254000',18014398509491984);

insert  into `device_info`(`object_id`,`created_date`,`description`,`device_name`,`device_remark`,`sold_date`,`updated_date`,`assigned_to`,`product_id`) values 
(13510798882121488,'2020-11-01 17:14:59.243000',NULL,'123456','sold','2020-11-01 17:14:59.214000','2020-11-01 17:14:59.243000',4503599627380497,18014398509491984);



