package de.schmowser.radio.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SongRequest {

    private String artist;

    private String title;

    private String lyrics;

}
