package com.nobug.nobug_teamproject.service;

import com.nobug.nobug_teamproject.models.Book;
import com.nobug.nobug_teamproject.models.Rating;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookAndRatingIntegrationTest {
    @Autowired
    BookService bookService;
    @Autowired
    RatingService ratingService;

    static int bookID;
    static int result;

    @Test
    public void addBook() {
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
    public void addRating() {
        Random r = new Random();
        for (int i = 0; i < 10; i++){
            int temp = r.nextInt(5)+1;
            int ratingID = ratingService.addRating(bookID, temp);
            result += temp;
            assertTrue(ratingID >= 0);
        }
    }

    @Test
    public void checkResult(){
        result = result/10;
        Rating searchResult = ratingService.searchRating(bookID);
        assertEquals(result, searchResult.getRating());
    }
}
