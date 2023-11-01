BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, book;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE book(
	book_id serial,
	title varchar(120) NOT NULL,
	author varchar(120) NOT NULL,
	summary varchar (400) NOT NULL,
	price decimal,
	onWishlist boolean,
	hasRead boolean NOT NULL DEFAULT false, 
	hasPurchased boolean NOT NULL DEFAULT false,
	collection_name varchar(120),
	genre_name varchar(50) NOT NULL
);

COMMIT TRANSACTION;
