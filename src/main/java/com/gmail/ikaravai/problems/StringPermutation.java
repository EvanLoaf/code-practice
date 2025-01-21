package com.gmail.ikaravai.problems;

public class StringPermutation {

    public void permute(String input, String result) {
        // recursion stop processing tree branch is completed
        if (input.isEmpty()) {
            System.out.println(result);
            return;
        }

        for (int i = 0; i < input.length(); i++) {
            var currentCharacter = input.charAt(i);
            var remainder = input.substring(0, i) + input.substring(i + 1);
            // recursively splits the task to add all combinations of "suffixes" to the current locked "prefix" part
            this.permute(remainder, result + currentCharacter);
        }
    }
}
