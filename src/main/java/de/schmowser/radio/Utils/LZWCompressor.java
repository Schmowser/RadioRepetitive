package de.schmowser.radio.Utils;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class LZWCompressor {

    public LZWCompressor() {

    }

    public static String minimize(String text) {

        return text.toLowerCase();

    }

    private Set<String> initializeLetterDictionaryWithSpecialCharacters() {

        return new HashSet<>(Arrays.asList("a", "b", "c", "d", "e", "f",
                "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u",
                "v", "w", "x", "y", "z", " ", ".", ",", "!", "?"));

    }

    public Set<String> initializeEnglishDictionary() {

        Set<String> dic = initializeLetterDictionaryWithSpecialCharacters();
        dic.add("'");
        return dic;

    }

    public Set<String> initializeGermanDictionary() {

        Set<String> dic = initializeLetterDictionaryWithSpecialCharacters();
        dic.addAll(Arrays.asList("ä", "ö", "ü", "ß"));
        return dic;

    }

    public List<String> compressEnglishDocument(String document) {

        List<String> output = new ArrayList<>();
        String word = "";
        int i = 0;

//        I  : Initialize the dictionary to contain all strings of length one.

        Set<String> dictionary = initializeEnglishDictionary();

        while (i < document.length()) {

            // IV : Add W followed by the next symbol in the input to the dictionary.
            dictionary.add(word);
            word = "" + document.charAt(i);

            // II : Find the longest string W in the dictionary that matches the current input.
            while (dictionary.contains(word)) {

                try {
                    i++;
                    word = word + document.charAt(i);
                } catch (StringIndexOutOfBoundsException e) {
                    break;
                }

            }

            // III: Emit the dictionary index for W to output and remove W from the input.
            if (i == document.length()) {
                output.add(word);
            } else {
                output.add(word.substring(0, word.length() - 1));
            }

        }

        return output;

    }

    public float computeCompressionRate(String originalString, List<String> compressedStringList) {

        return compressedStringList.size() * 100 / originalString.length();

    }

}
