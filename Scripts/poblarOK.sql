INSERT INTO usuario VALUES('maria.alfaro','maria.alfaro@mail.escuelaing.edu.co', 'Angelica Alfaro','Activo','44f632480c49db38c4d0cbc2bea2384049c74a689baf5bf576163455787185a3');
INSERT INTO usuario VALUES('laura.izquierdo','laura.izquierdo@mail.escuelaing.edu.co','Laura Izquierdo','Activo','899f4ea4f605ced480d6f70712ec335ea4ff2a71493f0ce5e58cbee2f68ec6dd');
INSERT INTO usuario VALUES('cesar.ortiz','cesar.ortiz@mail.escuelaing.edu.co','Cesar Ortiz','Activo','fd40bd1f4708532654678711dd956a1ee3fe51419521b0b6ea0ee0597cd5f75e');
INSERT INTO usuario VALUES('julian.velasco','julian.velasco-b@escuelaing.edu.co', 'Julian Velasco','Activo','aa3bf762374446a04335e72f2d075cfc414ebe7fb7ad9bcd9c9704a775f965e0');
INSERT INTO usuario VALUES('pedro.gutierrez','pedro.gutierrez@mail.escuelaing.edu.co','Pedro Gutierrez','Inactivo','bba44acd2f6fac34bd6ed2cbd9bc07d0e78db88679287e142e70b2730677144e');

INSERT INTO laboratorio (nombre , usuario_idcorreo, fechaCreacion, fechaFin) VALUES ('REDES','maria.alfaro',TO_DATE('2020/11/17','yyyy/mm/dd'), TO_DATE('2020/12/17','yyyy/mm/dd'));
INSERT INTO laboratorio (nombre , usuario_idcorreo, fechaCreacion) VALUES ('PLATAFORMAS','cesar.ortiz', TO_DATE('2020/11/17','yyyy/mm/dd'));

INSERT INTO equipo (nombre, marca, usuario_idcorreo, nombrelab) VALUES ('SISTEMAS1','DELL','maria.alfaro', 'REDES');

INSERT INTO elemento (tipo, nombre) VALUES ('Torre', 'V530 AIO');
INSERT INTO elemento (tipo, nombre) VALUES ('Torre', 'E-ATX');
INSERT INTO elemento (tipo, nombre) VALUES ('Mouse', 'Vertical Inalámbrico');
INSERT INTO elemento (tipo, nombre) VALUES ('Mouse', 'Multitáctil');
INSERT INTO elemento (tipo, nombre) VALUES ('Mouse', 'Óptico');
INSERT INTO elemento (tipo, nombre) VALUES ('Teclado', 'Gamer');
INSERT INTO elemento (tipo, nombre) VALUES ('Pantalla', 'LCD');
INSERT INTO elemento (tipo, nombre, disponible, numequipo) VALUES ('Pantalla', 'LED', false, 1);
INSERT INTO elemento (tipo, nombre, disponible, numequipo) VALUES ('Torre', 'FEX', false, 1);
INSERT INTO elemento (tipo, nombre, disponible, numequipo) VALUES ('Teclado', 'Flexible', false, 1);
INSERT INTO elemento (tipo, nombre, disponible, numequipo) VALUES ('Mouse', 'Inalámbrico', false, 1);
INSERT INTO elemento (tipo, nombre) VALUES ('Mouse', 'Laser');
INSERT INTO elemento (tipo, nombre) VALUES ('Pantalla', 'Multi-touch');
INSERT INTO elemento (tipo, nombre) VALUES ('Teclado', 'Ergonómico');

