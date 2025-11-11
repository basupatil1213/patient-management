# patient-management

This repository contains a microservices-based patient management system, including:

## Projects

### 1. patient-service

A Spring Boot REST API for managing patient records.  
**Features:**
Patient Management — Microservices Overview

Overview
--------
Collection of Spring Boot microservices for patient management and billing. Includes `patient-service` and `billing-service` with supporting request collections for testing.

Services
--------
- patient-service: Spring Boot REST API for CRUD on patient records (Postgres/H2 for tests)
- billing-service: Scaffolded service for billing and invoicing logic
- api-requests: HTTP request files for endpoint testing

Tech stack
----------
Java, Spring Boot, PostgreSQL (production), H2 (testing), OpenAPI/Swagger

Running locally
---------------
1. mvn install in service directories
2. Start services with `mvn spring-boot:run`

Notes
-----
See each service folder for detailed README and environment variable requirements.