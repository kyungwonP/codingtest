package com.codingtest.study2.problem1;

import java.util.Scanner;

public class Test2 {
    /***
     * 설명
     * 대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로 변환하여 출력하는 프로그램을 작성하세요.
     *
     * 입력
     * 첫 줄에 문자열이 입력된다. 문자열의 길이는 100을 넘지 않습니다.
     * 문자열은 영어 알파벳으로만 구성되어 있습니다.
     *
     * 출력
     * 첫 줄에 대문자는 소문자로, 소문자는 대문자로 변환된 문자열을 출력합니다.
     */

    public static void main(String str[]) {
        Test2 t = new Test2();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        System.out.println(t.solution(line));
    }

    private String solution(String line) {
        char[] chars = line.toCharArray();
        StringBuilder result = new StringBuilder();

        for (char c : chars) {
            if (Character.isUpperCase(c)) {
                result.append(Character.toLowerCase(c));
            } else {
                result.append(Character.toUpperCase(c));
            }
        }

        return result.toString();
    }

    private String solution2(String line) {
        StringBuilder result = new StringBuilder();

        for (char c : line.toCharArray()) {
            result.append(Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c));
        }

        return result.toString();
    }
}