INSERT INTO Novedad (titulo, fecha, responsable , detalle, nombrelab) VALUES ('Registro de laboratorio', TO_DATE('2020/11/17','yyyy/mm/dd'), 'laura.izquierdo','Se registró el laboratorio REDES', 'REDES');
INSERT INTO Novedad (titulo, fecha, responsable , detalle, nombrelab) VALUES ('Registro de laboratorio', TO_DATE('2020/11/17','yyyy/mm/dd'), 'cesar.ortiz','Se registró el laboratorio PLATAFORMAS', 'PLATAFORMAS');
INSERT INTO Novedad (titulo, fecha, responsable , detalle, nombreeq) VALUES ('Registro de equipo', TO_DATE('2020/11/18','yyyy/mm/dd'), 'cesar.ortiz','Se registró el equipo SISTEMAS1','SISTEMAS1');
INSERT INTO Novedad (titulo, fecha, responsable , detalle, nombreelem) VALUES ('Registro de Elemento', TO_DATE('2020/11/18','yyyy/mm/dd'), 'cesar.ortiz','Se registró una Torre V530 AIO','V530 AIO');
INSERT INTO Novedad (titulo, fecha, responsable , detalle, nombreelem) VALUES ('Registro de Elemento', TO_DATE('2020/11/18','yyyy/mm/dd'), 'maria.alfaro','Se registró un Torre E-ATX','E-ATX');
INSERT INTO Novedad (titulo, fecha, responsable , detalle, nombreelem) VALUES ('Registro de Elemento', TO_DATE('2020/11/18','yyyy/mm/dd'), 'cesar.ortiz','Se registró un Mouse Vertical Inalámbrico','Vertical Inalámbrico');
INSERT INTO Novedad (titulo, fecha, responsable , detalle, nombreelem) VALUES ('Registro de Elemento', TO_DATE('2020/11/19','yyyy/mm/dd'), 'maria.alfaro','Se registró un Mouse Multitáctil','Multitáctil');
INSERT INTO Novedad (titulo, fecha, responsable , detalle, nombreelem) VALUES ('Registro de Elemento', TO_DATE('2020/11/19','yyyy/mm/dd'), 'laura.izquierdo','Se registró un Teclado Gamer','Gamer');
INSERT INTO Novedad (titulo, fecha, responsable , detalle, nombreelem) VALUES ('Registro de Elemento', TO_DATE('2020/11/19','yyyy/mm/dd'), 'maria.alfaro','Se registró una Pantalla LCD','LCD');
INSERT INTO Novedad (titulo, fecha, responsable , detalle, nombreelem) VALUES ('Registro de Elemento', TO_DATE('2020/11/19','yyyy/mm/dd'), 'laura.izquierdo','Se registró un Mouse Óptico','Óptico');
INSERT INTO Novedad (titulo, fecha, responsable , detalle, nombreelem) VALUES ('Registro de Elemento', TO_DATE('2020/11/19','yyyy/mm/dd'), 'laura.izquierdo','Se registró un Mouse Laser','Laser');
INSERT INTO Novedad (titulo, fecha, responsable , detalle, nombreelem) VALUES ('Registro de Elemento', TO_DATE('2020/11/19','yyyy/mm/dd'), 'maria.alfaro','Se registró una Pantalla Multi-touch','Multi-touch');
INSERT INTO Novedad (titulo, fecha, responsable , detalle, nombreelem) VALUES ('Registro de Elemento', TO_DATE('2020/11/19','yyyy/mm/dd'), 'laura.izquierdo','Se registró un Teclado Ergonómico','Ergonómico');

INSERT INTO Novedad (titulo, fecha, responsable , detalle, nombreeq, nombreelem) VALUES ('Asociación de elemento a equipo', TO_DATE('2020/11/20','yyyy/mm/dd'), 'cesar.ortiz','Se asoció el elemento LED al equipo SISTEMAS1','SISTEMAS1','LED');
INSERT INTO Novedad (titulo, fecha, responsable , detalle, nombreeq, nombreelem) VALUES ('Asociación de elemento a equipo', TO_DATE('2020/11/20','yyyy/mm/dd'), 'cesar.ortiz','Se asoció el elemento FEX al equipo SISTEMAS1','SISTEMAS1','FEX');
INSERT INTO Novedad (titulo, fecha, responsable , detalle, nombreeq, nombreelem) VALUES ('Asociación de elemento a equipo', TO_DATE('2020/11/20','yyyy/mm/dd'), 'cesar.ortiz','Se asoció el elemento Flexible al equipo SISTEMAS1','SISTEMAS1','Flexible');
INSERT INTO Novedad (titulo, fecha, responsable , detalle, nombreeq, nombreelem) VALUES ('Asociación de elemento a equipo', TO_DATE('2020/11/20','yyyy/mm/dd'), 'cesar.ortiz','Se asoció el elemento Gamer al equipo SISTEMAS1','SISTEMAS1','Gamer');
