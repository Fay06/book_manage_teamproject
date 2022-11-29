package com.nobug.nobug_teamproject.controller;

import com.nobug.nobug_teamproject.models.Book;
import com.nobug.nobug_teamproject.models.BookList;
import com.nobug.nobug_teamproject.service.BookListService;
import com.nobug.nobug_teamproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/booklist")
public class BookListController {
    @Autowired
    private BookListService bookListService;
    @Autowired
    private BookService bookService;

    private String booklistNotFound = "BookList Not Found";

    @GetMapping("get/name")
    public ResponseEntity<Object> getBookList(@RequestParam(value = "bookListID", required = true) Integer bookListID){
        BookList result = bookListService.getBookList(bookListID);
        if (result == null) {
            return new ResponseEntity<>(booklistNotFound, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("get/book")
    public ResponseEntity<Object> getBooksFromBookList(@RequestParam(value = "bookListID", required = true) Integer bookListID){
        BookList temp = bookListService.getBookList(bookListID);
        List<Book> result = bookListService.getBooksFromBookList(bookListID);
        if (temp == null) {
            return new ResponseEntity<>(booklistNotFound, HttpStatus.NOT_FOUND);
        } else if (result.isEmpty()) {
            return new ResponseEntity<>("BookList Empty", HttpStatus.OK);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<Object> add(@RequestParam(value = "bookListName", required = false) String bookListName,
                                 @RequestParam(value = "bookListID", required = false) Integer bookListID,
                                 @RequestParam(value = "bookID", required = false) Integer bookID){
        if (bookListName != null){
            int bookListId = bookListService.addBookList(bookListName);
            String message = "BookList Added, BookList ID: " + bookListId;
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else if (bookListID != null && bookID != null) {
            List<Book> book = bookService.getBookId(bookID);
            BookList booklist = bookListService.getBookList(bookListID);
            if (book == null || book.isEmpty()){
                return new ResponseEntity<>("Book Not Found", HttpStatus.NOT_FOUND);
            } else if (booklist == null) {
                return new ResponseEntity<>(booklistNotFound, HttpStatus.NOT_FOUND);
            }
            bookListService.addBookToBookList(bookID, bookListID);
        }

        return new ResponseEntity<>("Book Added to Booklist",HttpStatus.OK);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Object> delete(@RequestParam(value = "bookListID", required = true) Integer bookListID,
                                    @RequestParam(value = "bookID", required = false) Integer bookID){
        BookList booklist = bookListService.getBookList(bookListID);
        if (bookID != null && bookListID != null) {
            List<Book> book = bookService.getBookId(bookID);
            if (book == null || book.isEmpty()){
                return new ResponseEntity<>("Book Not Found", HttpStatus.NOT_FOUND);
            } else if (booklist == null) {
                return new ResponseEntity<>(booklistNotFound, HttpStatus.NOT_FOUND);
            }
            bookListService.removeBookFromBookList(bookID, bookListID);
        } else if (bookListID != null) {
            if (booklist == null) {
                return new ResponseEntity<>(booklistNotFound, HttpStatus.NOT_FOUND);
            } else bookListService.deleteBookList(bookListID);
        }
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity<Object> updateBookListName(@RequestParam(value = "bookListID", required = true) Integer bookListID,
                                                @RequestParam(value = "bookListName", required = true) String bookListName){
        BookList result = bookListService.getBookList(bookListID);
        if (result == null) {
            return new ResponseEntity<>(booklistNotFound, HttpStatus.NOT_FOUND);
        }
        bookListService.updateBookListName(bookListID, bookListName);
        return new ResponseEntity<>("BookList Updated", HttpStatus.OK);
    }

}
