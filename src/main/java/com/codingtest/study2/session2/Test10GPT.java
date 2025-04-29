package com.codingtest.study2.session2;

import java.util.Scanner;

public class Test10GPT {
    /**
     * 10. 가장 짧은 문자거리
     * 설명
     * 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.
     * <p>
     * 입력
     * 첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.
     * 문자열의 길이는 100을 넘지 않는다.
     * <p>
     * 출력
     * 첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.
     */

    public static void main(String[] args) {
        Test10GPT t = new Test10GPT();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String spell = in.next();
        System.out.println(t.solution(line, spell));
    }

    private String solution(String line, String spell) {
        StringBuilder result = new StringBuilder();
        int[] answer = new int[line.length()];
        int tempIndex = 1000;

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == spell.charAt(0)) {
                tempIndex = 0;
            } else {
                tempIndex++;
            }
            answer[i] = tempIndex;
        }

        for (int i = line.length() - 1; i >= 0; i--) {
            if (line.charAt(i) == spell.charAt(0)) {
                tempIndex = 0;
            } else {
                tempIndex++;
                answer[i] = Math.min(answer[i], tempIndex);
            }
        }

        for (int i : answer) {
            result.append(i).append(" ");
        }

        return result.toString().trim();
    }
}
