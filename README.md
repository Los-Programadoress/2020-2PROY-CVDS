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
<!DOCTYPE html>
<html>
    <head></head>
    <body>
        <img src="https://github.com/Los-Programadoress/2020-2PROY-CVDS/blob/main/img/ERModel.png" alt="ER" width="700"/>
    </body>
</html>

#### Diagrama de clases
<!DOCTYPE html>
<html>
    <head></head>
    <body>
        <img src="https://github.com/Los-Programadoress/2020-2PROY-CVDS/blob/main/img/DiagramaClases.png" alt="ER" width="700"/>
    </body>
</html>

#### Stack de tecnologías utilizado (capas)

#### Capa de presentación
+  Primefaces

#### Capa de aplicación
+  Java
+  Google Guice  (*Inyección de dependencias*)
+  Maven (*Gestión de dependencias*)
+  Apache Shiro (*Autenticación*)

#### Capa de persistencia de datos
+ PostgreSQL (*Motor de bases de datos*)
+ myBatis (*mappeo de sentencias SQL*)

#### 📎Enlace a la aplicación en Heroku: [Aplicación Historial de Equipos](https://historialdeequipo.herokuapp.com)
#### ⭕ Enlace al sistema de integración continua: [![CircleCI](https://circleci.com/gh/Los-Programadoress/2020-2PROY-CVDS.svg?style=svg)](https://circleci.com/gh/Los-Programadoress/2020-2PROY-CVDS)
#### Enlace al análisis de código en Codacy: 

### 📋 Descripción del proceso
#### Descripción de la Metodología.
La aplicación se desarrolló mediante la metodología ágil Scrum. Se realizaron por cada sprint las ceremonias de la metodología: sprint planning, daily scrum y sprint review en un periodo de 2 semanas, en compañia del product owner.
#### Enlace a Taiga. [Taiga](https://tree.taiga.io/project/cesar-ortiz-historial-de-equipos-labinfo/backlog)
#### Release-burndown chart del proyecto 
#### 📈Sprint 1  [Burndown chart](https://tree.taiga.io/project/cesar-ortiz-historial-de-equipos-labinfo/taskboard/sprint-1-14429)
**sprint-backlog**  

<!DOCTYPE html>
<html>
    <head></head>
    <body>
        <img src="https://github.com/Los-Programadoress/2020-2PROY-CVDS/blob/main/img/BacklogSprint1.png" alt="ER" width="800"/>
    </body>
</html>

Al principio del sprint se presentaron inconvenientes con el manejo de Shiro, pero para el final del Sprint se superó de manera satisfactoria el inconveniente. En general fue un sprint de reconocimiento y organización y a pesar de ello se desarrollaron parte de las funcionalidades base del proyecto.
#### 📈Sprint 2  [Burndown chart](https://tree.taiga.io/project/cesar-ortiz-historial-de-equipos-labinfo/taskboard/sprint-2-7725)
**sprint-backlog**  

En general fue un sprint de completitud de las funcionalidades base, con colaboración del equipo y el profesor se mejoraron estrategias de las mismas y realizaron pruebas de lo desarrollado hasta el momento.

#### 📈Sprint 3  [Burndown chart](https://tree.taiga.io/project/cesar-ortiz-historial-de-equipos-labinfo/taskboard/sprint-3-5033)
**sprint-backlog**  

Finalmente el último sprint fue de completitud de funcionalidades del proyecto, solucionando bugs del Sprint 2, mejorando experiencia de usuario, y organizando detalles para finalizar con éxito la entrega presente.

#### Reporte de Pruebas

#### Reporte de de Análisis estático de código
