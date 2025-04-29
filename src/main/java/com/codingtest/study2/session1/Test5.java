package com.codingtest.study2.session1;

import java.util.Scanner;

public class Test5 {
    /**
     * 5. 특정 문자 뒤집기
     * 설명
     * 영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,
     * 특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.
     * <p>
     * 입력
     * 첫 줄에 길이가 100을 넘지 않는 문자열이 주어집니다.
     * <p>
     * 출력
     * 첫 줄에 알파벳만 뒤집힌 문자열을 출력합니다.
     */

    public static void main(String[] args) {
        Test5 t = new Test5();
        Scanner in = new Scanner(System.in);
        String word = in.next();
        System.out.println(t.solution(word));
    }

    private String solution(String word) {
        StringBuilder result = new StringBuilder();
        char[] chars = word.toCharArray();

        int leftIndex = 0;
        int rightIndex = word.length() - 1;

        for (char c : chars) {
            if (Character.isAlphabetic(c)) {
                for (int i = rightIndex; i >= 0; i--) {
                    if (Character.isAlphabetic(chars[i])) {
                        rightIndex = i;
                        break;
                    }
                }
                result.append(chars[rightIndex--]);
                leftIndex++;
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}
