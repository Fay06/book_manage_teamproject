package com.nobug.test_project.mapper;

import com.nobug.test_project.models.Rating;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RatingMapper {
    List<Rating> searchRating(int bookID);
    void addRating(int bookID, int rating);
}
