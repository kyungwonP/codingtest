package com.codingtest.study2.problem2;

import java.util.Scanner;

public class Test6GPT {
    /**
     * 6. 뒤집은 소수
     * 설명
     * N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력하는 프로그램을 작성하세요.
     * 예를 들어 32를 뒤집으면 23이고, 23은 소수이다. 그러면 23을 출력한다. 단 910를 뒤집으면 19로 숫자화 해야 한다.
     * 첫 자리부터의 연속된 0은 무시한다.
     * <p>
     * 입력
     * 첫 줄에 자연수의 개수 N(3<=N<=100)이 주어지고, 그 다음 줄에 N개의 자연수가 주어진다.
     * 각 자연수의 크기는 100,000를 넘지 않는다.
     * <p>
     * 출력
     * 첫 줄에 뒤집은 소수를 출력합니다. 출력순서는 입력된 순서대로 출력합니다.
     */
    public static void main(String[] args) {
        Test6GPT t = new Test6GPT();
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        in.nextLine();
        String line = in.nextLine();
        System.out.println(t.solution(count, line));
    }

    private String solution(int count, String line) {
        String[] numbers = line.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < count; i++) {
            int current = reverse(Integer.parseInt(numbers[i]));

            if (isPrime(current)) {
                result.append(current).append(" ");
            }
        }

        return result.toString().trim();
    }

    private int reverse(int current) {
        int result = 0;

        while (current > 0) {
            result = result * 10 + (current % 10);
            current /= 10;
        }

        return result;
    }

    private boolean isPrime(int current) {
        if (current < 2) {
            return false;
        }

        for (int i = 2; i * i <= current; i++) {
            if (current % i == 0) {
                return false;
            }
        }

        return true;
    }

}
