package com.codingtest.study2.session2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Test6 {
    /**
     * 설명
     * 소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요.
     * 중복이 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.
     * <p>
     * 입력
     * 첫 줄에 문자열이 입력됩니다. 문자열의 길이는 100을 넘지 않는다.
     * <p>
     * 출력
     * 첫 줄에 중복문자가 제거된 문자열을 출력합니다.
     */

    public static void main(String[] args) {
        Test6 t = new Test6();
        Scanner in = new Scanner(System.in);
        String line = in.next();
        System.out.println(t.solution(line));
    }

    private String solution(String line) {
        Set<Character> hashMap = new HashSet<>();
        StringBuilder result = new StringBuilder();
        for (char c : line.toCharArray()) {
            if (hashMap.add(c)) {
                result.append(c);
            }
        }
        return result.toString();
    }
}
