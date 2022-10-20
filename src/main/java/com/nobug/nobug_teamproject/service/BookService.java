package com.nobug.nobug_teamproject.service;

import com.nobug.nobug_teamproject.mapper.BookMapper;
import com.nobug.nobug_teamproject.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookMapper bookMapper;

    public Book searchBook(String bookName){
        return bookMapper.searchBook(bookName);
    }
    public List<Book> searchCategory(String category) {
        return bookMapper.searchCategory(category);
    }
    public Book getBookId(int bookID){
        return bookMapper.getBookId(bookID);
    }
    public void deleteBookId(int bookID){
//        ratingMapper.deleteBookId(bookID);
        bookMapper.deleteBookId(bookID);
    }
    public void addBook(String bookName, String category){
        bookMapper.addBook(bookName, category);
    }
    public void updateBookName(int bookID, String bookName){
        bookMapper.updateBookName(bookID, bookName);
    }
    public void updateCategory(int bookID, String category){
        bookMapper.updateCategory(bookID, category);
    }
}
