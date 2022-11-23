package com.nobug.nobug_teamproject.mapper;

import com.nobug.nobug_teamproject.models.Rating;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RatingMapper {
    Rating searchRating(int bookID);
    Rating search(int ratingID);
    void addRating(Rating rating);
    void deleteRating(int ratingID);
    void updateRating(int ratingID, int rating);
}
