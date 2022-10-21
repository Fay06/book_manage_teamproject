package com.nobug.nobug_teamproject.controller;

import com.nobug.nobug_teamproject.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RatingController {
    @Autowired
    private RatingService ratingService;

    @GetMapping("/searchRating/{bookID}")
    public float searchRating(@PathVariable("bookID") int bookID){
        return ratingService.searchRating(bookID);
    }

    @GetMapping("/addRating/{bookID}/{rating}")
    public void addRating(@PathVariable("bookID") int bookID, @PathVariable("rating") int rating){
        ratingService.addRating(bookID, rating);
    }

    @GetMapping("/deleteRating/{ratingID}")
    public void deleteRating(@PathVariable("ratingID") int ratingID){
        ratingService.deleteRating(ratingID);
    }

    @GetMapping("/updateRating/{ratingID}/{rating}")
    public void updateRating(@PathVariable("ratingID") int ratingID, @PathVariable("rating") int rating){
        ratingService.updateRating(ratingID, rating);
    }
}
