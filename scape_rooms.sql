create database if not exists Scape_db;
use Scape_db;

create table scape_rooms (
    id int auto_increment primary key,
    name varchar(100),
    difficulty varchar(50),
    duration int
);