/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  USUARIO
 * Created: 12 jun. 2025
 */
create database CRUD_JAVA_MVC
USE CRUD_JAVA_MVC

CREATE TABLE ROLES(
id int not null auto_increment,
nombre varchar(20) not null,
primary key(id)
);

create table Persona(
id int not null auto_increment,
Nombre varchar(100) not null,
Apellido varchar(100) not null,
Correo varchar(150) not null,
Fecha_Nacimientro Date not null,
Pais varchar(50) not null,
rol_id int not null,
Profesion varchar(50) not null,
primary key (id),
foreign key (rol_id) references ROLES(id)
);

INSERT INTO ROLES (nombre) 
VALUES 
('Admin'),
('Estudiante'),
('Empleado'),
('Secretario');

INSERT INTO Persona (Nombre, Apellido, Correo, Fecha_Nacimientro, Pais, rol_id, Profesion)
VALUES
('Carlos', 'Lopez', 'carlos.lopez@gmail.com', '1990-02-15', 'España', 1, 'Abogado'),
('Ana', 'Gomez', 'ana.gomez@yahoo.com', '1985-08-23', 'Peru', 2, 'Ingeniero'),
('Juan', 'Perez', 'juan.perez@gmail.com', '1993-05-12', 'México', 3, 'Contador'),
('Maria', 'Rodriguez', 'maria.rodriguez@hotmail.com', '1990-07-10', 'Argentina', 4, 'Secretaria'),
('Pedro', 'Martinez', 'pedro.martinez@outlook.com', '1988-09-17', 'Chile', 1, 'Gerente'),
('Lucia', 'Fernandez', 'lucia.fernandez@aol.com', '1992-03-25', 'España', 2, 'Arquitecta'),
('Luis', 'Gonzalez', 'luis.gonzalez@icloud.com', '1987-11-30', 'Colombia', 3, 'Programador'),
('Laura', 'Lopez', 'laura.lopez@live.com', '1995-01-20', 'Peru', 4, 'Diseñadora'),
('Ricardo', 'Sanchez', 'ricardo.sanchez@yahoo.com', '1990-04-11', 'México', 1, 'Abogado'),
('Elena', 'Diaz', 'elena.diaz@gmail.com', '1985-12-02', 'Argentina', 2, 'Ingeniera');




