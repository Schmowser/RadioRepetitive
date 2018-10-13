package de.schmowser.radio.service;

import de.schmowser.radio.Utils.LZW77Compressor;
import de.schmowser.radio.Utils.LZWTriple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompressionService {

    private LZW77Compressor lzw77Compressor;

    @Autowired
    public CompressionService() {
        this.lzw77Compressor = new LZW77Compressor(5000, 500);
    }

    public float compressAndReturnRate(String textToBeCompressed) {
        List<LZWTriple> output = lzw77Compressor.compressEnglishDocument(textToBeCompressed);
        return lzw77Compressor.computeCompressionRate(textToBeCompressed, output);
    }

}