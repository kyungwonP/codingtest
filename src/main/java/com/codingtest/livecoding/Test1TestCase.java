package com.codingtest.livecoding;

import java.util.List;

public class Test1TestCase {

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
        List<Integer> inputs = List.of(4, 10, 20, 30, 40);

        int n = inputs.get(0);
        int[] numbers = new int[n];
        for (int i = 1; i < inputs.size(); i++) {
            numbers[i - 1] = inputs.get(i);
        }

        System.out.println(solution(numbers));
    }

    private static long solution(int[] numbers) {
        long result = 0;

        for (int number : numbers) {
            result += number;
        }

        return result;
    }
}
