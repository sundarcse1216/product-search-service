# product-search-service
Product Search Service

# Pre-requirement:
1. java
2. Start postgres database with default port and host (localhost:5432)

# API Doc:


## 1.Status: 
    Endpoint: /app/status
    Method: GET
    Description: We can check the application status
    
    Response:
    Http Code: 200
    Body:
        Hi, Product Service Up and Running... :)


## 2. Insert Product
    Endpoint: /products
    Method: POST
    Description: Insert product
    
    Request:
    Body:
        {...}
    
    Response:
        Http Code: 200
        Body:
            {
                "code": 202,
                "message": {...}
            }


## 3. Search Product

    Endpoint: /products/search/{keyword}
    Method: GET
    Description: Get all the products
    
    Response:
    Http Code: 200
    Body:
        {
            "code": 200,
            "message": [{...}, {...}]
        }
### Note:
1. Search keyword is case in sensitive
2. Developed this API as per requirement. But for searching elasticsearch will be more efficient than RDBMS.
3. <a href="https://github.com/sundarcse1216/product-search/tree/featute/products">Elasticsearch project</a>


## 4. Get Products
    Endpoint: /products
    Method: GET
    Description: Get all the products
    
    Response:
    Http Code: 200
    Body:
        {
            "code": 200,
            "message": [{...}, {...}]
        }


## 5. Get Product By ID
    Endpoint: /products/{id}
    Method: GET
    Description: Get product by id

    Response:
    Http Code: 200
    Body:
        {
            "code": 200,
            "message": {...}
        }


## 6. Insert Category
    Endpoint: /categories
    Method: POST
    Description: Insert category
    
    Request:
    Body:
        {...}
    
    Response:
    Http Code: 200
    Body:
        {
            "code": 202,
            "message": {...}
        }


## 7. Get Category by ID
    Endpoint: /categories/{id}
    Method: GET
    Description: Get category by id
    
    Response:
    Http Code: 200
    Body:
        {
            "code": 200,
            "message": {...}
        }

# Postman collection
https://github.com/sundarcse1216/product-search-service/blob/feature/products/Product.postman_collection.json

