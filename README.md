# Escuela Colombiana de Ingeniería Julio Garavito 
# Proyecto Final CVDS 2020-2

## 📍 HISTORIAL DE EQUIPOS

#### Product Owner 💥 
> - Julián Mauricio Velasco Briceño

#### Team 👤👤👤
> - María Angélica Alfaro Fandiño (Design)
> - César Fernando Ortiz Rocha (Front)
> - Laura Alejandra Izquierdo Castro (Back)

### 🔎 Descripción del producto 
**Descripción general:** La Plataforma Historial de Equipo, es una herramienta donde el personal administrativo del laboratorio de informática (LabInfo) pertenecientes a la decanatura de Ingeniería de Sistemas podrán hacer el registro y seguimiento de las novedades que han sido realizadas sobre los equipos de cómputo pertenecientes al Laboratorio de Informática. 

El sistema, más allá de facilitar el registro de los equipos y novedades, es una valiosa base de conocimiento donde el personal del laboratorio, puede revisar el histórico de novedades que se le han realizado a cada elemento a través del tiempo durante todo su ciclo de vida útil. 

#### Manual de usuario
#### Funcionalidades más importantes

### 📜 Arquitectura y Diseño detallado

#### Modelo E-R
![ER](https://github.com/Los-Programadoress/2020-2PROY-CVDS/blob/main/img/ERModel.png)
#### Diagrama de clases
![MODELO DE DATOS](https://github.com/Los-Programadoress/2020-2PROY-CVDS/blob/main/img/DiagramaClases.png)

#### Stack de tecnologías utilizado (capas)

#### Capa de presentación
+  Primefaces

#### Capa de aplicación
+  Java
+  Google Guice  (*Inyección de dependencias*)
+  Maven (*Gestión de dependencias*)
+  Apache Shiro (*Autenticación*)

#### Capa de persistencia de datos
+ PostgreSQL (Motor de bases de datos)
+ myBatis (mappea sentencias SQL)

#### 📎Enlace a la aplicación en Heroku: [Aplicación Historial de Equipos](https://historialdeequipo.herokuapp.com)
#### ⭕ Enlace al sistema de integración continua: [![CircleCI](https://circleci.com/gh/Los-Programadoress/2020-2PROY-CVDS.svg?style=svg)](https://circleci.com/gh/Los-Programadoress/2020-2PROY-CVDS)



