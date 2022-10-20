package com.nobug.nobug_teamproject.models;

public class Book {
    private int bookID;
    private String bookName;
    private String category;

    public Book(int bookID, String bookName, String category) {
        this.bookID = bookID;
        this.bookName = bookName;
        this.category = category;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
