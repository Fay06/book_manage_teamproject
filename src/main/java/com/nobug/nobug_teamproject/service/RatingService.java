package com.nobug.nobug_teamproject.service;

import com.nobug.nobug_teamproject.mapper.RatingMapper;
import com.nobug.nobug_teamproject.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {
    @Autowired
    private RatingMapper ratingMapper;

    public List<Rating> searchRating(int bookID) {
        return ratingMapper.searchRating(bookID);
    }

    public void addRating(int bookID, int rating) {
        ratingMapper.addRating(bookID, rating);
    }
}
