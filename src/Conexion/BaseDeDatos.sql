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


