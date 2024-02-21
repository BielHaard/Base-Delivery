# Base-Delivery-API
<h2>This is a base application introducing a JWT auth with login e signup, to magnament a delivery simple control.</h2>

## 🚀 Start

This instructions have the step's to introducing and configure test ambient.

### 📋 Required

how many thing's what do you need for run this application?

```
Java 17
Springboot 2.7.X
Postgresql

```

### 🔧 Install

Have only one step to intall and run, configurate your application.propperties to conect a JDBC Postgresql.

how? 

```
application.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/nome_do_banco
spring.datasource.username=your_user
spring.datasource.password=your_password
spring.datasource.driver-class-name=org.postgresql.Driver

spring.mvc.pathmatch.matching-strategy=ant-path-matcher

spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=none
token.signing.key=your_secret_key
```

## 🛠️ Make by


* [Springboot](https://docs.spring.io/spring-framework/reference/index.html) - Framework
* [Maven](https://maven.apache.org/) - Dependencies Magnament


## 📌 Version

[1.0.0]

## ✒️ Autor

* **Júlio Gabriel Garcia** - *Initial work* - [BielHaard]([https://github.com/BielHaard/)
* **Júlio Gabriel Garcia** - *Documentation* - [BielHaard](https://github.com/BielHaard/)


---
⌨️ with ❤️ by [Júlio Gabriel Garcia](https://github.com/BielHaard/) 😊
