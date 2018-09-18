package de.schmowser.radio.Utils;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class LZW77Compressor {

    private int dictionaryLength;
    private int windowLength;

    public LZW77Compressor() {
        dictionaryLength = 8;
        windowLength = 4;
    }

    public LZW77Compressor(int d, int w) {
        dictionaryLength = d;
        windowLength = w;
    }

    public static String minimize(String text) { return text.toLowerCase(); }

    public static String removeLinebreaks(String text) { return text.replace("\n", ""); }

    public List<LZWTriple> compressEnglishDocument(String document) {

        List<LZWTriple> output = new ArrayList<>();
        String dictionary = "";
        List<Character> window = new ArrayList<>(); // TODO: Implement as a Queue
        int indexOfNextCharForWindow = 0;

        // Fill window with first characters of document
        for (int i = 0; i < windowLength; i++) {
            try {
                window.add(document.charAt(i));
                indexOfNextCharForWindow++;
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }

        // while input is not empty do
        while (!window.isEmpty()) {

            LZWTriple triple;

            // prefix := longest prefix of input that begins in window
            String prefix = window.stream()
                                .map(String::valueOf)
                                .collect(Collectors.joining());

            // i := 0, l := 0, c := first char of input
            int i = 0;
            int l = 0;
            char c = prefix.charAt(0);

            while (prefix.length() > 1) {

                int indexOfOccurrence = dictionary.indexOf(prefix);

                if (indexOfOccurrence < 0) {
                    prefix = prefix.substring(0, prefix.length() - 1);
                }
                else {
                    // i := distance to start of prefix, l := length of prefix, c := char following prefix in input
                    i = getInvertedIndexFromIndexOfOccurrence(dictionary, indexOfOccurrence);
                    l = prefix.length();
                    int indexOfNextCharacter = indexOfNextCharForWindow - window.size() + l;
                    // @ denotes END of document
                    c = indexOfNextCharacter < document.length() ? document.charAt(indexOfNextCharacter) : '@';
                    break;
                }
            }

            // Output (i, l ,c)
            triple = new LZWTriple(i, l, c);
            output.add(triple);

            // s := pop l+1 chars from front of input
            // discard l+1 chars from front of window
            // append s to back of window
            for (int j = 0; j < l + 1; j++) {
                if (window.size() > 0) {
                    dictionary = dictionary + window.get(0);
                    if (dictionary.length() > dictionaryLength) {
                        dictionary = dictionary.substring(1);
                    }
                    window.remove(0);
                    try {
                        window.add(document.charAt(indexOfNextCharForWindow));
                        indexOfNextCharForWindow++;
                    } catch (IndexOutOfBoundsException e) {

                    }
                }
            }

        }

        return output;


    }

    public float computeCompressionRate(String originalString, List<LZWTriple> lzwTripleList) {

        int originalSize = originalString.length();
        int compressedSize = 0;
        for (LZWTriple triple : lzwTripleList) {
            int lengthOfWord = triple.getLengthOfWord();
            if (lengthOfWord == 0) {
                compressedSize++;
            } else {
                compressedSize = compressedSize + 3;
            }
        }

        return (float) compressedSize * 100 / originalSize;

    }

    public String decompressEnglishDocument(List<LZWTriple> tripleList) {

        StringBuilder recoveredString = new StringBuilder();
        String dictionary = "";

        for (LZWTriple triple : tripleList) {

            if (triple.getLengthOfWord() != 0) {
                int startingIndex = getIndexOfOccurrenceFromInvertedIndex(dictionary,
                        triple.getInvertedIndexOfOccurrence());
                int lengthOfCodeword = triple.getLengthOfWord();
                String substringToAdd = dictionary.substring(startingIndex, startingIndex + lengthOfCodeword);
                dictionary = dictionary + substringToAdd;
                if (dictionary.length() > dictionaryLength) {
                    dictionary = dictionary.substring(substringToAdd.length());
                }
                recoveredString.append(substringToAdd);
            }

            if (triple.getNextCharacter() != '@') {
                dictionary = dictionary + triple.getNextCharacter();
                if (dictionary.length() > dictionaryLength) {
                    dictionary = dictionary.substring(1);
                }
                recoveredString.append(triple.getNextCharacter());
            }
        }

        return recoveredString.toString();
    }

    private int getIndexOfOccurrenceFromInvertedIndex(String window, int invertedIndex) { return window.length() - invertedIndex - 1; }

    private int getInvertedIndexFromIndexOfOccurrence(String window, int index) {
        return window.length() - index - 1;
    }
}
