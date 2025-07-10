# 📚 RESTful Bookstore API

A Spring Boot application that provides RESTful APIs for managing books and authors in a bookstore. The app supports CRUD operations, filtering, pagination, and sorting, and uses H2 as the in-memory database.

---

## 📌 Features

- CRUD operations for **Authors** and **Books**
- Data validation using `jakarta.validation`
- Filtering, sorting, and pagination support for books
- DTO-based request/response handling
- Global exception handling
- Preloaded dataset on startup
- Swagger UI documentation
- H2 console for in-memory database visualization

---

## 🛠 Tools & Technologies

- Java 17
- Spring Boot 3.x
- Spring Data JPA
- H2 Database
- Swagger (Springdoc OpenAPI)
- Lombok
- Maven

---

## 🚀 Getting Started

### Prerequisites

- Java 17+
- Maven

### Run the Project

```bash
mvn spring-boot:run
````

### Access Swagger UI

```
http://localhost:8080/swagger-ui/index.html
```

### Access H2 Console

```
http://localhost:8080/h2-console
```

Use `jdbc:h2:mem:bookstoredb` as JDBC URL

---

## 🧪 Sample Endpoints

### 📘 Books

* `GET /api/books` – List all books (supports pagination, filtering, sorting)
* `GET /api/books/{id}` – Get book details by ID
* `POST /api/books` – Create a new book
* `PUT /api/books/{id}` – Update an existing book
* `DELETE /api/books/{id}` – Delete a book
* `GET /api/books/filter` - Filter , Pagenate, Sort books based on Title, Genre, PublicationYear, Author etc.

### 👤 Authors

* `GET /api/authors` – List all authors
* `GET /api/authors/{id}` – Get author details with books
* `POST /api/authors` – Create a new author
* `PUT /api/authors/{id}` – Update an existing author
* `DELETE /api/authors/{id}` – Delete an author

---

## 📄 Notes

* Project uses **DTOs** for clean data exchange between client and server.
* Author and Book update operations expect path variable `id` and relevant fields in the request body.
* On startup, 10+ books and 6+ authors are auto-populated for testing.
* Validation errors and missing resources are gracefully handled with custom exceptions.

---