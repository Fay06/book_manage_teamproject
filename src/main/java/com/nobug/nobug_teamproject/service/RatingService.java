package com.nobug.nobug_teamproject.service;

import com.nobug.nobug_teamproject.mapper.RatingMapper;
import com.nobug.nobug_teamproject.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {
    @Autowired
    private RatingMapper ratingMapper;

    public Rating searchRating(int bookID) {
        return ratingMapper.searchRating(bookID);
    }

    public Rating search(int ratingID) {
        return ratingMapper.search(ratingID);
    }

    public int addRating(int bookID, int rating) {
        Rating rating1 = new Rating();
        rating1.setBookID(bookID);
        rating1.setRating(rating);
        ratingMapper.addRating(rating1);
        return rating1.getRatingID();
    }
    public void deleteRating(int ratingID) {
        ratingMapper.deleteRating(ratingID);
    }
    public void updateRating(int ratingID, int rating) {
        ratingMapper.updateRating(ratingID, rating);
    }
}
