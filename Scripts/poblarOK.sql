INSERT INTO usuario VALUES('maria.alfaro','maria.alfaro@mail.escuelaing.edu.co', 'Angelica Alfaro','Activo','44f632480c49db38c4d0cbc2bea2384049c74a689baf5bf576163455787185a3');
INSERT INTO usuario VALUES('laura.izquierdo','laura.izquierdo@mail.escuelaing.edu.co','Laura Izquierdo','Activo','899f4ea4f605ced480d6f70712ec335ea4ff2a71493f0ce5e58cbee2f68ec6dd');
INSERT INTO usuario VALUES('cesar.ortiz','cesar.ortiz@mail.escuelaing.edu.co','Cesar Ortiz','Activo','fd40bd1f4708532654678711dd956a1ee3fe51419521b0b6ea0ee0597cd5f75e');
INSERT INTO usuario VALUES('julian.velasco','julian.velasco-b@escuelaing.edu.co', 'Julian Velasco','Activo','aa3bf762374446a04335e72f2d075cfc414ebe7fb7ad9bcd9c9704a775f965e0');
INSERT INTO usuario VALUES('pedro.gutierrez','pedro.gutierrez@mail.escuelaing.edu.co','Pedro Gutierrez','Inactivo','bba44acd2f6fac34bd6ed2cbd9bc07d0e78db88679287e142e70b2730677144e');

INSERT INTO laboratorio (nombre , usuario_idcorreo) VALUES ('REDES','maria.alfaro');
INSERT INTO laboratorio (nombre , usuario_idcorreo) VALUES ('PLATAFORMAS','cesar.ortiz');

INSERT INTO equipo (nombre, marca, disponible, usuario_idcorreo, nombrelab, dadodebaja) VALUES ('SISTEMAS1','DELL', true, 'maria.alfaro', 'REDES', false);

INSERT INTO elemento (tipo, nombre, disponible, dadodebaja) VALUES ('Torre', 'V530 AIO', true, false);
INSERT INTO elemento (tipo, nombre, disponible, dadodebaja) VALUES ('Torre', 'E-ATX', true, false);
INSERT INTO elemento (tipo, nombre, disponible, dadodebaja) VALUES ('Mouse', 'Vertical Inalámbrico', true, false);
INSERT INTO elemento (tipo, nombre, disponible, dadodebaja) VALUES ('Mouse', 'Multitáctil', true, false);
INSERT INTO elemento (tipo, nombre, disponible, dadodebaja) VALUES ('Mouse', 'Óptico', true, false);
INSERT INTO elemento (tipo, nombre, disponible, dadodebaja) VALUES ('Teclado', 'Gamer', true, false);
INSERT INTO elemento (tipo, nombre, disponible, dadodebaja) VALUES ('Pantalla', 'LCD', true, false);
INSERT INTO elemento (tipo, nombre, disponible, numequipo, dadodebaja) VALUES ('Pantalla', 'LED', false,1, false);
INSERT INTO elemento (tipo, nombre, disponible, numequipo, dadodebaja) VALUES ('Torre', 'FEX', false,1, false);
INSERT INTO elemento (tipo, nombre, disponible, numequipo, dadodebaja) VALUES ('Teclado', 'Flexible', false,1, false);
INSERT INTO elemento (tipo, nombre, disponible, numequipo, dadodebaja) VALUES ('Mouse', 'Gamer+', false,1, false);

INSERT INTO Novedad (titulo, fecha, responsable , detalle, nombreEq) VALUES ('Cambio de equipo', TO_DATE('2020/11/17','yyyy/mm/dd'), 'cesar.ortiz','Se presenta un asunto de cambio por daños en el actual', 'SISTEMAS1');
INSERT INTO Novedad (titulo, fecha, responsable , detalle, nombreElem) VALUES ('Cambio de elemento', TO_DATE('2020/11/17','yyyy/mm/dd'), 'cesar.ortiz','Se presenta un asunto de cambio por daños en el actual', 'V530 AIO');
INSERT INTO Novedad (titulo, fecha, responsable , detalle, nombrelab ) VALUES ('Cambio de laboratorio', TO_DATE('2020/11/17','yyyy/mm/dd'), 'cesar.ortiz','Se presenta un asunto de cambio por capacidad','REDES');

