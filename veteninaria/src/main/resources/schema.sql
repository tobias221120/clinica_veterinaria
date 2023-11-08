CREATE database veterinaria;
USE veterinaria;
CREATE TABLE duenio (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(30),
    apellido VARCHAR(30),
    dni VARCHAR(10),
    celular VARCHAR(15)
);

CREATE TABLE mascota (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50),
    especie VARCHAR(25),
    raza VARCHAR(40),
    color VARCHAR(20),
    duenio_id INT,
    FOREIGN KEY (duenio_id) REFERENCES duenio(id)
);
