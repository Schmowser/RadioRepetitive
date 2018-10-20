-- Songs
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Whitney Houston', 'I Will Always Love You', 1992, 43.0);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Savage Garden', 'Truly Madly Deeply', 1997, 55.8);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Spice Girls', 'Wannabe', 1996, 68.2);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Los del Rio', 'Macarena', 1993, 74.5);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Eiffel 65', 'Blue (Da Ba Dee)', 1999, 74.7);


INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Coolio', 'Gangstas Paradise', 1995, 49.7);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Haddaway', 'What is Love', 1993, 67.3);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Britney Spears', '...Baby One More Time', 1998, 63.7);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Kris Kross', 'Jump', 1992, 57.8);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('MC Hammer', 'U Cant Touch This', 1990, 53.3);

INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Nirvana', 'Smells Like Teen Spirit', 1991, 61.4);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Aqua', 'Barbie Girl', 1997, 68.3);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Toni Braxton', 'Un-Break My Heart', 1996, 60.7);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Fugees', 'Killing Me Softly With His Song', 1996, 65.4);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Christina Aguilera', 'Genie in a Bottle', 1999, 67.0);

INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('All-4-One', 'I Swear', 2005, 53.4);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Backstreet Boys', 'I Want It That Way', 1999, 65.3);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Will Smith', 'Gettin Jiggy With It', 1997, 46.2);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Bryan Adams', '(Everything I Do) I Do It For You', 1991, 53.4);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Natalia Imbruglia', 'Torn', 1998, 51.4);

INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Oasis', 'Wonderwall', 1995, 59.1);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Right Said Fred', 'Im Too Sexy', 1992, 64.8);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Michael Jackson', 'Black Or White', 1991, 44.0);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Spin Doctors', 'Two Princess', 1991, 70.8);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Chumbawamba', 'Tubthumping', 1997, 89.3);

INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Seal', 'Kiss From a Rose', 1994, 67.7);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Lou Bega', 'Mambo No. 5', 1999, 52.8);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Vanilla Ice', 'Ice Ice Baby', 1990, 38.7);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Beck', 'Loser', 1996, 39.5);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Wolfgang Petry', 'Die Längste Single der Welt', 1996, 37.0);

INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Scorpions', 'Wind of Change', 1991, 57.5);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Dr. Alban', 'Its My Life', 1992, 61.9);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Ace Of Base', 'All That She Wants', 1993, 61.3);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Snap!', 'Rhythm is a Dancer', 1992, 53.4);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Fools Garden', 'Lemon Tree', 1995, 56.9);

INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Inner Circle', 'Sweat (A La La La La Long)', 1992, 73.0);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Die Wildecker Herzbuben', 'Herzilein', 1990, 46.2);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Crazytown', 'Butterfly', 2000, 55.4);


-- Genre
INSERT INTO TBL_SONG_GENRE (song_id, genre) VALUES (SELECT id FROM SONG WHERE artist = 'Coolio', 'HIPHOP');
INSERT INTO TBL_SONG_GENRE (song_id, genre) VALUES (SELECT id FROM SONG WHERE artist = 'Savage Garden', 'POP');
INSERT INTO TBL_SONG_GENRE (song_id, genre) VALUES (SELECT id FROM SONG WHERE title = 'Macarena', 'LATIN');
INSERT INTO TBL_SONG_GENRE (song_id, genre) VALUES (SELECT id FROM SONG WHERE artist = 'Eiffel 65', 'DANCE');

INSERT INTO TBL_SONG_GENRE (song_id, genre)
    SELECT DISTINCT id, 'HIPHOP'
    FROM SONG
    WHERE artist = 'MC Hammer'
    OR artist = 'Will Smith'
    OR artist = 'Vanilla Ice';

    INSERT INTO TBL_SONG_GENRE (song_id, genre)
    SELECT DISTINCT id, 'INDIE'
    FROM SONG
    WHERE artist = 'Oasis';

INSERT INTO TBL_SONG_GENRE (song_id, genre)
    SELECT DISTINCT id, 'ROCK'
    FROM SONG
    WHERE artist = 'Nirvana'
    OR artist = 'Beck'
    OR artist = 'Scorpions';

INSERT INTO TBL_SONG_GENRE (song_id, genre)
    SELECT DISTINCT id, 'R_N_B'
    FROM SONG
    WHERE artist = 'Whitney Houston'
    OR artist = 'Toni Braxton'
    OR artist = 'All-4-One'
    OR artist = 'Seal';

    INSERT INTO TBL_SONG_GENRE (song_id, genre)
    SELECT DISTINCT id, 'POP'
    FROM SONG
    WHERE artist = 'Britney Spears'
    OR artist = 'Christina Aguilera'
    OR artist = 'Natalia Imbruglia'
    OR artist = 'Fugees'
    OR artist = 'Right Said Fred'
    OR artist = 'Bryan Adams'
    OR artist = 'Spin Doctors'
    OR artist = 'Chumbawamba'
    OR artist = 'Lou Bega'
    OR artist = 'Inner Circle'
    OR artist = 'Backstreet Boys';

    INSERT INTO TBL_SONG_GENRE (song_id, genre)
    SELECT DISTINCT id, 'DEUTSCH'
    FROM SONG
    WHERE artist = 'Wolfgang Petry';

    INSERT INTO TBL_SONG_GENRE (song_id, genre)
    SELECT DISTINCT id, 'DANCE'
    FROM SONG
    WHERE artist = 'Dr. Alban'
    OR artist = 'Ace of Base'
    OR artist = 'Snap!';

INSERT INTO TBL_SONG_GENRE (song_id, genre) VALUES (SELECT id FROM SONG WHERE title = 'What is Love', 'DANCE');


INSERT INTO TBL_SONG_GENRE (song_id, genre) VALUES (SELECT id FROM SONG WHERE title = 'Wannabe', 'POP');
INSERT INTO TBL_SONG_GENRE (song_id, genre) VALUES (SELECT id FROM SONG WHERE title = 'Macarena', 'POP');
INSERT INTO TBL_SONG_GENRE (song_id, genre) VALUES (SELECT id FROM SONG WHERE title = 'Blue (Da Ba Dee)', 'POP');

INSERT INTO TBL_SONG_GENRE (song_id, genre) VALUES (SELECT id FROM SONG WHERE artist = 'Kris Kross', 'HIPHOP');
INSERT INTO TBL_SONG_GENRE (song_id, genre) VALUES (SELECT id FROM SONG WHERE artist = 'Die Wildecker Herzbuben', 'DEUTSCH');
INSERT INTO TBL_SONG_GENRE (song_id, genre) VALUES (SELECT id FROM SONG WHERE artist = 'Crazytown', 'HIPHOP');