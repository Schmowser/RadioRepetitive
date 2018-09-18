package de.schmowser.radio.domain;

import lombok.Data;

@Data
public class SongRequest {

    private String artist;

    private String title;

    private String lyrics;

}
