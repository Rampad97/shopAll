# 🎬 ShopAll API - Skill Challenge 4

Proyecto que forma ste proyecto fue desarrollado como parte del **Plan de Capacitación y Entrenamiento Booster** en el curso de **Desarrollo Java Backend Junior**

---

## 📌 Contenido

- [Descripción](#-descripción)
- [Objetivo del reto](#-objetivo-del-reto)
- [Tecnologías utilizafas](#-tecnologías-utilizadas)
- [Instalación](#-instalación)
- [Configuración de Base de Datos](#-configuración-de-base-de-datos)
- [Funcionalidades](#-funcionalidades)
- [Validaciones y Manejo Global de Errores](#-validaciones-y-manejo-global-de-errores)
  - [Validaciones](#-validaciones)
  - [Manejo Global de Errores](#-manejo-global-de-errores)
- [Endpoints](#-endpoints)
- [Pruebas](#-pruebas)
- [Estructura del Proyecto](#-estructura-del-proyecto)
- [Autor](#-autor)

---

## 📚 Descripción

API RESTful que permite gestionar un catálogo de películas usando Spring Boot, con enfoque en buenas prácticas como validación de datos, manejo de excepciones y diseño en capas (controller, service, repository).

---

## 🧩 Objetivo del reto
El objetivo de este desafío fue mejorar el sistema desarrollado anteriormente, integrando:

* Validaciones sobre los datos de entrada
* Manejo adecuado de errores de validación
* Excepciones personalizadas
* Manejador global de errores para toda la API

---

## ⚙️ Tecnologías utilizadas

* Java 17+
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate Validator (Jakarta Validation)
* MySQL

---

## 🛠 Instalación

1. Clona el proyecto:

```bash
git clone https://github.com/Rampad97/shopAll.git
````

2. Abre en tu IDE favorito (IntelliJ, Eclipse, VS Code)

3. Asegúrate de tener MySQL corriendo

4. Crea la base de datos:

```sql
CREATE DATABASE shopall_db;
```

5. Ejecuta `ShopAllApplication.java`

---

## 🔌 Configuración de Base de Datos

Modifica `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost/shopall_db
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
hibernate.dialect=org.hibernate.dialect.MySQLDialect
logging.level.org.hibernate.SQL=debug
spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
```

---

## 🚀 Funcionalidades

- Obtener todas las películas
- Listar solo disponibles / no disponibles
- Agregar nuevas películas con validación
- Eliminar por ID
- Marcar como disponible

---
## 🛡️ Validaciones y Manejo Global de Errores

### ✅ Validaciones

Se aplican anotaciones como `@NotBlank` y `@Size`. Si el dato es inválido, se devuelve un error 400 con mensajes claros.

### ⚠️ Manejo Global de Errores

Mediante `@ControllerAdvice` se captura:
* Errores de validación (`MethodArgumentNotValidException`) - Error 400
* Excepciones personalizadas (`PeliculaNotFoundException`) - Error 404
* Excepciones generales (`Exception`) - Error 500

## 📬 Endpoints

| Método | Endpoint                       | Descripción                                      |
| ------ | ------------------------------ | ------------------------------------------------ |
| GET    | `/api/shopall/peliculas`       | Listar todas las películas                       |
| GET    | `/api/shopall/disponibles`     | Listar solo películas disponibles                |
| GET    | `/api/shopall/no-disponibles`  | Listar películas no disponibles                  |
| POST   | `/api/shopall`                 | Agregar una nueva película (validación aplicada) |
| DELETE | `/api/shopall/{id}`            | Eliminar una película por ID                     |
| PUT    | `/api/shopall/{id}/disponible` | Marcar una película como disponible              |

## 🧪 Pruebas

Usa Postman o curl para probar los endpoints.

---

## 📁 Estructura del Proyecto

```
com.metaphorce.shopAll
│
├── controllers       # Endpoints REST
├── entidades         # Clases JPA
├── exceptions        # Excepciones y manejo global
├── repositories      # JpaRepository
├── services          # Lógica de negocio
└── ShopAllApplication.java
```

---

## 👤 Autor

**Fernanda Ramírez**

Curso: *Desarrollo Java Backend Junior*

Programa: *Booster de Capacitación*

Plataforma: Metaphorce

---