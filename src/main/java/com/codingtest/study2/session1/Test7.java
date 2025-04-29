package com.codingtest.study2.session1;

import java.util.Scanner;

public class Test7 {
    /**
     * 설명
     * 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 합니다.
     * 문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력하는 프로그램을 작성하세요.
     * 단 회문을 검사할 때 대소문자를 구분하지 않습니다.
     * <p>
     * 입력
     * 첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.
     * <p>
     * 출력
     * 첫 번째 줄에 회문 문자열인지의 결과를 YES 또는 NO로 출력합니다.
     */

    public static void main(String[] args) {
        Test7 t = new Test7();
        Scanner in = new Scanner(System.in);
        String line = in.next();
        System.out.println(t.solution(line));
    }

    private String solution(String line) {
        line = line.toLowerCase();
        char[] chars = line.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        String result = "YES";

        while (left < right) {
            if (chars[left] == chars[right]) {
                left++;
                right--;
            } else {
                result = "NO";
                break;
            }
        }

        return result;
    }
}
