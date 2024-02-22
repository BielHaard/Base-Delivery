# Base-Delivery-API
<h2>Esta é uma aplicação base que apresenta autenticação JWT com login e cadastro, para gerenciar um controle de entrega simples.</h2>

## 🚀 Início

Estas instruções têm os passos para introduzir e configurar um ambiente de teste.

### 📋 Requisitos

O que você precisa para executar esta aplicação?

```
Java 17
Springboot 2.7.X
Postgresql

```

### 🔧 Instalação

Apenas um passo para instalar e executar, configure seu arquivo `application.properties` para se conectar a um PostgreSQL via JDBC.

Como?

```properties
application.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/nome_do_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.datasource.driver-class-name=org.postgresql.Driver

spring.mvc.pathmatch.matching-strategy=ant-path-matcher

spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=none
token.signing.key=sua_chave_secreta
```

## 🌐 Endpoints

### Controller de Cliente

#### `GET /clientes`

Obter todos os clientes.

#### `GET /clientes/{id}`

Obter um cliente específico pelo ID.

#### `POST /clientes`

Criar um novo cliente.

#### `PUT /clientes/{id}`

Atualizar um cliente pelo ID.

#### `DELETE /clientes/{id}`

Excluir um cliente pelo ID.

#### `POST /clientes/{clienteId}/relacionar-pedido`

Relacionar um pedido a um cliente.

### Controller de Entrega

#### `GET /entregas`

Obter todas as entregas.

#### `GET /entregas/{id}`

Obter uma entrega específica pelo ID.

#### `POST /entregas/{pedidoId}`

Criar uma nova entrega relacionada a um pedido.

#### `PUT /entregas/{id}`

Atualizar uma entrega pelo ID.

#### `DELETE /entregas/{id}`

Excluir uma entrega pelo ID.



## 🛠️ Feito Com


* [Springboot](https://docs.spring.io/spring-framework/reference/index.html) - Framework
* [Maven](https://maven.apache.org/) - Dependencies Magnament


## 📌 Versão

[1.0.0]

## ✒️ Autor

* **Júlio Gabriel Garcia** - *Initial work* - [BielHaard]([https://github.com/BielHaard/)
* **Júlio Gabriel Garcia** - *Documentation* - [BielHaard](https://github.com/BielHaard/)


---
⌨️ with ❤️ by [Júlio Gabriel Garcia](https://github.com/BielHaard/) 😊
