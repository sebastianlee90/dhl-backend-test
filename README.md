# dhl-backend-test

Technical Assessment for DHL Backend

# RESTful API for Coordinate Management System using Spring Boot 3

- [Tech Stack](#tech-stack)
- [Run Project](#run-project)
- [API URLs](#api-urls)
- [Containerized application with Docker](#containerized-application-with-docker)

## Tech Stack:

- Spring Boot 3.x
- Java 17+
- jOOQ Object Oriented Querying
- PostgreSQL - Neon tech
- Gradle for dependency management

## Run Project

```
./gradlew bootRun
```

## API URLs

```
src\main\java\com\backend\coordinateManagement\controller\PostcodeController.java
```

Example:

```
localhost:8081/api/v1/postcode

localhost:8081/api/v1/postcode/calculate_distance?postcodeFrom=B34&postcodeTo=L36
```

## Containerized application with Docker

```
<!-- Build docker image -->
docker build -t coordinate-management
```
