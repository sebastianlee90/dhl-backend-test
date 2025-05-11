# dhl-backend-test

Technical Assessment for DHL Backend

# RESTful API for Recipe Management System using Spring Boot 3

- [Tech Stack](#tech-stack)
- [Run Project](#run-project)
- [Containerized application with Docker](#containerized-application-with-docker)
- [Prometheus for Monitoring](#prometheus-for-monitoring)
- [Spring Boot Jwt Based Authentication and Role-based access control](#spring-boot-jwt-based-authentication)
  - [UserDetailsService](#userdetailsservice)
  - [Add SecurityFilterChain](#add-securityfilterchain)
  - [Generate Jwt Token](#generate-jwt-token)
  - [Implement JwtAuthenticationFilter](#implement-jwtauthenticationfilter)

## Tech Stack:

- Spring Boot 3.x
- Java 17+
<!-- - Spring Data JPA -->
- jOOQ Object Oriented Querying
<!-- - Spring Security -->
- PostgreSQL - Neon tech
- Gradle for dependency management

## Run Project

```
./gradlew bootRun
```

## Containerized application with Docker

```
<!-- Build docker image -->
docker build -t recipe-management .

<!-- Run container from image-->
docker run --name recipe-management -p 8080:8080 recipe-management
```
