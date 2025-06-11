# Cómo correr el proyecto

## 🚀 Requisitos

- Java 17
- Maven 3.9+
- Puerto 8080 libre

## 📦 Instalación

```bash
mvn clean install
```

## ▶️ Ejecución

```bash
mvn spring-boot:run
```

## 🔎 Endpoints disponibles

- `GET /products`  
  Retorna todos los productos.

- `GET /products/{id}`  
  Retorna el producto con ID especificado. Devuelve 404 si no existe.

## 📘 Swagger

Una vez levantado el proyecto, accedé a:

```
http://localhost:8080/swagger-ui.html
```

## 🧪 Tests

Para correr los tests con cobertura:

```bash
mvn clean test jacoco:report
```

Ver cobertura en:

```
target/site/jacoco/index.html
```

## 📫 Contacto

Desarrollado por Diego Prystupczuk como parte del challenge técnico de Mercado Libre.
