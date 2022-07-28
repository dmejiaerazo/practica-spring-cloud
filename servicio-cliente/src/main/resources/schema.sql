CREATE TABLE cliente (
id INT NOT NULL AUTO_INCREMENT,
nombre VARCHAR(50) NOT NULL,
identificacion VARCHAR(10) NOT NULL,
correo VARCHAR(50) NOT NULL,
estado VARCHAR(10) NOT NULL,
primary key (id)
);