package com.techelevator.model;

public class Book {
    private int bookId;
    private String title;

    private String author;
    private String summary;
    private float price;
    private boolean onWishList;

    private boolean hasRead;
    private boolean hasPurchased;
    private String collectionName;

    private String genreName;

    public Book (){};
    public Book(int bookId, String title, String author, String summary, float price, boolean onWishList, boolean hasRead, boolean hasPurchased, String collectionName, String genreName) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.summary = summary;
        this.price = price;
        this.onWishList = onWishList;
        this.hasRead = hasRead;
        this.hasPurchased = hasPurchased;
        this.collectionName = collectionName;
        this.genreName = genreName;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isOnWishList() {
        return onWishList;
    }

    public void setOnWishList(boolean onWishList) {
        this.onWishList = onWishList;
    }

    public boolean isHasRead() {
        return hasRead;
    }

    public void setHasRead(boolean hasRead) {
        this.hasRead = hasRead;
    }

    public boolean isHasPurchased() {
        return hasPurchased;
    }

    public void setHasPurchased(boolean hasPurchased) {
        this.hasPurchased = hasPurchased;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", summary='" + summary + '\'' +
                ", price=" + price +
                ", onWishList=" + onWishList +
                ", hasRead=" + hasRead +
                ", hasPurchased=" + hasPurchased +
                ", collectionName='" + collectionName + '\'' +
                ", genreName='" + genreName + '\'' +
                '}';
    }
}
