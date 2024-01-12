package com.techelevator.controller;

import com.techelevator.dao.BookDao;
import com.techelevator.dao.JdbcBookDao;
import com.techelevator.model.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value="/")
public class BookController {
    private BookDao bookDao;

    public BookController(BookDao bookDao){
        this.bookDao = bookDao;
    }

    //getAllBooks
    @RequestMapping(value="", method = RequestMethod.GET)
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        try{
            books = bookDao.getAllBooks();
        } catch (RuntimeException e) {
            throw new RuntimeException("Couldn't get books!");
        }
        return books;
    }

    //getBookByTitle
    //getBookById
    //getBooksByGenre
    //getBooksByCollection
    //createBook
    //updateBook
    //deleteBook
}
