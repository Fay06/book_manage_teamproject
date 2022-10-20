package com.nobug.nobug_teamproject.mapper;

import com.nobug.nobug_teamproject.models.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
    Book searchBook(String bookName);
    List<Book> searchCategory(String category);
    Book getBookId(int bookID);
}
