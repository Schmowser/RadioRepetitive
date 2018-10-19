-- Songs
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Taylor Swift', 'You Belong With Me', 2008, 50.0);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Taylor Swift', 'Love Story', 2008, 59.5);

INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Taylor Swift', 'We Are Never Ever Getting Back Together', 2012, 30.3);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Taylor Swift', 'All Too Well', 2012, 62.3);

INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Taylor Swift', '...Ready For It?', 2018, 41.9);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Taylor Swift', 'End Game', 2018, 44.9);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Taylor Swift', 'I Did Something Bad', 2018, 41.7);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Taylor Swift', 'Dont Blame Me', 2018, 34.1);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Taylor Swift', 'Delicate', 2018, 34.2);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Taylor Swift', 'Look What Your Made Me Do', 2018, 31.4);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Taylor Swift', 'So It Goes...', 2018, 39.4);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Taylor Swift', 'Gorgeous', 2018, 43.0);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Taylor Swift', 'Getaway Car', 2018, 40.5);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Taylor Swift', 'King of My Heart', 2018, 36.0);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Taylor Swift', 'Dancing With Our Hands Tied', 2018, 38.8);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Taylor Swift', 'Dress', 2018, 35.6);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Taylor Swift', 'This is Why We Cant Have Nice Things', 2018, 45.5);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Taylor Swift', 'Call It What Your Want', 2018, 45.6);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Taylor Swift', 'New Years Day', 2018, 37.3);

-- Genre
INSERT INTO TBL_SONG_GENRE (song_id, genre)
    SELECT DISTINCT id, 'POP'
    FROM SONG
    WHERE artist = 'Taylor Swift';
INSERT INTO TBL_SONG_GENRE (song_id, genre) VALUES (1, 'COUNTRY');
