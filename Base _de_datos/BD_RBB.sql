create database BD_RBB;

use desafio_listar_inscripciones;

create table curso(
	id_curso integer auto_increment,
    descripcion varchar(50),
    precio decimal,
    constraint pk_id_cpeliculasurso primary key (id_curso)
);

create table forma_de_pago(
	id_forma_de_pago integer auto_increment,
    descripcion varchar(50),
    recargo varchar(20),
    constraint pk_id_forma_de_pago primary key (id_forma_de_pago)
);

create table inscripcion(
	id_insc integer auto_increment,
    nombre varchar(30),
    clave varchar(200),
    rol varchar(10),
    celular varchar(10),
    id_curso integer,
    id_forma_de_pago integer,
    constraint pk_id_insc primary key (id_insc),
    constraint fk_table_curso foreign key (id_curso) references curso(id_curso) on delete cascade,
    constraint fk_table_forma_de_pago foreign key (id_forma_de_pago) references forma_de_pago(id_forma_de_pago) on delete cascade
);


insert into curso( descripcion, precio)
values( "programacion java", 200000);
insert into curso( descripcion, precio)
values( "programacion python", 300000);
insert into curso( descripcion, precio)
values( "programacion nodeJS", 300000);
insert into curso(descripcion, precio)
values("programacion Ruby on rails", 250000);
insert into curso( descripcion, precio)
values("programacion front end VUE JS", 200000);
insert into curso( descripcion, precio)
values("programacion front end Angular", 250000);
insert into curso( descripcion, precio)
values("programacion front end React JS", 250000);
insert into curso(descripcion, precio)
values( "programacion PHP", 150000);
insert into curso(descripcion, precio)
values( "programacion C++", 200000);
insert into curso( descripcion, precio)
values("programacion C#", 200000);

insert into forma_de_pago(id_forma_de_pago, descripcion, recargo)
values(2001, "Credito", "Si");
insert into forma_de_pago(id_forma_de_pago, descripcion, recargo)
values(2002, "Debito", "Si");
insert into forma_de_pago(id_forma_de_pago, descripcion, recargo)
values(2003, "PayPal", "Si");


insert into inscripcion(nombre, clave, rol, celular, id_curso, id_forma_de_pago)
values("marcos ojeda", "contra1", "ADMIN", "982490014", 2, 2001);
insert into inscripcion(nombre, clave, rol, celular, id_curso, id_forma_de_pago)
values("antonio escalante", "contra2", "USER", "6548351", 2, 2002);
insert into inscripcion(nombre, clave, rol, celular, id_curso, id_forma_de_pago)
values("barbara feres", "contra3", "USER", "984651", 3, 2002);
insert into inscripcion(nombre, clave, rol, celular, id_curso, id_forma_de_pago)
values("javier perez", "contra4", "USER", "68514684", 4, 2002);
insert into inscripcion(nombre, clave, rol, celular, id_curso, id_forma_de_pago)
values("katherine diaz", "contra5", "USER", "6854684", 5, 2001);
insert into inscripcion(nombre, clave, rol, celular, id_curso, id_forma_de_pago)
values("reinaldo barriga", "contra6", "USER", "887585777", 6, 2002);