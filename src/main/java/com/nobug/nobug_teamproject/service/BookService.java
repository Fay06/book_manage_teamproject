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

    public List<Book> allBook(){
        return bookMapper.allBook();
    }
    public List<Book> searchBook(String bookName){
        return bookMapper.searchBook(bookName);
    }
    public List<Book> searchCategory(String category) {
        return bookMapper.searchCategory(category);
    }
    public List<Book> getBookId(int bookID){
        return bookMapper.getBookId(bookID);
    }
    public void deleteBookId(int bookID){
        bookMapper.deleteBookId(bookID);
    }
    public int addBook(String bookName, String category){
        Book book = new Book();
        book.setBookName(bookName);
        book.setCategory(category);
        bookMapper.addBook(book);
        return book.getBookID();
    }
    public void updateBookName(int bookID, String bookName){
        bookMapper.updateBookName(bookID, bookName);
    }
    public void updateCategory(int bookID, String category){
        bookMapper.updateCategory(bookID, category);
    }
}
