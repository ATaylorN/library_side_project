package com.techelevator.controller;

import com.techelevator.dao.BookDao;
import com.techelevator.dao.JdbcBookDao;
import com.techelevator.model.Book;
import org.springframework.http.HttpStatus;
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
    @RequestMapping(value="/{genre}", method = RequestMethod.GET)
    public List<Book> getBooksByGenre(@PathVariable String genreName){
        List<Book> booksByGenre = new ArrayList<>();
        try{
            booksByGenre = bookDao.getBooksByGenre(genreName);
        }catch (RuntimeException e){
            throw new RuntimeException("Couldn't get books by genre!");
        }
        return booksByGenre;
    }
    //getBooksByCollection
    //createBook
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value="", method = RequestMethod.POST)
    public int createBook(@RequestBody Book book){
        int newBookId;
        try{
            newBookId = bookDao.createBook(book).getBookId();
        } catch (RuntimeException e) {
            throw new RuntimeException("Unable to create new book!");
        }
        return newBookId;
    }
    //updateBook
    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
    public Book updateBook(@PathVariable int bookId, @RequestBody Book bookToUpdate){
        if(bookId<0){
            throw new RuntimeException("Book not found!");
        }
        bookToUpdate.setBookId(bookId);
        try{
            Book book = bookDao.updateBook(bookToUpdate);
            return book;
        } catch (RuntimeException e){
            throw  new RuntimeException("Unable to update book!");
        }
    }
    //deleteBook
}
