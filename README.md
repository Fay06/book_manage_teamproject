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
    * Sample Request: `curl --location --request GET 'https://nobug-teamproject.herokuapp.com/book/get?bookID=123'`
    * Request Parameters:
      * `bookID` int(Not necessarily)
      * `bookName` String(Not necessarily)
      * `category` String(Not necessarily)
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
  * `DELETE /book/delete`
    * Sample Request: https://nobug-teamproject.herokuapp.com/book/delete?bookID=123
    * Request Parameters:
      * `bookID` int(Required)
  * `POST /book/add`
    * Sample Request: https://nobug-teamproject.herokuapp.com/book/add?bookName=test&category=test
    * Request Parameters:
      * `bookName` String(Required)
      * `category` String(Required)
  * `PUT /book/update`
    * Sample Request: https://nobug-teamproject.herokuapp.com/book/update?bookID=123&bookName=test
    * Request Parameters:
      * `bookID` int(Required)
      * `bookName` String(Not necessarily)
      * `category` String(Not necessarily)

* ___Rating___
  * `GET /rating/get`
    * Sample Request: https://nobug-teamproject.herokuapp.com/rating/get?bookID=123
    * Request Parameters:
      * `bookID` int(Required)
  * `DELETE /rating/delete`
    * Sample Request: https://nobug-teamproject.herokuapp.com/rating/delete?ratingID=11
    * Request Parameters:
      * `ratingID` int(Required)
  * `POST /rating/add`
    * Sample Request: https://nobug-teamproject.herokuapp.com/rating/add?bookID=123&rating=5
    * Request Parameters:
      * `bookID` int(Required)
      * `rating` int(Required)
  * `PUT /rating/update`
    * Sample Request: https://nobug-teamproject.herokuapp.com/rating/update?ratingID=11&rating=1
    * Request Parameters:
      * `ratingID` int(Required)
      * `rating` int(Required)

* ___BookList___
  * `GET /booklist/get/name`
    * Sample Request: https://nobug-teamproject.herokuapp.com/booklist/get/name?bookListID=2
    * Request Parameters:
      * `bookListID` int(Required)
  * `GET /booklist/get/book`
    * Sample Request: https://nobug-teamproject.herokuapp.com/booklist/get/book?bookListID=2
    * Request Parameters:
      * `bookListID` int(Required)
  * `DELETE /booklist/delete`
    * Sample Request: https://nobug-teamproject.herokuapp.com/booklist/delete?bookListID=6&bookID=123
    * Request Parameters:
      * `bookListID` int(Required)
      * `bookID` int(Not necessarily)
  * `POST /booklist/add`
    * Sample Request: https://nobug-teamproject.herokuapp.com/booklist/add?bookListID=6&bookID=789
    * Request Parameters:
      * `bookListID` int(Not necessarily)
      * `bookID` int(Not necessarily)
      * `bookListName` String(Not necessarily)
  * `PUT /booklist/update`
    * Sample Request: https://nobug-teamproject.herokuapp.com/booklist/update?bookListID=6&bookListName=test2116
    * Request Parameters:
      * `bookListID` int(Required)
      * `bookListName` String(Required)

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
    * For valid token: if we input existing book name, book id or book category, we expect the related value from the database; if we input non-existing book name, book id or book category, we expect error message
    * For invalid token: no matter what we input, we expect "This token is invalid!"

## 3. StyleChecker

* We use SonarLint for style checker, and below are the analysis after running under /src/main
<img width="800" alt="Screen Shot 2022-10-24 at 11 11 18 PM" src="https://user-images.githubusercontent.com/37780284/197674011-8a28f9d8-e296-4ae5-a3c3-8e8624d003ae.png">

## 4. Sample Client Page

* We have implemented three sample client pages: 
  * valid token: https://nobug.retool.com/embedded/public/776b48c5-a3ff-49a7-80cf-22baab79a25c
  * valid token: https://nobug.retool.com/embedded/public/b0d803f8-e79c-45d3-a801-3e6da43a10ed
  * invalid token: https://nobug.retool.com/embedded/public/ffcee06e-19cf-41fd-88ef-4d9b757dd291

## 5. Continuous Integration

* We used CircleCI: https://github.com/Fay06/nobug_teamproject/tree/circleci-project-setup

