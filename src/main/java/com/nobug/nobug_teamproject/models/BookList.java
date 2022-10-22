package com.nobug.nobug_teamproject.models;

public class BookList {
    private int bookListID;

    private String bookListName;

    public BookList(int bookListID, String bookListName) {
        this.bookListID = bookListID;
        this.bookListName = bookListName;
    }

    public int getBookListID() {
        return bookListID;
    }

    public void setBookListID(int bookListID) {
        this.bookListID = bookListID;
    }

    public String getBookListName() {
        return bookListName;
    }

    public void setBookListName(String bookListName) {
        this.bookListName = bookListName;
    }
}
