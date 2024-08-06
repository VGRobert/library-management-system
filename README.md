# Library Management System

## Overview

The **Library Management System** is a Spring Boot application designed to manage a library's collection of books. It provides a RESTful API that allows users to perform CRUD operations on books and categories, showcasing how to handle bidirectional relationships using JPA and Hibernate.

## Features

- **RESTful API**: Provides endpoints for managing books and categories.
- **Entity Relationships**: Demonstrates bidirectional relationships between `Book` and `Category` entities.
- **JSON Serialization**: Uses `@JsonManagedReference` and `@JsonBackReference` to prevent infinite recursion during JSON serialization.
- **Database Management**: Automatically handles schema creation and sample data insertion on application startup.
- **Sample Data**: Preloads the database with sample categories and books for immediate use and testing.

## Technologies Used

- **Java 17**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **Hibernate**
- **PostgreSQL**
- **Maven**
- **Jackson for JSON serialization**

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.x
- PostgreSQL database

### Setup

1. **Clone the repository:**

   ```bash
   git clone https://github.com/VGRobert/library-management-system.git
   cd library-management-system
