package com.techelevator.dao;

import com.techelevator.model.Book;

import java.util.List;

public interface BookDao {
    Book getBook();
    Book getBookById();
    Book getBookByGenre();
    Book getBookByCollection();
    List<Book> getAllBooks();
}
