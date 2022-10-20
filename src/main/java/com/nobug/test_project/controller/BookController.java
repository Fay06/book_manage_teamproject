package com.nobug.test_project.controller;

import com.nobug.test_project.models.Book;
import com.nobug.test_project.service.BookService;
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

//    @RequestMapping("/helloworld")
//    public String helloWorld(){
//        return "Hello World!";
//    }

    @GetMapping ("/search/{bookName}")
    public Book searchBook(@PathVariable("bookName") String bookName){
        return bookService.searchBook(bookName);
    }

    @GetMapping("searchCategory/{category}")
    public List<Book> searchCategory(@PathVariable("category") String category) { return bookService.searchCategory(category); }
}
