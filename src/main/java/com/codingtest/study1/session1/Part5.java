package com.codingtest.study1.session1;


import java.util.Scanner;

// 특정 문자 뒤집기
public class Part5 {
    /**
     * [설명]
     * 영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,
     * 특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.
     * <p>
     * [입력]
     * 첫 줄에 길이가 100을 넘지 않는 문자열이 주어집니다.
     * <p>
     * [출력]
     * 첫 줄에 알파벳만 뒤집힌 문자열을 출력합니다.
     *
     * @param args
     */
    public static void main(String[] args) {
        Part5 main = new Part5();
        Scanner in = new Scanner(System.in);
        String input1 = in.next();

        System.out.println(main.solution(input1));
    }

    public String solution(String input1) {
        String onlyAlphabet = input1.replaceAll("[^a-zA-z]", "");
        int i = onlyAlphabet.length();
        StringBuilder stringBuilder = new StringBuilder();

        for (char ch : input1.toCharArray()) {
            if (Character.isAlphabetic(ch)) {
                stringBuilder.append(onlyAlphabet.charAt(--i));
            } else {
                stringBuilder.append(ch);
            }
        }

        return stringBuilder.toString();
    }
}
