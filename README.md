# ServiAseo Invoice Management System

## Descripción

El sistema de gestión de facturas de **ServiAseo** es una aplicación basada en Spring Boot que permite crear, almacenar y enviar facturas por correo electrónico (simulado) a los clientes. La aplicación está integrada con una base de datos PostgreSQL para la persistencia de datos.

## Requisitos Previos

Antes de poder ejecutar este proyecto, asegúrate de tener instalados los siguientes componentes:

- **Java Development Kit (JDK)** 17 o superior
- **Maven** 3.6.0 o superior
- **PostgreSQL** 13 o superior
- **IntelliJ IDEA** (opcional pero recomendado)
- **Git** (opcional para clonar el repositorio)

## 2. Configuración de la Base de Datos

### 2.1 Crear la Base de Datos

Primero, necesitas crear la base de datos en PostgreSQL.

1. Conéctate a tu servidor PostgreSQL usando `psql` o `pgAdmin`.
2. Crea la base de datos:

   ```sql
   CREATE DATABASE serviaseo_db;


## 2.2 Crear las Tablas

A continuación, crea las tablas necesarias para el proyecto.

### 2.2.1 Tabla `customers`

```sql
CREATE TABLE customers (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    phone VARCHAR(20),
    address VARCHAR(255)
);

