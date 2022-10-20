package com.nobug.test_project.mapper;

import com.nobug.test_project.models.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
    Book searchBook(String bookName);
    List<Book> searchCategory(String category);
}
