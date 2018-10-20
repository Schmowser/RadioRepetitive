-- Songs
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Survivor', 'Eye of the Tiger', 1982, 56.6);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Men at Work', 'Down Under', 1980, 62.1);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Eurythmics', 'Sweet Dreams', 1983, 79.9);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Michael Jackson', 'Beat It', 1982, 71.4);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Soft Cell', 'Tainted Love', 1981, 47.2);


INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Bonnie Tyler', 'Total Eclipse of the Heart', 1983, 65.9);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Wham!', 'Wake Me Up Before You Go-Go', 1984, 50.0);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('a-ha', 'Take On Me', 1985, 34.1);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Modern Talking', 'Youre My Heart, Youre My Soul', 1985, 71.3);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Guns n Roses', 'Sweet Child O Mine', 1987, 53.4);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Phil Collins', 'In the Air Tonight', 1981, 63.1);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Cyndi Lauper', 'Girls Just Want to Have Fun', 1983, 66.7);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('The Police', 'Every Breath You Take', 1996, 70.7);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('U2', 'With or Without You', 1996, 57.7);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('ABBA', 'Super Trouper', 1980, 66.8);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Van Halen', 'Jump', 1984, 50.9);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Whitney Houston', 'I Wanna Dance With Somebody', 1987, 68.3);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('The Bangles', 'Walk Like An Egyptian', 1986, 41.2);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Rick Astley', 'Never Gonna Give You Up', 1987, 72.0);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Michael Jackson', 'Billie Jean', 1982, 60.1);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Bon Jovi', 'Livin on a Prayer', 1986, 57.8);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Queen', 'Another One Bites the Dust', 1980, 57.2);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Cyndi Lauper', 'Time After Time', 1983, 58.5);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Dexys Midnight Runners', 'Come On Eileen', 1985, 53.0);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Falco', 'Rock Me Amadeus', 1997, 65.5);

INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Madonna', 'Like a Virgin', 1984, 45.7);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Taylor Dayne', 'Tell It To My Heart', 1988, 64.1);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Europe', 'The Final Countdown', 1986, 52.5);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Queen', 'Crazy Little Thing Called Love', 1980, 63.8);

INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Spider Murphy Gang', 'Skandal im Sperrbezirk', 1981, 61.8);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Pink Floyd', 'Another Brick in the Wall (Part I)', 1980, 26.4);

INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Roland Kaiser', 'Santa Maria', 1980, 56.6);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Verdammt, Ich Lieb Dich', 'Matthias Reim', 1990, 58.5);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Joachim Witt', 'Goldener Reiter', 1981, 55.3);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Lipps, Inc.', 'Funkytown', 1979, 78.6);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Trio', 'Da Da Da, Ich Lieb Dich Nicht Du Liebst Mich Nicht Aha Aha Aha', 1982, 35.4);

INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Boney M.', 'Rivers of Babylon', 1978, 60.9);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('Udo Jürgens', 'Griechischer Wein', 1974, 42.8);
INSERT INTO SONG (artist, title, year, compression_rate) VALUES ('The Beatles', 'Her Majesty', 1969, 35.4);

-- Genre
INSERT INTO TBL_SONG_GENRE (song_id, genre) VALUES (SELECT id FROM SONG WHERE title = 'Another Brick in the Wall (Part I)', 'ROCK');
INSERT INTO TBL_SONG_GENRE (song_id, genre) VALUES (SELECT id FROM SONG WHERE title = 'Sweet Dreams', 'ELECTRO');
INSERT INTO TBL_SONG_GENRE (song_id, genre) VALUES (SELECT id FROM SONG WHERE title = 'Tainted Love', 'ELECTRO');
INSERT INTO TBL_SONG_GENRE (song_id, genre) VALUES (SELECT id FROM SONG WHERE title = 'Rivers of Babylon', 'DISCO');
INSERT INTO TBL_SONG_GENRE (song_id, genre) VALUES (SELECT id FROM SONG WHERE title = 'Funkytown', 'DISCO');

INSERT INTO TBL_SONG_GENRE (song_id, genre)
    SELECT DISTINCT id, 'DEUTSCH'
    FROM SONG
    WHERE artist = 'Udo Jürgens'
    OR artist = 'Joachim Witt'
    OR artist = 'Trio'
    OR artist = 'Spider Murphy Gang'
    OR artist = 'Matthias Reim'
    OR artist = 'Roland Kaiser'
    OR artist = 'Falco';

INSERT INTO TBL_SONG_GENRE (song_id, genre)
    SELECT DISTINCT id, 'POP'
    FROM SONG
    WHERE artist = 'Men at Work'
    OR artist = 'Madonna'
    OR artist = 'Wham!'
    OR artist = 'a-ha'
    OR artist = 'Modern Talking'
    OR artist = 'Phil Collins'
    OR artist = 'Cyndi Lauper'
    OR artist = 'Dexys Midnight Runners'
    OR artist = 'Taylor Dayne'
    OR artist = 'Queen'
    OR artist = 'The Beatles';

INSERT INTO TBL_SONG_GENRE (song_id, genre)
    SELECT DISTINCT id, 'ROCK'
    FROM SONG
    WHERE artist = 'Europe'
    OR artist = 'Bonnie Tyler'
    OR artist = 'Guns n Roses';