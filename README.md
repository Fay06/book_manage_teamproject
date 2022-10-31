# Nobug Team Project

* Team Member:\
Yufei Liu yl5099\
Hongxuan Chen hc3275\
Chenyue Wang cw3444\
Chang Gao cg3320

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
![1](https://user-images.githubusercontent.com/24384014/197678567-d579117a-01b8-40cb-b14d-f3114a02627e.png)
![2](https://user-images.githubusercontent.com/24384014/197678585-13d4a115-0f50-4b8c-af20-0b448fe775a0.png)
![3](https://user-images.githubusercontent.com/24384014/197678589-a6d56228-94f6-4570-bef8-8792bf31dd7e.png)

## 3. StyleChecker

* We use SonarLint for style checker, and below are the analysis after running under /src/main
<img width="1418" alt="Screen Shot 2022-10-24 at 11 11 18 PM" src="https://user-images.githubusercontent.com/37780284/197674011-8a28f9d8-e296-4ae5-a3c3-8e8624d003ae.png">
