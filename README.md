# Auth

Responsible for authentication and authorization.

## Requirements

- [JDK 17](https://www.oracle.com/br/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven](https://maven.apache.org)

## Build
```shell
cd auth
mvn install
```

## Run

`com.deboramendes.auth.AuthApplication`

## Environment variables

Name | Value
---- | -----
AUTH_OPEN_API_CONTACT_EMAIL | Contact e-mail
AUTH_OPEN_API_CONTACT_NAME | Contact name
AUTH_OPEN_API_CONTACT_URL | Contact URL
AUTH_JWT_SECRET_KEY | JWT secret key
AUTH_POSTGRESQL_DATABASE | Database name
AUTH_POSTGRESQL_HOST | Database host
AUTH_POSTGRESQL_PASS | Database password
AUTH_POSTGRESQL_PORT | Database port

## OpenAPI 3.0

- [Swagger 3](http://localhost:8080/swagger-ui/index.html#/)