package com.nobug.nobug_teamproject.models;

public class Rating {
    private String ratingID;
    private int bookID;
    private int ratingNum;

    public Rating(int bookID, int rating) {
        this.bookID = bookID;
        this.ratingNum = rating;
    }

    public String getRatingID() {
        return ratingID;
    }

    public void setRatingID(String ratingID) {
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
