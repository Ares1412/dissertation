drop table if exists user_info;
drop table if exists sensor_data;
drop table if exists sensor_info;

create table if not exists user_info(
id varchar(100) primary key not null unique ,
name varchar(100) not null unique ,
password varchar(100) not null ,
create_time datetime default current_timestamp
)default charset = utf8;

create table if not exists user_sensor(
user_id varchar(100) not null ,
sensor_id varchar(100) not null,
create_time datetime default current_timestamp
)default charset = utf8;

create trigger dele_user_trigger after delete on user_info for each row
begin
    delete from user_sensor where
        user_id = OLD.id;
end;

create table if not exists sensor_info(
id varchar(100) primary key not null unique ,
type varchar(100) not null ,
longitude decimal(10,7) not null ,
latitude decimal(10,7) not null ,
create_time datetime default current_timestamp
)default charset = utf8;

create trigger dele_sensor_trigger after delete on sensor_info for each row
begin
    delete from user_sensor where
            sensor_id = OLD.id;
end;

create table if not exists sensor_data(
id varchar(100) not null ,
data double not null ,
error_upper double,
error_lower double,
time varchar(100) not null ,
create_time datetime default current_timestamp,
foreign key (id) references sensor_info(id)
)default charset = utf8;

insert into user_info (id, name, password)
values ('906620499','root','123');
insert into user_info (id, name, password)
values ('374927235','test','123');

insert into user_sensor (user_id, sensor_id)
values ('906620499','10165101203');
insert into user_sensor (user_id, sensor_id)
values ('906620499','10165101204');
insert into user_sensor (user_id, sensor_id)
values ('906620499','10165101205');

insert into sensor_info (id, type, longitude, latitude)
values ('10165101203','温度',121.4055186,31.2265366);
insert into sensor_info (id, type, longitude, latitude)
values ('10165101204','湿度',121.4054489,31.2265687);
insert into sensor_info (id, type, longitude, latitude)
values ('10165101205','温度',120.8995329,31.3443227);

insert into sensor_data(id, data, error_upper, error_lower, time)
values ('10165101203',18.63,0.31,0.53,'2020-05-08 22:45:34');

update user_info set name = 'wang',password = 1997 where id = 374927235;

select * from sensor_data where id='10165101203' and time like '2020-05-08%';

select sensor_id from user_sensor where user_id ='906620499';