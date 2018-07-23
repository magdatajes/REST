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

insert into turno (id, descripcion)
values (1, 'De 13 a 15');

insert into turno (id, descripcion)
values (2, 'De 20 a 22');

insert into turno (id, descripcion)
values (3, 'De 22 a 00');

insert into mesa (id, capacidad, restaurante_id)
values (1, 6, 2);

insert into mesa (id, capacidad, restaurante_id)
values (2, 4, 2);

insert into mesa (id, capacidad, restaurante_id)
values (3, 6, 4);

insert into mesa (id, capacidad, restaurante_id)
values (4, 2, 5);



