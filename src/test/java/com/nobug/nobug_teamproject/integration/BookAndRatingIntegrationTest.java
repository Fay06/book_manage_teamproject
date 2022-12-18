package com.nobug.nobug_teamproject.integration;

import com.nobug.nobug_teamproject.models.Book;
import com.nobug.nobug_teamproject.models.Rating;
import com.nobug.nobug_teamproject.service.BookService;
import com.nobug.nobug_teamproject.service.RatingService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BookAndRatingIntegrationTest {
    @Autowired
    BookService bookService;
    @Autowired
    RatingService ratingService;

    static int bookID;
    static int result;

    @Test
    public void test1AddBook() {
        bookID = bookService.addBook("Test for Rating", "test");
        List<Book> books = bookService.getBookId(bookID);
        boolean found = false;
        for (int i = 0; i < books.size(); i++)
        {
            if (books.get(i).getCategory().equals("test") && books.get(i).getBookName().equals("Test for Rating")) {
                found = true;
            }
        }
        assertTrue(found);
    }

    @Test
    public void test2AddRating() {
        Random r = new Random();
        for (int i = 0; i < 10; i++){
            int temp = r.nextInt(5)+1;
            int ratingID = ratingService.addRating(bookID, temp);
            result += temp;
            assertTrue(ratingID >= 0);
        }
    }

    @Test
    public void test3CheckResult(){
        result = result/10;
        Rating searchResult = ratingService.searchRating(bookID);
        assertEquals(result, searchResult.getRating());
    }
}
