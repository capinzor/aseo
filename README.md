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

## Configuración de la Base de Datos

1. **Instalar y configurar PostgreSQL**:

   Asegúrate de que PostgreSQL esté instalado y en funcionamiento. Luego, crea una base de datos para la aplicación:

   ```sql
   CREATE DATABASE serviaseo_db;
