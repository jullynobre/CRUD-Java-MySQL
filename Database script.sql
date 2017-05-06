CREATE DATABASE crudjavamysql;

USE crudjavamysql;

CREATE TABLE caloteiro(
	id INT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(45) NULL,
	email VARCHAR(45) NULL,
	devendo INT NULL,
	dataDivida DATE NULL
);