package com.nobug.nobug_teamproject.controller;

import com.nobug.nobug_teamproject.models.Book;
import com.nobug.nobug_teamproject.models.Rating;
import com.nobug.nobug_teamproject.service.BookService;
import com.nobug.nobug_teamproject.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {
    @Autowired
    private RatingService ratingService;

    @Autowired
    private BookService bookService;

    @GetMapping("get")
    public ResponseEntity<Object> searchRating(@RequestParam(value = "bookID", required = true) Integer bookID){
        Rating rating = ratingService.searchRating(bookID);
        List<Book> result = bookService.getBookId(bookID);
        if (result == null || result.isEmpty()){
            return new ResponseEntity<>("Book Not Found", HttpStatus.NOT_FOUND);
        } else if (rating == null) {
            return new ResponseEntity<>("Rating Not Found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(rating, HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<Object> addRating(@RequestParam(value = "bookID", required = true) Integer bookID,
                          @RequestParam(value = "rating", required = true) Integer rating){
        String message = null;
        List<Book> result = bookService.getBookId(bookID);
        if (result == null || result.isEmpty()){
            return new ResponseEntity<>("Book Not Found", HttpStatus.NOT_FOUND);
        }
        int ratingID = ratingService.addRating(bookID, rating);
        message = "Rating Added, RatingID: " + ratingID;
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Object> deleteRating(@RequestParam(value = "ratingID", required = true) Integer ratingID){
        Rating rating = ratingService.search(ratingID);
        if (rating == null) {
            return new ResponseEntity<>("RatingID Not Found", HttpStatus.NOT_FOUND);
        }
        ratingService.deleteRating(ratingID);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity<Object> updateRating(@RequestParam(value = "ratingID", required = true) Integer ratingID,
                             @RequestParam(value = "rating", required = true) Integer rating){
        Rating rating1 = ratingService.search(ratingID);
        if (rating1 == null) {
            return new ResponseEntity<>("RatingID Not Found", HttpStatus.NOT_FOUND);
        }
        ratingService.updateRating(ratingID, rating);
        return new ResponseEntity<>("Updated", HttpStatus.OK);
    }
}
