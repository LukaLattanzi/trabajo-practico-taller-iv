# Trabajo Práctico: Mapeo ORM - Spring Boot + JPA

## Descripción

Este proyecto es una implementación de un sistema hospitalario utilizando **Spring Boot**, **JPA/Hibernate** y **Thymeleaf**. El objetivo es mapear un modelo de base de datos relacional a entidades Java (ORM), exponer endpoints REST y mostrar los datos en un dashboard web.

Incluye:

- Mapeo de entidades y relaciones (herencia, colecciones, embebidos, enums).
- Repositorios, servicios y controladores REST para CRUD completo.
- Dashboard web con **Thymeleaf** y **Bootstrap** mostrando todas las tablas (principales y de colecciones).
- Scripts SQL para poblar la base de datos.

---

## Estructura del Proyecto

- `/src/main/java/com/talleriv/backend/models` — Entidades JPA (Hospital, Department, Staff, Patient, etc.)
- `/src/main/java/com/talleriv/backend/repository` — Repositorios JPA
- `/src/main/java/com/talleriv/backend/service` — Servicios con lógica de negocio
- `/src/main/java/com/talleriv/backend/controller` — Controladores REST y de vistas
- `/src/main/resources/templates/dashboard.html` — Dashboard web
- `/docs/inserts_sql.sql` — Script SQL de ejemplo para poblar la base de datos

---

## Requisitos

- Java 17 o superior (el proyecto usa Java 24, ajusta si es necesario)
- Maven
- MySQL

---

## Instalación y Ejecución

1. **Clona el repositorio**

   ```bash
   git clone <url-del-repo>
   cd backend
   ```

2. **Configura la base de datos**

   - Crea la base de datos y carga los datos de ejemplo:
     ```sql
     -- En tu cliente MySQL:
     SOURCE docs/inserts_sql.sql;
     ```
   - Ajusta el archivo `src/main/resources/application.properties` con tu usuario y contraseña de MySQL.

3. **Compila y ejecuta la aplicación**

   ```bash
   mvn spring-boot:run
   ```

4. **Accede al dashboard**
   - Abre [http://localhost:8081/dashboard](http://localhost:8081/dashboard) en tu navegador.

---

## Funcionalidades

- **CRUD REST** para todas las entidades principales.
- **Dashboard web** que muestra:
  - Departamentos
  - Hospitales
  - Pacientes
  - Staff
  - Staff Education, Certification, Languages
  - Patient Prescriptions, Allergies, Special Requirements

---

## Personalización

- Puedes modificar los inserts SQL para agregar más datos de prueba.
- El dashboard puede ampliarse para agregar, editar o eliminar registros desde la web.
- Si quieres desactivar la seguridad, ajusta o comenta las líneas de Spring Security en `application.properties`.

---

## Notas Técnicas

- El mapeo de herencia usa `@Inheritance(strategy = InheritanceType.JOINED)`.
- Las colecciones (`List<String>`) se almacenan en tablas separadas mediante `@ElementCollection`.
- Las relaciones entre entidades están normalizadas y siguen buenas prácticas ORM.
- El dashboard usa Bootstrap para una visualización clara y moderna.

---
