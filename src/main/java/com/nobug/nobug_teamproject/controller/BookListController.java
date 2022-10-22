package com.nobug.nobug_teamproject.controller;

import com.nobug.nobug_teamproject.models.Book;
import com.nobug.nobug_teamproject.models.BookList;
import com.nobug.nobug_teamproject.service.BookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookListController {
    @Autowired
    private BookListService bookListService;

    @GetMapping("getBookList/{bookListID}")
    public BookList getBookList(@PathVariable("bookListID") int bookListID) { return bookListService.getBookList(bookListID); }

    @GetMapping("deleteBookList/{bookListID}")
    public void deleteBookList(@PathVariable("bookListID") int bookListID) { bookListService.deleteBookList(bookListID); }

    @GetMapping("addBookList/{bookListName}")
    public void addBookList(@PathVariable("bookListName") String bookListName) { bookListService.addBookList(bookListName); }

    @GetMapping("updateBookListName/{bookListID}/{bookListName}")
    public void updateBookListName(@PathVariable("bookListID") int bookListID, @PathVariable("bookListName") String bookListName) { bookListService.updateBookListName(bookListID, bookListName); }

    @GetMapping("addBookToBookList/{bookListID}/{bookID}")
    public void addBookToBookList(@PathVariable("bookListID") int bookListID, @PathVariable("bookID") int bookID) { bookListService.addBookToBookList(bookID, bookListID); }

    @GetMapping("removeBookFromBookList/{bookListID}/{bookID}")
    public void removeBookFromBookList(@PathVariable("bookListID") int bookListID, @PathVariable("bookID") int bookID) { bookListService.removeBookFromBookList(bookID, bookListID); }

    @GetMapping("getBooksFromBookList/{bookListID}")
    public List<Book> getBooksFromBookList(@PathVariable("bookListID") int bookListID) { return bookListService.getBooksFromBookList(bookListID); }
}
