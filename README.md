# Product Management Application

## Description

The Product Management Application is a Java-based web application designed for managing products. It provides a set of RESTful endpoints for retrieving all products and filtering products based on specific query parameters. The application uses a SQL database for data persistence and employs the Maven tool for managing project's build.

## Technologies

The application is built using the following technologies:

- **Java 11**: The primary programming language used for the development of the application.
- **SQL (H2)**: An in-memory database used for data persistence.
- **Maven**: A powerful project management tool used for managing the project's build, reporting, and documentation.
- **JUnit 5 and Mockito**: These are used for effective unit testing in the application.

## Endpoints

The application exposes the following RESTful endpoints:

- `GET /products`: This endpoint retrieves all products from the database and returns them as a JSON array.
- `GET /products/filter`: This endpoint retrieves products based on query parameters. The query parameters should be included in the URL. For example, `/products/filter?name=ale` would retrieve products with "ale" in their name. The endpoint returns a JSON array of the filtered products.

Please note that these endpoints are relative to the base URL of the server hosting the application. For example, if the application is hosted at `http://localhost:8080`, the full URL for the `/products` endpoint would be `http://localhost:8080/products`.

## Future Implementations

The following features are planned for future implementation:

- **Product Update and Deletion**: Endpoints for updating and deleting products will be added.
- **User Authentication**: User authentication will be implemented to secure the application.
- **Pagination**: Pagination will be added to the endpoints to handle large amounts of data.

## Credits

This application is developed by JesterCharles & roryeiffe. 