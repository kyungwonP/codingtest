package com.codingtest.study2.problem1;

import java.util.Scanner;

public class Test11 {
    /**
     * 11. 문자열 압축
     * 설명
     * 알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는
     * 문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.
     * 단 반복횟수가 1인 경우 생략합니다.
     * <p>
     * 입력
     * 첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.
     * <p>
     * 출력
     * 첫 줄에 압축된 문자열을 출력한다.
     */

    public static void main(String[] args) {
        Test11 t = new Test11();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        System.out.println(t.solution(line));
    }

    private String solution(String line) {
        StringBuilder result = new StringBuilder();
        int count = 0;
        char prevSpell = line.charAt(0);

        for (char c : line.toCharArray()) {
            if (prevSpell == c) {
                count++;
            } else {
                result.append(prevSpell).append(count > 1 ? count : "");
                prevSpell = c;
                count = 1;
            }
        }

        result.append(prevSpell).append(count > 1 ? count : "");

        return result.toString();
    }
}
