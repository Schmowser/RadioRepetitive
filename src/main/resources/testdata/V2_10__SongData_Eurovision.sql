-- Songs
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Netta', 'Toy', 2018, 43.7);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Scheiße Sobral', 'Amar Pelos Dois', 2017, 38.9);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Jamal', '1944', 2016, 45.7);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Mans Zelmerlöw', 'Heroes', 2015, 55.3);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Conchita Wurst', 'Rise Like a Phoenix', 2014, 47.8);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Emilie De Forest', 'Only Teardrops', 2013, 68.8);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Loreen', 'Euphoria', 2012, 55.9);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Ell & Nikki', 'Running Scared', 2011, 68.5);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Alexander Rybak', 'Fairytale', 2009, 40.4);

INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Dima Bilan', 'Believe', 2008, 52.3);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Marija Serifovic', 'Molidva', 2007, 20.5);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Lordi', 'Hard Rock Halluluja', 2006, 60.7);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('(H)elena Paparizou', 'My Number One', 2005, 42.8);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Ruslana', 'Wild Dances', 2004, 66.8);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Sertab Erener', 'Everyway that I Can', 2003, 59.2);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Marie N', 'I Wanna', 2002, 50.9);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Tanel Padar & Dave Benton', 'Everybody', 2001, 57.8);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Olsen Brothers', 'Fly on the Wings of Love', 2000, 43.0);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Charlotte Perrelli', 'Take Me to Heaven', 1999, 55.5);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Katrina and the Waves', 'Love Shine a Light', 1997, 67.8);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Eimear Quinn', 'The Voice', 1996, 37.0);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Dana International', 'Diva', 1998, 56.2);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Secret Garden', 'Nocturne', 1995, 7.7);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Paul Harrington & Charlie McGettigan', 'Rock n Roll Kids', 1994, 45.9);

INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Blanche', 'City Lights', 2017, 64.3);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Loic Nottet', 'Million Eyes', 2017, 69.6);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Aram MP3', 'Not Alone', 2014, 44.8);

-- Genre
INSERT INTO TBL_SONG_GENRE (song_id, genre) VALUES (SELECT id FROM SONG WHERE title = 'Toy', 'EUROVISION');
INSERT INTO TBL_SONG_GENRE (song_id, genre) VALUES (SELECT id FROM SONG WHERE title = 'Amar Pelos Dois', 'EUROVISION');
INSERT INTO TBL_SONG_GENRE (song_id, genre) VALUES (SELECT id FROM SONG WHERE title = '1944', 'EUROVISION');
INSERT INTO TBL_SONG_GENRE (song_id, genre) VALUES (SELECT id FROM SONG WHERE title = 'Heroes', 'EUROVISION');
INSERT INTO TBL_SONG_GENRE (song_id, genre) VALUES (SELECT id FROM SONG WHERE title = 'Rise Like a Phoenix', 'EUROVISION');
INSERT INTO TBL_SONG_GENRE (song_id, genre) VALUES (SELECT id FROM SONG WHERE title = 'Only Teardrops', 'EUROVISION');
INSERT INTO TBL_SONG_GENRE (song_id, genre) VALUES (SELECT id FROM SONG WHERE title = 'Euphoria', 'EUROVISION');
INSERT INTO TBL_SONG_GENRE (song_id, genre) VALUES (SELECT id FROM SONG WHERE title = 'Running Scared', 'EUROVISION');
INSERT INTO TBL_SONG_GENRE (song_id, genre) VALUES (SELECT id FROM SONG WHERE title = 'Fairytale', 'EUROVISION');
INSERT INTO TBL_SONG_GENRE (song_id, genre) VALUES (SELECT id FROM SONG WHERE title = 'Believe', 'EUROVISION');
INSERT INTO TBL_SONG_GENRE (song_id, genre) VALUES (SELECT id FROM SONG WHERE title = 'Molidva', 'EUROVISION');
INSERT INTO TBL_SONG_GENRE (song_id, genre) VALUES (SELECT id FROM SONG WHERE title = 'Hard Rock Halluluja', 'EUROVISION');
INSERT INTO TBL_SONG_GENRE (song_id, genre) VALUES (SELECT id FROM SONG WHERE title = 'My Number One', 'EUROVISION');
INSERT INTO TBL_SONG_GENRE (song_id, genre) VALUES (SELECT id FROM SONG WHERE title = 'Wild Dances', 'EUROVISION');
INSERT INTO TBL_SONG_GENRE (song_id, genre) VALUES (SELECT id FROM SONG WHERE title = 'Everyway that I Can', 'EUROVISION');
INSERT INTO TBL_SONG_GENRE (song_id, genre) VALUES (SELECT id FROM SONG WHERE title = 'I Wanna', 'EUROVISION');
INSERT INTO TBL_SONG_GENRE (song_id, genre) VALUES (SELECT id FROM SONG WHERE artist = 'Tanel Padar & Dave Benton', 'EUROVISION');
INSERT INTO TBL_SONG_GENRE (song_id, genre) VALUES (SELECT id FROM SONG WHERE title = 'Fly on the Wings of Love', 'EUROVISION');
INSERT INTO TBL_SONG_GENRE (song_id, genre) VALUES (SELECT id FROM SONG WHERE title = 'Take Me to Heaven', 'EUROVISION');
INSERT INTO TBL_SONG_GENRE (song_id, genre) VALUES (SELECT id FROM SONG WHERE title = 'Love Shine a Light', 'EUROVISION');
INSERT INTO TBL_SONG_GENRE (song_id, genre) VALUES (SELECT id FROM SONG WHERE title = 'The Voice', 'EUROVISION');
INSERT INTO TBL_SONG_GENRE (song_id, genre) VALUES (SELECT id FROM SONG WHERE title = 'Diva', 'EUROVISION');
INSERT INTO TBL_SONG_GENRE (song_id, genre) VALUES (SELECT id FROM SONG WHERE title = 'Nocturne', 'EUROVISION');
INSERT INTO TBL_SONG_GENRE (song_id, genre) VALUES (SELECT id FROM SONG WHERE title = 'Rock n Roll Kids', 'EUROVISION');
INSERT INTO TBL_SONG_GENRE (song_id, genre) VALUES (SELECT id FROM SONG WHERE title = 'City Lights', 'EUROVISION');
INSERT INTO TBL_SONG_GENRE (song_id, genre) VALUES (SELECT id FROM SONG WHERE title = 'Million Eyes', 'EUROVISION');
INSERT INTO TBL_SONG_GENRE (song_id, genre) VALUES (SELECT id FROM SONG WHERE title = 'Not Alone', 'EUROVISION');