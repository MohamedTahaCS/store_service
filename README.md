# Store Service

**Store Service** is a Spring Boot application designed for straightforward store inventory management. It comprises three main classes: `Store`, `Stock`, and `StockHistory`. The application employs Spring JPA and a PostgreSQL database for seamless data storage. Lombok minimizes code, Maven simplifies project management, and API documentation is facilitated via Swagger.

## Features

-   **Store Operations**: Utilize the `Store` class for effortless CRUD (Create, Read, Update, Delete) operations to manage store details.

-   **Stock Tracking**: The `Stock` class ensures efficient inventory control by managing product quantities within the store.

-   **Stock History**: Track stock quantity changes over time with the `StockHistory` class, maintaining a reliable change history.

Experience simplified store inventory management with the efficiency of Spring Boot, Spring JPA's data handling, and the robustness of PostgreSQL. Lombok minimizes code overhead, Maven eases project upkeep, and Swagger documentation aids in API understanding.

## Prerequisites

-   Java 20 or higher
-   Maven
-   PostgreSQL

## Setup

1. Clone the repository:

    ```bash
    git clone https://github.com/MohamedTahaCS/store_service.git
    cd store-service
    ```

2. Configure the database:

    - Create a PostgreSQL database and update the `application.properties` file under `src/main/resources` with your database configuration:

    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/your_database
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    ```

3. Build and run the application:

    ```bash
    mvn spring-boot:run
    ```

4. Access the Swagger documentation:

    After starting the application, you can access the Swagger UI at `http://localhost:8080/swagger-ui.html`. Here, you can interact with the API endpoints and view their documentation.

## Project Structure

    - `controller/` - Contains API endpoints and request mappings.
    - `model/` - Contains the data models (e.g., `Store`, `Stock`, `StockHistory`).
    - `repository/` - Spring Data JPA repositories.
    - `service/` - Service layer for business logic.
    - `FawryApplication.java` - Main Spring Boot application class.

## Usage

The service exposes RESTful API endpoints for managing stores, stocks, and stock history. Refer to the Swagger documentation for a detailed API reference.

## Contributing

Contributions are welcome! Please follow these steps to contribute:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Commit your changes.
4. Push your changes to your fork.
5. Submit a pull request to the main repository.
