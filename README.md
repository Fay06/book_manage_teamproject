# Nobug Team Project
*(@localhost:8081)*
## 1. Documented API

* ___Books___
  * `GET /book/get`
    * Sample Request: localhost:8081/book/get?bookID=123
    * Request Parameters:
      * `bookID` int(Not necessarily)
      * `bookName` String(Not necessarily)
      * `category` String(Not necessarily)
  * `DELETE /book/delete`
    * Sample Request: localhost:8081/book/delete?bookID=123
    * Request Parameters:
      * `bookID` int(Required)
  * `POST /book/add`
    * Sample Request: localhost:8081/book/add?bookName=test&category=test
    * Request Parameters:
      * `bookName` String(Required)
      * `category` String(Required)
  * `PUT /book/update`
    * Sample Request: localhost:8081/book/update?bookID=123&bookName=test
    * Request Parameters:
      * `bookID` int(Required)
      * `bookName` String(Not necessarily)
      * `category` String(Not necessarily)

* ___Rating___
  * `GET /rating/get`
    * Sample Request: localhost:8081/rating/get?bookID=123
    * Request Parameters:
      * `bookID` int(Required)
  * `DELETE /book/delete`
    * Sample Request: localhost:8081/rating/delete?ratingID=11
    * Request Parameters:
      * `ratingID` int(Required)
  * `POST /book/add`
    * Sample Request: localhost:8081/rating/add?bookID=123&rating=5
    * Request Parameters:
      * `bookID` int(Required)
      * `rating` int(Required)
  * `PUT /book/update`
    * Sample Request: localhost:8081/rating/update?ratingID=11&rating=1
    * Request Parameters:
      * `ratingID` int(Required)
      * `rating` int(Required)

* ___BookList___

  - /getBookList/{bookListID}

  - /deleteBookList/{bookListID}

  - /addBookList/{bookListName}

  - /updateBookListName/{bookListID}/{bookListName}

  - /addBookToBookList/{bookListID}/{bookID}

  - /removeBookFromBookList/{bookListID}/{bookID}

  - /getBooksFromBookList/{bookListID}

## 2. Build, Run, Test Instructions

* Build project in IntelliJ using "Build Project" button

* Run nobug_teamproject/src/test/java/com/nobug/nobug_teamproject/TestProjectApplicationTests.java

* Open browser, and type localhost:8081/... to get the information or make changes on existing table

* System test: test with this address localhost:8081 in Postman
