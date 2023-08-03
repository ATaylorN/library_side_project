DROP TABLE IF EXISTS collection,book_genre,genre, book;

CREATE TABLE collection(
	collection_id serial NOT NULL,
	name varchar(120) NOT NULL,
	CONSTRAINT PK_collection PRIMARY KEY(collection_id)
);

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
	CONSTRAINT PK_book PRIMARY KEY(book_id),
	CONSTRAINT FK_book_collection FOREIGN KEY(collection_id) REFERENCES collection(collection_id)
);

CREATE TABLE genre(
	genre_id serial NOT NULL,
	name varchar(50) NOT NULL,
	CONSTRAINT PK_genre PRIMARY KEY(genre_id)
);

CREATE TABLE book_genre(
	book_id int NOT NULL,
	genre_id int NOT NULL,
	CONSTRAINT PK_book_genre PRIMARY KEY(book_id, genre_id),
	CONSTRAINT FK_book_genre_book FOREIGN KEY (book_id) REFERENCES book(book_id),
	CONSTRAINT FK_book_genre_genre FOREIGN KEY (genre_id) REFERENCES genre(genre_id)
);


INSERT INTO book(title, author, summary, hasRead, hasPurchased)
VALUES ('The Count of Monte Cristo', 'Alexandre Dumas','test description', true, true),
('Hamlet', 'William Shakespeare', 'test description', true, true);

INSERT INTO genre(name) 
VALUES ('Horror'),('Sci-Fi'),('Mystery'),('True Crime'), ('Manga'),('Fantasy'), ('Classic Literature');

INSERT INTO book_genre (book_id, genre_id)
VALUES(1, 7);

INSERT INTO collection (name)
VALUES('Harry Potter Collection'), ('Death Note Collection');

--SELECT * FROM collection;
--SELECT * FROM book_genre;
--SELECT * FROM genre;
--SELECT * FROM book;