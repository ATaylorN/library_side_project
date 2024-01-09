package com.techelevator.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.techelevator.model.Book;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcBookDaoTests extends BaseDaoTests{

//    protected static final Book Book1 = new Book(1, "Book1", "BookAuthor1", "testSummary1", 0.00, false, true, true, "collectionName1", "genreName1");
//    protected static final Book Book2 = new Book(2, "Book2", "BookAuthor2", "testSummary2", 1.20, true, false, false, "collectionName2", "genreName1");
//    protected static final Book Book3 = new Book(3, "Book3", "BookAuthor3", "testSummary3", 13.50, false, true, true, "collectionName1", "genreName2");
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


}
