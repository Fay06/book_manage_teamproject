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
  * System/API Test: 
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
        * e.g. localhost:80/booklist/get/book?bookListID=6
      * If we input non-existing booklist id, we expect error message.
        * e.g. localhost:80/booklist/get/name?bookListID=0

    * For invalid token: no matter what we input, we expect "This token is invalid!"

## 3. StyleChecker

* We use SonarLint for style checker, and below are the analysis after running under /src/
<img width="800" alt="截屏2022-11-28 下午7 36 22" src="https://user-images.githubusercontent.com/37780284/204409758-09914eb4-4f5b-486f-838e-bd4e6fccc240.png">

## 4. Client
* We use Retool to develop client
  * With Retool, we created various components, e.g. Text, Button, etc. 
  * We wrote different queries(e.g. findbybookid, findbybookname, etc) linked with components, and each query can call into our service with its REST request and header. We can get the corresponding response and result code. According to the response or result, we can show in our client components(e.g. table) or call other handlers. 
  * We can add authorized token for clients in queires' "Header Authorization" (attached example below)
  * Reference for retool develop guide: https://docs.retool.com/docs
  * Example developing process:
<img width="800" alt="截屏2022-12-08 上午1 14 31" src="https://user-images.githubusercontent.com/37780284/206373675-9ac5bed9-270e-43f3-b8d0-1dfaf8c2c17f.png">



* We have implemented below sample client pages: 
  * valid token1: （diff client instances using the same token)
      * https://nobug.retool.com/embedded/public/776b48c5-a3ff-49a7-80cf-22baab79a25c
      * https://nobug.retool.com/embedded/public/51283910-8a1e-4a4e-a5ee-9a416f7aa6d3
  * valid token2: (another client using another valid token)
      * https://nobug.retool.com/embedded/public/259de960-9886-410d-9a2a-3af002d9c816
  * invalid token: 
      * https://nobug.retool.com/embedded/public/471b1da1-994a-4c8d-9352-b042e032d6a1

## 5. Continuous Integration

* We used CircleCI: https://app.circleci.com/pipelines/github/Fay06
* Example whole CI report:
<img width="800" alt="截屏2022-12-06 下午5 16 11" src="https://user-images.githubusercontent.com/37780284/206036189-a20b7d15-c3f4-43e8-9538-a49c4f723b50.png">
* Our CI automatically runs unit, integration, API tests. You can find their reports on "Run Tests" section in the CI report. Example test CI report:
<img width="800" alt="截屏2022-12-09 上午12 28 32" src="https://user-images.githubusercontent.com/37780284/206630975-8f052ed6-815a-47b9-81f5-7f1ce84c5270.png">




## 6. Static Analysis Bug Finder
* We use SpotBugs for static analysis bug finder, and below are the analysis after running under /src/main

<img width="800" alt="截屏2022-11-28 下午8 50 32" src="https://user-images.githubusercontent.com/37780284/204418814-367d8787-e247-416b-952a-bcfede87c41b.png">

