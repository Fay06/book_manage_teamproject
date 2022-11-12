package com.nobug.nobug_teamproject.service;

import com.nobug.nobug_teamproject.models.Book;
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
        List<Book> expectResult = new ArrayList<>();
        List<Book> searchResult = bookService.searchBook("unit test");
        assertEquals(expectResult, searchResult);
    }

    @Test
    void searchCategory() {
        List<Book> expectResult = new ArrayList<>();
        List<Book> searchResult = bookService.searchCategory("unit test");
        assertEquals(expectResult, searchResult);
    }

    @Test
    void getBookId() {
        List<Book> expectResult = new ArrayList<>();
        List<Book> searchResult = bookService.getBookId(123);
        assertEquals(expectResult, searchResult);
    }

    @Test
    void deleteBookId() {
    }

    @Test
    void addBook() {
    }

    @Test
    void updateBookName() {
    }

    @Test
    void updateCategory() {
    }
}