# consume-report-api
This API provides to report transactions .

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

# Running the application locally

```shell
'mvn spring-boot:run'  or './mvnw spring-boot:run'
```
For running the tests
```shell
'mvn test' or './mvnw test'
```

# Opening Swagger

After running the project, swagger link is: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)


# Credentials

    Email: demo@financialhouse.io
    Password: cjaiU8CV

Entities are stored in H2 db and ids start 1L.

# Endpoints
api/v1/consume-report/login : Get token by https://sandbox-reporting.rpdpymnt.com/api/v3

api/v3/merchant/user/login : Login and generate token by user credential.

api/v3/client : You can customer info with transaction id and token.

api/v3/transaction : Gets transaction info by transaction id.

api/v3/transactions : Gets all transaction detail.

api/v3/transactions/report : Gets the sum of the transactions amount by currency.
