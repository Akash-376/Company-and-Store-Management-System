# Company and Store Management System

A Spring Boot RESTful API project to manage **Companies** and their **Stores**.  
This system allows us to:
- Create and fetch companies
- Assign any existing store to companies
- Manage stores belonging to companies
- Fetch store details and locations
- Query stores by city

---

## 🚀 Features
### Company Endpoints (`/companies`)
- **POST** `/companies/`  
  ➝ Add a new company

- **GET** `/companies`  
  ➝ Get list of all companies

- **GET** `/companies/AllStores/{companyId}`  
  ➝ Get all stores for a given company

- **POST** `/companies/{companyId}/{storeId}`  
  ➝ Assign an existing store to a company

---

### Store Endpoints (`/stores`)
- **POST** `/stores`  
  ➝ Add a new store

- **GET** `/stores/{storeId}`  
  ➝ Get store by ID

- **GET** `/stores/location/{storeId}`  
  ➝ Get location details of a store

- **GET** `/stores/stores/{city}`  
  ➝ Get all stores in a city

---

## 🏗️ Tech Stack
- **Java 17+**
- **Spring Boot 3+**
- **Spring Web** (REST API)
- **Spring Data JPA** (assumed for persistence)
- **Hibernate** (ORM)
- **MySQL** (configurable database)

---
