package com.nobug.nobug_teamproject.models;

public class Rating {
    private int ratingID;
    private int bookID;
    private double rating;

    public Rating(int bookID, double rating) {
        this.bookID = bookID;
        this.rating = rating;
    }

    public Rating() {
        super();
    }

    public int getRatingID() {
        return ratingID;
    }

    public void setRatingID(int ratingID) {
        this.ratingID = ratingID;
    }

    public double getRating() {
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
