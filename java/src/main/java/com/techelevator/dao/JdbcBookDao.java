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
    public Book getBookById(int id) {
        String sql = "SELECT book_id, title, author, summary, price, onWishList, hasRead, hasPurchased, collection_name, genre_name FROM book"
                + "WHERE book_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if (results.next()){
            return mapRowToBook(results);
        } else {
            return null;
        }
    }

    @Override
    public List<Book> getBooksByGenre(String genreName) {
       List<Book> books = new ArrayList<>();
        String sql = "SELECT book_id, title, author, summary, price, onWishList, hasRead, hasPurchased, collection_name, genre_name FROM book"
                + "WHERE genre_name = ?;";
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
                + "WHERE collection_name = ?;";
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
