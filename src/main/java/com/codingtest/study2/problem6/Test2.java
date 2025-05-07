package com.codingtest.study2.problem6;

import java.util.Scanner;

public class Test2 {
    /**
     * 2. 버블 정렬
     * 설명
     * N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
     * 정렬하는 방법은 버블정렬입니다.
     * <p>
     * 입력
     * 첫 번째 줄에 자연수 N(1<=N<=100)이 주어집니다.
     * 두 번째 줄에 N개의 자연수가 공백을 사이에 두고 입력됩니다. 각 자연수는 정수형 범위 안에 있습니다.
     * <p>
     * 출력
     * 오름차순으로 정렬된 수열을 출력합니다.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String line = in.nextLine();
        System.out.println(new Test2().solution(n, line));
    }

    private String solution(int n, String line) {
        StringBuilder result = new StringBuilder();
        String[] strings = line.split(" ");
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(strings[i]);
        }

        for (int i = n - 1; i > 0; i--) {
            for (int j = 1; j < n; j++) {
                if (numbers[j - 1] > numbers[j]) {
                    int temp = numbers[j - 1];
                    numbers[j - 1] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }

        for (int number : numbers) {
            result.append(number).append(" ");
        }

        return result.toString().trim();
    }
}
