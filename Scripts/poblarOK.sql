INSERT INTO usuario VALUES('maria.alfaro','maria.alfaro@mail.escuelaing.edu.co', 'Angelica Alfaro','Activo','44f632480c49db38c4d0cbc2bea2384049c74a689baf5bf576163455787185a3');
INSERT INTO usuario VALUES('laura.izquierdo','laura.izquierdo@mail.escuelaing.edu.co','Laura Izquierdo','Activo','899f4ea4f605ced480d6f70712ec335ea4ff2a71493f0ce5e58cbee2f68ec6dd');
INSERT INTO usuario VALUES('cesar.ortiz','cesar.ortiz@mail.escuelaing.edu.co','Cesar Ortiz','Activo','fd40bd1f4708532654678711dd956a1ee3fe51419521b0b6ea0ee0597cd5f75e');
INSERT INTO usuario VALUES('julian.velasco','julian.velasco-b@escuelaing.edu.co', 'Julian Velasco','Activo','aa3bf762374446a04335e72f2d075cfc414ebe7fb7ad9bcd9c9704a775f965e0');
INSERT INTO usuario VALUES('pedro.gutierrez','pedro.gutierrez@mail.escuelaing.edu.co','Pedro Gutierrez','Inactivo','bba44acd2f6fac34bd6ed2cbd9bc07d0e78db88679287e142e70b2730677144e');

INSERT INTO equipo (marca, disponible, usuario_idcorreo) VALUES ('DELL', true, 'maria.alfaro');

INSERT INTO elemento (tipo, nombre, disponible) VALUES ('Torre', 'V530 AIO', true);
INSERT INTO elemento (tipo, nombre, disponible) VALUES ('Torre', 'E-ATX', true);
INSERT INTO elemento (tipo, nombre, disponible) VALUES ('Mouse', 'Vertical Inalámbrico', true);
INSERT INTO elemento (tipo, nombre, disponible) VALUES ('Mouse', 'Multitáctil', true);
INSERT INTO elemento (tipo, nombre, disponible) VALUES ('Mouse', 'Óptico', true);
INSERT INTO elemento (tipo, nombre, disponible, numequipo) VALUES ('Pantalla', 'LED', false,1);
INSERT INTO elemento (tipo, nombre, disponible, numequipo) VALUES ('Pantalla', 'LCD', false,1);
INSERT INTO elemento (tipo, nombre, disponible, numequipo) VALUES ('Teclado', 'Flexible', false,1);
INSERT INTO elemento (tipo, nombre, disponible, numequipo) VALUES ('Teclado', 'Gamer', false,1);
