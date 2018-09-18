package de.schmowser.radio.Utils;

import lombok.Data;

@Data
public class LZWTriple {

    private int invertedIndexOfOccurrence;
    private int lengthOfWord;
    private char nextCharacter;

    public LZWTriple(int i, int l, char c) {
        invertedIndexOfOccurrence = i;
        lengthOfWord = l;
        nextCharacter = c;
    }

    @Override
    public String toString() {
        return "(" + invertedIndexOfOccurrence + ", " + lengthOfWord + ", " + nextCharacter + ")";
    }

}
