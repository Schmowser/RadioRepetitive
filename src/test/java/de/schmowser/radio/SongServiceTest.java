package de.schmowser.radio;

import de.schmowser.radio.domain.Genre;
import de.schmowser.radio.domain.Song;
import de.schmowser.radio.domain.SongRequest;
import de.schmowser.radio.service.SongService;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;

public class SongServiceTest {

    private SongService songService;

    private Song song;
    private SongRequest songRequest;

    @Before
    public void setUp() {

        songService = new SongService();

        song = Song.builder()
                .id(1L)
                .artist("Taylor Swift")
                .title("Shake It Off")
                .year(2014)
                .genre(new HashSet<>(Collections.singletonList(Genre.POP)))
                .build();

        songRequest = SongRequest.builder()
                .artist("Taylor Swift")
                .title("Shake It Off")
                .lyrics("...")
                .build();
    }

    @Test
    public void test_mapSongRequestToSong() {

        Song testSong = songService.mapSongRequestToSong(songRequest);

        assertEquals(testSong.getArtist(), song.getArtist());
        assertEquals(testSong.getTitle(), song.getTitle());

    }

}
