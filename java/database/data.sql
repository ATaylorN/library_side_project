BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO book(title, author, summary, price, onwishlist, hasread, hasPurchased, collection_name, genre_name)
VALUES ('The Count of Monte Cristo', 'Alexandre Dumas','Thrown in prison for a crime he has not commited, Edmond Dantes is confined to the grim fotress of If. There he learns of a great hoard of treasure hidden on the Isle of Monte Cristo and he becomes determined not only to escape, but also to unearth the treasure and use it to plot the destruction of the three men responsible for his incarceration.', 0.00, false, true, true, 'Classics', 'Classic Literature'),
('Hamlet', 'William Shakespeare', 'Hamlet is Shakespeares most popular, and most puzzling, play. It follows the form of a revenge tragedy, in which the hero, Hamlet, seeks vengeance against his fathers murderer, his uncle Claudius, now the king of Denmark.', 0.00, false, true, true, 'Classics', 'Classic Literature'),
('Harry Potter and the Philosophers Stone', 'J.K. Rowling', 'Harry Potter thinks he is an ordinary boy - until he is rescued by an owl, taken to Hogwarts School of Witchcraft and Wizardry, learns to play Quidditch, and does battle in a deadly duel. The reason...HARRY POTTER IS A WIZARD!', 0.00, false, true, true, 'Harry Potter Series', 'Fantasy'),
('Harry Potter and the Chamber of Secrets', 'J.K. Rowling', 'Ever since Harry Potter had come home for the summer, the Dursleys had been so mean and hideous that all Harry wanted was to get back to Hogwarts School for Witchcraft and Wizardry. But just as he is packing his bags, Harry receives a warning from a strange impish creature who says that if Harry returns to Hogwarts, disaster will strike.', 0.00, false, true, true, 'Harry Potter Series', 'Fantasy'),
('H.P. Lovecraft: The Complete Fiction', 'H.P. Lovecraft', 'In the 1920s and 30s, H.P. Lovecraft pioneered a new type of weird fiction that fused elements of supernatural horror with the concepts of visionary science fiction. Lovecrafts tales of cosmic horror revolutionized modern horror fiction and earned him the reputation of the most influential American writer of weird tales since Edgar Allan Poe.', 0.00, false, false, true, 'Classics', 'Horror'),
('Baby Teeth', 'Zoje Stage', 'She is the sweet-but-silent sngel in the adoring eyes of her Daddy. He is the only person who understands her, and all Hanna wants is to live happily ever after with him. But Mommy stands in her way, and she will try any trick she can think of to get rid of her. Ideally for good.', 17.99, false, true, false, 'none', 'Horror'),
('Legends & Lattes', 'Travis Baldree', 'Worn out after decades of packing steel and raising hell, Viv the orc barbarian cashes out of the warriors life with one final score. A forgotten legend, a fabled artifact, and an unreasonable amount of hope lead her to the streets of Thune, where she plans to open the first coffee shop the city has ever seen.', 17.99, true, false, false, 'Legends & Lattes Collection', 'Fantasy Romance'),
('Bookshops & Bonedust', 'Travis Baldree', 'The follow-up to Legends & Lattes is just as cozy and warm as night spent around the hearth, sharing stories of adventure. If you are tired of battles and bloodshed, but love fantasy worlds, this is the book for you.', 17.99, true, false, false, 'Legends & Lattes Collection', 'Fantasy Romance')
;

COMMIT TRANSACTION;
