# Address Book Spring Boot Application

## Overview
A RESTful backend application built using Spring Boot to manage Address Book entries.  
Developed incrementally using structured Use Cases (UCs), focusing on clean architecture, REST design, validation, exception handling, logging, and environment-based configuration.

---

## Architecture
Controller → Service → Repository → Database  
             ↘ DTO → Model  
             ↘ Exception Handling  
             ↘ Logging  

---

## Tech Stack
- Java  
- Spring Boot (Web, Data JPA, Validation)  
- MySQL  
- Lombok  
- Maven  

---

## Features
- CRUD REST APIs (GET, POST, PUT, DELETE)  
- DTO-based validation  
- Global exception handling  
- Custom business exceptions  
- Structured logging using Lombok (`@Slf4j`)  
- Environment-based configuration (dev/prod)  
- Secure DB configuration using environment variables  

---

## Use Cases

- UC1: Base project setup with working REST endpoint  
- UC2: Implemented REST APIs with all HTTP methods  
- UC3: Introduced DTO, Model, Repository, and Service layers  
- UC4: Moved business logic to Service layer (thin controller)  
- UC5: Implemented in-memory data storage  
- UC6: Used Lombok to remove boilerplate code  
- UC7: Added logging using `@Slf4j`  
- UC8: Configured environment-based logging using Spring profiles  
- UC9: Externalized DB credentials using environment variables  
- UC10: Added validation (`@NotBlank`, `@Pattern`)  
- UC11: Implemented global exception handling  
- UC12: Added custom exception for "AddressBook not found"  

---

## API Endpoints

| Method | Endpoint                | Description        |
|--------|------------------------|--------------------|
| GET    | /addressbook           | Get all records    |
| GET    | /addressbook/{id}      | Get record by ID   |
| POST   | /addressbook           | Create record      |
| PUT    | /addressbook/{id}      | Update record      |
| DELETE | /addressbook/{id}      | Delete record      |

---

## Sample CURL

curl.exe http://localhost:8080/addressbook

---

## Error Response Format

Validation Error:
{
  "timestamp": "2026-04-18T12:10:00",
  "status": 400,
  "message": "Validation failed",
  "errors": {
    "name": "Name is required"
  }
}

Not Found Error:
{
  "timestamp": "2026-04-18T12:13:55",
  "status": 404,
  "message": "AddressBook with id 99 not found"
}

---

## Configuration

spring.profiles.active=dev

Environment Variables:
DB_USERNAME=your_username  
DB_PASSWORD=your_password  

---
