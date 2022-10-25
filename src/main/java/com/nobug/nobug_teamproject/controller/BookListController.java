package com.nobug.nobug_teamproject.controller;

import com.nobug.nobug_teamproject.models.Book;
import com.nobug.nobug_teamproject.models.BookList;
import com.nobug.nobug_teamproject.service.BookListService;
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

    @GetMapping("get/name")
    public ResponseEntity<?> getBookList(@RequestParam(value = "bookListID", required = true) Integer bookListID){
        return new ResponseEntity<>(bookListService.getBookList(bookListID), HttpStatus.OK);
    }

    @GetMapping("get/book")
    public ResponseEntity<?> getBooksFromBookList(@RequestParam(value = "bookListID", required = true) Integer bookListID){
        return new ResponseEntity<>(bookListService.getBooksFromBookList(bookListID), HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@RequestParam(value = "bookListName", required = false) String bookListName,
                                 @RequestParam(value = "bookListID", required = false) Integer bookListID,
                                 @RequestParam(value = "bookID", required = false) Integer bookID){
        if (bookListName != null){
            bookListService.addBookList(bookListName);
        } else if (bookListID != null && bookID != null) {
            bookListService.addBookToBookList(bookID, bookListID);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> delete(@RequestParam(value = "bookListID", required = true) Integer bookListID,
                                    @RequestParam(value = "bookID", required = false) Integer bookID){
        if (bookID != null && bookListID != null) {
            bookListService.removeBookFromBookList(bookID, bookListID);
        } else if (bookListID != null) {
            bookListService.deleteBookList(bookListID);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity<?> updateBookListName(@RequestParam(value = "bookListID", required = true) Integer bookListID,
                                                @RequestParam(value = "bookListName", required = true) String bookListName){
        bookListService.updateBookListName(bookListID, bookListName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
