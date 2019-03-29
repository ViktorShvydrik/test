CREATE SCHEMA `vote` ;
 
use vote;

CREATE TABLE vote (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(20), 
link VARCHAR(20) unique,
status boolean default 0);

CREATE TABLE category (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
id_vote INT NOT NULL, 
name VARCHAR(20),
count INT(5)
);

ALTER TABLE category ADD CONSTRAINT fk_category_vote FOREIGN KEY (id_vote)
REFERENCES vote(id) ON DELETE CASCADE ON UPDATE CASCADE;

insert into vote (name, link) values ('Ваш возраст', 'NazSfrEA') ;
insert into vote (name, link, status) values ('Ваш пол', 'jLPAwiBr', 1) ;

insert into category (id_vote, name, count) values (1, 'до 18', 4);
insert into category (id_vote, name, count) values (1, '18-25', 1);
insert into category (id_vote, name, count) values (1, '25-35', 7);

insert into category (id_vote, name, count) values (2, 'Мужской', 4);
insert into category (id_vote, name, count) values (2, 'Женский', 6);