package com.nobug.nobug_teamproject.unit;

import com.nobug.nobug_teamproject.mapper.BookListMapper;
import com.nobug.nobug_teamproject.models.Book;
import com.nobug.nobug_teamproject.models.BookList;
import com.nobug.nobug_teamproject.service.BookListService;
import com.nobug.nobug_teamproject.mapper.BookListMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookListServiceUnitTest {
    @Autowired
    private BookListService bookListService;

    @MockBean
    private BookListMapper bookListMapper;

    @Test
    void testGetBookList() {
        int testBookListID = 1000;

        BookList bookList = new BookList(testBookListID, "mock booklist");

        Mockito.when(bookListMapper.getBookList(testBookListID)).thenReturn(bookList);

        assertEquals("mock booklist", bookListService.getBookList(testBookListID).getBookListName());
    }

    @Test
    void testDeleteBookList() {
        int testBookListID = 1000;

        BookList bookList = new BookList(testBookListID, "a booklist");

        Mockito.doNothing().when(bookListMapper).deleteBookList(testBookListID);

        bookListService.deleteBookList(testBookListID);

        Mockito.verify(bookListMapper).deleteBookList(testBookListID);

    }

    @Test
    void testUpdateBookList() {
        int testBookListID = 1000;
        String testBookListName = "booklist1";
        String changeBookListName = "booklist2";
        BookList bookList = new BookList(testBookListID, testBookListName);

        Mockito.doNothing().when(bookListMapper).updateBookListName(testBookListID, changeBookListName);

        bookListService.updateBookListName(testBookListID, changeBookListName);

        Mockito.verify(bookListMapper).updateBookListName(testBookListID, changeBookListName);

    }

    @Test
    void testRemoveBookFromBookList() {
        int testBookListID = 1000;
        int testBookId = 2222;
        String testBookListName = "booklist1";
        String testBookName = "book1";
        String testBookCategory = "textbook";
        BookList bookList = new BookList(testBookListID, testBookListName);
        Book book = new Book(testBookId, testBookName, testBookCategory);

        Mockito.doNothing().when(bookListMapper).removeBookFromBookList(testBookId, testBookListID);

        bookListService.removeBookFromBookList(testBookId, testBookListID);

        Mockito.verify(bookListMapper).removeBookFromBookList(testBookId, testBookListID);
    }

    @Test
    void testAddBookToBookList() {
        int testBookListID = 1000;
        int testBookId = 2222;
        String testBookListName = "booklist1";
        String testBookName = "book1";
        String testBookCategory = "textbook";
        BookList bookList = new BookList(testBookListID, testBookListName);
        Book book = new Book(testBookId, testBookName, testBookCategory);

        Mockito.doNothing().when(bookListMapper).addBookToBookList(testBookId, testBookListID);

        bookListService.addBookToBookList(testBookId, testBookListID);

        Mockito.verify(bookListMapper).addBookToBookList(testBookId, testBookListID);
    }

    @Test
    void testGetBooksFromBookList() {
        int testBookListID = 1000;
        int testBookId = 2222;
        String testBookListName = "booklist1";
        String testBookName = "book1";
        String testBookCategory = "textbook";
        BookList bookList = new BookList(testBookListID, testBookListName);

        Book book = new Book(testBookId, testBookName, testBookCategory);
        List<Book> books = new ArrayList<Book>();
        books.add(book);

        Mockito.when(bookListMapper.getBooksFromBookList(testBookListID)).thenReturn(books);

        bookListService.getBooksFromBookList(testBookListID).get(0);

        assertEquals(testBookId, bookListService.getBooksFromBookList(testBookListID).get(0).getBookID());

    }
}