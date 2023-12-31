# java-spring-app-cookbook
## Overview
Dec 2023:

The project is in the inception phase with the intention to build a fully functioning application in Java programming language
based on the Spring frameworks and persistence layer on MongoDB showcasing the main 
building blocks, technology stack, and coding techniques of an online cloud deployed application.

Functionally, the project implements the basis of a microservice for Business Contact Management. (A commercial product is being developed by AlgoCrafters Inc.)

A front-end UI clients may be added later.

## Status and change history
Dec 2023:

Initial commit consists of the boot (launcher) class, security configuration (minimal for the moment), a controller with a single API endpoint, and service implementing mock (for now) data access.

It compiles and runs; the API endpoint can be tested with a provided cURL request (or any other test client such as Postman).

## Technology stack
- Java 17
- Spring Boot 3.2.0
- Spring Web MVC 6.2.1
- Spring Security 6.2.1
- Spring Data MongoDB 4.2.1
- Mongo Java Driver 4.11.1
- Lombok 1.18.28 is used for code generation of constructors, builders, and getter and setter methods
- Logging: logback
- Source Control and Build: Git (GitHub) & Maven
- Static code analysis via SonarLint (IntelliJ plugin)
- Testing: Postman 10.21.9 and cURL
- Development IDE: IntelliJ IDEA Ultimate (source code contains no dependencies on an IDE other than relying on the SonarLint plugin)

## Architecture
- Spring Boot based application with embedded Tomcat server
- Typical 3-tier backend: Controller tier, Service tier, and Persistence tier
- Controller tier is implemented with REST Annotated Controllers
- Data access is based on Spring Data for MongoDB
- The service layer accesses data via Repository classes and operates with @Document annotated entity classes
- Data in the Controller tier are decoupled from the data in the Persistent tier to comply with security considerations (Ref.: https://o2platform.files.wordpress.com/2011/07/ounce_springframework_vulnerabilities.pdf)
- Services perform mapping of data between DTO (Data Transfer Object) instances and Entity objects (Mongo Documents)

## Build and run
- The app is based on Spring Boot; the parent pom: `spring-boot-starter-parent`
- To build from a terminal, `cd` to the project's root directory, for example  `./home/Projects/Public/java-spring-app-cookbook`
- Java 17 (or later) is required; to verify run: `javac -version`
- To build: `mvn clean install`
- To start (on localhost:8080): `java -jar ./target/java-spring-app-cookbook-0.0.1-SNAPSHOT.jar`

## License
Apache-2.0: https://github.com/VitaliTch/java-spring-app-cookbook?tab=Apache-2.0-1-ov-file#readme
