CREATE USER root IDENTIFIED BY q1234;

GRANT CONNECT, RESOURCE TO root;

connect root/q1234;

create table person(
id_person number not null,
last_name varchar(30) not null,
first_name varchar(20) not null
);

COMMIT ;

INSERT INTO person VALUES(1,'Smit','Rose');
INSERT INTO person VALUES(2,'Freeman','Tom');

COMMIT;