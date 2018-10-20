INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Heisskalt', 'Hallo', 2013, 45.0);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Heisskalt', 'Alles Gut', 2014, 41.0);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Heisskalt', 'Besiegen die Angst', 2013, 59.5);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Heisskalt', 'Lied über nichts', 2017, 37.6);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Heisskalt', 'Nicht anders gewollt', 2014, 55.4);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Heisskalt', 'Dezemberluft', 2013, 45.5);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Heisskalt', 'Sonne über Wien', 2013, 42.4);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Heisskalt', 'Leben wert', 2016, 36.8);


INSERT INTO TBL_SONG_GENRE (song_id, genre)
    SELECT DISTINCT id, 'PUNK'
    FROM SONG
    WHERE artist = 'Heisskalt';