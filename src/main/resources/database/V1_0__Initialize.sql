CREATE TABLE SONG (
    id SERIAL PRIMARY KEY,
    Artist varchar (255) NOT NULL,
    Title varchar (255) NOT NULL,
    Year INTEGER,
    Compression_Rate FLOAT
);

CREATE TABLE TBL_SONG_GENRE (
    song_id INTEGER NOT NULL,
--    genre_id INTEGER not null, -- the ordinal number of enum value
    Genre varchar (255) NOT NULL,
    primary key (SONG_ID, GENRE)
)
