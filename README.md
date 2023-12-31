# FX Deals Data Warehouse

This project is a Spring Boot application developed to handle FX deals and persist them into a MySQL database for analysis. It provides functionality to validate incoming deal details, prevent duplication, and store the valid deals in the database.

## Prerequisites
- Java 11 or higher
- Maven build tool
- MySQL database


## Getting Started
Follow the instructions below to set up and run the FX Deals Data Warehouse application.

1. Clone the repository from GitHub:
   git clone https://github.com/Waad-Awajneh/FXdeals.git
   
2. Configure the MySQL database connection details: Open the src/main/resources/application.properties file, and Update the following properties with your MySQL 
   database connection details:

    - spring.datasource.url=jdbc:mysql://localhost:3306/db_name
    - spring.datasource.username=db_username
    - spring.datasource.password=db_password

3. Replace db_name, db_username, and db_password with your MySQL database name, username, and password.


## Build the application using Maven :

  mvn clean install

## Run the application:

   mvn spring-boot:run
   The application will start, and you can access it at http://localhost:8080.


## Build the Docker image :

   docker build -t [tag] .
   
## Run the application using docker compose:

   docker compose up 

## API Endpoint
The application exposes the following API endpoint to import FX deals:

Endpoint: POST /api/v1/
Request body:
```json
 {
 "orderingCurrency":"JOD", --required
     "codeCurrency":"123", --required
     "amount":10.5         --required
     }
```   
Response: Success message or error message with appropriate HTTP status code

Endpoint: GET /api/v1/
Response body:
```json
{
        "orderingCurrency": "JOD",
        "codeCurrency": "123",
        "dateTime": "2023-06-21T21:45:30.228259",
        "amount": 10.5
    }
```

## Error Handling
The application handles different types of errors and exceptions:

- FxDealValidationException: Thrown when deal validation fails.


## Logging

The application uses the default logging configuration provided by Spring Boot. Logging statements are written to the console and can be customized as per your 
needs. using lombok library.

## Database Schema
The application automatically creates the necessary database tables based on the entity classes.
The table schema for the FxDeal entity is as follows:
```sql
CREATE TABLE fx_deal (
  id INT PRIMARY KEY AUTO_INCREMENT,
  codeCurrency VARCHAR(255) NOT NULL,
  orderingCurrency VARCHAR(255) NOT NULL,
  dateTime DATETIME NOT NULL,
  amount DECIMAL(10, 2) NOT NULL
);
```

## Conclusion

The FX Deals Data Warehouse application provides a convenient way to import and store FX deals in a MySQL database. It handles deal validation, prevents duplication, and ensures the successful persistence of valid deals. You can further extend and customize this application to meet your specific requirements.


