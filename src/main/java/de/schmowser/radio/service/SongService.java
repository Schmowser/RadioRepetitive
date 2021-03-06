package de.schmowser.radio.service;

import de.schmowser.radio.domain.Song;
import de.schmowser.radio.domain.SongRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SongService {

    @Autowired
    public SongService() {}

    public Song mapSongRequestToSong(SongRequest songRequest) {
        return Song.builder()
                .artist(songRequest.getArtist())
                .title(songRequest.getTitle())
                .build();
    }

}
