CREATE TABLE categoria (
id INT NOT NULL AUTO_INCREMENT,
nombre VARCHAR(50) NOT NULL,
primary key (id)
);

CREATE TABLE libro (
id INT NOT NULL AUTO_INCREMENT,
nombre VARCHAR(50) NOT NULL,
descripcion VARCHAR(70) NOT NULL,
cantidad INT NOT NULL,
estado VARCHAR(10) NOT NULL,
id_categoria INT NOT NULL,
primary key (id)
);