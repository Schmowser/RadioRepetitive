package de.schmowser.radio.controller;

import de.schmowser.radio.Utils.LZW77Compressor;
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
public class CompressorController {

    private SongRepository songRepository;

    private CompressionService compressionService;
    private SongService songService;

    @Autowired
    public CompressorController(SongRepository songRepository, CompressionService compressionService, SongService songService) {
        this.songRepository = songRepository;
        this.compressionService = compressionService;
        this.songService = songService;
    }

    @GetMapping("/songs/{artist}")
    @ResponseStatus(HttpStatus.OK)
    public List<Song> getByArtist(@PathVariable String artist) {
        return songRepository.findAllByArtist(artist);
    }

    @GetMapping("/songs/{artist}/{title}")
    @ResponseStatus(HttpStatus.OK)
    public List<Song> getByArtistAndTitle(@PathVariable String artist, @PathVariable String title) {
        String lowerCaseTitle = LZW77Compressor.minimize(title);
        return songRepository.findAllByArtistAndTitle(artist, lowerCaseTitle);
    }

    @GetMapping("/songs")
    @ResponseStatus(HttpStatus.OK)
    public List<Song> getByGenre(@RequestParam(value = "genre") Genre genre) {
        return songRepository.findAllByGenreIn(genre);
    }

    @PostMapping("/compress")
    @ResponseStatus(HttpStatus.OK)
    public float compress(@RequestBody String textToBeCompressed) {
        return compressionService.compressAndReturnRate(textToBeCompressed);
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



    @GetMapping("/error")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String pageNotFound() {
        return "Thanks for trying. But it seems like nothing's here!";
    }

}
