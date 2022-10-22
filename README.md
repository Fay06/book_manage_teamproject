# Nobug Team Project

## 1. Documented API

#### Sample Request: localhost:8081/...

Book:

* /search/{bookName}

* /searchCategory/{category}

* /getBookId/{bookID}

* /deleteBookId/{bookID}

* /addBook/{bookName}/{category}

* /updateBookName/{bookID}/{bookName}

* /updateCategory/{bookID}/{category}

Rating:

* /searchRating/{bookID}

* /addRating/{bookID}/{rating}

* /deleteRating/{ratingID}

* /updateRating/{ratingID}/{rating}

BookList:

* /getBookList/{bookListID}

* /deleteBookList/{bookListID}

* /addBookList/{bookListName}

* /updateBookListName/{bookListID}/{bookListName}

* /addBookToBookList/{bookListID}/{bookID}

* /removeBookFromBookList/{bookListID}/{bookID}

* /getBooksFromBookList/{bookListID}

## 2. Build, Run, Test Instructions