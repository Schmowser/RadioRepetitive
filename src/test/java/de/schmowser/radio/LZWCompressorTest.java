package de.schmowser.radio;

import de.schmowser.radio.Utils.LZWCompressor;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LZWCompressorTest {

    private LZWCompressor lzwCompressor = new LZWCompressor();

    private String doc1 = "lzwlzxylzxxlzclzmwlzap";
    private String doc2 = "tobeornottobeortobeornot";

    @Test
    public void minimize_test_CamelCase() {

        String text1 = "CamelCase";
        String text2 = "I'm an übermenß!";

        assertEquals("camelcase", LZWCompressor.minimize(text1));
        assertEquals("i'm an übermenß!", LZWCompressor.minimize(text2));
    }

    @Test
    public void compress_document1() {

        List<String> output = lzwCompressor.compressEnglishDocument(doc1);
        assertEquals(72.0, lzwCompressor.computeCompressionRate(doc1, output), 0.0);

    }

    @Test
    public void compress_document2() {

        List<String> output = lzwCompressor.compressEnglishDocument(doc2);
        assertEquals(66.0, lzwCompressor.computeCompressionRate(doc2, output), 0.0);

    }



}
