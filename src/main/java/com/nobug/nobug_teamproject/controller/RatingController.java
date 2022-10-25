package com.nobug.nobug_teamproject.controller;

import com.nobug.nobug_teamproject.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rating")
public class RatingController {
    @Autowired
    private RatingService ratingService;

    @GetMapping("get")
    public ResponseEntity<?> searchRating(@RequestParam(value = "bookID", required = true) Integer bookID){
        return new ResponseEntity<>(ratingService.searchRating(bookID), HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<?> addRating(@RequestParam(value = "bookID", required = true) Integer bookID,
                          @RequestParam(value = "rating", required = true) Integer rating){
        ratingService.addRating(bookID, rating);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("delete")
    public ResponseEntity<?> deleteRating(@RequestParam(value = "ratingID", required = true) Integer ratingID){
        ratingService.deleteRating(ratingID);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity<?> updateRating(@RequestParam(value = "ratingID", required = true) Integer ratingID,
                             @RequestParam(value = "rating", required = true) Integer rating){
        ratingService.updateRating(ratingID, rating);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
