package com.nobug.nobug_teamproject.controller;

import com.nobug.nobug_teamproject.models.Book;
import com.nobug.nobug_teamproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("get")
    public ResponseEntity<?> getBook(@RequestParam(value = "bookID", required = false) Integer bookID,
                              @RequestParam(value = "bookName", required = false) String bookName,
                              @RequestParam(value = "category", required = false) String category){
        List<Book> result = null;
        if (bookID != null){
            result = bookService.getBookId(bookID);
        } else if (bookName != null){
            result =  bookService.searchBook(bookName);
        } else if (category != null){
            result =  bookService.searchCategory(category);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> deleteBookId(@RequestParam(value = "bookID", required = true) Integer bookID) {
        bookService.deleteBookId(bookID);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<?> addBook(@RequestParam(value = "bookName", required = true) String bookName,
                                     @RequestParam(value = "category", required = true) String category) {
        bookService.addBook(bookName, category);
        return new ResponseEntity<>(bookService.searchBook(bookName),HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity<?> updateBook(@RequestParam(value = "bookID", required = true) Integer bookID,
                                        @RequestParam(value = "bookName", required = true) String bookName,
                                        @RequestParam(value = "category", required = true) String category){
        bookService.updateBookName(bookID, bookName);
        bookService.updateCategory(bookID, category);
        return new ResponseEntity<>(bookService.getBookId(bookID),HttpStatus.OK);
    }

}
