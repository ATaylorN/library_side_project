DROP TABLE IF EXISTS book;

CREATE TABLE book(
	book_id serial,
	title varchar(120) NOT NULL,
	author varchar(120) NOT NULL,
	summary varchar (400) NOT NULL,
	price decimal,
	onWishlist boolean, 
	collection_id int,
	hasRead boolean NOT NULL DEFAULT false, 
	hasPurchased boolean NOT NULL DEFAULT false,
	collection_name varchar(120),
	genre_name varchar(50) NOT NULL);

INSERT INTO book(title, author, summary, hasRead, hasPurchased, genre_name)
VALUES ('The Count of Monte Cristo', 'Alexandre Dumas','test description', true, true, 'Classic Literature'),
('Hamlet', 'William Shakespeare', 'test description', true, true, 'Classic Literature');

COMMIT TRANSACTION;
--SELECT * FROM book;