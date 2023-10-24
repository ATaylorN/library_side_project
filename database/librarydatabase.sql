DROP TABLE IF EXISTS book;

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

INSERT INTO book(title, author, summary, price, onwishlist, hasread, hasPurchased, collection_name, genre_name)
VALUES ('The Count of Monte Cristo', 'Alexandre Dumas','Thrown in prison for a crime he has not commited, Edmond Dantes is confined to the grim fotress of If. There he learns of a great hoard of treasure hidden on the Isle of Monte Cristo and he becomes determined not only to escape, but also to unearth the treasure and use it to plot the destruction of the three men responsible for his incarceration.', 0.00, false, true, true, 'Classics', 'Classic Literature'),
('Hamlet', 'William Shakespeare', 'Hamlet is Shakespeares most popular, and most puzzling, play. It follows the form of a revenge tragedy, in which the hero, Hamlet, seeks vengeance against his fathers murderer, his uncle Claudius, now the king of Denmark.', 0.00, false, true, true, 'Classics', 'Classic Literature');

-- COMMIT TRANSACTION;
--SELECT * FROM book;