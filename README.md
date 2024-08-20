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
```
### 2.2.2 Tabla `cleaning_types`

```sql
CREATE TABLE cleaning_types (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);
```
### 2.2.3 Tabla `invoices`

```sql
CREATE TABLE invoices (
    id SERIAL PRIMARY KEY,
    issue_date DATE NOT NULL,
    cleaning_type_id INT REFERENCES cleaning_types(id),
    customer_id INT REFERENCES customers(id),
    amount DECIMAL(10, 2) NOT NULL
);
```
### 2.2.4 Tabla `invoice_details`

```sql
CREATE TABLE invoice_details (
    id SERIAL PRIMARY KEY,
    invoice_id INT REFERENCES invoices(id),
    description TEXT NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL
);
```
### 2.2.5 Tabla `email_logs`

```sql
CREATE TABLE products (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL
);
```
### 2.2.6 Tabla `email_logs`

```sql
CREATE TABLE email_logs (
    id SERIAL PRIMARY KEY,
    recipient VARCHAR(255) NOT NULL,
    subject VARCHAR(255) NOT NULL,
    body TEXT NOT NULL,
    attachment_size INT,
    timestamp TIMESTAMP NOT NULL
);
```

