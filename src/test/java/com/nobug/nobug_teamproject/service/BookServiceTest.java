package com.nobug.nobug_teamproject.service;

import com.nobug.nobug_teamproject.models.Book;
import com.nobug.nobug_teamproject.models.BookList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookServiceTest {

    @Autowired
    BookService bookService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void searchBook() {
        List<Book> books = bookService.searchBook("Leading Innovation");
        boolean found = false;
        for (int i = 0; i < books.size(); i++)
        {
            if (1117 == books.get(i).getBookID()) {
                found = true;
            }
        }
        assertTrue(found);
    }

    @Test
    void searchCategory() {
        List<Book> books = bookService.searchCategory("textbook");
        boolean found = false;
        if (books.get(0).getCategory() != null) {
            found = true;
        }
        assertTrue(found);
    }

    @Test
    void getBookId() {
        List<Book> books = bookService.getBookId(1117);
        boolean found = false;
        for (int i = 0; i < books.size(); i++)
        {
            if (1117 == books.get(i).getBookID()) {
                found = true;
            }
        }
        assertTrue(found);
    }

    @Test
    void deleteBookId() {
        bookService.deleteBookId(1117);
        List<Book> searchResult = bookService.getBookId(1117);
        List<Book> expectResult = new ArrayList<>();
        assertEquals(expectResult, searchResult);
    }

    @Test
    void addBook() {
        bookService.addBook("unit test", "unit test");
        List<Book> books = bookService.searchBook("unit test");
        boolean found = false;
        for (int i = 0; i < books.size(); i++)
        {
            if (books.get(i).getBookName().equals("unit test")) {
                found = true;
            }
        }
        assertTrue(found);
    }

    @Test
    void updateBookName() {
    }

    @Test
    void updateCategory() {
    }
}