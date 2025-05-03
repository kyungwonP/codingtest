package com.codingtest.study2.problem1;

import java.util.Scanner;

public class Test10 {
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
        Test10 t = new Test10();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String spell = in.next();
        System.out.println(t.solution(line, spell));
    }

    private String solution(String line, String spell) {
        char[] chars = line.toCharArray();
        char charSpell = spell.charAt(0);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            if (c == charSpell) {
                result.append(0);
            } else {
                int left = i - 1;
                int right = i + 1;

                while (left > 0 || right < chars.length - 1) {
                    if (left >= 0 && chars[left] == charSpell) {
                        result.append(Math.abs(left - i));
                        break;
                    } else if (right <= chars.length - 1 && chars[right] == charSpell) {
                        result.append(Math.abs(right - i));
                        break;
                    } else {
                        left--;
                        right++;
                    }
                }

            }
            result.append(" ");
        }

        return result.toString().trim();
    }
}
