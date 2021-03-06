CREATE TABLE IF NOT EXISTS USUARIO (
  idCorreo VARCHAR(30) NOT NULL,
  correo VARCHAR(50) UNIQUE NOT NULL,
  nombre VARCHAR(50) NOT NULL,
  estado VARCHAR(30) NOT NULL,
  contrasena VARCHAR(65) NOT NULL,
  PRIMARY KEY (idCorreo));
  
create sequence NumEquipo_req;

CREATE TABLE IF NOT EXISTS LABORATORIO (
  nombre VARCHAR(50) NOT NULL,
  usuario_idCorreo VARCHAR(30) NOT NULL,
  estaCerrado BOOLEAN default false,
  fechaCreacion DATE ,
  fechaFin DATE,
  PRIMARY KEY (nombre),
  CONSTRAINT fk_LABORATORIO_USUARIO
    FOREIGN KEY (usuario_idCorreo)
      REFERENCES USUARIO (idCorreo));
     
CREATE TABLE IF NOT EXISTS EQUIPO (
  numero INT NOT NULL DEFAULT NEXTVAL ('NumEquipo_req'),
  nombre VARCHAR(50) UNIQUE NOT NULL,
  marca VARCHAR(50) NOT NULL,
  disponible BOOLEAN NOT null default true,
  usuario_idCorreo VARCHAR(30) NOT NULL,
  nombreLab VARCHAR(50),
  dadoDeBaja BOOLEAN default false,
  PRIMARY KEY (numero),
  CONSTRAINT fk_EQUIPO_USUARIO
    FOREIGN KEY (usuario_idCorreo)
      REFERENCES USUARIO (idCorreo),
  CONSTRAINT fk_EQUIPO_LABORATORIO
    FOREIGN KEY (nombreLab)
      REFERENCES LABORATORIO (nombre));

create sequence NumElemento_req;
      
CREATE TABLE IF NOT EXISTS ELEMENTO (
  id INT NOT NULL DEFAULT NEXTVAL ('NumElemento_req'),
  tipo VARCHAR(50) NOT NULL,
  nombre VARCHAR(50) UNIQUE NOT NULL,
  disponible BOOLEAN NOT null default true,
  numEquipo INT,
  dadoDeBaja BOOLEAN default false,
  PRIMARY KEY (id),
  CONSTRAINT fk_ELEMENTO_EQUIPO
    FOREIGN KEY (numEquipo)
      REFERENCES EQUIPO (numero));
      
create sequence NumNovedad_req;
      
CREATE TABLE IF NOT EXISTS NOVEDAD (
  id INT NOT NULL DEFAULT NEXTVAL ('NumNovedad_req'),
  titulo VARCHAR(80) NOT NULL,
  fecha DATE NOT NULL,
  responsable VARCHAR(30) NOT NULL,
  detalle VARCHAR(100) NOT NULL,
  nombreEq VARCHAR(50),
  nombreElem VARCHAR(50),
  nombreLab VARCHAR(50),
  PRIMARY KEY (id),
  CONSTRAINT fk_NOVEDAD_EQUIPO
    FOREIGN KEY (nombreEq)
      REFERENCES EQUIPO (nombre),
  CONSTRAINT fk_NOVEDAD_ELEMENTO
    FOREIGN KEY (nombreElem)
      REFERENCES ELEMENTO (nombre),
  CONSTRAINT fk_NOVEDAD_LABORATORIO
    FOREIGN KEY (nombreLab)
      REFERENCES LABORATORIO (nombre));