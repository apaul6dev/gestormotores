#creacion de base de datos
create user admin password 'admin001';
create database etapadb with owner admin template template1;
grant all privileges on database etapadb to admin;