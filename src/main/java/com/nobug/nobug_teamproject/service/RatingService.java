package com.nobug.test_project.service;

import com.nobug.test_project.mapper.RatingMapper;
import com.nobug.test_project.models.Rating;
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
    }Rating
}
