package com.codingtest.study2.problem10;

import java.util.Scanner;

public class Test2GPT {
    /**
     * 2. 돌다리 건너기
     * 설명
     * 철수는 학교에 가는데 개울을 만났습니다. 개울은 N개의 돌로 다리를 만들어 놓았습니다.
     * 철수는 돌 다리를 건널 때 한 번에 한 칸 또는 두 칸씩 건너뛰면서 돌다리를 건널 수 있습니다.
     * 철수가 개울을 건너는 방법은 몇 가지일까요?
     * <p>
     * 입력
     * 첫째 줄은 돌의 개수인 자연수 N(3≤N≤35)이 주어집니다.
     * <p>
     * 출력
     * 첫 번째 줄에 개울을 건너는 방법의 수를 출력합니다.
     */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(new Test2GPT().solution(n));
    }

    private int solution(int n) {
        int[] rocks = new int[n + 2];
        rocks[1] = 1;
        rocks[2] = 2;

        for (int i = 3; i <= n + 1; i++) {
            rocks[i] = rocks[i - 2] + rocks[i - 1];
        }

        return rocks[n + 1];
    }
}
