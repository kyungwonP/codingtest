package com.codingtest.livecoding;

import java.util.List;

public class Test1TestCaseGPT {

    /**
     * 4
     * 10 20 30 40 => 100
     * <p>
     * 5
     * 3 6 9 12 15 => 45
     * <p>
     * 3
     * 100 200 300 => 600
     */
    public static void main(String[] args) {
        List<List<Integer>> testCases = List.of(List.of(4, 10, 20, 30, 40), List.of(5, 3, 6, 9, 12, 15), List.of(3, 100, 200, 300));
        List<Long> answers = List.of(100L, 45L, 600L);

        for (int k = 0; k < testCases.size(); k++) {
            List<Integer> inputs = testCases.get(k);
            int n = inputs.get(0);
            int[] numbers = new int[n];
            for (int i = 1; i < inputs.size(); i++) {
                numbers[i - 1] = inputs.get(i);
            }

            long solution = solution(numbers);
            System.out.println(solution);
            System.out.println(solution == answers.get(k) ? "PASS" : "FAIL");
        }
    }

    private static long solution(int[] numbers) {
        long result = 0;

        for (int number : numbers) {
            result += number;
        }

        return result;
    }
}
