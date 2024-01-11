package com.techelevator.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.techelevator.model.Book;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcBookDaoTests extends BaseDaoTests{

private Book testBook;
private JdbcBookDao sut;

@Before
    public void setup(){
    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
    sut = new JdbcBookDao(jdbcTemplate);
    testBook = new Book(0, "Test Title", "Test Author", "Test Summary", 0.00, true, false, false, "Test Collection Name", "Test Genre Name");
}

@Test
    public void list_of_books_returns_books(){

    Assert.assertEquals(3, sut.getAllBooks().size());
}
@Test
    public void get_books_by_title_works(){
    Assert.assertEquals(2, sut.getBookByTitle("Book2").size());
}

@Test
    public  void get_books_by_id_works(){
    Book book = new Book();
    book.setBookId(3);
    Assert.assertEquals(book.getBookId(), sut.getBookById(3).getBookId());
}
@Test
    public void books_by_genre_works(){
    Assert.assertEquals(2, sut.getBooksByGenre("genre1").size());
    Assert.assertEquals(1, sut.getBooksByGenre("genre2").size());
}

@Test
    public void books_by_collection_works(){
    Assert.assertEquals(2, sut.getBooksByCollection("collection1").size());
    Assert.assertEquals(1, sut.getBooksByCollection("collection2").size());
}

@Test
    public void create_book_creates_newbook(){
    Book newBook = sut.createBook(testBook);
    int  newBookId = newBook.getBookId();
    Assert.assertTrue(newBookId > 0);
    Book retrievedBook = sut.getBookById(newBookId);
    Assert.assertEquals(newBook.getBookId(), retrievedBook.getBookId());
    Assert.assertEquals(newBook.getTitle(),retrievedBook.getTitle());
    Assert.assertEquals(newBook.getAuthor(),retrievedBook.getAuthor());
    Assert.assertEquals(newBook.getSummary(),retrievedBook.getSummary());
    Assert.assertEquals(newBook.getPrice(),retrievedBook.getPrice(),0.02);
    Assert.assertEquals(newBook.isOnWishList(),retrievedBook.isOnWishList());
    Assert.assertEquals(newBook.isHasRead(),retrievedBook.isHasRead());
    Assert.assertEquals(newBook.isHasPurchased(),retrievedBook.isHasPurchased());
    Assert.assertEquals(newBook.getCollectionName(),retrievedBook.getCollectionName());
    Assert.assertEquals(newBook.getGenreName(),retrievedBook.getGenreName());
}
}
