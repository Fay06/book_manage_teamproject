package com.nobug.nobug_teamproject.mapper;

import com.nobug.nobug_teamproject.models.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
    List<Book> searchBook(String bookName);
    List<Book> searchCategory(String category);
    List<Book> getBookId(int bookID);
    void deleteBookId(int bookID);
    void addBook(Book book);
    void updateBookName(int bookID, String bookName);
    void updateCategory(int bookID, String category);
}
