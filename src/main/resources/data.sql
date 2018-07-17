/**
 * CREATE Script for init of DB
 */

-- Create Boards

insert into restaurante (id, nombre, descripcion, direccion)
values (1, 'Sushi','Arroz', 'Calle Si');

insert into restaurante (id, nombre, descripcion, direccion)
values (2, 'Pizzas','Italiano', 'Plaza Venecia');

insert into restaurante (id, nombre, descripcion, direccion)
values (3, 'Mexicano', 'Tacos', 'Aqui');

insert into restaurante (id, nombre, descripcion, direccion)
values (4, 'El de aqui al lado', 'Pues eso', 'Alli');

insert into restaurante (id, nombre, descripcion, direccion)
values (5, 'Bueno no tengo tanta imaginación', 'Sah', 'Meh');


insert into reserva (id, localizador, personas, restaurante)
values (1, 45360, 4, 'Sushi');

insert into restaurante_reservas (restaurante_id, reservas_id)
values (1,1)

