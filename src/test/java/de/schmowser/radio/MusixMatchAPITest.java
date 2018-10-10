package de.schmowser.radio;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jmusixmatch.MusixMatch;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


// Be careful to run this test class too intensively. As we are handling copy-right
// material we use a third party API which copes with the legal work for us. MusixMatch
// provides a brilliantly simple API which returns meta data and lyrics on a vast variety
// of songs. But therefore, we are currently only allowed to send 2k calls per day.
public class MusixMatchAPITest {

    final String url = "https://api.musixmatch.com/ws/1.1/";

    String apiKey = System.getProperty("musix.apikey");
    MusixMatch musixMatch = new MusixMatch(apiKey);

    private RestTemplate restTemplate;
    private ObjectMapper mapper = new ObjectMapper();

    final String artistName = "Taylor Swift";

    @Before
    public void setUp() {
        restTemplate = new RestTemplate();
    }

    @Test
    public void getAlbumById_Red_TaylorSwift() throws IOException {

        String getAlbumByIdString = "album.tracks.get";

        long albumId = 14260680;
        String format = "json";
        String callback = "jsonp";
        int f_has_lyrics = 1;

        ResponseEntity<String> response = restTemplate.getForEntity(url + getAlbumByIdString
                + "?format=" + format
                + "&callback=" + callback
                + "&f_has_lyrics=" + f_has_lyrics
                + "&album_id=" + albumId
                + "&apikey=" + apiKey, String.class);

        JsonNode root = mapper.readTree(response.getBody());
        JsonNode trackListNode = root.path("message").path("body").path("track_list");

        for (JsonNode node : trackListNode) {
            System.out.println(node.path("track").get("track_name"));
        }

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @Test
    public void searchArtist_TaylorSwift() throws IOException {

        String searchArtistByName = "artist.search";

        String format = "json";
        String callback = "jsonp";

        ResponseEntity<String> response = restTemplate.getForEntity(url + searchArtistByName
                + "?format=" + format
                + "&callback=" + callback
                + "&q_artist=" + artistName
                + "&apikey=" + apiKey, String.class);

        JsonNode root = mapper.readTree(response.getBody());
        JsonNode artistListNode = root.path("message").path("body").path("artist_list");

        System.out.println("Artist Name: " + artistListNode.get(0).get("artist").get("artist_name"));
        System.out.println("Artist Id: " + artistListNode.get(0).get("artist").get("artist_id"));

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));

    }

}
