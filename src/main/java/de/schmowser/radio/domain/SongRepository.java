package de.schmowser.radio.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {

    Optional<Song> findById(long id);

    List<Song> findAllByArtistOrderByYearAsc(String artist);

    List<Song> findAllByArtistAndTitle(String artist, String title);

    List<Song> findAllByGenreInOrderByYearAsc(Genre genre);

    List<Song> findAllByYearBetweenOrderByCompressionRateDesc(int startYear, int endYear);

    Song save(Song song);

}
