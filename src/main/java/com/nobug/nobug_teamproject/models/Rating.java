package com.nobug.test_project.models;

public class Rating {
    private String ratingID;
    private int bookID;
    private int rating;

    public Rating(int bookID, int rating) {
        this.bookID = bookID;
        this.rating = rating;
    }

    public String getRatingID() {
        return ratingID;
    }

    public void setRatingID(String ratingID) {
        this.ratingID = ratingID;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

}
