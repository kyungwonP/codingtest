package com.codingtest.study2.problem6;

import java.util.Scanner;

public class Test1GPT {
    /**
     * 1. 선택 정렬
     * 설명
     * N개이 숫자가 입력되면 오름차순으로 정렬하여 출력하는 프로그램을 작성하세요.
     * 정렬하는 방법은 선택정렬입니다.
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
        System.out.println(new Test1GPT().solution(n, line));
    }

    private String solution(int n, String line) {
        StringBuilder result = new StringBuilder();

        String[] strings = line.split(" ");
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(strings[i]);
        }

        for (int i = 0; i < n; i++) {
            int minIndex = i;

            for (int j = i; j < n; j++) {
                if (numbers[j] < numbers[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = numbers[i];
                numbers[i] = numbers[minIndex];
                numbers[minIndex] = temp;
            }
        }

        for (int num : numbers) {
            result.append(num).append(" ");
        }

        return result.toString().trim();
    }
}
