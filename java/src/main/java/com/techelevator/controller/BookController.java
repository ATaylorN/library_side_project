package com.techelevator.controller;

import com.techelevator.dao.BookDao;
import com.techelevator.dao.JdbcBookDao;
import com.techelevator.model.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value="/{title}", method = RequestMethod.GET)
    public Book getBookByTitle(@PathVariable String title){
        Book book = null;
        try {
            book = (Book) bookDao.getBookByTitle(title);
        } catch (RuntimeException e){
            throw  new RuntimeException("Books not found!");
        }
        return book;
    }
    //getBookById
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Book getBookById(@PathVariable int bookId){
        Book book = null;
        try{
            book = bookDao.getBookById(bookId);
        } catch (RuntimeException e){
            throw new RuntimeException("Book not found! Try a different ID");
        }
        return book;
    }
    //getBooksByGenre
    //getBooksByCollection
    //createBook
    //updateBook
    //deleteBook
}
