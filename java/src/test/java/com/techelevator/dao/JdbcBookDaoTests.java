package com.techelevator.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.techelevator.model.Book;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcBookDaoTests extends BaseDaoTests{
    Book book = new Book();
private JdbcBookDao sut;

@Before
    public void setup(){
    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
    sut = new JdbcBookDao(jdbcTemplate);
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


}
