package com.nobug.nobug_teamproject.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RatingServiceTest {

    @Autowired
    RatingService ratingService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void searchRating() {
        double ratingResult = 1.0;
        double searchResult = ratingService.searchRating(2);
        assertEquals(ratingResult, searchResult);
    }

    @Test
    @Transactional
    void addRating() {
        ratingService.addRating(4, 5);
        double ratingResult = 5.0;
        double searchResult = ratingService.searchRating(4);
        assertEquals(ratingResult, searchResult);
    }

    @Test
    @Transactional
    void deleteRating() {
    }

    @Test
    void updateRating() {
    }
}