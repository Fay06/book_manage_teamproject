package com.nobug.nobug_teamproject.controller;

import com.nobug.nobug_teamproject.models.Book;
import com.nobug.nobug_teamproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping ("/search/{bookName}")
    public Book searchBook(@PathVariable("bookName") String bookName){
        return bookService.searchBook(bookName);
    }

    @GetMapping("searchCategory/{category}")
    public List<Book> searchCategory(@PathVariable("category") String category) { return bookService.searchCategory(category); }

    @GetMapping("getBookId/{bookID}")
    public Book getBookId(@PathVariable("bookID") int bookID) { return bookService.getBookId(bookID); }

    @GetMapping("deleteBookId/{bookID}")
    public void deleteBookId(@PathVariable("bookID") int bookID) { bookService.deleteBookId(bookID); }

    @GetMapping("addBook/{bookName}/{category}")
    public Book addBook(@PathVariable("bookName") String bookName, @PathVariable("category") String category) { return bookService.addBook(bookName, category); }
}
