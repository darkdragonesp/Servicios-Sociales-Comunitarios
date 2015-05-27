-- Datos de UTS
INSERT INTO SSC.UTS VALUES (1, 'Sur', 'El Palo', 'Malaga');
INSERT INTO SSC.UTS VALUES (2, 'Norte', 'Teatinos', 'Malaga');
INSERT INTO SSC.UTS VALUES (3, 'Centro', 'Antequera', 'Malaga');

-- Datos de expedientes
INSERT INTO SSC.EXPEDIENTE VALUES (12345678, 'Abierto', '2015-05-24', NULL, NULL, 1);
INSERT INTO SSC.EXPEDIENTE VALUES (22245563, 'Abierto', '2015-05-24', NULL, NULL, 2);
INSERT INTO SSC.EXPEDIENTE VALUES (22241234, 'cerrado', '2015-05-20', '2015-05-24', NULL, 2);

-- Datos de personas
INSERT INTO SSC.PERSONA VALUES ('11111111H', 'Tomas', 'Turbado', 'Calle Nueva', 'a@mail.com', 'Soltero', '1/1/1990', 'Malaga', 'Espana', 'Lucia', 'M', 666666666);
INSERT INTO SSC.PERSONA VALUES ('22222222J', 'Tomas', 'Turbado', 'Calle Nueva', 'a@mail.com', 'Soltero', '1/1/1990', 'Malaga', 'Espana', 'Carlos', 'H', 666666666);
INSERT INTO SSC.PERSONA VALUES ('33333333P', 'Tomas', 'Turbado', 'Calle Nueva', 'a@mail.com', 'Soltero', '1/1/1990', 'Malaga', 'Espana', 'Juan', 'H', 666666666);
INSERT INTO SSC.PERSONA VALUES ('12345678A', 'Tomas', 'Turbado', 'Calle Nueva', 'a@mail.com', 'Soltero', '1/1/1990', 'Malaga', 'Espana', 'Ana', 'M', 666666666);
INSERT INTO SSC.PERSONA VALUES ('11112222B', 'Tomas', 'Turbado', 'Calle Nueva', 'a@mail.com', 'Soltero', '1/1/1990', 'Malaga', 'Espana', 'Eustaquio', 'H', 666666666);

-- Datos de usuarios
INSERT INTO SSC.USUARIO VALUES ('11111111H', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 'Profesional', 1);
INSERT INTO SSC.USUARIO VALUES ('22222222J', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 'Auxiliar administrativo', 2);
INSERT INTO SSC.USUARIO VALUES ('33333333P', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 'Tecnico Superior', 3);

-- Datos de ciudadanos
INSERT INTO SSC.CIUDADANO VALUES ('12345678A', 12345678);
INSERT INTO SSC.CIUDADANO VALUES ('11112222B', 22245563);
INSERT INTO SSC.CIUDADANO VALUES ('11111111H', 22245563);

-- Datos de relaciones de parentesco
INSERT INTO SSC.PARENTESCO VALUES ('Hermanos', '11112222B', '11111111H');

-- Datos de actividades
INSERT INTO SSC.ACTIVIDAD VALUES ('1', 'Trabajo supervision', '2015-05-24', '24:00', 'Malaga', '33333333P');
INSERT INTO SSC.ACTIVIDAD VALUES ('2', 'Descanso', '2015-05-27', '24:00', 'Malaga', '22222222J');
INSERT INTO SSC.ACTIVIDAD VALUES ('3', 'Visita a paciente', '2015-05-26', '24:00', 'Malaga', '11111111H');

-- Datos de intervenciones
INSERT INTO SSC.INTERVENCION VALUES (0, NULL, NULL, '2015-05-25', 'hola pepito | adios pepito', NULL, NULL, 'Discapacidad', 'Muy buena', 12345678, '3');

-- Asignar permisos de acceso a expedientes
INSERT INTO SSC.ACCESO_EXPEDIENTES VALUES (12345678, '11111111H');
INSERT INTO SSC.ACCESO_EXPEDIENTES VALUES (22245563, '11111111H');
INSERT INTO SSC.ACCESO_EXPEDIENTES VALUES (22245563, '22222222J');
INSERT INTO SSC.ACCESO_EXPEDIENTES VALUES (12345678, '33333333P');
