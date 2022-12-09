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
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.JVM)
public class AddNewBookToBookListTest {
    @Autowired
    BookListService bookListService;
    @Autowired
    BookService bookService;

    private static int bookListID;
    private static int bookID;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void addNewBook() {
        this.bookID = bookService.addBook("New Book", "testbook");
        List<Book> books = bookService.getBookId(bookID);
        boolean found = false;
        for (int i = 0; i < books.size(); i++)
        {
            if (books.get(i).getBookName().equals("New Book")) {
                found = true;
            }
        }
        assertTrue(found);
    }

    @Test
    public void addNewBookList() {
        this.bookListID = bookListService.addBookList("New BookList");
        String name = bookListService.getBookList(bookListID).getBookListName();
        assertEquals("New BookList", name);
    }

    @Test
    public void addNewBookToBookList() {
        bookListService.addBookToBookList(this.bookID, this.bookListID);
        List<Book> books = bookListService.getBooksFromBookList(bookListID);
        boolean found = false;
        for (int i = 0; i < books.size(); i++)
        {
            if (bookID == books.get(i).getBookID()) {
                found = true;
            }
        }
        assertTrue(found);
    }

    @Test
    public void deleteNewBook() {
        bookService.deleteBookId(this.bookID);
        System.out.print(this.bookID);
        List<Book> searchResult = bookService.getBookId(bookID);
        List<Book> expectResult = new ArrayList<>();
        assertEquals(expectResult, searchResult);
    }

    @Test
    public void deleteNewBookList() {
        bookListService.deleteBookList(this.bookListID);
        System.out.print(this.bookListID);
        BookList booklist = bookListService.getBookList(bookListID);
        assertNull(booklist);
    }

}