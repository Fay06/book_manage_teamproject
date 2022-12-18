package com.nobug.nobug_teamproject.service;

import com.nobug.nobug_teamproject.models.Rating;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RatingServiceTest {

    @Autowired
    RatingService ratingService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void search() {
        double ratingResult = 1.0;
        Rating searchResult = ratingService.search(1);
        assertEquals(ratingResult, searchResult.getRating());
    }

    @Test
    public void searchRating() {
        double ratingResult = 5.0;
        Rating searchResult = ratingService.searchRating(1025);
        assertEquals(ratingResult, searchResult.getRating());
    }

    @Test
    @Transactional
    public void addRating() {
        ratingService.addRating(4, 5);
        double ratingResult = 5.0;
        Rating searchResult = ratingService.searchRating(4);
        assertEquals(ratingResult, searchResult.getRating());
    }

    @Test
    @Transactional
    public void deleteRating() {
        ratingService.deleteRating(23);
        Rating searchResult = ratingService.searchRating(3);
        assertNull(searchResult);
    }

    @Test
    @Transactional
    public void updateRating() {
        Rating previousRes = ratingService.searchRating(3);
        ratingService.updateRating(23, 1);
        Rating afterRes = ratingService.searchRating(3);
        assertNotEquals(previousRes.getRating(), afterRes.getRating());
    }
}