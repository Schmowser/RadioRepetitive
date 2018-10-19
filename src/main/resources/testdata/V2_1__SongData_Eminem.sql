INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Eminem', 'Like Toy Soldiers', 2005, 39.8);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Eminem', 'The Real Slim Shady', 2000, 49.5);

INSERT INTO TBL_SONG_GENRE (song_id, genre)
    SELECT DISTINCT id, 'HIPHOP'
    FROM SONG
    WHERE artist = 'Eminem';