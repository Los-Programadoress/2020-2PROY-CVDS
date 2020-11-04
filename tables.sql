
CREATE TABLE IF NOT EXISTS USUARIO (
  idCorreo VARCHAR(30) NOT NULL,
  correo VARCHAR(50) UNIQUE NOT NULL,
  nombre VARCHAR(50) NOT NULL,
  estado VARCHAR(30) NOT NULL,
  contrasena VARCHAR(65) NOT NULL,
  PRIMARY KEY (idCorreo));


CREATE TABLE IF NOT EXISTS EQUIPO (
  numero INT NOT NULL DEFAULT NEXTVAL ('NumEquipo_req'),
  marca VARCHAR(50) NOT NULL,
  disponible BOOLEAN,
  usuario_idCorreo VARCHAR(30) NOT NULL,
  PRIMARY KEY (numero),
  CONSTRAINT fk_EQUIPO_USUARIO
    FOREIGN KEY (usuario_idCorreo)
      REFERENCES USUARIO (idCorreo));


CREATE TABLE IF NOT EXISTS ELEMENTO (
  id INT NOT NULL,
  tipo VARCHAR(50) NOT NULL,
  nombre VARCHAR(30) NOT NULL,
  disponible BOOLEAN,
  numEquipo INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_ELEMENTO_EQUIPO
    FOREIGN KEY (numEquipo)
      REFERENCES EQUIPO (numero));
