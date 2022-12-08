package com.nobug.nobug_teamproject.service;

import com.nobug.nobug_teamproject.models.Book;
import com.nobug.nobug_teamproject.models.BookList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookListServiceTest {
    @Autowired
    BookListService bookListService;
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void getBookList() {
        String name = bookListService.getBookList(3).getBookListName();
        assertEquals("my_wishlist", name);
    }

    @Test
    @Transactional
    public void deleteBookList() {
        bookListService.deleteBookList(7);
        BookList booklist = bookListService.getBookList(7);
        assertNull(booklist);
    }

    @Test
    @Transactional
    public void addBookList() {
        int bookListID = bookListService.addBookList("int test");
        String name = bookListService.getBookList(bookListID).getBookListName();
        assertEquals("int test", name);
    }

    @Test
    @Transactional
    public void updateBookListName() {
        bookListService.updateBookListName(7, "hellooo");
        String name = bookListService.getBookList(7).getBookListName();
        assertEquals("hellooo", name);
    }

    @Test
    @Transactional
    public void addBookToBookList() {
        bookListService.addBookToBookList(2, 7);
        List<Book> books = bookListService.getBooksFromBookList(7);
        boolean found = false;
        for (int i = 0; i < books.size(); i++)
        {
            if (2 == books.get(i).getBookID()) {
                found = true;
            }
        }
        assertTrue(found);
    }

    @Test
    @Transactional
    public void removeBookFromBookList() {
        bookListService.removeBookFromBookList(981, 6);
        List<Book> books = bookListService.getBooksFromBookList(6);
        boolean found = false;
        for (int i = 0; i < books.size(); i++)
        {
            if (1011 == books.get(i).getBookID()) {
                found = true;
            }
        }
        assertFalse(found);
    }

    @Test
    public void getBooksFromBookList() {
        List<Book> books = bookListService.getBooksFromBookList(6);
        assertNotEquals(0, books.size());
    }
}