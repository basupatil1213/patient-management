# patient-management

This repository contains a microservices-based patient management system, including:

## Projects

### 1. patient-service

A Spring Boot REST API for managing patient records.  
**Features:**
- CRUD operations for patients (create, read, update, delete)
- Data validation and exception handling
- Uses PostgreSQL (with H2 for testing)
- OpenAPI/Swagger documentation

### 2. billing-service

A Spring Boot service scaffolded for handling billing operations.  
**Features:**
- Intended for billing and invoicing logic
- Includes dependencies for gRPC, suggesting future or planned inter-service communication via gRPC

### 3. api-requests

A collection of HTTP request files (in `.http` format) for testing the `patient-service` API endpoints, including:
- Create, update, delete, and fetch patients