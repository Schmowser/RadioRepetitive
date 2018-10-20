package de.schmowser.radio;


import org.jmusixmatch.MusixMatch;
import org.jmusixmatch.MusixMatchException;
import org.jmusixmatch.entity.lyrics.Lyrics;
import org.jmusixmatch.entity.track.Track;
import org.jmusixmatch.entity.track.TrackData;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


// Be careful to run this test class too intensively. As we are handling copy-right
// material we use a third party API which copes with the legal work for us. MusixMatch
// provides a brilliantly simple API which returns meta data and lyrics on a vast varierty
// of songs. But therefore, we are currently only allowed to send 2k calls per day.
@Ignore
public class MusixMatchAPIWrapperIT {

    String apiKey = System.getProperty("musix.apikey");
    MusixMatch musixMatch = new MusixMatch(apiKey);

    final String artistName = "Taylor Swift";

    @Test
    public void searchForTrack_AllTooWell_TaylorSwift() throws MusixMatchException {

        String trackName = "All Too Well";

        // Track Search [ Fuzzy ]
        Track track = musixMatch.getMatchingTrack(trackName, artistName);
        TrackData data = track.getTrack();

        System.out.println("AlbumID : "    + data.getAlbumId());
        System.out.println("Album Name : " + data.getAlbumName());
        System.out.println("Artist ID : "  + data.getArtistId());
        System.out.println("Artist Name : " + data.getArtistName());
        System.out.println("Track ID : "   + data.getTrackId());

        assertEquals(trackName, data.getTrackName());
        assertEquals(artistName, data.getArtistName());
        assertEquals("Red", data.getAlbumName());

    }

    @Test
    public void getLyrics_AllTooWell_TaylorSwift() throws MusixMatchException {

        int trackID = 31300701;

        Lyrics lyrics = musixMatch.getLyrics(trackID);

        System.out.println("Lyrics Copyright : "    + lyrics.getLyricsCopyright());

        assertEquals("en", lyrics.getLyricsLang());
        assertTrue(lyrics.getLyricsBody().contains("I walked through the door with you"));

    }

}
