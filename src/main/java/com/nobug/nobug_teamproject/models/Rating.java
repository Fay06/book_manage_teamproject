package com.nobug.nobug_teamproject.models;

public class Rating {
    private int ratingID;
    private int bookID;
    private int ratingNum;

    public Rating(int ratingID, int bookID, int rating) {
        this.ratingID = ratingID;
        this.bookID = bookID;
        this.ratingNum = rating;
    }

    public int getRatingID() {
        return ratingID;
    }

    public void setRatingID(int ratingID) {
        this.ratingID = ratingID;
    }

    public int getRating() {
        return ratingNum;
    }

    public void setRating(int rating) {
        this.ratingNum = rating;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

}
