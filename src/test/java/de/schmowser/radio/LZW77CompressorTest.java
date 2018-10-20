package de.schmowser.radio;

import de.schmowser.radio.Utils.LZW77Compressor;
import de.schmowser.radio.Utils.LZWTriple;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LZW77CompressorTest {

    // TODO: Different dictionary and window sizes
    private LZW77Compressor lzw77Compressor_2000_250 = new LZW77Compressor(2000, 250);
    private LZW77Compressor lzw77Compressor_500_50 = new LZW77Compressor(500, 50);

    private String doc1 = "lzwlzxylzxxlzclzmwlzap";
    private String doc2 = "tobeornottobeortobeornot";
    private String doc3 = "happy birthday to you happy birthday to you happy birthday dear name happy birthday to you.";
    private String lyrics1 = "Any way you want it\n" +
            "That's the way you need it\n" +
            "Any way you want it\n" +
            "She loves to laugh\n" +
            "She loves to sing\n" +
            "She does everything\n" +
            "She loves to move\n" +
            "She loves to groove\n" +
            "She loves the lovin' things\n" +
            "Ooh, all night, all night\n" +
            "Oh, every night\n" +
            "So hold tight, hold tight\n" +
            "Ooh baby, hold tight\n" +
            "Oh, she said,\n" +
            "Any way you want it\n" +
            "That's the way you need it\n" +
            "Any way you want it\n" +
            "She said, any way you want it\n" +
            "That's the way you need it\n" +
            "Any way you want it\n" +
            "I was alone\n" +
            "I never knew\n" +
            "What good love could do\n" +
            "Ooh, then we touched\n" +
            "Then we sang\n" +
            "About the lovin' things\n" +
            "Ooh, all night, all night\n" +
            "Oh, every night\n" +
            "So hold tight, hold tight\n" +
            "Ooh baby, hold tight\n" +
            "Oh, she said,\n" +
            "Any way you want it\n" +
            "That's the way you need it\n" +
            "Any way you want it\n" +
            "I said, any way you want it\n" +
            "That's the way you need it\n" +
            "Any way you want it\n" +
            "She said ohh, hold on, hold on, hold on\n" +
            "Oh, she said any way you want it\n" +
            "That's the way you need it\n" +
            "Any way you want it\n" +
            "Any way you want it\n" +
            "That's the way you need it\n" +
            "Any way you want it\n" +
            "She said any way you want it\n" +
            "That's the way you need it\n" +
            "Any way you want it\n" +
            "Any way you want it\n" +
            "That's the way you need it\n" +
            "Any way you want it\n" +
            "Any way you want it\n" +
            "That's the way you need it\n" +
            "Any way you want it\n" +
            "Any way you want it\n" +
            "That's the way you need it\n" +
            "Any way you want it\n" +
            "Any way you want it\n" +
            "That's the way you need it\n" +
            "Any way you want it\n" +
            "Any way you want it\n" +
            "That's the way you need it\n" +
            "Any way you want it\n" +
            "Any way you want it\n" +
            "That's the way you need it\n" +
            "Any way you want it\n" +
            "Any way you want it\n" +
            "That's the way you need it";

    private String lyrics2 = "I remember when we broke up, the first time\n" +
            "Saying, this is it, I've had enough\n" +
            "'Cause like we hadn't seen each other in a month\n" +
            "When you, said you, needed space (what?)\n" +
            "Then you come around again and say\n" +
            "Baby, I miss you and I swear I'm gonna change, trust me\n" +
            "Remember how that lasted for a day?\n" +
            "I say, I hate you, we break up, you call me, I love you\n" +
            "Oh we called it off again last night\n" +
            "But oh, this time I'm telling you, I'm telling you\n" +
            "We are never ever, ever getting back together\n" +
            "We are never ever, ever getting back together\n" +
            "You go talk to your friends, talk to my friends, talk to me\n" +
            "But we are never ever, ever, ever getting back together\n" +
            "Like, ever\n" +
            "I'm really gonna miss you picking fights\n" +
            "And me, falling for it screaming that I'm right\n" +
            "And you, would hide away and find your peace of mind\n" +
            "With some indie record that's much cooler than mine\n" +
            "Oh, you called me up again tonight\n" +
            "But oh, this time I'm telling you, I'm telling you\n" +
            "We are never ever, ever getting back together\n" +
            "We! Are never ever, ever getting back together\n" +
            "You go talk to your friends, talk to my friends, talk to me (talk to me)\n" +
            "But, we are never ever, ever, ever getting back together\n" +
            "Oh yeah, oh yeah, oh yeah\n" +
            "Oh oh oh\n" +
            "I used to think that we were forever ever, ever\n" +
            "And I used to say, never say never\n" +
            "Huh, so he calls me up and he's like, I still love you\n" +
            "And I'm like I just I mean this is exhausting, you know, like\n" +
            "We are never getting back together like, ever\n" +
            "We are never ever, ever getting back together\n" +
            "We! Are never ever, ever getting back together\n" +
            "You go talk to your friends, talk to my friends, talk to me\n" +
            "But we are never ever ever ever getting back together\n" +
            "We, are not getting back together,\n" +
            "We oh, not getting back together\n" +
            "You go talk to your friends, talk to my friends, talk to me (talk to me)\n" +
            "But we are never ever, ever, ever getting back together";
    private String lyrics3 = "I'm pretty sure we almost broke up last night\n" +
            "I threw my phone across the room at you\n" +
            "I was expecting some dramatic turn-away\n" +
            "But you stayed\n" +
            "This morning I said we should talk about it\n" +
            "'Cause I read you should never leave a fight unresolved\n" +
            "That's when you came in wearing a football helmet and said \"okay, let's talk.\"\n" +
            "And I said,\n" +
            "Stay, stay, stay\n" +
            "I've been lovin' you for quite some time, time, time\n" +
            "You think that it's funny when I'm mad, mad, mad\n" +
            "But I think that it's best if we both stay\n" +
            "Before you, I'd only dated self-indulgent takers\n" +
            "That took all of their problems out on me\n" +
            "But you carry my groceries, and now I'm always laughin'\n" +
            "And I love you because you have given me no choice but to\n" +
            "Stay, stay, stay\n" +
            "I've been lovin' you for quite some time, time, time\n" +
            "You think that it's funny when I'm mad, mad, mad\n" +
            "But I think that it's best if we both stay, stay, stay, stay\n" +
            "You took the time to memorize me\n" +
            "My fears, my hopes, and dreams\n" +
            "I just like hangin' out with you, all the time\n" +
            "All those times that you didn't leave\n" +
            "It's been occurring to me I'd like to hang out with you, for my whole life\n" +
            "Stay, and I'll be loving you for quite some time\n" +
            "No one else is going to love me, when I get mad, mad mad\n" +
            "So I think that it's best if we both stay, stay, stay, stay, stay, stay\n" +
            "Stay, stay, stay\n" +
            "I've been lovin' you for quite some time, time, time\n" +
            "You think that it's funny when I'm mad, mad, mad\n" +
            "But I think that it's best if we both stay, stay, stay, stay, stay, stay\n" +
            "Stay, stay, stay\n" +
            "I've been lovin' you for quite some time, time, time\n" +
            "You think that it's funny when I'm mad, mad, mad\n" +
            "But I think that it's best if we both stay";
    private String alphabet = "abcdefghijklmnopqrst";

    @Test
    public void minimize_test_CamelCase() {

        String text1 = "CamelCase";
        String text2 = "I'm an übermenß!";

        assertEquals("camelcase", LZW77Compressor.minimize(text1));
        assertEquals("i'm an übermenß!", LZW77Compressor.minimize(text2));
    }

    @Test
    public void compress_document1_MustReturnCorrectCompressionRate() {

        List<LZWTriple> output = lzw77Compressor_500_50.compressEnglishDocument(doc1);
        assertEquals(10.0, lzw77Compressor_500_50.computeCompressionRate(doc1, output), 1.0);

    }

    @Test
    public void compress_document2_MustReturnCorrectCompressionRate() {

        List<LZWTriple> output = lzw77Compressor_2000_250.compressEnglishDocument(doc2);
        assertEquals(38.0, lzw77Compressor_2000_250.computeCompressionRate(doc2, output), 1.0);

    }

    @Test
    public void compress_document3_MustReturnCorrectCompressionRate() {

        List<LZWTriple> output = lzw77Compressor_2000_250.compressEnglishDocument(doc3);
        assertEquals(58.0, lzw77Compressor_2000_250.computeCompressionRate(doc3, output), 1.0);

    }

    @Test
    public void compress_AnywayYouWantIt() {

        String minLyrics = LZW77Compressor.minimize(lyrics1);
        List<LZWTriple> output = lzw77Compressor_2000_250.compressEnglishDocument(minLyrics);
        assertEquals(81.0, lzw77Compressor_2000_250.computeCompressionRate(minLyrics, output), 1.0);

    }

    @Test
    public void compress_alphabet(){

        List<LZWTriple> output = lzw77Compressor_2000_250.compressEnglishDocument(alphabet);
        assertEquals(0.0, lzw77Compressor_2000_250.computeCompressionRate(alphabet, output), 1.0);

    }

    @Test
    public void compress_decompress_MustReturnSameString_doc1() {

        List<LZWTriple> throughput = lzw77Compressor_2000_250.compressEnglishDocument(doc1);
        String output = lzw77Compressor_2000_250.decompressEnglishDocument(throughput);

        assertEquals(doc1, output);

    }

    @Test
    public void compress_decompress_MustReturnSameString_doc2() {

        List<LZWTriple> throughput = lzw77Compressor_2000_250.compressEnglishDocument(doc2);
        String output = lzw77Compressor_2000_250.decompressEnglishDocument(throughput);

        assertEquals(doc2, output);

    }

    @Test
    public void compress_decompress_MustReturnSameString_doc3() {

        List<LZWTriple> throughput = lzw77Compressor_2000_250.compressEnglishDocument(doc3);
        String output = lzw77Compressor_2000_250.decompressEnglishDocument(throughput);

        assertEquals(doc3, output);

    }

    @Test
    public void compress_decompress_2000_250_MustReturnSameString_lyrics() {

        String minLyrics = LZW77Compressor.minimize(lyrics1);
        List<LZWTriple> throughput = lzw77Compressor_2000_250.compressEnglishDocument(minLyrics);
        String output = lzw77Compressor_2000_250.decompressEnglishDocument(throughput);

        assertEquals(minLyrics, output);

    }

    @Test
    public void compress_decompress_MustReturnSameString_lyrics1() {

        String minLyrics = LZW77Compressor.minimize(lyrics1);
        List<LZWTriple> throughput = lzw77Compressor_500_50.compressEnglishDocument(minLyrics);
        String output = lzw77Compressor_500_50.decompressEnglishDocument(throughput);

        assertEquals(minLyrics, output);

    }

    @Test
    public void compress_decompress_MustReturnSameString_lyrics2() {

        String minLyrics = prepareLyrics(lyrics2);
        List<LZWTriple> throughput = lzw77Compressor_2000_250.compressEnglishDocument(minLyrics);
        System.out.print(lzw77Compressor_2000_250.computeCompressionRate(minLyrics, throughput));
        String output = lzw77Compressor_2000_250.decompressEnglishDocument(throughput);

        assertEquals(minLyrics, output);

    }

    @Test
    public void compress_decompress_MustReturnSameString_lyrics3() {

        String minLyrics = prepareLyrics(lyrics3);
        List<LZWTriple> throughput = lzw77Compressor_2000_250.compressEnglishDocument(minLyrics);
        System.out.print(lzw77Compressor_2000_250.computeCompressionRate(minLyrics, throughput));
        String output = lzw77Compressor_2000_250.decompressEnglishDocument(throughput);

        assertEquals(minLyrics, output);

    }

    private String prepareLyrics(String lyrics) {
        String resultString = LZW77Compressor.minimize(lyrics);
        return LZW77Compressor.removeLinebreaks(resultString);
    }

}
