package de.schmowser.radio.controller;

import de.schmowser.radio.domain.Genre;
import de.schmowser.radio.domain.Song;
import de.schmowser.radio.domain.SongRepository;
import de.schmowser.radio.domain.SongRequest;
import de.schmowser.radio.service.CompressionService;
import de.schmowser.radio.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class SongController {

    private SongRepository songRepository;

    private CompressionService compressionService;
    private SongService songService;

    @Autowired
    public SongController(SongRepository songRepository, CompressionService compressionService, SongService songService) {
        this.songRepository = songRepository;
        this.compressionService = compressionService;
        this.songService = songService;
    }

    @GetMapping("/songs/{artist}")
    @ResponseStatus(HttpStatus.OK)
    public List<Song> getByArtist(@PathVariable String artist) {
        return songRepository.findAllByArtistOrderByYearAsc(artist);
    }

    @GetMapping("/songs/{artist}/{title}")
    @ResponseStatus(HttpStatus.OK)
    public List<Song> getByArtistAndTitle(@PathVariable String artist, @PathVariable String title) {
        return songRepository.findAllByArtistAndTitle(artist, title);
    }

    @GetMapping("/songs")
    @ResponseStatus(HttpStatus.OK)
    public List<Song> getByGenre(@RequestParam(value = "genre") Genre genre) {
        return songRepository.findAllByGenreIn(genre);
    }

    @GetMapping("/songs/period")
    @ResponseStatus(HttpStatus.OK)
    public List<Song> getByPeriod(@RequestParam(value = "startyear") int startYear, @RequestParam(value = "endyear") int endYear) {
        return songRepository.findAllByYearBetweenOrderByCompressionRateAsc(startYear, endYear);
    }

    @PostMapping("/songs/compress")
    @ResponseStatus(HttpStatus.CREATED)
    public Song compressAndSaveSong(@RequestBody SongRequest songToBeCompressed) {
        String lyrics = songToBeCompressed.getLyrics();
        float compressionRate = compressionService.compressAndReturnRate(lyrics);

        Song songToDatabase = songService.mapSongRequestToSong(songToBeCompressed);
        songToDatabase.setCompressionRate(compressionRate);

        songRepository.save(songToDatabase);

        return songToDatabase;
    }

    @GetMapping("/rates/{artist}/{title}")
    @ResponseStatus(HttpStatus.OK)
    public Double getRatesByArtistAndTitle(@PathVariable String artist, @PathVariable String title) {
        List<Song> songList = songRepository.findAllByArtistAndTitle(artist, title);
        Double rateSum = songList.stream().mapToDouble(Song::getCompressionRate).sum();
        return rateSum;
    }

    @GetMapping("/error")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String pageNotFound() {
        return "Thanks for trying. But it seems like nothing's here!";
    }

}

