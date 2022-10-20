package com.nobug.test_project.service;

import com.nobug.test_project.mapper.BookMapper;
import com.nobug.test_project.models.Book;
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
    public List<Book> searchCategory(String category) { return bookMapper.searchCategory(category); }
}
