# Nobug Team Project

## 1. Documented API

#### Sample Request: localhost:8081/...

* Book:

  - /search/{bookName}

  - /searchCategory/{category}

  - /getBookId/{bookID}

  - /deleteBookId/{bookID}

  - /addBook/{bookName}/{category}

  - /updateBookName/{bookID}/{bookName}

  - /updateCategory/{bookID}/{category}

* Rating:

  - /searchRating/{bookID}

  - /addRating/{bookID}/{rating}

  - /deleteRating/{ratingID}

  - /updateRating/{ratingID}/{rating}

* BookList:

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
