INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('ABBA', 'Dancing Queen', 1976, 0.0);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('ABBA', 'Knowing Me Knowing You', 1976, 0.0);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('ABBA', 'Mamma Mia', 1975, 0.0);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('ABBA', 'Waterloo', 1974, 0.0);

INSERT INTO TBL_SONG_GENRE (song_id, genre)
    SELECT DISTINCT id, 'POP'
    FROM SONG
    WHERE artist = 'ABBA';