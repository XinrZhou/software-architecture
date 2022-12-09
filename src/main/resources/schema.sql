create table if not exists`user`
(
    id int primary key auto_increment ,
    account varchar(20) not null ,
    password varchar(40) not null ,
    role int not null ,

    unique (account)
);

create table if not exists `address`
(
    id int primary key auto_increment ,
    detail varchar(40) not null ,
    user_id int not null ,

    index (user_id)
);

