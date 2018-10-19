INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('The Wombats', 'Turn', 2018, 52.1);

INSERT INTO TBL_SONG_GENRE (song_id, genre)
    SELECT DISTINCT id, 'INDIE'
    FROM SONG
    WHERE artist = 'The Wombats';