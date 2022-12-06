package com.nobug.nobug_teamproject.unit;

import com.nobug.nobug_teamproject.mapper.RatingMapper;
import com.nobug.nobug_teamproject.models.Rating;
import com.nobug.nobug_teamproject.service.RatingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RatingServiceUnitTest {
    @Autowired
    private RatingService ratingService;

    @MockBean
    private RatingMapper ratingMapper;

    @Test
    public void testSearchRating() {
        int testBookID = 1025;

        Rating rating = new Rating(testBookID, 5.0);

        Mockito.when(ratingMapper.searchRating(testBookID)).thenReturn(rating);

        assertEquals(5.0, ratingService.searchRating(testBookID).getRating());
    }

    @Test
    public void testSearch() {
        int testRatingID = 23;

        Rating rating = new Rating(testRatingID, 3, 5);

        Mockito.when(ratingMapper.search(testRatingID)).thenReturn(rating);

        assertEquals(rating, ratingService.search(testRatingID));
    }

    @Test
    @Transactional
    public void testDeleteRating() {
        int testRatingID = 23;

        Mockito.doNothing().when(ratingMapper).deleteRating(testRatingID);

        ratingService.deleteRating(testRatingID);

        Mockito.verify(ratingMapper).deleteRating(testRatingID);
    }

    @Test
    @Transactional
    public void testUpdateRating() {
        int testRatingID = 23;

        int changeRating = 3;

        Mockito.doNothing().when(ratingMapper).updateRating(testRatingID, changeRating);

        ratingService.updateRating(testRatingID, changeRating);

        Mockito.verify(ratingMapper).updateRating(testRatingID, changeRating);
    }

}