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
    public ResponseEntity<Object> getBook(@RequestParam(value = "bookID", required = false) Integer bookID,
                                          @RequestParam(value = "bookName", required = false) String bookName,
                                          @RequestParam(value = "category", required = false) String category,
                                          @RequestParam(value = "size", required = false) Integer size){
        List<Book> result = null;

        // Check if size parameter is null & is valid
        if (size == null){
            size = 20;
        } else if (size <= 0) {
            return new ResponseEntity<>("Invalid Parameter: Size", HttpStatus.BAD_REQUEST);
        }

        // Determine which specific function to use according to the input parameters
        if (bookID != null){
            result = bookService.getBookId(bookID);
            if (result == null || result.isEmpty()){
                return new ResponseEntity<>("BookID Not Found", HttpStatus.NOT_FOUND);
            }
        } else if (bookName != null){
            result =  bookService.searchBook(bookName);
            if (result == null || result.isEmpty()){
                return new ResponseEntity<>("BookName Not Found", HttpStatus.NOT_FOUND);
            }
            if (result.size() > size){
                result = result.subList(0,size);
            }
        } else if (category != null){
            result =  bookService.searchCategory(category);
            if (result == null || result.isEmpty()){
                return new ResponseEntity<>("Category Not Found", HttpStatus.NOT_FOUND);
            }
            if (result.size() > size){
                result = result.subList(0,size);
            }
        }else{
            result = bookService.allBook();
            if (result.size() > size){
                result = result.subList(0,size);
            }
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Object> deleteBookId(@RequestParam(value = "bookID", required = true) Integer bookID) {
        List<Book> result = bookService.getBookId(bookID);
        if (result == null || result.isEmpty()) {
            return new ResponseEntity<>("Book Not Found", HttpStatus.NOT_FOUND);
        } else bookService.deleteBookId(bookID);
        return new ResponseEntity<>("Book Deleted", HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<Object> addBook(@RequestParam(value = "bookName", required = true) String bookName,
                                     @RequestParam(value = "category", required = true) String category) {
        int bookId = bookService.addBook(bookName, category);
        String message = "Book Added, Book ID: " + bookId;
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity<Object> updateBook(@RequestParam(value = "bookID", required = true) Integer bookID,
                                        @RequestParam(value = "bookName", required = true) String bookName,
                                        @RequestParam(value = "category", required = true) String category){
        List<Book> result = bookService.getBookId(bookID);
        if (result == null || result.isEmpty()){
            return new ResponseEntity<>("Book Not Found", HttpStatus.NOT_FOUND);
        } else {
            bookService.updateBookName(bookID, bookName);
            bookService.updateCategory(bookID, category);
        }
        return new ResponseEntity<>(bookService.getBookId(bookID),HttpStatus.OK);
    }

}
