package com.nobug.nobug_teamproject.mapper;

import com.nobug.nobug_teamproject.models.Rating;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RatingMapper {
    List<Rating> searchRating(int bookID);
    void addRating(int bookID, int rating);
}
