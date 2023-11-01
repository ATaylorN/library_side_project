BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user1','user1','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user2','user2','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user3','user3','ROLE_USER');

INSERT INTO book (book_id, title, author, summary, price, onwishlist, hasread, haspurchased, collection_name, genre_name) VALUES (1, 'Book1', 'Author1', 'test summary1', 0.50, true, true, true, 'collection1', 'genre1');
INSERT INTO book (book_id, title, author, summary, price, onwishlist, hasread, haspurchased, collection_name, genre_name) VALUES (2, 'Book2', 'Author2', 'test summary2', 12.75, false, true, false, 'collection1', 'genre1');
INSERT INTO book (book_id, title, author, summary, price, onwishlist, hasread, haspurchased, collection_name, genre_name) VALUES (3, 'Book3', 'Author3', 'test summary3', 17.99, true, false, false, 'collection2', 'genre2');

COMMIT TRANSACTION;
