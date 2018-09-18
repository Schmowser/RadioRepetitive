package de.schmowser.radio.domain;

import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.util.Set;

@Data
@Table(name = "SONG")
@Entity
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String artist;

    private String title;

    private int year;

    @ElementCollection(targetClass = Genre.class)
    @CollectionTable(
            name = "TBL_SONG_GENRE",
            joinColumns = @JoinColumn(name = "SONG_ID")
    )
    @Column(name = "GENRE")
    @Enumerated(EnumType.STRING)
    protected Set<Genre> genre;

    @Column(name = "CompressionRate")
    @Nullable
    private Float compressionRate;

}
