package com.nobug.nobug_teamproject.service;

import com.nobug.nobug_teamproject.mapper.BookListMapper;
import com.nobug.nobug_teamproject.models.Book;
import com.nobug.nobug_teamproject.models.BookList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookListService {
    @Autowired
    private BookListMapper bookListMapper;

    public BookList getBookList(int bookListID){
        return bookListMapper.getBookList(bookListID);
    }

    public void deleteBookList(int bookListID){
        bookListMapper.deleteBookList(bookListID);
    }

    public int addBookList(String bookListName){
        BookList booklist = new BookList();
        booklist.setBookListName(bookListName);
        bookListMapper.addBookList(booklist);
        return booklist.getBookListID();
    }

    public void updateBookListName(int bookListID, String bookListName){
        bookListMapper.updateBookListName(bookListID, bookListName);
    }

    public void addBookToBookList(int bookID, int bookListID){
        bookListMapper.addBookToBookList(bookID, bookListID);
    }

    public void removeBookFromBookList(int bookID, int bookListID) {
        bookListMapper.removeBookFromBookList(bookID, bookListID);
    }

    public List<Book> getBooksFromBookList(int bookListID) {
        return bookListMapper.getBooksFromBookList(bookListID);
    }
}
