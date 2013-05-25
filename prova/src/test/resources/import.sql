-- You can use this file to load seed data into the database using SQL statements
insert into Member (id, name, email, phone_number,password) values (0, 'Joao Da Silva', 'joao@silva.com.br', '2323122122', 'prova');
--drop table if exists Member_Roles;
--create table Member_Roles(id INT PRIMARY KEY, MEMBER_ID INT(12), MEMBER_ROLE VARCHAR(150));
insert into MemberROLE(id, MEMBER_ID, MEMBER_ROLE) values(0, 0, 'ROLE_USER');