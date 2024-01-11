package com.techelevator.dao;

import com.techelevator.model.Book;

import java.util.List;

public interface BookDao {
    List<Book> getBookByTitle(String title);
    Book getBookById(int bookId);
    List<Book> getBooksByGenre(String genreName);
    List <Book> getBooksByCollection(String collectionName);
    List<Book> getAllBooks();
    Book createBook(Book book);
}
