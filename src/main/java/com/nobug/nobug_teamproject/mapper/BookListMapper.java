package com.nobug.nobug_teamproject.mapper;

import com.nobug.nobug_teamproject.models.BookList;
import com.nobug.nobug_teamproject.models.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookListMapper {
    BookList getBookList(int bookListID);

    void deleteBookList(int bookListID);

    void addBookList(String bookListName);

    void updateBookListName(int bookListID, String bookListName);

    void addBookToBookList(int bookID, int bookListID);

    void removeBookFromBookList(int bookID, int bookListID);

    List<Book> getBooksFromBookList(int bookListID);
}
