package com.codingtest.study2.problem2;

import java.util.Scanner;

public class Test8 {
    /**
     * 8. 등수구하기
     * 설명
     * N명의 학생의 국어점수가 입력되면 각 학생의 등수를 입력된 순서대로 출력하는 프로그램을 작성하세요.
     * 같은 점수가 입력될 경우 높은 등수로 동일 처리한다.
     * 즉 가장 높은 점수가 92점인데 92점이 3명 존재하면 1등이 3명이고 그 다음 학생은 4등이 된다.
     * <p>
     * 입력
     * 첫 줄에 N(3<=N<=100)이 입력되고, 두 번째 줄에 국어점수를 의미하는 N개의 정수가 입력된다.
     * <p>
     * 출력
     * 입력된 순서대로 등수를 출력한다.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        in.nextLine();
        String line = in.nextLine();
        System.out.println(new Test8().solution(count, line));
    }

    private String solution(int count, String line) {
        StringBuilder result = new StringBuilder();
        String[] scores = line.split(" ");
        int[] grades = new int[count];

        for (int i = 0; i < count; i++) {
            int score = Integer.parseInt(scores[i]);

            grades[i] = 1;

            for (int j = 0; j < i; j++) {
                int prevScore = Integer.parseInt(scores[j]);
                if (score > prevScore) {
                    grades[j]++;
                } else {
                    grades[i]++;
                }
            }
        }

        for (int grade : grades) {
            result.append(grade).append(" ");
        }

        return result.toString().trim();
    }
}
