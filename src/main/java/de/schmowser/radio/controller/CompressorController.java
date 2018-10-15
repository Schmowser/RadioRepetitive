package de.schmowser.radio.controller;

import de.schmowser.radio.service.CompressionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class CompressorController {

    private CompressionService compressionService;

    @Autowired
    public CompressorController(CompressionService compressionService) {
        this.compressionService = compressionService;
    }

    @PostMapping("/compress")
    @ResponseStatus(HttpStatus.OK)
    public float compress(@RequestBody String textToBeCompressed) {
        return compressionService.compressAndReturnRate(textToBeCompressed);
    }

}
