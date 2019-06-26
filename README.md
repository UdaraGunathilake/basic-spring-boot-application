# Sample Spring Boot API

Imlplemented to demonstrate on how to develop basic Spring Boot application. <br />
MySQL as the database. <br />
Log4j2 for logging.

## Features that used in the application

Interceptor - CorrelationId Interceptor <br />
Swagger - API documantation <br />
ControllerAdvicer - Controller Level Exception Handling<br />
Aspect - Repository Aspect <br />
Spring Profiles <br/>

CorrelationId - to log and handle each request separetly <br />
JPA - Handle Database transactions <br />
MDC - Maintain CorrelationId through out the request <br />
ConstraintValidator - Used to validate domain classes just by adding a annotation <br />

## Build Application

mvnw clean install -Dspring.profiles.active=local <br />

## Running Application

spring boot run command : <br />

mvnw spring-boot:run -Dspring.profiles.active=local


