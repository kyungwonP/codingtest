package com.codingtest.study1.session1;


import java.util.Scanner;

// 대소문자 변환
public class Part2 {
    /**
     * [설명]
     * 대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로 변환하여 출력하는 프로그램을 작성하세요.
     * <p>
     * [입력]
     * 첫 줄에 문자열이 입력된다. 문자열의 길이는 100을 넘지 않습니다.
     * 문자열은 영어 알파벳으로만 구성되어 있습니다.
     * <p>
     * [출력]
     * 첫 줄에 대문자는 소문자로, 소문자는 대문자로 변환된 문자열을 출력합니다.
     *
     * @param args
     */
    public static void main(String[] args) {
        Part2 main = new Part2();
        Scanner in = new Scanner(System.in);
        String input1 = in.next();

        System.out.println(main.solution(input1));
    }

    public String solution(String input1) {
        StringBuilder sb = new StringBuilder();

        for (char x : input1.toCharArray()) {
            String str = Character.toString(x);
            if (Character.isUpperCase(x)) {
                sb.append(str.toLowerCase());
            } else {
                sb.append(str.toUpperCase());
            }
        }

        return sb.toString();
    }
}
