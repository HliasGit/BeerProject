# PintBid bidding platform app

A simple bidding app allowing you to create an auction and to bid.

## Table of contents
* [Current srage](#progress)
* [Database](#database)
* [Testing Data](#data)
* [Technologies](#technologies)


<a id="progress"></a>
## 🌅 Current stage of progress

- For now, we have set up:

**MVC in SpringBoot**:
Package structure:
--api: controllers
--dao: crud repositories
--model
--service

models: Auction, User, Offer and Product 
controllers:  AuctionController, UserController, OfferController, ProductController

**CRUD Repositories**:
DAO interfaces extend CRUD Repositories

**REST API endpoints, response with HTTP status**:

http://localhost:8080/v1/auctions
http://localhost:8080/v1/auctions/{id}

http://localhost:8080/v1/products
http://localhost:8080/v1/products/{id}

http://localhost:8080/v1/users
http://localhost:8080/v1/users/{id}

http://localhost:8080/v1/offers
http://localhost:8080/v1/offers/{id}


<a id="database"></a>
## 📊 Database

we implemented h2 database. It is accessible in http://localhost:8080/h2/
-> IDs are autogenerated by using annotations:  @Id @GeneratedValue

with path: jdbc:h2:file:./data/fileDb
User name: su
Password: 

There are 4 tables created for now, TB_USERS, TB_PRODUCTS, TB_AUCTIONS, TB_OFFERS


<a id="data"></a>
## 📊 Testing Data
>AUCTION TEST DATA 
>  
>{
"id": "E025402-890f-4db7-b4f4-c5df57afa624",
"title": “Test” Title One,
"dateOfStart": "2022-11-29”,
"dateOfEnd": "2022-11-30",
"buyerId": "E7fe4cae-b906-4d3a-ad51-07ed8760b399",
"sellerId": "E633f794-969d-474e-88b1-4697d1fa6f3a",
"active": true,
"productId": "EEfe4cae-b906-4d3a-ad51-07ed8760b399",
"category": “beer”
}
> 
> PRODUCT TEST DATA
>
>{
"userId”: E7fe4cae-b906-4d3a-ad51-07ed8760b399
"name": “Product”,
"description": “Product description,
"image": “fakeImg”,
"minPrice": 4.9,
"expectedPrice": 9.2,
"expectedDeliveryTimeInDays": 7 }



<a id="technologies"></a>
## 🛠 Technologies used:

validation: [spring-boot-starter-validation](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-validation)
-> annotation we used: @NotNull @NotBlank, @Email, @Size, 

unit testing: [junit-jupiter-api](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api/5.9.1)
