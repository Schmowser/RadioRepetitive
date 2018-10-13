package de.schmowser.radio;

import de.schmowser.radio.controller.CompressorController;
import de.schmowser.radio.domain.Genre;
import de.schmowser.radio.domain.Song;
import de.schmowser.radio.domain.SongRepository;
import de.schmowser.radio.service.CompressionService;
import de.schmowser.radio.service.SongService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CompressorController.class)
public class CompressorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SongRepository songRepository;

    @MockBean
    private SongService songService;

    @MockBean
    private CompressionService compressionService;

    private Song song1;
    private Song song2;
    private Song song3;

    @Before
    public void setUp() {

        song1 = Song.builder()
                .id(1L)
                .artist("Taylor Swift")
                .title("Shake It Off")
                .year(2014)
                .genre(new HashSet<>(Collections.singletonList(Genre.POP)))
                .build();

        song2 = Song.builder()
                .id(2L)
                .artist("Taylor Swift")
                .title("You Belong With Me")
                .year(2008)
                .genre(new HashSet<>(Arrays.asList(Genre.POP, Genre.COUNTRY)))
                .build();

        song3 = Song.builder()
                .id(3L)
                .artist("Daft Punk")
                .title("Around the World")
                .year(1997)
                .genre(new HashSet<>(Collections.singletonList(Genre.HOUSE)))
                .build();

    }

    @Test
    public void getByArtist_shouldReturnOk() throws Exception {

        // Arrange
        when(songRepository.findAllByArtist("Taylor Swift")).thenReturn(Arrays.asList(song1, song2));

        // Act
        ResultActions result = mockMvc.perform(get("/songs/Taylor Swift"));

        // Assert
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].artist", is("Taylor Swift")))
                .andExpect(jsonPath("$[1].artist", is("Taylor Swift")));

    }

    @Test
    public void getByGenre_shouldReturnOk() throws Exception {

        // Arrange
        when(songRepository.findAllByGenreIn(Genre.POP)).thenReturn(Arrays.asList(song1, song2));

        // Act
        ResultActions result = mockMvc.perform(get("/songs")
                .param("genre", "POP"));

        // Assert
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].genre", contains("POP")))
                /*.andExpect(jsonPath("$[1].genre", is("POP")))*/;

    }

}
