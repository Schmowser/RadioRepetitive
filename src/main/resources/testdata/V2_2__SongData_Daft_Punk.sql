INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Daft Punk', 'Around the World', 1997, 1.9);

INSERT INTO TBL_SONG_GENRE (song_id, genre)
    SELECT DISTINCT id, 'HOUSE'
    FROM SONG
    WHERE artist = 'Daft Punk';