package com.techelevator.dao;


import com.techelevator.model.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcBookDao implements BookDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcBookDao(JdbcTemplate jdbcTemplate){this.jdbcTemplate = jdbcTemplate;}
    @Override
    public List<Book> getBookByTitle(String title) {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT book_id, title, author, summary, price, onWishList, hasRead, hasPurchased, collection_name, genre_name FROM book WHERE title = ?;";
        try {
            SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, title);
            while (rows.next()) {
                books.add(mapRowToBook(rows));
            }
        } catch (RuntimeException e){
            throw new RuntimeException("Couldn't load books!");
        }
        return books;
    }

    @Override
    public Book getBookById(int bookId) {
        Book book = null;
        String sql = "SELECT book_id, title, author, summary, price, onWishList, hasRead, hasPurchased, collection_name, genre_name FROM book "
                + "WHERE book_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, bookId);
            if (results.next()) {
                book = mapRowToBook(results);
            }
        }catch (RuntimeException e){
            throw new RuntimeException("Couldn't load book by ID!");
        }
        return book;
    }

    @Override
    public List<Book> getBooksByGenre(String genreName) {
       List<Book> books = new ArrayList<>();
        String sql = "SELECT book_id, title, author, summary, price, onWishList, hasRead, hasPurchased, collection_name, genre_name FROM book"
                + " WHERE genre_name = ?;";
        try {
            SqlRowSet row = jdbcTemplate.queryForRowSet(sql, genreName);
            while (row.next()) {
                books.add(mapRowToBook(row));
            }
        }catch (RuntimeException e){
            throw new RuntimeException("Couldn't load the books by their genre!");
        }
        return books;
    }

    @Override
    public List<Book> getBooksByCollection(String collectionName) {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT book_id, title, author, summary, price, onWishList, hasRead, hasPurchased, collection_name, genre_name FROM book"
                + " WHERE collection_name = ?;";
        try {
            SqlRowSet row = jdbcTemplate.queryForRowSet(sql, collectionName);
            while (row.next()){
                books.add(mapRowToBook(row));
            }
        }catch (RuntimeException e) {
            throw new RuntimeException("Couldn't load the books by their collection!");
    }  return books;
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT book_id, title, author, summary, price, onWishList, hasRead, hasPurchased, collection_name, genre_name FROM book;";
        try {
            SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);
            while (rows.next()) {
                books.add(mapRowToBook(rows));
            }
        } catch (RuntimeException e){
                throw new RuntimeException("Couldn't load books!");
            }
            return books;
    }

    @Override
    public Book createBook(Book book) {
        Book newBook = null;
        String sql = "INSERT INTO book (title, author, summary, price, onwishlist, hasread, haspurchased, collection_name, genre_name) VALUES (?,?,?,?,?,?,?,?,?) RETURNING book_id;";
        try {
            int newBookId = jdbcTemplate.queryForObject(sql, int.class, book.getTitle(), book.getAuthor(), book.getSummary(), book.getPrice(), book.isOnWishList(), book.isHasRead(), book.isHasPurchased(), book.getCollectionName(), book.getGenreName());
            newBook = getBookById(newBookId);
        }catch(RuntimeException e) {
            throw new RuntimeException("Unable to create book!");
            }
            return newBook;
    }

    @Override
    public Book updateBook(Book book){
        Book updatedBook = null;
        String sql = "UPDATE book SET title = ?, author = ?, summary = ?, price = ?, onwishList = ?, hasread = ?, haspurchased = ?, collection_name = ?, genre_name = ? " +
                "WHERE book_id = ?;";
        try{
            int numberOfRows = jdbcTemplate.update(sql, book.getTitle(), book.getAuthor(), book.getSummary(), book.getPrice(), book.isOnWishList(), book.isHasRead(), book.isHasPurchased(), book.getCollectionName(), book.getGenreName(), book.getBookId());
            if(numberOfRows == 0) {
                throw new RuntimeException("None of the information was updated!");
            }else {
                updatedBook = getBookById(book.getBookId());
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("Unable to update book!");
        }
        return updatedBook;
    }

    private Book mapRowToBook(SqlRowSet row){
        Book book = new Book();
        book.setBookId(row.getInt("book_id"));
        book.setTitle(row.getString("title"));
        book.setAuthor(row.getString("author"));
        book.setSummary(row.getString("summary"));
        book.setPrice(row.getFloat("price"));
        book.setOnWishList(row.getBoolean("onWishList"));
        book.setHasRead(row.getBoolean("hasRead"));
        book.setHasPurchased(row.getBoolean("hasPurchased"));
        book.setCollectionName(row.getString("collection_name"));
        book.setGenreName(row.getString("genre_name"));
        return book;
    }
}
