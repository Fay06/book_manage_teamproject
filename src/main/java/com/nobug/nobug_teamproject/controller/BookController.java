package com.nobug.nobug_teamproject.controller;

import com.nobug.nobug_teamproject.models.Book;
import com.nobug.nobug_teamproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("get")
    public List<Book> getBook(@RequestParam(value = "bookID", required = false) Integer bookID,
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
        return result;
    }

//    @GetMapping ("/search/{bookName}")
//    public Book searchBook(@PathVariable("bookName") String bookName){
//        return bookService.searchBook(bookName);
//    }
//
//    @GetMapping("searchCategory/{category}")
//    public List<Book> searchCategory(@PathVariable("category") String category) { return bookService.searchCategory(category); }
//
//    @GetMapping("get/{bookID}")
//    public Book getBookId(@PathVariable("bookID") int bookID) { return bookService.getBookId(bookID); }

    @GetMapping("deleteBookId/{bookID}")
    public void deleteBookId(@PathVariable("bookID") int bookID) { bookService.deleteBookId(bookID); }

    @GetMapping("addBook/{bookName}/{category}")
    public void addBook(@PathVariable("bookName") String bookName, @PathVariable("category") String category) { bookService.addBook(bookName, category); }

    @GetMapping("updateBookName/{bookID}/{bookName}")
    public void updateBookName(@PathVariable("bookID") int bookID, @PathVariable("bookName") String bookName) { bookService.updateBookName(bookID, bookName); }

    @GetMapping("updateCategory/{bookID}/{category}")
    public void updateCategory(@PathVariable("bookID") int bookID, @PathVariable("category") String category) { bookService.updateCategory(bookID, category); }
}
