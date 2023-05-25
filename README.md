# Picky Cocktail

Picky Cocktail es una aplicación en desarrollo escrita en Java que utiliza Spring Data y Spring MVC para su implementación. La aplicación se centra en la gestión de cócteles y utiliza una base de datos MySQL como backend.

## Tareas Pendientes

### Capa de Persistencia
- [ ] Implementar los métodos de persistencia restantes en la capa DAO.
- [ ] Configurar correctamente la conexión a la base de datos MySQL.
- [ ] Realizar pruebas de integración de la capa de persistencia.

### Capa de Negocio
- [ ] Desarrollar las funcionalidades de búsqueda y filtrado de cócteles según las preferencias del usuario.
- [ ] Implementar la funcionalidad de creación y edición de cócteles.
- [ ] Mejorar la lógica de negocio para un mejor rendimiento y precisión.
- [ ] Realizar pruebas unitarias para garantizar la calidad y la cobertura del código.

### Capa de Presentación
- [ ] Sustituir la vista de la aplicación de escritorio Swing por un controlador en Spring MVC.
- [ ] Implementar la capa de presentación en Spring MVC para permitir la interacción con la aplicación a través de una interfaz web.
- [ ] Mejorar la interfaz de usuario para una experiencia más intuitiva y atractiva.
- [ ] Asegurar la integración correcta de la capa de presentación con las demás capas.

## Arquitectura

Picky Cocktail sigue una arquitectura DAO (Data Access Object) y MVC (Model-View-Controller).

- La capa de persistencia utiliza Spring Data JPA (versión 2.7.0) para interactuar con la base de datos MySQL.
- La capa de presentación está siendo migrada de una aplicación de escritorio Swing a un controlador en Spring MVC.
- La capa de negocio se basa en los DAOs implementados y utiliza los servicios de Spring para la gestión de transacciones.

## Requisitos de Colaboración

Para colaborar en el proyecto, asegúrate de tener instalados los siguientes componentes y bibliotecas:

- Java JDK 8 o superior
- Maven
- MySQL
- IDE de desarrollo (por ejemplo, IntelliJ IDEA, Eclipse)

### Dependencias del Proyecto

- Spring Web MVC (versión 5.3.27)
- Spring Data JPA (versión 2.7.0)
- JSTL (versión 1.2)
- MySQL Connector (versión 8.0.32)
- JUnit Jupiter (versión 5.8.2)
- Hibernate Core (versión 5.6.15.Final)
- Gson (versión 2.10.1)
