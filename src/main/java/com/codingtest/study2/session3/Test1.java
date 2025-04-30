package com.codingtest.study2.session3;

import java.util.Scanner;

public class Test1 {
    /**
     * 1. 큰 수 출력하기
     * 설명
     * N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.
     * (첫 번째 수는 무조건 출력한다)
     * <p>
     * 입력
     * 첫 줄에 자연수 N(1<=N<=100)이 주어지고, 그 다음 줄에 N개의 정수가 입력된다.
     * <p>
     * 출력
     * 자신의 바로 앞 수보다 큰 수만 한 줄로 출력한다.
     */
    public static void main(String[] args) {
        Test1 t = new Test1();
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        in.nextLine();
        String line = in.nextLine();
        System.out.println(t.solution(count, line));
    }

    private String solution(int count, String line) {
        StringBuilder result = new StringBuilder();
        String[] numbers = line.split(" ");
        int prev = 0;

        for (int i = 0; i < count; i++) {
            int number = Integer.parseInt(numbers[i]);
            if (number > prev) {
                result.append(number).append(" ");
                prev = number;
            }
        }

        return result.toString().trim();
    }
}
