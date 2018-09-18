package de.schmowser.radio.service;

import de.schmowser.radio.domain.Song;
import de.schmowser.radio.domain.SongRequest;
import org.springframework.stereotype.Component;

@Component
public class SongService {

    public Song mapSongRequestToSong(SongRequest songRequest) {
        Song song = new Song();

        song.setTitle(songRequest.getTitle());
        song.setArtist(songRequest.getArtist());

        return song;
    }

}
