# Proyecto Final: Sistema de Gestión de Biblioteca

Este repositorio contiene el proyecto final desarrollado como parte del curso de Desarrollo de Software en Java. El proyecto consiste en un Sistema de Gestión de Biblioteca que permite la administración de libros, ejemplares, lectores y préstamos.

## Funcionalidades

- **Libros:** Gestión de información detallada sobre libros, incluyendo ISBN, nombre, género, editorial, autor, estado y cantidad disponible.
- **Ejemplares:** Registro y seguimiento de ejemplares asociados a libros, con información sobre el estado y disponibilidad.
- **Lectores:** Mantenimiento de datos de lectores, incluyendo DNI, nombre, domicilio, teléfono y estado.
- **Préstamos:** Registro y administración de préstamos, con detalles sobre lector, ejemplar, fechas de préstamo y devolución, y estado del préstamo.

## Capturas de Pantalla

_Incluir aquí algunas capturas de pantalla del sistema en funcionamiento._

## Tecnologías Utilizadas

- Java
- Swing (para la interfaz gráfica)
- MariaDB (como base de datos relacional)

## Estructura del Proyecto

El proyecto está organizado en los siguientes paquetes:

- `com.biblioteca.ui`: Contiene las clases relacionadas con la interfaz de usuario.
- `com.biblioteca.data`: Contiene las clases relacionadas con el acceso a datos y la gestión de la base de datos.
- Otros paquetes: Pueden incluir utilidades, modelos, etc.

## Instrucciones de Ejecución

1. **Requisitos previos:**
   - Tener instalado Java Runtime Environment (JRE).
   - Configurar una base de datos MariaDB y actualizar la configuración de conexión en el código.

2. **Compilar el Proyecto:**
   ```bash
   javac -d bin src/com/biblioteca/*.java
