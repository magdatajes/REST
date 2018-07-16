/**
 * CREATE Script for init of DB
 */

-- Create Boards

insert into restaurante (id, nombre)
values (1, 'Sushi');

insert into restaurante (id, nombre)
values (2, 'Pizzas');

insert into restaurante (id, nombre)
values (3, 'Mexicano');

insert into restaurante (id, nombre)
values (4, 'El de aqui al lado');

insert into restaurante (id, nombre)
values (5, 'Bueno no tengo tanta imaginación');


insert into reserva (id, localizador, personas)
values (1, 45360, 4);

