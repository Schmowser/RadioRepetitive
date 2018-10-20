INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('ABBA', 'Dancing Queen', 1976, 55.8);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('ABBA', 'Knowing Me Knowing You', 1976, 60.2);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('ABBA', 'Mamma Mia', 1975, 55.3);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('ABBA', 'Waterloo', 1974, 57.2);

INSERT INTO TBL_SONG_GENRE (song_id, genre)
    SELECT DISTINCT id, 'POP'
    FROM SONG
    WHERE artist = 'ABBA';