# Bookstore REST API - Project Description

## 📚 Overview
This project is a comprehensive RESTful API for a Bookstore management system, developed as part of the Client-Server Architectures coursework at the University of Westminster. The API enables full CRUD operations for books, authors, customers, shopping carts, and orders, following strict REST principles and implemented using JAX-RS.



Uploading W2083055 Disandu Jayawardhana CSA(API Testing With Postman ).mp4…



## ✨ Key Features
- **Resource Management**: Full lifecycle management for books, authors, and customers
- **E-commerce Functionality**: Shopping cart operations and order processing
- **RESTful Design**: Proper use of HTTP methods and status codes
- **Error Handling**: Custom exceptions with meaningful JSON responses
- **In-Memory Storage**: Simple yet effective data persistence

## 🛠 Technology Stack
- **Core Framework**: JAX-RS (Jersey/RESTEasy implementation)
- **Data Format**: JSON for all requests/responses
- **Testing Tool**: Postman for API testing and documentation
- **Storage**: In-memory data structures (no external databases)

## 📂 Project Structure
```
bookstore-api/
├── src/
│   ├── main/java/
│   │   ├── resources/          # JAX-RS resource classes
│   │   ├── models/             # Data model classes
│   │   ├── exceptions/         # Custom exception classes
│   │   └── AppConfig.java      # Application configuration
│   └── test/                   # Test classes
├── postman/                    # Postman collection
├── reports/                    # Test case documentation
└── README.md                   # This file
```

## 🚀 Getting Started
1. **Prerequisites**: Java JDK 8+, Maven, Postman
2. **Installation**:
   ```bash
   git clone [repository-url]
   cd bookstore-api
   mvn clean install
   ```
3. **Running**:
   ```bash
   mvn jetty:run
   ```
4. **Testing**: Import the Postman collection from `/postman`

---

# README.md

```markdown
# Bookstore REST API

![Java](https://img.shields.io/badge/Java-17-blue)
![JAX-RS](https://img.shields.io/badge/JAX--RS-2.1-green)
![REST](https://img.shields.io/badge/RESTful-API-orange)

A complete RESTful API for bookstore management, developed for the Client-Server Architectures coursework at University of Westminster.

## Table of Contents
- [Features](#features)
- [API Endpoints](#api-endpoints)
- [Installation](#installation)
- [Usage](#usage)
- [Testing](#testing)
- [Documentation](#documentation)
- [Academic Compliance](#academic-compliance)

## Features
- **Book Management**: Create, read, update, and delete books
- **Author Operations**: Manage author information and their books
- **Customer System**: Handle customer accounts and profiles
- **Shopping Cart**: Add/remove books, adjust quantities
- **Order Processing**: Convert carts to completed orders
- **Error Handling**: Custom exceptions with JSON responses

## API Endpoints

### Books
- `POST /books` - Create new book
- `GET /books` - List all books
- `GET /books/{id}` - Get specific book
- `PUT /books/{id}` - Update book
- `DELETE /books/{id}` - Remove book

### Authors
- `POST /authors` - Add new author
- `GET /authors/{id}/books` - Get author's books
- ... [other author endpoints]

### Customers
- `POST /customers` - Register customer
- ... [other customer endpoints]

### Carts
- `POST /customers/{id}/cart/items` - Add to cart
- ... [other cart endpoints]

### Orders
- `POST /customers/{id}/orders` - Create order
- ... [other order endpoints]

## Installation
1. Clone repository:
   ```bash
   git clone https://github.com/[your-repo]/bookstore-api.git
   ```
2. Build with Maven:
   ```bash
   mvn clean install
   ```

## Usage
Run the application:
```bash
mvn jetty:run
```

The API will be available at `http://localhost:8080/api`

## Testing
Import the Postman collection from `postman/Bookstore_API.postman_collection.json` and run the test cases.

## Documentation
- Full API specification in `reports/API_Documentation.pdf`
- Test case reports in `reports/Test_Cases.pdf`
