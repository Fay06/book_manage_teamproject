package com.nobug.test_project.controller;

import com.nobug.test_project.models.Book;
import com.nobug.test_project.models.Rating;
import com.nobug.test_project.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RatingController {
    @Autowired
    private RatingService ratingService;

    @GetMapping("/searchRating/{bookID}")
    public List<Rating> searchRating(@PathVariable("bookID") int bookID){
        return ratingService.searchRating(bookID);
    }

    @GetMapping("/addRating/{bookID}/{rating}")
    public void addRating(@PathVariable("bookID") int bookID, @PathVariable("rating") int rating){
        ratingService.addRating(bookID, rating);
    }
}
