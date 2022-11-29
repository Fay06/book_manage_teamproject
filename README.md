# Nobug Team Project
*(We have deployed this to heroku, link: https://nobug-teamproject.herokuapp.com/)*

#### Team Member:
* Yufei Liu yl5099
* Hongxuan Chen hc3275
* Chenyue Wang cw3444
* Chang Gao cg3320

## 1. Documented API
* `NOTE: All methods below require authentication token, include token in HEADER(Authorization = "Bearer + Token")`
  * Invalid token or empty token:
    * `Authentication Failed` (HTTP Status 403 Forbidden)
* ___Books___
  * `GET /book/get`
    * Sample Request: `curl --location --request GET 'https://nobug-teamproject.herokuapp.com/book/get?bookID=2'`
    * Request Parameters:
      * `bookID` int(Not necessarily)
      * `bookName` String(Not necessarily)
      * `category` String(Not necessarily)
      * `size` int(Not necessarily)
    * Instruction:
      * Search by `bookID`(default size = 20)
      * Search by `bookName`(default size = 20)
      * Search by `category`(default size = 20)
      * List all Books(with no input and default size = 20)
    * Responses:
      * ```
          {
              "bookID": 1162,
              "bookName": "Applied Human Anatomy",
              "category": "textbook"
          }
    * Error Message:
      * `BookID Not Found` (HTTP Status 404 Not Found)
      * `BookName Not Found` (HTTP Status 404 Not Found)
      * `Category Not Found` (HTTP Status 404 Not Found)
      * `Failed` (HTTP Status 400 Bad Request)
  * `DELETE /book/delete`
    * Sample Request: `curl --location --request DELETE 'https://nobug-teamproject.herokuapp.com/book/delete?bookID=2'`
    * Request Parameters:
      * `bookID` int(Required)
    * Instruction:
      * Delete by `bookID`
    * Responses: `Book Deleted`
    * Error Message:
      * `Book Not Found` (HTTP Status 404 Not Found)
      * `Failed` (HTTP Status 400 Bad Request)
  * `POST /book/add`
    * Sample Request: `curl --location --request POST 'https://nobug-teamproject.herokuapp.com/book/add?bookName=test&category=test'`
    * Request Parameters:
      * `bookName` String(Required)
      * `category` String(Required)
    * Instruction:
      * Add Book with `bookName` and `category`
    * Responses: `Book Added, Book ID: 123`
    * Error Message:
      * `Failed` (HTTP Status 400 Bad Request)
  * `PUT /book/update`
    * Sample Request: `curl --location --request PUT 'https://nobug-teamproject.herokuapp.com/book/update?bookID=2&bookName=test'`
    * Request Parameters:
      * `bookID` int(Required)
      * `bookName` String(Not necessarily)
      * `category` String(Not necessarily)
    * Instruction:
      * Update the `bookName` of a specific `bookID`
      * Update the `category` of a specific `bookID`
    * Responses:
      * ```
          {
              "bookID": 1162,
              "bookName": "Applied Human Anatomy",
              "category": "textbook"
          }
    * Error Message:
      * `Book Not Found` (HTTP Status 404 Not Found)
      * `Failed` (HTTP Status 400 Bad Request)

* ___Rating___
  * `GET /rating/get`
    * Sample Request: `curl --location --request GET 'https://nobug-teamproject.herokuapp.com/rating/get?bookID=2'`
    * Request Parameters:
      * `bookID` int(Required)
    * Instruction:
      * Get rating by `bookID`
    * Responses: `4.2`
    * Error Message:
      * `Book Not Found` (HTTP Status 404 Not Found)
      * `Rating Not Found` (HTTP Status 404 Not Found)
      * `Failed` (HTTP Status 400 Bad Request)
  * `DELETE /rating/delete`
    * Sample Request: `curl --location --request DELETE 'https://nobug-teamproject.herokuapp.com/rating/delete?ratingID=44'`
    * Request Parameters:
      * `ratingID` int(Required)
    * Instruction:
      * Delete rating by `ratingID`
    * Responses: `Deleted`
    * Error Message:
      * `RatingID Not Found` (HTTP Status 404 Not Found)
      * `Failed` (HTTP Status 400 Bad Request)
  * `POST /rating/add`
    * Sample Request: `curl --location --request POST 'https://nobug-teamproject.herokuapp.com/rating/add?bookID=2&rating=5'`
    * Request Parameters:
      * `bookID` int(Required)
      * `rating` int(Required)
    * Instruction:
      * Add a `rating` for `bookID`
    * Responses: `Rating Added, RatingID: 1792`
    * Error Message:
      * `Book Not Found` (HTTP Status 404 Not Found)
      * `Failed` (HTTP Status 400 Bad Request)
  * `PUT /rating/update`
    * Sample Request: `curl --location --request PUT 'https://nobug-teamproject.herokuapp.com/rating/update?ratingID=44&rating=1'`
    * Request Parameters:
      * `ratingID` int(Required)
      * `rating` int(Required)
    * Instruction:
      * Update `rating` of `ratingID`
    * Responses: `Updated`
    * Error Message:
      * `RatingID Not Found` (HTTP Status 404 Not Found)
      * `Failed` (HTTP Status 400 Bad Request)

* ___BookList___
  * `GET /booklist/get/name`
    * Sample Request: `curl --location --request GET 'https://nobug-teamproject.herokuapp.com/booklist/get/name?bookListID=22'`
    * Request Parameters:
      * `bookListID` int(Required)
    * Instruction:
      * Get name of `bookListID`
    * Responses:
      * ```
          {
              "bookListID": 2,
              "bookListName": "test5"
          }
    * Error Message:
      * `BookList Not Found` (HTTP Status 404 Not Found)
      * `Failed` (HTTP Status 400 Bad Request)
  * `GET /booklist/get/book`
    * Sample Request: `curl --location --request GET 'https://nobug-teamproject.herokuapp.com/booklist/get/book?bookListID=22'`
    * Request Parameters:
      * `bookListID` int(Required)
    * Instruction:
      * Get all Books in `bookListID`
    * Responses:
      * ```
          [
              {
                  "bookID": 652,
                  "bookName": "Principles of Microeconomics Scarcity and Social Provisioning",
                  "category": "textbook"
              },
              {
                  "bookID": 789,
                  "bookName": "Business Computers 365",
                  "category": "textbook"
              }
          ]
    * Error Message:
      * `BookList Not Found` (HTTP Status 404 Not Found)
      * `BookList Empty` (HTTP Status 200 OK)
      * `Failed` (HTTP Status 400 Bad Request)
  * `DELETE /booklist/delete`
    * Sample Request: `curl --location --request DELETE 'https://nobug-teamproject.herokuapp.com/booklist/delete?bookListID=6&bookID=482'`
    * Request Parameters:
      * `bookListID` int(Required)
      * `bookID` int(Not necessarily)
    * Instruction:
      * Delete `bookID` in `bookListID`
      * Delete the whole `bookListID`
    * Responses: `Deleted`
    * Error Message:
      * `BookList Not Found` (HTTP Status 404 Not Found)
      * `Book Not Found` (HTTP Status 404 Not Found)
      * `Failed` (HTTP Status 400 Bad Request)
  * `POST /booklist/add`
    * Sample Request: `curl --location --request POST 'https://nobug-teamproject.herokuapp.com/booklist/add?bookListID=6&bookID=482'`
    * Request Parameters:
      * `bookListID` int(Not necessarily)
      * `bookID` int(Not necessarily)
      * `bookListName` String(Not necessarily)
    * Instruction:
      * Add a new booklist with `bookListName`
      * Add a `bookID` into booklist `bookListID`
    * Responses:
      * `BookList Added, BookList ID: 17`
      * `Book Added to Booklist`
    * Error Message:
      * `BookList Not Found` (HTTP Status 404 Not Found)
      * `Book Not Found` (HTTP Status 404 Not Found)
      * `Failed` (HTTP Status 400 Bad Request)
  * `PUT /booklist/update`
    * Sample Request: `curl --location --request PUT 'https://nobug-teamproject.herokuapp.com/booklist/update?bookListID=6&bookListName=test2116'`
    * Request Parameters:
      * `bookListID` int(Required)
      * `bookListName` String(Required)
    * Instruction:
      * Update `bookListName` of `bookListID`
    * Responses: `BookList Updated`
    * Error Message:
      * `BookList Not Found` (HTTP Status 404 Not Found)
      * `Failed` (HTTP Status 400 Bad Request)

## 2. Build, Run, Test Instructions

JDK version : OpenJDK 1.8.0

* First clone our GitHub repository
  * `git clone https://github.com/Fay06/nobug_teamproject.git`
* Check local maven environment
  * `mvn -v` (If you have not installed maven, use `sudo apt-get install maven` to install)
* Change directory to project folder
  * `cd ./nobug_teamproject`
* Install dependencies and build
  * `mvn install`
* Run the application
  * `mvn spring-boot:run`
* Run test
  * Manual Test: 
    * nobug_teamproject/src/test/java/com/nobug/nobug_teamproject/ProjectApplicationTests.java 
  * Unit Test: 
    * nobug_teamproject/src/test/java/com/nobug/nobug_teamproject/unit
  * System Test: 
    * https://documenter.getpostman.com/view/23968342/2s8YsxvBoe
  * Integration Test:
    * nobug_teamproject/src/test/java/com/nobug/nobug_teamproject/service
  * End-to-end Test:
    * For valid token: 
      * If we input existing book name, book id or book category, we expect the related value {bookID, bookName, category} returned from the database;
        * e.g. localhost:80/book/get?bookID=2
      * Test a book's rating, and we expect the related value {ratingID, bookID, rating} returned from the database;
        * e.g. localhost:80/rating/get?bookID=2
      * Test all books under a booklist, and we expect a list of books returned from the database;
        * e.g. localhost:80/rating/get?bookID=2get/book?bookListID=6
      * If we input non-existing booklist id, we expect error message.
        * e.g. localhost:80/booklist/get/name?bookListID=0

    * For invalid token: no matter what we input, we expect "This token is invalid!"

## 3. StyleChecker

* We use SonarLint for style checker, and below are the analysis after running under /src/
<img width="800" alt="截屏2022-11-28 下午7 36 22" src="https://user-images.githubusercontent.com/37780284/204409758-09914eb4-4f5b-486f-838e-bd4e6fccc240.png">

## 4. Sample Client Page

* We have implemented three sample client pages: 
  * valid token: https://nobug.retool.com/embedded/public/776b48c5-a3ff-49a7-80cf-22baab79a25c
  * valid token: https://nobug.retool.com/embedded/public/b0d803f8-e79c-45d3-a801-3e6da43a10ed
  * invalid token: https://nobug.retool.com/embedded/public/ffcee06e-19cf-41fd-88ef-4d9b757dd291

## 5. Continuous Integration

* We used CircleCI: https://app.circleci.com/pipelines/github/Fay06
* Example report:
<img width="800" alt="截屏2022-11-28 下午8 58 06" src="https://user-images.githubusercontent.com/37780284/204419707-f9a5c429-1648-40ff-8b01-a5d98d71977f.png">

## 6. Static Analysis Bug Finder
* We use SpotBugs for static analysis bug finder, and below are the analysis after running under /src/main

<img width="800" alt="截屏2022-11-28 下午8 50 32" src="https://user-images.githubusercontent.com/37780284/204418814-367d8787-e247-416b-952a-bcfede87c41b.png">

