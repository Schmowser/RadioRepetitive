INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('KC And The Sunshine Band', 'Thats the Way I Like It', 1977, 82.3);

INSERT INTO TBL_SONG_GENRE (song_id, genre)
    SELECT DISTINCT id, 'DISCO'
    FROM SONG
    WHERE artist = 'KC And The Sunshine Band';