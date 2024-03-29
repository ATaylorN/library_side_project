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
    Assert.assertEquals(4, sut.getAllBooks().size());
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
    assertBooksMatch(newBook, retrievedBook);
}
@Test
public void update_book_works(){
    Book bookToUpdate = sut.getBookById(1);
    bookToUpdate.setTitle("Updated Title");
    bookToUpdate.setAuthor("Updated Author");
    bookToUpdate.setSummary("Updated Summary");
    bookToUpdate.setPrice(25.00);
    bookToUpdate.setOnWishList(false);
    bookToUpdate.setHasRead(false);
    bookToUpdate.setHasPurchased(false);
    bookToUpdate.setCollectionName("Updated Collection");
    bookToUpdate.setGenreName("Updated Genre");
    sut.updateBook(bookToUpdate);
    Book retrievedBook = sut.getBookById(1);
    assertBooksMatch(bookToUpdate,retrievedBook);
}
@Test
public void deleted_book_is_no_longer_available(){
    sut.deleteBook(3);
    Book retrievedBook = sut.getBookById(3);
    Assert.assertNull(retrievedBook);
}

public void assertBooksMatch(Book expectedBook, Book actualBook){
    Assert.assertEquals(expectedBook.getBookId(), actualBook.getBookId());
    Assert.assertEquals(expectedBook.getTitle(),actualBook.getTitle());
    Assert.assertEquals(expectedBook.getAuthor(),actualBook.getAuthor());
    Assert.assertEquals(expectedBook.getSummary(),actualBook.getSummary());
    Assert.assertEquals(expectedBook.getPrice(),actualBook.getPrice(),0.02);
    Assert.assertEquals(expectedBook.isOnWishList(),actualBook.isOnWishList());
    Assert.assertEquals(expectedBook.isHasRead(),actualBook.isHasRead());
    Assert.assertEquals(expectedBook.isHasPurchased(),actualBook.isHasPurchased());
    Assert.assertEquals(expectedBook.getCollectionName(),actualBook.getCollectionName());
    Assert.assertEquals(expectedBook.getGenreName(),actualBook.getGenreName());
}
}
