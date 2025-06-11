# Documentación técnica - Challenge Mercado Libre

## 🧠 Diseño general

Para este challenge decidí implementar una arquitectura basada en **DDD (Domain-Driven Design)** y **principios SOLID**, dado que son prácticas habituales en entornos productivos y que aplico frecuentemente en .NET.

El proyecto está dividido en capas:

- `controller`: expone la API RESTful
- `service`: contiene la lógica de negocio
- `repository`: maneja el acceso a los datos desde un archivo JSON local
- `model`: representa el dominio real de los productos y vendedores
- `dto`: define los contratos expuestos por la API (evitando exponer el modelo directamente)

También implementé una capa de `exception` para el manejo centralizado de errores, alineado a buenas prácticas de Spring Boot.

---

## 📦 Stack elegido

- **Java 17**
- **Spring Boot 3**
- **Maven** como herramienta de build
- **Jackson** para deserialización de JSON
- **JUnit 5 + Mockito** para tests unitarios
- **JaCoCo** para medir cobertura de código
- **springdoc-openapi** para documentación Swagger

---

## 🔍 Detalles técnicos

- La persistencia se resuelve leyendo un archivo `products.json` en cada request (como indicaba el enunciado).
- El endpoint `/products` devuelve todos los productos.
- El endpoint `/products/{id}` permite consultar un producto específico.
- En caso de error (producto inexistente o fallo de lectura), se responde con códigos y mensajes adecuados vía `@ControllerAdvice`.

El modelo `Product` y `Seller` incluye atributos adicionales como garantía, ventas, cuotas, y envío, basándome en ejemplos reales de Mercado Libre para simular un caso de uso más completo.

---

## ✅ Cobertura y calidad

- La cobertura de código alcanza **más del 80%** sobre la capa de negocio y controladores.
- Se testean los flujos positivos y negativos, incluyendo el manejo de excepciones.
- Swagger documenta todos los endpoints con parámetros y respuestas esperadas.

---

## 🛠️ Desafíos y soluciones

**Problema**: Integrar Swagger con Spring Boot 3.  
**Solución**: Usé `springdoc-openapi-starter-webmvc-ui` versión 2.8.9 para evitar errores 500 en `/v3/api-docs`.

**Problema**: Manejar correctamente errores sin usar una base de datos real.  
**Solución**: Se creó una excepción personalizada (`ProductNotFoundException`) y un manejador global para retornar mensajes claros.

**Problema**: Mantener testabilidad sin sobrecomplicar la carga desde JSON.  
**Solución**: Se modularizó la lógica en `ProductRepository` y se simularon errores en tests usando archivos malformados.

---

## 🙌 Gracias

Este proyecto fue desarrollado con foco en calidad técnica, mantenibilidad y buenas prácticas.  
Gracias por la oportunidad.

**Diego Prystupczuk**
