package com.nobug.nobug_teamproject.service;

import com.nobug.nobug_teamproject.mapper.RatingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {
    @Autowired
    private RatingMapper ratingMapper;

    public float searchRating(int bookID) {
        return ratingMapper.searchRating(bookID);
    }

    public void addRating(int bookID, int rating) {
        ratingMapper.addRating(bookID, rating);
    }
    public void deleteRating(int ratingID) {
        ratingMapper.deleteRating(ratingID);
    }
    public void updateRating(int ratingID, int rating) {
        ratingMapper.updateRating(ratingID, rating);
    }
}
