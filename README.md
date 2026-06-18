# currency-converter-api
prueba técnica - API conversión de divisas usando Spring Boot

# Sistema de Gestión de Divisas

Este proyecto es una aplicación web desarrollada con **Spring Boot (backend)** y **React (frontend)** que permite gestionar divisas mediante operaciones CRUD (Crear, Leer, Actualizar y Eliminar). Además, la API está documentada con Swagger.


## Arquitectura del sistema

El sistema está dividido en dos repositorios independientes:

- Backend: Spring Boot (API REST)
- Frontend: React (Vite)


## Tecnologías utilizadas

### Backend:
- Java 17+
- Spring Boot
- Spring Data JPA
- Hibernate
- H2
- Swagger
- Maven

### Frontend:
- React (Vite)
- JavaScript (ES6+)
- Fetch API
- CSS3 (Responsive Design)


## Funcionalidades

### Backend (API REST)
- Crear divisa
- Listar divisas
- Actualizar divisa
- Eliminar divisa
- Documentación con Swagger

### Frontend
- Visualización de divisas
- Crear nuevas divisas
- Editar divisas existentes
- Eliminar divisas
- Búsqueda de divisas
- Interfaz responsive
- Validaciones y manejo de errores
- Mensajes de éxito y error


## Estructura del proyecto

### Backend

backend/
├── config/
├── controller/
├── dto/
├── entity/
├── exception/
├── mapper/
├── repository/
├── service/


### Frontend

frontend-divisas-react/
├── src/
│ ├── services/
│ ├── App.css
│ ├── App.jsx
│ ├── main.jsx
│ └── styles.css


## Instalación y ejecución

### Backend (Spring Boot)

1. Clonar el repositorio:
Bash: git clone https://github.com/dcrob92/currency-converter-api

2. Ejecutar el proyecto:
Bash: mvn spring-boot:run

3. Acceder a la API: http://localhost:8080/api/currencies

4. Swagger: http://localhost:8080/swagger-ui/index.html


### Frontend(React)

1. Clonar el repositorio
Bash: git clone https://github.com/dcrob92/frontend-divisas-react

2. Instalar dependencias
Bash: npm install

3. Ejecutar el proyecto
Bash: npm run dev

4. acceder a la aplicacion: http://localhost:5173


# Comunicación entre frontend y backend

El frontend consume la API REST del backend mediante fetch: http://localhost:8080/api/currencies

**Importante: El backend debe tener habilitado CORS para permitir solicitudes desde el frontend.**


## Validaciones implementadas

- Campos obligatorios en formulario
- Validación de tipo numérico en valor
- Manejo de errores en peticiones HTTP
- Mensajes de éxito y error en la interfaz

## Diseño UI

- Diseño tipo dashboard moderno
- Layout responsive (móvil y escritorio)
- Tarjetas para visualización de datos
- Barra de búsqueda de divisas


### Autor
**Proyecto desarrollado por Diana Rodriguez** 