# Product Management Application

## Description

This is a Java-based web application for managing products. The application provides endpoints for retrieving all products and filtering products based on query parameters. It uses a SQL database for data persistence and Maven for dependency management.

## Technologies

This application is built with the following technologies:

- Java 11: The main programming language used for development.
- SQL (H2): Used for in-memory data persistence.
- Maven: Used for dependency management.
- JUnit 5 and Mockito: Used for unit testing.

## Endpoints

The application provides the following endpoints:

- `GET /products`: Retrieves all products. Returns a JSON array of products.
- `GET /products/filter`: Retrieves products based on query parameters. The query parameters should be included in the URL. For example, `/products/filter?name=ale` would retrieve products with "ale" in their name. Returns a JSON array of products.

Please note that these endpoints are relative to the base URL of the server hosting the application. For example, if the application is hosted at `http://localhost:8080`, the full URL for the `/products` endpoint would be `http://localhost:8080/products`.