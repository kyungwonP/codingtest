package com.codingtest.study2.problem2;

import java.util.Scanner;

public class Test4GPT {
    /**
     * 2. 보이는 학생
     * 설명
     * 선생님이 N명의 학생을 일렬로 세웠습니다. 일렬로 서 있는 학생의 키가 앞에서부터 순서대로 주어질 때, 맨 앞에 서 있는
     * 선생님이 볼 수 있는 학생의 수를 구하는 프로그램을 작성하세요. (앞에 서 있는 사람들보다 크면 보이고, 작거나 같으면 보이지 않습니다.)
     * <p>
     * 입력
     * 첫 줄에 정수 N(5<=N<=100,000)이 입력된다. 그 다음줄에 N명의 학생의 키가 앞에서부터 순서대로 주어진다.
     * <p>
     * 출력
     * 선생님이 볼 수 있는 최대학생수를 출력한다.
     */
    public static void main(String[] args) {
        Test4GPT t = new Test4GPT();
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        System.out.println(t.solution(number));
    }

    private String solution(int number) {
        StringBuilder result = new StringBuilder();
        int a = 1, b = 1;

        result.append(a).append(" ").append(b).append(" ");

        for (int i = 2; i < number; i++) {
            int c = a + b;
            result.append(c).append(" ");
            a = b;
            b = c;
        }

        return result.toString().trim();
    }
}
