package com.nobug.nobug_teamproject.controller;

import com.nobug.nobug_teamproject.models.Book;
import com.nobug.nobug_teamproject.models.Rating;
import com.nobug.nobug_teamproject.service.RatingService;
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
