package com.codingtest.livecoding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test2GPT {
    /**
     * 문자열 역정렬
     */
    public static void main(String[] args) {
        List<String> testCase = List.of("3", "banana", "apple", "cherry");
        List<String> answers = List.of("nnbaaa", "pplea", "yrrhec");

        int n = Integer.parseInt(testCase.get(0));
        String[] words = new String[n];

        for (int i = 1; i <= n; i++) {
            words[i - 1] = testCase.get(i);
            String solution = solution(words[i - 1]);
            System.out.println(solution + " " + (answers.get(i - 1).equals(solution) ? "true" : "false"));
        }
    }

    private static String solution(String word) {
        StringBuilder result = new StringBuilder();

        List<Character> charWords = new ArrayList<>();
        char[] chars = word.toCharArray();

        for (char ch : chars) {
            charWords.add(ch);
        }

        Collections.sort(charWords, (a, b) -> {
            return b - a;
        });

        for (char ch : charWords) {
            result.append(ch);
        }

        return result.toString();
    }
}
