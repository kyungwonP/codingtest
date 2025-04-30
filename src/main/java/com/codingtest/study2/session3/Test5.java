package com.codingtest.study2.session3;

import java.util.Scanner;

public class Test5 {
    /**
     * 5. 소수(에라토스테네스 체)
     * 설명
     * 자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.
     * 만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.
     * <p>
     * 입력
     * 첫 줄에 자연수의 개수 N(2<=N<=200,000)이 주어집니다.
     * <p>
     * 출력
     * 첫 줄에 소수의 개수를 출력합니다.
     */
    public static void main(String[] args) {
        Test5 t = new Test5();
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        System.out.println(t.solution(number));
    }

    private int solution(int number) {
        int result = 2;

        for (int i = 4; i <= number; i++) {
            if (i % 2 != 0 && i % 3 != 0) {
                result++;
            }
        }

        return result;
    }
}
