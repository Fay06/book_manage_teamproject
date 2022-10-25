# Nobug Team Project
*(We have deployed this application to heroku, link: `https://nobug-teamproject.herokuapp.com/`)*
## 1. Documented API

* ___Books___
  * `GET /book/get`
    * Sample Request: https://nobug-teamproject.herokuapp.com/book/get?bookID=123
    * Request Parameters:
      * `bookID` int(Not necessarily)
      * `bookName` String(Not necessarily)
      * `category` String(Not necessarily)
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
      * `bookListID` int(Required)
      * `bookID` int(Not necessarily)
      * `bookListName` String(Not necessarily)
  * `PUT /booklist/update`
    * Sample Request: https://nobug-teamproject.herokuapp.com/booklist/update?bookListID=6&bookListName=test2116
    * Request Parameters:
      * `bookListID` int(Required)
      * `bookListName` String(Required)

## 2. Build, Run, Test Instructions

* First clone our GitHub repository
  * `git clone https://github.com/Fay06/nobug_teamproject.git`
* Check local maven environment
  * `mvn -v` (Our Java version is 11, if you have not installed maven, use `sudo apt-get install maven` to install)
* Change directory to project folder
  * `cd ./nobug_teamproject`
* Install dependencies and build
  * `mvn install`
* Run the application
  * `mvn spring-boot:run`
