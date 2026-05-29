# E-Commerce Microservices Application

A full-stack E-Commerce backend built using Spring Boot Microservices architecture. The project demonstrates service discovery, API gateway routing, JWT authentication, distributed services, Docker containerization, and cloud deployment.

## Architecture

* API Gateway
* Eureka Discovery Server
* User Service
* Product Service
* Cart Service
* MySQL Database

## Tech Stack

### Backend

* Java 21
* Spring Boot 3
* Spring Cloud
* Spring Security
* Spring Data JPA
* JWT Authentication

### Database

* MySQL

### DevOps & Deployment

* Docker
* Docker Compose
* Render
* Railway

## Microservices

### User Service

Responsible for:

* User Registration
* User Authentication
* JWT Token Generation
* User Management

### Product Service

Responsible for:

* Product Management
* Product Creation
* Product Retrieval
* Product Deletion

### Cart Service

Responsible for:

* Add Products to Cart
* View Cart Products
* Increase Product Quantity
* Decrease Product Quantity
* Remove Products from Cart

### API Gateway

Responsible for:

* Request Routing
* Centralized API Access
* Service Communication

### Eureka Discovery Server

Responsible for:

* Service Registration
* Service Discovery

## API Endpoints

### User Service

| Method | Endpoint           | Description   |
| ------ | ------------------ | ------------- |
| POST   | /api/auth/register | Register User |
| POST   | /api/auth/login    | Login User    |
| GET    | /api/auth/getUsers | Get All Users |

### Product Service

| Method | Endpoint                     | Description              |
| ------ | ---------------------------- | ------------------------ |
| GET    | /api/products/getProducts    | Get All Products         |
| POST   | /api/products/addProduct     | Add Product              |
| POST   | /api/products/addProducts    | Add Multiple Products    |
| GET    | /api/products/{id}           | Get Product By Id        |
| DELETE | /api/products/delete/{id}    | Delete Product           |
| DELETE | /api/products/deleteMultiple | Delete Multiple Products |

### Cart Service

| Method | Endpoint                        | Description              |
| ------ | ------------------------------- | ------------------------ |
| POST   | /api/cart/addProductToCart      | Add Product To Cart      |
| GET    | /api/cart/getCartProds          | Get Cart Products        |
| POST   | /api/cart/incNoOfProds/{cartId} | Increase Quantity        |
| POST   | /api/cart/decNoOfProds/{cartId} | Decrease Quantity        |
| DELETE | /api/cart/deleteCartProd/{id}   | Remove Product From Cart |

## Deployment

### Live Services

* API Gateway: https://api-gateway-ktkn.onrender.com
* Discovery Server: https://discovery-server1.onrender.com
* User Service: https://user-service1-midk.onrender.com
* Product Service: https://product-service-e3qx.onrender.com
* Cart Service: https://cart-service-47qe.onrender.com

### Database

* MySQL hosted on Railway

## Features

* Microservices Architecture
* Service Discovery with Eureka
* API Gateway Routing
* JWT Authentication
* MySQL Database Integration
* Dockerized Services
* Cloud Deployment
* RESTful APIs

## Future Enhancements

* Order Service
* Payment Integration
* Inventory Management
* Redis Caching
* Kubernetes Deployment
* CI/CD Pipeline


## Author

Ram
