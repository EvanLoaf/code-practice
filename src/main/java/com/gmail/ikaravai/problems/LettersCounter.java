package com.gmail.ikaravai.problems;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LettersCounter {

    public Map<Character, Integer> countLetters(String input) {
        if (input == null || input.isEmpty()) {
            return Collections.emptyMap();
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c))
                map.merge(Character.toLowerCase(c), 1, Integer::sum);
        }
        return map;
    }
}
